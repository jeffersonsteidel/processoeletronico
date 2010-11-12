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
import br.com.progepe.dao.DependenteDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.GrauParentesco;
import br.com.progepe.entity.Servidor;
import br.com.progepe.validator.Validator;

public class DependenteController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private Dependente dependente;
	private List<SelectItem> grausParentescos = new ArrayList<SelectItem>();
	private List<SelectItem> ufs = new ArrayList<SelectItem>();
	DependenteDAO dependenteDAO = new DependenteDAO();
	private List<Dependente> listaDependentes;
	DAO dao = new DAO();

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
			dependente.setDocumento(new Documento());
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

	@SuppressWarnings("unchecked")
	public void salvarDependente() throws Exception {
		List<GrauParentesco> grauParentescos = dao.list(GrauParentesco.class);
		for (GrauParentesco item : grauParentescos) {
			if (item.getCodigo().equals(
					dependente.getGrauParentesco().getCodigo())) {
				dependente.setGrauParentesco(item);
				break;
			}
		}
		if( 0 ==(dependente.getDocumento().getRgUf())){
			dependente.getDocumento().setRgUf(null);
		}
		this.getListaDependentes().add(dependente);
		dao.saveOrUpdate(dependente);
		listarDependentesServidorLogado();
		dependente = new Dependente();
		dependente.setDocumento(new Documento());
		dependente.setGrauParentesco(new GrauParentesco());
		abrirAdicionarDependentes();
	}

	public void listarDependentesServidorLogado() throws Exception {
		buscarServidorLogado();
		listaDependentes = dependenteDAO.listByServidor(dependente);
		if(listaDependentes.isEmpty()){
			listaDependentes = new ArrayList<Dependente>();
		}
	}

//	public void carregar() throws Exception {
//		servidorTitulacao = (ServidorTitulacao) dao.refresh(servidorTitulacao);
//		if (servidorTitulacao.getCidadeEstabelecimentoEnsino().getCodigo() != null) {
//			listarCidadesEstabelecimento();
//		}
//		FacesContext.getCurrentInstance().getExternalContext()
//				.redirect("adicionarTitulacao.jsp");
//	}
//	
	// public void salvar() throws IOException, ParseException {
	// dao.saveOrUpdate(dependente);
	// dependente = new Dependente();
	// files = new ArrayList<Portaria>();
	// }

	// @SuppressWarnings("unchecked")
	// public void listarDependentes() {
	// listaDependentes = dao.list(Dependente.class);
	// }

	public void remover() throws Exception {
	//	dao.refresh(dependente);
		listaDependentes.remove(dependente);
		dao.delete(dependente);
		dependente = new Dependente();
		dependente.setDocumento(new Documento());
		dependente.setGrauParentesco(new GrauParentesco());
		abrirAdicionarDependentes();
	}

}
