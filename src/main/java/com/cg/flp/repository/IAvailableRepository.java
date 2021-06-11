package com.cg.flp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flp.entities.Available;

@Repository
public interface IAvailableRepository extends JpaRepository<Available, Integer> {

}
