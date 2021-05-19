package com.nestor.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	private String phone;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Order> orders;

	public Customer() {
		this.orders = new ArrayList<>();
	}
}
