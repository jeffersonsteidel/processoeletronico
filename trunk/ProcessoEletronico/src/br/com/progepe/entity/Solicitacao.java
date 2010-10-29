package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Solicitacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private TipoSolicitacao	tipoSolicitacao;
	private Date dataAbertura;
	private Date dataAtendimento;
	private Servidor solicitante;
	private Integer atendente; // SIAPE
	private Date dataFechamento;
	private StatusSolicitacao statusSolicitacao;
	private String justificativa;
	
	private Servidor atendenteLogado;
	
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
	public Date getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
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
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
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
	public Servidor getAtendenteLogado() {
		return atendenteLogado;
	}
	public void setAtendenteLogado(Servidor atendenteLogado) {
		this.atendenteLogado = atendenteLogado;
	}
}
