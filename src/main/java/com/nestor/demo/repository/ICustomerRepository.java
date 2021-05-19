package com.nestor.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.nestor.demo.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long>{

}
