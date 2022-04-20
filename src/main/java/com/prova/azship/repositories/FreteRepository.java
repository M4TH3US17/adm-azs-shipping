package com.prova.azship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.azship.model.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>{

}
