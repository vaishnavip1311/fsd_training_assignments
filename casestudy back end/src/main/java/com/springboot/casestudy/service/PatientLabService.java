package com.springboot.casestudy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.casestudy.exception.ResourceNotFoundException;
import com.springboot.casestudy.repository.PatientLabRepository;
import com.springboot.casestudy.repository.PatientRepository;

@Service
public class PatientLabService {
	
	private PatientLabRepository patientLabRepository;
	private PatientRepository patientRepository;

	public PatientLabService(PatientLabRepository patientLabRepository, PatientRepository patientRepository) {
		super();
		this.patientLabRepository = patientLabRepository;
		this.patientRepository = patientRepository;
	}

	public ResponseEntity<?> getFloorByPatient(int patientId) {
		patientRepository.findById(patientId)
		.orElseThrow(()-> new ResourceNotFoundException("Patient not found"));
		
		return patientLabRepository.getFloorByPatient(patientId);
	}

}
