package com.fvneto.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fvneto.vetclinic.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
}