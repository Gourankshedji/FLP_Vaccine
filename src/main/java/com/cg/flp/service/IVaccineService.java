package com.cg.flp.service;

import java.util.List;

import com.cg.flp.entities.Vaccine;
import com.cg.flp.exception.VaccineExistsException;
import com.cg.flp.exception.VaccineNotFoundException;


public interface IVaccineService {
	
	public Vaccine addVaccine(Vaccine vacc) throws VaccineExistsException;
	public List<Vaccine> getVaccineList() throws VaccineNotFoundException;
}
