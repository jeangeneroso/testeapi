package com.example.corretora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corretora.datasource.model.Titulo;
import com.example.corretora.repository.TituloRepository;
import com.example.corretora.service.BuscarTituloServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class TituloController {

	@Autowired
	private TituloRepository tituloRepository;
	
	@Autowired
	private BuscarTituloServiceImpl serviceBuscar;

	@GetMapping
	public List<Titulo> buscarTitulo() {
	return serviceBuscar.buscarTodosOsTitulos();

	}

	@GetMapping(path = "api/titulo-emissor_master")
	public ResponseEntity<Object> buscarTitulosMaster(@PathVariable(name = "emissor", required = true) String emissor) {
		if (emissor == " Banco Master SA " && emissor == " Banco Master de Investimentos SA ") {
			return ResponseEntity.ok(tituloRepository.findAll(emissor));

		}
		/* return (ResponseEntity<Object>) tituloRepository.findAll(); */
		return null;
	}

	@GetMapping(path = "api/titulo-emissor")
	public ResponseEntity<Object> buscarTitulosOutrosEmissores(@PathVariable(name = "emissor", required = true) String emissor) {
		if (emissor != " Banco Master SA " && emissor != " Banco Master de Investimentos SA ") {
			return ResponseEntity.ok(tituloRepository.findAll(emissor));

		}
		/* return (ResponseEntity<Object>) tituloRepository.findAll(); */
		return null;
	}

}
