package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.DependenteDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.GrauParentesco;
import br.com.progepe.entity.Servidor;
import br.com.progepe.validator.Validator;

public class DependenteController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private Dependente dependente;
	private List<SelectItem> grausParentescos = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private List<Dependente> listaDependentes;

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

	public void abrirAdicionarDependentes() throws Exception {
		try {
			dependente = new Dependente();
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

	public void validarCPF() {
		if (!Validator.validaCPF(dependente.getCpf())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo CPF inválido!",
					"Campo CPF inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
			dependente.setCpf("");
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
		if (Constantes.ZERO.equals(dependente.getRgUf())) {
			dependente.setRgUf(null);
		}

		if (dependente.getIndEstudante() == false) {
			dependente.setCurso("");
			dependente.setFaculdade("");
			dependente.setDataFormacao(null);
		}

		this.getListaDependentes().add(dependente);
		DAO.getInstance().saveOrUpdate(dependente);
		listarDependentesServidorLogado();
		dependente = new Dependente();
		dependente.setGrauParentesco(new GrauParentesco());
		buscarServidorLogado();
	}

	public void listarDependentesServidorLogado() throws Exception {
		buscarServidorLogado();
		listaDependentes = DependenteDAO.getInstance().listByServidor(
				dependente);
		if (listaDependentes.isEmpty()) {
			listaDependentes = new ArrayList<Dependente>();
		}
	}

	public void remover() throws Exception {
		dependente = (Dependente) DAO.getInstance().refresh(dependente);
		listaDependentes.remove(dependente);
		DAO.getInstance().delete(dependente);
		dependente = new Dependente();
		dependente.setGrauParentesco(new GrauParentesco());
		buscarServidorLogado();
	}

	public void carregar() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		dependente = (Dependente) context.getExternalContext().getRequestMap()
				.get("list");
	}

}
