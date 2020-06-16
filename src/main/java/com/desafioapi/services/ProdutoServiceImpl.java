package com.desafioapi.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.jvnet.hk2.annotations.Service;

import com.desafioapi.api.Produto;
import com.desafioapi.dao.ProdutoDao;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Inject
	ProdutoDao produtoDao;
	
	@Inject
	Produto produto;
		
	public  ProdutoServiceImpl(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	public ProdutoServiceImpl() {
		
	}
	
	@Override
	public Produto findById(long id) {
		this.produto = produtoDao.getProdutoByid(id);
		if (produto == null) {
			throw new WebApplicationException("Produto não encontrado", Response.Status.NOT_FOUND);
		}
		return produto;
	}

	public List<Produto> findAllProdutos() {
			List<Produto> allProducts = produtoDao.findAllProdutos();
			return allProducts;
	}

	@Override
	public List<Produto> findAllByName(String name) {
		 List<Produto> allProducts = produtoDao.findByName(name);
		 return allProducts;
	}

	@Override
	public List<Produto> findAllByCategoria(String nameCategoria) {
		 List<Produto> allProducts = produtoDao.findByNameCategoria(nameCategoria);
		 return allProducts;
	}

	@Override
	public Produto createProduto(Produto produto) {
			produtoDao.insertProduto(produto);
			return produto;
	}

	@Override
	public Produto updateProduto(Produto produto) {
		Produto produtoExiste = produtoDao.getProdutoByid(produto.getId());
		if (produtoExiste == null) {
			throw new WebApplicationException("Produto não encontrado", Response.Status.NOT_FOUND);
		}

		produtoDao.updateProduto(produto);

		return produto;
	}

	@Override
	public void deleteProduto(long id) {
		produto = produtoDao.getProdutoByid(id);
		if (produto == null) {
			throw new WebApplicationException("Produto não encontrado", Response.Status.NOT_FOUND);
		}
		produtoDao.deleteProdutoById(produto.getId());
		
	}

}
