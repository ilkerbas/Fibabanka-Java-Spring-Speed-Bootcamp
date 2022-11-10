package com.ilkerbas.spring.homework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ilkerbas.spring.homework.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Override
	public Customer findById(long customerId) {
		
		Customer customer = new Customer(customerId, "Can Ata", 10250);
		System.out.println("Inside -> findById:CustomerService");
		System.out.println("Given customer id: " + customerId);
		
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		
		List<Customer> customers = new ArrayList<>();
		
		customers.add(new Customer(1000, "İlker Baş", 14000));
		customers.add(new Customer(1000, "Efe Kabakaş", 11230));
		customers.add(new Customer(1000, "Gizem Kaya", 9860));
		customers.add(new Customer(1000, "Ayşe Çetin", 100));
		
		System.out.println("Inside -> findAll:CustomerService");
		
		return customers;
	}

	@Override
	public void createCustomer(Customer customer) {
		System.out.println("Given customer: "
				+ "id: " + customer.getCustomerId() 
				+ "name: " + customer.getCustomerName()
				+ "debt: " + customer.getTotalDebt());
		System.out.println("Customer is created!");
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Customer is updated: "
				+ "id: " + customer.getCustomerId() 
				+ "name: " + customer.getCustomerName()
				+ "debt: " + customer.getTotalDebt());
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Customer is deleted: " + customerId);
	}

}
