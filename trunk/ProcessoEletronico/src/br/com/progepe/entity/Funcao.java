package br.com.progepe.entity;

import java.io.Serializable;

public class Funcao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private TipoFuncao tipoFuncao;
		
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

	public TipoFuncao getTipoFuncao() {
		return tipoFuncao;
	}

	public void setTipoFuncao(TipoFuncao tipoFuncao) {
		this.tipoFuncao = tipoFuncao;
	}

}
