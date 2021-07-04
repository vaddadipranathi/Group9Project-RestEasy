import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CredentialsService } from 'src/app/services/credentials.service';

function passwordsMatchValidator(form: any) {
  const password = form.get('password')
  const confirmPassword = form.get('confirmPassword')

  if (password.value !== confirmPassword.value) {
    confirmPassword.setErrors({ passwordsMatch: true })
  } else {
    confirmPassword.setErrors(null)
  }

  return null
}


function symbolValidator(control: any) {
  if (control.hasError('required')) return null;
  if (control.hasError('minlength')) return null;

  if (control.value.indexOf('@') > -1) {
    return null
  } else {
    return { symbol: true }
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  [x: string]: any;
  customer: Customer = new Customer();

  constructor(private builder: FormBuilder, private router: Router, private service: CredentialsService) { }

  ngOnInit() {
    this.buildForm()
  }

  buildForm() {
    this.registerForm = this.builder.group({
      firstName: ['', [Validators.required, Validators.minLength(2)]],
      lastName: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, symbolValidator, Validators.minLength(6), Validators.maxLength(15)]],
      confirmPassword: ''
    }, {
      validators: passwordsMatchValidator
    })
  }

  //Method to add customer 
  register() {
    this.service.addCustomer(this.customer).subscribe(data => {
      this.service.submitted = true;
      console.log(data);
      this.router.navigateByUrl("/login")
    },
      e => {
        alert("Email Alredy exsists");
        console.log(e);
      }
    )
  }



}