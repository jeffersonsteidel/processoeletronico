package br.com.progepe.entity;

public class SolicitacaoContaBancaria extends Solicitacao {

	private static final long serialVersionUID = 1L;
	private ContaBancaria contaBancaria;
	private String novoNumeroConta;
	private String novaAgencia;
	private Banco novoBanco;
	private Boolean novoIndPoupanca = false;
	
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}
	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	public String getNovoNumeroConta() {
		return novoNumeroConta;
	}
	public void setNovoNumeroConta(String novoNumeroConta) {
		this.novoNumeroConta = novoNumeroConta;
	}
	public String getNovaAgencia() {
		return novaAgencia;
	}
	public void setNovaAgencia(String novaAgencia) {
		this.novaAgencia = novaAgencia;
	}
	public Banco getNovoBanco() {
		return novoBanco;
	}
	public void setNovoBanco(Banco novoBanco) {
		this.novoBanco = novoBanco;
	}
	public Boolean getNovoIndPoupanca() {
		return novoIndPoupanca;
	}
	public void setNovoIndPoupanca(Boolean novoIndPoupanca) {
		this.novoIndPoupanca = novoIndPoupanca;
	}
}
