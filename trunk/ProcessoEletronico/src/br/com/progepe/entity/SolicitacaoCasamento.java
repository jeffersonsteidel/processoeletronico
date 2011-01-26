package br.com.progepe.entity;

import java.util.ArrayList;
import java.util.Date;

public class SolicitacaoCasamento extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String nomeConjuge;
	private Integer numeroCertidao;
	private byte[] certidaoCasamento;
	private Boolean documentoValidado = false;
	private Date dataCasemento;
	private Date dataRetorno;
	private ArrayList<SolicitacaoCasamento> files = new ArrayList<SolicitacaoCasamento>();

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public Integer getNumeroCertidao() {
		return numeroCertidao;
	}

	public void setNumeroCertidao(Integer numeroCertidao) {
		this.numeroCertidao = numeroCertidao;
	}

	public byte[] getCertidaoCasamento() {
		return certidaoCasamento;
	}

	public void setCertidaoCasamento(byte[] certidaoCasamento) {
		this.certidaoCasamento = certidaoCasamento;
	}

	public Boolean getDocumentoValidado() {
		return documentoValidado;
	}

	public void setDocumentoValidado(Boolean documentoValidado) {
		this.documentoValidado = documentoValidado;
	}
	
	public ArrayList<SolicitacaoCasamento> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<SolicitacaoCasamento> files) {
		this.files = files;
	}

	public Date getDataCasemento() {
		return dataCasemento;
	}

	public void setDataCasemento(Date dataCasemento) {
		this.dataCasemento = dataCasemento;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
}
