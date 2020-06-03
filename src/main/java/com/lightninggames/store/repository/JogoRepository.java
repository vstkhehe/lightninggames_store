package com.lightninggames.store.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.lightninggames.store.model.Jogo;

public interface JogoRepository extends CrudRepository<Jogo, String> {
	Optional<Jogo> findById(String id);
	
	Jogo findByNome(String nome);
	
}
