package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Dependente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;
	private String sexo;
	private Date dataNascimento;
	private GrauParentesco grauParentesco;
	private Boolean indNecessidadesEspeciais = false;
	private Boolean indEstudante = false;
	private Boolean indIr = false;
	private String curso;
	private String faculdade;
	private Date dataFormacao;
	private Servidor servidor;
	private String cpf;
	private String rg;
	private String rgOrgao;
	private Date rgDataExpedicao;
	private Estado rgUf;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public Boolean getIndNecessidadesEspeciais() {
		return indNecessidadesEspeciais;
	}

	public void setIndNecessidadesEspeciais(Boolean indNecessidadesEspeciais) {
		this.indNecessidadesEspeciais = indNecessidadesEspeciais;
	}

	public Boolean getIndEstudante() {
		return indEstudante;
	}

	public void setIndEstudante(Boolean indEstudante) {
		this.indEstudante = indEstudante;
	}

	public Boolean getIndIr() {
		return indIr;
	}

	public void setIndIr(Boolean indIr) {
		this.indIr = indIr;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	public Date getDataFormacao() {
		return dataFormacao;
	}

	public void setDataFormacao(Date dataFormacao) {
		this.dataFormacao = dataFormacao;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgOrgao() {
		return rgOrgao;
	}

	public void setRgOrgao(String rgOrgao) {
		this.rgOrgao = rgOrgao;
	}

	public Date getRgDataExpedicao() {
		return rgDataExpedicao;
	}

	public void setRgDataExpedicao(Date rgDataExpedicao) {
		this.rgDataExpedicao = rgDataExpedicao;
	}

	public Estado getRgUf() {
		return rgUf;
	}

	public void setRgUf(Estado rgUf) {
		this.rgUf = rgUf;
	}
}