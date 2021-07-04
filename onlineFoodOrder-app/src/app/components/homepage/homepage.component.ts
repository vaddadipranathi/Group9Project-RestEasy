
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';
import { Search } from 'src/app/model/search';
import { CartService } from 'src/app/services/cart.service';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';
import images from '../../model/images';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  menu: Array<Search> = [];
  categroyFoods: Array<Search> = [];
  decision: string = '';
  name: string = "";
  display: Array<images> = [];
  cartArray: Array<Search> = [];
  result: boolean = false;
  cartId: number = 0;
  resultofCart: boolean = false;
  isToken: boolean = false;
  total: number = 0;
  quantity: number = 0;
  constructor(private router: ActivatedRoute, private service: MenuService, private cartService: CartService
    , private loginService: CredentialsService, private r: Router) { }

  ngOnInit(): void {
    this.iterateroute();
  }

  //Method to get menu list 
  getMenu(name: string) {
    this.service.getMenuList(name).subscribe((data) => {
      this.menu = data;
      console.log(this.menu);
    },
      e => {
        console.log(e);
      }
    )
  }

  iterateroute() {
    this.router.url.subscribe((url: UrlSegment[]) => {
      this.decision = url[0].path.toString();
      this.getMenu(this.decision);
    });
  }



  //Method to add food item into cart
  addToCart(menu1: Search) {
    this.cartId = menu1.foodId
    this.cartService.addCart(menu1).subscribe(
      (data) => {

        console.log(data);
      },
      (error) => console.log(error)
    );
  }


  isAdded(menu: Search) {
    return menu.foodId === this.cartId;
  }

  isTokenPresent(): any {
    if (this.loginService.getToken() != null) {
      return this.isToken = true;
    }
    return false;
  }

  getFoobyCategoryVeg() {
    this.service.getFoodByCategory("veg").subscribe(data => {
      this.r.navigateByUrl("/foodCategory")
      this.service.foodType = "Veg";
      this.categroyFoods = data;
      this.service.categroyFoods = data;
      console.log(this.categroyFoods)
    })
  }
  getFoobyCategoryNonVeg() {
    this.service.getFoodByCategory("non-veg").subscribe(data => {
      this.r.navigateByUrl("/foodCategory")
      this.service.foodType = "Non-Veg";
      this.categroyFoods = data;
      this.service.categroyFoods = data;
      console.log(this.categroyFoods)
    })
  }
}
