package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.GrauParentesco;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoObito;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoObitoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoObito solicitacaoObito;
	private ArrayList<SolicitacaoObito> files = new ArrayList<SolicitacaoObito>();
	private List<SelectItem> grausParentescos = new ArrayList<SelectItem>();
	
	DAO dao = new DAO();

	public SolicitacaoObito getSolicitacaoObito() {
		return solicitacaoObito;
	}

	public void setSolicitacaoObito(SolicitacaoObito solicitacaoObito) {
		this.solicitacaoObito = solicitacaoObito;
	}

	public List<SelectItem> getGrausParentescos() {
		return grausParentescos;
	}

	public void setGrausParentescos(List<SelectItem> grausParentescos) {
		this.grausParentescos = grausParentescos;
	}
	
	public ArrayList<SolicitacaoObito> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<SolicitacaoObito> files) {
		this.files = files;
	}

	public void abrirSolicitacaoObito() throws ParseException {
		try {
			solicitacaoObito = new SolicitacaoObito();
			solicitacaoObito.setGrauParentesco(new GrauParentesco());
			listarGrauParentesco();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoObito.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoObito.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoObito.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoObito.setSolicitante(servidorDAO
				.refreshBySiape(solicitacaoObito.getSolicitante()));
	}
	
	public void salvar() throws IOException, ParseException {
		solicitacaoObito.setDataAbertura(new Date());
		solicitacaoObito.setDataAtendimento(null);
		solicitacaoObito.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoObito.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_OBITO);
		solicitacaoObito.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoObito.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		dao.saveOrUpdate(solicitacaoObito);
		solicitacaoObito = new SolicitacaoObito();
		files = new ArrayList<SolicitacaoObito>();
		buscarServidorLogado();
	}
	
	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(getFiles().get((Integer) object).getCertidaoObito());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoObito.setCertidaoObito(item.getData());
		files.add(solicitacaoObito);
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
}
