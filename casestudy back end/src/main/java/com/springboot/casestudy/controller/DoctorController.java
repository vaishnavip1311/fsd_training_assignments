package com.springboot.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.casestudy.model.Doctor;
import com.springboot.casestudy.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

}
