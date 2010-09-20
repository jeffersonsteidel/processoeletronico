package br.com.progepe.entity;

import java.io.Serializable;

public class Conjuge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;
	private Documento documento;
	private Cidade cidadeNascimento;
	private Boolean indEstrangeiro;
	private Boolean indServidor;
	private String local;
	private String sexo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Cidade getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(Cidade cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public Boolean getIndEstrangeiro() {
		return indEstrangeiro;
	}

	public void setIndEstrangeiro(Boolean indEstrangeiro) {
		this.indEstrangeiro = indEstrangeiro;
	}

	public Boolean getIndServidor() {
		return indServidor;
	}

	public void setIndServidor(Boolean indServidor) {
		this.indServidor = indServidor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
