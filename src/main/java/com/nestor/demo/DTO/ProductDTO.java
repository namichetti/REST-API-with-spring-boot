package com.nestor.demo.DTO;

import java.math.BigInteger;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private BigInteger price;
	private String name;
}
