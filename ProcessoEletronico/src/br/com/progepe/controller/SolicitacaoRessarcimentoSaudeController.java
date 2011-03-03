package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.RessarcimentoSaude;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoRessarcimentoSaude;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoRessarcimentoSaudeController  {

	private SolicitacaoRessarcimentoSaude solicitacaoRessarcimentoSaude;

	public SolicitacaoRessarcimentoSaude getSolicitacaoRessarcimentoSaude() {
		return solicitacaoRessarcimentoSaude;
	}

	public void setSolicitacaoRessarcimentoSaude(
			SolicitacaoRessarcimentoSaude solicitacaoRessarcimentoSaude) {
		this.solicitacaoRessarcimentoSaude = solicitacaoRessarcimentoSaude;
	}

	public void abrirSolicitacaoRessarcimentoSaude() throws ParseException {
		try {
			solicitacaoRessarcimentoSaude = new SolicitacaoRessarcimentoSaude();
			solicitacaoRessarcimentoSaude
					.setRessarcimentoSaude(new RessarcimentoSaude());
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoRessarcimentoSaude.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoRessarcimentoSaude.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoRessarcimentoSaude.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoRessarcimentoSaude
				.setSolicitante(ServidorDAO.getInstance().refreshBySiape(
						solicitacaoRessarcimentoSaude.getSolicitante()));
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoRessarcimentoSaude.setDataAbertura(new Date());
		solicitacaoRessarcimentoSaude.setDataAtendimento(null);
		solicitacaoRessarcimentoSaude.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoRessarcimentoSaude.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_RESSARCIMENTO_SAUDE);
		solicitacaoRessarcimentoSaude
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoRessarcimentoSaude.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		DAO.getInstance().save(solicitacaoRessarcimentoSaude);
		EnviarEmail enviarEmail = new EnviarEmail();
		enviarEmail.enviarEmailSolicitacao(solicitacaoRessarcimentoSaude);
		solicitacaoRessarcimentoSaude = new SolicitacaoRessarcimentoSaude();
		solicitacaoRessarcimentoSaude
				.setRessarcimentoSaude(new RessarcimentoSaude());
		buscarServidorLogado();
	}
	
	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoRessarcimentoSaude.setComprovante(item.getData());
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		if (solicitacaoRessarcimentoSaude.getComprovante() != null)
			stream.write(solicitacaoRessarcimentoSaude.getComprovante());
	}
}
