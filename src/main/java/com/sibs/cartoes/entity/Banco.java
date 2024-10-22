package com.sibs.cartoes.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "t_banco")
public class Banco {

	@Id
	@SequenceGenerator(name="banco_seq",sequenceName="banco_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="banco_seq")
	
	@Column(name = "id_banco", nullable = false)
	private Long id;

	@Column(name = "c_banco", nullable = false)
	private String codigo;

	@Column(name = "nm_banco", nullable = false)
	private String nome;

	@Column(name = "dt_atualizacao", nullable = false)
	private Date dataAtualização;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAtualização() {
		return dataAtualização;
	}

	public void setDataAtualização(Date dataAtualização) {
		this.dataAtualização = dataAtualização;
	}

	
}
