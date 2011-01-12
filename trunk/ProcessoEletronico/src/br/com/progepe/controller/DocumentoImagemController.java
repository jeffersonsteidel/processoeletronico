package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.DocumentoImagemDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.DocumentoImagem;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.TipoDocumento;

public class DocumentoImagemController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	DocumentoImagem documentoImagem;

	private List<DocumentoImagem> files = new ArrayList<DocumentoImagem>();
	private List<DocumentoImagem> documentoList;
	private Integer quantidadeArquivos = 0;
	private List<SelectItem> servidores = new ArrayList<SelectItem>();
	private List<SelectItem> dependentes = new ArrayList<SelectItem>();
	private List<SelectItem> conjuges = new ArrayList<SelectItem>();
	private List<SelectItem> tiposDocumentos = new ArrayList<SelectItem>();
	private Integer titularDocumento = 1;

	public DocumentoImagem getDocumentoImagem() {
		return documentoImagem;
	}

	public void setDocumentoImagem(DocumentoImagem documentoImagem) {
		this.documentoImagem = documentoImagem;
	}

	public List<DocumentoImagem> getFiles() {
		return files;
	}

	public void setFiles(List<DocumentoImagem> files) {
		this.files = files;
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

	public void abrirAdicionarDocumentos() {
		try {
			files = new ArrayList<DocumentoImagem>();
			titularDocumento = 1;
			documentoImagem = new DocumentoImagem();
			buscarServidorLogado();
			listarTiposDocumentos();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("anexarDocumentos.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregarComboTitular() throws Exception {
		if (titularDocumento == 2) {
			documentoImagem.setConjuge(new Conjuge());
			listarConjuges();
		} else if (titularDocumento == 3) {
			documentoImagem.setDependente(new Dependente());
			listarDependentes();
		} else {
			documentoImagem.setServidor(new Servidor());
			conjuges = new ArrayList<SelectItem>();
			dependentes = new ArrayList<SelectItem>();
		}
		documentoImagem.setImagem1(null);
		documentoImagem.setImagem2(null);
		documentoImagem.setImagem3(null);
		files.clear();
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

	public void abrirPesquisarDocumentos() {
		try {
			documentoList.clear();
			documentoImagem = new DocumentoImagem();
			documentoImagem.setConjuge(new Conjuge());
			documentoImagem.setServidor(new Servidor());
			documentoImagem.setDependente(new Dependente());
			documentoImagem.setTipoDocumento(new TipoDocumento());
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
		files.add(documentoImagem);
	}

	public void paint1(OutputStream stream, Object object) throws IOException {
		if(documentoImagem.getImagem1() != null)
		stream.write(documentoImagem.getImagem1());
	}

	public void paint2(OutputStream stream, Object object) throws IOException {
		if(documentoImagem.getImagem2() != null)
		stream.write(documentoImagem.getImagem2());
	}

	public void paint3(OutputStream stream, Object object) throws IOException {
		if(documentoImagem.getImagem3() != null)
		stream.write(documentoImagem.getImagem3());
	}

	public void salvar() throws Exception {
		documentoImagem.setIndValidado(false);
		if (titularDocumento.equals(1)) {
			documentoImagem.setServidor(ServidorDAO.getInstance()
					.refreshBySiape(documentoImagem.getServidor()));
			documentoImagem.setConjuge(null);
			documentoImagem.setDependente(null);
		} else if (titularDocumento.equals(2)) {
			documentoImagem.setServidor(null);
			Conjuge conjuge = (Conjuge) DAO.getInstance().refresh(
					documentoImagem.getConjuge());
			documentoImagem.setConjuge(conjuge);
			documentoImagem.setDependente(null);
		} else if (titularDocumento.equals(3)) {
			documentoImagem.setServidor(null);
			documentoImagem.setConjuge(null);
			Dependente dependente = (Dependente) DAO.getInstance().refresh(
					documentoImagem.getDependente());
			documentoImagem.setDependente(dependente);
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
			documentoImagem.setTipoDocumento(new TipoDocumento());
			files = new ArrayList<DocumentoImagem>();
		}
		buscarServidorLogado();
	}

	public void validar() {
		documentoImagem.setIndValidado(true);
		DAO.getInstance().update(documentoImagem);
	}
}
