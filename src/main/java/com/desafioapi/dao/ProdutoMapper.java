package com.desafioapi.dao;

import com.desafioapi.api.Produto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoMapper implements RowMapper<Produto> {

    @Override
    public Produto map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Produto(
        		rs.getInt("id_produto"),
        		rs.getString("codigo_barras"),
        		rs.getString("nome"), 
        		rs.getString("descricao"),
        		rs.getInt("quantidade"), 
        		rs.getString("categoria")
        );
    }
}




