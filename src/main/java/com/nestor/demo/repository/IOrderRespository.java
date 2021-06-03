package com.nestor.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nestor.demo.model.Order;

public interface IOrderRespository extends JpaRepository<Order, Long>{

	public List<Order> findByDateBetween(LocalDateTime firstDate, LocalDateTime secondDate);
}
