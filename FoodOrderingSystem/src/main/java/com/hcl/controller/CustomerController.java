package com.hcl.controller;

import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Customer;
import com.hcl.services.ICustomerServices;
import com.hcl.token.ITokenGenerator;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
@Validated
public class CustomerController {
	@Autowired
	private ICustomerServices customerServices;

	@Autowired
	ITokenGenerator tokenGenrator;

	// Method to get Customer Details
	@GetMapping("/getCustomerDetails/{email}")
	public ResponseEntity<Customer> getCustomerOnEmail(@PathVariable String email) {
		return new ResponseEntity<Customer>(customerServices.getByEmailId(email), HttpStatus.OK);
	}

	// Method to add customer details
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		System.out.println(customer);
		return new ResponseEntity<Customer>(customerServices.addCustomer(customer), HttpStatus.OK);
	}

	// Method to get customer credentials
	@GetMapping("/getCredentails/{email}/{password}")
	public ResponseEntity<?> getCredentials(@PathVariable String email, @PathVariable String password) {

		System.out.println(email + "" + password);

		Customer c = customerServices.getEmailAndPassword(email, password);
		System.out.println(c);
		if (c != null) {
			Map<String, String> map = tokenGenrator.generateToken(c);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Email and Password is incorrect", HttpStatus.NOT_FOUND);
	}

}
