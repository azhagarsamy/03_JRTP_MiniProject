package com.azhagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.entity.Country;
import com.azhagar.repo.ICountryRespository;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private ICountryRespository  repo;
	
	@Override
	public List<Country> getCountries() {
		return repo.findAll();
	}

}
