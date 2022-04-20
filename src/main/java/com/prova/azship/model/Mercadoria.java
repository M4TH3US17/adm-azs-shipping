package com.prova.azship.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prova.azship.model.enums.TipoTransporte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mercadoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mercadoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoTransporte transporte;

	private Double largura;
	private Double altura;
	private Double profundidade;
	private Integer quantidade;

	private Double cubagem;
	private Double pesoCubado;

	public Mercadoria(Double largura, Double altura, Double profundidade, Integer quantidade,
			TipoTransporte transporte) {
		this.altura = altura;
		this.largura = largura;
		this.quantidade = quantidade;
		this.profundidade = profundidade;
		this.transporte = transporte;
		this.pesoCubado = getPesoCubado();
		this.cubagem = getCubagem();
	}

	public Double getPesoCubado() {
		Double result = 0.0;
		Double cubagem = largura * altura * profundidade;

		if (transporte.getType().equalsIgnoreCase("Rodoviario")) {
			result = 300.0 * cubagem;
		} else if (getTransporte().getType().equalsIgnoreCase("Hidroviario")) {
			result = 1000.0 * cubagem;
		} else if (getTransporte().getType().equalsIgnoreCase("Aereo")) {
			result = 166.7 * cubagem;
		}
		return result * quantidade;
	}

	public Double getCubagem() {
		Double pesoCubado = (largura * altura * profundidade) * quantidade;
		return pesoCubado;
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
		Mercadoria other = (Mercadoria) obj;
		return Objects.equals(id, other.id);
	}

}
