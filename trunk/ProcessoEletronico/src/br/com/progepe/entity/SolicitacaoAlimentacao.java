package br.com.progepe.entity;

import java.io.Serializable;

public class SolicitacaoAlimentacao extends Solicitacao implements Serializable{

	private static final long serialVersionUID = 1L;
		
	private Boolean indAlimentacao = false;

	public Boolean getIndAlimentacao() {
		return indAlimentacao;
	}

	public void setIndAlimentacao(Boolean indAlimentacao) {
		this.indAlimentacao = indAlimentacao;
	}
	
	
}
