package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Imigrante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Servidor servidor;
	private Conjuge conjuge;
	private Pais pais;
	private Date dataChegadaPais;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Conjuge getConjuge() {
		return conjuge;
	}

	public void setConjuge(Conjuge conjuge) {
		this.conjuge = conjuge;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Date getDataChegadaPais() {
		return dataChegadaPais;
	}

	public void setDataChegadaPais(Date dataChegadaPais) {
		this.dataChegadaPais = dataChegadaPais;
	}
}

