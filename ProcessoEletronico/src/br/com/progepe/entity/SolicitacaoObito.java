package br.com.progepe.entity;

import java.util.ArrayList;

public class SolicitacaoObito extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String nomeFalecido;
	private GrauParentesco grauParentesco;
	private Integer numeroCertidao;
	private byte[] certidaoObito;
	private ArrayList<SolicitacaoObito> files = new ArrayList<SolicitacaoObito>();
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
	
	public ArrayList<SolicitacaoObito> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<SolicitacaoObito> files) {
		this.files = files;
	}
}
