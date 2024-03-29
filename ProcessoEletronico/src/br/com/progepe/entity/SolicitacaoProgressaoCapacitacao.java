package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SolicitacaoProgressaoCapacitacao extends Solicitacao implements
		Serializable {

	private static final long serialVersionUID = 1L;

	private Padrao novoPadrao;
	private String portaria;
	private String curso;
	private Integer cargaHoraria;
	private String instituicaoEnsino;
	private Date dataInicio;
	private Date dataTermino;
	private Set<ProgressaoCapacitacaoCertificado> progressaoCapacitacaoCertificadoList = new HashSet<ProgressaoCapacitacaoCertificado>();

	public Padrao getNovoPadrao() {
		return novoPadrao;
	}

	public void setNovoPadrao(Padrao novoPadrao) {
		this.novoPadrao = novoPadrao;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Set<ProgressaoCapacitacaoCertificado> getProgressaoCapacitacaoCertificadoList() {
		return progressaoCapacitacaoCertificadoList;
	}

	public void setProgressaoCapacitacaoCertificadoList(
			Set<ProgressaoCapacitacaoCertificado> progressaoCapacitacaoCertificadoList) {
		this.progressaoCapacitacaoCertificadoList = progressaoCapacitacaoCertificadoList;
	}
	
}
