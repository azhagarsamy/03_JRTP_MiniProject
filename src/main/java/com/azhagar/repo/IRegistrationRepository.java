package com.azhagar.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.UserRegistration;

public interface IRegistrationRepository extends JpaRepository<UserRegistration, Serializable> {
	
//	@Query("select u from UserRegistration  where email=:email")
	Optional<UserRegistration> findByEmail(String email);

}
