package com.nestor.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nestor.demo.DTO.CustomerDTO;
import com.nestor.demo.model.Customer;
import com.nestor.demo.repository.ICustomerRepository;


@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly=true)
	public List<Customer> getAll() {
		return this.customerRepository.findAll();
	}
	
	@Override
	@Transactional
	public void save(Customer customer) {
		this.customerRepository.save(customer);
	}

	@Override
	public List<CustomerDTO> ListEntityToDTOs(List<Customer> customers) {
		List<CustomerDTO> customerDTOs = customers
						.stream()
						.map(customer-> this.modelMapper.map(customer, CustomerDTO.class))
						.collect(Collectors.toList());
		return customerDTOs;
	}
	
	
	
	public CustomerDTO EntityToDTO(Customer customer) {
		CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
		return customerDTO;
	}

	public Customer DTOToEntity(CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		return customer;
	}

}
