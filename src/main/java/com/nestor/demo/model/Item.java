package com.nestor.demo.model;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	/*public BigInteger getSubTotal() {
		BigInteger q = new BigInteger(this.quantity.toString());
		return this.product.getPrice().multiply(q);
	}*/
}
