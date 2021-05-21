package com.nestor.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nestor.demo.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	public Customer findByAddress(String address);

}
