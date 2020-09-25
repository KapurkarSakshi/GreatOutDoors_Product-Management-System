/****************************
 -Author                : Sakshi Kapurkar
 -Created/Modified Date : 22/09/2020
 -Description           : IProductService interface for Product Management System
**********************/


package com.capgemini.go.pms.service;

import java.util.List;

import com.capgemini.go.pms.exceptions.InvalidInputException;
import com.capgemini.go.pms.exceptions.ProductNotFoundException;
import com.capgemini.go.pms.model.Product;

public interface IProductService {
	
	    public List<Product> getAllProducts();
	    public Product getProductById(String id);
	    public Product addProduct(Product product) ;
	    public Product updateProduct(Product product) ;
	    public void deleteProduct(String productId) ;
	    
	    
	    public boolean validateProductId(String productId) ;

}
