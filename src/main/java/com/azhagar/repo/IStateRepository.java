package com.azhagar.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.Country;
import com.azhagar.entity.State;

public interface IStateRepository extends JpaRepository<State, Serializable> {
	
	List<State> findByCountry(Country country);

	
}
