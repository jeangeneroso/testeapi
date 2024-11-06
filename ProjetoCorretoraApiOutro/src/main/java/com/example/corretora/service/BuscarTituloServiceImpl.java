package com.example.corretora.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.corretora.repository.TituloRepository;

import com.example.corretora.datasource.model.Titulo;

@Service
public class BuscarTituloServiceImpl<Lastro> {

	/*
	 * private static final Logger LOG =
	 * Logger.getLogger(BuscarTituloServiceImpl.class);
	 */
	private static final Logger LOG = Logger.getLogger(BuscarTituloServiceImpl.class);

	@Autowired
	private TituloRepository tituloRepository;

	public List<Titulo> buscarTodosOsTitulos() {
		LOG.info(" Iniciando o serviço ");
		List<Titulo> listTitulo = tituloRepository.findAll();
		return listTitulo;
	}

	public ResponseEntity<Object> buscarTitulosMaster(@PathVariable(name = "emissor", required = true) String emissor) {
		LOG.info(" Iniciando o serviço ");
		if (emissor == " Banco Master SA " && emissor == " Banco Master de Investimentos SA ") {
			return ResponseEntity.ok(tituloRepository.findAll(emissor));

		} /*
			 * else {
			 * 
			 * return
			 * ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Requisição não encontrada"
			 * ); }
			 */

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Requisição não encontrada");
	}

	public ResponseEntity<Object> buscarTitulosOutrosEmissores(
			@PathVariable(name = "emissor", required = true) String emissor) {
		if (emissor != " Banco Master SA " && emissor != " Banco Master de Investimentos SA ") {
			return ResponseEntity.ok(tituloRepository.findAll(emissor));

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Requisição não encontrada");
	}

	public List<Titulo> buscarLastro() {
		double lastro;
		if (lastro < 700.00) {
			return (List<Titulo>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Requisição não encontrada");
		} else if (lastro >= 700.00) {
			List<Titulo> listTitulo = tituloRepository.findAll();
			return listTitulo;
		}

	}

	/*
	 * public List<Titulo> buscarTodosOsTitulos() {
	 * LOG.info(" Iniciando o serviço "); if (emissor != null) { List<Titulo>
	 * listTitulo = tituloRepository.findAll(); return listTitulo;
	 * 
	 * } else { return (List<Titulo>)
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Requisição não encontrada"
	 * );
	 * 
	 * }
	 * 
	 * }
	 */

}
