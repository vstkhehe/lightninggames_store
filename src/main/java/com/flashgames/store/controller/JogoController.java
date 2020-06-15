package com.flashgames.store.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flashgames.store.model.Edicao;
import com.flashgames.store.model.Jogo;
import com.flashgames.store.service.EdicaoService;
import com.flashgames.store.service.JogoService;

@Controller
public class JogoController {

	@Autowired
	private JogoService jogoService;
	
	@Autowired
	private EdicaoService edicaoService;
	
	@GetMapping(value="/cadastrarJogo")
	public String form() {
		return "jogo/formJogo";
	}
	
	@PostMapping(value="/cadastrarJogo")
	public String form(Jogo jogo, String nome, RedirectAttributes attributes) {
		Jogo jogoEstoque = jogoService.findByNome(nome);
			if(jogoEstoque == null) {
				jogoService.save(jogo);
				attributes.addFlashAttribute("mensagem", "Jogo cadastrado com sucesso");
			}else {
				attributes.addFlashAttribute("mensagem", "Jogo já cadastrado");
			}
		return "redirect:/cadastrarJogo";
	}
	
	@RequestMapping("/jogos")
	public ModelAndView listaJogos() {
		ModelAndView mv = new ModelAndView("jogo/listJogo");
		Iterable<Jogo> jogos = jogoService.findAll();
		mv.addObject("jogos", jogos);
		return mv;
		
	}
	
	@GetMapping(value="/{id}")
	public ModelAndView detalhesJogo(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("jogo/detalhesJogo");
		Optional<Jogo> optionalJogo = jogoService.findById(id);
		
		//Insere Edicoes
		if(optionalJogo.isPresent()) {
			mv.addObject("jogo", optionalJogo.get());
			Iterable<Edicao> edicoes = edicaoService.findByJogo(optionalJogo.get());
			mv.addObject("edicoes", edicoes);
		}	
		
		//Contador disponiveis
   		if(optionalJogo.isPresent()) {
				Iterable<Edicao> edicoes = edicaoService.findByJogo(optionalJogo.get());
				
				int quantidade = 0;
				
				if(!edicoes.iterator().hasNext()) {
					optionalJogo.get().setDisponivel(0);
					jogoService.save(optionalJogo.get());
					mv.addObject("quantidade", quantidade);
				}
					
				for(Edicao edicao : edicoes) {
					quantidade = quantidade + edicao.getDisponivel();					
					optionalJogo.get().setDisponivel(quantidade);
				}
				jogoService.save(optionalJogo.get());
				mv.addObject("quantidade", quantidade);
		}
		
		return mv;
	}
	
	@RequestMapping("/deletarJogo")
	public String deletarJogo(String id, RedirectAttributes attributes) {
		Optional<Jogo> optionalJogo = jogoService.findById(id);
		if(optionalJogo.isPresent()) {
			Jogo jogo = optionalJogo.get();
			if(!jogo.getEdicao().isEmpty()){
				attributes.addFlashAttribute("mensagem", "Jogo possui edições cadastradas");
			}else {
			jogoService.delete(jogo);
			attributes.addFlashAttribute("mensagem", "Jogo excluído com sucesso");
			}
		}
		return "redirect:/jogos";
	}
	
	@PostMapping(value="/{id}")
	public String inserirDetalhes(@PathVariable("id") String id, @Valid Optional<Edicao> edicao, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{id}";
		}
			Optional<Jogo> optionalJogo = jogoService.findById(id);
			if(optionalJogo.isPresent()) {
				Jogo jogo = optionalJogo.get();
				edicao.get().setJogo(jogo);
				edicaoService.save(edicao.get());
				attributes.addFlashAttribute("mensagem", "Edição adicionada com sucesso");
			}
		return "redirect:/{id}";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") String id, RedirectAttributes attributes, 
			Optional<Edicao> edicao, BindingResult result, Model model) {	
		if (edicao.isPresent()) {
            edicao = edicaoService.findById(id);
            model.addAttribute("edicao", edicao);
		}
		return "jogo/editDetalhes";	
	}
	
	@PostMapping("/update/{id}")
	public String updateEdicao(@PathVariable("id") String id, RedirectAttributes attributes, 
			Edicao edicao, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        edicao.setId(id);
	        return "jogo/editDetalhes";
	    }
	    edicaoService.save(edicao);
	    model.addAttribute("edicao", edicaoService.findById(id));
	    return "redirect:/{id}";
	}

	@RequestMapping("/deletarEdicao")
	public String deletarEdicao(String id, RedirectAttributes attributes) {
		Optional<Edicao> optionalEdicao = edicaoService.findById(id);
		if(optionalEdicao.isPresent()) {
			Edicao edicao = optionalEdicao.get();
			edicaoService.delete(edicao);
			attributes.addFlashAttribute("mensagem", "Edição excluída com sucesso");
		}
		return "redirect:/jogos";
		
	}

}
