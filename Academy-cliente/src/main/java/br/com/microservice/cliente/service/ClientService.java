package br.com.microservice.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.cliente.handle.exception.clientNotFoudException;
import br.com.microservice.cliente.model.Client;
import br.com.microservice.cliente.model.Endereco;
import br.com.microservice.cliente.repository.ClientRepository;
import br.com.microservice.cliente.repository.EnderecoRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> listar(){
		return (List<Client>) clientRepository.findAll();
	}
	@Transactional
	public Client adicionar(Client cliente) {
	
		return clientRepository.save(cliente);
	}
	@Transactional
	public ResponseEntity<Client> buscarPorId(Long clienteId) {
		return clientRepository.findById(clienteId)
				.map( cliente -> ResponseEntity.ok(cliente))
				.orElseThrow(()-> new clientNotFoudException("Cliente com o id :"+ clienteId + "não existe." ));
			
	}
	@Transactional
	public ResponseEntity<Client> update(Long clienteId, Client cliente) {
		if(!clientRepository.existsById(clienteId)) {
			throw new clientNotFoudException("Cliente de id: "+ clienteId + " não encontrado.");
		}
		cliente.setId(clienteId);
		cliente = clientRepository.save(cliente);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Void> deletar(Long clienteId) {
		if(!clientRepository.existsById(clienteId)) {
			throw new clientNotFoudException("Cliente de id:" +clienteId+" não existe ");
		}
		clientRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}
	
	

	
}
	



