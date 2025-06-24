package com.springboot.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.casestudy.service.PatientLabService;

@RestController
@RequestMapping("/api/patient-lab")
public class PatientLabController {
	
	@Autowired
	private PatientLabService patientLabService;
	
	@GetMapping("/get-floor/{patientId}")
	public ResponseEntity<?> getFloorByPatient(@PathVariable int patientId){
		return patientLabService.getFloorByPatient(patientId);
	}
	

}
