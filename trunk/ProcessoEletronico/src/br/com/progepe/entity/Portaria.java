package br.com.progepe.entity;

import java.util.Date;

public class Portaria {

	private static final long serialVersionUID = 1L;

	private byte[] arquivo1;
	private byte[] arquivo2;
	private byte[] arquivo3;
	private byte[] arquivo4;
	private byte[] arquivo5;
	private String nome;
	private Integer numero;
	private Long codigo;
	private Date data;
	private TipoPortaria tipo;
	private String descricao;
	private String local;

	public byte[] getArquivo1() {
		return arquivo1;
	}

	public void setArquivo1(byte[] arquivo1) {
		this.arquivo1 = arquivo1;
	}

	public byte[] getArquivo2() {
		return arquivo2;
	}

	public void setArquivo2(byte[] arquivo2) {
		this.arquivo2 = arquivo2;
	}

	public byte[] getArquivo3() {
		return arquivo3;
	}

	public void setArquivo3(byte[] arquivo3) {
		this.arquivo3 = arquivo3;
	}

	public byte[] getArquivo4() {
		return arquivo4;
	}

	public void setArquivo4(byte[] arquivo4) {
		this.arquivo4 = arquivo4;
	}

	public byte[] getArquivo5() {
		return arquivo5;
	}

	public void setArquivo5(byte[] arquivo5) {
		this.arquivo5 = arquivo5;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoPortaria getTipo() {
		return tipo;
	}

	public void setTipo(TipoPortaria tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
