package com.sibs.cartoes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sibs.cartoes.dto.Request;
import com.sibs.cartoes.dto.Response;
import com.sibs.cartoes.dto.ResponseBase;
import com.sibs.cartoes.entity.Telefone;
import com.sibs.cartoes.service.RequestService;


@RestController
@RequestMapping("/sibs")
public class SibsController {

	@Autowired
	private RequestService requestService;	
		
		@GetMapping
		public Response getTelefoneCartoes(String telefone) {
			return requestService.findTelefoneByNumber(telefone);
		}
		
		@PostMapping
		public ResponseBase saveTelefoneCartoes(@RequestBody Request request) throws Exception {
			return requestService.gravaNovoRegistro(request);
		}

		@PutMapping
		public ResponseBase updateTelefoneCartoes(@RequestBody Request request) throws Exception {
			return requestService.updateRegistro(request);
		}
}
