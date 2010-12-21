package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Funcao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private TipoFuncao tipoFuncao;
	private String atoCriacao;
	private Funcao funcaoAnterior;
	private Date dataCriacao;
	private Date dataExtincao;
		
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFuncao getTipoFuncao() {
		return tipoFuncao;
	}

	public void setTipoFuncao(TipoFuncao tipoFuncao) {
		this.tipoFuncao = tipoFuncao;
	}

	public String getAtoCriacao() {
		return atoCriacao;
	}

	public void setAtoCriacao(String atoCriacao) {
		this.atoCriacao = atoCriacao;
	}

	public Funcao getFuncaoAnterior() {
		return funcaoAnterior;
	}

	public void setFuncaoAnterior(Funcao funcaoAnterior) {
		this.funcaoAnterior = funcaoAnterior;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExtincao() {
		return dataExtincao;
	}

	public void setDataExtincao(Date dataExtincao) {
		this.dataExtincao = dataExtincao;
	}
	
}
