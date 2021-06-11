package com.cg.flp.service;

import java.util.List;

import com.cg.flp.entities.Hospital;
import com.cg.flp.exception.HospitalException;


public interface IHospitalService {
	
	public Hospital addHospital(Hospital bean);
	//public boolean addHospital(Hospital hosp);
	//public List<Hospital> getHospitalList();
	public List<Hospital> getHospitalList();
	public Hospital cancelHospital(int hospitalId)  throws HospitalException;



}
