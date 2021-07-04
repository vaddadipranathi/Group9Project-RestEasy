import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { Login } from 'src/app/model/login';
import { CredentialsService } from 'src/app/services/credentials.service';
import { MenuService } from 'src/app/services/menu.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userEmail: string = "";
  total_price: number = 0;
  total_quantity: number = 0;
  foodName: string = "";
  dish: Array<any> = [];
  responseMessage: string = "";
  customer: Customer = new Customer();
  totalCost1: number = 0;
  totalQuantity: number = 0;
  search: any;
  isToken: boolean = false;


  constructor(private menuService: MenuService,
    public credentialService: CredentialsService, private router: Router, private builder: FormBuilder) { }

  ngOnInit(): void {
    this.buildForm();
  }
  buildForm() {
    this.search = this.builder.group({
      foodName: ['', Validators.required]
    })
  }


  login2: Login = new Login();

  //Method to get customer email
  getCustomerEmail() {
    this.userEmail = this.credentialService.customerEmail
    console.log("customerEmail ", this.credentialService.customerEmail)
  }

  //Method to search food based on food Name
  searchFood(name: string) {
    this.menuService.getFoodByName(name).subscribe((data) => {
      this.menuService.b = true;
      this.menuService.foodArray = data;

      this.router.navigateByUrl("/searchPage")
    },
      e => {
        alert("Food Item Not Present")
        this.router.navigateByUrl("/Adigas")
        this.responseMessage = e.error.message;
        console.log(e);

      })
  }


  //Method to know token is present or no
  isTokenPresent(): any {
    if (this.credentialService.getToken() != null) {
      return this.isToken = true;
    }
    return false;
  }

  //Method to remove token when user logs out
  LogOut() {

    this.credentialService.removeToken();
    this.router.navigateByUrl("/Adigas")
  }

  //Method to redirect to cart
  redirectCart() {
    this.router.navigateByUrl("/cart")
  }


}
