package com.aulas.aluno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

	private static final int List = 0;
	@Autowired
	private AlunoRepository repositorio;

	public List<Aluno> buscarTodos() {
		List<Aluno> findAll = repositorio.findAll();
		return findAll;
	}

	public Aluno criar(Aluno aluno) {
		aluno.setAtivo(true);
		return repositorio.save(aluno);
	}

	public Aluno findById(String id) {
		return repositorio.findById(id).orElseThrow(RuntimeException::new);
	}

	public Aluno adcionarNota(Integer nota, String id) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		aluno.getNotas().add(nota);
		return repositorio.save(aluno);
	}

	public Aluno calcularMedia(String id) {
		Aluno lista = repositorio.findById(id).orElseThrow(RuntimeException::new);
		int j = 0;
		for (Integer i : lista.getNotas()) {
			j = i + j;
		}
		j = j / lista.getNotas().size();
		lista.setMedia(j);
		Aluno nota = repositorio.save(lista);
		return nota;
	}

	public Aluno deletar(String id) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		aluno.setAtivo(false);
		Aluno alunoAtualizado = repositorio.save(aluno);
		return alunoAtualizado;
	}

	public Aluno atualizar(Aluno aluno) {
		return repositorio.save(aluno);
	}

	public Aluno cadastrarMateria(Materias materias, String id) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		aluno.getMaterias().add(materias);
		return repositorio.save(aluno);
	}

	public List<String> buscarAtivos() {
		List<Aluno> ativos = repositorio.findAll();
		ArrayList<String> alunos = new ArrayList<String>();
		for (Aluno aluno : ativos) {
			if (aluno.getAtivo()) {
				alunos.add(aluno.getNome());
			}
		}
		return alunos;
	}

	public Aluno cadastrarEndereco(String id, String endereco) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		aluno.getEndereco().add(endereco);
		return repositorio.save(aluno);
	}

	public Aluno deletarEndereco(String id, String endereco) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		for (String i : aluno.getEndereco()) {
			if (i.equals(endereco)) {
				aluno.getEndereco().remove(aluno.getEndereco().indexOf(i));
			}
		}

		return repositorio.save(aluno);
	}

	public List<Integer> todasMedias(String id) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		ArrayList<Integer> notas = new ArrayList<>();
		for (Materias materia : aluno.getMaterias()) {
			if (materia.equals(materia.getCiencias())) {
				for (Integer i : materia.getCiencias().getNotas()) {
					int j = i + i++;
					j = j / materia.getCiencias().getNotas().size();
					notas.add(j);
				}
			}

			if (materia.equals(materia.getGeografia())) {
				for (Integer i : materia.getGeografia().getNotas()) {
					int j = i + i++;
					j = j / materia.getGeografia().getNotas().size();
					notas.add(j);
				}
			}

			if (materia.equals(materia.getHistoria())) {
				for (Integer i : materia.getHistoria().getNotas()) {
					int j = i + i++;
					j = j / materia.getHistoria().getNotas().size();
					notas.add(j);
				}
			}

			if (materia.equals(materia.getIngles())) {
				for (Integer i : materia.getIngles().getNotas()) {
					int j = i + i++;
					j = j / materia.getIngles().getNotas().size();
					notas.add(j);
				}
			}

			if (materia.equals(materia.getMatematica())) {
				for (Integer i : materia.getMatematica().getNotas()) {
					int j = i + i++;
					j = j / materia.getMatematica().getNotas().size();
					notas.add(j);
				}
			}

			if (materia.equals(materia.getPortugues())) {
				for (Integer i : materia.getPortugues().getNotas()) {
					int j = i + i++;
					j = j / materia.getPortugues().getNotas().size();
					notas.add(j);
				}
			}
		}
		return notas;
	}

	public Integer mediaMateria(String id, Materias materia) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		int nota = 0;
		for (Materias m : aluno.getMaterias()) {
			if (materia.equals(m.getCiencias())) {
				for (Integer i : m.getCiencias().getNotas()) {
					int j = i + i++;
					j = j / materia.getCiencias().getNotas().size();
					nota = j;
				}
			}

			if (materia.equals(m.getGeografia())) {
				for (Integer i : m.getGeografia().getNotas()) {
					int j = i + i++;
					j = j / m.getGeografia().getNotas().size();
					nota = j;
				}
			}

			if (materia.equals(m.getHistoria())) {
				for (Integer i : m.getHistoria().getNotas()) {
					int j = i + i++;
					j = j / m.getHistoria().getNotas().size();
					nota = j;
				}
			}

			if (materia.equals(m.getIngles())) {
				for (Integer i : m.getIngles().getNotas()) {
					int j = i + i++;
					j = j / m.getIngles().getNotas().size();
					nota = j;
				}
			}

			if (materia.equals(m.getMatematica())) {
				for (Integer i : m.getMatematica().getNotas()) {
					int j = i + i++;
					j = j / m.getMatematica().getNotas().size();
					nota = j;
				}
			}

			if (materia.equals(m.getPortugues())) {
				for (Integer i : m.getPortugues().getNotas()) {
					int j = i + i++;
					j = j / m.getPortugues().getNotas().size();
					nota = j;
				}
			}
		}
		return nota;
	}
	
	public Aluno notaMAteria (String id, Materias materia, Integer nota) {
		Aluno aluno = repositorio.findById(id).orElseThrow(RuntimeException::new);
		for (Materias m : aluno.getMaterias()) {
			if (materia.equals(m.getCiencias())) {
				m.getCiencias().getNotas().add(nota);
			}
			if (materia.equals(m.getGeografia())) {
				m.getGeografia().getNotas().add(nota);
			}
			if (materia.equals(m.getHistoria())) {
				m.getHistoria().getNotas().add(nota);
			}
			if (materia.equals(m.getIngles())) {
				m.getIngles().getNotas().add(nota);
			}
			if (materia.equals(m.getMatematica())) {
				m.getMatematica().getNotas().add(nota);
			}
			if (materia.equals(m.getPortugues())) {
				m.getPortugues().getNotas().add(nota);
			}
		}
		return repositorio.save(aluno);
	}
	
}