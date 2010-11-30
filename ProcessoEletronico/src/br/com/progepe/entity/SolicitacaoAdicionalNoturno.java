package br.com.progepe.entity;

import java.util.HashSet;
import java.util.Set;

public class SolicitacaoAdicionalNoturno extends Solicitacao {

	private static final long serialVersionUID = 1L;

	Set<AdicionalNoturno> adicionais = new HashSet<AdicionalNoturno>();

	public Set<AdicionalNoturno> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(Set<AdicionalNoturno> adicionais) {
		this.adicionais = adicionais;
	}

}
