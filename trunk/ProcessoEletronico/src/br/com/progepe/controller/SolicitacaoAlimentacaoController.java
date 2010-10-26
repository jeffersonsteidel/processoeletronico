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
import br.com.progepe.entity.SolicitacaoAlimentacao;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAlimentacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoAlimentacao solicitacaoAlimentacao;
	private Boolean indCancelarAlimentacao=false;
	private Boolean indIncluirAlimentacao=true;
	DAO dao = new DAO();

	public SolicitacaoAlimentacao getSolicitacaoAlimentacao() {
		return solicitacaoAlimentacao;
	}

	public void setSolicitacaoAlimentacao(
			SolicitacaoAlimentacao solicitacaoAlimentacao) {
		this.solicitacaoAlimentacao = solicitacaoAlimentacao;
	}

	public Boolean getIndCancelarAlimentacao() {
		return indCancelarAlimentacao;
	}

	public void setIndCancelarAlimentacao(Boolean indCancelarAlimentacao) {
		this.indCancelarAlimentacao = indCancelarAlimentacao;
	}

	public Boolean getIndIncluirAlimentacao() {
		return indIncluirAlimentacao;
	}

	public void setIndIncluirAlimentacao(Boolean indIncluirAlimentacao) {
		this.indIncluirAlimentacao = indIncluirAlimentacao;
	}

	public void abrirSolicitacaoAlimentacao() throws ParseException {
		try {
			solicitacaoAlimentacao = new SolicitacaoAlimentacao();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAlimentacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAlimentacao.setSolicitante(new Servidor());
		solicitacaoAlimentacao.getSolicitante().setRegimeTrabalho(new RegimeTrabalho());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoAlimentacao.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoAlimentacao.setSolicitante(servidorDAO
				.refreshBySiape(solicitacaoAlimentacao.getSolicitante()));
	}
	
	public void isAlimentacao(){
		if(indCancelarAlimentacao){
			indIncluirAlimentacao = true;
			indCancelarAlimentacao = false;
			solicitacaoAlimentacao.setIndAlimentacao(false);
		}else{
			indIncluirAlimentacao = false;
			indCancelarAlimentacao = true;
			solicitacaoAlimentacao.setIndAlimentacao(true);
		}
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoAlimentacao.setDataAbertura(new Date());
		solicitacaoAlimentacao.setDataAtendimento(null);
		solicitacaoAlimentacao.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAlimentacao.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_AUXILIO_ALIMENTACAO);
		solicitacaoAlimentacao.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAlimentacao.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		dao.saveOrUpdate(solicitacaoAlimentacao);
		solicitacaoAlimentacao = new SolicitacaoAlimentacao();
		buscarServidorLogado();
	}
}
