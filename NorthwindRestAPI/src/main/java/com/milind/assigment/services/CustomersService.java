package com.milind.assigment.services;

import java.util.List;

import com.milind.assigment.domain.Customers;

public interface CustomersService {
	public Customers saveCustomer(Customers customer);

	public Customers updateCustomer(Customers customer);

	public List<Customers> getAllCustomers();

	public Customers getCustomerById(String customerId);

	public Customers getOrderHistoryOfCustomer(String customerId);
}
