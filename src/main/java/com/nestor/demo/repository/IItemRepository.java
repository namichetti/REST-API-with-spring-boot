package com.nestor.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nestor.demo.model.Item;

public interface IItemRepository extends JpaRepository<Item, Long>{

}
