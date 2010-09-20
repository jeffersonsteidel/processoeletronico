package br.com.progepe.entity;

import java.io.Serializable;

public class Cargo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private Classe classe;

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

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
}
