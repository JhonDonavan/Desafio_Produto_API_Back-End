package com.desafioapi.services;

import java.util.List;

import com.desafioapi.api.Produto;

public interface ProdutoService {
	
	List<Produto> findAllProdutos();
	
	List<Produto> findAllByName(String name);
	
	List<Produto> findAllByCategoria(String nameCategoria);
	
	Produto findById(long id);
	
	Produto createProduto(Produto produto);
	
	Produto updateProduto(Produto produto);
	
	void deleteProduto(long id);	
}
