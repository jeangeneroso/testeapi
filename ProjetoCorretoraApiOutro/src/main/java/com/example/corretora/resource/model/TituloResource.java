package com.example.corretora.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TituloResource {
	
	@JsonProperty("nome_emissor")
	private String emissor;
	
	@JsonProperty("taxa_emissor")
	private double taxa;
	
	public TituloResource(String emissor, double taxa) {
		this.emissor = emissor;
		this.taxa = taxa;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
}
