package com.example.corretora.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.corretora.repository.TituloRepository;

import com.example.corretora.datasource.model.Titulo;

@Service
public class BuscarTituloServiceImpl {
	
	/*private static final Logger LOG = Logger.getLogger(BuscarTituloServiceImpl.class);*/
	private static final Logger LOG = Logger.getLogger(BuscarTituloServiceImpl.class);
	
	@Autowired
	private TituloRepository tituloRepository;
	
	public List<Titulo> buscarTodosOsTitulos(){
		LOG.info(" Iniciando o serviço ");
		List<Titulo> listTitulo =  tituloRepository.findAll();
		return listTitulo;
		
	}

}
