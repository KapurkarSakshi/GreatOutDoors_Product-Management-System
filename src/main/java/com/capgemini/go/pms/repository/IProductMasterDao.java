package com.capgemini.go.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.go.pms.model.ProductMaster;

@Repository
public interface IProductMasterDao extends JpaRepository<ProductMaster,String> {

}
