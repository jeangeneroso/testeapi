package com.example.corretora.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;

/*import java.util.Date;*/

public class Titulo {

	@Id
	private Long id;

	@Column
	private String emissor;
	private double taxa;
	private Date dataAplicacao;
	private Date dataVencimento;

	public Titulo(Long id, String emissor, Date dataVencimento, double taxa, double lastro) {
		this.id = id;
		this.emissor = emissor;
		this.dataVencimento = dataVencimento;
		this.taxa = taxa;
	}

	@SuppressWarnings("unused") // Quando tem essa anotação é que não vai utilizar esse construtor
	private Titulo() {
		// TODO Stub de construtor gerado automaticamente
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

}
