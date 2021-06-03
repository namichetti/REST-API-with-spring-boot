package com.nestor.demo.service;

import java.util.List;

import com.nestor.demo.DTO.ProductDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Product;

public interface IProductService {
	
	public List<Product> getAll();
	public void save(Product product);
	public Product getById(Long id) throws NotFoundByIdCustomException, NotFoundCustomException;
	public void deleteById(Long id) throws NotFoundByIdCustomException, NotFoundCustomException;
	public List<ProductDTO> ListEntityToDTOs(List<Product> products);
	public ProductDTO EntityToDTO(Product product);
	public Product DTOToEntity(ProductDTO productDTO);

}
