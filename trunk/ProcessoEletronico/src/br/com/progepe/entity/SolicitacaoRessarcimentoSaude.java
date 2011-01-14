package br.com.progepe.entity;

import java.util.Date;

public class SolicitacaoRessarcimentoSaude extends Solicitacao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1595653461934669946L;
	private byte[] comprovante;
	private Date dataPagamento;
	private Double valor;
	private RessarcimentoSaude ressarcimentoSaude;

	public byte[] getComprovante() {
		return comprovante;
	}

	public void setComprovante(byte[] comprovante) {
		this.comprovante = comprovante;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public RessarcimentoSaude getRessarcimentoSaude() {
		return ressarcimentoSaude;
	}

	public void setRessarcimentoSaude(RessarcimentoSaude ressarcimentoSaude) {
		this.ressarcimentoSaude = ressarcimentoSaude;
	}

}
