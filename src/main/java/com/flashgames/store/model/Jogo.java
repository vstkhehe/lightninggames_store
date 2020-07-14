package com.flashgames.store.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Jogo implements Serializable{
	
	public Jogo() {  
	} 

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@NotNull
	private String nome;
	@NotNull
	private int disponivel;
	
	private String imagemNome;
	
	private String imagemTipo;
	
	private String imagemTamanho;
	
	private Timestamp createdDate;
	
	@OneToMany(mappedBy="jogo", orphanRemoval=true, cascade=CascadeType.PERSIST)
	private List<Edicao> edicao;

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

	public List<Edicao> getEdicao() {
		return edicao;
	}

	public void setEdicao(List<Edicao> edicao) {
		this.edicao = edicao;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemTipo() {
		return imagemTipo;
	}

	public void setImagemTipo(String imagemTipo) {
		this.imagemTipo = imagemTipo;
	}

	public String getImagemTamanho() {
		return imagemTamanho;
	}

	public void setImagemTamanho(String imagemTamanho) {
		this.imagemTamanho = imagemTamanho;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + disponivel;
		result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
		result = prime * result + ((imagemNome == null) ? 0 : imagemNome.hashCode());
		result = prime * result + ((imagemTamanho == null) ? 0 : imagemTamanho.hashCode());
		result = prime * result + ((imagemTipo == null) ? 0 : imagemTipo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Jogo other = (Jogo) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (disponivel != other.disponivel)
			return false;
		if (edicao == null) {
			if (other.edicao != null)
				return false;
		} else if (!edicao.equals(other.edicao))
			return false;
		if (imagemNome == null) {
			if (other.imagemNome != null)
				return false;
		} else if (!imagemNome.equals(other.imagemNome))
			return false;
		if (imagemTamanho == null) {
			if (other.imagemTamanho != null)
				return false;
		} else if (!imagemTamanho.equals(other.imagemTamanho))
			return false;
		if (imagemTipo == null) {
			if (other.imagemTipo != null)
				return false;
		} else if (!imagemTipo.equals(other.imagemTipo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Jogo(String id, @NotNull String nome, @NotNull int disponivel, String imagemNome, String imagemTipo,
			String imagemTamanho, Timestamp createdDate, List<Edicao> edicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.disponivel = disponivel;
		this.imagemNome = imagemNome;
		this.imagemTipo = imagemTipo;
		this.imagemTamanho = imagemTamanho;
		this.createdDate = createdDate;
		this.edicao = edicao;
	}
	
}
