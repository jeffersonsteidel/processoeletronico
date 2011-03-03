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
import br.com.progepe.entity.SolicitacaoAlteracaoFerias;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoAlteracaoFeriasController  {

	private SolicitacaoAlteracaoFerias solicitacaoAlteracaoFerias;

	public SolicitacaoAlteracaoFerias getSolicitacaoAlteracaoFerias() {
		return solicitacaoAlteracaoFerias;
	}

	public void setSolicitacaoAlteracaoFerias(
			SolicitacaoAlteracaoFerias solicitacaoAlteracaoFerias) {
		this.solicitacaoAlteracaoFerias = solicitacaoAlteracaoFerias;
	}

	public void abrirSolicitacaoAlteracaoFerias() throws ParseException {
		try {
			solicitacaoAlteracaoFerias = new SolicitacaoAlteracaoFerias();
			solicitacaoAlteracaoFerias.setMotivo(null);
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAlteracaoFerias.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAlteracaoFerias.setSolicitante(new Servidor());

		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");

		solicitacaoAlteracaoFerias.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoAlteracaoFerias.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoAlteracaoFerias.getSolicitante()));
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoAlteracaoFerias.setDataAbertura(new Date());
		solicitacaoAlteracaoFerias.setDataAtendimento(null);
		solicitacaoAlteracaoFerias.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAlteracaoFerias.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ALTERACAO_FERIAS);
		solicitacaoAlteracaoFerias.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAlteracaoFerias.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		DAO.getInstance().saveOrUpdate(solicitacaoAlteracaoFerias);
		EnviarEmail enviarEmail = new EnviarEmail();
		enviarEmail.enviarEmailSolicitacao(solicitacaoAlteracaoFerias);
		solicitacaoAlteracaoFerias = new SolicitacaoAlteracaoFerias();
		buscarServidorLogado();
	}
}
