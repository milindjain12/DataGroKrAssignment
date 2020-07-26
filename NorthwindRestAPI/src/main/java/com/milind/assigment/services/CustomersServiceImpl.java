package com.milind.assigment.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milind.assigment.dao.CustomersDAO;
import com.milind.assigment.domain.Customers;

@Service
public class CustomersServiceImpl implements CustomersService {

	Logger logger = LoggerFactory.getLogger(CustomersServiceImpl.class);

	@Autowired
	private CustomersDAO customersDAO;

	@Override
	public Customers saveCustomer(Customers customer) {
		logger.info("Entering - saveCustomer() method with customer: " + customer.toString() + " to DB");

		Customers cus = customersDAO.saveCustomerToDB(customer);

		logger.info("Leaving - saveCustomer() method");
		return cus;
	}

	@Override
	public Customers updateCustomer(Customers customer) {
		logger.info("Entering - updateCustomer() method with customer: " + customer.toString() + " to DB");

		Customers origCustomers = customersDAO.getCustomerByIdForUpdate(customer.getCustomerId());
		origCustomers = Customers.copyValues(origCustomers, customer);

		logger.info("Leaving - updateCustomer() method");
		return customersDAO.updateCustomersInDB(origCustomers);
	}

	@Override
	public List<Customers> getAllCustomers() {
		logger.info("Entering - getAllCustomers() method");

		List<Customers> customers = customersDAO.getAllCustomersFromDB();

		logger.info("Leaving - getAllCustomers() method");
		return customers;
	}

	@Override
	public Customers getCustomerById(String customerId) {
		logger.info("Entering - getCustomerById() method with customer ID: " + customerId);

		Customers customer = customersDAO.getCustomerByIdFromDB(customerId);

		logger.info("Leaving - getCustomerById() method");
		return customer;
	}

	@Override
	public Customers getOrderHistoryOfCustomer(String customerId) {
		logger.info("Entering - getOrderHistoryOfCustomer() method with customer ID: " + customerId);

		Customers customer = customersDAO.getCustomerByIdFromDB(customerId);

		logger.info("Leaving - getOrderHistoryOfCustomer() method");
		return customer;
	}

}
