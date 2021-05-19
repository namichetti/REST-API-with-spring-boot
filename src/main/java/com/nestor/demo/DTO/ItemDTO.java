package com.nestor.demo.DTO;

import java.math.BigInteger;

import lombok.Data;

@Data
public class ItemDTO {
	
	private BigInteger price;
	private Integer quantity;
	private OrderDTO order;
	private ProductDTO product;

}
