package com.mus.spring_restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mus.spring_restful.dao.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
