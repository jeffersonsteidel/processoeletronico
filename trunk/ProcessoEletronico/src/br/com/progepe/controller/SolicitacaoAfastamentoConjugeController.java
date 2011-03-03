package br.com.progepe.controller;

import java.io.IOException;
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
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoAfastamentoConjugeController  {

	private SolicitacaoAfastamentoConjuge solicitacaoAfastamentoConjuge;
	private Boolean desabilitaBotao = true;

	public SolicitacaoAfastamentoConjuge getSolicitacaoAfastamentoConjuge() {
		return solicitacaoAfastamentoConjuge;
	}

	public void setSolicitacaoAfastamentoConjuge(
			SolicitacaoAfastamentoConjuge solicitacaoAfastamentoConjuge) {
		this.solicitacaoAfastamentoConjuge = solicitacaoAfastamentoConjuge;
	}

	public Boolean getDesabilitaBotao() {
		return desabilitaBotao;
	}

	public void setDesabilitaBotao(Boolean desabilitaBotao) {
		this.desabilitaBotao = desabilitaBotao;
	}

	public void abrirSolicitacaoAfastamentoConjuge() throws ParseException {
		try {
		    desabilitaBotao = false;
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
		solicitacaoAfastamentoConjuge.setSolicitante(ServidorDAO.getInstance()
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
		DAO.getInstance().saveOrUpdate(solicitacaoAfastamentoConjuge);
		 desabilitaBotao = true;
		EnviarEmail enviarEmail = new EnviarEmail();
		enviarEmail.enviarEmailSolicitacao(solicitacaoAfastamentoConjuge);
		solicitacaoAfastamentoConjuge = new SolicitacaoAfastamentoConjuge();
		buscarServidorLogado();
	}
}
