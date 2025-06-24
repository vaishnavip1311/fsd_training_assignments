package com.springboot.casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.casestudy.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	@Query("select p from Patient p where p.user.username=?1")
	Patient  findPatientByUsername(String username);

	

}
