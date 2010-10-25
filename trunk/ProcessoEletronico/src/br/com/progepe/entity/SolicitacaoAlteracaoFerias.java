package br.com.progepe.entity;

import java.util.Date;

public class SolicitacaoAlteracaoFerias extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private Date dataInicio;
	private Date dataFinal;
	private Date novaDataInicio;
	private Date novaDataFinal;
	private String motivo;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getNovaDataInicio() {
		return novaDataInicio;
	}

	public void setNovaDataInicio(Date novaDataInicio) {
		this.novaDataInicio = novaDataInicio;
	}

	public Date getNovaDataFinal() {
		return novaDataFinal;
	}

	public void setNovaDataFinal(Date novaDataFinal) {
		this.novaDataFinal = novaDataFinal;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
