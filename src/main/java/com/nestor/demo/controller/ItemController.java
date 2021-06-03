package com.nestor.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nestor.demo.DTO.ItemDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Item;
import com.nestor.demo.service.IItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	@GetMapping("/")
	public List<ItemDTO> getAll(){
		List<Item> items = this.itemService.getAll();
		List<ItemDTO> itemDTOs = this.itemService.ListEntityToDTOs(items);
		return itemDTOs;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		this.itemService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		ItemDTO itemDTO = this.itemService.EntityToDTO(this.itemService.getById(id));
		return new ResponseEntity<>(itemDTO,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody ItemDTO itemDTO){
		Item item = this.itemService.DTOToEntity(itemDTO);
		this.itemService.save(item);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ItemDTO itemDTO, @PathVariable Long id) 
			throws NotFoundCustomException, NotFoundByIdCustomException{
		Item recoveredItem = this.itemService.getById(id);
		Item item = this.itemService.DTOToEntity(itemDTO);
		recoveredItem.setQuantity(item.getQuantity());
		recoveredItem.setOrder(item.getOrder());
		recoveredItem.setProduct(item.getProduct());
		this.itemService.save(recoveredItem);
		return new ResponseEntity<>(recoveredItem,HttpStatus.OK);
	}
}
