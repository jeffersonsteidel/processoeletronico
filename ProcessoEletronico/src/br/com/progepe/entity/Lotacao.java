package br.com.progepe.entity;

import java.io.Serializable;

public class Lotacao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private String telefone;
	private Endereco endereco;
	private String diretorGeral;
	private String diretorAdministrativo;
	private String email;
	private String site;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDiretorGeral() {
		return diretorGeral;
	}

	public void setDiretorGeral(String diretorGeral) {
		this.diretorGeral = diretorGeral;
	}

	public String getDiretorAdministrativo() {
		return diretorAdministrativo;
	}

	public void setDiretorAdministrativo(String diretorAdministrativo) {
		this.diretorAdministrativo = diretorAdministrativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
