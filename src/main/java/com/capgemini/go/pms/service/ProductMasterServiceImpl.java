package com.capgemini.go.pms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.go.pms.exceptions.InvalidInputException;
import com.capgemini.go.pms.exceptions.ProductNotFoundException;
import com.capgemini.go.pms.model.Product;
import com.capgemini.go.pms.model.ProductMaster;
import com.capgemini.go.pms.repository.IProductMasterDao;

@Service
public class ProductMasterServiceImpl  implements IProductMasterService{

	@Autowired
	IProductMasterDao repository;

	
	/*******************************************************************
	 -FunctionName          : addProductMaster
	 -Input Parameters      : ProductMaster productMaster
	 -Return Type           : ProductMaster 
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public ProductMaster addProductMaster(ProductMaster productMaster) {
		
		if(!(validateProductMaster(productMaster)  && (productMaster.getPassword().equals(productMaster.getReEnterPassword())))) 
		{
			throw new InvalidInputException("Re-Entered-Password is incorrect! Please Check!!");
		}
		else {
		return repository.save(productMaster);
		}
	}

	
	/*******************************************************************
	 -FunctionName          : validateProductMaster
	 -Input Parameters      : ProductMaster master
	 -Return Type           : boolean
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	
	public boolean validateProductMaster(ProductMaster master) {
	
		if((validateUserId(master.getUserId()) ) && (validatePassword(master.getPassword()) )&& 
				(validatePassword(master.getReEnterPassword()) )&&(validateEmail(master.getEmail()) )&& 
				(validatePhoneNumber(master.getPhoneNumber()) )){
			return true;}
		else {return false;}
		
	}
	
	/*******************************************************************
	 -FunctionName          : validateUserId
	 -Input Parameters      : String userId
	 -Return Type           : boolean
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	
	@Override
	public boolean validateUserId(String userId) {
		String regex="[(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{8,}";
		if(!userId.matches(regex)) {
			throw new InvalidInputException("Username should contain atleast 8 alphanumeric characters");
			
		}
		else if(repository.existsById(userId))
			throw new InvalidInputException("User with Id ["+userId+"] already exists");
		else
			return true;	
	}

	/*******************************************************************
	 -FunctionName          : validatePassword
	 -Input Parameters      : String password
	 -Return Type           : boolean
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public boolean validatePassword(String password) {
		String regex="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
		if(password.matches(regex)) {
			return true;
		}
		else 
			throw new InvalidInputException("Password should contain:- "
					+ "[uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,"
					+ "should contain atleast 8 characters]");
	
	}

	
	/*******************************************************************
	 -FunctionName          : validateEmail
	 -Input Parameters      : String email
	 -Return Type           : boolean
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	
	
	
	@Override
	public boolean validateEmail(String email) {
		
	      String regex = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,4}";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidInputException("Email Id NOT valid");	
	}

	
	/*******************************************************************
	 -FunctionName          : validatePhoneNumber
	 -Input Parameters      : Long phoneNumber
	 -Return Type           : boolean
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	
	
	@Override
	public boolean validatePhoneNumber(Long phoneNumber) {
		String s=Long.toString(phoneNumber);
		if(!(s.length()==10 && s.charAt(0)!=0)) {
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;		
		
	}

	
	/*******************************************************************
	 -FunctionName          : deleteProductMaster
	 -Input Parameters      : String userId
	 -Return Type           :      -
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public void deleteProductMaster(String userId) {
		if(repository.existsById(userId)) {
			repository.deleteById(userId);
			}
		else {
				throw new ProductNotFoundException("Product Id does not exist !");
			}
		
		
	}

	/*******************************************************************
	 -FunctionName          : getAllProductMaster
	 -Input Parameters      :      -
	 -Return Type           : List<ProductMaster>
	 -Author				: Sakshi Kapurkar
	 -Creation Date			: 22/09/2020
	*********************************************************************/
	
	@Override
	public List<ProductMaster> getAllProductMaster() {
		List<ProductMaster> p = repository.findAll();
		
		if(p.isEmpty()) {
			throw new NullPointerException("The List is Empty !!");
		}
		else {
		
		return repository.findAll();
		}
		
	}

	


}
