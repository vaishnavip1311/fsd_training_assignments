package com.springboot.casestudy.service;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.casestudy.dto.MedicalHistoryDTO;
import com.springboot.casestudy.model.MedicalHistory;
import com.springboot.casestudy.model.Patient;
import com.springboot.casestudy.repository.MedicalHistoryRepository;
import com.springboot.casestudy.repository.PatientRepository;

@Service
public class MedicalHistoryService {

    private PatientService patientService;
	private MedicalHistoryRepository medicalHistoryRepository;
	private PatientRepository patientRepository;


	public MedicalHistoryService(PatientService patientService, MedicalHistoryRepository medicalHistoryRepository,
			PatientRepository patientRepository) {
		super();
		this.patientService = patientService;
		this.medicalHistoryRepository = medicalHistoryRepository;
		this.patientRepository = patientRepository;
	}



	public MedicalHistory addPatientWithMedicalHistory(MedicalHistory medicalHistory) {
		//fetch patient from medical history
		Patient patient = medicalHistory.getPatient();

		//check patient already present
		Patient patientcheck = patientRepository.findPatientByUsername(patient.getUser().getUsername());
		if(patientcheck != null) {
			patient.setId(patientcheck.getId());
			medicalHistory.setPatient(patient);
		}
		else {
			patient = patientService.addPatient(patient);
			medicalHistory.setPatient(patient);
		}
		
		return medicalHistoryRepository.save(medicalHistory);
	}



	public ResponseEntity<?> getPatientWithMedicalHistory(int patientIid) {
		
		List<MedicalHistoryDTO> dtoList = medicalHistoryRepository.findMedicalHistoryByPatientId(patientIid);
		return ResponseEntity.ok(dtoList);
	}
	
	

}
