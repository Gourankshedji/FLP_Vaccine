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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flp.entities.Appointment;
import com.cg.flp.entities.Available;
import com.cg.flp.exception.AppointmentNotFoundException;
import com.cg.flp.exception.AvailabilityNotFoundException;
import com.cg.flp.service.IAvailableService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("Vaccine/available")
public class AvailableController {
	
	@Autowired
	IAvailableService service;
	Logger logger=LoggerFactory.getLogger(AvailableController.class);

	@PostMapping("/addAvailibility")
	public ResponseEntity<Object> addAvailibility(@Valid @RequestBody Available available ) {
		logger.debug("AvailableController is executing addAvalability ");


		Available availabletData;
		
			availabletData = service.addAvailability(available);
			return new ResponseEntity<Object>(availabletData, HttpStatus.OK);
		
	}
	@PutMapping("/updateAvailability")
	public ResponseEntity<Object> updateAvailability(@Valid @RequestBody Available available)  {
		logger.debug("AvailableController is executing updateAvalability ");

		Available availabletData = null;
		try {
			availabletData = service.updateAvailability(available);
			return new ResponseEntity<Object>(availabletData, HttpStatus.OK);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>("No Availaibility found in DataBase with given ID",HttpStatus.UNAUTHORIZED);
	}
	@DeleteMapping("/cancelAvailability/{availableId}")
	public ResponseEntity<Object> cancelAvailability(@PathVariable int availableId){
		logger.debug("AvailableController is executing deletedAvalability ");


		Available availabletData;
		try {
			availabletData = service.cancelAvailable(availableId);
			return new ResponseEntity<Object>(availabletData, HttpStatus.OK);
		
		} catch (AvailabilityNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return new ResponseEntity<Object>("No Appointments found in DataBase with given ID",HttpStatus.UNAUTHORIZED);
	}
	@GetMapping("/selectAll")
	public ResponseEntity<Object> selectAllAvailable() {
		logger.debug("AvailableController is executing view availability ");



		List<Available> availableList;
		try {
			availableList = service.getAvailable();
			return new ResponseEntity<Object>(availableList,HttpStatus.OK);
		}catch (AvailabilityNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new ResponseEntity<Object>("No Available found in DataBase",HttpStatus.NO_CONTENT);	
	}
}
