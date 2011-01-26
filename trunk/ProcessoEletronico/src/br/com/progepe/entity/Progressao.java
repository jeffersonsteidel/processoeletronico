package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Progressao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Servidor servidor;
	private Classe classeAntiga;
	private Classe classeNova;
	private Padrao padraoAntigo;
	private Padrao padraoNovo;
	private Date dataProgressao;
	private String portaria;
	private TipoProgressao tipoProgressao;
	private ServidorTitulacao servidorTitulacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Classe getClasseAntiga() {
		return classeAntiga;
	}

	public void setClasseAntiga(Classe classeAntiga) {
		this.classeAntiga = classeAntiga;
	}

	public Classe getClasseNova() {
		return classeNova;
	}

	public void setClasseNova(Classe classeNova) {
		this.classeNova = classeNova;
	}

	public Padrao getPadraoAntigo() {
		return padraoAntigo;
	}

	public void setPadraoAntigo(Padrao padraoAntigo) {
		this.padraoAntigo = padraoAntigo;
	}

	public Padrao getPadraoNovo() {
		return padraoNovo;
	}

	public void setPadraoNovo(Padrao padraoNovo) {
		this.padraoNovo = padraoNovo;
	}

	public Date getDataProgressao() {
		return dataProgressao;
	}

	public void setDataProgressao(Date dataProgressao) {
		this.dataProgressao = dataProgressao;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

	public TipoProgressao getTipoProgressao() {
		return tipoProgressao;
	}

	public void setTipoProgressao(TipoProgressao tipoProgressao) {
		this.tipoProgressao = tipoProgressao;
	}

	public ServidorTitulacao getServidorTitulacao() {
		return servidorTitulacao;
	}

	public void setServidorTitulacao(ServidorTitulacao servidorTitulacao) {
		this.servidorTitulacao = servidorTitulacao;
	}

}
