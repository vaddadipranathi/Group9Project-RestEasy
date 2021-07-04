import { Component, OnInit } from '@angular/core';
import { Search } from 'src/app/model/search';
import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';

@Component({
  selector: 'app-food-category',
  templateUrl: './food-category.component.html',
  styleUrls: ['./food-category.component.css']
})
export class FoodCategoryComponent implements OnInit {
  constructor(private service: MenuService, private loginService: CredentialsService, private cartService: CartService) { }

  ngOnInit(): void {
    this.getFoodByCategory();
  }
  cartId: number = 0;
  foodType: string = "";
  categroyFoods: Array<any> = [];
  isToken: boolean = false;
  //Method to  get menu list based on food category
  getFoodByCategory() {
    this.foodType = this.service.foodType
    this.categroyFoods = this.service.categroyFoods;
  }

  isAdded(menu: Search) {
    return menu.foodId === this.cartId;
  }


  //Method to know token is present
  isTokenPresent(): any {
    if (this.loginService.getToken() != null) {
      return this.isToken = true;
    }
    return false;
  }

  //Method to add food items into cart
  addToCart(menu1: Search) {

    this.cartId = menu1.foodId

    this.cartService.addCart(menu1).subscribe(
      (data: any) => {

        console.log(data);
      },
      (error: any) => console.log(error)
    );
  }
}
