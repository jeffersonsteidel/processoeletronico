package br.com.progepe.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grupo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private Set<Acao> acoes = new HashSet<Acao>();

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

	public Set<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(Set<Acao> acoes) {
		this.acoes = acoes;
	}

}
