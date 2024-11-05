package com.example.corretora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corretora.repository.TituloRepository;

import com.example.corretora.datasource.model.Titulo;

@Service
public class BuscarTituloServiceImpl {
	
	@Autowired
	private TituloRepository tituloRepository;
	
	public List<Titulo> buscarTodosOsTitulos(){
		List<Titulo> listTitulo =  tituloRepository.findAll();
		return listTitulo;
		
	}

}
