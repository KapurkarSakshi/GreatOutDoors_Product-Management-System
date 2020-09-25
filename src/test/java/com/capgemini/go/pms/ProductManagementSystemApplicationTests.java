package com.capgemini.go.pms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.go.pms.exceptions.ProductNotFoundException;
import com.capgemini.go.pms.model.Product;
import com.capgemini.go.pms.repository.IProductDao;
import com.capgemini.go.pms.repository.IProductMasterDao;
import com.capgemini.go.pms.service.IProductMasterService;
import com.capgemini.go.pms.service.IProductService;


@SpringBootTest
class ProductManagementSystemApplicationTests {

	@Autowired
	IProductDao repository;
		
	@Autowired
	IProductService service;
	
	@Autowired
	IProductMasterService pmService;
	
	Product product1= new Product("101B","Iphone",75000.17,"Crystal Black",1,1,"It is a SmartPhone.","10'6","Apple company");

	@Test
	void testProductById() throws ProductNotFoundException {
//		Boolean product= repository.existsById("101A");
//		assertNotNull(product);
		assertEquals(true, repository.existsById("101A"));
	}
		
	@Test
	void testNotProductById() throws ProductNotFoundException  {
		assertEquals(false, repository.existsById("101R"));
	}
	
	@Test
	void testList() throws Exception{
		List<Product> productList= repository.findAll();
		assertNotNull(productList);
	}

	@Test
	public void testValidProductld() {
	assertEquals(true, service.validateProductId("101A"));
	}
	
	
	@Test
	public void testValidUserld() {
		assertEquals(true, pmService.validateUserId("ProductMaster20"));
		}
	

	@Test
	public void testValidPassword() {
	
		assertEquals(true, pmService.validatePassword("Password@12"));
		}

	@Test
	public void testValidEmail() {
		assertTrue(pmService.validateEmail("kapurkar@gmail.com"));
		}
	

	@Test
	public void testValidPhoneNo() {
		assertEquals(true, pmService.validatePhoneNumber(9640907428l));
		}
	
	
}
	



