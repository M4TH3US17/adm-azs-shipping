package com.prova.azship.model.enums;

public enum TipoTransporte {

	RODOVIARIO("Rodoviario"), 
	AEREO("Aereo"),
	HIDROVIARIO("Hidroviario");
	
	private String type;

	TipoTransporte() {
	}
	
	TipoTransporte(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
