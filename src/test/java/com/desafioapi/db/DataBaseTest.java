package com.desafioapi.db;

import org.junit.ClassRule;


import com.desafioapi.api.Produto;
import com.desafioapi.dao.ProdutoDao;

import io.dropwizard.testing.junit.DAOTestRule;





public class DataBaseTest {
	
	@SuppressWarnings("deprecation")
	@ClassRule
    public DAOTestRule database = DAOTestRule.newBuilder().addEntityClass(Produto.class).build();

	private ProdutoDao produtoDao;
	
	
}
