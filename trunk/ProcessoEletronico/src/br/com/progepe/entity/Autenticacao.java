package br.com.progepe.entity;

import java.io.Serializable;

public class Autenticacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer siape;
	private String senha;
	private Boolean indAdministrador;
	
	public Integer getSiape() {
		return siape;
	}
	public void setSiape(Integer siape) {
		this.siape = siape;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean getIndAdministrador() {
		return indAdministrador;
	}
	public void setIndAdministrador(Boolean indAdministrador) {
		this.indAdministrador = indAdministrador;
	}
}
