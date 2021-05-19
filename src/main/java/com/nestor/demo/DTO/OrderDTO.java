package com.nestor.demo.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	
	private LocalDateTime date;
	private CustomerDTO customer;
	private Boolean status;
	private List<ItemDTO> items;

}
