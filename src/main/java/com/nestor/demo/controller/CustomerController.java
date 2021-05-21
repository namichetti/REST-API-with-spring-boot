package com.nestor.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestor.demo.DTO.CustomerDTO;
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
	
}
