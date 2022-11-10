package com.ilkerbas.spring.homework.client;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ilkerbas.spring.homework.Customer;

// Customer MVC Web Client
@Controller
@RequestMapping("/client")
public class CustomerController {

	// get a customer by id
	@GetMapping("/customers/get/{id}")
	@ResponseBody
	public String getCustomer(@PathVariable("id") long customerId) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/customers/" + customerId;
		Customer customer = restTemplate.getForObject(url, Customer.class);
		
		return "Client get customer is successfull " + "customer: " + customer.getCustomerName();
		
	}
	
	// get all customers
	@GetMapping("/customers/get")
	@ResponseBody
	public String getCustomers() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/customers";
		ArrayList<Customer> customers = restTemplate.getForObject(url, ArrayList.class);
		
		return "Client get all customer is successfull " + "customers: " + customers.toString();
		
	}
	
	// update customer
	@GetMapping("/customers/update")
	@ResponseBody
	public String updateCustomer() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/customers";
		Customer updatedCustomer = new Customer(1001, "İlker Baş", 500);
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(updatedCustomer), Void.class);
		
		return "Client update customer is successfull " + "updated customer: " + updatedCustomer.getCustomerName();
		
	}
	
	// delete customer
	@GetMapping("/customers/delete/{id}")
	@ResponseBody
	public String deleteCustomer(@PathVariable("id") long customerId) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/customers/" + customerId;
		restTemplate.delete(url);
		
		return "Client delete customer is successfull " + "deleted customer id: " + customerId;
		
	}
	
	// add customer, post
	@GetMapping("/customers/post")
	@ResponseBody
	public String postCustomer() {
		
		Customer customer = new Customer(1033, "Emre Erden", 1489);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/customers";
		
		Customer postedCustomer = restTemplate.postForObject(url, customer, Customer.class);
		
		return "Client post customer is successfull " + "posted customer: " + customer.getCustomerName();
		
	}
}
