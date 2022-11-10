package com.ilkerbas.spring.homework.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.homework.Customer;
import com.ilkerbas.spring.homework.service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerResource {
	
	@Autowired
	private ICustomerService customerService;

	// get a customer
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable("id") long customerId) {
		
		Customer customer = customerService.findById(customerId);
		return customer;
	}
	
	// get all customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		List<Customer> customers = customerService.findAll();
		
		return customers;
	}
	
	// post a customer
	@PostMapping("/customers")
	public Customer postCustomer(@RequestBody Customer customer) {
		
		customer.setCustomerId(1001);
		customerService.createCustomer(customer);
		
		return customer;
		
	}
	
	// update a customer
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
	
	// delete a customer
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable long customerId) {
		customerService.deleteCustomer(customerId);
	}
}
