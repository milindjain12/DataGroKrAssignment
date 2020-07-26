package com.milind.assigment.services;

import java.util.List;

import com.milind.assigment.domain.Products;

public interface ProductsService {
	
	public Products saveProduct(Products product);
	
	public Products updateProduct(Products product);
	
	public List<Products> getAllProducts();
	
	public Products getProductById(Integer productId);
}
