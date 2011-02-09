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
				.redirect("relatorios.jsp");
	}
	

	@SuppressWarnings({"rawtypes", "unchecked"})
	public String gerarRelatorioServidorCargoLotacao() throws ClassNotFoundException,
			SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER", jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorCargoLotacao.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public String gerarRelatorioServidorContaBancaria() throws ClassNotFoundException,
			SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER", jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorContaBancaria.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public String gerarRelatorioServidorGeral() throws ClassNotFoundException,
			SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER", jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		parametros.put("SUB_PESSOAIS", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubPessoais.jasper"));
		parametros.put("COD_SERV", "470");
		String nomeDoJasper = "/WEB-INF/jasper/historicoServidor.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}
}
