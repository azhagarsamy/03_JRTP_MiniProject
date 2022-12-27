package com.azhagar.service;

import java.util.List;

import com.azhagar.entity.Country;
import com.azhagar.entity.State;

public interface IStateService {
	
	List<State> getStates(Country country);

}
