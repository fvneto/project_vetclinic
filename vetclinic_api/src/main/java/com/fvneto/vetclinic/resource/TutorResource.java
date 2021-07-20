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

import com.fvneto.vetclinic.model.Tutor;
import com.fvneto.vetclinic.repository.TutorRepository;
import com.fvneto.vetclinic.service.TutorService;

@RestController
@RequestMapping("/tutores")
public class TutorResource {
	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private TutorService tutorService;

	@GetMapping
	public List<Tutor> listar() {

		return tutorRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Tutor> criar(@Valid @RequestBody Tutor tutor, HttpServletResponse response) {

		Tutor tutorSalva = tutorRepository.save(tutor);

		return ResponseEntity.status(HttpStatus.CREATED).body(tutorSalva);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tutor> buscarPeloCodigo(@PathVariable Long id) {

		return this.tutorRepository.findById(id).map(funcionario -> ResponseEntity.ok(funcionario))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.tutorRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Tutor> atualizar(@PathVariable Long codigo, @Valid @RequestBody Tutor tutor) {
		Tutor tutorSalvo = tutorService.atualizar(codigo, tutor);
		return ResponseEntity.ok(tutorSalvo);
	}
}
