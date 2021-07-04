package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hcl.entity.Menu;
import com.hcl.entity.ResponseMessage;
import com.hcl.exception.UserDefinedException;
import com.hcl.services.IMenuServices;
import com.hcl.services.IRestuarantServices;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class FoodController {
	@Autowired
	private IRestuarantServices resturaentServices;
	@Autowired
	private IMenuServices menuServices;

	// Method to get menu list based in restuarant
	@GetMapping("/restuarantName/{rname}")
	public ResponseEntity<?> displayRestuarants(@PathVariable String rname) {
		System.out.println(rname);
		List<Menu> mList = resturaentServices.getResturant(rname);
		System.out.println(mList);
		if (mList != null) {
			return new ResponseEntity<List<Menu>>(mList, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Restuarant Not Found", HttpStatus.NOT_FOUND);
	}

	// Method to search food based on food name
	@GetMapping("/searchByFood/{name}")
	public ResponseEntity<List<Menu>> searchByResName(@PathVariable String name) throws UserDefinedException {
		System.out.println("search Name" + name);
		return new ResponseEntity<List<Menu>>(menuServices.getFoodByName(name), HttpStatus.OK);
	}

	public ResponseEntity<ResponseMessage> handleGlobalException(HttpServletRequest request, Exception ex) {
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm, HttpStatus.NOT_FOUND);
	}

	// Method to get food items based on food category
	@GetMapping("/getFoodByCategory/{foodCategory}")
	public ResponseEntity<List<Menu>> getFoodDetailsCategory(@PathVariable String foodCategory) {
		return new ResponseEntity<List<Menu>>(menuServices.getFoodByCategory(foodCategory), HttpStatus.OK);

	}

}
