package com.nestor.demo.DTO;

import java.math.BigInteger;
import java.util.List;
import lombok.Data;

@Data
public class OrderDTO {
	
	private BigInteger total;
	private Boolean status;
	private List<ItemDTO> items;


}
