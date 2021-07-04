package com.hcl.services;

import java.util.List;

import com.hcl.entity.Cart;
import com.hcl.entity.Menu;
import com.hcl.exception.UserDefinedException;

public interface IMenuServices {
	List<Menu> getdetailsByRestuarant(int rid);

	List<Menu> getFoodByName(String foodName) throws UserDefinedException;

	Cart addCart(Cart cart);

	List<Menu> getFoodByCategory(String foodCategory);
}
