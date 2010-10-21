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
import br.com.progepe.entity.SolicitacaoAlimentacao;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAlimentacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoAlimentacao solicitacaoAlimentacao;
	DAO dao = new DAO();

	public SolicitacaoAlimentacao getSolicitacaoAlimentacao() {
		return solicitacaoAlimentacao;
	}

	public void setSolicitacaoAlimentacao(
			SolicitacaoAlimentacao solicitacaoAlimentacao) {
		this.solicitacaoAlimentacao = solicitacaoAlimentacao;
	}

	public void abrirSolicitacaoAlimentacao() throws ParseException {
		try {
			solicitacaoAlimentacao = new SolicitacaoAlimentacao();
			buscarServidorLogado();
			solicitacaoAlimentacao.setIndAlimentacao(false);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAlimentacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public void isPoupanca() {
	// if
	// ((Constantes.CAIXA_ECONOMICA_FEDERAL).equals(solicitacaoContaBancaria.getNovoBanco().getCodigo()))
	// {
	// indPoupanca = true;
	// } else {
	// indPoupanca = false;
	// }
	// }

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAlimentacao.setSolicitante(new Servidor());

		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");

		solicitacaoAlimentacao.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoAlimentacao.setSolicitante(servidorDAO
				.refreshBySiape(solicitacaoAlimentacao.getSolicitante()));
	}

	public void salvar() {
		solicitacaoAlimentacao.setDataAbertura(new Date());
		solicitacaoAlimentacao.setDataAtendimento(null);
	//	solicitacaoAlimentacao.setIndAlimentacao(new Boolean(false));    // n�o funciona sem o bot�o =P
		solicitacaoAlimentacao.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAlimentacao.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_AUXILIO_ALIMENTACAO);
		solicitacaoAlimentacao.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAlimentacao.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_AGUARDANDO);
		dao.saveOrUpdate(solicitacaoAlimentacao);
	}
}