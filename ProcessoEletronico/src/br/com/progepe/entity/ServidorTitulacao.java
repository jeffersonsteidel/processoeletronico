package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class ServidorTitulacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Servidor servidor;
	private Titulacao titulacao;
	private String estabelecimentoEnsino;
	private Cidade cidadeEstabelecimentoEnsino;
	private Pais pais;
	private AreaConhecimento areaConhecimento;
	private Integer anoConclusao;
	private Integer cargaHoraria;
	private String registroConselho;
	private String orgaoEmissor;
	private Estado estadoOrgaoEmissor;
	private String curso;
	private Integer atendente;
	private Date dataAtendimento;
	private Date dataAbertura;
	private Date dataFechamento;
	private String justificativa;
	private StatusSolicitacao statusSolicitacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Titulacao getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}

	public String getEstabelecimentoEnsino() {
		return estabelecimentoEnsino;
	}

	public void setEstabelecimentoEnsino(String estabelecimentoEnsino) {
		this.estabelecimentoEnsino = estabelecimentoEnsino;
	}

	public Cidade getCidadeEstabelecimentoEnsino() {
		return cidadeEstabelecimentoEnsino;
	}

	public void setCidadeEstabelecimentoEnsino(
			Cidade cidadeEstabelecimentoEnsino) {
		this.cidadeEstabelecimentoEnsino = cidadeEstabelecimentoEnsino;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getRegistroConselho() {
		return registroConselho;
	}

	public void setRegistroConselho(String registroConselho) {
		this.registroConselho = registroConselho;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Estado getEstadoOrgaoEmissor() {
		return estadoOrgaoEmissor;
	}

	public void setEstadoOrgaoEmissor(Estado estadoOrgaoEmissor) {
		this.estadoOrgaoEmissor = estadoOrgaoEmissor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public AreaConhecimento getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public Integer getAtendente() {
		return atendente;
	}

	public void setAtendente(Integer atendente) {
		this.atendente = atendente;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public StatusSolicitacao getStatusSolicitacao() {
		return statusSolicitacao;
	}

	public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}
	
}
