package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Solicitacao implements Serializable {
	/**
	 * 
	 */
	
	private Long codigo;
	private TipoSolicitacao	tipoSolicitacao;
	private Date cataAbertura;
	private Date inicioAtendimento;
	private Servidor solicitante;
	private int atendente; // SIAPE
	private Date dataDeFechamento;
	private StatusSolicitacao statusSolicitacao;
	private String justificativa;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public TipoSolicitacao getTipoSolicitacao() {
		return tipoSolicitacao;
	}
	public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}
	public Date getCataAbertura() {
		return cataAbertura;
	}
	public void setCataAbertura(Date cataAbertura) {
		this.cataAbertura = cataAbertura;
	}
	public Date getInicioAtendimento() {
		return inicioAtendimento;
	}
	public void setInicioAtendimento(Date inicioAtendimento) {
		this.inicioAtendimento = inicioAtendimento;
	}
	public Servidor getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Servidor solicitante) {
		this.solicitante = solicitante;
	}
	public int getAtendente() {
		return atendente;
	}
	public void setAtendente(int atendente) {
		this.atendente = atendente;
	}
	public Date getDataDeFechamento() {
		return dataDeFechamento;
	}
	public void setDataDeFechamento(Date dataDeFechamento) {
		this.dataDeFechamento = dataDeFechamento;
	}
	public StatusSolicitacao getStatusSolicitacao() {
		return statusSolicitacao;
	}
	public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	
	
	
	
	

	
}
