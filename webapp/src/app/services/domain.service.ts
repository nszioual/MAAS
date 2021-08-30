import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8887/domains';

@Injectable({
  providedIn: 'root'
})
export class DomainService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }

  getAllPageable(page): Observable<any> {
    return this.http.get(`${baseUrl}?p=${page}`);
  }

  get(id): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data): Observable<any> {
    return this.http.post(`${baseUrl}`, data);
  }

  update(id, data): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`, { responseType: 'text' });
  }

  findByName(name): Observable<any> {
    return this.http.get(`${baseUrl}?name=${name}`);
  }

  findByNamePageable(name, page): Observable<any> {
    return this.http.get(`${baseUrl}?name=${name}&p=${page}`);
  }
}