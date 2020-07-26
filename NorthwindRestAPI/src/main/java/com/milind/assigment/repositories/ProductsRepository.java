package com.milind.assigment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milind.assigment.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
