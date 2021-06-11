package com.cg.flp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flp.entities.Hospital;
import com.cg.flp.entities.Vaccine;
@Repository
public interface IVaccineRepository extends JpaRepository<Vaccine, String> {

	public boolean existsByTypeofVaccine(String typeofVaccine);

}
