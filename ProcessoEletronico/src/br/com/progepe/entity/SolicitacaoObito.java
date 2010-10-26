package br.com.progepe.entity;

public class SolicitacaoObito extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String nomeFalecido;
	private GrauParentesco grauParentesco;
	private Integer numeroCertidao;
	private String livro;
	private String folhas;
	private String cartorio;
	private byte[] certidaoObito;
	
	public String getNomeFalecido() {
		return nomeFalecido;
	}
	public void setNomeFalecido(String nomeFalecido) {
		this.nomeFalecido = nomeFalecido;
	}
	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}
	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}
	public Integer getNumeroCertidao() {
		return numeroCertidao;
	}
	public void setNumeroCertidao(Integer numeroCertidao) {
		this.numeroCertidao = numeroCertidao;
	}
	public String getLivro() {
		return livro;
	}
	public void setLivro(String livro) {
		this.livro = livro;
	}
	public String getFolhas() {
		return folhas;
	}
	public void setFolhas(String folhas) {
		this.folhas = folhas;
	}
	public String getCartorio() {
		return cartorio;
	}
	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}
	public byte[] getCertidaoObito() {
		return certidaoObito;
	}
	public void setCertidaoObito(byte[] certidaoObito) {
		this.certidaoObito = certidaoObito;
	}
	public Boolean getDocumentoValidado() {
		return documentoValidado;
	}
	public void setDocumentoValidado(Boolean documentoValidado) {
		this.documentoValidado = documentoValidado;
	}
	private Boolean documentoValidado = false;
	
	
	



}
