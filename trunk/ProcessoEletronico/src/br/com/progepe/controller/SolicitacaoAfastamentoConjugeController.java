package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.faces.context.FacesContext;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoAfastamentoConjuge;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAfastamentoConjugeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoAfastamentoConjuge solicitacaoAfastamentoConjuge;
	DAO dao = new DAO();

	public SolicitacaoAfastamentoConjuge getSolicitacaoAfastamentoConjuge() {
		return solicitacaoAfastamentoConjuge;
	}

	public void setSolicitacaoAfastamentoConjuge(
			SolicitacaoAfastamentoConjuge solicitacaoAfastamentoConjuge) {
		this.solicitacaoAfastamentoConjuge = solicitacaoAfastamentoConjuge;
	}

	public void abrirSolicitacaoAfastamentoConjuge() throws ParseException {
		try {
			solicitacaoAfastamentoConjuge = new SolicitacaoAfastamentoConjuge();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAfastamentoConjuge.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAfastamentoConjuge.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoAfastamentoConjuge.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoAfastamentoConjuge.setSolicitante(servidorDAO
				.refreshBySiape(solicitacaoAfastamentoConjuge.getSolicitante()));
	}
	
	public void salvar() throws IOException, ParseException {
		solicitacaoAfastamentoConjuge.setDataAbertura(new Date());
		solicitacaoAfastamentoConjuge.setDataAtendimento(null);
		solicitacaoAfastamentoConjuge.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAfastamentoConjuge.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_AFASTAMENTO_CONJUGE);
		solicitacaoAfastamentoConjuge.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAfastamentoConjuge.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		dao.saveOrUpdate(solicitacaoAfastamentoConjuge);
		solicitacaoAfastamentoConjuge = new SolicitacaoAfastamentoConjuge();
		buscarServidorLogado();
	}
}
