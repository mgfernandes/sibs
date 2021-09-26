package com.sibs.cartoes.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_cartao")
public class Cartao {

	@Id
	@SequenceGenerator(name="carta_seq",sequenceName="cartao_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="cartao_seq")
	
	@Column(name = "id_cartao", nullable = false)
	private Long id;
	
	@Column(name = "nr_cartao", nullable = false)
	private String numeroCartao;

	@Column(name = "dt_validade", nullable = false)
	private Date validade;
	
	@ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;	
	
	@ManyToOne
    @JoinColumn(name = "id_telefone")
    private Telefone telefone;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}


	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
