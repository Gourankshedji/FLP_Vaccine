package com.cg.flp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flp.entities.Vaccine;
import com.cg.flp.repository.IVaccineRepository;
import com.cg.flp.service.IVaccineService;

@SpringBootTest
public class VaccineTest {
	@Autowired
	IVaccineService service;
	
	@MockBean
	private IVaccineRepository repository;
	public Vaccine getVaccine(){
		Vaccine vaccine=new Vaccine(1,"CoviShield");
		return vaccine;
		
	}
	public List<Vaccine> getVaccineList(){
		List<Vaccine> testVaccineList=new ArrayList<Vaccine>();
testVaccineList.add(new Vaccine(1,"CoviShield"));
testVaccineList.add(new Vaccine(2,"Sputnik V"));
return testVaccineList;
	}
	
	@Test
	void addVaccine() {
		Vaccine vaccineData=getVaccine();
		Mockito.when(repository.existsByTypeofVaccine(vaccineData.getTypeofVaccine())).thenReturn(false);
		Mockito.when(repository.save(vaccineData)).thenReturn(vaccineData);
		Vaccine res = service.addVaccine(vaccineData);
		assertEquals(res.getTypeofVaccine(), vaccineData.getTypeofVaccine());
	}
	
	@Test
	void testViewVaccineList() {

		List<Vaccine> vaccineList = getVaccineList();

		Mockito.when(repository.findAll()).thenReturn(vaccineList);
		assertEquals(2, service.getVaccineList().size());
	}
	
}
