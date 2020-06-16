package com.desafioapi.util;

public class ResultValidacaoProduto {
	
	private String msg;
	
	private boolean erro;

	public ResultValidacaoProduto(String msg, boolean erro) {
		this.msg = msg;
		this.erro = erro;
	}
	
	public ResultValidacaoProduto() {

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean getErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}

}
