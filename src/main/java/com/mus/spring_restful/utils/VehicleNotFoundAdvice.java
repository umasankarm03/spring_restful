package com.mus.spring_restful.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VehicleNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(VehicleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String VehicleNotFoundHandler(VehicleNotFoundException ex) {
		
		return ex.getMessage();
		
	}

}
