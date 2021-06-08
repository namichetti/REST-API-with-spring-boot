package com.nestor.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nestor.demo.DTO.OrderDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Order;
import com.nestor.demo.repository.IOrderRespository;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderRespository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly=true)
	public List<Order> getAll() {
		return this.orderRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Order getById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException {
		Order order = null;
		
		if(id>0) {
			order = this.orderRepository.findById(id).orElse(null);
			if(order!=null) {
				return order;
			}else {
				throw new NotFoundCustomException();
				}
		    }else{
			throw new NotFoundByIdCustomException(); 
		}
	}

	@Override
	@Transactional
	public void save(Order order) {
		this.orderRepository.save(order);

	}

	@Override
	@Transactional
	public void deleteById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException {
		this.getById(id);
		this.orderRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Order> searchByDate(LocalDateTime firstDate, LocalDateTime secondDate) {
		return this.orderRepository.findByDateBetween(firstDate,secondDate);
	}
	
	@Override
	public List<OrderDTO> ListEntityToDTOs(List<Order> orders) {
		List<OrderDTO> orderDTOs = orders
						.stream()
						.map(object-> this.modelMapper.map(object, OrderDTO.class))
						.collect(Collectors.toList());
		return orderDTOs; 
	}
	
	
	@Override
	public OrderDTO EntityToDTO(Order order) {
		OrderDTO customerDTO = modelMapper.map(order, OrderDTO.class);
		return customerDTO;
	}

	@Override
	public Order DTOToEntity(OrderDTO orderDTO) {
		Order order = modelMapper.map(orderDTO, Order.class);
		return order;
	}

}
