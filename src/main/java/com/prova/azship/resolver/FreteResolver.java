package com.prova.azship.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prova.azship.input.FreteInput;
import com.prova.azship.model.Frete;
import com.prova.azship.model.Mercadoria;
import com.prova.azship.repositories.ClienteRepository;
import com.prova.azship.repositories.FreteRepository;
import com.prova.azship.repositories.MercadoriaRepository;

@Component
public class FreteResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private FreteRepository repository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private MercadoriaRepository mercadoriaRepository;

	public List<Frete> findAllFrete() {
		return repository.findAll();
	}

	public Frete findFreteById(Long id) {
		return repository.findById(id).get();
	}

	public Boolean deleteFreteById(Long id) {
		if (repository.existsById(id) == true) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Frete createFrete(FreteInput input) {
		Mercadoria mercadoria = mercadoriaRepository.getById(input.getMercadoriaId());
		return repository.save(new Frete(mercadoria, clienteRepository.findById(input.getClienteId()).get()));
	}

	public Frete addItemFrete(Long id, Long mId, Long mId2, 
			Long mId3, Long mId4, Long mId5) {
		Frete obj = repository.findById(id).get();
		if (mId != null) {
			obj.getMercadorias().add(
					mercadoriaRepository.getById(mId));
		}
		if (mId2 != null) {
			obj.getMercadorias().add(
					mercadoriaRepository.getById(mId2));
		}
		if (mId3 != null) {
			obj.getMercadorias().add(
					mercadoriaRepository.getById(mId3));
		}
		if (mId4 != null) {
			obj.getMercadorias().add(
					mercadoriaRepository.getById(mId4));
		}
		if (mId5 != null) {
			obj.getMercadorias().add(
					mercadoriaRepository.getById(mId5));
		}
		return repository.save(obj);
	}

}
