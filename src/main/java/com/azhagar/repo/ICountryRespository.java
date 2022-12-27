package com.azhagar.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.Country;

public interface ICountryRespository extends JpaRepository<Country, Serializable> {

}
