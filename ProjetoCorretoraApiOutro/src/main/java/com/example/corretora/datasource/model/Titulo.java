package com.example.corretora.datasource.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "titulo")
public class Titulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;

	@Column(name = "nome_emissor")
	private String emissor;

	private LocalDate dataVencimento;
	private double taxa;
	private double lastro;

	/*@SuppressWarnings("unused") // Quando tem essa anotação é que não vai utilizar esse construtor
	public Titulo(long id, String emissor, LocalDate dataVencimento, double taxa, double lastro) {
		this.id = id;
		this.emissor = emissor;
		this.dataVencimento = dataVencimento;
		this.taxa = taxa;
		this.lastro = lastro;
	}*/


	public Titulo() {
		// TODO Stub de construtor gerado automaticamente
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public double getLastro() {
		return lastro;
	}

	public void setLastro(double lastro) {
		this.lastro = lastro;
	}

}
