package com.sibs.cartoes.dto;

import java.util.List;

public class Base {
	private String telefone;

	private List<Cartoes> cartoes;
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Cartoes> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartoes> cartoes) {
		this.cartoes = cartoes;
	}



}
