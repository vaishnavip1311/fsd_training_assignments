package com.springboot.casestudy.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.casestudy.model.Patient;
import com.springboot.casestudy.model.User;
import com.springboot.casestudy.repository.PatientDoctorRepository;
import com.springboot.casestudy.repository.PatientRepository;

@Service
public class PatientService {
	
	private PatientRepository patientRepository;
	private PatientDoctorRepository patientDoctorRepository;
	private UserService userService;
	
	public PatientService(PatientRepository patientRepository, PatientDoctorRepository patientDoctorRepository,
			UserService userService) {
		super();
		this.patientRepository = patientRepository;
		this.patientDoctorRepository = patientDoctorRepository;
		this.userService = userService;
	}


	public Patient addPatient(Patient patient) {
		User user = patient.getUser();
		user.setRole("PATIENT");
		userService.signUp(user);
		patient.setUser(user);
		return patientRepository.save(patient);
	}




}
