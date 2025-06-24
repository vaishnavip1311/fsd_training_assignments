package com.springboot.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.casestudy.model.Patient;
import com.springboot.casestudy.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	

}
