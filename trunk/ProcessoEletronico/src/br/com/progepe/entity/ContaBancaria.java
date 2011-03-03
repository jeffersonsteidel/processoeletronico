package br.com.progepe.entity;

import java.io.Serializable;

public class ContaBancaria implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String numeroConta;
	private String agencia;
	private Banco banco;
	private Boolean indPoupanca = false;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Boolean getIndPoupanca() {
		return indPoupanca;
	}

	public void setIndPoupanca(Boolean indPoupanca) {
		this.indPoupanca = indPoupanca;
	}
	
}
