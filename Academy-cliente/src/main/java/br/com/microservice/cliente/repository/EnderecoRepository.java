package br.com.microservice.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.cliente.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

}
