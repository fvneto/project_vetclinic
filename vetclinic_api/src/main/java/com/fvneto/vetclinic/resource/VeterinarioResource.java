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

import com.fvneto.vetclinic.model.Veterinario;
import com.fvneto.vetclinic.repository.VeterinarioRepository;
import com.fvneto.vetclinic.service.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioResource {
		
		@Autowired
		private VeterinarioRepository veterinarioRepository;
		
		@Autowired
		private VeterinarioService veterinarioService;
		
		@GetMapping
		public List <Veterinario> listar(){
			
			return veterinarioRepository.findAll();
		}
		
		@PostMapping
		public ResponseEntity<Veterinario> criar(
				@Valid @RequestBody Veterinario veterinario, 
				HttpServletResponse response) {
			
			Veterinario veterinarioSalvo = veterinarioRepository
					.save(veterinario);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(veterinarioSalvo);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Veterinario> buscarPeloCodigo(
				@PathVariable Long id) {
			
		  return this.veterinarioRepository.findById(id)
		      .map(veterinario -> ResponseEntity.ok(veterinario))
		      .orElse(ResponseEntity.notFound().build());	
		}
		
		@DeleteMapping("/{codigo}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void remover(@PathVariable Long codigo) {
			
			this.veterinarioRepository.deleteById(codigo);
		}
		
		@PutMapping("/{codigo}")
		public ResponseEntity<Veterinario> atualizar(
				@PathVariable Long codigo, 
				@Valid @RequestBody Veterinario veterinario) {
			Veterinario veterinarioSalvo = veterinarioService
					.atualizar(codigo, veterinario);
			return ResponseEntity.ok(veterinarioSalvo);
		}
}
