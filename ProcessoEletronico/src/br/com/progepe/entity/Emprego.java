package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Emprego implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String cargo;
	private Date dataAdmissao;
	private Date dataSaida;
	private String empresa;
	private String atividades;
	private Servidor servidor;
	private Boolean indValidado;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Boolean getIndValidado() {
		return indValidado;
	}

	public void setIndValidado(Boolean indValidado) {
		this.indValidado = indValidado;
	}

}
