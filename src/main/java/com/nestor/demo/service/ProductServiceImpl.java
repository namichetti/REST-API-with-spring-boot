package com.nestor.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nestor.demo.DTO.ProductDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Product;
import com.nestor.demo.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional(readOnly=true)
	public List<Product> getAll() {
		return this.productRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Product product) {
		this.productRepository.save(product);
	}

	@Override
	@Transactional(readOnly=true)
	public Product getById(Long id) throws NotFoundByIdCustomException, NotFoundCustomException {
	 Product product = null;
		
		if(id>0) {
			product = this.productRepository.findById(id).orElse(null);
			if(product!=null) {
				return product;
			}else {
				throw new NotFoundCustomException();
				}
		    }else{
			throw new NotFoundByIdCustomException(); 
		}		
	}

	@Override
	@Transactional
	public void deleteById(Long id) throws NotFoundByIdCustomException, NotFoundCustomException {
		this.getById(id);
		this.productRepository.deleteById(id);	
	}

	@Override
	public List<ProductDTO> ListEntityToDTOs(List<Product> products) {
		List<ProductDTO> productDTOs = products
						.stream()
						.map(product-> this.modelMapper.map(product, ProductDTO.class))
						.collect(Collectors.toList());
		return productDTOs; 
	}
	
	
	@Override
	public ProductDTO EntityToDTO(Product product) {
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		return productDTO;
	}

	@Override
	public Product DTOToEntity(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		return product;
	}
}
