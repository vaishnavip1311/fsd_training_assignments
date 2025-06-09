package com.springboot.casestudy.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.casestudy.model.Patient;
import com.springboot.casestudy.model.PatientDoctor;

public interface PatientDoctorRepository extends JpaRepository<PatientDoctor, Integer>{

	@Query("select p.patient from PatientDoctor p where p.doctor.id=?1")
	List<Patient> getAllPatientsByDoctorId(int doctorId);
}
