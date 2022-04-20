package com.prova.azship.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "endereco")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rua;
	private String estado;
	private String cidade;
	private String bairro;
	@Column(name = "numero_casa")
	private Integer numCasa;
	
	public Endereco(String rua, String estado, String cidade, String bairro, Integer numCasa) {
		this.rua = rua;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numCasa = numCasa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
}
