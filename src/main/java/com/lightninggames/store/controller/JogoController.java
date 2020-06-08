package com.lightninggames.store.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lightninggames.store.model.Edicao;
import com.lightninggames.store.model.Jogo;
import com.lightninggames.store.repository.EdicaoRepository;
import com.lightninggames.store.repository.JogoRepository;

@Controller
public class JogoController {

	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private EdicaoRepository edicaoRepository;
	
	@RequestMapping(value="/cadastrarJogo", method=RequestMethod.GET)
	public String form() {
		return "jogo/formJogo";
	}
	
	@RequestMapping(value="/cadastrarJogo", method=RequestMethod.POST)
	public String form(Jogo jogo, String nome, RedirectAttributes attributes) {
		Jogo jogoEstoque = jogoRepository.findByNome(nome);
			if(jogoEstoque == null) {
				jogoRepository.save(jogo);
			}else {
				attributes.addFlashAttribute("mensagem", "Jogo já cadastrado");
			}
		return "redirect:/jogos";
	}
	
	@RequestMapping("/jogos")
	public ModelAndView listaJogos() {
		ModelAndView mv = new ModelAndView("jogo/listJogo");
		Iterable<Jogo> jogos = jogoRepository.findAll();
		mv.addObject("jogos", jogos);
		return mv;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesJogo(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("jogo/detalhesJogo");
		Optional<Jogo> optionalJogo = jogoRepository.findById(id);
		if(optionalJogo.isPresent()) {
			mv.addObject("jogo", optionalJogo.get());
			Iterable<Edicao> edicoes = edicaoRepository.findByJogo(optionalJogo.get());
			mv.addObject("edicoes", edicoes);
		}				
		return mv;
	}
	
	@RequestMapping("/deletarJogo")
	public String deletarJogo(String id, RedirectAttributes attributes) {
		Optional<Jogo> optionalJogo = jogoRepository.findById(id);
		if(optionalJogo.isPresent()) {
			Jogo jogo = optionalJogo.get();
			if(!jogo.getEdicao().isEmpty()){
				attributes.addFlashAttribute("mensagem", "Jogo possui edições cadastradas !");
			}else {
			jogoRepository.delete(jogo);
			}
		}
		return "redirect:/jogos";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String inserirDetalhes(@PathVariable("id") String id, @Valid Edicao edicao, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{id}";
		}
			Optional<Jogo> optionalJogo = jogoRepository.findById(id);
			if(optionalJogo.isPresent()) {
				Jogo jogo = optionalJogo.get();
				edicao.setJogo(jogo);
				edicaoRepository.save(edicao);
				attributes.addFlashAttribute("mensagem", "Edição adicionada com sucesso");
			}
		return "redirect:/{id}";
	}
	
	@RequestMapping("/deletarEdicao")
	public String deletarEdicao(String id) {
		Optional<Edicao> optionalEdicao = edicaoRepository.findById(id);
		if(optionalEdicao.isPresent()) {
			Edicao edicao = optionalEdicao.get();
			edicaoRepository.delete(edicao);
		}
		return "redirect:/jogos";
		
	}
	
}
