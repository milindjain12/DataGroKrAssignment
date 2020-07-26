package com.milind.assigment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.milind.assigment.domain.Customers;
import com.milind.assigment.domain.Orders;
import com.milind.assigment.services.CustomersService;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	public static final String BASE_URL = "/customers";

	@Autowired
	private CustomersService customersService;

	@GetMapping
	List<Customers> getAllCustomers() {
		logger.info("Entering - getAllCustomers() method");

		List<Customers> customers = customersService.getAllCustomers();

		logger.info("Leaving - getAllCustomers() method");
		return customers;
	}

	@GetMapping("/{customerId}")
	Customers getCustomerById(@PathVariable("customerId") @Valid String customerId) {
		logger.info("Entering - getCustomerById() method with CustomerID: " + customerId);

		Customers customer = customersService.getCustomerById(customerId);

		logger.info("Leaving - getCustomerById() method");
		return customer;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Customers saveCustomer(@RequestBody @Valid Customers customer) {
		logger.info("Entering - saveCustomer() method with Customer: " + customer.toString());
		
		Customers cus = customersService.saveCustomer(customer);
		
		logger.info("Leaving - saveCustomer() method");
		return cus;
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	Customers updateCustomer(@RequestBody @Valid Customers customer) {
		logger.info("Entering - updateCustomer() method with Customer: " + customer.toString());
		
		Customers cus = customersService.updateCustomer(customer);
		
		logger.info("Leaving - updateCustomer() method");
		return cus;
	}

	@GetMapping("/orders/{customerId}")
	List<Orders> getCustomerOrderHistory(@PathVariable("customerId") @Valid String customerId) {
		logger.info("Entering - getCustomerOrderHistory() method with CustomerID: " + customerId);
		
		Customers customer = customersService.getOrderHistoryOfCustomer(customerId);
		
		logger.info("Leaving - getCustomerOrderHistory() method");
		return customer.getOrders();
	}
}
