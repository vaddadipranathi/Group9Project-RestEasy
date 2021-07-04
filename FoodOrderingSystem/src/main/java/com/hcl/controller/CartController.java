package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Cart;
import com.hcl.entity.Customer;
import com.hcl.services.ICartServices;
import com.hcl.services.ICustomerServices;
import com.hcl.services.IMenuServices;
import com.hcl.token.ITokenGenerator;

import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")

public class CartController {
	@Autowired
	private IMenuServices menuServices;
	@Autowired
	private ICartServices cartServices;
	@Autowired
	ITokenGenerator tokenGenerator;

	@Autowired
	private ICustomerServices customerServices;

	// Method to create cart for customer
	@PostMapping("/addCart")
	public ResponseEntity<Cart> saveCart(@Valid @RequestBody Cart cart, HttpServletRequest request) {
		final String authHeader = request.getHeader("authorization");

		System.out.println(authHeader);
		final String token = authHeader.substring(7);
		System.out.println(token);
		String email = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody().getSubject();
		System.out.println(email + "email customer");
		Customer customer = customerServices.getByEmailId(email);
		System.out.println(customer + "Customer object..");
		cart.setCustomer(customer);
		System.out.println(cart);
		return new ResponseEntity<Cart>(menuServices.addCart(cart), HttpStatus.OK);
	}

	// Method to get all the cart items
	@GetMapping(value = "/getCart")
	public ResponseEntity<List<Cart>> getAllItems() {
		List<Cart> items = new ArrayList<Cart>();
		try {
			items = cartServices.getItems();

			if (items.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Method to delete food item
	@DeleteMapping("/delete/{foodId}")
	public ResponseEntity<String> delete(@PathVariable("foodId") int foodId) {
		cartServices.deleteItem(foodId);
		System.out.println("delete");
		return new ResponseEntity<String>("Deleted successfully.!", HttpStatus.OK);
	}

	// Method to delete all food items in cart
	@DeleteMapping("/deleteCartItems")
	public ResponseEntity<Boolean> deleteCartItemss() {
		return new ResponseEntity<Boolean>(cartServices.deleteCartItems(), HttpStatus.OK);
	}

}
