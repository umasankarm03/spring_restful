package com.mus.spring_restful.utils;

public class VehicleNotFoundException extends RuntimeException{

	public VehicleNotFoundException(Long id) {
	    super("Could not find vehicle " + id);
	  }
}
