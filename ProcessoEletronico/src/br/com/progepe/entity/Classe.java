package br.com.progepe.entity;

import java.io.Serializable;

public class Classe implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String sigla;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
