package com.prova.azship.input;

import com.prova.azship.model.enums.TipoTransporte;

import graphql.schema.GraphQLInputType;
import lombok.*;

@Getter @Setter
public class MercadoriaInput implements GraphQLInputType {

	private Double largura;
	private Double altura;
	private Double profundidade;
	private Integer quantidade;
	private TipoTransporte transporte;
	
	@Override
	public String getName() {
		return transporte.getType();
	}

}
