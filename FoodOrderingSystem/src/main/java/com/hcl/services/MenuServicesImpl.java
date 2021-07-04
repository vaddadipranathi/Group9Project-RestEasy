package com.hcl.services;

import com.hcl.entity.Cart;
import com.hcl.entity.Menu;
import com.hcl.exception.UserDefinedException;
import com.hcl.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServicesImpl implements IMenuServices {
	@Autowired
	private IMenuDAO menuDao;
	@Autowired
	private ICartDAO cartDao;

	// Method to get restuarent details by restuarentId
	@Override
	public List<Menu> getdetailsByRestuarant(int rid) {
		return menuDao.findByRestuarant(rid);
	}

	// Method to get food details by restuarentId
	@Override
	public List<Menu> getFoodByName(String foodName) throws UserDefinedException {

		if (!menuDao.findByFoodName(foodName).isEmpty()) {
			return menuDao.findByFoodName(foodName);
		} else
			throw new UserDefinedException("FoodItem Not Present");
	}

	// Method to create cart for customer
	@Override
	public Cart addCart(Cart cart) {
		return cartDao.saveAndFlush(cart);
	}

	// Method to get food details based on food category
	@Override
	public List<Menu> getFoodByCategory(String foodCategory) {

		return menuDao.findByFoodCategory(foodCategory);
	}
}
