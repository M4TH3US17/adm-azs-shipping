package com.prova.azship.input;

import graphql.schema.GraphQLInputType;
import lombok.*;

@Getter @Setter
public class EnderecoInput implements GraphQLInputType {
	
	private String rua;
	private String estado;
	private String cidade;
	private String bairro;
	private Integer numCasa;

	@Override
	public String getName() {
		return rua;
	}

}
