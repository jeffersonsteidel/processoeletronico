package br.com.progepe.entity;

import java.io.Serializable;

public class TipoDocumento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4907890108698701588L;
	private Long codigo;
	private String descricao;

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

}
