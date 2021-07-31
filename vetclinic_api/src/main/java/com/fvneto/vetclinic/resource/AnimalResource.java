package com.fvneto.vetclinic.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fvneto.vetclinic.model.Animal;
import com.fvneto.vetclinic.repository.AnimalRepository;
import com.fvneto.vetclinic.service.AnimalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/animais")
@Api(value = "API REST Animais")
public class AnimalResource {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private AnimalService animalService;

	@ResponseBody
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de animais")
	public List<Animal> listar() {

		return animalRepository.findAll();
	}

	@PostMapping
	@ApiOperation(value = "Adicionar um novo pet")
	public ResponseEntity<Animal> criar(@Valid @RequestBody Animal animal, 
			HttpServletResponse response) {

		Animal animalSalvo = animalRepository.save(animal);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(animalSalvo);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Consultar um animal pelo codigo")
	public ResponseEntity<Animal> buscarPeloCodigo(@PathVariable Long id) {

		return this.animalRepository.findById(id)
				.map(animal -> ResponseEntity.ok(animal))
				.orElse(ResponseEntity.notFound()
				.build());
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Remover um animal")
	public void remover(@PathVariable Long codigo) {

		this.animalRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	@ApiOperation(value = "Atualizar um animal")
	public ResponseEntity<Animal> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody Animal animal) {
		Animal AnimalSalvo = animalService.atualizar(codigo, animal);
		return ResponseEntity.ok(AnimalSalvo);
	}

}
