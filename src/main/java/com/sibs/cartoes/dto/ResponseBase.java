package com.sibs.cartoes.dto;

import java.util.Date;

public class ResponseBase{

private Date dataUltimaAtualização = new Date();
private String mensagemRetorno; 

public static final String NOVO_REGISTRO = "Novo registro adicionado com Sucesso";
public static final String ATUALIZACAO_REGISTRO = "Atualização realizada com Sucesso";
public static final String ERRO = "Erro: ";

public String getMensagemRetorno() {
	return mensagemRetorno;
}

public void setMensagemRetorno(String mensagemRetorno) {
	this.mensagemRetorno = mensagemRetorno;
}

public Date getDataUltimaAtualização() {
	return dataUltimaAtualização;
}

public void setDataUltimaAtualização(Date dataUltimaAtualização) {
	this.dataUltimaAtualização = dataUltimaAtualização;
}

		
}
