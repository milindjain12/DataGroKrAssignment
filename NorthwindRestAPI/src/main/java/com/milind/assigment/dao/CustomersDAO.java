package com.milind.assigment.dao;

import java.util.List;

import com.milind.assigment.domain.Customers;

public interface CustomersDAO {
	public Customers saveCustomerToDB(Customers customer);

	public Customers updateCustomersInDB(Customers customer);

	public List<Customers> getAllCustomersFromDB();
	
	public Customers getCustomerByIdForUpdate(String customerId);

	public Customers getCustomerByIdFromDB(String customerId);
}
