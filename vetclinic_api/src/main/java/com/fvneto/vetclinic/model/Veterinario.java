package com.fvneto.vetclinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veterinario")
public class Veterinario extends Pessoa {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "veterinario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Consulta> consultas;

}
