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
import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.ConjugeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.DocumentoImagemDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.DocumentoImagem;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Pais;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.validator.Validator;

public class ConjugeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Conjuge conjuge;
	private Conjuge conjugeFilter;
	private List<Conjuge> conjugeList = new ArrayList<Conjuge>();
	private List<SelectItem> paises = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private List<SelectItem> estados = new ArrayList<SelectItem>();
	private List<SelectItem> cidadesNascimento = new ArrayList<SelectItem>();
	private List<Conjuge> listaConjugesByFilter = new ArrayList<Conjuge>();
	private List<SelectItem> statusSolicitacoes = new ArrayList<SelectItem>();
	private Integer situacao = 0;
	private Integer atuais = Constantes.TODOS;
	private Servidor atendente;
	private List<DocumentoImagem> documentos;

	private Estado estadoNascimento;

	private Boolean conjugeServidor = false;
	private String texto;

	public Conjuge getConjuge() {
		return conjuge;
	}

	public void setConjuge(Conjuge conjuge) {
		this.conjuge = conjuge;
	}

	public List<SelectItem> getUfs() {
		return ufs;
	}

	public void setUfs(List<SelectItem> ufs) {
		this.ufs = ufs;
	}

	public List<SelectItem> getEstados() {
		return estados;
	}

	public void setEstados(List<SelectItem> estados) {
		this.estados = estados;
	}

	public List<Conjuge> getConjugeList() {
		return conjugeList;
	}

	public void setConjugeList(List<Conjuge> conjugeList) {
		this.conjugeList = conjugeList;
	}

	public List<SelectItem> getPaises() {
		return paises;
	}

	public void setPaises(List<SelectItem> paises) {
		this.paises = paises;
	}

	public List<SelectItem> getCidadesNascimento() {
		return cidadesNascimento;
	}

	public void setCidadesNascimento(List<SelectItem> cidadesNascimento) {
		this.cidadesNascimento = cidadesNascimento;
	}

	public Estado getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(Estado estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	public Boolean getConjugeServidor() {
		return conjugeServidor;
	}

	public void setConjugeServidor(Boolean conjugeServidor) {
		this.conjugeServidor = conjugeServidor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Conjuge> getListaConjugesByFilter() {
		return listaConjugesByFilter;
	}

	public void setListaConjugesByFilter(List<Conjuge> listaConjugesByFilter) {
		this.listaConjugesByFilter = listaConjugesByFilter;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Integer getAtuais() {
		return atuais;
	}

	public void setAtuais(Integer atuais) {
		this.atuais = atuais;
	}

	public Servidor getAtendente() {
		return atendente;
	}

	public void setAtendente(Servidor atendente) {
		this.atendente = atendente;
	}

	public Conjuge getConjugeFilter() {
		return conjugeFilter;
	}

	public void setConjugeFilter(Conjuge conjugeFilter) {
		this.conjugeFilter = conjugeFilter;
	}

	public List<SelectItem> getStatusSolicitacoes() {
		return statusSolicitacoes;
	}

	public void setStatusSolicitacoes(List<SelectItem> statusSolicitacoes) {
		this.statusSolicitacoes = statusSolicitacoes;
	}

	public List<DocumentoImagem> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoImagem> documentos) {
		this.documentos = documentos;
	}

	public void abrirCadastrarConjuge() throws ParseException {
		try {
			conjuge = new Conjuge();
			conjuge.setStatusSolicitacao(new StatusSolicitacao());
			conjuge.setCidadeNascimento(new Cidade());
			conjuge.setRgUf(new Estado());
			conjuge.getCidadeNascimento().setEstado(new Estado());
			conjuge.setPais(new Pais());
			listarPais();
			listarUfs();
			listarEstados();
			buscarServidorLogado();
			conjuge.setAtual(true);
			conjugeList = new ArrayList<Conjuge>();
			conjugeList = ConjugeDAO.getInstance().listByServidor(conjuge);
			if (conjugeList.size() > 0) {
				texto = "Você já possui cônjuge cadastrado, caso tenha separado cadastre o novo  cônjuge.";
			} else {
				texto = "";
			}
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("cadastrarConjuge.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salvarConjuge() throws Exception {
		Integer existeAtual = 0;
		if (conjuge.getIndEstrangeiro() == false) {
			conjuge.setPais(null);
		} else {
			conjuge.setCidadeNascimento(null);
		}
		listarConjugesServidorLogado();
		if (conjuge.getCodigo() == null) {
			conjugeList.add(conjuge);
		}
		for (Conjuge item : conjugeList) {
			if (conjuge.getCodigo() != null
					&& item.getCodigo().equals(conjuge.getCodigo())) {
				item = conjuge;
			}
			if (item.getAtual()) {
				existeAtual = existeAtual + 1;
			}
		}
		if (conjuge.getCodigo() == null
				|| Constantes.ZERO.equals(conjuge.getCodigo())) {
			conjuge.setIndNovo(true);
		} else {
			conjuge.setIndNovo(false);
		}
		if (existeAtual <= 1) {
			conjuge.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			conjuge.setDataAbertura(new Date());
			conjuge.setAtendente(null);
			conjuge.setDataAtendimento(null);
			conjuge.setDataFechamento(null);
			conjuge.setJustificativa(null);
			DAO.getInstance().saveOrUpdate(conjuge);
			conjuge = new Conjuge();
			conjuge.setCidadeNascimento(new Cidade());
			conjuge.setRgUf(new Estado());
			conjuge.getCidadeNascimento().setEstado(new Estado());
			conjuge.setPais(new Pais());
			cidadesNascimento = new ArrayList<SelectItem>();
			conjuge.setStatusSolicitacao(new StatusSolicitacao());
			listarPais();
			listarUfs();
			listarEstados();
			buscarServidorLogado();
			listarConjugesServidorLogado();
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Você já possui um cônjuge na condição atual, por favor edite o registro para cadastrar um novo cônjuge!",
					"Você já possui um cônjuge na condição atual, por favor edite o registro para cadastrar um novo cônjuge!");
			FacesContext.getCurrentInstance().addMessage("", message);
			conjugeList.remove(conjuge);
		}
	}

	public void validar() throws IOException {
		conjuge = (Conjuge) DAO.getInstance().refresh(conjuge);
		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(conjuge
				.getStatusSolicitacao().getCodigo())) {
			conjuge.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_EM_ANALISE);
			atendente = new Servidor();
			conjuge.setDataAtendimento(new Date());
			Autenticacao siapeAutenticado = (Autenticacao) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuarioLogado");
			atendente.setSiape(siapeAutenticado.getSiape());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
			conjuge.setAtendente(atendente.getSiape());
			ConjugeDAO.getInstance().updateConjuge(conjuge);
			documentos = new ArrayList<DocumentoImagem>();
			documentos = DocumentoImagemDAO.getInstance()
					.listDocumentosByConjuge(conjuge);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("conjugeAprovar.jsp");
		} else if (Constantes.STATUS_SOLICITACAO_EM_ANALISE.equals(conjuge
				.getStatusSolicitacao().getCodigo())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Este Cônjuge já está sendo analizado por outro servidor!",
					"Este Cônjuge já está sendo analizado por outro servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			documentos = new ArrayList<DocumentoImagem>();
			documentos = DocumentoImagemDAO.getInstance()
					.listDocumentosByConjuge(conjuge);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("conjugeAprovar.jsp");
		}
	}

	public void deferir() {
		if (conjuge.getJustificativa().length() > 250) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa deve ter no máximo 250 caracteres!",
					"O campo Justificativa deve ter no máximo 250 caracteres!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else if (conjuge.getJustificativa().length() > 250) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa deve ter no máximo 250 caracteres!",
					"O campo Justificativa deve ter no máximo 250 caracteres!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			conjuge.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			conjuge.setDataFechamento(new Date());
			DAO.getInstance().update(conjuge);
		}
	}

	public void indeferir() {
		if (conjuge.getJustificativa() == null
				|| conjuge.getJustificativa() == "") {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa é obrigatório!",
					"O campo Justificativa é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else if (conjuge.getJustificativa().length() > 250) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa deve ter no máximo 250 caracteres!",
					"O campo Justificativa deve ter no máximo 250 caracteres!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			conjuge.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			conjuge.setDataFechamento(new Date());
			DAO.getInstance().update(conjuge);
		}
	}

	public void listarConjugesServidorLogado() throws Exception {
		conjugeList = ConjugeDAO.getInstance().listByServidor(conjuge);
		if (conjugeList.isEmpty()) {
			conjugeList = new ArrayList<Conjuge>();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		conjuge.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		conjuge.getServidor().setSiape(siapeAutenticado.getSiape());
		conjuge.setServidor(ServidorDAO.getInstance().refreshBySiape(
				conjuge.getServidor()));
	}

	public void carregar() throws IOException, ParseException {
		FacesContext context = FacesContext.getCurrentInstance();
		conjuge = (Conjuge) context.getExternalContext().getRequestMap()
				.get("list");
		if (conjuge.getCidadeNascimento() != null) {
			listarCidadesNascimentoConjuge();
		}
		if (conjuge.getPais() == null) {
			conjuge.setPais(new Pais());
		}
	}

	public void verificarStatus() throws IOException, ParseException {
		FacesContext context = FacesContext.getCurrentInstance();
		conjugeFilter = (Conjuge) context.getExternalContext().getRequestMap()
				.get("list");
		if (!(Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(conjugeFilter
				.getStatusSolicitacao().getCodigo()))) {
			atendente = new Servidor();
			atendente.setSiape(conjugeFilter.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
		}
	}

	public void carregarConjugeSolicitante(Servidor servidor) {
		conjuge = (Conjuge) ConjugeDAO.getInstance().refreshBySolicitante(
				servidor);
	}

	public List<SelectItem> listarCidadesNascimentoConjuge() {
		cidadesNascimento = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = CidadeDAO.getInstance().listByEstado(
				conjuge.getCidadeNascimento().getEstado());
		for (Cidade cidade : cidadeList) {
			cidadesNascimento.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidadesNascimento;
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
	public List<SelectItem> listarPais() {
		paises = new ArrayList<SelectItem>();
		List<Pais> paisList = new ArrayList<Pais>();
		paisList = DAO.getInstance().list(Pais.class, "descricao");
		for (Pais pais : paisList) {
			paises.add(new SelectItem(pais.getCodigo(), pais.getDescricao()));
		}
		return paises;
	}

	public void validarCPF() {
		if (!Validator.validaCPF(conjuge.getCpf())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo CPF inválido!",
					"Campo CPF inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
			conjuge.setCpf("");
		}
	}

	public void limparEstado() {
		conjuge.setCidadeNascimento(new Cidade());
		conjuge.getCidadeNascimento().setEstado(new Estado());
		cidadesNascimento = new ArrayList<SelectItem>();
	}

	public void abrirListarConjuge() throws Exception {
		try {
			listaConjugesByFilter.clear();
			conjuge = new Conjuge();
			conjuge.setServidor(new Servidor());
			conjuge.setCidadeNascimento(new Cidade());
			conjuge.getCidadeNascimento().setEstado(new Estado());
			conjuge.setPais(new Pais());
			conjuge.setRgUf(new Estado());
			conjuge.setStatusSolicitacao(new StatusSolicitacao());
			conjugeFilter = new Conjuge();
			conjugeFilter.setServidor(new Servidor());
			conjugeFilter.setCidadeNascimento(new Cidade());
			conjugeFilter.getCidadeNascimento().setEstado(new Estado());
			conjugeFilter.setPais(new Pais());
			conjugeFilter.setRgUf(new Estado());
			conjugeFilter.setStatusSolicitacao(new StatusSolicitacao());
			listarStatusSolicitacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarConjuge.jsp");
		} catch (IOException e) {
			e.printStackTrace();
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

	public List<Conjuge> buscarConjuges() {
		listaConjugesByFilter = (List<Conjuge>) ConjugeDAO.getInstance()
				.listByFilter(conjugeFilter, situacao, atuais);
		return listaConjugesByFilter;
	}

	public void retornarUltimaPesquisa() throws IOException {
		listaConjugesByFilter = (List<Conjuge>) ConjugeDAO.getInstance()
				.listByFilter(conjugeFilter, situacao, atuais);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarConjuge.jsp");
	}
}
