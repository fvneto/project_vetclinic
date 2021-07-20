package com.fvneto.vetclinic.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fvneto.vetclinic.model.Veterinario;
import com.fvneto.vetclinic.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository veterinarioRepository;

	public Veterinario atualizar(Long codigo, Veterinario veterinario) {

		Veterinario veterinarioSalvo = this.veterinarioRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		BeanUtils.copyProperties(veterinario, veterinarioSalvo, "codigo");

		return this.veterinarioRepository.save(veterinarioSalvo);

	}

}
