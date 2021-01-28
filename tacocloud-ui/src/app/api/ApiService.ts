import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class ApiService {

  constructor(private httpClient: HttpClient) {
  }

  get(path: string): Observable<object> {
    return this.httpClient.get('http://localhost:8080' + path);
  }

}
