package com.springboot.casestudy.dto;

import org.springframework.stereotype.Component;

public class MedicalHistoryDTO {
	
	private String illness;
    private int numberOfYears;
    private String currentMedication;
    

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

	public MedicalHistoryDTO(String illness, int numberOfYears, String currentMedication) {
        this.illness = illness;
        this.numberOfYears = numberOfYears;
        this.currentMedication = currentMedication;
    }

}
