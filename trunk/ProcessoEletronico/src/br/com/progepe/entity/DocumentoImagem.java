package br.com.progepe.entity;

import java.io.Serializable;

public class DocumentoImagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1254981489993800216L;
	private Long codigo;
	private TipoDocumento tipoDocumento;
	private Servidor servidor;
	private Conjuge conjuge;
	private Dependente dependente;
	private byte[] imagem1;
	private byte[] imagem2;
	private byte[] imagem3;
	private Boolean indValidado;
	private String motivo;
	private ServidorTitulacao servidorTitulacao;
	private Emprego emprego;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Conjuge getConjuge() {
		return conjuge;
	}

	public void setConjuge(Conjuge conjuge) {
		this.conjuge = conjuge;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public byte[] getImagem1() {
		return imagem1;
	}

	public void setImagem1(byte[] imagem1) {
		this.imagem1 = imagem1;
	}

	public byte[] getImagem2() {
		return imagem2;
	}

	public void setImagem2(byte[] imagem2) {
		this.imagem2 = imagem2;
	}

	public byte[] getImagem3() {
		return imagem3;
	}

	public void setImagem3(byte[] imagem3) {
		this.imagem3 = imagem3;
	}

	public Boolean getIndValidado() {
		return indValidado;
	}

	public void setIndValidado(Boolean indValidado) {
		this.indValidado = indValidado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public ServidorTitulacao getServidorTitulacao() {
		return servidorTitulacao;
	}

	public void setServidorTitulacao(ServidorTitulacao servidorTitulacao) {
		this.servidorTitulacao = servidorTitulacao;
	}

	public Emprego getEmprego() {
		return emprego;
	}

	public void setEmprego(Emprego emprego) {
		this.emprego = emprego;
	}

}
