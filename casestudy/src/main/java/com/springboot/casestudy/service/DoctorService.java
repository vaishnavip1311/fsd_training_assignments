package com.springboot.casestudy.service;

import org.springframework.stereotype.Service;

import com.springboot.casestudy.model.Doctor;
import com.springboot.casestudy.model.User;
import com.springboot.casestudy.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private DoctorRepository doctorRepository;
	private UserService userService;

	public DoctorService(DoctorRepository doctorRepository, UserService userService) {
		super();
		this.doctorRepository = doctorRepository;
		this.userService = userService;
	}


	public Doctor addDoctor(Doctor doctor) {
		
		//fetch user from doctor
		User user = doctor.getUser();
		// set role as DOCTOR
		user.setRole("DOCTOR");
		//add user to db 
		userService.signUp(user);
		//add user to doctor again
		doctor.setUser(user);
		// save doctor in db
		return doctorRepository.save(doctor);
	}

}
