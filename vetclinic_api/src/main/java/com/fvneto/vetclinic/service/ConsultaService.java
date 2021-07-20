package com.fvneto.vetclinic.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fvneto.vetclinic.model.Consulta;
import com.fvneto.vetclinic.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	public Consulta atualizar(Long codigo, Consulta consulta) {

		Consulta consultaSalvo = this.consultaRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));

		BeanUtils.copyProperties(consulta, consultaSalvo, "codigo");

		return this.consultaRepository.save(consultaSalvo);

	}

}
