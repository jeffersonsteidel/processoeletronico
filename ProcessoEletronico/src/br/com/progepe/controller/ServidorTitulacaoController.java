package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
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
	private ArrayList<ServidorTitulacao> listaServidorTitulacaos = new ArrayList<ServidorTitulacao>();
	private ServidorTitulacao servidorTitulacao;
	private List<SelectItem> areasConhecimento = new ArrayList<SelectItem>();
	private List<SelectItem> paises = new ArrayList<SelectItem>();
	private List<SelectItem> cidadesEstabelecimento = new ArrayList<SelectItem>();
	private List<SelectItem> estados = new ArrayList<SelectItem>();
	private List<SelectItem> titulacoes = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private Boolean indTitulacaoEstrangeira = false;
	DAO dao = new DAO();

	public ArrayList<ServidorTitulacao> getListaServidorTitulacaos() {
		return listaServidorTitulacaos;
	}

	public void setListaServidorTitulacaos(
			ArrayList<ServidorTitulacao> listaServidorTitulacaos) {
		this.listaServidorTitulacaos = listaServidorTitulacaos;
	}

	public ServidorTitulacao getServidorTitulacao() {
		return servidorTitulacao;
	}

	public void setServidorTitulacao(ServidorTitulacao servidorTitulacao) {
		this.servidorTitulacao = servidorTitulacao;
	}

	public Boolean getIndTitulacaoEstrangeira() {
		return indTitulacaoEstrangeira;
	}

	public void setIndTitulacaoEstrangeira(Boolean indTitulacaoEstrangeira) {
		this.indTitulacaoEstrangeira = indTitulacaoEstrangeira;
	}

	public List<SelectItem> getPaises() {
		return paises;
	}

	public void setPaises(List<SelectItem> paises) {
		this.paises = paises;
	}

	public List<SelectItem> getAreasConhecimento() {
		return areasConhecimento;
	}

	public void setAreasConhecimento(List<SelectItem> areasConhecimento) {
		this.areasConhecimento = areasConhecimento;
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

	public void buscarServidorLogado() throws IOException, ParseException {
		servidorTitulacao.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		servidorTitulacao.getServidor().setSiape(siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		servidorTitulacao.setServidor(servidorDAO
				.refreshBySiape(servidorTitulacao.getServidor()));
	}

	public void abrirAdicionarServidorTitulacao() throws ParseException {
		try {
			servidorTitulacao = new ServidorTitulacao();
			servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
			servidorTitulacao.setAreaConhecimento(new AreaConhecimento());
			servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
			servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
					new Estado());
			servidorTitulacao.setServidor(new Servidor());
			servidorTitulacao.setTitulacao(new Titulacao());
			buscarServidorLogado();
			listarAreaConhecimento();
			listarEstados();
			listarTitulacoes();
			listarEstados();
			listarUf();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("adicionarTitulacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adicionarTitulacao() throws IOException, ParseException {
		listaServidorTitulacaos.add(servidorTitulacao);
		servidorTitulacao = new ServidorTitulacao();
	}

	public void salvar() throws IOException, ParseException {
		dao.saveOrUpdate(servidorTitulacao);
		servidorTitulacao = new ServidorTitulacao();
	}

	public void isTitulacaoEstrangeira() {
		if (indTitulacaoEstrangeira) {
			servidorTitulacao.setPais(new Pais());
			listarPais();
			servidorTitulacao.setCidadeEstabelecimentoEnsino(null);
		} else {
			servidorTitulacao.setPais(null);
			servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
			servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
					new Estado());
		}
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarPais() {
		paises = new ArrayList<SelectItem>();
		List<Pais> paisList = new ArrayList<Pais>();
		paisList = dao.list(Pais.class, "descricao");
		for (Pais pais : paisList) {
			paises.add(new SelectItem(pais.getCodigo(), pais.getDescricao()));
		}
		return paises;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarAreaConhecimento() {
		areasConhecimento = new ArrayList<SelectItem>();
		List<AreaConhecimento> areaConhecimentos = new ArrayList<AreaConhecimento>();
		areaConhecimentos = dao.list(AreaConhecimento.class, "descricao");
		for (AreaConhecimento areaConhecimento : areaConhecimentos) {
			areasConhecimento.add(new SelectItem(areaConhecimento.getCodigo(),
					areaConhecimento.getDescricao()));
		}
		return areasConhecimento;
	}

	public List<SelectItem> listarCidadesEstabelecimento() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadesEstabelecimento = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = cidadeDAO.listByEstado(servidorTitulacao
				.getCidadeEstabelecimentoEnsino().getEstado());
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
		estadoList = dao.list(Estado.class, "descricao");
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
		titulacaoList = dao.list(Titulacao.class, "descricao");
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
		estadoList = dao.list(Estado.class, "descricao");
		for (Estado estado : estadoList) {
			ufs.add(new SelectItem(estado.getCodigo(), estado.getUf()));
		}
		return ufs;
	}
}