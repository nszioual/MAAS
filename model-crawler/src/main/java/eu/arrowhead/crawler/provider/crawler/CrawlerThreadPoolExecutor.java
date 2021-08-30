package eu.arrowhead.crawler.provider.crawler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class CrawlerThreadPoolExecutor extends ThreadPoolExecutor {

    private final AtomicLong lastExecutionTimeNano = new AtomicLong(System.nanoTime());

    public CrawlerThreadPoolExecutor(int availableProcessors) {
        super(availableProcessors, availableProcessors, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long currentSysNano = System.nanoTime();
        while (true) {
            long time = lastExecutionTimeNano.get();
            if (currentSysNano < time) break;
            if (lastExecutionTimeNano.compareAndSet(time, currentSysNano)) {
                break;
            }
        }
        super.afterExecute(r, t);
    }

    public long getLastExecutionTimeNano() {
        return lastExecutionTimeNano.get();
    }
}

