package com.nestor.demo.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	private LocalDateTime date;
	private BigInteger total;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;
	private Boolean status;
	@OneToMany(mappedBy = "order", cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private List<Item> items;
	
	public Order() {
		this.items = new ArrayList<>();
	}
	
	/*public BigInteger getTotal(){
		this.total = null;
		for (Item item : items) {
			total = total.and(item.getSubTotal());
		}
		return total;
	}*/
}
