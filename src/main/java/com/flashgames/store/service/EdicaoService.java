package com.flashgames.store.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashgames.store.model.Edicao;
import com.flashgames.store.model.Jogo;
import com.flashgames.store.repository.EdicaoRepository;


@Service
public class EdicaoService{
	
	@Autowired
	private EdicaoRepository repository;
	
	public Iterable<Edicao> findByJogo(Jogo jogo){
		return repository.findByJogo(jogo);
	}
	
	public Optional<Edicao> findByJogo(Optional<Jogo> jogo){
		return repository.findByJogo(jogo);
	}
	
	public Optional<Edicao> findById(String id){
		return repository.findById(id);
	}
	
	public Edicao findByNome(String nome) {
		return repository.findByNome(nome);
	}

	public Edicao save(@Valid Edicao edicao) {
		return repository.save(edicao);
	}

	public void delete(Edicao edicao) {
		repository.deleteById(edicao.getId());
	}
	
}
