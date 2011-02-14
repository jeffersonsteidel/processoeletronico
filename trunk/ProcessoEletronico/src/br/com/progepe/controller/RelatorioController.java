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
		parametros.put("SUB_FUNCIONAL", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubDadosFuncionais.jasper"));
		parametros.put("SUB_ENDERECO", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubContatoEndereco.jasper"));
		parametros.put("SUB_DOCUMENTOS", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubDocumentos.jasper"));
		parametros.put("SUB_CONTA_BANCARIA", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubContaBancaria.jasper"));
		parametros.put("SUB_TITULACOES", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubTitulacoes.jasper"));
		parametros.put("SUB_DEPENDENTE", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubDependente.jasper"));
		parametros.put("SUB_EMPREGO", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubEmpregos.jasper"));
		parametros.put("SUB_CONJUGE", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubConjuge.jasper"));
		parametros.put("SUB_FUNCAO", jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubFuncao.jasper"));
		parametros.put("COD_SERV", "470");
		String nomeDoJasper = "/WEB-INF/jasper/historicoServidor.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}
}
