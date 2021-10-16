import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8888/crawler';

@Injectable({
  providedIn: 'root'
})
export class CrawlerService {

  constructor(private http: HttpClient) {}

  startCrawler(format): Observable<any> {
    return this.http.get(`${baseUrl}?format=${format}`);
  }

  startCrawlerWithOptions(options): Observable<any> {
    return this.http.post(`${baseUrl}`, options);
  }

  stopCrawler(): Observable<any> {
    return this.http.get(`${baseUrl}/stop`);
  }
}
