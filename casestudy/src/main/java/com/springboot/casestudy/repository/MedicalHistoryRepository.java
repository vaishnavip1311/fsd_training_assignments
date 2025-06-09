package com.springboot.casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.casestudy.dto.MedicalHistoryDTO;
import com.springboot.casestudy.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer>{
	
	@Query("select m from MedicalHistory m where m.patient.id=?1")
	List<MedicalHistoryDTO> findMedicalHistoryByPatientId(int patientId);

}
