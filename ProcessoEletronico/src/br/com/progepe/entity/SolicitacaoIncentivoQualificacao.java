package br.com.progepe.entity;

import java.io.Serializable;

public class SolicitacaoIncentivoQualificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private ServidorTitulacao titulacao;
	private Boolean incQualificacaoDireta;
	private String portaria;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public ServidorTitulacao getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(ServidorTitulacao titulacao) {
		this.titulacao = titulacao;
	}

	public Boolean getIncQualificacaoDireta() {
		return incQualificacaoDireta;
	}

	public void setIncQualificacaoDireta(Boolean incQualificacaoDireta) {
		this.incQualificacaoDireta = incQualificacaoDireta;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

}