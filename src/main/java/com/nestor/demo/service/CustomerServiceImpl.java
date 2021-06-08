package com.nestor.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nestor.demo.DTO.CustomerDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
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
	@Transactional(readOnly=true)
	public Customer getById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		Customer customer = null;
		
		if(id>0) {
		customer = this.customerRepository.findById(id).orElse(null);
			if(customer!=null) {
				return customer;
			}else {
				throw new NotFoundCustomException();
				}
		    }else{
			throw new NotFoundByIdCustomException(); 
		}
		
		
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		this.getById(id);
		this.customerRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Customer searchByAddress(String address) {
		return this.customerRepository.findByAddress(address);
	}



	public List<CustomerDTO> ListEntityToDTOs(List<Customer> customers) {
		List<CustomerDTO> customerDTOs = customers
						.stream()
						.map(object-> this.modelMapper.map(object, CustomerDTO.class))
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
