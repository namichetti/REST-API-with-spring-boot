package com.nestor.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.nestor.demo.DTO.OrderDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Order;

public interface IOrderService {
	
	public List<Order> getAll();
	public Order getById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException;
	public void save(Order order);
	public void deleteById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException;
	public OrderDTO EntityToDTO(Order order);
	public List<OrderDTO> ListEntityToDTOs(List<Order> orders);
	public Order DTOToEntity(OrderDTO orderDTO);
	public List<Order> searchByDate(LocalDateTime firstDate,LocalDateTime secondtDate);

}
