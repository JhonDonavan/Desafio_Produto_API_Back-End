package com.desafioapi.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.desafioapi.api.Produto;

@RegisterRowMapper(ProdutoMapper.class)
public interface ProdutoDao {

		@SqlQuery("select * from produtos")
		public List<Produto> findAllProdutos();
		
		@SqlQuery("select * from produtos where id_produto = :id")
		public Produto getProdutoByid(@Bind("id") long id);
		
		@SqlUpdate("insert into produtos(codigo_barras, nome, descricao, quantidade, categoria) "
				+ "values(:codigo_barras, :nome, :descricao, :quantidade, :categoria)")
		public void insertProduto(@BindBean Produto produto);
		
		@SqlUpdate("delete from produtos WHERE id_produto = :id")
		public void deleteProdutoById(@Bind("id") long id);

		@SqlUpdate("update produtos SET codigo_barras = :codigo_barras, nome = :nome, descricao = :descricao,"
				+ " quantidade = :quantidade, categoria = :categoria where id_produto = :id")
		public void updateProduto(@BindBean Produto produto);
		
		@SqlQuery("select * from produtos where categoria like :nameCategoria"
				+" order by nome")
		public List<Produto> findByNameCategoria(@Bind("nameCategoria") String nameCategoria);

		@SqlQuery("select * from produtos where nome like '%':name'%' order by nome")
		public List<Produto> findByName(@Bind("name") String name);
	
		
}
