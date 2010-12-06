package br.com.progepe.entity;

import java.util.HashSet;
import java.util.Set;

public class SolicitacaoAdicionalNoturno extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String turma;
	private Boolean indDocente;

	private Curso curso;
	private Lotacao lotacao;
	private Servidor servidor;

	private Set<AdicionalNoturno> adicionais = new HashSet<AdicionalNoturno>();

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public boolean isIndDocente() {
		return indDocente;
	}

	public void setIndDocente(boolean indDocente) {
		this.indDocente = indDocente;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Lotacao getLotacao() {
		return lotacao;
	}

	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Boolean getIndDocente() {
		return indDocente;
	}

	public void setIndDocente(Boolean indDocente) {
		this.indDocente = indDocente;
	}

	public Set<AdicionalNoturno> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(Set<AdicionalNoturno> adicionais) {
		this.adicionais = adicionais;
	}
}
