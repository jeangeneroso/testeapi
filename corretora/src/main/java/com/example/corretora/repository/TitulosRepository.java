package com.example.corretora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.corretora.model.Titulos;

@Repository
public interface TitulosRepository extends JpaRepository<Titulos, Long> {

}
