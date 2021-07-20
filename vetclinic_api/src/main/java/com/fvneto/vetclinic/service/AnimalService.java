package com.fvneto.vetclinic.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fvneto.vetclinic.model.Animal;
import com.fvneto.vetclinic.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public Animal atualizar(Long codigo, Animal animal) {

		Animal animalSalvo = this.animalRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		BeanUtils.copyProperties(animal, animalSalvo, "codigo");

		return this.animalRepository.save(animalSalvo);
	}

}