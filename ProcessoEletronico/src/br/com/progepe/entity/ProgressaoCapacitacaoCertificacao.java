package br.com.progepe.entity;

import java.io.Serializable;


public class ProgressaoCapacitacaoCertificacao extends Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private byte[] certificado;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public byte[] getCertificado() {
		return certificado;
	}
	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}
	
}
