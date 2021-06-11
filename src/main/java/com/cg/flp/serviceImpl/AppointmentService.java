package com.cg.flp.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flp.controller.AppointmentController;
import com.cg.flp.entities.Appointment;
import com.cg.flp.exception.AppointmentExistsException;
import com.cg.flp.exception.AppointmentNotFoundException;
import com.cg.flp.repository.IAppointmentRepository;
import com.cg.flp.service.IAppointmentService;

@Service
@Transactional

public class AppointmentService implements IAppointmentService {
	@Autowired
	IAppointmentRepository repository;
	Logger logger=LoggerFactory.getLogger(AppointmentService.class);

	@Override
	public Appointment bookAppointment(Appointment appointment) throws AppointmentExistsException {
		logger.debug("Appointment Service is implementing book appointment method");

	if(repository.existsById(appointment.getAppointmentId())) {
		logger.error("AppointmentExistsException thrown");

		throw new AppointmentExistsException("Appointments Id already exists");
	}
	
	Appointment appointmentData =repository.save(appointment);
	logger.info("New Appointment Booked");


		return appointmentData;
}	

	@Override
	public Appointment cancelAppointment(int appointmentId) throws AppointmentNotFoundException {
		logger.debug("Appointment Service is implementing cancel appointment method");

		if(!repository.existsById(appointmentId)) {
			logger.error("AppointmentNotFoundException thrown");

			 throw new AppointmentNotFoundException("Appointments is not available with the given booking ID" +appointmentId);
			 }
			 repository.deleteById(appointmentId);
				logger.info(" Appointment Cancelled");

			return null;
	}
	@Override
	public List<Appointment> getAppointment() throws AppointmentNotFoundException {
		logger.debug("Appointment Service is implementing view appointment method");

		List<Appointment> bookingList = repository.findAll();
		if(bookingList.isEmpty()){
			logger.error("AppointmentNotFoundException thrown");

			throw new AppointmentNotFoundException("Appointments Database is empty");
		}
		else
			logger.info(" Appointment List Displayed");

			return bookingList;	}

}
