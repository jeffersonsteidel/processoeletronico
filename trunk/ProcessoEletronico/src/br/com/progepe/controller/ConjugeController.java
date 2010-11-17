package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.ConjugeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Servidor;
import br.com.progepe.validator.Validator;

public class ConjugeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Conjuge conjuge;
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private List<Conjuge> conjugeList = new ArrayList<Conjuge>();

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

	public List<Conjuge> getConjugeList() {
		return conjugeList;
	}

	public void setConjugeList(List<Conjuge> conjugeList) {
		this.conjugeList = conjugeList;
	}

	public void abrirConjuge() throws ParseException {
		try {
			conjuge = new Conjuge();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("conjuge.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void salvarConjuge() throws Exception {
		if (0 == (conjuge.getDocumento().getRgUf())) {
			conjuge.getDocumento().setRgUf(null);
		}
		this.conjugeList.add(conjuge);
		DAO.getInstance().saveOrUpdate(conjuge);
		listarConjugesServidorLogado();
		conjuge = new Conjuge();
		conjuge.setDocumento(new Documento());
		abrirConjuge();
	}

	public void listarConjugesServidorLogado() throws Exception {
		buscarServidorLogado();
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
		conjuge = (Conjuge) DAO.getInstance().refresh(conjuge);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("conjuge.jsp");
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

	public void validarCPF() {
		if (!Validator.validaCPF(conjuge.getDocumento().getCpf())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo CPF inválido!",
					"Campo CPF inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
			conjuge.getDocumento().setCpf("");
		}
	}

}
