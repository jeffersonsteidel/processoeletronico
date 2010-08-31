package br.com.progepe.entity;

import java.io.Serializable;

public class Estado implements Serializable {

	private static final long serialVersionUID = -8444634627158933299L;
	
	private Long codigo;
	private String descricao;
	private String uf;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
