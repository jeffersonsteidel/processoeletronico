package br.com.progepe.entity;

import java.io.Serializable;

public class TipoFuncao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private String sigla;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
