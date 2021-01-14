package com.aulas.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService service;

	@GetMapping("/buscar")
	public List<Aluno> findAll() {
		return service.buscarTodos();
	}

	@PostMapping("/criar")
	public Aluno create(@RequestBody Aluno aluno) {
		return this.service.criar(aluno);
	}
	
	@GetMapping("/buscar/{id}")
	public Aluno findById(@PathVariable("id") String id) {
		return this.service.findById(id);
	}
	
	@PostMapping("/nota/{id}")
	public Aluno adcionarNota(@RequestBody String id, Integer nota) {
		return this.service.adcionarNota(nota, id);
	}
	
	@PostMapping("/deletar/{id}")
	public Aluno deletar(@PathVariable("id") String id) {
		return this.service.deletar(id);
	}
	
	@PutMapping("/atualiza")
	public Aluno atualizar(@RequestBody Aluno aluno) {
		return this.service.atualizar(aluno);
	}
	
	@PostMapping("/materia/{id}")
	public Aluno cadastrarMateria(@RequestBody String id, Materias materia) {
		return this.service.cadastrarMateria(materia, id);
	}
	
	@GetMapping("/buscarAtivo")
	public List<String> buscarAtivos() {
		return this.service.buscarAtivos();
	} 
	
	@GetMapping ("/todasMedias/{id}")
	public List<Integer> todasMedias(String id){
		return this.service.todasMedias(id);
	}
	
	@GetMapping ("/mediaMateria/{id}")
	public Integer mediaMateria(String id, Materias materia){
		return this.service.mediaMateria(id, materia);
	}
	
	
}
