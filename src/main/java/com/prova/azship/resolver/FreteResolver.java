package com.prova.azship.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prova.azship.input.FreteInput;
import com.prova.azship.model.Frete;
import com.prova.azship.repositories.ClienteRepository;
import com.prova.azship.repositories.FreteRepository;

@Component
public class FreteResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private FreteRepository repository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Frete> findAllFrete() {
		return repository.findAll();
	}
	
	public Frete findFreteById(Long id) {
		return repository.findById(id).get();
	}
	
	public Boolean deleteFreteById(Long id) {
		if(repository.existsById(id) == true) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Frete createFrete(FreteInput input) {
		return repository.save(new Frete(
				input.getMercadorias(),
				clienteRepository.findById(input.getClienteId()).get()
				));
	}

	public Frete updateFrete(Long id, Long clienteId) {
		Frete obj = repository.findById(id).get();
		if(clienteId != null) {
			obj.setCliente(clienteRepository.findById(id).get());
		}
		return repository.save(obj);
	}
	
}
