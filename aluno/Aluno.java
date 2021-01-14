package com.aulas.aluno;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aluno {

	@Id
	private String id;
	private String nome;
	private String cpf;
	private Turno turno;
	private List<Integer> notas;
	private Integer media;
	private boolean ativo;
	private List<Materias> materias;
	private List<String> endereco;

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Integer> getNotas() {
		return notas;
	}

	public void setNotas(List<Integer> notas) {
		this.notas = notas;
	}

	public Integer getMedia() {
		return media;
	}

	public void setMedia(Integer media) {
		this.media = media;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<String> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<String> endereco) {
		this.endereco = endereco;
	}

	public List<Materias> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
}
