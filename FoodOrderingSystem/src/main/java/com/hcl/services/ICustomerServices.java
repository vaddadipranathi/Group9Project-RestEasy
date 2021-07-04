package com.hcl.services;

import com.hcl.entity.Customer;

public interface ICustomerServices {
	Customer addCustomer(Customer customer);

	Customer getEmailAndPassword(String email, String password);

	Customer getByEmailId(String email);

	Customer getById(int customerId);

}
