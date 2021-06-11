package com.cg.flp.controller;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flp.entities.Vaccine;
import com.cg.flp.exception.VaccineExistsException;
import com.cg.flp.exception.VaccineNotFoundException;
import com.cg.flp.service.IVaccineService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("Vaccine/vaccine")
public class VaccineController {

	@Autowired
	IVaccineService service;
	Logger logger=LoggerFactory.getLogger(VaccineController.class);

	@PostMapping("/addVaccine")
	public ResponseEntity<Object>addVaccine(@RequestBody Vaccine vaccine) throws VaccineExistsException{
		logger.debug("VaccineController is executing addVaccine ");

		Vaccine vaccineData;
		try {
			vaccineData=service.addVaccine(vaccine);
			return new ResponseEntity<Object>(vaccineData,HttpStatus.OK);
		}
		catch (VaccineExistsException e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/selectAll")
	public ResponseEntity<Object>selectAllVaccine()throws VaccineNotFoundException{
		logger.debug("VaccineController is executing View All Available Vaccines ");

		List<Vaccine> vaccineList;
		try {
			vaccineList=service.getVaccineList();
			return new ResponseEntity<Object>(vaccineList,HttpStatus.OK);
		}
		catch (VaccineNotFoundException e) {
			// TODO: handle exception\
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);

		}
	}
	
	
}
