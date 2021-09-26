package com.sibs.cartoes.dto;

import java.util.Date;

public class Response extends Base{

	private String mensagem;

	public static final String ERRO = "Erro: ";	
	public static final String SUCESSO = "Sucesso";
	
	private Date ultimaAlteracao;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
	
	
}
