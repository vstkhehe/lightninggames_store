package com.flashgames.store.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.flashgames.store.model.Edicao;
import com.flashgames.store.model.Jogo;

public interface JogoRepository extends CrudRepository<Jogo, String> {
	Optional<Jogo> findById(String id);
	
	Jogo findByNome(String nome);
	
	Jogo findByEdicao(Edicao edicao);
	
	Jogo findByEdicao(Optional<Edicao> edicao);

}
