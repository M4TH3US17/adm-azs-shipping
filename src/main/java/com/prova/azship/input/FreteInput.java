package com.prova.azship.input;

import java.util.List;

import com.prova.azship.model.Mercadoria;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FreteInput implements GraphQLInputType {

	private Long clienteId;
	private List<Mercadoria> mercadorias;
	
	@Override
	public String getName() {
		return "";
	}

}
