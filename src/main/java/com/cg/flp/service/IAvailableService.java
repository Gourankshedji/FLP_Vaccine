package com.cg.flp.service;

import java.util.List;

import com.cg.flp.entities.Appointment;
import com.cg.flp.entities.Available;
import com.cg.flp.exception.AppointmentNotFoundException;
import com.cg.flp.exception.AvailabilityNotFoundException;


public interface IAvailableService {

	public Available addAvailability(Available available);
	public Available updateAvailability(Available available) throws AvailabilityNotFoundException;
	public Available cancelAvailable(int availableId)  throws AvailabilityNotFoundException;
	public List<Available> getAvailable() throws AvailabilityNotFoundException;
}
