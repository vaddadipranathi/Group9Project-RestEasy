import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Search } from '../model/search';
import { CredentialsService } from './credentials.service';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  totalPrice: number = 0;
  totalQuantity: number = 0;
  private baseUrl = 'http://localhost:8082/api/v2/';
  bearerToken: string = "";
  cartArray: Array<Search> = [];
  constructor(private http: HttpClient, private credentialService: CredentialsService) {
    this.getTokenMeth();
  }
  getTokenMeth() {
    this.bearerToken = this.credentialService.getToken();
    console.log("cartservice Token" + this.bearerToken)
  }

  //Method to create cart for customer
  addCart(cart: any): Observable<any> {
    this.getTokenMeth();
    return this.http.post<any>(`${this.baseUrl}addCart`, cart,
      {
        headers: new HttpHeaders().set('Authorization',
          `Bearer ${this.bearerToken}`)
      });
  }
  //Method to get food items present in cart
  getItems(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}getCart`);
  }
  //Method to  delete a food item from cart based on foodId
  deleteItem(foodId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${foodId}`);
  }
  //Method to empty the cart
  cartClearItems() {
    return this.http.delete<any>(`${this.baseUrl}deleteCartItems`);
  }

}
