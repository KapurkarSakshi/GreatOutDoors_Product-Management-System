/****************************
 -Author                : Sakshi Kapurkar
 -Created/Modified Date : 22/09/2020
 -Description           : IProductMasterService interface for Product Management System
*****************************/

package com.capgemini.go.pms.service;

import java.util.List;

import com.capgemini.go.pms.model.ProductMaster;

public interface IProductMasterService {
	
	 public ProductMaster addProductMaster(ProductMaster productMaster) ;
	 public void deleteProductMaster(String userId);
	 public  List<ProductMaster> getAllProductMaster();
	 
	 
	 public boolean validateUserId(String userId);
	 public boolean validatePassword(String password);
	 public boolean validatePhoneNumber(Long phoneNumber);
	 public boolean validateEmail(String email);
	

}
