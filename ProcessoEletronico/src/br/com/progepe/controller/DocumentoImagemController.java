package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.DocumentoImagemDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.DocumentoImagem;
import br.com.progepe.entity.Emprego;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;
import br.com.progepe.entity.TipoDocumento;

public class DocumentoImagemController  {

	private DocumentoImagem documentoImagem;
	private DocumentoImagem documentoImagemTemp;
	private List<DocumentoImagem> documentoList = new ArrayList<DocumentoImagem>();
	private Integer quantidadeArquivos = 0;
	private List<SelectItem> servidores = new ArrayList<SelectItem>();
	private List<SelectItem> dependentes = new ArrayList<SelectItem>();
	private List<SelectItem> conjuges = new ArrayList<SelectItem>();
	private List<SelectItem> tiposDocumentos = new ArrayList<SelectItem>();
	private List<SelectItem> empregos = new ArrayList<SelectItem>();
	private Integer titularDocumento = 1;

	private List<SelectItem> titulacoes = new ArrayList<SelectItem>();

	public DocumentoImagem getDocumentoImagem() {
		return documentoImagem;
	}

	public void setDocumentoImagem(DocumentoImagem documentoImagem) {
		this.documentoImagem = documentoImagem;
	}

	public DocumentoImagem getDocumentoImagemTemp() {
		return documentoImagemTemp;
	}

	public void setDocumentoImagemTemp(DocumentoImagem documentoImagemTemp) {
		this.documentoImagemTemp = documentoImagemTemp;
	}

	public Integer getQuantidadeArquivos() {
		return quantidadeArquivos;
	}

	public void setQuantidadeArquivos(Integer quantidadeArquivos) {
		this.quantidadeArquivos = quantidadeArquivos;
	}

	public List<SelectItem> getServidores() {
		return servidores;
	}

	public void setServidores(List<SelectItem> servidores) {
		this.servidores = servidores;
	}

