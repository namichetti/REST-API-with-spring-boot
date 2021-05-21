package com.nestor.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestor.demo.DTO.CustomerDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Customer;
import com.nestor.demo.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/")
	public List<CustomerDTO> getAll(){
		List<Customer> customers = this.customerService.getAll();
		return this.customerService.ListEntityToDTOs(customers);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody CustomerDTO customerDTO){
		Customer customer = this.customerService.DTOToEntity(customerDTO);
		this.customerService.save(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) 
			throws NotFoundCustomException, NotFoundByIdCustomException{
		Customer recoveredCustomer = this.customerService.getById(id);
		Customer customer = this.customerService.DTOToEntity(customerDTO);
		recoveredCustomer.setAddress(customer.getAddress());
		recoveredCustomer.setPhone(customer.getPhone());
		recoveredCustomer.setOrders(customer.getOrders());
		this.customerService.save(recoveredCustomer);
		return new ResponseEntity<>(recoveredCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		this.customerService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{address}")
	public ResponseEntity<?> searchByAddress(@PathVariable String address) throws NotFoundCustomException{
		Customer customer = this.customerService.searchByAddress(address);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
}
