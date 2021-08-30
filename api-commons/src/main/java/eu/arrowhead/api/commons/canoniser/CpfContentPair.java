package eu.arrowhead.api.commons.canoniser;

import org.apromore.cpf.CanonicalProcessType;

public class CpfContentPair {

    private CanonicalProcessType cpf;
    private String content;

    public CpfContentPair() {}

    public CpfContentPair(CanonicalProcessType cpf, String content) {
        this.cpf = cpf;
        this.content = content;
    }

    public CanonicalProcessType getCpf() {
        return cpf;
    }

    public String getContent() {
        return content;
    }
}