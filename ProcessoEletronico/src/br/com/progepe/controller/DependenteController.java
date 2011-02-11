package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.DependenteDAO;
import br.com.progepe.dao.DocumentoImagemDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.DocumentoImagem;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.GrauParentesco;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.validator.Validator;

public class DependenteController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private Dependente dependente;
	private Dependente dependenteFilter;
	private Servidor servidor;
	private List<SelectItem> grausParentescos = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private List<SelectItem> statusSolicitacoes = new ArrayList<SelectItem>();
	private List<Dependente> listaDependentes;
	private List<Dependente> listaDependentesFiltro;
	private Integer situacao = 0;
	private Integer ativo = 0;
	private Servidor atendente;
	private List<DocumentoImagem> documentos;  

	public List<Dependente> getListaDependentes() {
		return listaDependentes;
	}

	public void setListaDependentes(List<Dependente> listaDependentes) {
		this.listaDependentes = listaDependentes;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<SelectItem> getGrausParentescos() {
		return grausParentescos;
	}

	public void setGrausParentescos(List<SelectItem> grausParentescos) {
		this.grausParentescos = grausParentescos;
	}

	public List<SelectItem> getUfs() {
		return ufs;
	}

	public void setUfs(List<SelectItem> ufs) {
		this.ufs = ufs;
	}

	public List<Dependente> getListaDependentesFiltro() {
		return listaDependentesFiltro;
	}

	public void setListaDependentesFiltro(
			List<Dependente> listaDependentesFiltro) {
		this.listaDependentesFiltro = listaDependentesFiltro;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Servidor getAtendente() {
		return atendente;
	}

	public void setAtendente(Servidor atendente) {
		this.atendente = atendente;
	}

	public List<SelectItem> getStatusSolicitacoes() {
		return statusSolicitacoes;
	}

	public void setStatusSolicitacoes(List<SelectItem> statusSolicitacoes) {
		this.statusSolicitacoes = statusSolicitacoes;
	}

	public Dependente getDependenteFilter() {
		return dependenteFilter;
	}

	public void setDependenteFilter(Dependente dependenteFilter) {
		this.dependenteFilter = dependenteFilter;
	}

	public List<DocumentoImagem> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoImagem> documentos) {
		this.documentos = documentos;
	}

	public void abrirAdicionarDependentes() throws Exception {
		try {
			dependente = new Dependente();
			dependente.setStatusSolicitacao(new StatusSolicitacao());
			dependente.setRgUf(new Estado());
			listaDependentes = new ArrayList<Dependente>();
			listaDependentes.clear();
			dependente.setGrauParentesco(new GrauParentesco());
			buscarServidorLogado();
			listarGrauParentesco();
			listarDependentesServidorLogado();
			listarUfs();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("adicionarDependente.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirListarDependentes() throws Exception {
		try {
			listaDependentesFiltro = new ArrayList<Dependente>();
			listaDependentesFiltro.clear();
			dependenteFilter = new Dependente();
			dependenteFilter.setServidor(new Servidor());
			dependenteFilter.setRgUf(new Estado());
			dependenteFilter.setGrauParentesco(new GrauParentesco());
			dependenteFilter.setStatusSolicitacao(new StatusSolicitacao());
			listarGrauParentesco();
			listarStatusSolicitacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarDependentesFilter.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		dependente.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		dependente.getServidor().setSiape(siapeAutenticado.getSiape());
		dependente.setServidor(ServidorDAO.getInstance().refreshBySiape(
				dependente.getServidor()));
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarGrauParentesco() {
		grausParentescos = new ArrayList<SelectItem>();
		List<GrauParentesco> grauParentescosList = new ArrayList<GrauParentesco>();
		grauParentescosList = DAO.getInstance().list(GrauParentesco.class,
				"descricao");
		for (GrauParentesco grauParentesco : grauParentescosList) {
			grausParentescos.add(new SelectItem(grauParentesco.getCodigo(),
					grauParentesco.getDescricao()));
		}
		return grausParentescos;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarUfs() {
		ufs = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = DAO.getInstance().list(Estado.class, "descricao");
		for (Estado estado : estadoList) {
			ufs.add(new SelectItem(estado.getCodigo(), estado.getUf()));
		}
		return ufs;
	}

	public boolean validarCPF() {
		if (!Validator.validaCPF(dependente.getCpf())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo CPF inválido!",
					"Campo CPF inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
			dependente.setCpf("");
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	public void salvarDependente() throws Exception {
		List<GrauParentesco> grauParentescos = DAO.getInstance().list(
				GrauParentesco.class);
		for (GrauParentesco item : grauParentescos) {
			if (item.getCodigo().equals(
					dependente.getGrauParentesco().getCodigo())) {
				dependente.setGrauParentesco(item);
				break;
			}
		}
		if (Constantes.ZERO.equals(dependente.getRgUf().getCodigo())) {
			dependente.setRgUf(null);
		}

		dependente.setIndAtivo(true);
		this.getListaDependentes().add(dependente);
		dependente.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		dependente.setDataAbertura(new Date());
		dependente.setAtendente(null);
		dependente.setDataAtendimento(null);
		dependente.setDataFechamento(null);
		dependente.setJustificativa(null);
		if(dependente.getCodigo() == null || Constantes.ZERO.equals(dependente.getCodigo()) ){
			dependente.setIndNovo(true);
		}else{
			dependente.setIndNovo(false);
		}
		if (validarCPF()) {
			DAO.getInstance().saveOrUpdate(dependente);
		}
		listarDependentesServidorLogado();
		dependente = new Dependente();
		dependente.setRgUf(new Estado());
		dependente.setGrauParentesco(new GrauParentesco());
		dependente.setStatusSolicitacao(new StatusSolicitacao());
		buscarServidorLogado();
	}

	public void deferir() {
		dependente.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_DEFERIDO);
		dependente.setDataFechamento(new Date());
		DAO.getInstance().update(dependente);
	}

	public void indeferir() {
		if (dependente.getJustificativa() == null
				|| dependente.getJustificativa() == "") {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa é obrigatório!",
					"O campo Justificativa é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			dependente.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			dependente.setDataFechamento(new Date());
			DAO.getInstance().update(dependente);
		}
	}

	public void listarDependentesServidorLogado() throws Exception {
		buscarServidorLogado();
		listaDependentes = DependenteDAO.getInstance().listByServidor(
				dependente);
		if (listaDependentes.isEmpty()) {
			listaDependentes = new ArrayList<Dependente>();
		}
	}

	public List<Dependente> pesquisarDependentesFiltro() {
		listaDependentesFiltro = new ArrayList<Dependente>();
		setListaDependentesFiltro(DependenteDAO.getInstance().listByFilter(
				dependenteFilter, situacao, ativo));
		if (getListaDependentesFiltro().size() == 0) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Nenhum registro para o filtro informado!",
					"Nenhum registro para o filtro informado!");
			FacesContext.getCurrentInstance().addMessage("", message);

		}
		return listaDependentesFiltro;
	}

	public void retornarUltimaPesquisa() throws IOException {
		setListaDependentesFiltro(DependenteDAO.getInstance().listByFilter(
				dependenteFilter, situacao, ativo));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarDependentesFilter.jsp");
	}

	public void remover() throws Exception {
		dependente = (Dependente) DAO.getInstance().refresh(dependente);
		listaDependentes.remove(dependente);
		DAO.getInstance().delete(dependente);
		dependente = new Dependente();
		dependente.setGrauParentesco(new GrauParentesco());
		abrirAdicionarDependentes();
	}

	public void carregar() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		dependenteFilter = (Dependente) context.getExternalContext().getRequestMap()
				.get("list");
		if (dependenteFilter.getRgUf() == null) {
			dependenteFilter.setRgUf(new Estado());
		}
		if (!(Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(dependenteFilter
				.getStatusSolicitacao().getCodigo()))) {
			atendente = new Servidor();
			atendente.setSiape(dependenteFilter.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
		}
	}

	public void ativarDesativar() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		dependente = (Dependente) context.getExternalContext().getRequestMap()
				.get("list");
		dependente.setIndAtivo(!dependente.getIndAtivo());
		dependente.setDataFechamento(null);
		dependente.setAtendente(null);
		dependente.setDataAtendimento(null);
		dependente.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		dependente.setJustificativa(null);
		DAO.getInstance().update(dependente);
	}

	public void validarEstudante() {
		if (!dependente.getIndEstudante()) {
			dependente.setCurso(null);
			dependente.setFaculdade(null);
			dependente.setDataFormacao(null);
		}
	}
	
	public void validar() throws IOException {
		dependente = (Dependente) DAO.getInstance().refresh(dependente);
		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(dependente
				.getStatusSolicitacao().getCodigo())) {
			dependente.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_EM_ANALISE);
			atendente = new Servidor();
			dependente.setDataAtendimento(new Date());
			Autenticacao siapeAutenticado = (Autenticacao) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuarioLogado");
			atendente.setSiape(siapeAutenticado.getSiape());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
			dependente.setAtendente(atendente.getSiape());
			DependenteDAO.getInstance().updateDependente(dependente);
			documentos = new ArrayList<DocumentoImagem>();
			documentos = DocumentoImagemDAO.getInstance().listDocumentosByDependente(dependente);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("dependenteAprovar.jsp");
		} else if (Constantes.STATUS_SOLICITACAO_EM_ANALISE.equals(dependente
				.getStatusSolicitacao().getCodigo())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Este Dependente já está sendo analizado por outro servidor!",
					"Este Dependente já está sendo analizado por outro servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			documentos = new ArrayList<DocumentoImagem>();
			documentos = DocumentoImagemDAO.getInstance().listDocumentosByDependente(dependente);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("dependenteAprovar.jsp");
		}
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

	public void buscarAtendente() {
		if (!(Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(dependente
				.getStatusSolicitacao().getCodigo()))) {
			atendente = new Servidor();
			atendente.setSiape(dependente.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
		}
	}
	
	public void visualizarDocumentos() {
		DocumentoImagemDAO.getInstance().listDocumentosByDependente(dependente);
	}
}
