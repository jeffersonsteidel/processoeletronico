package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Documento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String cpf;
	private String rg;
	private Estado rgUf;
	private String rgOrgaoEmissor;
	private Date rgDataExpedicao;
	private String tituloEleitor;
	private Estado tituloUf;
	private Integer tituloZona;
	private Integer tituloSecao;
	private Date tituloDataEmissao;
	private Integer certificadoMilitar;
	private String certificadoOrgaoEmissor;
	private String certificadoSerie;
	private Integer carteiraTrabalho;
	private String carteiraSerie;
	private Estado carteiraUf;
	private Date carteiraDataExpedicao;
	private String pis;
	private Date dataPrimeiroEmprego;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Estado getRgUf() {
		return rgUf;
	}

	public void setRgUf(Estado rgUf) {
		this.rgUf = rgUf;
	}

	public String getRgOrgaoEmissor() {
		return rgOrgaoEmissor;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}

	public Date getRgDataExpedicao() {
		return rgDataExpedicao;
	}

	public void setRgDataExpedicao(Date rgDataExpedicao) {
		this.rgDataExpedicao = rgDataExpedicao;
	}

	public Estado getTituloUf() {
		return tituloUf;
	}

	public void setTituloUf(Estado tituloUf) {
		this.tituloUf = tituloUf;
	}

	public Integer getTituloZona() {
		return tituloZona;
	}

	public void setTituloZona(Integer tituloZona) {
		this.tituloZona = tituloZona;
	}

	public Integer getTituloSecao() {
		return tituloSecao;
	}

	public void setTituloSecao(Integer tituloSecao) {
		this.tituloSecao = tituloSecao;
	}

	public Date getTituloDataEmissao() {
		return tituloDataEmissao;
	}

	public void setTituloDataEmissao(Date tituloDataEmissao) {
		this.tituloDataEmissao = tituloDataEmissao;
	}

	public Integer getCertificadoMilitar() {
		return certificadoMilitar;
	}

	public void setCertificadoMilitar(Integer certificadoMilitar) {
		this.certificadoMilitar = certificadoMilitar;
	}

	public String getCertificadoOrgaoEmissor() {
		return certificadoOrgaoEmissor;
	}

	public void setCertificadoOrgaoEmissor(String certificadoOrgaoEmissor) {
		this.certificadoOrgaoEmissor = certificadoOrgaoEmissor;
	}

	public String getCertificadoSerie() {
		return certificadoSerie;
	}

	public void setCertificadoSerie(String certificadoSerie) {
		this.certificadoSerie = certificadoSerie;
	}

	public Integer getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(Integer carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public String getCarteiraSerie() {
		return carteiraSerie;
	}

	public void setCarteiraSerie(String carteiraSerie) {
		this.carteiraSerie = carteiraSerie;
	}

	public Estado getCarteiraUf() {
		return carteiraUf;
	}

	public void setCarteiraUf(Estado carteiraUf) {
		this.carteiraUf = carteiraUf;
	}

	public Date getCarteiraDataExpedicao() {
		return carteiraDataExpedicao;
	}

	public void setCarteiraDataExpedicao(Date carteiraDataExpedicao) {
		this.carteiraDataExpedicao = carteiraDataExpedicao;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public Date getDataPrimeiroEmprego() {
		return dataPrimeiroEmprego;
	}

	public void setDataPrimeiroEmprego(Date dataPrimeiroEmprego) {
		this.dataPrimeiroEmprego = dataPrimeiroEmprego;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
}
