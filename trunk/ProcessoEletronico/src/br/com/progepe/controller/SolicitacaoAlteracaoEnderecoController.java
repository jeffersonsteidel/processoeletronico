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
import br.com.progepe.entity.RegimeTrabalho;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoAlteracaoEndereco;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAlteracaoEnderecoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoAlteracaoEndereco solicitacaoAlteracaoEndereco;

	public SolicitacaoAlteracaoEndereco getSolicitacaoAlteracaoEndereco() {
		return solicitacaoAlteracaoEndereco;
	}

	public void setSolicitacaoAlteracaoEndereco(
			SolicitacaoAlteracaoEndereco solicitacaoAlteracaoEndereco) {
		this.solicitacaoAlteracaoEndereco = solicitacaoAlteracaoEndereco;
	}

	public void abrirSolicitacaoAlteracaoEndereco() throws ParseException {
		try {
			solicitacaoAlteracaoEndereco = new SolicitacaoAlteracaoEndereco();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAlteracaoEndereco.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAlteracaoEndereco.setSolicitante(new Servidor());
		solicitacaoAlteracaoEndereco.getSolicitante().setRegimeTrabalho(new RegimeTrabalho());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoAlteracaoEndereco.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoAlteracaoEndereco.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoAlteracaoEndereco.getSolicitante()));
	}
	

	public void salvar() throws IOException, ParseException {
		solicitacaoAlteracaoEndereco.setDataAbertura(new Date());
		solicitacaoAlteracaoEndereco.setDataAtendimento(null);
		solicitacaoAlteracaoEndereco.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAlteracaoEndereco.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ALTERACAO_ENDERECO);
		solicitacaoAlteracaoEndereco.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAlteracaoEndereco.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		DAO.getInstance().saveOrUpdate(solicitacaoAlteracaoEndereco);
		solicitacaoAlteracaoEndereco = new SolicitacaoAlteracaoEndereco();
		buscarServidorLogado();
	}
}
