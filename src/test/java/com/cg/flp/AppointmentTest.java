package com.cg.flp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flp.entities.Appointment;
import com.cg.flp.entities.Available;
import com.cg.flp.entities.Hospital;
import com.cg.flp.entities.Vaccine;
import com.cg.flp.exception.AppointmentExistsException;
import com.cg.flp.exception.AppointmentNotFoundException;
import com.cg.flp.repository.IAppointmentRepository;
import com.cg.flp.repository.IHospitalRepository;
import com.cg.flp.service.IAppointmentService;
import com.cg.flp.service.IHospitalService;
import com.cg.flp.serviceImpl.AppointmentService;



@SpringBootTest
public class AppointmentTest {
	@Autowired
	AppointmentService service;
	
	@MockBean
	private IAppointmentRepository repository;
	static LocalDate appointmentDate = LocalDate.now();
	static LocalDate dob=LocalDate.of(1999,10,30);
	static LocalDateTime time=LocalDateTime.now();
		     
	public Appointment getAppointment() {
		
		Available available=new Available(1,appointmentDate,time);
		Hospital hospital  = new Hospital(1, "Sevasadan","2220066", "Sangli", "416410",available);
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(hospital);
		Vaccine vaccine = new Vaccine(1, "CovieShield");
		Appointment appointment = new Appointment(1, "123123123123", hospital, "Male", dob, vaccine);
		return appointment;
	}
	
	public List<Appointment> getAppointmentList() {
		List<Appointment> testAppointmentList = new ArrayList<Appointment>();
		Available available=new Available(1,appointmentDate,time);

		Hospital hospital  = new Hospital(1, "Sevasadan","2220066", "Sangli", "416410",available);
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(hospital);
		Vaccine vaccine = new Vaccine(1, "CovieShield");
		testAppointmentList.add( new Appointment(1, "123123123123", hospital, "Male", dob, vaccine));
		testAppointmentList.add( new Appointment(1, "123126123123", hospital, "Female", dob, vaccine));
		return testAppointmentList;
	}
	@Test
	void testBookAppointment() {
		Appointment appointmentData = getAppointment();
		Mockito.when(repository.existsById(appointmentData.getAppointmentId())).thenReturn(false);
		Mockito.when(repository.save(appointmentData)).thenReturn(appointmentData);
		Appointment res = service.bookAppointment(appointmentData);
		assertEquals(res.getAppointmentId(), appointmentData.getAppointmentId());

	}
	
	@Test
	void testCancelAppointment() throws AppointmentNotFoundException {
		Appointment cancelAppointment = getAppointment();
		int appointmentId = cancelAppointment.getAppointmentId();
		Mockito.when(repository.existsById(appointmentId)).thenReturn(true);
		service.cancelAppointment(cancelAppointment.getAppointmentId());


	}
	@Test
	void testViewAppointmentList() throws AppointmentNotFoundException {

		List<Appointment> appointmentList = getAppointmentList();

		Mockito.when(repository.findAll()).thenReturn(appointmentList);
		assertEquals(2, service.getAppointment().size());
	}
	
}

/*
 * 
 */
