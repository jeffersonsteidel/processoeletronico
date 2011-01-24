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
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Classe;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.Progressao;
import br.com.progepe.entity.Servidor;

public class ProgressaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Progressao progressao;
	private List<Progressao> progressaoList;
	private List<SelectItem> classes = new ArrayList<SelectItem>();
	private List<SelectItem> padroes = new ArrayList<SelectItem>();
	private List<SelectItem> motivos = new ArrayList<SelectItem>();
	private Boolean indNovo;


	public Progressao getProgressao() {
		return progressao;
	}

	public void setProgressao(Progressao progressao) {
		this.progressao = progressao;
	}

	public List<Progressao> getProgressaoList() {
		return progressaoList;
	}

	public void setProgressaoList(List<Progressao> progressaoList) {
		this.progressaoList = progressaoList;
	}

	public List<SelectItem> getClasses() {
		return classes;
	}

	public void setClasses(List<SelectItem> classes) {
		this.classes = classes;
	}

	public List<SelectItem> getPadroes() {
		return padroes;
	}

	public void setPadroes(List<SelectItem> padroes) {
		this.padroes = padroes;
	}

	public List<SelectItem> getMotivos() {
		return motivos;
	}

	public void setMotivos(List<SelectItem> motivos) {
		this.motivos = motivos;
	}

	public Boolean getIndNovo() {
		return indNovo;
	}

	public void setIndNovo(Boolean indNovo) {
		this.indNovo = indNovo;
	}
	
	public void buscarServidorLogado() throws IOException, ParseException {
		progressao.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		progressao.getServidor().setSiape(siapeAutenticado.getSiape());
		progressao.setServidor(ServidorDAO.getInstance()
				.refreshBySiape(progressao.getServidor()));
	}
	
	
	public void abrirCadastrarProgressao() throws ParseException {
		try {
			indNovo = true;
			progressao = new Progressao();
			buscarServidorLogado();
			progressao.setClasseAntiga(progressao.getServidor().getCargo().getClasse());
			progressao.setClasseNova(new Classe());
			progressao.setPadraoAntigo(progressao.getServidor().getPadrao());
			progressao.setPadraoNovo(new Padrao());
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("cadastrarLotacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarClasses() {
		classes = new ArrayList<SelectItem>();
		List<Classe> classeList = new ArrayList<Classe>();
		classeList = DAO.getInstance().list(Classe.class, "sigla");
		for (Classe classe : classeList) {
			classes.add(new SelectItem(classe.getCodigo(), classe
					.getSigla()));
		}
		return classes;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarPadroes() {
		padroes = new ArrayList<SelectItem>();
		List<Padrao> padraoList = new ArrayList<Padrao>();
		padraoList = DAO.getInstance().list(Padrao.class, "nivel");
		for (Padrao padrao : padraoList) {
			padroes.add(new SelectItem(padrao.getCodigo(), padrao
					.getNivel().toString()));
		}
		return padroes;
	}
	
	
	public void salvar() {
		if (indNovo) {
			DAO.getInstance().save(progressao);
		} else {
			DAO.getInstance().update(progressao);
		}
		progressao = new Progressao();
		progressao.setClasseAntiga(progressao.getServidor().getCargo().getClasse());
		progressao.setClasseNova(new Classe());
		progressao.setPadraoAntigo(progressao.getServidor().getPadrao());
		progressao.setPadraoNovo(new Padrao());
		}
}