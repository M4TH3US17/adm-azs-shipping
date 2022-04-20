package com.prova.azship.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prova.azship.input.ClienteInput;
import com.prova.azship.model.Cliente;
import com.prova.azship.model.Endereco;
import com.prova.azship.repositories.ClienteRepository;
import com.prova.azship.repositories.EnderecoRepository;

@Component
public class ClienteResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Cliente> findAllCliente() {
		return repository.findAll();
	}

	public Cliente findClienteById(Long id) {
		return repository.findById(id).get();
	}

	public Cliente createCliente(ClienteInput input) {
		Endereco endereco = enderecoRepository.findById(input.getEnderecoId()).get();
		return repository.save(new Cliente(input.getName(), input.getEmail(), input.getContato(), endereco));
	}

	public Cliente updateCliente(Long id, String nome, String email, String contato) {
		Cliente obj = repository.findById(id).get();
		if (nome != null) {
			obj.setNome(nome);
		}
		if (email != null) {
			obj.setEmail(email);
		}
		if (contato != null) {
			obj.setContato(contato);
		}
		return obj;
	}
}
