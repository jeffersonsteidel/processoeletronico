package br.com.progepe.entity;

import java.util.Date;

public class SolicitacaoLicencaPaternidade extends Solicitacao {

	private static final long serialVersionUID = 1L;
	
	private Date dataInicial;
	private Date dataFinal;
	private byte[] certidaoNascimento;
	private Boolean documentoValidado = false; 
	private Date dataNascimento;
	
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
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
}
