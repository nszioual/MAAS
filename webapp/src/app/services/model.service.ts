import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

const baseUrl = 'http://localhost:8887/models';

@Injectable({
  providedIn: 'root',
})
export class ModelService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(baseUrl);
  }

  getAllPageAble(offset, limit): Observable<any> {
    return this.http.get(`${baseUrl}?offset=${offset}&limit=${limit}`);
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

  findByNamePageAble(name, offset, limit): Observable<any> {
    return this.http.get(`${baseUrl}?name=${name}&offset=${offset}&=limit=${limit}`);
  }

  downloadVersion(id): Observable<any> {
    return this.http.get(`${baseUrl}/${id}/download`, { responseType: 'blob' });
  }
}
