package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;

public class RelatorioController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	public void abrirRelatorioTeste() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("relatorioTeste.jsp");
	}

	@SuppressWarnings("rawtypes")
	public String gerarRelatorioTeste() throws ClassNotFoundException,
			SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		String nomeDoJasper = "/WEB-INF/jasper/relatorio1.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioTeste2() throws ClassNotFoundException,
			SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("CODIGOLOTACAO", 8);
		String nomeDoJasper = "/WEB-INF/jasper/relatorio2.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}
	

	@SuppressWarnings({"rawtypes"})
	public String gerarRelatorioServidorCargoLotacao() throws ClassNotFoundException,
			SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorCargoLotacao.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}
}
