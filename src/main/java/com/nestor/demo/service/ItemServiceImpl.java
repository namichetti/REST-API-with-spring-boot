package com.nestor.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nestor.demo.DTO.ItemDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Item;
import com.nestor.demo.repository.IItemRepository;

@Service
public class ItemServiceImpl implements IItemService{

	@Autowired
	private IItemRepository itemRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional(readOnly=true)
	public List<Item> getAll() {
		return this.itemRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Item item) {
		this.itemRepository.save(item);
	}

	@Override
	@Transactional(readOnly=true)
	public Item getById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException {
		Item item = null;
		if(id>0) {
			item = this.itemRepository.findById(id).orElse(null);
			if(item!=null) {
				return item;
			}else {
				throw new NotFoundCustomException();
				}
		    }else{
			throw new NotFoundByIdCustomException(); 
		}	
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) throws NotFoundCustomException, NotFoundByIdCustomException {
		this.getById(id);
		this.itemRepository.deleteById(id);	
	}
	
	@Override
	public List<ItemDTO> ListEntityToDTOs(List<Item> items) {
		List<ItemDTO> itemDTOs = items
						.stream()
						.map(item-> this.modelMapper.map(item, ItemDTO.class))
						.collect(Collectors.toList());
		return itemDTOs; 
	}
	
	
	@Override
	public ItemDTO EntityToDTO(Item product) {
		ItemDTO itemDTO = modelMapper.map(product, ItemDTO.class);
		return itemDTO;
	}

	@Override
	public Item DTOToEntity(ItemDTO itemDTO) {
		Item item = modelMapper.map(itemDTO, Item.class);
		return item;
	}

}
