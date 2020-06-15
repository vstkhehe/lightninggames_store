package com.flashgames.store.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashgames.store.model.Jogo;
import com.flashgames.store.repository.JogoRepository;


@Service
public class JogoService{
	
	@Autowired
	private JogoRepository repository;
	
	public Optional<Jogo> findById(String id){
		return repository.findById(id);
	}
	
	public Jogo findByNome(String nome) {
		return repository.findByNome(nome);
	}

	public Iterable<Jogo> findAll() {
		return repository.findAll();
	}

	public void delete(Jogo jogo) {
		repository.deleteById(jogo.getId());
	}

	public Jogo save(Jogo jogo) {
		return repository.save(jogo);
	}
}
