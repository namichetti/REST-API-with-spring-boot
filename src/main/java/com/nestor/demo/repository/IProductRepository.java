package com.nestor.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nestor.demo.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

}
