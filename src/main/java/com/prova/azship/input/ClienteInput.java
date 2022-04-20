package com.prova.azship.input;

import graphql.schema.GraphQLInputType;
import lombok.*;

@Getter @Setter
public class ClienteInput implements GraphQLInputType {

	private String nome;
	private String email;
	private String contato;
	private Integer enderecoId;
	
	@Override
	public String getName() {
		return nome;
	}

}
