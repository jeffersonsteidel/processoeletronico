package br.com.progepe.entity;

import java.io.Serializable;

public class ProgressaoCapacitacaoCertificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private SolicitacaoProgressaoCapacitacao solicitacaoProgressaoCapacitacao;
	private byte[] certificado;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public SolicitacaoProgressaoCapacitacao getSolicitacaoProgressaoCapacitacao() {
		return solicitacaoProgressaoCapacitacao;
	}

	public void setSolicitacaoProgressaoCapacitacao(
			SolicitacaoProgressaoCapacitacao solicitacaoProgressaoCapacitacao) {
		this.solicitacaoProgressaoCapacitacao = solicitacaoProgressaoCapacitacao;
	}

	public byte[] getCertificado() {
		return certificado;
	}

	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}

}
