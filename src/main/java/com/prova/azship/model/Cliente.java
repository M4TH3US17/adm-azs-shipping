package com.prova.azship.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "cliente")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String contato;
	
	@OneToOne
	private Endereco endereco;
	
	public Cliente(String nome, String email, String contato, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.contato = contato;
		this.endereco = endereco;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}
