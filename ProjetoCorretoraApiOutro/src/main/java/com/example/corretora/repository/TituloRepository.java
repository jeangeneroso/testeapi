package com.example.corretora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.corretora.datasource.model.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {

	Object findAll(String emissor);

}
