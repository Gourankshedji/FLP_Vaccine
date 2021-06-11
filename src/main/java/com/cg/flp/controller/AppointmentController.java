package com.cg.flp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flp.entities.Appointment;
import com.cg.flp.exception.AppointmentExistsException;
import com.cg.flp.exception.AppointmentNotFoundException;
import com.cg.flp.service.IAppointmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("Vaccine/appointment")
public class AppointmentController {

	@Autowired
	IAppointmentService service;
	Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	@PostMapping("/bookAppointment")
	public ResponseEntity<Object> bookAppointment(@Valid @RequestBody Appointment appointment) {
		logger.debug("AppointmentController is executing bookAppointment ");

		Appointment appointmentData;
		try {
			appointmentData = service.bookAppointment(appointment);
			return new ResponseEntity<Object>(appointmentData, HttpStatus.OK);
		}

		catch (AppointmentExistsException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/cancelAppointment/{appointmentId}")
	public ResponseEntity<Object> cancelAppointment(@PathVariable int appointmentId) {
		logger.debug("AppointmentController is executing cancel Appointment ");

		Appointment appointmentData;
		try {
			appointmentData = service.cancelAppointment(appointmentId);
			return new ResponseEntity<Object>(appointmentData, HttpStatus.OK);

		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return new ResponseEntity<Object>("No Appointments found in DataBase with given ID", HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/selectAll")
	public ResponseEntity<Object> selectAllAppointment() {
		logger.debug("AppointmentController is executing view Appointment ");

		List<Appointment> appointmentList;
		try {
			appointmentList = service.getAppointment();
			return new ResponseEntity<Object>(appointmentList, HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new ResponseEntity<Object>("No Appointments found in DataBase", HttpStatus.NO_CONTENT);
	}
}
