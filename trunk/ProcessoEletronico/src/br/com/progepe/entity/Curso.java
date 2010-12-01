package br.com.progepe.entity;

import java.io.Serializable;

public class Curso implements Serializable {

	private static final long serialVersionUID = 1074452354548565445L;
	
	private Integer codigo;
	private String descricao;
	private Lotacao lotacao;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Lotacao getLotacao() {
		return lotacao;
	}
	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}
}

