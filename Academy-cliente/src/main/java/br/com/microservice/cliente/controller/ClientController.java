package br.com.microservice.cliente.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.microservice.cliente.model.Client;
import br.com.microservice.cliente.service.ClientService;

@RestController
@RequestMapping("/cliente")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<Client> listaCliente(){
		return clientService.listar();
		
	}
	@PostMapping
	public ResponseEntity<Client> cadastrar (@Valid @RequestBody Client cliente, UriComponentsBuilder uriComponente) {
		cliente = clientService.adicionar(cliente);
		URI uri = uriComponente.path("/cliente/{id}")
				.buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
		
	}
	@GetMapping("/{clienteId}")
	public ResponseEntity<Client> buscar (@PathVariable  Long clienteId) {
		return clientService.buscarPorId(clienteId);
	}
	@PutMapping("/{clienteId}")
	public ResponseEntity<Client> atualizar (@PathVariable Long clienteId,@RequestBody @Valid Client cliente) {
		return clientService.update(clienteId, cliente);
	}
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long clienteId)	{
		return clientService.deletar(clienteId);
	}

}
