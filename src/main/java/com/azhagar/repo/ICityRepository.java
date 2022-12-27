package com.azhagar.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.City;
import com.azhagar.entity.State;

public interface ICityRepository extends JpaRepository<City, Serializable> {

	List<City> findByState(State state);
	
}
