package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.SolicitacaoDAO;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.Solicitacao;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	
	private Solicitacao solicitacao;
	private Date dataAberturaInicial;
	private Date dataAberturaFinal;
	private List<SelectItem> tiposSolicitacoes = new ArrayList<SelectItem>();
	private List<SelectItem> statusSolicitacoes = new ArrayList<SelectItem>();
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	DAO dao = new DAO();
	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	
	public Date getDataAberturaInicial() {
		return dataAberturaInicial;
	}

	public void setDataAberturaInicial(Date dataAberturaInicial) {
		this.dataAberturaInicial = dataAberturaInicial;
	}

	public Date getDataAberturaFinal() {
		return dataAberturaFinal;
	}

	public void setDataAberturaFinal(Date dataAberturaFinal) {
		this.dataAberturaFinal = dataAberturaFinal;
	}

	public List<SelectItem> getTiposSolicitacoes() {
		return tiposSolicitacoes;
	}

	public void setTiposSolicitacoes(List<SelectItem> tiposSolicitacoes) {
		this.tiposSolicitacoes = tiposSolicitacoes;
	}

	public List<SelectItem> getStatusSolicitacoes() {
		return statusSolicitacoes;
	}

	public void setStatusSolicitacoes(List<SelectItem> statusSolicitacoes) {
		this.statusSolicitacoes = statusSolicitacoes;
	}

	public void abrirPesquisarSolicitacoes() throws ParseException {
		try {
			solicitacao = new Solicitacao(); 
			solicitacao.setSolicitante(new Servidor());
			solicitacao.setStatusSolicitacao(new StatusSolicitacao());
			solicitacao.setTipoSolicitacao(new TipoSolicitacao());
			statusSolicitacoes = new ArrayList<SelectItem>();
			tiposSolicitacoes = new ArrayList<SelectItem>();
			listarStatusSolicitacoes();
			listarTiposSolicitacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("pesquisarSolicitacoes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Solicitacao> pesquisarSolicitacoes() throws ParseException {
		SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
		this.setSolicitacoes(solicitacaoDAO.listByFilter(solicitacao, dataAberturaInicial, dataAberturaFinal));
		return this.getSolicitacoes();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarStatusSolicitacoes() {
		statusSolicitacoes = new ArrayList<SelectItem>();
		List<StatusSolicitacao> statusSolicitacoesList = new ArrayList<StatusSolicitacao>();
		statusSolicitacoesList = dao.list(StatusSolicitacao.class, "descricao");
		for (StatusSolicitacao statusSolicitacao : statusSolicitacoesList) {
			statusSolicitacoes.add(new SelectItem(statusSolicitacao.getCodigo(), statusSolicitacao
					.getDescricao()));
		}
		return statusSolicitacoes;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposSolicitacoes() {
		tiposSolicitacoes = new ArrayList<SelectItem>();
		List<TipoSolicitacao> tipoSolicitacoesList = new ArrayList<TipoSolicitacao>();
		tipoSolicitacoesList = dao.list(TipoSolicitacao.class, "descricao");
		for (TipoSolicitacao tipoSolicitacao : tipoSolicitacoesList) {
			tiposSolicitacoes.add(new SelectItem(tipoSolicitacao.getCodigo(), tipoSolicitacao
					.getDescricao()));
		}
		return tiposSolicitacoes;
	}
}
