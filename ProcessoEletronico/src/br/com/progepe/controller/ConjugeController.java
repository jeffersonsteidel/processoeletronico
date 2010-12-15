package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.ConjugeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Pais;
import br.com.progepe.entity.Servidor;
import br.com.progepe.validator.Validator;

public class ConjugeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Conjuge conjuge;
	private List<Conjuge> conjugeList = new ArrayList<Conjuge>();
	private List<SelectItem> paises = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private List<SelectItem> estados = new ArrayList<SelectItem>();
	private List<SelectItem> cidadesNascimento = new ArrayList<SelectItem>();

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
	
	public void abrirCadastrarConjuge() throws ParseException {
		try {
			conjuge = new Conjuge();
			conjuge.setCidadeNascimento(new Cidade());
			conjuge.setRgUf(new Estado());
			conjuge.getCidadeNascimento().setEstado(new Estado());
			conjuge.setPais(new Pais());
			listarPais();
			listarUfs();
			listarEstados();
			buscarServidorLogado();
			conjugeList = new ArrayList<Conjuge>();
			conjugeList = ConjugeDAO.getInstance().listByServidor(conjuge);
			if (conjugeList.size() > 0) {
				texto = "Você já possui cônjuge cadastrado, caso tenha separado cadastre o novo  cônjuge.";
			}
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("cadastrarConjuge.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salvarConjuge() throws Exception {
		if (conjuge.getIndEstrangeiro() == false) {
			conjuge.setPais(null);
		} else {
			conjuge.setCidadeNascimento(null);
		}
		DAO.getInstance().saveOrUpdate(conjuge);
		conjuge = new Conjuge();
		conjuge.setCidadeNascimento(new Cidade());
		conjuge.setRgUf(new Estado());
		conjuge.getCidadeNascimento().setEstado(new Estado());
		conjuge.setPais(new Pais());
		listarPais();
		listarUfs();
		listarEstados();
		buscarServidorLogado();
		listarConjugesServidorLogado();
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

	public void pesquisarConjuges() throws IOException {
		this.setConjugeList(ConjugeDAO.getInstance().listByServidor(
				getConjuge()));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarPortarias.jsp");
	}

	public void carregar() throws IOException, ParseException {
		FacesContext context = FacesContext.getCurrentInstance();
		conjuge = (Conjuge) context.getExternalContext().getRequestMap()
				.get("list");
		listarCidadesNascimentoConjuge();
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
	}

}
