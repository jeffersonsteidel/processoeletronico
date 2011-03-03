package br.com.progepe.entity;

import java.io.Serializable;

public class Padrao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Integer nivel;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
}
