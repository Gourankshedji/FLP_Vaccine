package com.cg.flp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccine_master")
public class Vaccine {

	
	@Id
	@GeneratedValue
	private int vaccineId;
	
	private String typeofVaccine;
	
	public Vaccine() {
		super();
	}

	public Vaccine(String typeofVaccine) {
		super();
		this.typeofVaccine = typeofVaccine;
	}

	public Vaccine(int vaccineId, String typeofVaccine) {
		super();
		this.vaccineId = vaccineId;
		this.typeofVaccine = typeofVaccine;
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getTypeofVaccine() {
		return typeofVaccine;
	}

	public void setTypeofVaccine(String typeofVaccine) {
		this.typeofVaccine = typeofVaccine;
	}

	@Override
	public String toString() {
		return "Vaccine [vaccineId=" + vaccineId + ", typeofVaccine=" + typeofVaccine + "]";
	}
	
	
	
}
