package com.cg.flp.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flp.entities.Available;
import com.cg.flp.entities.Hospital;
import com.cg.flp.exception.AppointmentNotFoundException;
import com.cg.flp.exception.AvailabilityNotFoundException;
import com.cg.flp.exception.HospitalException;
import com.cg.flp.repository.IHospitalRepository;
import com.cg.flp.service.IHospitalService;

@Service
@Transactional

public class HospitalService implements IHospitalService {
	
	@Autowired
	IHospitalRepository repository;
	
	
	Logger logger = LoggerFactory.getLogger(HospitalService.class);
	
	@Override
	public Hospital addHospital(Hospital bean) {

		

		Hospital hospital = repository.save(bean);
		logger.info("*** Service :  Hospital added successfully. ***");
		return hospital;
	}

	@Override
	public List<Hospital> getHospitalList() {

		logger.info("*** Service : Displaying Hospital information ***");
		return repository.findAll();
	}
	@Override
	public Hospital cancelHospital(int hospitalId) throws HospitalException {
		logger.debug("Hospital Service is implementing cancel hospital method");

		if(!repository.existsById(hospitalId)) {
			logger.error("AvailabilityNotFoundException thrown");

			 throw new HospitalException("Hospital is not available with the given booking ID" +hospitalId);
			 }
			 repository.deleteById(hospitalId);
				logger.info(" hospital Deleted");

			return null;
	}
	
	

	
}
