package com.flashgames.store.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Edicao implements Serializable{
	
	public Edicao() {
	}

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@NotEmpty
	private String nome;
	
	private int disponivel;
	private String cdkey;
	private String plataforma;
	private String console;
	
	@ManyToOne
	private Jogo jogo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}

	public String getCdkey() {
		return cdkey;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}	

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdkey == null) ? 0 : cdkey.hashCode());
		result = prime * result + ((console == null) ? 0 : console.hashCode());
		result = prime * result + disponivel;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edicao other = (Edicao) obj;
		if (cdkey == null) {
			if (other.cdkey != null)
				return false;
		} else if (!cdkey.equals(other.cdkey))
			return false;
		if (console == null) {
			if (other.console != null)
				return false;
		} else if (!console.equals(other.console))
			return false;
		if (disponivel != other.disponivel)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jogo == null) {
			if (other.jogo != null)
				return false;
		} else if (!jogo.equals(other.jogo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		return true;
	}

	public Edicao(String id, String nome, int disponivel, String cdkey, String plataforma, String console,
			Jogo jogo) {
		super();
		this.id = id;
		this.nome = nome;
		this.disponivel = disponivel;
		this.cdkey = cdkey;
		this.plataforma = plataforma;
		this.console = console;
		this.jogo = jogo;
	}
	
	

}
