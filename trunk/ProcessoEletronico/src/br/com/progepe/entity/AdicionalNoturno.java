package br.com.progepe.entity;

import java.sql.Time;
import java.util.Date;

public class AdicionalNoturno {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private Date data;
	private String motivo;
	private SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno;
	private Servidor servidor;
	private Time horaInicial;
	private Time horaFinal;
	private Boolean indAprovadoDiretor;
	private Boolean indAprovadoProgepe;

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

	public Time getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Time horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Time getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
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
}


