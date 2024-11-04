package com.example.corretora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.corretora.repository.TituloRepository;

@RestController
public class TituloController {
	
	@Autowired
	private TituloRepository tituloRepository;
	
	@GetMapping(path = "api/titulo-emissor_master")
	public ResponseEntity<Object> buscarTitulosMaster(@PathVariable(name = "emissor", required = true) String emissor ) {
		if(emissor == " Banco Master SA " && emissor == " Banco Master de Investimentos SA ") {
			return ResponseEntity.ok(tituloRepository.findAll(emissor));
			
		}
		/*return (ResponseEntity<Object>) tituloRepository.findAll();*/
		return null;
	}
	
	@GetMapping(path = "api/titulo-emissor")
	public ResponseEntity<Object> buscarTitulosOutrosEmissores(@PathVariable(name = "emissor", required = true) String emissor ) {
		if(emissor != " Banco Master SA " && emissor != " Banco Master de Investimentos SA ") {
			return ResponseEntity.ok(tituloRepository.findAll(emissor));
			
		}
		/*return (ResponseEntity<Object>) tituloRepository.findAll();*/
		return null;
	}


}
