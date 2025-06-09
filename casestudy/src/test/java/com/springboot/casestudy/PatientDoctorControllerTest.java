package com.springboot.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.casestudy.model.Patient;
import com.springboot.casestudy.repository.PatientDoctorRepository;
import com.springboot.casestudy.repository.PatientRepository;
import com.springboot.casestudy.service.PatientDoctorService;

@SpringBootTest
public class PatientDoctorControllerTest {
	
	@InjectMocks
    private PatientDoctorService patientDoctorService;
    @Mock
    private PatientRepository patientRepository;
    @Mock
    private PatientDoctorRepository patientDoctorRepository;

    private Patient patient;

    @BeforeEach
    public void init(){
        patient = new Patient();
        patient.setName("Patient");
        patient.setAge(20);
    }

    @Test
    public void getPatientsByDoctorTest(){
        List<Patient> expected = List.of(patient);

        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        when(patientDoctorRepository.getAllPatientsByDoctorId(1)).thenReturn(expected);

        List<Patient> actual = patientDoctorService.getAllPatientsByDoctorId(1);

        assertEquals(expected, actual);

    }

    @AfterEach
    public void makeNull(){
        patient = null;
    }

}
