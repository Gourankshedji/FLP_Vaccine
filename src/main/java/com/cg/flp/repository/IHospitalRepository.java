package com.cg.flp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flp.entities.Hospital;


public interface IHospitalRepository extends JpaRepository<Hospital, Integer> {
	
	

}
