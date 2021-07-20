package com.fvneto.vetclinic.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fvneto.vetclinic.model.Tutor;
import com.fvneto.vetclinic.repository.TutorRepository;

@Service
public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;

	public Tutor atualizar(Long codigo, Tutor tutor) {

		Tutor tutorSalvo = this.tutorRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		BeanUtils.copyProperties(tutor, tutorSalvo, "codigo");

		return this.tutorRepository.save(tutorSalvo);
	}

}
