package com.nestor.demo.service;

import java.util.List;

import com.nestor.demo.DTO.CustomerDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Customer;

public interface ICustomerService {

	public List<Customer> getAll();
	public void save(Customer customer);
	public Customer getById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException;
	public void deleteById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException;
	public Customer searchByAddress(String address);
	public List<CustomerDTO> ListEntityToDTOs(List<Customer> customers);
	public Customer DTOToEntity(CustomerDTO customerDTO);
	public CustomerDTO EntityToDTO(Customer customer);

}
