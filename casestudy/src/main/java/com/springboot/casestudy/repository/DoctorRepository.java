package com.springboot.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.casestudy.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
