package com.prova.azship.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.prova.azship.input.MercadoriaInput;
import com.prova.azship.model.Mercadoria;
import com.prova.azship.model.enums.TipoTransporte;
import com.prova.azship.repositories.MercadoriaRepository;

@Component
public class MercadoriaResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private MercadoriaRepository repository;

	public List<Mercadoria> findAllMercadoria() {
		return repository.findAll();
	}

	public Mercadoria findMercadoriaById(Long id) {
		return repository.findById(id).get();
	}

	public Mercadoria createMercadoria(MercadoriaInput input) {
		return repository.save(new Mercadoria(input.getLargura(), input.getAltura(), input.getProfundidade(),
				input.getQuantidade(), input.getTransporte()));
	}

	public Mercadoria updateMercadoria(Long id, Double largura, Double altura, Double profundidade, Integer quantidade,
			TipoTransporte transporte) {

		Mercadoria obj = repository.findById(id).get();
		if (largura != null) {
			obj.setLargura(largura);
		}
		if (altura != null) {
			obj.setAltura(altura);
		}
		if (transporte != null) {
			obj.setTransporte(transporte);
		}
		if (profundidade != null) {
			obj.setProfundidade(profundidade);
		}
		if (quantidade != null) {
			obj.setQuantidade(quantidade);
		}
		return repository.save(obj);
	}
}
