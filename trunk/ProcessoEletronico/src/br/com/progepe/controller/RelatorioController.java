package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Servidor;

public class RelatorioController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private Servidor servidor;
	
	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
	public String abrirRelatorioTeste() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("relatorios.jsp");
		return "";
	}
	
	public void abrirRelatorioGeral() throws Exception {
		try {
				
			servidor = new Servidor();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("abrirRelatorio.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		servidor = (Servidor) ServidorDAO.getInstance().refreshBySiape(servidor);
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
		parametros.put("COD_SERV", servidor.getCodigo().toString());
		String nomeDoJasper = "/WEB-INF/jasper/historicoServidor.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros,nomeDoJasper);
		return "";
	}
}
