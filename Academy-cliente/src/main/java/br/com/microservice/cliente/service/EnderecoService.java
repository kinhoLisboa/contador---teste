package br.com.microservice.cliente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.cliente.model.Endereco;
import br.com.microservice.cliente.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public Endereco salvar ( Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
}
