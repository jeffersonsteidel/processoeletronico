package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.GrauParentesco;
import br.com.progepe.entity.Portaria;
import br.com.progepe.entity.Servidor;
import br.com.progepe.validator.Validator;

public class DependenteController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private ArrayList<Portaria> files = new ArrayList<Portaria>();
	private ArrayList<Dependente> listaDependentes = new ArrayList<Dependente>();
	private Dependente dependente;
	private List<SelectItem> grausParentescos = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	DAO dao = new DAO();

	public ArrayList<Portaria> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Portaria> files) {
		this.files = files;
	}
	
	public ArrayList<Dependente> getListaDependentes() {
		return listaDependentes;
	}

	public void setListaDependentes(ArrayList<Dependente> listaDependentes) {
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

	public void abrirAdicionarDependentes() throws ParseException {
		try {
			dependente = new Dependente();
			dependente.setDocumento(new Documento());
			dependente.setGrauParentesco(new GrauParentesco());
			buscarServidorLogado();
			listarGrauParentesco();
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
		ServidorDAO servidorDAO = new ServidorDAO();
		dependente.setServidor(servidorDAO.refreshBySiape(dependente
				.getServidor()));
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarGrauParentesco() {
		grausParentescos = new ArrayList<SelectItem>();
		List<GrauParentesco> grauParentescosList = new ArrayList<GrauParentesco>();
		grauParentescosList = dao.list(GrauParentesco.class, "descricao");
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
		estadoList = dao.list(Estado.class, "descricao");
		for (Estado estado : estadoList) {
			ufs.add(new SelectItem(estado.getCodigo(), estado.getUf()));
		}
		return ufs;
	}
	
	public void validarCPF() {
		if (!Validator.validaCPF(dependente.getDocumento().getCpf())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo CPF inválido!",
					"Campo CPF inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
			dependente.getDocumento().setCpf("");
		}
	}
	
	public void adicionarDependente() throws IOException, ParseException {
		listaDependentes.add(dependente);
		dependente = new Dependente();
	}

	public void salvar() throws IOException, ParseException {
		dao.saveOrUpdate(dependente);
		dependente = new Dependente();
		files = new ArrayList<Portaria>();
	}
	
	
}
