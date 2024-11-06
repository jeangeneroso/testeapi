package com.example.corretora.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.corretora.repository.TituloRepository;
import com.example.corretora.datasource.model.Titulo;

@Service
public class BuscarTituloServiceImpl {

	/*
	 * private static final Logger LOG =
	 * Logger.getLogger(BuscarTituloServiceImpl.class);
	 */
	private static final Logger LOG = Logger.getLogger(BuscarTituloServiceImpl.class);

	@Autowired
	private TituloRepository tituloRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Titulo> buscarTodosOsTitulos() {
		LOG.info(" Iniciando o serviço ");
		List<Titulo> listTitulo = tituloRepository.findAll();
		String url = "https://experiencia.xpi.com.br/renda-fixa/#/emissao-bancaria";
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		} catch (Exception e) {
			LOG.severe(" Erro ao chamar a URL da XP: " + e.getMessage());
		}
		return listTitulo;
	}

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

	public ResponseEntity<Object> buscarTitulosOutrosEmissores(
			@PathVariable(name = "emissor", required = true) String emissor) {
		if (!emissor.equals("Banco Master SA") && !emissor.equals("Banco Master de Investimentos SA")) {
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

	public List<Titulo> buscarLastro() {
		double lastro = 0;
		if (lastro < 700.00) {
			return (List<Titulo>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Requisição não encontrada");
		} else if (lastro >= 700.00) {
			String url = "https://experiencia.xpi.com.br/renda-fixa/#/emissao-bancaria";
			try {
				
				ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
				LOG.info(" Retorno " + response.getBody());
				
				List<Titulo> listTitulo = tituloRepository.findAll();
				return listTitulo;
				
			} catch (Exception e) {
				LOG.severe("Erro ao chamar a URL: " + e.getMessage());
				return(List<Titulo>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao chamar a URL");
			}
			
		}
		
		return null;

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
