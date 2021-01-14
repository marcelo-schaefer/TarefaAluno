package com.aulas.aluno;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {

	Aluno findByCpf(String cpf);
	
}
