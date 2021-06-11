package com.cg.flp.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flp.controller.AppointmentController;
import com.cg.flp.entities.Vaccine;
import com.cg.flp.exception.VaccineExistsException;
import com.cg.flp.exception.VaccineNotFoundException;
import com.cg.flp.repository.IVaccineRepository;
import com.cg.flp.service.IVaccineService;

@Service
@Transactional
public class VaccineService implements IVaccineService {

	@Autowired
	IVaccineRepository repository;
	Logger logger=LoggerFactory.getLogger(VaccineService.class);

	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineExistsException{
		logger.debug("Vaccine Service is implementing add vaccine method");

		// TODO Auto-generated method stub
		//if(repository.existsById(vaccine.getVaccineId())) 
		if(repository.existsByTypeofVaccine(vaccine.getTypeofVaccine())){
			logger.error("VaccineExistsException thrown");

			throw new VaccineExistsException("Vaccine is already Exists");
		}
		Vaccine vaccineData=repository.save(vaccine);
		logger.info("New Vaccine Added");

		return vaccineData;
	}

	@Override
	public List<Vaccine> getVaccineList() throws VaccineNotFoundException {
		logger.debug("Vaccine Service is implementing show vaccine method");

		// TODO Auto-generated method stub
		List<Vaccine>vaccineList=repository.findAll();
		if(vaccineList.isEmpty()) {
			logger.error("VaccineNotFoundException thrown");

			throw new VaccineNotFoundException("Vaccine database is empty");
		}
		else 
			logger.info("Vaccine List Displayed");

			
		return vaccineList;
	}

}
