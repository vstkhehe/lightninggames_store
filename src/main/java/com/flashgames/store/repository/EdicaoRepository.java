package com.flashgames.store.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.flashgames.store.model.Edicao;
import com.flashgames.store.model.Jogo;

public interface EdicaoRepository extends CrudRepository<Edicao, String>{
	
	Iterable<Edicao> findByJogo(Jogo jogo);
	
	Optional<Edicao> findByJogo(Optional<Jogo> jogo);
	
	Optional<Edicao> findById(String id);
	
	Edicao findByNome(String nome);
	
}
