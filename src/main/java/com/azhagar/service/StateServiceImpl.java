package com.azhagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.entity.Country;
import com.azhagar.entity.State;
import com.azhagar.repo.IStateRepository;

@Service
public class StateServiceImpl implements IStateService {

	@Autowired
	private IStateRepository repo;
	
	@Override
	public List<State> getStates(Country country) {
		
		return repo.findByCountry(country);
	}

}
