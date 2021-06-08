package com.nestor.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nestor.demo.DTO.ProductDTO;
import com.nestor.demo.exception.NotFoundByIdCustomException;
import com.nestor.demo.exception.NotFoundCustomException;
import com.nestor.demo.model.Product;
import com.nestor.demo.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/")
	public List<ProductDTO> getAll(){
		List<Product> products = this.productService.getAll();
		List<ProductDTO> productDTOs = this.productService.ListEntityToDTOs(products);
		return productDTOs;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundCustomException, NotFoundByIdCustomException{
		ProductDTO productDTO = this.productService.EntityToDTO(this.productService.getById(id));
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody ProductDTO productDTO){
		Product product = this.productService.DTOToEntity(productDTO);
		this.productService.save(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ProductDTO productDTO, @PathVariable Long id) 
			throws NotFoundCustomException, NotFoundByIdCustomException{
		Product recoveredProduct = this.productService.getById(id);
		Product product = this.productService.DTOToEntity(productDTO);
		recoveredProduct.setName(product.getName());
		recoveredProduct.setPrice(product.getPrice());
		this.productService.save(recoveredProduct);
		return new ResponseEntity<>(recoveredProduct,HttpStatus.OK);
	}
}
