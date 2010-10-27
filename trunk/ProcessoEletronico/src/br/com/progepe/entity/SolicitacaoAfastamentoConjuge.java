package br.com.progepe.entity;

import java.util.Date;

public class SolicitacaoAfastamentoConjuge extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private Date dataInicio;
	private String local;
	private Boolean remuneracao;
	private String unidReceptora;
	private String telefone;
	
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Boolean getRemuneracao() {
		return remuneracao;
	}
	public void setRemuneracao(Boolean remuneracao) {
		this.remuneracao = remuneracao;
	}
	public String getUnidReceptora() {
		return unidReceptora;
	}
	public void setUnidReceptora(String unidReceptora) {
		this.unidReceptora = unidReceptora;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
