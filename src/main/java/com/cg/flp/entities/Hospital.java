package com.cg.flp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

//Declare the class a entity
@Entity

//Declare the table name
@Table(name="hospitals")

public class Hospital {
	
	//attributes
	@Id
	@GeneratedValue // generates an automatic value during commit for every new entity
	private int hospitalId;
	
	private String hospitalName;
	
	private String hospitalContact;
	private String cityName;
	private String pincode;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="availableId")
	private Available available;
	
	
	
	
	
	//default constructor
	public Hospital() {
		super();
	}





	public Hospital(String hospitalName, String hospitalContact, String cityName, String pincode, Available available) {
		super();
		this.hospitalName = hospitalName;
		this.hospitalContact = hospitalContact;
		this.cityName = cityName;
		this.pincode = pincode;
		this.available = available;
	}





	public Hospital(int hospitalId, String hospitalName, String hospitalContact, String cityName, String pincode,
			Available available) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalContact = hospitalContact;
		this.cityName = cityName;
		this.pincode = pincode;
		this.available = available;
	}





	public int getHospitalId() {
		return hospitalId;
	}





	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}





	public String getHospitalName() {
		return hospitalName;
	}





	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}





	public String getHospitalContact() {
		return hospitalContact;
	}





	public void setHospitalContact(String hospitalContact) {
		this.hospitalContact = hospitalContact;
	}





	public String getCityName() {
		return cityName;
	}





	public void setCityName(String cityName) {
		this.cityName = cityName;
	}





	public String getPincode() {
		return pincode;
	}





	public void setPincode(String pincode) {
		this.pincode = pincode;
	}





	public Available getAvailable() {
		return available;
	}





	public void setAvailable(Available available) {
		this.available = available;
	}





	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalContact="
				+ hospitalContact + ", cityName=" + cityName + ", pincode=" + pincode + ", available=" + available
				+ "]";
	}
	
	
}
