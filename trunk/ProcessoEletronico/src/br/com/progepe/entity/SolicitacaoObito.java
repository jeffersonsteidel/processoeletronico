package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class SolicitacaoObito extends Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeFalecido;
	private GrauParentesco grauParentesco;
	private Integer numeroCertidao;
	private byte[] certidaoObito;
	private Date dataObito;
	private Date dataRetorno;
	private boolean documentoValidado = false;
	
	
	public String getNomeFalecido() {
		return nomeFalecido;
	}
	public void setNomeFalecido(String nomeFalecido) {
		this.nomeFalecido = nomeFalecido;
	}
	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}
	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}
	public Integer getNumeroCertidao() {
		return numeroCertidao;
	}
	public void setNumeroCertidao(Integer numeroCertidao) {
		this.numeroCertidao = numeroCertidao;
	}
	public byte[] getCertidaoObito() {
		return certidaoObito;
	}
	public void setCertidaoObito(byte[] certidaoObito) {
		this.certidaoObito = certidaoObito;
	}
	public Boolean getDocumentoValidado() {
		return documentoValidado;
	}
	public void setDocumentoValidado(Boolean documentoValidado) {
		this.documentoValidado = documentoValidado;
	}
	
	public Date getDataObito() {
		return dataObito;
	}
	public void setDataObito(Date dataObito) {
		this.dataObito = dataObito;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public void setDocumentoValidado(boolean documentoValidado) {
		this.documentoValidado = documentoValidado;
	}
	
}
