package br.com.progepe.entity;

import java.util.Date;

public class AdicionalNoturno {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private Date data;
	private String motivo;
	private SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno;
	private Servidor servidor;
	private String horaInicial;
	private String horaFinal;
	private Boolean indAprovadoDiretor;
	private Boolean indAprovadoProgepe;
	private String materia;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public SolicitacaoAdicionalNoturno getSolicitacaoAdicionalNoturno() {
		return solicitacaoAdicionalNoturno;
	}

	public void setSolicitacaoAdicionalNoturno(
			SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno) {
		this.solicitacaoAdicionalNoturno = solicitacaoAdicionalNoturno;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Boolean getIndAprovadoDiretor() {
		return indAprovadoDiretor;
	}

	public void setIndAprovadoDiretor(Boolean indAprovadoDiretor) {
		this.indAprovadoDiretor = indAprovadoDiretor;
	}

	public Boolean getIndAprovadoProgepe() {
		return indAprovadoProgepe;
	}

	public void setIndAprovadoProgepe(Boolean indAprovadoProgepe) {
		this.indAprovadoProgepe = indAprovadoProgepe;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
}


