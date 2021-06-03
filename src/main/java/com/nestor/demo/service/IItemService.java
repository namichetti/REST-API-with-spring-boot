package com.nestor.demo.service;

import java.util.List;

import com.nestor.demo.DTO.ItemDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Item;

public interface IItemService {

	public List<Item> getAll();
	public void save(Item item);
	public Item getById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException;
	public void deleteById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException;
	public Item DTOToEntity(ItemDTO itemDTO);
	public ItemDTO EntityToDTO(Item product);
	public List<ItemDTO> ListEntityToDTOs(List<Item> items);
}
