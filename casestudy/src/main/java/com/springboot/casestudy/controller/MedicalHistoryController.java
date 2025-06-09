package com.springboot.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.casestudy.model.MedicalHistory;
import com.springboot.casestudy.service.MedicalHistoryService;

@RestController
@RequestMapping("/api/medical-history")
public class MedicalHistoryController {
	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@PostMapping("/add-patient")
	public MedicalHistory addPatientWithMedicalHistory(@RequestBody MedicalHistory medicalHistory) {	
		return medicalHistoryService.addPatientWithMedicalHistory(medicalHistory);
	}

	@GetMapping("/get-patient/{patientIid}")
	public ResponseEntity<?> getPatientWithMedicalHistory(@PathVariable int patientIid) {
		return medicalHistoryService.getPatientWithMedicalHistory(patientIid);
	}

}
