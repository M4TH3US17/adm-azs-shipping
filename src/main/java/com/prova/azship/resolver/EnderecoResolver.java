package com.prova.azship.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prova.azship.input.EnderecoInput;
import com.prova.azship.model.Endereco;
import com.prova.azship.repositories.EnderecoRepository;

@Component
public class EnderecoResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private EnderecoRepository repository;

	public List<Endereco> findAllEndereco() {
		return repository.findAll();
	}

	public Endereco createEndereco(EnderecoInput input) {
		return repository.save(new Endereco(input.getName(), input.getEstado(), input.getCidade(), input.getBairro(),
				input.getNumCasa()));
	}

	public Endereco findByEnderecoId(Integer id) {
		return repository.findById(id).get();
	}

	public Endereco updateEndereco(Integer id, String rua, String estado, String bairro, String cidade, Integer numCasa) {
		Endereco obj = repository.findById(id).get();
		if (estado != null) {
			obj.setEstado(estado);
		} 
		if(rua != null) {
			obj.setRua(rua);
		}
		if(numCasa != null) {
			obj.setNumCasa(numCasa);
		}
		if(bairro != null) {
			obj.setBairro(bairro);
		}
		if(cidade != null) {
			obj.setCidade(cidade);
		}
		return repository.save(obj);
	}
}
