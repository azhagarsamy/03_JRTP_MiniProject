package com.azhagar.service;

import java.util.List;

import com.azhagar.entity.City;
import com.azhagar.entity.State;

public interface ICityService {
	
	List<City> getCities(State state);

}
