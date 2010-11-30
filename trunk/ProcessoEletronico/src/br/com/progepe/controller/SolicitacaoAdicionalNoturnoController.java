package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.AdicionalNoturno;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoAdicionalNoturno;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAdicionalNoturnoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private AdicionalNoturno adicionalNoturno;
	private List<SelectItem> lotacoes = new ArrayList<SelectItem>();
	private List<SelectItem> servidoresCampus = new ArrayList<SelectItem>();
	
	private SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno;
	
	public AdicionalNoturno getSolicitacaoAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setSolicitacaoAdicionalNoturno(
			AdicionalNoturno adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}
	public List<SelectItem> getLotacoes() {
		return lotacoes;
	}

	public void setLotacoes(List<SelectItem> lotacoes) {
		this.lotacoes = lotacoes;
	}
	
	public List<SelectItem> getServidoresCampus() {
		return servidoresCampus;
	}

	public void setServidoresCampus(List<SelectItem> servidoresCampus) {
		this.servidoresCampus = servidoresCampus;
	}
	
	public AdicionalNoturno getAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setAdicionalNoturno(AdicionalNoturno adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}

	public void setSolicitacaoAdicionalNoturno(
			SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno) {
		this.solicitacaoAdicionalNoturno = solicitacaoAdicionalNoturno;
	}

	public void abrirSolicitacaoAdicionalNoturno() throws ParseException {
		try {
			solicitacaoAdicionalNoturno.getAdicionais().clear();
			adicionalNoturno = new AdicionalNoturno();
			buscarServidorLogado();
			listarLotacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAdicionalNoturno.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		adicionalNoturno.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		adicionalNoturno.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		adicionalNoturno.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(adicionalNoturno.getSolicitante()));
	}
	
	public void adicionarAdicional(){
		solicitacaoAdicionalNoturno.getAdicionais().add(adicionalNoturno);
	}

	public void salvar() throws IOException, ParseException {
		adicionalNoturno.setDataAbertura(new Date());
		adicionalNoturno.setDataAtendimento(null);
		adicionalNoturno.setTipoSolicitacao(new TipoSolicitacao());
		adicionalNoturno.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO);
		adicionalNoturno
				.setStatusSolicitacao(new StatusSolicitacao());
		adicionalNoturno.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		DAO.getInstance().saveOrUpdate(adicionalNoturno);
		adicionalNoturno = new AdicionalNoturno();
		buscarServidorLogado();
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarLotacoes() {
		lotacoes = new ArrayList<SelectItem>();
		List<Lotacao> lotacaoList = new ArrayList<Lotacao>();
		lotacaoList = DAO.getInstance().list(Lotacao.class, "descricao");
		for (Lotacao lotacao : lotacaoList) {
			lotacoes.add(new SelectItem(lotacao.getCodigo(), lotacao
					.getDescricao()));
		}
		return lotacoes;
	}
	
	public List<SelectItem> listarServidoresCampus() {
		servidoresCampus = new ArrayList<SelectItem>();
		List<Servidor> servidorList = new ArrayList<Servidor>();
		servidorList = ServidorDAO.getInstance().listByCampus(adicionalNoturno.getLotacao());
		
		for (Servidor item : servidorList) {
			servidoresCampus.add(new SelectItem(item.getCodigo(), item.getNome()));
		}
		return servidoresCampus;
	}
}
