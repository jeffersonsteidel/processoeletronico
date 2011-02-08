package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.AdicionalNoturnoDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.dao.SolicitacaoDAO;
import br.com.progepe.entity.AdicionalNoturno;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.Solicitacao;
import br.com.progepe.entity.SolicitacaoAdicionalNoturno;
import br.com.progepe.entity.SolicitacaoAfastamentoConjuge;
import br.com.progepe.entity.SolicitacaoAlimentacao;
import br.com.progepe.entity.SolicitacaoAlteracaoEndereco;
import br.com.progepe.entity.SolicitacaoCasamento;
import br.com.progepe.entity.SolicitacaoContaBancaria;
import br.com.progepe.entity.SolicitacaoHorarioEspecialEstudante;
import br.com.progepe.entity.SolicitacaoLicencaPaternidade;
import br.com.progepe.entity.SolicitacaoObito;
import br.com.progepe.entity.SolicitacaoRessarcimentoSaude;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Solicitacao solicitacao;
	private Date dataAberturaInicial;
	private Date dataAberturaFinal;
	private List<SelectItem> tiposSolicitacoes = new ArrayList<SelectItem>();
	private List<SelectItem> statusSolicitacoes = new ArrayList<SelectItem>();
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	private List<Solicitacao> minhasSolicitacoes = new ArrayList<Solicitacao>();
	private SolicitacaoContaBancaria solicitacaoContaBancaria;
	private SolicitacaoLicencaPaternidade solicitacaoLicencaPaternidade;
	private SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante;
	private SolicitacaoObito solicitacaoObito;
	private SolicitacaoCasamento solicitacaoCasamento;
	private SolicitacaoAlimentacao solicitacaoAlimentacao;
	private SolicitacaoAfastamentoConjuge solicitacaoAfastamentoConjuge;
	private SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturnoTecnico;
	private SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturnoDocente;
	private SolicitacaoAlteracaoEndereco solicitacaoAlteracaoEndereco;
	private SolicitacaoRessarcimentoSaude solicitacaoRessarcimentoSaude;

	Solicitacao solicitacaoTemp = new Solicitacao();

	private Long codigoSolicitacao;
	private Long tipoSolicitacao;
	private Boolean desabilitaBotao = true;

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public Date getDataAberturaInicial() {
		return dataAberturaInicial;
	}

	public void setDataAberturaInicial(Date dataAberturaInicial) {
		this.dataAberturaInicial = dataAberturaInicial;
	}

	public Date getDataAberturaFinal() {
		return dataAberturaFinal;
	}

	public void setDataAberturaFinal(Date dataAberturaFinal) {
		this.dataAberturaFinal = dataAberturaFinal;
	}

	public List<SelectItem> getTiposSolicitacoes() {
		return tiposSolicitacoes;
	}

	public void setTiposSolicitacoes(List<SelectItem> tiposSolicitacoes) {
		this.tiposSolicitacoes = tiposSolicitacoes;
	}

	public List<SelectItem> getStatusSolicitacoes() {
		return statusSolicitacoes;
	}

	public void setStatusSolicitacoes(List<SelectItem> statusSolicitacoes) {
		this.statusSolicitacoes = statusSolicitacoes;
	}

	public List<Solicitacao> getMinhasSolicitacoes() {
		return minhasSolicitacoes;
	}

	public void setMinhasSolicitacoes(List<Solicitacao> minhasSolicitacoes) {
		this.minhasSolicitacoes = minhasSolicitacoes;
	}

	public Long getCodigoSolicitacao() {
		return codigoSolicitacao;
	}

	public void setCodigoSolicitacao(Long codigoSolicitacao) {
		this.codigoSolicitacao = codigoSolicitacao;
	}

	public Long getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(Long tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public SolicitacaoContaBancaria getSolicitacaoContaBancaria() {
		return solicitacaoContaBancaria;
	}

	public void setSolicitacaoContaBancaria(
			SolicitacaoContaBancaria solicitacaoContaBancaria) {
		this.solicitacaoContaBancaria = solicitacaoContaBancaria;
	}

	public SolicitacaoLicencaPaternidade getSolicitacaoLicencaPaternidade() {
		return solicitacaoLicencaPaternidade;
	}

	public void setSolicitacaoLicencaPaternidade(
			SolicitacaoLicencaPaternidade solicitacaoLicencaPaternidade) {
		this.solicitacaoLicencaPaternidade = solicitacaoLicencaPaternidade;
	}

	public SolicitacaoHorarioEspecialEstudante getSolicitacaoHorarioEspecialEstudante() {
		return solicitacaoHorarioEspecialEstudante;
	}

	public void setSolicitacaoHorarioEspecialEstudante(
			SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante) {
		this.solicitacaoHorarioEspecialEstudante = solicitacaoHorarioEspecialEstudante;
	}

	public SolicitacaoObito getSolicitacaoObito() {
		return solicitacaoObito;
	}

	public void setSolicitacaoObito(SolicitacaoObito solicitacaoObito) {
		this.solicitacaoObito = solicitacaoObito;
	}

	public SolicitacaoCasamento getSolicitacaoCasamento() {
		return solicitacaoCasamento;
	}

	public void setSolicitacaoCasamento(
			SolicitacaoCasamento solicitacaoCasamento) {
		this.solicitacaoCasamento = solicitacaoCasamento;
	}

	public SolicitacaoAlimentacao getSolicitacaoAlimentacao() {
		return solicitacaoAlimentacao;
	}

	public void setSolicitacaoAlimentacao(
			SolicitacaoAlimentacao solicitacaoAlimentacao) {
		this.solicitacaoAlimentacao = solicitacaoAlimentacao;
	}

	public Boolean getDesabilitaBotao() {
		return desabilitaBotao;
	}

	public void setDesabilitaBotao(Boolean desabilitaBotao) {
		this.desabilitaBotao = desabilitaBotao;
	}

	public SolicitacaoAfastamentoConjuge getSolicitacaoAfastamentoConjuge() {
		return solicitacaoAfastamentoConjuge;
	}

	public void setSolicitacaoAfastamentoConjuge(
			SolicitacaoAfastamentoConjuge solicitacaoAfastamentoConjuge) {
		this.solicitacaoAfastamentoConjuge = solicitacaoAfastamentoConjuge;
	}

	public SolicitacaoAdicionalNoturno getSolicitacaoAdicionalNoturnoTecnico() {
		return solicitacaoAdicionalNoturnoTecnico;
	}

	public void setSolicitacaoAdicionalNoturnoTecnico(
			SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturnoTecnico) {
		this.solicitacaoAdicionalNoturnoTecnico = solicitacaoAdicionalNoturnoTecnico;
	}

	public SolicitacaoAdicionalNoturno getSolicitacaoAdicionalNoturnoDocente() {
		return solicitacaoAdicionalNoturnoDocente;
	}

	public void setSolicitacaoAdicionalNoturnoDocente(
			SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturnoDocente) {
		this.solicitacaoAdicionalNoturnoDocente = solicitacaoAdicionalNoturnoDocente;
	}

	public SolicitacaoAlteracaoEndereco getSolicitacaoAlteracaoEndereco() {
		return solicitacaoAlteracaoEndereco;
	}

	public void setSolicitacaoAlteracaoEndereco(
			SolicitacaoAlteracaoEndereco solicitacaoAlteracaoEndereco) {
		this.solicitacaoAlteracaoEndereco = solicitacaoAlteracaoEndereco;
	}

	public SolicitacaoRessarcimentoSaude getSolicitacaoRessarcimentoSaude() {
		return solicitacaoRessarcimentoSaude;
	}

	public void setSolicitacaoRessarcimentoSaude(
			SolicitacaoRessarcimentoSaude solicitacaoRessarcimentoSaude) {
		this.solicitacaoRessarcimentoSaude = solicitacaoRessarcimentoSaude;
	}

	public void abrirPesquisarSolicitacoes() throws ParseException {
		try {
			solicitacoes = new ArrayList<Solicitacao>();
			solicitacoes.clear();
			solicitacao = new Solicitacao();
			solicitacao.setSolicitante(new Servidor());
			solicitacao.setStatusSolicitacao(new StatusSolicitacao());
			solicitacao.setTipoSolicitacao(new TipoSolicitacao());
			statusSolicitacoes = new ArrayList<SelectItem>();
			tiposSolicitacoes = new ArrayList<SelectItem>();
			listarStatusSolicitacoes();
			listarTiposSolicitacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("pesquisarSolicitacoes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Solicitacao> pesquisarSolicitacoes() throws ParseException {
		solicitacoes = new ArrayList<Solicitacao>();
		solicitacoes.clear();
		if (dataAberturaInicial != null && dataAberturaFinal != null) {
			if (dataAberturaInicial.after(dataAberturaFinal)
					|| dataAberturaInicial.equals(dataAberturaFinal)) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"A Data de Abertura Final deve ser maior que Data de Abertura Inicial!",
						"A Data de Abertura Final deve ser menor que Data de Abertura Inicial!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		}
		if (solicitacao.getSolicitante().getSiape() != null
				&& solicitacao.getSolicitante().getSiape() != 0) {
			solicitacao.setSolicitante(ServidorDAO.getInstance()
					.refreshByFilter(solicitacao.getSolicitante()));
		}
		this.setSolicitacoes(SolicitacaoDAO.getInstance().listByFilter(
				solicitacao, dataAberturaInicial, dataAberturaFinal));
		for (Solicitacao item : this.getSolicitacoes()) {
			Servidor servidor = new Servidor();
			servidor.setSiape(item.getAtendente());
			if (item.getAtendente() != null) {
				item.setAtendenteLogado(ServidorDAO.getInstance()
						.refreshBySiape(servidor));
			}
		}
		solicitacaoTemp = solicitacao;
		dataAberturaInicial = null;
		dataAberturaFinal = null;
		solicitacao = new Solicitacao();
		solicitacao.setSolicitante(new Servidor());
		solicitacao.setStatusSolicitacao(new StatusSolicitacao());
		solicitacao.setTipoSolicitacao(new TipoSolicitacao());
		return this.getSolicitacoes();
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarStatusSolicitacoes() {
		statusSolicitacoes = new ArrayList<SelectItem>();
		List<StatusSolicitacao> statusSolicitacoesList = new ArrayList<StatusSolicitacao>();
		statusSolicitacoesList = DAO.getInstance().list(
				StatusSolicitacao.class, "descricao");
		for (StatusSolicitacao statusSolicitacao : statusSolicitacoesList) {
			statusSolicitacoes.add(new SelectItem(
					statusSolicitacao.getCodigo(), statusSolicitacao
							.getDescricao()));
		}
		return statusSolicitacoes;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposSolicitacoes() {
		tiposSolicitacoes = new ArrayList<SelectItem>();
		List<TipoSolicitacao> tipoSolicitacoesList = new ArrayList<TipoSolicitacao>();
		tipoSolicitacoesList = DAO.getInstance().list(TipoSolicitacao.class,
				"descricao");
		for (TipoSolicitacao tipoSolicitacao : tipoSolicitacoesList) {
			tiposSolicitacoes.add(new SelectItem(tipoSolicitacao.getCodigo(),
					tipoSolicitacao.getDescricao()));
		}
		return tiposSolicitacoes;
	}

	public void abrirMinhasSolicitacoes() throws ParseException {
		try {
			statusSolicitacoes = new ArrayList<SelectItem>();
			tiposSolicitacoes = new ArrayList<SelectItem>();
			listarStatusSolicitacoes();
			listarTiposSolicitacoes();
			minhasSolicitacoes = new ArrayList<Solicitacao>();
			minhasSolicitacoes.clear();
			solicitacao = new Solicitacao();
			solicitacao.setSolicitante(new Servidor());
			solicitacao.setStatusSolicitacao(new StatusSolicitacao());
			solicitacao.setTipoSolicitacao(new TipoSolicitacao());
			Autenticacao siapeAutenticado = (Autenticacao) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuarioLogado");
			solicitacao.getSolicitante().setSiape(siapeAutenticado.getSiape());
			solicitacao.setSolicitante(ServidorDAO.getInstance()
					.refreshByFilter(solicitacao.getSolicitante()));
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarMinhasSolicitacoes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Solicitacao> pesquisarMinhasSolicitacoes()
			throws ParseException {
		minhasSolicitacoes = new ArrayList<Solicitacao>();
		minhasSolicitacoes.clear();
		if (dataAberturaInicial != null && dataAberturaFinal != null) {
			if (dataAberturaInicial.after(dataAberturaFinal)
					|| dataAberturaInicial.equals(dataAberturaFinal)) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"A Data de Abertura Final deve ser maior que Data de Abertura Inicial!",
						"A Data de Abertura Final deve ser menor que Data de Abertura Inicial!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		}
		this.setMinhasSolicitacoes(SolicitacaoDAO.getInstance().listByFilter(
				solicitacao, dataAberturaInicial, dataAberturaFinal));
		for (Solicitacao item : this.getMinhasSolicitacoes()) {
			Servidor servidor = new Servidor();
			servidor.setSiape(item.getAtendente());
			if (item.getAtendente() != null) {
				item.setAtendenteLogado(ServidorDAO.getInstance()
						.refreshBySiape(servidor));
			}
		}
		solicitacao = new Solicitacao();
		solicitacao.setSolicitante(new Servidor());
		solicitacao.setStatusSolicitacao(new StatusSolicitacao());
		solicitacao.setTipoSolicitacao(new TipoSolicitacao());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacao.getSolicitante().setSiape(siapeAutenticado.getSiape());
		solicitacao.setSolicitante(ServidorDAO.getInstance().refreshByFilter(
				solicitacao.getSolicitante()));
		dataAberturaInicial = null;
		dataAberturaFinal = null;
		return this.getMinhasSolicitacoes();
	}

	public void carregarSolicitacaoContaBancaria(
			SolicitacaoContaBancaria codigoSolicitacaoContaBancaria)
			throws IOException {
		solicitacaoContaBancaria = (SolicitacaoContaBancaria) DAO.getInstance()
				.refresh(codigoSolicitacaoContaBancaria);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoContaBancariaAprovar.jsp ");
	}

	public void carregarSolicitacaoAlimentacao(
			SolicitacaoAlimentacao codigoSolicitacaoAlimentacao)
			throws IOException {
		solicitacaoAlimentacao = (SolicitacaoAlimentacao) DAO.getInstance()
				.refresh(codigoSolicitacaoAlimentacao);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoAlimentacaoAprovar.jsp ");
	}

	public void carregarSolicitacaoAfasatamentoConjuge(
			SolicitacaoAfastamentoConjuge codigoSolicitacaoAfastamentoConjuge)
			throws IOException {
		solicitacaoAfastamentoConjuge = (SolicitacaoAfastamentoConjuge) DAO
				.getInstance().refresh(codigoSolicitacaoAfastamentoConjuge);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoAfastamentoConjugeAprovar.jsp ");
	}

	public void carregarSolicitacaoLicencaPaternidade(
			SolicitacaoLicencaPaternidade codigoSolicitacaoLicencaPaternidade)
			throws IOException {
		solicitacaoLicencaPaternidade = (SolicitacaoLicencaPaternidade) DAO
				.getInstance().refresh(codigoSolicitacaoLicencaPaternidade);
		solicitacaoLicencaPaternidade.getFiles().add(
				solicitacaoLicencaPaternidade);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoLicencaPaternidadeAprovar.jsp ");
	}

	public void carregarSolicitacaoHorarioEspecialEstudante(
			SolicitacaoHorarioEspecialEstudante codigoSolicitacaoHorarioEspecialEstudante)
			throws IOException {
		solicitacaoHorarioEspecialEstudante = (SolicitacaoHorarioEspecialEstudante) DAO
				.getInstance().refresh(
						codigoSolicitacaoHorarioEspecialEstudante);
		solicitacaoHorarioEspecialEstudante.getFiles().add(
				solicitacaoHorarioEspecialEstudante);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoHorarioEspecialEstudanteAprovar.jsp ");
	}

	public void carregarSolicitacaoObito(SolicitacaoObito codigoSolicitacaoObito)
			throws IOException {
		solicitacaoObito = (SolicitacaoObito) DAO.getInstance().refresh(
				codigoSolicitacaoObito);
		solicitacaoObito.getFiles().add(solicitacaoObito);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoObitoAprovar.jsp ");
	}

	public void carregarSolicitacaoCasamento(
			SolicitacaoCasamento codigoSolicitacaoCasamento) throws IOException {
		solicitacaoCasamento = (SolicitacaoCasamento) DAO.getInstance()
				.refresh(codigoSolicitacaoCasamento);
		solicitacaoCasamento.getFiles().add(solicitacaoCasamento);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoCasamentoAprovar.jsp ");
	}

	public void carregarSolicitacaoAdicionalNotunoTecnico(
			SolicitacaoAdicionalNoturno codigoSolicitacaoAdicionalNoturnoTecnico)
			throws IOException {
		solicitacaoAdicionalNoturnoTecnico = (SolicitacaoAdicionalNoturno) DAO
				.getInstance()
				.refresh(codigoSolicitacaoAdicionalNoturnoTecnico);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoAdicionalNoturnoTecnicosAprovar.jsp ");
	}

	public void carregarSolicitacaoAdicionalNotunoDocente(
			SolicitacaoAdicionalNoturno codigoSolicitacaoAdicionalNoturnoDocente)
			throws IOException {
		solicitacaoAdicionalNoturnoDocente = (SolicitacaoAdicionalNoturno) DAO
				.getInstance()
				.refresh(codigoSolicitacaoAdicionalNoturnoDocente);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoAdicionalNoturnoDocentesAprovar.jsp ");
	}

	public void carregarSolicitacaoAlteracaoEndereco(
			SolicitacaoAlteracaoEndereco codigoSolicitacaoAlteracaoEndereco)
			throws IOException {
		solicitacaoAlteracaoEndereco = (SolicitacaoAlteracaoEndereco) DAO
				.getInstance().refresh(codigoSolicitacaoAlteracaoEndereco);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoAlteracaoEnderecoAprovar.jsp ");
	}

	public void carregarSolicitacaoRessarcimentoSaude(
			SolicitacaoRessarcimentoSaude codigoSolicitacaoRessarcimentoSaude)
			throws IOException {
		solicitacaoRessarcimentoSaude = (SolicitacaoRessarcimentoSaude) DAO
				.getInstance().refresh(codigoSolicitacaoRessarcimentoSaude);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoRessarcimentoSaudeAprovar.jsp ");
	}

	public void carregarSolicitacao() throws IOException, ParseException {
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		Servidor servidor = new Servidor();
		servidor.setSiape(siapeAutenticado.getSiape());
		Solicitacao solicitacaoSelecionada = (Solicitacao) DAO.getInstance()
				.getById(codigoSolicitacao, Solicitacao.class);
		if (Constantes.STATUS_SOLICITACAO_EM_ANALISE
				.equals(solicitacaoSelecionada.getStatusSolicitacao()
						.getCodigo())) {
			pesquisarSolicitacoes();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Está solicitação já está sendo analizada por outro servidor!",
					"Está solicitação já está sendo analizada por outro servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			if (Constantes.TIPO_SOLICITACAO_ALTERAR_CONTA_BANCARIA
					.equals(tipoSolicitacao)) {
				solicitacaoContaBancaria = new SolicitacaoContaBancaria();
				solicitacaoContaBancaria.setSolicitante(new Servidor());
				solicitacaoContaBancaria.getSolicitante().setContaBancaria(
						new ContaBancaria());
				solicitacaoContaBancaria.getSolicitante().getContaBancaria()
						.setBanco(new Banco());
				solicitacaoContaBancaria.setNovoBanco(new Banco());
				solicitacaoContaBancaria.setCodigo(codigoSolicitacao);
				solicitacaoContaBancaria = (SolicitacaoContaBancaria) SolicitacaoDAO
						.getInstance().carregarSoliciacaoContaBancaria(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoContaBancaria.getStatusSolicitacao()
								.getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoContaBancaria.getStatusSolicitacao().setCodigo(
							Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoContaBancaria.setDataAtendimento(new Date());
					solicitacaoContaBancaria.setAtendente(siapeAutenticado
							.getSiape());
					solicitacaoContaBancaria.setAtendenteLogado(new Servidor());
					solicitacaoContaBancaria.setAtendenteLogado(servidor);
					DAO.getInstance().saveOrUpdate(solicitacaoContaBancaria);
				}
				this.carregarSolicitacaoContaBancaria(solicitacaoContaBancaria);
			} else if (Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE
					.equals(tipoSolicitacao)) {
				solicitacaoLicencaPaternidade = new SolicitacaoLicencaPaternidade();
				solicitacaoLicencaPaternidade
						.setFiles(new ArrayList<SolicitacaoLicencaPaternidade>());
				solicitacaoLicencaPaternidade.setSolicitante(new Servidor());
				solicitacaoLicencaPaternidade.setCodigo(codigoSolicitacao);
				solicitacaoLicencaPaternidade = (SolicitacaoLicencaPaternidade) SolicitacaoDAO
						.getInstance().carregarSolicitacaoLicencaPaternidade(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoLicencaPaternidade
								.getStatusSolicitacao().getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoLicencaPaternidade
							.getStatusSolicitacao()
							.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoLicencaPaternidade
							.setDataAtendimento(new Date());
					solicitacaoLicencaPaternidade.setAtendente(siapeAutenticado
							.getSiape());
					solicitacaoLicencaPaternidade
							.setAtendenteLogado(new Servidor());
					solicitacaoLicencaPaternidade.setAtendenteLogado(servidor);
					DAO.getInstance().saveOrUpdate(
							solicitacaoLicencaPaternidade);
				}
				this.carregarSolicitacaoLicencaPaternidade(solicitacaoLicencaPaternidade);
			} else if (Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE
					.equals(tipoSolicitacao)) {
				solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
				solicitacaoHorarioEspecialEstudante
						.setFiles(new ArrayList<SolicitacaoHorarioEspecialEstudante>());
				solicitacaoHorarioEspecialEstudante
						.setSolicitante(new Servidor());
				solicitacaoHorarioEspecialEstudante
						.setCodigo(codigoSolicitacao);
				solicitacaoHorarioEspecialEstudante = (SolicitacaoHorarioEspecialEstudante) SolicitacaoDAO
						.getInstance()
						.carregarSolicitacaoHorarioEspecialEstudante(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoHorarioEspecialEstudante
								.getStatusSolicitacao().getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoHorarioEspecialEstudante
							.getStatusSolicitacao()
							.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoHorarioEspecialEstudante
							.setDataAtendimento(new Date());
					solicitacaoHorarioEspecialEstudante
							.setAtendente(siapeAutenticado.getSiape());
					solicitacaoHorarioEspecialEstudante
							.setAtendenteLogado(new Servidor());
					solicitacaoHorarioEspecialEstudante
							.setAtendenteLogado(servidor);
					DAO.getInstance().saveOrUpdate(
							solicitacaoHorarioEspecialEstudante);
				}
				this.carregarSolicitacaoHorarioEspecialEstudante(solicitacaoHorarioEspecialEstudante);
			} else if (Constantes.TIPO_SOLICITACAO_OBITO
					.equals(tipoSolicitacao)) {
				solicitacaoObito = new SolicitacaoObito();
				solicitacaoObito.setFiles(new ArrayList<SolicitacaoObito>());
				solicitacaoObito.setSolicitante(new Servidor());
				solicitacaoObito.setCodigo(codigoSolicitacao);
				solicitacaoObito = (SolicitacaoObito) SolicitacaoDAO
						.getInstance().carregarSolicitacaoObito(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoObito.getStatusSolicitacao()
								.getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoObito.getStatusSolicitacao().setCodigo(
							Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoObito.setDataAtendimento(new Date());
					solicitacaoObito.setAtendente(siapeAutenticado.getSiape());
					solicitacaoObito.setAtendenteLogado(new Servidor());
					solicitacaoObito.setAtendenteLogado(servidor);
				}
				DAO.getInstance().saveOrUpdate(solicitacaoObito);
				this.carregarSolicitacaoObito(solicitacaoObito);
			} else if (Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO
					.equals(tipoSolicitacao)) {
				solicitacaoCasamento = new SolicitacaoCasamento();
				solicitacaoCasamento
						.setFiles(new ArrayList<SolicitacaoCasamento>());
				solicitacaoCasamento.setSolicitante(new Servidor());
				solicitacaoCasamento.setCodigo(codigoSolicitacao);
				solicitacaoCasamento = (SolicitacaoCasamento) SolicitacaoDAO
						.getInstance().carregarSolicitacaoCasamento(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoCasamento.getStatusSolicitacao()
								.getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoCasamento.getStatusSolicitacao().setCodigo(
							Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoCasamento.setDataAtendimento(new Date());
					solicitacaoCasamento.setAtendente(siapeAutenticado
							.getSiape());
					solicitacaoCasamento.setAtendenteLogado(new Servidor());
					solicitacaoCasamento.setAtendenteLogado(servidor);
					DAO.getInstance().saveOrUpdate(solicitacaoCasamento);
				}
				this.carregarSolicitacaoCasamento(solicitacaoCasamento);
			} else if (Constantes.TIPO_SOLICITACAO_AUXILIO_ALIMENTACAO
					.equals(tipoSolicitacao)) {
				solicitacaoAlimentacao = new SolicitacaoAlimentacao();
				solicitacaoAlimentacao.setSolicitante(new Servidor());
				solicitacaoAlimentacao.setCodigo(codigoSolicitacao);
				solicitacaoAlimentacao = (SolicitacaoAlimentacao) SolicitacaoDAO
						.getInstance().carregarSolicitacaoAlimentacao(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoAlimentacao.getStatusSolicitacao()
								.getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoAlimentacao.getStatusSolicitacao().setCodigo(
							Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoAlimentacao.setDataAtendimento(new Date());
					solicitacaoAlimentacao.setAtendente(siapeAutenticado
							.getSiape());
					solicitacaoAlimentacao.setAtendenteLogado(new Servidor());
					solicitacaoAlimentacao.setAtendenteLogado(servidor);
					DAO.getInstance().saveOrUpdate(solicitacaoAlimentacao);
				}
				this.carregarSolicitacaoAlimentacao(solicitacaoAlimentacao);
			} else if (Constantes.TIPO_SOLICITACAO_AFASTAMENTO_CONJUGE
					.equals(tipoSolicitacao)) {
				solicitacaoAfastamentoConjuge = new SolicitacaoAfastamentoConjuge();
				solicitacaoAfastamentoConjuge.setSolicitante(new Servidor());
				solicitacaoAfastamentoConjuge.setCodigo(codigoSolicitacao);
				solicitacaoAfastamentoConjuge = (SolicitacaoAfastamentoConjuge) SolicitacaoDAO
						.getInstance().carregarSolicitacaoAfastamentoConjuge(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoAfastamentoConjuge
								.getStatusSolicitacao().getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoAfastamentoConjuge
							.getStatusSolicitacao()
							.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoAfastamentoConjuge
							.setDataAtendimento(new Date());
					solicitacaoAfastamentoConjuge.setAtendente(siapeAutenticado
							.getSiape());
					solicitacaoAfastamentoConjuge
							.setAtendenteLogado(new Servidor());
					solicitacaoAfastamentoConjuge.setAtendenteLogado(servidor);
					DAO.getInstance().saveOrUpdate(
							solicitacaoAfastamentoConjuge);
				}
				this.carregarSolicitacaoAfasatamentoConjuge(solicitacaoAfastamentoConjuge);
			} else if (Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_TECNICOS
					.equals(tipoSolicitacao)) {
				solicitacaoAdicionalNoturnoTecnico = new SolicitacaoAdicionalNoturno();
				solicitacaoAdicionalNoturnoTecnico
						.setSolicitante(new Servidor());
				solicitacaoAdicionalNoturnoTecnico = (SolicitacaoAdicionalNoturno) SolicitacaoDAO
						.getInstance().carregarSolicitacaoAdicionalNoturno(
								codigoSolicitacao);
				for (AdicionalNoturno item : solicitacaoAdicionalNoturnoTecnico
						.getAdicionais()) {
					@SuppressWarnings("deprecation")
					String dia = SolicitacaoAdicionalNoturnoController
							.pesquisarDiaSemana(item.getData().getDay());
					item.setDiaSemana(dia);
					solicitacaoAdicionalNoturnoTecnico
							.getListaAdicionaisTecnicos().add(item);
				}
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoAdicionalNoturnoTecnico
								.getStatusSolicitacao().getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoAdicionalNoturnoTecnico
							.getStatusSolicitacao()
							.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoAdicionalNoturnoTecnico
							.setDataAtendimento(new Date());
					solicitacaoAdicionalNoturnoTecnico
							.setAtendente(siapeAutenticado.getSiape());
					solicitacaoAdicionalNoturnoTecnico
							.setAtendenteLogado(new Servidor());
					solicitacaoAdicionalNoturnoTecnico
							.setAtendenteLogado(servidor);
					AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
							solicitacaoAdicionalNoturnoTecnico);
				}
				this.carregarSolicitacaoAdicionalNotunoTecnico(solicitacaoAdicionalNoturnoTecnico);
			} else if (Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_DOCENTES
					.equals(tipoSolicitacao)) {
				solicitacaoAdicionalNoturnoDocente = new SolicitacaoAdicionalNoturno();
				solicitacaoAdicionalNoturnoDocente
						.setSolicitante(new Servidor());
				solicitacaoAdicionalNoturnoDocente = (SolicitacaoAdicionalNoturno) SolicitacaoDAO
						.getInstance().carregarSolicitacaoAdicionalNoturno(
								codigoSolicitacao);
				for (AdicionalNoturno item : solicitacaoAdicionalNoturnoDocente
						.getAdicionais()) {
					@SuppressWarnings("deprecation")
					String dia = SolicitacaoAdicionalNoturnoController
							.pesquisarDiaSemana(item.getData().getDay());
					item.setDiaSemana(dia);
					solicitacaoAdicionalNoturnoDocente
							.getListaAdicionaisDocente().add(item);
				}
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoAdicionalNoturnoDocente
								.getStatusSolicitacao().getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoAdicionalNoturnoDocente
							.getStatusSolicitacao()
							.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoAdicionalNoturnoDocente
							.setDataAtendimento(new Date());
					solicitacaoAdicionalNoturnoDocente
							.setAtendente(siapeAutenticado.getSiape());
					solicitacaoAdicionalNoturnoDocente
							.setAtendenteLogado(new Servidor());
					solicitacaoAdicionalNoturnoDocente
							.setAtendenteLogado(servidor);
					AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
							solicitacaoAdicionalNoturnoDocente);
				}
				this.carregarSolicitacaoAdicionalNotunoDocente(solicitacaoAdicionalNoturnoDocente);
			} else if (Constantes.TIPO_SOLICITACAO_ALTERACAO_ENDERECO
					.equals(tipoSolicitacao)) {
				solicitacaoAlteracaoEndereco = new SolicitacaoAlteracaoEndereco();
				solicitacaoAlteracaoEndereco.setSolicitante(new Servidor());
				solicitacaoAlteracaoEndereco = (SolicitacaoAlteracaoEndereco) SolicitacaoDAO
						.getInstance().carregarSolicitacaoAlteracaoEndereco(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoAlteracaoEndereco
								.getStatusSolicitacao().getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoAlteracaoEndereco
							.getStatusSolicitacao()
							.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoAlteracaoEndereco.setDataAtendimento(new Date());
					solicitacaoAlteracaoEndereco.setAtendente(siapeAutenticado
							.getSiape());
					solicitacaoAlteracaoEndereco
							.setAtendenteLogado(new Servidor());
					solicitacaoAlteracaoEndereco.setAtendenteLogado(servidor);
					DAO.getInstance()
							.saveOrUpdate(solicitacaoAlteracaoEndereco);
				}
				this.carregarSolicitacaoAlteracaoEndereco(solicitacaoAlteracaoEndereco);
			} else if (Constantes.TIPO_SOLICITACAO_RESSARCIMENTO_SAUDE
					.equals(tipoSolicitacao)) {
				solicitacaoRessarcimentoSaude = new SolicitacaoRessarcimentoSaude();
				solicitacaoRessarcimentoSaude.setSolicitante(new Servidor());
				solicitacaoRessarcimentoSaude.setCodigo(codigoSolicitacao);
				solicitacaoRessarcimentoSaude = (SolicitacaoRessarcimentoSaude) SolicitacaoDAO
						.getInstance().carregarSolicitacaoRessarcimentoSaude(
								codigoSolicitacao);
				if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
						.equals(solicitacaoRessarcimentoSaude
								.getStatusSolicitacao().getCodigo())) {
					this.setDesabilitaBotao(false);
					solicitacaoRessarcimentoSaude
							.getStatusSolicitacao()
							.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
					solicitacaoRessarcimentoSaude
							.setDataAtendimento(new Date());
					solicitacaoRessarcimentoSaude.setAtendente(siapeAutenticado
							.getSiape());
					solicitacaoRessarcimentoSaude
							.setAtendenteLogado(new Servidor());
					solicitacaoRessarcimentoSaude.setAtendenteLogado(servidor);
					DAO.getInstance().saveOrUpdate(
							solicitacaoRessarcimentoSaude);
				}
				this.carregarSolicitacaoRessarcimentoSaude(solicitacaoRessarcimentoSaude);
			}
		}
	}

	public void deferirSolicitacao() throws IOException, ParseException {
		if (Constantes.TIPO_SOLICITACAO_ALTERAR_CONTA_BANCARIA
				.equals(tipoSolicitacao)) {
			solicitacaoContaBancaria.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoContaBancaria.setDataFechamento(new Date());
			SolicitacaoDAO.getInstance().updateSolicitacao(
					solicitacaoContaBancaria);
			solicitacaoContaBancaria.getSolicitante().getContaBancaria()
					.setBanco(solicitacaoContaBancaria.getNovoBanco());
			solicitacaoContaBancaria
					.getSolicitante()
					.getContaBancaria()
					.setNumeroConta(
							solicitacaoContaBancaria.getNovoNumeroConta());
			solicitacaoContaBancaria.getSolicitante().getContaBancaria()
					.setAgencia(solicitacaoContaBancaria.getNovaAgencia());
			solicitacaoContaBancaria
					.getSolicitante()
					.getContaBancaria()
					.setIndPoupanca(
							solicitacaoContaBancaria.getNovoIndPoupanca());
			DAO.getInstance().update(solicitacaoContaBancaria.getSolicitante());
			this.setDesabilitaBotao(true);
			EnviarEmail enviarEmail = new EnviarEmail();
			enviarEmail.enviarEmailSolicitacao(solicitacaoContaBancaria);
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE
				.equals(tipoSolicitacao)) {
			solicitacaoLicencaPaternidade.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoLicencaPaternidade.setDataFechamento(new Date());
			DAO.getInstance().update(solicitacaoLicencaPaternidade);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE
				.equals(tipoSolicitacao)) {
			solicitacaoHorarioEspecialEstudante.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoHorarioEspecialEstudante.setDataFechamento(new Date());
			DAO.getInstance().update(solicitacaoHorarioEspecialEstudante);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_OBITO.equals(tipoSolicitacao)) {
			solicitacaoObito.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoObito.setDataFechamento(new Date());
			DAO.getInstance().update(solicitacaoObito);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO
				.equals(tipoSolicitacao)) {
			solicitacaoCasamento.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoCasamento.setDataFechamento(new Date());
			SolicitacaoDAO.getInstance()
					.updateSolicitacao(solicitacaoCasamento);
			solicitacaoCasamento.getSolicitante().getEstadoCivil()
					.setCodigo(Constantes.ESTADO_CIVIL_CASADO);
			DAO.getInstance().update(solicitacaoCasamento.getSolicitante());
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_AUXILIO_ALIMENTACAO
				.equals(tipoSolicitacao)) {
			solicitacaoAlimentacao.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoAlimentacao.setDataFechamento(new Date());
			DAO.getInstance().update(solicitacaoAlimentacao);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_AFASTAMENTO_CONJUGE
				.equals(tipoSolicitacao)) {
			solicitacaoAfastamentoConjuge.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoAfastamentoConjuge.setDataFechamento(new Date());
			DAO.getInstance().update(solicitacaoAfastamentoConjuge);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_TECNICOS
				.equals(tipoSolicitacao)) {
			solicitacaoAdicionalNoturnoTecnico.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoAdicionalNoturnoTecnico.setDataFechamento(new Date());
			AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
					solicitacaoAdicionalNoturnoTecnico);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_DOCENTES
				.equals(tipoSolicitacao)) {
			solicitacaoAdicionalNoturnoDocente.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoAdicionalNoturnoDocente.setDataFechamento(new Date());
			AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
					solicitacaoAdicionalNoturnoDocente);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_ALTERACAO_ENDERECO
				.equals(tipoSolicitacao)) {
			solicitacaoAlteracaoEndereco.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoAlteracaoEndereco.setDataFechamento(new Date());
			SolicitacaoDAO.getInstance().updateSolicitacao(
					solicitacaoAlteracaoEndereco);
			solicitacaoAlteracaoEndereco.getSolicitante().getEndereco()
					.setBairro(solicitacaoAlteracaoEndereco.getNovoBairro());
			solicitacaoAlteracaoEndereco.getSolicitante().getEndereco()
					.setCidade(solicitacaoAlteracaoEndereco.getNovaCidade());
			solicitacaoAlteracaoEndereco.getSolicitante().getEndereco()
					.setCep(solicitacaoAlteracaoEndereco.getNovoCep());
			solicitacaoAlteracaoEndereco
					.getSolicitante()
					.getEndereco()
					.setComplemento(
							solicitacaoAlteracaoEndereco.getNovoComplemento());
			solicitacaoAlteracaoEndereco.getSolicitante().getEndereco()
					.setNumero(solicitacaoAlteracaoEndereco.getNovoNumero());
			solicitacaoAlteracaoEndereco.getSolicitante().getEndereco()
					.setRua(solicitacaoAlteracaoEndereco.getNovaRua());
			solicitacaoAlteracaoEndereco.getSolicitante().setEmail(
					solicitacaoAlteracaoEndereco.getNovoEmail());
			solicitacaoAlteracaoEndereco.getSolicitante().setTelefone(
					solicitacaoAlteracaoEndereco.getNovoTelefone());
			solicitacaoAlteracaoEndereco.getSolicitante().setCelular(
					solicitacaoAlteracaoEndereco.getNovoCelular());
			DAO.getInstance().update(
					solicitacaoAlteracaoEndereco.getSolicitante());
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_RESSARCIMENTO_SAUDE
				.equals(tipoSolicitacao)) {
			solicitacaoRessarcimentoSaude.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoRessarcimentoSaude.setDataFechamento(new Date());
			DAO.getInstance().update(solicitacaoRessarcimentoSaude);
			this.setDesabilitaBotao(true);
		}
	}

	public void indeferirSolicitacao() throws IOException, ParseException {
		if (Constantes.TIPO_SOLICITACAO_ALTERAR_CONTA_BANCARIA
				.equals(tipoSolicitacao)) {
			solicitacaoContaBancaria.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoContaBancaria.setDataFechamento(new Date());
			if (solicitacaoContaBancaria.getJustificativa() != null
					&& solicitacaoContaBancaria.getJustificativa() != "") {
				SolicitacaoDAO.getInstance().saveOrUpdate(
						solicitacaoContaBancaria);
				this.setDesabilitaBotao(true);
				EnviarEmail enviarEmail = new EnviarEmail();
				enviarEmail.enviarEmailSolicitacao(solicitacaoContaBancaria);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE
				.equals(tipoSolicitacao)) {
			solicitacaoLicencaPaternidade.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoLicencaPaternidade.setDataFechamento(new Date());
			if (solicitacaoLicencaPaternidade.getJustificativa() != null
					&& solicitacaoLicencaPaternidade.getJustificativa() != "") {
				SolicitacaoDAO.getInstance().saveOrUpdate(
						solicitacaoLicencaPaternidade);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE
				.equals(tipoSolicitacao)) {
			solicitacaoHorarioEspecialEstudante.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoHorarioEspecialEstudante.setDataFechamento(new Date());
			if (solicitacaoHorarioEspecialEstudante.getJustificativa() != null
					&& solicitacaoHorarioEspecialEstudante.getJustificativa() != "") {
				SolicitacaoDAO.getInstance().saveOrUpdate(
						solicitacaoHorarioEspecialEstudante);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_OBITO.equals(tipoSolicitacao)) {
			solicitacaoObito.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoObito.setDataFechamento(new Date());
			if (solicitacaoObito.getJustificativa() != null
					&& solicitacaoObito.getJustificativa() != "") {
				SolicitacaoDAO.getInstance().saveOrUpdate(solicitacaoObito);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO
				.equals(tipoSolicitacao)) {
			solicitacaoCasamento.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoCasamento.setDataFechamento(new Date());
			if (solicitacaoCasamento.getJustificativa() != null
					&& solicitacaoCasamento.getJustificativa() != "") {
				SolicitacaoDAO.getInstance().saveOrUpdate(solicitacaoCasamento);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_AUXILIO_ALIMENTACAO
				.equals(tipoSolicitacao)) {
			solicitacaoAlimentacao.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoAlimentacao.setDataFechamento(new Date());
			if (solicitacaoAlimentacao.getJustificativa() != null
					&& solicitacaoAlimentacao.getJustificativa() != "") {
				SolicitacaoDAO.getInstance().saveOrUpdate(
						solicitacaoAlimentacao);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_AFASTAMENTO_CONJUGE
				.equals(tipoSolicitacao)) {
			solicitacaoAfastamentoConjuge.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoAfastamentoConjuge.setDataFechamento(new Date());
			if (solicitacaoAfastamentoConjuge.getJustificativa() != null
					&& solicitacaoAfastamentoConjuge.getJustificativa() != "") {
				SolicitacaoDAO.getInstance().saveOrUpdate(
						solicitacaoAfastamentoConjuge);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_TECNICOS
				.equals(tipoSolicitacao)) {
			solicitacaoAdicionalNoturnoTecnico.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoAdicionalNoturnoTecnico.setDataFechamento(new Date());
			if (solicitacaoAdicionalNoturnoTecnico.getJustificativa() != null
					&& solicitacaoAdicionalNoturnoTecnico.getJustificativa() != "") {
				AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
						solicitacaoAdicionalNoturnoTecnico);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_DOCENTES
				.equals(tipoSolicitacao)) {
			solicitacaoAdicionalNoturnoDocente.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoAdicionalNoturnoDocente.setDataFechamento(new Date());
			if (solicitacaoAdicionalNoturnoDocente.getJustificativa() != null
					&& solicitacaoAdicionalNoturnoDocente.getJustificativa() != "") {
				AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
						solicitacaoAdicionalNoturnoDocente);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_ALTERACAO_ENDERECO
				.equals(tipoSolicitacao)) {
			solicitacaoAlteracaoEndereco.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoAlteracaoEndereco.setDataFechamento(new Date());
			if (solicitacaoAlteracaoEndereco.getJustificativa() != null
					&& solicitacaoAlteracaoEndereco.getJustificativa() != "") {
				AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
						solicitacaoAlteracaoEndereco);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} else if (Constantes.TIPO_SOLICITACAO_RESSARCIMENTO_SAUDE
				.equals(tipoSolicitacao)) {
			solicitacaoRessarcimentoSaude.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			solicitacaoRessarcimentoSaude.setDataFechamento(new Date());
			if (solicitacaoRessarcimentoSaude.getJustificativa() != null
					&& solicitacaoRessarcimentoSaude.getJustificativa() != "") {
				DAO.getInstance().update(solicitacaoRessarcimentoSaude);
				this.setDesabilitaBotao(true);
			} else {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Justificativa é obrigatório!",
						"O campo Justificativa é obrigatório!!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		}
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		if (Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE
				.equals(tipoSolicitacao)) {
			stream.write(solicitacaoLicencaPaternidade.getFiles()
					.get((Integer) object).getCertidaoNascimento());
		} else if (Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE
				.equals(tipoSolicitacao)) {
			stream.write(solicitacaoHorarioEspecialEstudante.getFiles()
					.get((Integer) object).getDeclaracaoMatricula());
		} else if (Constantes.TIPO_SOLICITACAO_OBITO.equals(tipoSolicitacao)) {
			stream.write(solicitacaoObito.getFiles().get((Integer) object)
					.getCertidaoObito());
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO
				.equals(tipoSolicitacao)) {
			stream.write(solicitacaoCasamento.getFiles().get((Integer) object)
					.getCertidaoCasamento());
		} else if (Constantes.TIPO_SOLICITACAO_RESSARCIMENTO_SAUDE
				.equals(tipoSolicitacao)) {
			stream.write(solicitacaoRessarcimentoSaude.getComprovante());
		}
	}

	public void retornarUltimaPesquisa() throws ParseException {
		abrirPesquisarSolicitacoes();
		solicitacao = solicitacaoTemp;
		pesquisarSolicitacoes();
	}
}
