package com.ilkerbas.spring.homework.service;

import java.util.List;

import com.ilkerbas.spring.homework.Customer;

// Customer Service interface
public interface ICustomerService {

	// methods
	// find customer by using given id
	Customer findById(long customerId);
	
	// find all customers
	List<Customer> findAll();
	
	// create a customer
	void createCustomer(Customer customer);
	
	// update a customer
	void updateCustomer(Customer customer);
	
	// delete a customer
	void deleteCustomer(long customerId);
}
