package com.springboot.casestudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.casestudy.exception.ResourceNotFoundException;
import com.springboot.casestudy.model.Doctor;
import com.springboot.casestudy.model.Patient;
import com.springboot.casestudy.model.PatientDoctor;
import com.springboot.casestudy.repository.DoctorRepository;
import com.springboot.casestudy.repository.PatientDoctorRepository;
import com.springboot.casestudy.repository.PatientRepository;

@Service
public class PatientDoctorService {
	
	private PatientDoctorRepository patientDoctorRepository;
	private PatientRepository patientRepository;
	private DoctorRepository doctorRepository;

	public PatientDoctorService(PatientDoctorRepository patientDoctorRepository, PatientRepository patientRepository,
			DoctorRepository doctorRepository) {
		super();
		this.patientDoctorRepository = patientDoctorRepository;
		this.patientRepository = patientRepository;
		this.doctorRepository = doctorRepository;
	}


	public PatientDoctor makeAppointment(PatientDoctor patientDoctor,int patientId, int doctorId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Id is invalid"));
		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(()-> new ResourceNotFoundException("Id is invalid"));
		
		patientDoctor.setDoctor(doctor);
		patientDoctor.setPatient(patient);
		
		return patientDoctorRepository.save(patientDoctor);
	}
	
	public List<Patient> getAllPatientsByDoctorId(int doctorId) {
		return patientDoctorRepository.getAllPatientsByDoctorId(doctorId);
	}
	

}
