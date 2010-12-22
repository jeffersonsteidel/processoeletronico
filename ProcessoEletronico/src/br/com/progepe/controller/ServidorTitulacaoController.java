package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.dao.ServidorTitulacaoDAO;
import br.com.progepe.entity.AreaConhecimento;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Pais;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;
import br.com.progepe.entity.Titulacao;

public class ServidorTitulacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private List<ServidorTitulacao> listaServidorTitulacoes = new ArrayList<ServidorTitulacao>();
	private ServidorTitulacao servidorTitulacao;
	private List<SelectItem> areasConhecimento = new ArrayList<SelectItem>();
	private List<SelectItem> paises = new ArrayList<SelectItem>();
	private List<SelectItem> cidadesEstabelecimento = new ArrayList<SelectItem>();
	private List<SelectItem> estados = new ArrayList<SelectItem>();
	private List<SelectItem> titulacoes = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private Boolean indTitulacaoEstrangeira = false;
	private Boolean indSuperior = false;
	private List<ServidorTitulacao> listaTitulacoes = new ArrayList<ServidorTitulacao>();
	private Integer situacao = 0;

	public List<ServidorTitulacao> getListaServidorTitulacoes() {
		return listaServidorTitulacoes;
	}

	public void setListaServidorTitulacoes(
			List<ServidorTitulacao> listaServidorTitulacoes) {
		this.listaServidorTitulacoes = listaServidorTitulacoes;
	}

	public ServidorTitulacao getServidorTitulacao() {
		return servidorTitulacao;
	}

	public void setServidorTitulacao(ServidorTitulacao servidorTitulacao) {
		this.servidorTitulacao = servidorTitulacao;
	}

	public List<SelectItem> getAreasConhecimento() {
		return areasConhecimento;
	}

	public void setAreasConhecimento(List<SelectItem> areasConhecimento) {
		this.areasConhecimento = areasConhecimento;
	}

	public List<SelectItem> getPaises() {
		return paises;
	}

	public void setPaises(List<SelectItem> paises) {
		this.paises = paises;
	}

	public List<SelectItem> getCidadesEstabelecimento() {
		return cidadesEstabelecimento;
	}

	public void setCidadesEstabelecimento(
			List<SelectItem> cidadesEstabelecimento) {
		this.cidadesEstabelecimento = cidadesEstabelecimento;
	}

	public List<SelectItem> getEstados() {
		return estados;
	}

	public void setEstados(List<SelectItem> estados) {
		this.estados = estados;
	}

	public List<SelectItem> getTitulacoes() {
		return titulacoes;
	}

	public void setTitulacoes(List<SelectItem> titulacoes) {
		this.titulacoes = titulacoes;
	}

	public List<SelectItem> getUfs() {
		return ufs;
	}

	public void setUfs(List<SelectItem> ufs) {
		this.ufs = ufs;
	}

	public Boolean getIndTitulacaoEstrangeira() {
		return indTitulacaoEstrangeira;
	}

	public void setIndTitulacaoEstrangeira(Boolean indTitulacaoEstrangeira) {
		this.indTitulacaoEstrangeira = indTitulacaoEstrangeira;
	}

	public Boolean getIndSuperior() {
		return indSuperior;
	}

	public void setIndSuperior(Boolean indSuperior) {
		this.indSuperior = indSuperior;
	}

	public List<ServidorTitulacao> getListaTitulacoes() {
		return listaTitulacoes;
	}

	public void setListaTitulacoes(List<ServidorTitulacao> listaTitulacoes) {
		this.listaTitulacoes = listaTitulacoes;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public void abrirAdicionarServidorTitulacao() throws Exception {
		try {
			listaServidorTitulacoes.clear();
			servidorTitulacao = new ServidorTitulacao();
			servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
			servidorTitulacao.setPais(new Pais());
			servidorTitulacao.setAreaConhecimento(new AreaConhecimento());
			servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
			servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
					new Estado());
			servidorTitulacao.setTitulacao(new Titulacao());
			buscarServidorLogado();
			listarAreaConhecimento();
			listarEstados();
			listarTitulacoes();
			listarUf();
			listarTitulacoesServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("adicionarTitulacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirListarServidorTitulacao() throws Exception {
		try {
			listaTitulacoes.clear();
			listaServidorTitulacoes.clear();
			servidorTitulacao = new ServidorTitulacao();
			servidorTitulacao.setServidor(new Servidor());
			servidorTitulacao.setAreaConhecimento(new AreaConhecimento());
			servidorTitulacao.setTitulacao(new Titulacao());
			listarAreaConhecimento();
			listarTitulacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarTitulacoes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		servidorTitulacao.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		servidorTitulacao.getServidor().setSiape(siapeAutenticado.getSiape());
		servidorTitulacao.setServidor(ServidorDAO.getInstance().refreshBySiape(
				servidorTitulacao.getServidor()));
	}

	public void isTitulacaoEstrangeira() {
		if (indTitulacaoEstrangeira) {
			servidorTitulacao.setPais(new Pais());
			listarPais();
			servidorTitulacao.setCidadeEstabelecimentoEnsino(null);
		} else {
			servidorTitulacao.setPais(null);
			cidadesEstabelecimento = new ArrayList<SelectItem>();
			servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
			servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
					new Estado());
		}
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarPais() {
		paises = new ArrayList<SelectItem>();
		List<Pais> paisList = new ArrayList<Pais>();
		paisList = DAO.getInstance().list(Pais.class, "descricao");
		for (Pais pais : paisList) {
			paises.add(new SelectItem(pais.getCodigo(), pais.getDescricao()));
		}
		return paises;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarAreaConhecimento() {
		areasConhecimento = new ArrayList<SelectItem>();
		List<AreaConhecimento> areaConhecimentos = new ArrayList<AreaConhecimento>();
		areaConhecimentos = DAO.getInstance().list(AreaConhecimento.class,
				"descricao");
		for (AreaConhecimento areaConhecimento : areaConhecimentos) {
			areasConhecimento.add(new SelectItem(areaConhecimento.getCodigo(),
					areaConhecimento.getDescricao()));
		}
		return areasConhecimento;
	}

	public List<SelectItem> listarCidadesEstabelecimento() {
		cidadesEstabelecimento = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = CidadeDAO.getInstance().listByEstado(
				servidorTitulacao.getCidadeEstabelecimentoEnsino().getEstado());
		for (Cidade cidade : cidadeList) {
			cidadesEstabelecimento.add(new SelectItem(cidade.getCodigo(),
					cidade.getDescricao()));
		}
		return cidadesEstabelecimento;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarEstados() {
		estados = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = DAO.getInstance().list(Estado.class, "descricao");
		for (Estado estado : estadoList) {
			estados.add(new SelectItem(estado.getCodigo(), estado
					.getDescricao()));
		}
		return estados;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTitulacoes() {
		titulacoes = new ArrayList<SelectItem>();
		List<Titulacao> titulacaoList = new ArrayList<Titulacao>();
		titulacaoList = DAO.getInstance().list(Titulacao.class, "descricao");
		for (Titulacao titulacao : titulacaoList) {
			titulacoes.add(new SelectItem(titulacao.getCodigo(), titulacao
					.getDescricao()));
		}
		return titulacoes;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarUf() {
		ufs = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = DAO.getInstance().list(Estado.class, "descricao");
		for (Estado estado : estadoList) {
			ufs.add(new SelectItem(estado.getCodigo(), estado.getUf()));
		}
		return ufs;
	}

	public void salvarTitulacao() throws Exception {
		if (servidorTitulacao.getEstadoOrgaoEmissor() != null) {
			if (Constantes.ZERO.equals(servidorTitulacao
					.getEstadoOrgaoEmissor().getCodigo())) {
				servidorTitulacao.setEstadoOrgaoEmissor(null);
			}
		}
		if (servidorTitulacao.getPais() != null) {
			if (Constantes.ZERO.equals(servidorTitulacao.getPais().getCodigo())) {
				servidorTitulacao.setPais(null);
			}
		}
		DAO.getInstance().saveOrUpdate(servidorTitulacao);
		listarTitulacoesServidorLogado();
		servidorTitulacao = new ServidorTitulacao();
		servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
		servidorTitulacao.setAreaConhecimento(new AreaConhecimento());
		servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
		servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
				new Estado());
		servidorTitulacao.setTitulacao(new Titulacao());
		servidorTitulacao.setPais(new Pais());
		this.setIndTitulacaoEstrangeira(false);
		estados = new ArrayList<SelectItem>();
		ufs = new ArrayList<SelectItem>();
		cidadesEstabelecimento = new ArrayList<SelectItem>();
		paises = new ArrayList<SelectItem>();
		buscarServidorLogado();
		listarEstados();
		listarUf();
		listarPais();
	}

	public void listarTitulacoesServidorLogado() throws Exception {
		buscarServidorLogado();
		listaServidorTitulacoes = ServidorTitulacaoDAO.getInstance()
				.listByServidor(servidorTitulacao);
	}

	public void remover() throws Exception {
		servidorTitulacao = (ServidorTitulacao) DAO.getInstance().refresh(
				servidorTitulacao);
		DAO.getInstance().delete(servidorTitulacao);
		abrirAdicionarServidorTitulacao();
	}

	public void carregar() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		servidorTitulacao = (ServidorTitulacao) context.getExternalContext()
				.getRequestMap().get("list");
		if (servidorTitulacao.getEstadoOrgaoEmissor() == null) {
			servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
		}
		if (servidorTitulacao.getPais() == null) {
			setIndTitulacaoEstrangeira(false);
			servidorTitulacao.setPais(new Pais());
		} else {
			setIndTitulacaoEstrangeira(true);
			listarPais();
		}
		if (Constantes.ENSINO_FUNDAMENTAL.equals(servidorTitulacao
				.getTitulacao().getCodigo())
				|| Constantes.ENSINO_MEDIO.equals(servidorTitulacao
						.getTitulacao().getCodigo())) {
			setIndSuperior(false);
		} else {
			setIndSuperior(true);
		}
		if (servidorTitulacao.getCidadeEstabelecimentoEnsino() != null) {
			listarCidadesEstabelecimento();
		}
	}

	public void carregarTitulacao() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		servidorTitulacao = (ServidorTitulacao) context.getExternalContext()
				.getRequestMap().get("list");
	}

	public List<ServidorTitulacao> listarTitulacoesFiltro() {
		listaTitulacoes = (List<ServidorTitulacao>) ServidorTitulacaoDAO
				.getInstance().listByFilter(servidorTitulacao, situacao);
		return listaTitulacoes;
	}

	public void validarTitulacao() {
		if (Constantes.ENSINO_FUNDAMENTAL.equals(servidorTitulacao
				.getTitulacao().getCodigo())
				|| Constantes.ENSINO_MEDIO.equals(servidorTitulacao
						.getTitulacao().getCodigo())) {
			setIndSuperior(false);
			servidorTitulacao.setCargaHoraria(null);
			servidorTitulacao.setCurso(null);
			servidorTitulacao.setEstabelecimentoEnsino(null);
			servidorTitulacao.setAreaConhecimento(null);
		} else {
			setIndSuperior(true);
			servidorTitulacao.setAreaConhecimento(new AreaConhecimento());
			servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
		}
	}
}
