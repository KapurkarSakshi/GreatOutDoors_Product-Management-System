/***************************************
 -Author                : Sakshi Kapurkar
 -Created/Modified Date : 22/09/2020
 -Description           : Controller Product :for Adding, 
                                              viewing particular product using id ,
                                              view whole product List , 
                                              update & 
  	                                          deleting the product. 
  	                      Controller Product Master: for Adding, 
  	                                                     deleting & view whole List of the Product Master. 
*************************************/


package com.capgemini.go.pms.controller;

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

import com.capgemini.go.pms.exceptions.ProductNotFoundException;
import com.capgemini.go.pms.model.Product;
import com.capgemini.go.pms.model.ProductMaster;
import com.capgemini.go.pms.repository.IProductMasterDao;
import com.capgemini.go.pms.service.IProductMasterService;
import com.capgemini.go.pms.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	IProductService service;
	

	@GetMapping("/id/{productId}")
	public Product viewProductById(@PathVariable String productId) {
		
		return service.getProductById(productId);
		
	}
	
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return service.getAllProducts();	
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)  {

	     return product=service.addProduct(product);
	     
	}

	@PostMapping("/update")
	public Product updateProduct(@RequestBody Product product) {

        return service.updateProduct(product);   
}
				
	
	
	@DeleteMapping("/delete/{productId}")
	public void deleteProduct(@PathVariable String productId)  {
		 
		service.deleteProduct(productId);
		
	}
	
	// Product Master
	@Autowired
	IProductMasterService pmService;
	
		
	@PostMapping("/pm/reg")
	public ProductMaster registerProductMaster(@RequestBody ProductMaster productMaster)  {

	     return productMaster=pmService.addProductMaster(productMaster);
	     
	}
	
	@DeleteMapping("/pm/delete/{userId}")
	public void deleteProductMaster(@PathVariable String userId)  {
		 
		pmService.deleteProductMaster(userId);
	}
	
	@GetMapping("/pm/all")
	public List<ProductMaster> getAllProductMaster(){
		return pmService.getAllProductMaster();	
	}
	
	
	
}
