package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoAuxilioPaternidade;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAuxilioPaternidadeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	SolicitacaoAuxilioPaternidade solicitacaoAuxilioPaternidade;
	DAO dao = new DAO();

	public SolicitacaoAuxilioPaternidade getSolicitacaoAuxilioPaternidade() {
		return solicitacaoAuxilioPaternidade;
	}

	public void setSolicitacaoAuxilioPaternidade(
			SolicitacaoAuxilioPaternidade solicitacaoAuxilioPaternidade) {
		this.solicitacaoAuxilioPaternidade = solicitacaoAuxilioPaternidade;
	}

	public void abrirSolicitacaoPaternidade() throws ParseException {
		try {
			solicitacaoAuxilioPaternidade = new SolicitacaoAuxilioPaternidade();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAuxilioPaternidade.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAuxilioPaternidade.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoAuxilioPaternidade.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoAuxilioPaternidade
				.setSolicitante(servidorDAO
						.refreshBySiape(solicitacaoAuxilioPaternidade
								.getSolicitante()));
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoAuxilioPaternidade.setCertidaoNascimento(item.getData());
	}

	public void paint(OutputStream stream, Object object) throws IOException {
			stream.write(this.solicitacaoAuxilioPaternidade.getCertidaoNascimento());
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoAuxilioPaternidade.setDataAbertura(new Date());
		solicitacaoAuxilioPaternidade.setDataAtendimento(null);
		solicitacaoAuxilioPaternidade.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAuxilioPaternidade.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_AUXILIO_PATERNIDADE);
		solicitacaoAuxilioPaternidade
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAuxilioPaternidade.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_AGUARDANDO);
		dao.saveOrUpdate(solicitacaoAuxilioPaternidade);
		solicitacaoAuxilioPaternidade = new SolicitacaoAuxilioPaternidade();
		buscarServidorLogado();
	}
}
