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

import com.milind.assigment.domain.Products;
import com.milind.assigment.services.ProductsService;

@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {
	public static final String BASE_URL = "/products";

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductsService productsService;

	@GetMapping
	List<Products> getAllProducts() {
		logger.info("Entering - getAllProducts() method");

		List<Products> products = productsService.getAllProducts();

		logger.info("Leaving - getAllProducts() method");
		return products;
	}

	@GetMapping("/{productId}")
	Products getProductById(@PathVariable Integer productId) {
		logger.info("Entering - getProductById() method with ProductID: " + productId);

		Products product = productsService.getProductById(productId);

		logger.info("Leaving - getProductById() method");
		return product;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Products saveProduct(@RequestBody @Valid Products product) {
		logger.info("Entering - saveProduct() method with Product: " + product.toString());

		Products pro = productsService.saveProduct(product);

		logger.info("Leaving - saveProduct() method");
		return pro;
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	Products updateProduct(@RequestBody @Valid Products product) {
		logger.info("Entering - updateProduct() method with Product: " + product.toString());

		Products pro = productsService.updateProduct(product);

		logger.info("Leaving - updateProduct() method");
		return pro;
	}
}
