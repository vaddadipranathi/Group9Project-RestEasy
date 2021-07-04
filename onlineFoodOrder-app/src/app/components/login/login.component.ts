import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/login';
import { CredentialsService } from 'src/app/services/credentials.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private service: CredentialsService) { }
  login2: Login = new Login();
  userDetails: Login = new Login();
  ngOnInit(): void {
  }
  customerEmail: string = "";
  model: any = {}

  //Method to login into application
  login(email: string, password: string) {
    this.service.getLoginCredentails(email, password).subscribe(data => {
      this.service.customerEmail = this.customerEmail;
      this.service.setToken(data.token);
      this.service.submitted = true;
      this.router.navigateByUrl("/Adigas")
    },
      e => {
        console.log(e)
        alert("Please enter correct credentials")
      }
    )
  }


}
