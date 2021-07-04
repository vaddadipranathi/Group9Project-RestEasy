import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Address } from '../model/address';
import { CredentialsService } from './credentials.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseUrl = 'http://localhost:8082/api/v2/';
  bearerToken: any;
  constructor(private http: HttpClient, private service: CredentialsService) { this.getTokenMeth() }

  //Method to  get token genrated
  getTokenMeth() {
    this.bearerToken = this.service.getToken();
    console.log("cartservice Token" + this.bearerToken)
  }

  //Method to add order details
  addOrderDetails(orders: Address): Observable<any> {
    this.getTokenMeth();
    return this.http.post<any>(`${this.baseUrl}addOrderDetails`, orders,
      {
        headers: new HttpHeaders().set('Authorization',
          `Bearer ${this.bearerToken}`)
      });
  }
}
