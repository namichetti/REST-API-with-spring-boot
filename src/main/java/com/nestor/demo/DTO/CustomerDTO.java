package com.nestor.demo.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDTO {

	private String address;
	private String phone;
	private List<OrderDTO> orders;

}
