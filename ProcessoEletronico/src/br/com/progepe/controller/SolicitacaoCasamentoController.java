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
import br.com.progepe.entity.SolicitacaoCasamento;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoCasamentoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoCasamento solicitacaoCasamento;
	DAO dao = new DAO();

	public SolicitacaoCasamento getSolicitacaoCasamento() {
		return solicitacaoCasamento;
	}

	public void setSolicitacaoCasamento(SolicitacaoCasamento solicitacaoCasamento) {
		this.solicitacaoCasamento = solicitacaoCasamento;
	}

	public void abrirSolicitacaoCasamento() throws ParseException {
		try {
			solicitacaoCasamento = new SolicitacaoCasamento();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoCasamento.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoCasamento.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoCasamento.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoCasamento.setSolicitante(servidorDAO
				.refreshBySiape(solicitacaoCasamento.getSolicitante()));
	}
	
	public void salvar() throws IOException, ParseException {
		solicitacaoCasamento.setDataAbertura(new Date());
		solicitacaoCasamento.setDataAtendimento(null);
		solicitacaoCasamento.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoCasamento.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO);
		solicitacaoCasamento.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoCasamento.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_AGUARDANDO);
		dao.saveOrUpdate(solicitacaoCasamento);
		solicitacaoCasamento = new SolicitacaoCasamento();
		buscarServidorLogado();
	}
	
	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoCasamento.setCertidaoCasamento(item.getData());
	}

	public void paint(OutputStream stream, Object object) throws IOException {
			stream.write(this.solicitacaoCasamento.getCertidaoCasamento());
	}
}
