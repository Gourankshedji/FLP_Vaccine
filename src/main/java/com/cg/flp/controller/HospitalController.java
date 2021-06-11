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

import com.cg.flp.entities.Available;
import com.cg.flp.entities.Hospital;
import com.cg.flp.exception.AvailabilityNotFoundException;
import com.cg.flp.exception.HospitalException;
import com.cg.flp.service.IHospitalService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/covidVaccination/hospital")

public class HospitalController {

	@Autowired
	IHospitalService hospitalservice;
	
	Logger logger = LoggerFactory.getLogger(HospitalController.class);

	// Method to add hospital
	@PostMapping("/addHospital")
	public ResponseEntity<Hospital> addHospital(@Valid @RequestBody Hospital hospital) {

		Hospital hospitalData = hospitalservice.addHospital(hospital);
		if (hospitalData == null) {
			logger.error("Controller: Failed to add hospital");
			throw new HospitalException("hospital not added");
		}
		logger.info("*** Controller : hospital added successfully. ***");
		return new ResponseEntity<Hospital>(hospitalData, HttpStatus.OK);

	}
	
	// Method to get all hospital
		@GetMapping("/getHospitalList")
		public ResponseEntity<List<Hospital>> selectAllHospital() {
			List<Hospital> hospitalList = hospitalservice.getHospitalList();

			if (hospitalList.size() == 0) {
				logger.error("Controller: hospital not found.");
				throw new HospitalException("No Hospitals in the database ");
			}

			logger.info("*** Controller : Displaying hospital list. ***");
			return new ResponseEntity<List<Hospital>>(hospitalList, HttpStatus.OK);
		}
		@DeleteMapping("/cancelHospital/{hospitalId}")
		public ResponseEntity<Object> cancelHospital(@PathVariable int hospitalId){
			logger.debug("HospitalContyroller is executing delete Hospital ");


			Hospital hospitalData;
			try {
				hospitalData = hospitalservice.cancelHospital(hospitalId);
				return new ResponseEntity<Object>(hospitalData, HttpStatus.OK);
			
			} catch (HospitalException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
			return new ResponseEntity<Object>("No Hospitals found in DataBase with given ID",HttpStatus.UNAUTHORIZED);
		}
	
		
		
}
