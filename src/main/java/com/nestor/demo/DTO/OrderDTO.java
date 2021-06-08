package com.nestor.demo.DTO;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class OrderDTO {
	
	private BigInteger total;
	private Boolean status;
	private List<ItemDTO> items;
	@JsonIgnore
	private CustomerDTO customer;

}
