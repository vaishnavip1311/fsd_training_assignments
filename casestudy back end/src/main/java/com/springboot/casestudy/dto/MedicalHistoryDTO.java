package com.springboot.casestudy.dto;

import com.springboot.casestudy.model.Patient;

public class MedicalHistoryDTO {
	
	private String illness;
    private int numberOfYears;
    private String currentMedication;
    private Patient patient;

    public String getIllness() {
		return illness;
	}
    
	public void setIllness(String illness) {
		this.illness = illness;
	}

	public int getNumOfYears() {
		return numberOfYears;
	}

	public void setNumOfYears(int numOfYears) {
		this.numberOfYears = numOfYears;
	}

	public String getCurrentMedication() {
		return currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public MedicalHistoryDTO(String illness, int numberOfYears, String currentMedication,Patient patient) {
        this.illness = illness;
        this.numberOfYears = numberOfYears;
        this.currentMedication = currentMedication;
        this.patient = patient;
    }

}
