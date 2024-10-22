package com.sibs.cartoes.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_telefone")
public class Telefone {

	@Id
	@SequenceGenerator(name="telefone_seq",sequenceName="telefone_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="telefone_seq")
	
	@Column(name = "id_telefone", nullable = false)
	private Long id;

	@Column(name = "nr_telefone", nullable = false)
	private String numeroTelefone;

	@Column(name = "dt_atualizacao", nullable = false)
	private Date dataAtualização;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id")
    private List<Cartao> cartoes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAtualização() {
		return dataAtualização;
	}

	public void setDataAtualização(Date dataAtualização) {
		this.dataAtualização = dataAtualização;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	
	
}
