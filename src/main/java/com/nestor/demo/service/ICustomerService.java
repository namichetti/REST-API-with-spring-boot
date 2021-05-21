package com.nestor.demo.service;

import java.util.List;

import com.nestor.demo.DTO.CustomerDTO;
import com.nestor.demo.model.Customer;

public interface ICustomerService {

	public List<Customer> getAll();
	public List<CustomerDTO> ListEntityToDTOs(List<Customer> customers);
	public CustomerDTO EntityToDTO(Customer customer);
	public Customer DTOToEntity(CustomerDTO customerDTO);
	public void save(Customer customer);
}
