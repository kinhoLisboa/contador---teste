package br.com.microservice.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.cliente.model.Telefone;
import br.com.microservice.cliente.repository.Telefonerepository;

@Service

public class TelefoneService {
	
	@Autowired
	private Telefonerepository telefoneRepository;
	
	@Transactional
	public Telefone salvar( Telefone telefone) {
		return telefoneRepository.save(telefone);
		
	}
	

}
