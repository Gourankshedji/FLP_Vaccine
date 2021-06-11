package com.cg.flp.service;

import java.util.List;

import javax.validation.Valid;

import com.cg.flp.entities.Appointment;
import com.cg.flp.exception.AppointmentExistsException;
import com.cg.flp.exception.AppointmentNotFoundException;



public interface IAppointmentService {

	
	public Appointment bookAppointment(Appointment booking) throws AppointmentExistsException;
	public Appointment cancelAppointment(int appointmentId)  throws AppointmentNotFoundException;
	public List<Appointment> getAppointment() throws AppointmentNotFoundException;
}
