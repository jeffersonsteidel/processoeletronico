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
	private Boolean indNecessidadesEspeciais;
	private Boolean indEstudante;
	private Boolean indIr;
	private Documento documento;

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

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
}
