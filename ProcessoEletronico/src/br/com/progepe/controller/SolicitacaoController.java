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
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.dao.SolicitacaoDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.Solicitacao;
import br.com.progepe.entity.SolicitacaoAlimentacao;
import br.com.progepe.entity.SolicitacaoCasamento;
import br.com.progepe.entity.SolicitacaoContaBancaria;
import br.com.progepe.entity.SolicitacaoHorarioEspecialEstudante;
import br.com.progepe.entity.SolicitacaoLicencaPaternidade;
import br.com.progepe.entity.SolicitacaoObito;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

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

	private Long codigoSolicitacao;
	private Long tipoSolicitacao;
	private Boolean desabilitaBotao = true;

	DAO dao = new DAO();
	SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();

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

	public void abrirPesquisarSolicitacoes() throws ParseException {
		try {
			solicitacoes = new ArrayList<Solicitacao>();
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
		if (solicitacao.getSolicitante().getSiape() != 0) {
			ServidorDAO servidorDAO = new ServidorDAO();
			solicitacao.setSolicitante(servidorDAO.refreshByFilter(solicitacao
					.getSolicitante()));
		}
		this.setSolicitacoes(solicitacaoDAO.listByFilter(solicitacao,
				dataAberturaInicial, dataAberturaFinal));
		return this.getSolicitacoes();
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarStatusSolicitacoes() {
		statusSolicitacoes = new ArrayList<SelectItem>();
		List<StatusSolicitacao> statusSolicitacoesList = new ArrayList<StatusSolicitacao>();
		statusSolicitacoesList = dao.list(StatusSolicitacao.class, "descricao");
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
		tipoSolicitacoesList = dao.list(TipoSolicitacao.class, "descricao");
		for (TipoSolicitacao tipoSolicitacao : tipoSolicitacoesList) {
			tiposSolicitacoes.add(new SelectItem(tipoSolicitacao.getCodigo(),
					tipoSolicitacao.getDescricao()));
		}
		return tiposSolicitacoes;
	}

	public List<Solicitacao> abrirMinhasSolicitacoes() throws ParseException {
		try {
			minhasSolicitacoes = new ArrayList<Solicitacao>();
			ServidorDAO servidorDAO = new ServidorDAO();
			solicitacao = new Solicitacao();
			solicitacao.setSolicitante(new Servidor());
			solicitacao.setStatusSolicitacao(new StatusSolicitacao());
			solicitacao.setTipoSolicitacao(new TipoSolicitacao());

			Autenticacao siapeAutenticado = (Autenticacao) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuarioLogado");
			solicitacao.getSolicitante().setSiape(siapeAutenticado.getSiape());
			solicitacao.setSolicitante(servidorDAO.refreshByFilter(solicitacao
					.getSolicitante()));
			this.setMinhasSolicitacoes(solicitacaoDAO.listByFilter(solicitacao,
					null, null));
			for (Solicitacao item : this.getMinhasSolicitacoes()) {
				servidorDAO = new ServidorDAO();
				Servidor servidor = new Servidor();
				servidor.setSiape(item.getAtendente());
				if (item.getAtendente() != null) {
					item.setAtendenteLogado(servidorDAO
							.refreshBySiape(servidor));
				}
			}
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarMinhasSolicitacoes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.getMinhasSolicitacoes();
	}

	public void carregarSolicitacaoContaBancaria(
			SolicitacaoContaBancaria codigoSolicitacaoContaBancaria)
			throws IOException {
		solicitacaoContaBancaria = (SolicitacaoContaBancaria) dao
				.refresh(codigoSolicitacaoContaBancaria);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoContaBancariaAprovar.jsp ");
	}

	public void carregarSolicitacaoAlimentacao(
			SolicitacaoAlimentacao codigoSolicitacaoAlimentacao)
			throws IOException {
		solicitacaoAlimentacao = (SolicitacaoAlimentacao) dao
				.refresh(codigoSolicitacaoAlimentacao);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoAlimentacaoAprovar.jsp ");
	}

	public void carregarSolicitacaoLicencaPaternidade(
			SolicitacaoLicencaPaternidade codigoSolicitacaoLicencaPaternidade)
			throws IOException {
		solicitacaoLicencaPaternidade = (SolicitacaoLicencaPaternidade) dao
				.refresh(codigoSolicitacaoLicencaPaternidade);
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
		solicitacaoHorarioEspecialEstudante = (SolicitacaoHorarioEspecialEstudante) dao
				.refresh(codigoSolicitacaoHorarioEspecialEstudante);
		solicitacaoHorarioEspecialEstudante.getFiles().add(
				solicitacaoHorarioEspecialEstudante);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoHorarioEspecialEstudanteAprovar.jsp ");
	}

	public void carregarSolicitacaoObito(SolicitacaoObito codigoSolicitacaoObito)
			throws IOException {
		solicitacaoObito = (SolicitacaoObito) dao
				.refresh(codigoSolicitacaoObito);
		solicitacaoObito.getFiles().add(solicitacaoObito);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoObitoAprovar.jsp ");
	}

	public void carregarSolicitacaoCasamento(
			SolicitacaoCasamento codigoSolicitacaoCasamento) throws IOException {
		solicitacaoCasamento = (SolicitacaoCasamento) dao
				.refresh(codigoSolicitacaoCasamento);
		solicitacaoCasamento.getFiles().add(solicitacaoCasamento);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("solicitacaoCasamentoAprovar.jsp ");
	}

	public void carregarSolicitacao() throws IOException, ParseException {
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		Servidor servidor = new Servidor();
		servidor.setSiape(siapeAutenticado.getSiape());

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
			solicitacaoContaBancaria = (SolicitacaoContaBancaria) solicitacaoDAO
					.carregarSoliciacaoContaBancaria(codigoSolicitacao);
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
				dao.saveOrUpdate(solicitacaoContaBancaria);
			}
			this.carregarSolicitacaoContaBancaria(solicitacaoContaBancaria);
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE
				.equals(tipoSolicitacao)) {
			solicitacaoLicencaPaternidade = new SolicitacaoLicencaPaternidade();
			solicitacaoLicencaPaternidade
					.setFiles(new ArrayList<SolicitacaoLicencaPaternidade>());
			solicitacaoLicencaPaternidade.setSolicitante(new Servidor());
			solicitacaoLicencaPaternidade.setCodigo(codigoSolicitacao);
			solicitacaoLicencaPaternidade = (SolicitacaoLicencaPaternidade) solicitacaoDAO
					.carregarSolicitacaoLicencaPaternidade(codigoSolicitacao);
			if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
					.equals(solicitacaoLicencaPaternidade
							.getStatusSolicitacao().getCodigo())) {
				this.setDesabilitaBotao(false);
				solicitacaoLicencaPaternidade.getStatusSolicitacao().setCodigo(
						Constantes.STATUS_SOLICITACAO_EM_ANALISE);
				solicitacaoLicencaPaternidade.setDataAtendimento(new Date());
				solicitacaoLicencaPaternidade.setAtendente(siapeAutenticado
						.getSiape());
				solicitacaoLicencaPaternidade
						.setAtendenteLogado(new Servidor());
				solicitacaoLicencaPaternidade.setAtendenteLogado(servidor);
				dao.saveOrUpdate(solicitacaoLicencaPaternidade);
			}
			this.carregarSolicitacaoLicencaPaternidade(solicitacaoLicencaPaternidade);
		} else if (Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE
				.equals(tipoSolicitacao)) {
			solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
			solicitacaoHorarioEspecialEstudante
					.setFiles(new ArrayList<SolicitacaoHorarioEspecialEstudante>());
			solicitacaoHorarioEspecialEstudante.setSolicitante(new Servidor());
			solicitacaoHorarioEspecialEstudante.setCodigo(codigoSolicitacao);
			solicitacaoHorarioEspecialEstudante = (SolicitacaoHorarioEspecialEstudante) solicitacaoDAO
					.carregarSolicitacaoHorarioEspecialEstudante(codigoSolicitacao);
			if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
					.equals(solicitacaoHorarioEspecialEstudante
							.getStatusSolicitacao().getCodigo())) {
				this.setDesabilitaBotao(false);
				solicitacaoHorarioEspecialEstudante.getStatusSolicitacao()
						.setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
				solicitacaoHorarioEspecialEstudante
						.setDataAtendimento(new Date());
				solicitacaoHorarioEspecialEstudante
						.setAtendente(siapeAutenticado.getSiape());
				solicitacaoHorarioEspecialEstudante
						.setAtendenteLogado(new Servidor());
				solicitacaoHorarioEspecialEstudante
						.setAtendenteLogado(servidor);
				dao.saveOrUpdate(solicitacaoHorarioEspecialEstudante);
			}
			this.carregarSolicitacaoHorarioEspecialEstudante(solicitacaoHorarioEspecialEstudante);
		} else if (Constantes.TIPO_SOLICITACAO_OBITO.equals(tipoSolicitacao)) {
			solicitacaoObito = new SolicitacaoObito();
			solicitacaoObito.setFiles(new ArrayList<SolicitacaoObito>());
			solicitacaoObito.setSolicitante(new Servidor());
			solicitacaoObito.setCodigo(codigoSolicitacao);
			solicitacaoObito = (SolicitacaoObito) solicitacaoDAO
					.carregarSolicitacaoObito(codigoSolicitacao);
			if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
					.equals(solicitacaoObito.getStatusSolicitacao().getCodigo())) {
				this.setDesabilitaBotao(false);
				solicitacaoObito.getStatusSolicitacao().setCodigo(
						Constantes.STATUS_SOLICITACAO_EM_ANALISE);
				solicitacaoObito.setDataAtendimento(new Date());
				solicitacaoObito.setAtendente(siapeAutenticado.getSiape());
				solicitacaoObito.setAtendenteLogado(new Servidor());
				solicitacaoObito.setAtendenteLogado(servidor);
			}
			dao.saveOrUpdate(solicitacaoObito);
			this.carregarSolicitacaoObito(solicitacaoObito);
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO
				.equals(tipoSolicitacao)) {
			solicitacaoCasamento = new SolicitacaoCasamento();
			solicitacaoCasamento
					.setFiles(new ArrayList<SolicitacaoCasamento>());
			solicitacaoCasamento.setSolicitante(new Servidor());
			solicitacaoCasamento.setCodigo(codigoSolicitacao);
			solicitacaoCasamento = (SolicitacaoCasamento) solicitacaoDAO
					.carregarSolicitacaoCasamento(codigoSolicitacao);
			if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
					.equals(solicitacaoCasamento.getStatusSolicitacao()
							.getCodigo())) {
				this.setDesabilitaBotao(false);
				solicitacaoCasamento.getStatusSolicitacao().setCodigo(
						Constantes.STATUS_SOLICITACAO_EM_ANALISE);
				solicitacaoCasamento.setDataAtendimento(new Date());
				solicitacaoCasamento.setAtendente(siapeAutenticado.getSiape());
				solicitacaoCasamento.setAtendenteLogado(new Servidor());
				solicitacaoCasamento.setAtendenteLogado(servidor);
				dao.saveOrUpdate(solicitacaoCasamento);
			}
			this.carregarSolicitacaoCasamento(solicitacaoCasamento);
		} else if (Constantes.TIPO_SOLICITACAO_AUXILIO_ALIMENTACAO
				.equals(tipoSolicitacao)) {
			solicitacaoAlimentacao = new SolicitacaoAlimentacao();
			solicitacaoAlimentacao.setSolicitante(new Servidor());
			solicitacaoAlimentacao.setCodigo(codigoSolicitacao);
			solicitacaoAlimentacao = (SolicitacaoAlimentacao) solicitacaoDAO
					.carregarSolicitacaoAlimentacao(codigoSolicitacao);
			if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO
					.equals(solicitacaoAlimentacao.getStatusSolicitacao()
							.getCodigo())) {
				this.setDesabilitaBotao(false);
				solicitacaoAlimentacao.getStatusSolicitacao().setCodigo(
						Constantes.STATUS_SOLICITACAO_EM_ANALISE);
				solicitacaoAlimentacao.setDataAtendimento(new Date());
				solicitacaoAlimentacao
						.setAtendente(siapeAutenticado.getSiape());
				solicitacaoAlimentacao.setAtendenteLogado(new Servidor());
				solicitacaoAlimentacao.setAtendenteLogado(servidor);
				dao.saveOrUpdate(solicitacaoAlimentacao);
			}
			this.carregarSolicitacaoAlimentacao(solicitacaoAlimentacao);
		}
	}

	public void deferirSolicitacao() throws IOException, ParseException {
		if (Constantes.TIPO_SOLICITACAO_ALTERAR_CONTA_BANCARIA
				.equals(tipoSolicitacao)) {
			solicitacaoContaBancaria.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoContaBancaria.setDataFechamento(new Date());
			solicitacaoDAO.updateSolicitacao(solicitacaoContaBancaria);
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
			dao.update(solicitacaoContaBancaria.getSolicitante());
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE
				.equals(tipoSolicitacao)) {
			solicitacaoLicencaPaternidade.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoLicencaPaternidade.setDataFechamento(new Date());
			dao.update(solicitacaoLicencaPaternidade);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE
				.equals(tipoSolicitacao)) {
			solicitacaoHorarioEspecialEstudante.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoHorarioEspecialEstudante.setDataFechamento(new Date());
			dao.update(solicitacaoHorarioEspecialEstudante);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_OBITO.equals(tipoSolicitacao)) {
			solicitacaoObito.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoObito.setDataFechamento(new Date());
			dao.update(solicitacaoObito);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO
				.equals(tipoSolicitacao)) {
			solicitacaoCasamento.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoCasamento.setDataFechamento(new Date());
			dao.update(solicitacaoCasamento);
			this.setDesabilitaBotao(true);
		} else if (Constantes.TIPO_SOLICITACAO_AUXILIO_ALIMENTACAO
				.equals(tipoSolicitacao)) {
			solicitacaoAlimentacao.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			solicitacaoAlimentacao.setDataFechamento(new Date());
			dao.update(solicitacaoAlimentacao);
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
				solicitacaoDAO.saveOrUpdate(solicitacaoContaBancaria);
				this.setDesabilitaBotao(true);
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
				solicitacaoDAO.saveOrUpdate(solicitacaoLicencaPaternidade);
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
				solicitacaoDAO
						.saveOrUpdate(solicitacaoHorarioEspecialEstudante);
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
				solicitacaoDAO.saveOrUpdate(solicitacaoObito);
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
				solicitacaoDAO.saveOrUpdate(solicitacaoCasamento);
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
				solicitacaoDAO.saveOrUpdate(solicitacaoAlimentacao);
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
		}
	}
}
