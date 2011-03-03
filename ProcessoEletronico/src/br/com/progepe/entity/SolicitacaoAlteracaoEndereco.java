package br.com.progepe.entity;

import java.io.Serializable;

public class SolicitacaoAlteracaoEndereco extends Solicitacao implements Serializable{

	private static final long serialVersionUID = 1L;

	private String novoCep;
	private String novoNumero;
	private String novaRua;
	private String novoComplemento;
	private String novoBairro;
	private Cidade novaCidade;
	private String novoEmail;
	private String novoTelefone;
	private String novoCelular;
	
	public String getNovoCep() {
		return novoCep;
	}

	public void setNovoCep(String novoCep) {
		this.novoCep = novoCep;
	}

	public String getNovoNumero() {
		return novoNumero;
	}

	public void setNovoNumero(String novoNumero) {
		this.novoNumero = novoNumero;
	}

	public String getNovaRua() {
		return novaRua;
	}

	public void setNovaRua(String novaRua) {
		this.novaRua = novaRua;
	}

	public String getNovoComplemento() {
		return novoComplemento;
	}

	public void setNovoComplemento(String novoComplemento) {
		this.novoComplemento = novoComplemento;
	}

	public String getNovoBairro() {
		return novoBairro;
	}

	public void setNovoBairro(String novoBairro) {
		this.novoBairro = novoBairro;
	}

	public Cidade getNovaCidade() {
		return novaCidade;
	}

	public void setNovaCidade(Cidade novaCidade) {
		this.novaCidade = novaCidade;
	}

	public String getNovoEmail() {
		return novoEmail;
	}

	public void setNovoEmail(String novoEmail) {
		this.novoEmail = novoEmail;
	}

	public String getNovoTelefone() {
		return novoTelefone;
	}

	public void setNovoTelefone(String novoTelefone) {
		this.novoTelefone = novoTelefone;
	}

	public String getNovoCelular() {
		return novoCelular;
	}

	public void setNovoCelular(String novoCelular) {
		this.novoCelular = novoCelular;
	}
}
