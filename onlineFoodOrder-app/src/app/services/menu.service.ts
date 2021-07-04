import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Search } from '../model/search';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  private baseUrl = 'http://localhost:8082/api/v2';
  constructor(private http: HttpClient) { }
  totalprice: number = 0;
  foodType: string = "";
  totalquantity: number = 0;
  b: boolean = false;
  categroyFoods: Array<Search> = [];
  foodArray: Array<Search> = [];

  //Method to  get menu list based on restuarent name
  getMenuList(rname: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/restuarantName/${rname}`)
  }

  //Method to get food details based on name
  getFoodByName(foodName: any): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/searchByFood/${foodName}`)
  }

  //Method to menu list based on food category
  getFoodByCategory(foodCategory: any): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getFoodByCategory/${foodCategory}`)
  }


}
