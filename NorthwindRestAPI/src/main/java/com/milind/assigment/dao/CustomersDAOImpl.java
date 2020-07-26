package com.milind.assigment.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.LockModeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;

import com.milind.assigment.domain.Customers;
import com.milind.assigment.repositories.CustomersRepository;

@Component
public class CustomersDAOImpl implements CustomersDAO {

	Logger logger = LoggerFactory.getLogger(CustomersDAOImpl.class);

	@Autowired
	private CustomersRepository customersRepository;

	@Override
	public Customers saveCustomerToDB(Customers customer) {
		logger.info("Entering - saveCustomerToDB() method for saving customer: " + customer.toString() + " to DB");

		Customers cus = customersRepository.save(customer);
		if (cus == null) {
			logger.error("IllegalArgumentException encountered!!! - Customer not saved");
			throw new IllegalArgumentException("Customer not saved");
		}

		logger.info("Leaving - saveCustomerToDB() method");
		return cus;
	}

	@Override
	public Customers updateCustomersInDB(Customers customer) {
		logger.info(
				"Entering - updateCustomersInDB() method for updating customer: " + customer.toString() + "  to DB");

		Customers cus = saveCustomerToDB(customer);

		logger.info("Leaving - updateCustomersInDB() method");
		return cus;
	}

	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
	public List<Customers> getAllCustomersFromDB() {
		logger.info("Entering - getAllCustomersFromDB() method for fetching customers from DB");

		List<Customers> customers = customersRepository.findAll();

		logger.info("Leaving - getAllCustomersFromDB() method");
		return customers;
	}

	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
	public Customers getCustomerByIdForUpdate(String customerId) {
		logger.info("Entering - getCustomerByIdForUpdate() method for fetching customer from DB with customer id: "
				+ customerId);

		Customers customer = customersRepository.getOne(customerId);
		if (customer == null) {
			logger.error("EntityNotFoundException encountered!!! - Customer Not Found with customer ID: " + customerId);
			throw new EntityNotFoundException("Customer not found with id { " + customerId + " }");
		}
		logger.info("Leaving - getCustomerByIdForUpdate() method");

		return customer;
	}

	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
	public Customers getCustomerByIdFromDB(String customerId) {
		logger.info("Entering - getCustomerByIdFromDB() method for fetching customer from DB with customer id: "
				+ customerId);

		Optional<Customers> customer = customersRepository.findById(customerId);
		if (customer.get() == null) {
			logger.error("EntityNotFoundException encountered!!! - Customer Not Found with customer ID: " + customerId);
			throw new EntityNotFoundException("Customer not found with id { " + customerId + " }");
		}

		logger.info("Leaving - getCustomerByIdFromDB() method");
		return customer.get();
	}

}
