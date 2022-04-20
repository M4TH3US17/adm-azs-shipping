package com.prova.azship.input;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FreteInput implements GraphQLInputType {

	private Long clienteId;
	private Long mercadoriaId;
	
	@Override
	public String getName() {
		return mercadoriaId.toString();
	}

}
