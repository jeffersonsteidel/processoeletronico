package br.com.progepe.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class RessarcimentoSaude implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1108901121421462149L;
	private Long codigo;
	private TipoPlano tipoPlano;
	private Servidor servidor;
	private Boolean indImplantado;
	private String nomePlano;
	private String numeroContrato;
	private ArrayList<RessarcimentoSaudeContrato> files = new ArrayList<RessarcimentoSaudeContrato>();
	private Date dataAdesao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Boolean getIndImplantado() {
		return indImplantado;
	}

	public void setIndImplantado(Boolean indImplantado) {
		this.indImplantado = indImplantado;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public ArrayList<RessarcimentoSaudeContrato> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<RessarcimentoSaudeContrato> files) {
		this.files = files;
	}

	public Date getDataAdesao() {
		return dataAdesao;
	}

	public void setDataAdesao(Date dataAdesao) {
		this.dataAdesao = dataAdesao;
	}
	
}
