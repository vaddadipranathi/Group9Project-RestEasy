package com.hcl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.AddressDTO;
import com.hcl.entity.Address;
import com.hcl.entity.Customer;
import com.hcl.entity.OrderDetails;
import com.hcl.services.ICustomerServices;
import com.hcl.services.OrderServiceImpl;
import com.hcl.token.ITokenGenerator;

import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServices;

	@Autowired
	ITokenGenerator tokenGenrator;

	@Autowired
	private ICustomerServices customerServices;

	// Method to add order details
	@PostMapping("/addOrderDetails")
	public ResponseEntity<Boolean> addOrderDetails(@RequestBody AddressDTO addressDto, HttpServletRequest request) {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setTotalprice(addressDto.getTotalprice());
		orderDetails.setTotalquantity(addressDto.getTotalquantity());
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		System.out.println(token);
		String email = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody().getSubject();

		Address address = new Address();
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		address.setState(addressDto.getState());
		address.setZipcode(addressDto.getZipcode());
		address.setStreet(addressDto.getStreet());
		Customer customer = customerServices.getByEmailId(email);
		orderDetails.setCustomer(customer);
		orderDetails.setAddress(address);
		return new ResponseEntity<Boolean>(orderServices.addOrderDetails(orderDetails), HttpStatus.OK);

	}

}
