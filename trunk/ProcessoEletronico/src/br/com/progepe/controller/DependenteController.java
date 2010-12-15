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
	private Servidor servidor;
	private List<SelectItem> grausParentescos = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	private List<Dependente> listaDependentes;
	private List<Dependente> listaDependentesFiltro;
	

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

	public void setListaDependentesFiltro(List<Dependente> listaDependentesFiltro) {
		this.listaDependentesFiltro = listaDependentesFiltro;
	}

	public void abrirAdicionarDependentes() throws Exception {
		try {
			dependente = new Dependente();
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
			dependente = new Dependente();
			dependente.setServidor(new Servidor());
			dependente.setRgUf(new Estado());
			dependente.setGrauParentesco(new GrauParentesco()); 
			listarGrauParentesco();
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

		
		this.getListaDependentes().add(dependente);
		DAO.getInstance().saveOrUpdate(dependente);
		listarDependentesServidorLogado();
		dependente = new Dependente();
		dependente.setRgUf(new Estado());
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
	
	public List<Dependente> listarDependentesFiltro() {
		listaDependentesFiltro = new ArrayList<Dependente>();
		setListaDependentesFiltro(DependenteDAO.getInstance().listByFilter(dependente));
		if (getListaDependentesFiltro().size() == 0) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nenhum registro para o filtro informado!",
					"Nenhum registro para o filtro informado!");
			FacesContext.getCurrentInstance().addMessage("", message);

		}
		return listaDependentesFiltro;
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
		dependente = (Dependente) context.getExternalContext().getRequestMap()
				.get("list");
	}

	public void validarEstudante(){
		if(!dependente.getIndEstudante()){
			dependente.setCurso(null);
			dependente.setFaculdade(null);
			dependente.setDataFormacao(null);
		}
	}
}
