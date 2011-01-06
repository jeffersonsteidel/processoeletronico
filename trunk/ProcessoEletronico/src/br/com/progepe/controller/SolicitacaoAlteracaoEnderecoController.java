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
import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.RegimeTrabalho;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoAlteracaoEndereco;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAlteracaoEnderecoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoAlteracaoEndereco solicitacaoAlteracaoEndereco;
	
	private List<SelectItem> cidades = new ArrayList<SelectItem>();
	private List<SelectItem> estados = new ArrayList<SelectItem>();

	public SolicitacaoAlteracaoEndereco getSolicitacaoAlteracaoEndereco() {
		return solicitacaoAlteracaoEndereco;
	}

	public void setSolicitacaoAlteracaoEndereco(
			SolicitacaoAlteracaoEndereco solicitacaoAlteracaoEndereco) {
		this.solicitacaoAlteracaoEndereco = solicitacaoAlteracaoEndereco;
	}
	
	public List<SelectItem> getCidades() {
		return cidades;
	}

	public void setCidades(List<SelectItem> cidades) {
		this.cidades = cidades;
	}

	public List<SelectItem> getEstados() {
		return estados;
	}

	public void setEstados(List<SelectItem> estados) {
		this.estados = estados;
	}

	public void abrirSolicitacaoAlteracaoEndereco() throws ParseException {
		try {
			solicitacaoAlteracaoEndereco = new SolicitacaoAlteracaoEndereco();
			solicitacaoAlteracaoEndereco.setNovaCidade(new Cidade());
			solicitacaoAlteracaoEndereco.getNovaCidade().setEstado(new Estado());
			listarEstados();
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
		solicitacaoAlteracaoEndereco.setNovaCidade(new Cidade());
		solicitacaoAlteracaoEndereco.getNovaCidade().setEstado(new Estado());
		buscarServidorLogado();
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarEstados() {
		estados = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = DAO.getInstance().list(Estado.class, "descricao");
		for (Estado estado : estadoList) {
			estados.add(new SelectItem(estado.getCodigo(), estado
					.getDescricao()));
		}
		return estados;
	}

	public List<SelectItem> listarCidades() {
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = CidadeDAO.getInstance().listByEstado(solicitacaoAlteracaoEndereco.getNovaCidade().getEstado());
		for (Cidade cidade : cidadeList) {
			cidades.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidades;
	}
}
