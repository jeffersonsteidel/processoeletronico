package br.com.progepe.entity;

import java.io.Serializable;

public class Autenticacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Servidor servidor;
	private String senha;

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
