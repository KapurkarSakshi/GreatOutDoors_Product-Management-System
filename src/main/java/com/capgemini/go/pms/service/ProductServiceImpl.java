package com.capgemini.go.pms.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.go.pms.exceptions.InvalidInputException;
import com.capgemini.go.pms.exceptions.ProductNotFoundException;
import com.capgemini.go.pms.model.Product;
import com.capgemini.go.pms.model.ProductMaster;
import com.capgemini.go.pms.repository.IProductDao;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDao repository;
	
	/*******************************************************************
	 -FunctionName          : getAllProducts
	 -Input Parameters      :      -
	 -Return Type           : List<Product>
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public List<Product> getAllProducts() {
    List<Product> p = repository.findAll();
		
		if(p.isEmpty()) {
			throw new NullPointerException("The List is Empty !!");
		}
		else {
		
		return repository.findAll();
		}
		
	}

	
	/*******************************************************************
	 -FunctionName          : getProductById
	 -Input Parameters      : String productId
	 -Return Type           : Product
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
			
	@Override
	public Product getProductById(String productId) {
		if(!(repository.existsById(productId))) {
			throw new InvalidInputException("Product Id does not exist !");
		}
		else {
		return repository.getOne(productId);
	}
	}

	
	
	/*******************************************************************
	 -FunctionName          : addProduct
	 -Input Parameters      : Product product
	 -Return Type           : Product
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public Product addProduct(Product product) {
		

		if(product!=null) {
			if(repository.existsById(product.getProductId())) {
				throw new ProductNotFoundException("Product ID already exists !");
			}
			else if(!validateProductId(product.getProductId())){
				throw new InvalidInputException("Product Id  is NOT valid");
			}
			else{
				repository.save(product);
			}
		}
		return product;
		
	}
	
	/*******************************************************************
	 -FunctionName          : updateProduct
	 -Input Parameters      : Product product
	 -Return Type           : Product
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/

	@Override
	public Product updateProduct(Product product) {
		
		if(!(repository.existsById(product.getProductId()))) {
			throw new ProductNotFoundException("Product Id does not exist !");
		}
		else {
			return repository.save(product);
		}
	}

	

	/*******************************************************************
	 -FunctionName          : deleteProduct
	 -Input Parameters      : String productId
	 -Return Type           :       -
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public void deleteProduct(String productId) {
		if(repository.existsById(productId)) {
		repository.deleteById(productId);
		}
		else {
			throw new ProductNotFoundException("Product Id does not exist !");
		}
	
	}

	
	/*******************************************************************
	 -FunctionName          : validateProductId
	 -Input Parameters      : String id
	 -Return Type           : boolean
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public boolean validateProductId(String id) {
		
		String regex = "^[1-9]{1}[0-9]{2}+[aA-zZ]{1}$"; 
	      if(id.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidInputException("Product Id  is NOT valid");
	}
	
	
}
