package com.fvneto.vetclinic.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@ResponseBody
	@GetMapping
	public List<Tutor> listar() {

		return tutorRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Tutor> criar(@Valid @RequestBody Tutor tutor, 
			HttpServletResponse response) {

		Tutor tutorSalvo = tutorRepository.save(tutor);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(tutorSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tutor> buscarPeloCodigo(@PathVariable Long id) {

		return this.tutorRepository.findById(id)
				.map(tutor -> ResponseEntity.ok(tutor))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value = "/search-nome")
	public ResponseEntity<Page<Tutor>> buscarPeloNome(
			@RequestParam(defaultValue = "") String nome, 
			Pageable pageable) {

		Page<Tutor> result = tutorRepository.searchName(nome, pageable);
		return ResponseEntity.ok(result);	
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {

		this.tutorRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Tutor> atualizar(@PathVariable Long codigo, 
			@Valid @RequestBody Tutor tutor) {
		Tutor tutorSalvo = tutorService.atualizar(codigo, tutor);
		return ResponseEntity.ok(tutorSalvo);
	}
}
