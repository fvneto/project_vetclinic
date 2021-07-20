package com.fvneto.vetclinic.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fvneto.vetclinic.enums.EspecieEnum;

@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "animal_id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Enumerated(EnumType.STRING)
	private EspecieEnum especie;

	@Size(min = 3, max = 40)
	@Column(name = "raca")
	private String raca;

	@Column(name = "data_nascimento")
	private LocalDate datanascimento;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "animal", cascade = CascadeType.REMOVE)
	private List<Tutor> tutores;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "animal", cascade = CascadeType.REMOVE)
	private List<Consulta> consultas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EspecieEnum getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieEnum especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
