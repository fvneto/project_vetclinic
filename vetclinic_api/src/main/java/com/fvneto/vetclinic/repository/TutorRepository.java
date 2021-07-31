package com.fvneto.vetclinic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fvneto.vetclinic.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

	@Query("SELECT obj FROM Tutor obj WHERE LOWER(obj.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
	Page<Tutor> searchName(String nome, Pageable pageable);
	
}
