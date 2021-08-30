import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8889/filter';

@Injectable({
  providedIn: 'root'
})
export class FilterService {
  constructor(private http: HttpClient) {}

  search(searchData): Observable<any> {
    return this.http.post(`${baseUrl}`, searchData);
  }

  download(target): Observable<any> {
    return this.http.get(`${baseUrl}/download-bundle?target=${target}`, { responseType: 'blob' });
  }
}
