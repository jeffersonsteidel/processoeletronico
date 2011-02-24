package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRException;
import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Servidor;

public class RelatorioController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private Servidor servidor;
	private List<SelectItem> cargos = new ArrayList<SelectItem>();
	private Integer cargo;
	private List<SelectItem> locaisExercicio = new ArrayList<SelectItem>();
	private Integer lotacao;
	private Integer situacao;

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<SelectItem> getCargos() {
		return cargos;
	}

	public void setCargos(List<SelectItem> cargos) {
		this.cargos = cargos;
	}
	
	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public Integer getLotacao() {
		return lotacao;
	}

	public void setLotacao(Integer lotacao) {
		this.lotacao = lotacao;
	}

	public List<SelectItem> getLocaisExercicio() {
		return locaisExercicio;
	}

	public void setLocaisExercicio(List<SelectItem> locaisExercicio) {
		this.locaisExercicio = locaisExercicio;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public String abrirRelatorioCargoLotacaoByFiltro() throws Exception {
		try {
			listarCargos();
			listarLotacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("relatorioCargoLotacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarCargos() {
		cargos = new ArrayList<SelectItem>();
		List<Cargo> cargoList = new ArrayList<Cargo>();
		cargoList = DAO.getInstance().list(Cargo.class, "descricao");
		for (Cargo cargo : cargoList) {
			cargos.add(new SelectItem(cargo.getCodigo(), cargo
					.getDescricao()));
		}
		return cargos;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarLotacoes() {
		locaisExercicio = new ArrayList<SelectItem>();
		List<Lotacao> lotacaoList = new ArrayList<Lotacao>();
		lotacaoList = DAO.getInstance().list(Lotacao.class, "descricao");
		for (Lotacao lotacao : lotacaoList) {
			locaisExercicio.add(new SelectItem(lotacao.getCodigo(), lotacao
					.getDescricao()));
		}
		return locaisExercicio;
	}
	
	public void abrirRelatorios() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("relatorios.jsp");
	}

	public String abrirRelatorioGeral() throws Exception {
		try {
			servidor = new Servidor();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("relatorioGeral.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String abrirRelatorioPermissaoUsuario()
			throws ClassNotFoundException, SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioPermissoesUsuario.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorCargoLotacao()
			throws ClassNotFoundException, SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorCargoLotacao.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorTitulacao()
			throws ClassNotFoundException, SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorTitulacao.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorCargoLotacaoByFiltro()
			throws ClassNotFoundException, SQLException, JRException {
		

		String sql = "SELECT servidor.serv_siape AS servidor_serv_siape, servidor.serv_nome AS servidor_serv_nome," +
		" lotacao.lot_desc AS lotacao_lot_desc, cargo.carg_desc AS cargo_carg_desc, servidor.serv_data_saida AS servidor_serv_data_saida" +
		" FROM lotacao INNER JOIN servidor ON lotacao.lot_cod = servidor.lot_cod INNER JOIN cargo ON servidor.carg_cod = cargo.carg_cod" +
		" WHERE 1 = 1 ";
		
		if(cargo != null && cargo != 0){
			sql += " AND cargo.carg_cod = "+cargo;
		}
		if(lotacao != null && lotacao != 0){
			sql += " and lotacao.lot_cod =  "+lotacao;
		}
		
		if(situacao != null && situacao.equals(Constantes.ATIVO)){
			sql += " and servidor.serv_data_saida is null ";
		}
		if(situacao != null && situacao.equals(Constantes.DESATIVO)){
			sql += " and servidor.serv_data_saida is not null";
		}
		
		sql +=" order by servidor.serv_siape ";
		
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		parametros.put("SQL",jasperMB.getDiretorioReal(sql));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorCargoLotacaoByFiltro.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorContaBancaria()
			throws ClassNotFoundException, SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorContaBancaria.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorGeral() throws ClassNotFoundException,
			SQLException, JRException {
		servidor = (Servidor) ServidorDAO.getInstance()
				.refreshBySiape(servidor);
		if (servidor == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Siape inválido!",
					"Siape inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			JasperMB jasperMB = new JasperMB();
			jasperMB.criaConexao();
			HashMap parametros = new HashMap();
			parametros.put("BANNER",
					jasperMB.getDiretorioReal("/images/banner_topo.gif"));
			parametros
					.put("SUB_PESSOAIS",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubPessoais.jasper"));
			parametros
					.put("SUB_FUNCIONAL",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubDadosFuncionais.jasper"));
			parametros
					.put("SUB_ENDERECO",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubContatoEndereco.jasper"));
			parametros
					.put("SUB_DOCUMENTOS",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubDocumentos.jasper"));
			parametros
					.put("SUB_CONTA_BANCARIA",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubContaBancaria.jasper"));
			parametros
					.put("SUB_TITULACOES",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubTitulacoes.jasper"));
			parametros
					.put("SUB_DEPENDENTE",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubDependente.jasper"));
			parametros
					.put("SUB_EMPREGO",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubEmpregos.jasper"));
			parametros
					.put("SUB_CONJUGE",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubConjuge.jasper"));
			parametros
					.put("SUB_FUNCAO",
							jasperMB.getDiretorioReal("/WEB-INF/jasper/historicoServidor_SubFuncao.jasper"));
			parametros.put("COD_SERV", servidor.getCodigo().toString());
			String nomeDoJasper = "/WEB-INF/jasper/historicoServidor.jasper";
			jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
			return "";
		}
		servidor = new Servidor();
		return null;
	}

}
