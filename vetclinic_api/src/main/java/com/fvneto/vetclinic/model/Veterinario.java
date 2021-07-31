package com.fvneto.vetclinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_veterinario")
public class Veterinario extends Pessoa {

	private static final long serialVersionUID = 1L;

	public Veterinario(Long id, @Size(min = 3, max = 40) String nome, 
			@NotNull @NotBlank String telefone, String email) {
		super(id, nome, telefone, email);
	}

	@OneToMany(mappedBy = "veterinario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Consulta> consultas;

}
