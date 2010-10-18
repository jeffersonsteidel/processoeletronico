package br.com.progepe.entity;

public class SolicitacaoContaBancaria extends Solicitacao {

	private static final long serialVersionUID = 1L;
	private ContaBancaria contaBancaria;
	
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}
	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
}
