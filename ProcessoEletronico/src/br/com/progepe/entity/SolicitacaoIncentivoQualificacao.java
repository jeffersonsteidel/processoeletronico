package br.com.progepe.entity;

import java.io.Serializable;

public class SolicitacaoIncentivoQualificacao extends Solicitacao implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private ServidorTitulacao servidorTitulacao;
	private Boolean indQualificacaoDireta;
	private String portaria;

	public ServidorTitulacao getServidorTitulacao() {
		return servidorTitulacao;
	}

	public void setServidorTitulacao(ServidorTitulacao servidorTitulacao) {
		this.servidorTitulacao = servidorTitulacao;
	}

	public Boolean getIndQualificacaoDireta() {
		return indQualificacaoDireta;
	}

	public void setIndQualificacaoDireta(Boolean indQualificacaoDireta) {
		this.indQualificacaoDireta = indQualificacaoDireta;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

}