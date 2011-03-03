package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class SolicitacaoLicencaPaternidade extends Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private byte[] certidaoNascimento;
	private Boolean documentoValidado = false; 
	private Date dataNascimento;
	private Date dataRetorno;
	
	public byte[] getCertidaoNascimento() {
		return certidaoNascimento;
	}
	public void setCertidaoNascimento(byte[] certidaoNascimento) {
		this.certidaoNascimento = certidaoNascimento;
	}
	public Boolean getDocumentoValidado() {
		return documentoValidado;
	}
	public void setDocumentoValidado(Boolean documentoValidado) {
		this.documentoValidado = documentoValidado;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
}

