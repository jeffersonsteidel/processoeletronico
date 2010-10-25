package br.com.progepe.entity;

public class SolicitacaoHorarioEspecialEstudante extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String curso;
	private String instituicao;
	private String motivo;
	private byte[] declaracaoMatricula;
	private Boolean documentoValidado = false;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public byte[] getDeclaracaoMatricula() {
		return declaracaoMatricula;
	}

	public void setDeclaracaoMatricula(byte[] certidaoNascimento) {
		this.declaracaoMatricula = certidaoNascimento;
	}

	public Boolean getDocumentoValidado() {
		return documentoValidado;
	}

	public void setDocumentoValidado(Boolean documentoValidado) {
		this.documentoValidado = documentoValidado;
	}

}
