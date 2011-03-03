package br.com.progepe.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class RessarcimentoSaude implements Serializable {

	private static final long serialVersionUID = -1108901121421462149L;
	
	private Long codigo;
	private TipoPlano tipoPlano;
	private Servidor servidor;
	private String nomePlano;
	private String numeroContrato;
	private ArrayList<RessarcimentoSaudeContrato> files = new ArrayList<RessarcimentoSaudeContrato>();
	private Date dataAdesao;
	private StatusSolicitacao status;
	private String justificativa;
	private Boolean indAtual;
	private Date dataAbertura;
	private Date dataAtendimento;
	private Date dataFechamento;
	private Integer atendente;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public ArrayList<RessarcimentoSaudeContrato> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<RessarcimentoSaudeContrato> files) {
		this.files = files;
	}

	public Date getDataAdesao() {
		return dataAdesao;
	}

	public void setDataAdesao(Date dataAdesao) {
		this.dataAdesao = dataAdesao;
	}

	public StatusSolicitacao getStatus() {
		return status;
	}

	public void setStatus(StatusSolicitacao status) {
		this.status = status;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Boolean getIndAtual() {
		return indAtual;
	}

	public void setIndAtual(Boolean indAtual) {
		this.indAtual = indAtual;
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

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getAtendente() {
		return atendente;
	}

	public void setAtendente(Integer atendente) {
		this.atendente = atendente;
	}

}
