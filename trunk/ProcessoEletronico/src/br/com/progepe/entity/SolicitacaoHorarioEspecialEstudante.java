package br.com.progepe.entity;

public class SolicitacaoHorarioEspecialEstudante extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String curso;
	private String instituicao;
	private String motivo;

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

}
