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

import com.milind.assigment.domain.Products;
import com.milind.assigment.repositories.ProductsRepository;

@Component
public class ProductsDAOImpl implements ProductsDAO {

	Logger logger = LoggerFactory.getLogger(ProductsDAOImpl.class);

	@Autowired
	private ProductsRepository productRepository;

	@Override
	public Products saveProductToDB(Products product) {
		logger.info("Entering - saveProductToDB() method with Product: " + product.toString());
		Products pro = productRepository.save(product);
		if (pro == null) {
			logger.error("IllegalArgumentException encountered!!! - Product not saved");
			throw new IllegalArgumentException("Product not saved");
		}

		logger.info("Leaving - saveProductToDB() method");
		return pro;
	}

	@Override
	public Products updateProductInDB(Products product) {
		logger.info("Entering - updateProductInDB() method with Product: " + product.toString());

		Products pro = saveProductToDB(product);

		logger.info("Leaving - updateProductInDB() method");
		return pro;
	}

	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
	public List<Products> getAllProductsFromDB() {
		logger.info("Entering - getAllProductsFromDB() method for fetching all products in DB");

		List<Products> products = productRepository.findAll();

		logger.info("Leaving - getAllProductsFromDB() method");
		return products;
	}

	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
	public Products getProductByIdForUpdate(Integer productId) {
		logger.info("Entering - getProductByIdForUpdate() method for fetching product with ProductID: " + productId
				+ " in DB");
		Products product = productRepository.getOne(productId);
		if (product == null) {
			logger.error("EntityNotFoundException encountered with product id: " + productId);
			throw new EntityNotFoundException("Product not found with id { " + productId + " }");
		}
		logger.info("Leaving - getProductByIdForUpdate() method");
		return product;
	}

	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
	public Products getProductByIdFromDB(Integer productId) {
		logger.info("Entering - getProductByIdFromDB() method for fetching product with ProductID: " + productId
				+ " in DB");
		Optional<Products> product = productRepository.findById(productId);
		if (product.get() == null) {
			logger.error("EntityNotFoundException encountered with product id: " + productId);
			throw new EntityNotFoundException("Product not found with id { " + productId + " }");
		}
		logger.info("Leaving - getProductByIdFromDB() method");
		return product.get();
	}

}
