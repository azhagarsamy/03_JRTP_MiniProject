package com.azhagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.entity.City;
import com.azhagar.entity.State;
import com.azhagar.repo.ICityRepository;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	private ICityRepository repo;

	@Override
	public List<City> getCities(State state) {
		return repo.findByState(state);
	}

}