	public List<SelectItem> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<SelectItem> dependentes) {
		this.dependentes = dependentes;
	}

	public List<SelectItem> getConjuges() {
		return conjuges;
	}

	public void setConjuges(List<SelectItem> conjuges) {
		this.conjuges = conjuges;
	}

	public List<SelectItem> getTiposDocumentos() {
		return tiposDocumentos;
	}

	public void setTiposDocumentos(List<SelectItem> tiposDocumentos) {
		this.tiposDocumentos = tiposDocumentos;
	}

	public List<DocumentoImagem> getDocumentoList() {
		return documentoList;
	}

	
	public void setDocumentoList(List<DocumentoImagem> documentoList) {
		this.documentoList = documentoList;
	}

	public Integer getTitularDocumento() {
		return titularDocumento;
	}

	public void setTitularDocumento(Integer titularDocumento) {
		this.titularDocumento = titularDocumento;
	}

	public List<SelectItem> getTitulacoes() {
		return titulacoes;
	}

	public void setTitulacoes(List<SelectItem> titulacoes) {
		this.titulacoes = titulacoes;
	}

	public List<SelectItem> getEmpregos() {
		return empregos;
	}

	public void setEmpregos(List<SelectItem> empregos) {
		this.empregos = empregos;
	}
	
	

	public void abrirAdicionarDocumentos() {
		try {
			titularDocumento = Constantes.TITULAR_DOCUMENTO_IMAGEM_SERVIDOR;
			documentoImagem = new DocumentoImagem();
			documentoImagem.setTipoDocumento(new TipoDocumento());
			buscarServidorLogado();
			listarTiposDocumentos();
			quantidadeArquivos = 0;
			documentoImagem.setImagem1(null);
			documentoImagem.setImagem2(null);
			documentoImagem.setImagem3(null);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("anexarDocumentos.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abrirAdicionarDocumentosTitulacao() {
		try {
			documentoImagem = new DocumentoImagem();
			documentoImagem.setTipoDocumento(new TipoDocumento());
			documentoImagem.setServidorTitulacao(new ServidorTitulacao());
			quantidadeArquivos = 0;
			documentoImagem.setImagem1(null);
			documentoImagem.setImagem2(null);
			documentoImagem.setImagem3(null);
			titularDocumento = Constantes.TITULAR_DOCUMENTO_IMAGEM_TITULACAO;
			buscarServidorLogado();
			listarTiposDocumentos();
			listarTitulacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("anexarDocumentosTitulacao.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abrirAdicionarDocumentosDependente() {
		try {
			documentoImagem = new DocumentoImagem();
			documentoImagem.setTipoDocumento(new TipoDocumento());
			documentoImagem.setDependente(new Dependente());
			quantidadeArquivos = 0;
			documentoImagem.setImagem1(null);
			documentoImagem.setImagem2(null);
			documentoImagem.setImagem3(null);
			titularDocumento = Constantes.TITULAR_DOCUMENTO_IMAGEM_DEPENDENTE;
			buscarServidorLogado();
			listarTiposDocumentos();
			listarDependentes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("anexarDocumentosDependente.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abrirAdicionarDocumentosConjuge() {
		try {
			documentoImagem = new DocumentoImagem();
			documentoImagem.setTipoDocumento(new TipoDocumento());
			documentoImagem.setConjuge(new Conjuge());
			quantidadeArquivos = 0;
			documentoImagem.setImagem1(null);
			documentoImagem.setImagem2(null);
			documentoImagem.setImagem3(null);
			titularDocumento = Constantes.TITULAR_DOCUMENTO_IMAGEM_CONJUGE;
			buscarServidorLogado();
			listarTiposDocumentos();
			listarConjuges();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("anexarDocumentosConjuge.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abrirAdicionarDocumentosEmprego() {
		try {
			documentoImagem = new DocumentoImagem();
			documentoImagem.setTipoDocumento(new TipoDocumento());
			documentoImagem.setEmprego(new Emprego());
			quantidadeArquivos = 0;
			documentoImagem.setImagem1(null);
			documentoImagem.setImagem2(null);
			documentoImagem.setImagem3(null);
			titularDocumento = Constantes.TITULAR_DOCUMENTO_IMAGEM_EMPREGO;
			buscarServidorLogado();
			listarTiposDocumentos();
			listarEmpregos();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("anexarDocumentosEmprego.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposDocumentos() {
		tiposDocumentos = new ArrayList<SelectItem>();
		List<TipoDocumento> tipoDocumentoList = new ArrayList<TipoDocumento>();
		tipoDocumentoList = DAO.getInstance().list(TipoDocumento.class,
				"descricao");
		for (TipoDocumento tipoDocumento : tipoDocumentoList) {
			tiposDocumentos.add(new SelectItem(tipoDocumento.getCodigo(),
					tipoDocumento.getDescricao()));
		}
		return tiposDocumentos;
	}

	public List<SelectItem> listarConjuges() throws Exception {
		conjuges = new ArrayList<SelectItem>();
		List<Conjuge> conjugeList = new ArrayList<Conjuge>();
		buscarServidorLogado();
		conjugeList = DocumentoImagemDAO.getInstance().listConjugeByServidor(
				documentoImagem.getServidor());
		for (Conjuge conjuge : conjugeList) {
			conjuges.add(new SelectItem(conjuge.getCodigo(), conjuge.getNome()));
		}
		return conjuges;
	}

	public List<SelectItem> listarDependentes() throws Exception {
		dependentes = new ArrayList<SelectItem>();
		List<Dependente> dependenteList = new ArrayList<Dependente>();
		buscarServidorLogado();
		dependenteList = DocumentoImagemDAO.getInstance()
				.listDependenteByServidor(documentoImagem.getServidor());
		for (Dependente dependente : dependenteList) {
			dependentes.add(new SelectItem(dependente.getCodigo(), dependente
					.getNome()));
		}
		return dependentes;
	}

	public List<SelectItem> listarTitulacoes() throws Exception {
		titulacoes = new ArrayList<SelectItem>();
		List<ServidorTitulacao> titulacaoList = new ArrayList<ServidorTitulacao>();
		buscarServidorLogado();
		titulacaoList = DocumentoImagemDAO.getInstance()
				.listTitulacaoByServidor(documentoImagem.getServidor());
		for (ServidorTitulacao titulacao : titulacaoList) {
			String curso = null;
			if (titulacao.getCurso() != null) {
				curso = "-" + titulacao.getCurso();
			} else {
				curso = Constantes.STRING_VAZIA;
			}
			titulacoes.add(new SelectItem(titulacao.getCodigo(), titulacao
					.getTitulacao().getDescricao() + curso));
		}
		return titulacoes;
	}

	public List<SelectItem> listarEmpregos() throws Exception {
		empregos = new ArrayList<SelectItem>();
		List<Emprego> list = new ArrayList<Emprego>();
		buscarServidorLogado();
		list = DocumentoImagemDAO.getInstance().listEmpregoByServidor(
				documentoImagem.getServidor());
		for (Emprego item : list) {
			empregos.add(new SelectItem(item.getCodigo(), item.getCargo()));
		}
		return empregos;
	}

	public void abrirPesquisarDocumentos() {
		try {
			documentoList.clear();
			titularDocumento = 1;
			documentoImagem = new DocumentoImagem();
			documentoImagem.setConjuge(new Conjuge());
			documentoImagem.setServidor(new Servidor());
			documentoImagem.setDependente(new Dependente());
			documentoImagem.setTipoDocumento(new TipoDocumento());
			listarTiposDocumentos();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("pesquisarDocumentos.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		documentoImagem.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		documentoImagem.getServidor().setSiape(siapeAutenticado.getSiape());
		documentoImagem.setServidor(ServidorDAO.getInstance().refreshBySiape(
				documentoImagem.getServidor()));
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		quantidadeArquivos++;
		if (quantidadeArquivos.equals(1)) {
			documentoImagem.setImagem1(item.getData());
		} else if (quantidadeArquivos == 2) {
			documentoImagem.setImagem2(item.getData());
		} else if (quantidadeArquivos == 3) {
			documentoImagem.setImagem3(item.getData());
		}
	}

	public void paint1(OutputStream stream, Object object) throws IOException {
		if (documentoImagem.getImagem1() != null)
			stream.write(documentoImagem.getImagem1());
	}

	public void paint2(OutputStream stream, Object object) throws IOException {
		if (documentoImagem.getImagem2() != null)
			stream.write(documentoImagem.getImagem2());
	}

	public void paint3(OutputStream stream, Object object) throws IOException {
		if (documentoImagem.getImagem3() != null)
			stream.write(documentoImagem.getImagem3());
	}

	public void paintTemp1(OutputStream stream, Object object) throws IOException {
		if (documentoImagemTemp.getImagem1() != null)
			stream.write(documentoImagemTemp.getImagem1());
	}

	public void paintTemp2(OutputStream stream, Object object) throws IOException {
		if (documentoImagemTemp.getImagem2() != null)
			stream.write(documentoImagemTemp.getImagem2());
	}

	public void paintTemp3(OutputStream stream, Object object) throws IOException {
		if (documentoImagemTemp.getImagem3() != null)
			stream.write(documentoImagemTemp.getImagem3());
	}

	
	public void salvar() throws Exception {
		if (Constantes.TITULAR_DOCUMENTO_IMAGEM_SERVIDOR.equals(titularDocumento)) {
			documentoImagem.setServidor(ServidorDAO.getInstance()
					.refreshBySiape(documentoImagem.getServidor()));
			documentoImagem.setConjuge(null);
			documentoImagem.setDependente(null);
			documentoImagem.setServidorTitulacao(null);
			documentoImagem.setEmprego(null);
		} else if (Constantes.TITULAR_DOCUMENTO_IMAGEM_CONJUGE.equals(titularDocumento)) {
			Conjuge conjuge = (Conjuge) DAO.getInstance().refresh(
					documentoImagem.getConjuge());
			documentoImagem.setConjuge(conjuge);
			documentoImagem.setDependente(null);
			documentoImagem.setServidor(null);
			documentoImagem.setServidorTitulacao(null);
			documentoImagem.setEmprego(null);
		} else if (Constantes.TITULAR_DOCUMENTO_IMAGEM_DEPENDENTE.equals(titularDocumento)) {
			documentoImagem.setEmprego(null);
			documentoImagem.setServidor(null);
			documentoImagem.setConjuge(null);
			documentoImagem.setServidorTitulacao(null);
			Dependente dependente = (Dependente) DAO.getInstance().refresh(
					documentoImagem.getDependente());
			documentoImagem.setDependente(dependente);
		} else if (Constantes.TITULAR_DOCUMENTO_IMAGEM_TITULACAO.equals(titularDocumento)) {
			documentoImagem.setEmprego(null);
			documentoImagem.setServidor(null);
			documentoImagem.setConjuge(null);
			documentoImagem.setDependente(null);
			ServidorTitulacao titulacao = (ServidorTitulacao) DAO.getInstance()
					.refresh(documentoImagem.getServidorTitulacao());
			documentoImagem.setServidorTitulacao(titulacao);
		} else if (Constantes.TITULAR_DOCUMENTO_IMAGEM_EMPREGO.equals(titularDocumento)) {
			documentoImagem.setServidorTitulacao(null);
			documentoImagem.setServidor(null);
			documentoImagem.setConjuge(null);
			documentoImagem.setDependente(null);
			Emprego emprego = (Emprego) DAO.getInstance().refresh(
					documentoImagem.getEmprego());
			documentoImagem.setEmprego(emprego);
		}

		if (documentoImagem.getImagem1() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar um Documento!",
					"É necessário adicionar um Documento!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			DAO.getInstance().save(documentoImagem);
			documentoImagem = new DocumentoImagem();
			documentoImagem.setImagem1(null);
			documentoImagem.setImagem2(null);
			documentoImagem.setImagem3(null);
			documentoImagem.setConjuge(new Conjuge());
			documentoImagem.setServidor(new Servidor());
			documentoImagem.setDependente(new Dependente());
			documentoImagem.setServidorTitulacao(new ServidorTitulacao());
			documentoImagem.setEmprego(new Emprego());
			documentoImagem.setTipoDocumento(new TipoDocumento());
			quantidadeArquivos = 0;
		}
		buscarServidorLogado();
	}

	public void abrirPesquisarMeusDocumentos() throws Exception {
		documentoList.clear();
		titularDocumento = 1;
		documentoImagem = new DocumentoImagem();
		documentoImagem.setConjuge(new Conjuge());
		documentoImagem.setDependente(new Dependente());
		documentoImagem.setTipoDocumento(new TipoDocumento());
		buscarServidorLogado();
		listarTiposDocumentos();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("pesquisarMeusDocumentos.jsp");
	}

	public void pesquisarDocumentos() {
		Boolean validacao = true;
		if (documentoImagem.getServidor().getSiape() == null
				|| documentoImagem.getServidor().getSiape() == 0) {
			validacao = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Siape do Servidor é obrigatório!",
					"O campo Siape do Servidor é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (documentoImagem.getTipoDocumento().getCodigo() == null
				|| documentoImagem.getTipoDocumento().getCodigo() == 0) {
			validacao = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Tipo do Documento é obrigatório!",
					"O campo Tipo do Documento é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (validacao) {
			documentoList = DocumentoImagemDAO.getInstance().listByFilter(
					documentoImagem);
		}
	}

	public void carregar() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		documentoImagem = (DocumentoImagem) context.getExternalContext()
				.getRequestMap().get("list");
	}

	public void verDocumentos() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		documentoImagemTemp =  (DocumentoImagem) context.getExternalContext()
				.getRequestMap().get("list");
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("visualizarDocumentos.jsp");
	}

	public void listarDocumentosEmprego() {
		documentoList = new ArrayList<DocumentoImagem>();
		if (documentoImagem.getEmprego() != null
				&& documentoImagem.getEmprego().getCodigo() != null) {
			documentoImagem.setEmprego((Emprego) DAO.getInstance().refresh(
					documentoImagem.getEmprego()));
			documentoList = DocumentoImagemDAO.getInstance()
					.listDocumentosByEmprego(documentoImagem.getEmprego());
		}
	}

	public void listarDocumentosDependente() {
		documentoList = new ArrayList<DocumentoImagem>();
		if (documentoImagem.getDependente() != null
				&& documentoImagem.getDependente().getCodigo() != null) {
			documentoImagem.setDependente((Dependente) DAO.getInstance()
					.refresh(documentoImagem.getDependente()));
			documentoList = DocumentoImagemDAO
					.getInstance()
					.listDocumentosByDependente(documentoImagem.getDependente());
		}
	}
	public void listarDocumentosConjuge() {
		documentoList = new ArrayList<DocumentoImagem>();
		if (documentoImagem.getConjuge() != null
				&& documentoImagem.getConjuge().getCodigo() != null) {
			documentoImagem.setConjuge((Conjuge) DAO.getInstance()
					.refresh(documentoImagem.getConjuge()));
			documentoList = DocumentoImagemDAO
			.getInstance()
			.listDocumentosByConjuge(documentoImagem.getConjuge());
		}
	}
	
	public void listarDocumentosTitulacao() {
		documentoImagem.setImagem1(null);
		documentoImagem.setImagem2(null);
		documentoImagem.setImagem3(null);
		documentoList = new ArrayList<DocumentoImagem>();
		if (documentoImagem.getServidorTitulacao() != null
				&& documentoImagem.getServidorTitulacao().getCodigo() != null) {
			documentoImagem.setServidorTitulacao((ServidorTitulacao) DAO.getInstance()
					.refresh(documentoImagem.getServidorTitulacao()));
			documentoList = DocumentoImagemDAO
					.getInstance()
					.listDocumentosByTitulacao(documentoImagem.getServidorTitulacao());
		}
	}
}
