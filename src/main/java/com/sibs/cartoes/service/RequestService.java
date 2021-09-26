package com.sibs.cartoes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.sibs.cartoes.dto.Cartoes;
import com.sibs.cartoes.dto.Request;
import com.sibs.cartoes.dto.Response;
import com.sibs.cartoes.dto.ResponseBase;
import com.sibs.cartoes.entity.Banco;
import com.sibs.cartoes.entity.Cartao;
import com.sibs.cartoes.entity.Telefone;
import com.sibs.cartoes.repository.BancoRepository;
import com.sibs.cartoes.repository.CartaoRepository;
import com.sibs.cartoes.repository.TelefoneRepository;

@Service
public class RequestService {

	@Autowired
	private TelefoneRepository telefoneRepository;	
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	
	public Response findTelefoneByNumber(String telefone) {
		Response response = new Response();
		
		try {
			populaResponse(telefoneRepository.findTelefoneByNumber(telefone),response);
			response.setMensagem(Response.SUCESSO);
		}catch (Exception e) {
			response.setMensagem(Response.ERRO+e.getMessage());
		}
		
				
		return response;
	}
	

	private void populaResponse(Telefone telefone,Response response) throws Exception {
		
		if(telefone == null ) {
			 throw new Exception("Telefone não encontrado");
		}else {
		
			response.setTelefone(telefone.getNumeroTelefone());
			
			List<Cartoes> c = new ArrayList<Cartoes>();
			
			for(Cartao cartao: telefone.getCartoes()) {
				Cartoes cartoes = new Cartoes();
				cartoes.setNumero(cartao.getNumeroCartao());
				cartoes.setBanco(cartao.getBanco().getCodigo());
				cartoes.setValidade(cartao.getValidade());
				c.add(cartoes);
			}
			response.setUltimaAlteracao(telefone.getDataAtualização());
			
			response.setCartoes(c);
			
		}
		
	}
	
	public ResponseBase updateRegistro(Request request) {
		
		ResponseBase retorno = new ResponseBase();
		
		try {
			
			isBancoValido(request.getCartoes());
			
			procuraAtualzaCartoes(request);	
			retorno.setMensagemRetorno(ResponseBase.ATUALIZACAO_REGISTRO);
		}catch (Exception e) {
			
			retorno.setMensagemRetorno(ResponseBase.ERRO+e.getMessage());			
		}
				
		return retorno;
	}
	
	@Transactional
	private void procuraAtualzaCartoes(Request request) throws Exception {
		
		Telefone telefone = telefoneRepository.findTelefoneByNumber(request.getTelefone());
		
		if(telefone == null) {
			 throw new Exception("Telefone não encontrado");
		}else {
			cartaoRepository.deleteAll(telefone.getCartoes());
			telefoneRepository.delete(telefone);
		}
		
		telefone.setDataAtualização(new Date());
		
		telefoneRepository.save( populaEntidadeCartao(telefone, request.getCartoes()) );		
		
	}
	
	
	public ResponseBase gravaNovoRegistro(Request request) {
		
		ResponseBase retorno = new ResponseBase();
				
		try {
			
			isBancoValido(request.getCartoes());
			isTelefoneNovo(request.getTelefone());
			
			populaGravaEntidadeTelefone(request);	
			retorno.setMensagemRetorno(ResponseBase.NOVO_REGISTRO);
		}catch (Exception e) {
			
			retorno.setMensagemRetorno(ResponseBase.ERRO+e.getMessage());			
		}
				
		return retorno;
		
	}

	private void isTelefoneNovo(String telefone) throws Exception {
		
		Telefone tel = telefoneRepository.findTelefoneByNumber(telefone);
		
		if(tel != null) {
			 throw new Exception("Telefone ja cadastrado");
		}
	}
	
	private void populaGravaEntidadeTelefone(Request request) {
	
		Telefone telefone = new Telefone();
		
		telefone.setNumeroTelefone(request.getTelefone());
		telefone.setDataAtualização(new Date());
		
		telefoneRepository.save( populaEntidadeCartao(telefone, request.getCartoes()) );		
		
	}
	
	private Telefone populaEntidadeCartao(Telefone telefone, List<Cartoes> cartoesrequest) {
		List<Cartao> listaCartoes = new ArrayList<Cartao>();		
		
		for (Cartoes cartoes: cartoesrequest) {
			Cartao car = new Cartao();
				car.setNumeroCartao(cartoes.getNumero());
				car.setValidade(cartoes.getValidade());
				car.setTelefone(telefone);
				car.setBanco(bancoRepository.findBancoByCodigo(cartoes.getBanco()));
			listaCartoes.add(car);
		}
		
		telefone.setCartoes(listaCartoes);
		
		return telefone;
		
		
	}
	
	private void isBancoValido(List<Cartoes> cartoes) throws Exception {
		
		for (Cartoes cc: cartoes) {
			Banco banco = bancoRepository.findBancoByCodigo(cc.getBanco()); 
			if(banco == null) {
				 throw new Exception("Banco não existente");
			 }
		}
		
	}
}
