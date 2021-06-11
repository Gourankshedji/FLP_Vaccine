package com.cg.flp.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flp.entities.Appointment;
import com.cg.flp.entities.Available;
import com.cg.flp.exception.AppointmentExistsException;
import com.cg.flp.exception.AppointmentNotFoundException;
import com.cg.flp.exception.AvailabilityNotFoundException;
import com.cg.flp.repository.IAppointmentRepository;
import com.cg.flp.repository.IAvailableRepository;
import com.cg.flp.service.IAvailableService;



@Service
@Transactional
public class AvailableService implements IAvailableService {
	@Autowired
	IAvailableRepository repository;
	Logger logger=LoggerFactory.getLogger(AvailableService.class);

	@Override
	public Available addAvailability(Available available) {
		logger.debug("Available Service is implementing add availability method");

	
		
		Available availableData =repository.save(available);

		logger.info("New availability Added");

			return availableData;
	}	
	@Override
	public Available updateAvailability   (Available available) throws AvailabilityNotFoundException {
		logger.debug("Available Service is implementing update availability method");

		 available=repository.save(available);
		if(!repository.existsById(available.getAvailableId())) {
			logger.error("AvailabilityNotFoundException thrown");

			throw new AvailabilityNotFoundException("Availability not found" +available);
			}
		else
			logger.info(" availability Updated");

		 return available;
	}

	@Override
	public Available cancelAvailable(int availableId) throws AvailabilityNotFoundException {
		logger.debug("Available Service is implementing cancel availability method");

		if(!repository.existsById(availableId)) {
			logger.error("AvailabilityNotFoundException thrown");

			 throw new AppointmentNotFoundException("Available is not available with the given booking ID" +availableId);
			 }
			 repository.deleteById(availableId);
				logger.info(" availability Deleted");

			return null;
	}
	@Override
	public List<Available> getAvailable() throws AvailabilityNotFoundException {
		logger.debug("Available Service is implementing view all availability method");

		List<Available> availableList = repository.findAll();
		if(availableList.isEmpty()){
			logger.error("AvailabilityNotFoundException thrown");

			throw new AvailabilityNotFoundException("Available Database is empty");
		}
		else
			logger.info(" availability List Displayed");

			return availableList;	
		}
}
