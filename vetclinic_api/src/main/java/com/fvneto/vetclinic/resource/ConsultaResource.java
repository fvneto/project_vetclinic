package com.fvneto.vetclinic.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fvneto.vetclinic.model.Consulta;
import com.fvneto.vetclinic.repository.ConsultaRepository;
import com.fvneto.vetclinic.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaResource {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private ConsultaService consultaService;

	@GetMapping
	public List<Consulta> listar() {

		return consultaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Consulta> criar(@Valid @RequestBody Consulta consulta, HttpServletResponse response) {

		Consulta consultaSalva = consultaRepository.save(consulta);

		return ResponseEntity.status(HttpStatus.CREATED).body(consultaSalva);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Consulta> buscarPeloCodigo(@PathVariable Long id) {

		return this.consultaRepository.findById(id).map(funcionario -> ResponseEntity.ok(funcionario))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.consultaRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Consulta> atualizar(@PathVariable Long codigo, @Valid @RequestBody Consulta consulta) {
		Consulta ConsultaSalvo = consultaService.atualizar(codigo, consulta);
		return ResponseEntity.ok(ConsultaSalvo);
	}
}
