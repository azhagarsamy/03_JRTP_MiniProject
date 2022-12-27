package com.azhagar.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usr_rgtrton_tbl")
@Data
@NoArgsConstructor
public class UserRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	
	private String uFirstName;
	
	private String uLastName;
	
	private String email;
	
	private Long phNo;
	
	private Date dob;
	
	private String gender;

	private Integer cityId;
	
	private String pwd;
	
	private String isAccutActvd;
	
	
}
