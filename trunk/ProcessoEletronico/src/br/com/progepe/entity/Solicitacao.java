package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Solicitacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private TipoSolicitacao	tipoSolicitacao;
	private Date dataAbertura;
	private Date inicioAtendimento;
	private Servidor solicitante;
	private Integer atendente; // SIAPE
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
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
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
	public Integer getAtendente() {
		return atendente;
	}
	public void setAtendente(Integer atendente) {
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
