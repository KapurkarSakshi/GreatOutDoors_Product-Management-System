package com.capgemini.go.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.go.pms.model.Product;

@Repository
public interface IProductDao extends JpaRepository<Product,String>{

}
