package com.springboot.casestudy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface PatientLabRepository {

	@Query("select  pl.Lab.floor from PatientLab pl where pl.patient.id=?1" )
	ResponseEntity<?> getFloorByPatient(int patientId);

}
