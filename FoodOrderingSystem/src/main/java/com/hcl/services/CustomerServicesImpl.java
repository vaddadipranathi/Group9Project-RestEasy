package com.hcl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.Customer;
import com.hcl.repository.ICustomerDAO;

@Service
public class CustomerServicesImpl implements ICustomerServices {
	@Autowired
	private ICustomerDAO customerDao;

	// Method to add customer customer details
	@Override
	public Customer addCustomer(Customer customer) {

		return customerDao.saveAndFlush(customer);
	}

	// Method to get customer email and password
	@Override
	public Customer getEmailAndPassword(String email, String password) {
		return customerDao.findByEmailAndPassword(email, password);
	}

	// Method to get email id based on customer email
	@Override
	public Customer getByEmailId(String email) {
		return customerDao.findByEmail(email);
	}

	// Method to get customer details based on customer Id
	@Override
	public Customer getById(int customerId) {
		return customerDao.findById(customerId).get();
	}

}
