package com.cg.flp;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cg.flp.entities.Hospital;
import com.cg.flp.repository.IHospitalRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
@TestMethodOrder(OrderAnnotation.class) 
public class AppointmentTest1 {
	@Autowired
	IHospitalRepository repository;
	
//	@Test
//	@Rollback(false)
//	@Order(1)
//	public void testaddHospital(){
//		
//		Hospital hospitalData = repository.save(new Hospital(1,"Sevasadan", "2220066", "Sangli", "416410"));
//		assertThat(hospitalData.getHospitalId()).isGreaterThan(0);
//	}
//	@Test
//	@Rollback(false)
//	@Order(2)
//	public void testViewAllHospitals() {
//		List<Hospital> hospitalList = repository.findAll();
//		assertThat(hospitalList.size()).isGreaterThan(0);
//	}
	
}
