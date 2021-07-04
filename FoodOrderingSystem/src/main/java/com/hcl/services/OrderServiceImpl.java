package com.hcl.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.OrderDetails;
import com.hcl.repository.IOrderDAO;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderDAO orderDao;

	// Method to add order details
	@Override
	@Transactional
	public boolean addOrderDetails(OrderDetails order) {
		OrderDetails o = orderDao.save(order);
		System.out.println("My service : " + o);
		return true;
	}

}
