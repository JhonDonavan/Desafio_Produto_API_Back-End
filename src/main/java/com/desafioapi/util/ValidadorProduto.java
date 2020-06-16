package com.desafioapi.util;

import com.desafioapi.api.Produto;

public class ValidadorProduto {
	


	public static ResultValidacaoProduto validarProduto(Produto produto) {

		ResultValidacaoProduto result = new ResultValidacaoProduto();

		boolean erro = false;

		StringBuilder msg = new StringBuilder();
		msg.append("Favor Corrigir campo(s): ");

		if (produto.getCodigo_barras() != null) {
			if (produto.getCodigo_barras().isEmpty()) {
				erro = true;
				msg.append("CÓDIGO DE BARRAS");
			}
		} else {
			erro = true;
			msg.append("CÓDIGO DE BARRAS");
		}

		if (produto.getNome() != null) {
			if (produto.getDescricao().isEmpty()) {
				erro = true;
				msg.append(" - DESCRIÇÃO");
			}
		} else {
			erro = true;
			msg.append(" - DESCRIÇÃO");
		}

		if (produto.getNome() != null) {
			if (produto.getNome().isEmpty()) {
				erro = true;
				msg.append(" - NOME");
			}
		} else {
			erro = true;
			msg.append(" - NOME");
		}

		if (Integer.toString(produto.getQuantidade()) != null) {
			if(produto.getQuantidade() < 0) {
				erro = true;
				msg.append(" - QUANTIDADE");
			}
			
		}else {
			erro = true;
			msg.append(" - QUANTIDADE");
		}

		if (produto.getCategoria() != null) {
			if (produto.getCategoria().isEmpty()) {
				erro = true;
				msg.append(" - CATEGORIA");
			}
		} else {
			erro = true;
			msg.append(" - CATEGORIA");
		}

		result.setErro(erro);
		result.setMsg(msg.toString());

		return result;

	}
}
