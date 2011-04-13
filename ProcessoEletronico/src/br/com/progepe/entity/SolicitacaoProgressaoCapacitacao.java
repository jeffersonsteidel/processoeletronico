package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class SolicitacaoProgressaoCapacitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private Padrao novoPadrao;
	private String portaria;
	private String curso;
	private Integer cargaHoraria;
	private String instituicaoEnsino;
	private Date dataInicio;
	private Date dataTermio;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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

	public Date getDataTermio() {
		return dataTermio;
	}

	public void setDataTermio(Date dataTermio) {
		this.dataTermio = dataTermio;
	}

}
