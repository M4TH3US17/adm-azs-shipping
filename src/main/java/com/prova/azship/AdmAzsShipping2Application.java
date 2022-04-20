package com.prova.azship;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prova.azship.model.Cliente;
import com.prova.azship.model.Endereco;
import com.prova.azship.model.Frete;
import com.prova.azship.model.Mercadoria;
import com.prova.azship.model.enums.TipoTransporte;
import com.prova.azship.repositories.ClienteRepository;
import com.prova.azship.repositories.EnderecoRepository;
import com.prova.azship.repositories.FreteRepository;
import com.prova.azship.repositories.MercadoriaRepository;

@SpringBootApplication
public class AdmAzsShipping2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdmAzsShipping2Application.class, args);
	}
		
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private MercadoriaRepository mercadoriaRepository;
	@Autowired
	private FreteRepository freteRepository;

	@Override
	public void run(String... args) throws Exception {
		Endereco endereco1 = enderecoRepository.save(new Endereco(1, "Av. Samaúma", "Amazonas", "Manaus", "Cidade Nova", 517));
		Endereco endereco2 = enderecoRepository.save(new Endereco(2, "Av. Timbiras", "Tocantins", "Augustinópolis", "Cidade de Deus", 231));
		enderecoRepository.save(new Endereco(3, "Rua Pedro I", "Pará", "Belém", "Bairro Figueiredo", 221));
		
		Cliente cliente1 = clienteRepository.save(new Cliente(1L, "Matheus Dalvino", "matheusdalvino50@gmail.com", "(92) 99270-2070", endereco1));
		Cliente cliente2 = clienteRepository.save(new Cliente(2L, "Maria Joana", "maria@gmail.com", "(92) 99270-2070", endereco2));
		
		Mercadoria mercadoria1 = mercadoriaRepository.save(new Mercadoria(0.80, 0.80, 1.0, 2, TipoTransporte.RODOVIARIO));
		Mercadoria mercadoria2 = mercadoriaRepository.save(new Mercadoria(0.80, 0.80, 1.0, 1, TipoTransporte.RODOVIARIO));
		Mercadoria mercadoria3 = mercadoriaRepository.save(new Mercadoria(0.80, 0.80, 1.0, 1, TipoTransporte.AEREO));
		
		freteRepository.save(new Frete(1L, Arrays.asList(mercadoria1, mercadoria2), cliente1));
		freteRepository.save(new Frete(2L, Arrays.asList(mercadoria3), cliente2));
	}

}
