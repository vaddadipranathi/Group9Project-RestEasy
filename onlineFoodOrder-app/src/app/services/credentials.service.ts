import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CredentialsService {
  private baseUrl = 'http://localhost:8082/api/v2/';
  customer: string = "";
  constructor(private http: HttpClient) { }
  submitted: boolean = false;
  customerEmail: string = "";

  addCustomer(customer: any): Observable<object> {
    return this.http.post<object>(`${this.baseUrl}addCustomer`, customer);
  }


  isUserLoggedIn() {
    let cust = sessionStorage.getItem('customerName');
    this.customer = cust || '{}';
    return !(cust === null);
  }

  //Method to get token genrated
  getToken(): any {
    return localStorage.getItem("authToken");
  }

  setToken(token: string): void {
    localStorage.setItem("authToken", token);
  }

  //Method to  remove token
  removeToken(): void {
    localStorage.removeItem('authToken');
  }

  //Method to  get cutomer details based on email
  getCustomerDetails(email: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}getCustomerDetails/${email}`);
  }

  //Method to get login credentials
  getLoginCredentails(email: string, password: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}getCredentails/${email}/${password}`,);
  }
}
