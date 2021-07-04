import { Component, OnInit } from '@angular/core';
import { Search } from 'src/app/model/search';

import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  subtotal1: number = 0;
  totalqty: number = 0;
  subtotal: number = 0;
  cartEmptyMsg: string = "";
  isDisplay: boolean = false;
  quantity: number = 1;

  constructor(private menuService: MenuService,
    private cartService: CartService, public loginService: CredentialsService) { }

  cartArray: Array<any> = [];
  ngOnInit(): void {
    this.cartItemsDisplay()
  }

  sum: number = 0;
  isToken: boolean = false;
  items: Search[] = [];
  count: number = 0;

  //Method to display all food items in cart
  cartItemsDisplay() {
    this.cartService.getItems().subscribe((item) => {
      this.items = item;
      for (let i of this.items) {
        this.subtotal = i.quantity * i.foodPrice;
        this.sum = this.sum + this.subtotal;
        this.count = this.items.length;
        this.totalqty = this.count;
        localStorage.setItem('price', JSON.stringify(this.sum));
        localStorage.setItem('count', JSON.stringify(this.items.length));

      }
      if (item.length >= 1) {
        console.log("Inside for lopp of the if ")
        console.log("before", this.isDisplay)
        this.isDisplay = true;
        console.log(this.isDisplay)
      }

    },
      e => {
        console.log(e);
      });
    this.totalqty = JSON.parse(localStorage.getItem('count') || '{}');
  }

  //Method to remove food item from cart based on food Id
  removeCartItem(foodId: number) {
    this.cartService.deleteItem(foodId).subscribe(
      (data) => {
      },
      (error) => {
        this.cartItemsDisplay();
        console.log(error)
      }
    );
  }

  //Method to incresase quantity
  plus(item: any) {
    if (item.quantity != 10) {
      item.quantity += 1;
      this.subtotal1 = 1 * item.foodPrice;
      this.sum = this.sum + this.subtotal1;
      console.log(this.sum);
      this.totalqty += 1;
      console.log(this.totalqty);
    }
  }

  //Method to decrease quantity
  minus(item: any) {
    if (item.quantity != 1) {
      item.quantity -= 1;
      this.subtotal = -1 * item.foodPrice;
      this.sum = this.sum + this.subtotal;
      console.log(this.sum);
      this.totalqty -= 1;
    }
  }


  //Method to  know token is present or no
  isTokenPresent(): any {
    if (this.loginService.getToken() != null) {
      return this.isToken = true;
    }
    return false;
  }

  sendQuantityPrice() {
    this.menuService.totalprice = this.sum;
    this.menuService.totalquantity = this.totalqty
  }
}