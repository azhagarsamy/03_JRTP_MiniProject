package com.azhagar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="state_tbl")
@Data
@NoArgsConstructor
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer stateId;
	
	private String stateName;
	
	@ManyToOne
	@JoinColumn(name = "countryId")
	@JsonIgnore
	private Country country;
	
//	@OneToMany(mappedBy = "state",fetch = FetchType.LAZY)
//	@JsonIgnore
//	private List<City> cities;
	

}

