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

	private SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno;
	private List<SelectItem> lotacoes = new ArrayList<SelectItem>();
	private List<SelectItem> servidoresCampus = new ArrayList<SelectItem>();
	private AdicionalNoturno adicionalNoturno;
	
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
	
	public SolicitacaoAdicionalNoturno getSolicitacaoAdicionalNoturno() {
		return solicitacaoAdicionalNoturno;
	}

	public void setSolicitacaoAdicionalNoturno(
			SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno) {
		this.solicitacaoAdicionalNoturno = solicitacaoAdicionalNoturno;
	}
	
	public AdicionalNoturno getAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setAdicionalNoturno(AdicionalNoturno adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}

	public void abrirSolicitacaoAdicionalNoturno() throws ParseException {
		try {
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			adicionalNoturno = new AdicionalNoturno();
		    adicionalNoturno.setServidor(new Servidor());
			adicionalNoturno.setSolicitacaoAdicionalNoturno(new SolicitacaoAdicionalNoturno());
			adicionalNoturno.getSolicitacaoAdicionalNoturno().setLotacao(new Lotacao());
			buscarServidorLogado();
			listarLotacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAdicionalNoturnoTecnico.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAdicionalNoturno.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoAdicionalNoturno.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoAdicionalNoturno.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoAdicionalNoturno.getSolicitante()));
	}
	
	public void adicionarAdicional(){
		solicitacaoAdicionalNoturno.getAdicionais().add(adicionalNoturno);
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoAdicionalNoturno.setDataAbertura(new Date());
		solicitacaoAdicionalNoturno.setDataAtendimento(null);
		solicitacaoAdicionalNoturno.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAdicionalNoturno.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO);
		solicitacaoAdicionalNoturno
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAdicionalNoturno.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		DAO.getInstance().saveOrUpdate(solicitacaoAdicionalNoturno);
		solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
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
		servidorList = ServidorDAO.getInstance().listByCampus(solicitacaoAdicionalNoturno.getLotacao());
		
		for (Servidor item : servidorList) {
			servidoresCampus.add(new SelectItem(item.getCodigo(), item.getNome()));
		}
		return servidoresCampus;
	}
}
