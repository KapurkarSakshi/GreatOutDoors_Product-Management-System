package com.capgemini.go.pms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException  extends RuntimeException{
	

	public ProductNotFoundException(String msg){
        super(msg);
    }

}
