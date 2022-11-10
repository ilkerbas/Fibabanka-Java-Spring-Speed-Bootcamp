package com.ilkerbas.spring.homework;

public class Customer {

	// fields
	private long customerId;
	private String customerName;
	private long totalDebt;
	
	// default constructor
	public Customer() {
		
	}

	// constructor using fields
	public Customer(long customerId, String customerName, long totalDebt) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalDebt = totalDebt;
	}

	// getters & setters
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(long totalDebt) {
		this.totalDebt = totalDebt;
	}
	
}
