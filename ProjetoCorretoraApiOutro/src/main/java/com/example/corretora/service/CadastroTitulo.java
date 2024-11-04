package com.example.corretora.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.corretora.datasource.model.Titulo;
import com.example.corretora.repository.TituloRepository;

public class CadastroTitulo {
	
	@Autowired
	private TituloRepository tituloRepository;

	public void buscarPorEmissor() {
		Optional<Titulo> titulos = tituloRepository.findById(1L);
		Titulo titulo =  titulos.get();
		
	}
	
	public void cadastrar(Titulo titulo) {
		tituloRepository.saveAndFlush(titulo);
		
	}

}
