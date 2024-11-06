package com.example.corretora.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.corretora.repository.TituloRepository;

@Service
public class BuscarTitulosMasterServiceImpl {
	
	private static final Logger LOG = Logger.getLogger(BuscarTituloServiceImpl.class);

	@Autowired
	private TituloRepository tituloRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<Object> buscarTitulosMaster(@PathVariable(name = "emissor", required = true) String emissor) {
		LOG.info(" Iniciando o serviço ");
		if (emissor.equals(" Banco Master SA ") && emissor.equals(" Banco Master de Investimentos SA ")) {
			String url = "https://experiencia.xpi.com.br/renda-fixa/#/emissao-bancaria";
			try {
				ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
				return ResponseEntity.ok(response.getBody());
			} catch (Exception e) {
				LOG.severe("Erro ao chamar a URL: " + e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao chamar a URL");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emissor não encontrado");

	}

}
