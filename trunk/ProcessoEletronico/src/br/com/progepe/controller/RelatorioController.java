package br.com.progepe.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.DataUtil;

public class RelatorioController  {
	private static final long serialVersionUID = -333995781063775201L;
	private Servidor servidor;
	private Servidor atendente;
	private Servidor solicitante;
	private List<SelectItem> cargos = new ArrayList<SelectItem>();
	private List<SelectItem> locaisExercicio = new ArrayList<SelectItem>();
	private List<SelectItem> tipoSolicitacoes = new ArrayList<SelectItem>();
	private List<SelectItem> tipoStatus = new ArrayList<SelectItem>();
	private Integer cargo;
	private Integer lotacao;
	private Integer situacao;
	private Integer solicitacao;
	private Integer status;
	private Date periodoInicio;
	private Date periodoFinal;

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Servidor getAtendente() {
		return atendente;
	}

	public void setAtendente(Servidor atendente) {
		this.atendente = atendente;
	}

	public Servidor getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Servidor solicitante) {
		this.solicitante = solicitante;
	}

	public List<SelectItem> getCargos() {
		return cargos;
	}

	public void setCargos(List<SelectItem> cargos) {
		this.cargos = cargos;
	}

	public List<SelectItem> getLocaisExercicio() {
		return locaisExercicio;
	}

	public void setLocaisExercicio(List<SelectItem> locaisExercicio) {
		this.locaisExercicio = locaisExercicio;
	}

	public List<SelectItem> getTipoSolicitacoes() {
		return tipoSolicitacoes;
	}

	public void setTipoSolicitacoes(List<SelectItem> tipoSolicitacoes) {
		this.tipoSolicitacoes = tipoSolicitacoes;
	}

	public List<SelectItem> getTipoStatus() {
		return tipoStatus;
	}

	public void setTipoStatus(List<SelectItem> tipoStatus) {
		this.tipoStatus = tipoStatus;
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

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Integer solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public void buscarServidorAtendente() throws IOException, ParseException {
		if(atendente.getSiape() != 0){
			atendente = (Servidor) ServidorDAO.getInstance()
			.refreshBySiape(atendente);
		}
		
		if (atendente == null) {
			atendente = (new Servidor());
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Siape inválido!",
					"Siape inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
			return;
		}
		if(atendente.getSiape() == 0 ){
			atendente = (new Servidor());
		}
	}
	
	public void buscarServidorSolicitante() throws IOException, ParseException {
		if(solicitante.getSiape() != 0){
		solicitante = (Servidor) ServidorDAO.getInstance()
		.refreshBySiape(solicitante);
		}
		
		if (solicitante == null) {
			solicitante = (new Servidor());
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Siape inválido!",
					"Siape inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
			return;
		}
		if(solicitante.getSiape() == 0 ){
			solicitante = (new Servidor());
		}
	}
	
	public String abrirRelatorioSolicitacaoByFiltro() throws Exception {
		try {
			atendente = new Servidor();
			solicitante = new Servidor();
			listarTiposSolicitacoes();
			listarTiposStatus();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("relatorioSolicitacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
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
			cargos.add(new SelectItem(cargo.getCodigo(), cargo.getDescricao()));
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposSolicitacoes() {
		tipoSolicitacoes = new ArrayList<SelectItem>();
		List<TipoSolicitacao> tipoSolicitacoesList = new ArrayList<TipoSolicitacao>();
		tipoSolicitacoesList = DAO.getInstance().list(TipoSolicitacao.class,
				"descricao");
		for (TipoSolicitacao tipoSolicitacao : tipoSolicitacoesList) {
			tipoSolicitacoes.add(new SelectItem(tipoSolicitacao.getCodigo(),
					tipoSolicitacao.getDescricao()));
		}
		return tipoSolicitacoes;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposStatus() {
		tipoStatus = new ArrayList<SelectItem>();
		List<StatusSolicitacao> tipoStatusList = new ArrayList<StatusSolicitacao>();
		tipoStatusList = DAO.getInstance().list(StatusSolicitacao.class,
		"descricao");
		for (StatusSolicitacao status : tipoStatusList) {
			tipoStatus.add(new SelectItem(status.getCodigo(),
					status.getDescricao()));
		}
		return tipoStatus;
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
	public String gerarRelatorioServidorDependente()
			throws ClassNotFoundException, SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorDependente.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorConjuge()
			throws ClassNotFoundException, SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorConjuge.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorEmprego()
			throws ClassNotFoundException, SQLException, JRException {
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		String nomeDoJasper = "/WEB-INF/jasper/relatorioServidorEmprego.jasper";
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
	public String gerarRelatorioServidorSolicitacaoByFiltro()
			throws ClassNotFoundException, SQLException, JRException {

		String sql = "SELECT solicitacao.solic_dt_abertura AS solicitacao_solic_dt_abertura,"
				+ " solicitacao.solic_dt_atendimento AS solicitacao_solic_dt_atendimento,"
				+ " solicitacao.solic_dt_fechamento AS solicitacao_solic_dt_fechamento,"
				+ " tiposolicitacao.tipo_solic_desc AS tiposolicitacao_tipo_solic_desc,"
				+ " statussolicitacao.sta_solic_desc AS statussolicitacao_sta_solic_desc,"
				+ " servidorSolicitante.serv_nome AS servidor_serv_nome_solicitante,"
				+ " servidorAt.serv_nome AS servidor_serv_nome_atendente"
				+ " FROM solicitacao INNER JOIN tiposolicitacao ON solicitacao.tipo_solic_cod = tiposolicitacao.tipo_solic_cod"
				+ " INNER JOIN statussolicitacao ON solicitacao.sta_solic_cod = statussolicitacao.sta_solic_cod"
				+ " INNER JOIN servidor AS servidorSolicitante  ON solicitacao.serv_cod_solic = servidorSolicitante.serv_cod"
				+ " LEFT JOIN servidor AS servidorAt  ON solicitacao.serv_cod_atendente = servidorAt.serv_siape"
				+ " WHERE 1 = 1";
		
		
		if (periodoInicio != null) {
			sql += " and solicitacao.solic_dt_abertura > '" + DataUtil.format(periodoInicio, "yyyy-MM-dd") +"'";
		}
		
		if (periodoFinal != null) {
			sql += " and solicitacao.solic_dt_abertura < '" + DataUtil.format(periodoFinal, "yyyy-MM-dd") +"'";
		}
		
		
		if (atendente != null && atendente.getSiape() != 0) {
			sql += " and servidorAt.serv_nome = '" + atendente.getNome(); 
			sql += "'";
		}
		
		if (solicitante != null && solicitante.getSiape() != 0 ) {
			sql += " and servidorSolicitante.serv_nome = '"  + solicitante.getNome()+ "'";
		}
		
		if (solicitacao != null && solicitacao != 0) {
			sql += " and tiposolicitacao.tipo_solic_cod = " + solicitacao;
		}
		
		if (status != null && status != 0) {
			sql += " and solicitacao.sta_solic_cod = " + status;
		}
		
		sql += " ORDER BY solicitacao.solic_cod asc; ";
		
		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		parametros.put("SQL", sql);
		String nomeDoJasper = "/WEB-INF/jasper/historicoServidorSolicitacaoByFiltro.jasper";
		jasperMB.geraRelatorioPassandoResultSet(parametros, nomeDoJasper);
		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String gerarRelatorioServidorCargoLotacaoByFiltro()
			throws ClassNotFoundException, SQLException, JRException {

		String sql = "SELECT servidor.serv_siape AS servidor_serv_siape, servidor.serv_nome AS servidor_serv_nome,"
				+ " lotacao.lot_desc AS lotacao_lot_desc, cargo.carg_desc AS cargo_carg_desc, servidor.serv_data_saida AS servidor_serv_data_saida"
				+ " FROM lotacao INNER JOIN servidor ON lotacao.lot_cod = servidor.lot_cod INNER JOIN cargo ON servidor.carg_cod = cargo.carg_cod"
				+ " WHERE 1 = 1 ";

		if (cargo != null && cargo != 0) {
			sql += " AND cargo.carg_cod = " + cargo;
		}
		if (lotacao != null && lotacao != 0) {
			sql += " and lotacao.lot_cod =  " + lotacao;
		}

		if (situacao != null && situacao.equals(Constantes.ATIVO)) {
			sql += " and servidor.serv_data_saida is null ";
		}
		if (situacao != null && situacao.equals(Constantes.DESATIVO)) {
			sql += " and servidor.serv_data_saida is not null";
		}

		sql += " order by servidor.serv_siape ";

		JasperMB jasperMB = new JasperMB();
		jasperMB.criaConexao();
		HashMap parametros = new HashMap();
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
		parametros.put("SQL", sql);
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
		parametros.put("BANNER",
				jasperMB.getDiretorioReal("/images/banner_topo.gif"));
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
