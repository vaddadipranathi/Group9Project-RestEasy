package com.hcl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.Cart;
import com.hcl.repository.ICartDAO;

@Service
public class CartServicesImpl implements ICartServices {
	@Autowired
	ICartDAO cartDao;

	@Override
	public Cart addCart(Cart cart) {
		return cartDao.saveAndFlush(cart);
	}

	@Override
	public List<Cart> getItems() {
		return cartDao.findAll();
	}

	@Override
	public void deleteItem(int foodId) {
		cartDao.deleteById(foodId);
	}

	@Override
	public boolean deleteCartItems() {
		cartDao.deleteAll();
		return true;

	}
}