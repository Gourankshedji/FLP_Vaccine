package com.cg.flp.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "appointment_master")

public class Appointment {
	@Id
	@GeneratedValue
	private int appointmentId;

	@NotEmpty(message = "Enter your 12 digit Adhar Number")
	@Length(min = 12, max = 12, message = "The Adhar Number should have exact 12 digits")
	private String adharNo;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "hospitalId")
	private Hospital hospital;
	private String gender;
	@NotNull(message = "Enter Date of Birth")
	@Past(message = "Enter Past date")
	private LocalDate dob;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "vaccineId")
	private Vaccine vaccineId;

	public Appointment() {
		super();
	}

	public Appointment(String adharNo, Hospital hospital, String gender, LocalDate dob, Vaccine vaccineId) {
		super();
		this.adharNo = adharNo;
		this.hospital = hospital;
		this.gender = gender;
		this.dob = dob;

		this.vaccineId = vaccineId;
	}

	public Appointment(int appointmentId, String adharNo, Hospital hospital, String gender, LocalDate dob,
			Vaccine vaccineId) {
		super();
		this.appointmentId = appointmentId;
		this.adharNo = adharNo;
		this.hospital = hospital;
		this.gender = gender;
		this.dob = dob;

		this.vaccineId = vaccineId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Vaccine getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Vaccine vaccineId) {
		this.vaccineId = vaccineId;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", adharNo=" + adharNo + ", hospitalId=" + hospital
				+ ", gender=" + gender + ", dob=" + dob + ", vaccineId=" + vaccineId + "]";
	}

}
