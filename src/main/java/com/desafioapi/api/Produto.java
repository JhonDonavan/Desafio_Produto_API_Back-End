package com.desafioapi.api;



import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto {
	
	@JsonProperty
	private long id;
	
	@NotEmpty(message = "Favor informar o código de barras")
	private String codigo_barras;
	
	
	@NotEmpty(message = "Favor informar o nome do produto")
	private String nome;
	
	
	@NotEmpty(message = "Favor informar a descrição do produto")
	private String descricao;
	
	
	@NotEmpty(message = "Favor informar a quantidade do produto")
	private int quantidade;
	
	
	@NotEmpty(message = "Favor informar uma descrição do produto")
	private String categoria;

	
	public Produto() {

	}
	
	@JsonCreator
	public Produto(@JsonProperty("id") long id, @JsonProperty("codigo_barras") String codigo_barras, 
			       @JsonProperty("nome") String nome,  @JsonProperty("descricao") String descricao,
			       @JsonProperty("quantidade") int quantidade, @JsonProperty("categoria") String categoria) {
		
		
		if(codigo_barras == null) {
			throw new IllegalArgumentException("Código de barras não pode ser nulo");
		}
		
		if(nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser nulo vou vazio");
		}
		
		if(categoria == null) {
			throw new IllegalArgumentException("Categoria não pode ser nula");
		}
		
		if(quantidade < 0) {
			throw new IllegalArgumentException("Quantidade não pode ser um número negativo");
		}
		
		
		this.id = id;
		this.codigo_barras = codigo_barras;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}

	@JsonProperty("id")
	public long getId() {
		return id;
	}
	
	@JsonProperty("codigo_barras")
	public String getCodigo_barras() {
		return codigo_barras;
	}

	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}

	@JsonProperty("nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonProperty("descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@JsonProperty("quantidade")
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@JsonProperty("categoria")
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
