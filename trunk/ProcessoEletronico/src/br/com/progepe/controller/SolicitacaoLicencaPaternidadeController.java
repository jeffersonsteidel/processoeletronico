package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoLicencaPaternidade;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoLicencaPaternidadeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	SolicitacaoLicencaPaternidade solicitacaoLicencaPaternidade;
	private ArrayList<SolicitacaoLicencaPaternidade> files = new ArrayList<SolicitacaoLicencaPaternidade>();
	DAO dao = new DAO();

	public SolicitacaoLicencaPaternidade getSolicitacaoLicencaPaternidade() {
		return solicitacaoLicencaPaternidade;
	}

	public void setSolicitacaoLicencaPaternidade(
			SolicitacaoLicencaPaternidade solicitacaoLicencaPaternidade) {
		this.solicitacaoLicencaPaternidade = solicitacaoLicencaPaternidade;
	}

	public ArrayList<SolicitacaoLicencaPaternidade> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<SolicitacaoLicencaPaternidade> files) {
		this.files = files;
	}

	public void abrirSolicitacaoPaternidade() throws ParseException {
		try {
			solicitacaoLicencaPaternidade = new SolicitacaoLicencaPaternidade();
			files.clear();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoLicencaPaternidade.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoLicencaPaternidade.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoLicencaPaternidade.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoLicencaPaternidade
				.setSolicitante(servidorDAO
						.refreshBySiape(solicitacaoLicencaPaternidade
								.getSolicitante()));
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(getFiles().get((Integer)object).getCertidaoNascimento());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoLicencaPaternidade.setCertidaoNascimento(item.getData());
		files.add(solicitacaoLicencaPaternidade);
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoLicencaPaternidade.setDataAbertura(new Date());
		solicitacaoLicencaPaternidade.setDataAtendimento(null);
		solicitacaoLicencaPaternidade.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoLicencaPaternidade.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE);
		solicitacaoLicencaPaternidade
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoLicencaPaternidade.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		dao.saveOrUpdate(solicitacaoLicencaPaternidade);
		solicitacaoLicencaPaternidade = new SolicitacaoLicencaPaternidade();
		files = new ArrayList<SolicitacaoLicencaPaternidade>();
		buscarServidorLogado();
	}
}
