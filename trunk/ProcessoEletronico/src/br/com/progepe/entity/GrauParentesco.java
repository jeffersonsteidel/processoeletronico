package br.com.progepe.entity;

import java.io.Serializable;

public class GrauParentesco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private Boolean indSaude; 
	private Boolean  indObito;

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

	public Boolean getIndSaude() {
		return indSaude;
	}

	public void setIndSaude(Boolean indSaude) {
		this.indSaude = indSaude;
	}

	public Boolean getIndObito() {
		return indObito;
	}

	public void setIndObito(Boolean indObito) {
		this.indObito = indObito;
	}
	
}
