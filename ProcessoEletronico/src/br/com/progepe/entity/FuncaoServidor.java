package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class FuncaoServidor implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Servidor servidor;
	private Funcao funcao;
	private Lotacao localExercicio;
	private Date dataEntrada;
	private Date dataSaida;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Lotacao getLocalExercicio() {
		return localExercicio;
	}

	public void setLocalExercicio(Lotacao localExercicio) {
		this.localExercicio = localExercicio;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

}
