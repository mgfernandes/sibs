package com.sibs.cartoes.dto;

import java.util.Date;

public class Cartoes {

	private String numero;

    private Date validade;

    private String banco;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
    
    
    
}
