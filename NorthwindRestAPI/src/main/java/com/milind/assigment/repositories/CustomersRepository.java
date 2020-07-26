package com.milind.assigment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milind.assigment.domain.Customers;

public interface CustomersRepository extends JpaRepository<Customers, String> {

}
