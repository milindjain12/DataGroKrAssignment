package com.milind.assigment.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milind.assigment.dao.ProductsDAO;
import com.milind.assigment.domain.Products;

@Service
public class ProductsServiceImpl implements ProductsService {

	Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

	@Autowired
	private ProductsDAO productsDAO;

	@Override
	public Products saveProduct(Products product) {
		logger.info("Entering - saveProduct() method with Product: " + product.toString());

		Products pro = productsDAO.saveProductToDB(product);

		logger.info("Leaving - saveProduct() method");
		return pro;
	}

	@Override
	public Products updateProduct(Products product) {
		logger.info("Entering - updateProduct() method with Product: " + product.toString());

		Products origProduct = productsDAO.getProductByIdForUpdate(product.getProductId());
		origProduct = Products.copyValues(origProduct, product);

		logger.info("Leaving - updateProduct() method");
		return productsDAO.updateProductInDB(origProduct);
	}

	@Override
	public List<Products> getAllProducts() {
		logger.info("Entering - getAllProducts() method for fetching all products");

		List<Products> products = productsDAO.getAllProductsFromDB();

		logger.info("Leaving - getAllProducts() method");
		return products;
	}

	@Override
	public Products getProductById(Integer productId) {
		logger.info("Entering - getProductById() method for fetching product with ProductID: " + productId + " in DB");

		Products product = productsDAO.getProductByIdFromDB(productId);

		logger.info("Leaving - getProductById() method");
		return product;
	}

}
