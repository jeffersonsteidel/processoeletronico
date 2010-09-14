package br.com.progepe.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprego implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String cargo;
	private Date dataAdmissao;
	private Date dataSaida;
	private String empresa;
	private String atividades;
	// Variavel auxiliar
	private Integer indentificador;

	private String dataAdmissaoString;
	private String dataSaidaString;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public Integer getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(Integer indentificador) {
		this.indentificador = indentificador;
	}

	public String getDataAdmissaoString() {
		if (dataAdmissao != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAdmissaoString = sdf.format(dataAdmissao);
		}
		return dataAdmissaoString;
	}

	public void setDataAdmissaoString(String dataAdmissaoString) {
		this.dataAdmissaoString = dataAdmissaoString;
	}

	public String getDataSaidaString() {
		if (dataSaida != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataSaidaString = sdf.format(dataSaida);
		}
		return dataSaidaString;
	}

	public void setDataSaidaString(String dataSaidaString) {
		this.dataSaidaString = dataSaidaString;
	}

}
