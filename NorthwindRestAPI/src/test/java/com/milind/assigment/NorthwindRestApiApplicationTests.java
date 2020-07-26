package com.milind.assigment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.milind.assigment.controllers.CustomerController;
import com.milind.assigment.controllers.ProductController;
import com.milind.assigment.dao.CustomersDAO;
import com.milind.assigment.dao.ProductsDAO;
import com.milind.assigment.services.CustomersService;
import com.milind.assigment.services.ProductsService;

@SpringBootTest
class NorthwindRestApiApplicationTests {

	@Autowired
	CustomerController customerController;

	@Autowired
	ProductController productController;

	@Autowired
	CustomersService customerService;

	@Autowired
	ProductsService productsService;

	@Autowired
	CustomersDAO customersDAO;

	@Autowired
	ProductsDAO productsDAO;

	@DisplayName("Customer Controller test")
	@Test
	void contextLoadsCustomerController() throws Exception {
		assertThat(customerController).isNotNull();
	}

	@DisplayName("Product Controller test")
	@Test
	void contextLoadsProductController() throws Exception {
		assertThat(productController).isNotNull();
	}

	@DisplayName("Customers Service test")
	@Test
	void contextLoadsCustomersService() {
		assertThat(customerService).isNotNull();
	}

	@DisplayName("Products Service test")
	@Test
	void contextLoadsProductsService() {
		assertThat(productsService).isNotNull();
	}

	@DisplayName("CustomersDAO test")
	@Test
	void contextLoadsCustomersDAO() {
		assertThat(customersDAO).isNotNull();
	}

	@DisplayName("ProductsDAO test")
	@Test
	void contextLoadsProductsDAO() {
		assertThat(productsDAO).isNotNull();
	}
}
