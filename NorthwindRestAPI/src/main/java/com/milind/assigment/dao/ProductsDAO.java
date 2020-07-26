package com.milind.assigment.dao;

import java.util.List;

import com.milind.assigment.domain.Products;

public interface ProductsDAO {
	public Products saveProductToDB(Products product);

	public Products updateProductInDB(Products product);

	public List<Products> getAllProductsFromDB();
	
	public Products getProductByIdForUpdate(Integer productId);

	public Products getProductByIdFromDB(Integer productId);
}
