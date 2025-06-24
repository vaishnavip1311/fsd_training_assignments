package com.springboot.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.casestudy.model.Patient;
import com.springboot.casestudy.model.PatientDoctor;
import com.springboot.casestudy.service.PatientDoctorService;

@RestController
@RequestMapping("/api/patient-doctor")
public class PatientDoctorController {
	
	@Autowired
	private PatientDoctorService patientDoctorService;
	
	@PostMapping("/add-appointment/{patientId}/{doctorId}")
	public PatientDoctor makeAppointment(@RequestBody PatientDoctor patientDoctor,
			@PathVariable int patientId,
			@PathVariable int doctorId) {
		
		return patientDoctorService.makeAppointment(patientDoctor,patientId,doctorId);
		
	}
	
	@GetMapping("/get-all/patient/{doctorId}")
	public List<Patient> getAllPatientsByDoctorId(@PathVariable int doctorId){
		return patientDoctorService.getAllPatientsByDoctorId(doctorId);
	}

}
