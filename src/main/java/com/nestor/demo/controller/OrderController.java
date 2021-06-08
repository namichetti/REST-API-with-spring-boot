package com.nestor.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nestor.demo.DTO.OrderDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Customer;
import com.nestor.demo.model.Order;
import com.nestor.demo.service.ICustomerService;
import com.nestor.demo.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private ICustomerService customerService;
		
	@GetMapping("/")
	public List<OrderDTO> getAll(){
		List<Order> orders = this.orderService.getAll();
		List<OrderDTO> orderDTOs = this.orderService.ListEntityToDTOs(orders);
		return orderDTOs;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		this.orderService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		OrderDTO customerDTO = this.orderService.EntityToDTO(this.orderService.getById(id));
		return new ResponseEntity<>(customerDTO,HttpStatus.OK);
	}
	
	@PostMapping("/{customer_id}/")
	public ResponseEntity<?> save(@PathVariable Long customer_id, @RequestBody OrderDTO orderDTO)
			throws NotFoundCustomException, NotFoundByIdCustomException{
		Customer customer = this.customerService.getById(customer_id);
		Order order = this.orderService.DTOToEntity(orderDTO);
		order.setCustomer(customer);
		this.orderService.save(order);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{order_id}/{customer_id}")
	public ResponseEntity<?> update(@RequestBody OrderDTO orderDTO,@PathVariable Long order_id,@PathVariable Long customer_id) 
			throws NotFoundCustomException, NotFoundByIdCustomException{
		Order recoveredOrder = this.orderService.getById(order_id);
		Order order = this.orderService.DTOToEntity(orderDTO);
		Customer customer = this.customerService.getById(customer_id);
		recoveredOrder.setCustomer(customer);
		recoveredOrder.setStatus(order.getStatus());
		this.orderService.save(recoveredOrder);
		return new ResponseEntity<>(recoveredOrder,HttpStatus.OK);
	}
	
	@GetMapping("/search") //"yyyy-MM-dd'T'HH:mm:ssZ or "yyyy-MM-dd'T'HH:mm:ss". Exmaple: "2020-12-31T12:30:00";;
	public ResponseEntity<?> searchByTwoDates(@RequestParam(value= "firstDate" , required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime firstDate,
			@RequestParam(value = "secondDate" , required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime secondDate){
		List<Order> orders = this.orderService.searchByDate(firstDate, secondDate);
		List<OrderDTO> orderDTOs = this.orderService.ListEntityToDTOs(orders);
		return new ResponseEntity<>(orderDTOs, HttpStatus.OK);
	}

}
