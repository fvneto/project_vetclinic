package com.fvneto.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fvneto.vetclinic.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

}
