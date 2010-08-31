package br.com.progepe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.EstadoDAO;
import br.com.progepe.dao.LotacaoDAO;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Telefone;

public class LotacaoController {

	private Lotacao lotacao;
	private List<SelectItem> estados;
	private List<SelectItem> cidades;
	private List<Lotacao> lotacaoList;

	public Lotacao getLotacao() {
		return lotacao;
	}

	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}

	public List<SelectItem> getEstados() {
		return estados;
	}

	public void setEstados(List<SelectItem> estados) {
		this.estados = estados;
	}

	public List<SelectItem> getCidades() {
		return cidades;
	}

	public void setCidades(List<SelectItem> cidades) {
		this.cidades = cidades;
	}

	public List<Lotacao> getLotacaoList() {
		return lotacaoList;
	}

	public void setLotacaoList(List<Lotacao> lotacaoList) {
		this.lotacaoList = lotacaoList;
	}

	public void cadastrar() throws IOException {
		lotacao = new Lotacao();
		lotacao.setTelefone(new Telefone());
		lotacao.setEndereco(new Endereco());
		lotacao.getEndereco().setCidade(new Cidade());
		lotacao.getEndereco().getCidade().setEstado(new Estado());
		cidades = new ArrayList<SelectItem>();
		estados = new ArrayList<SelectItem>();
		listarEstados();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarLotacao.jsp");
	}

	public void salvar() {
		LotacaoDAO lotacaoDAO = new LotacaoDAO();
		lotacaoDAO.save(lotacao);
		lotacao = new Lotacao();
	}

	public void carregar() throws IOException {
		LotacaoDAO lotacaoDAO = new LotacaoDAO();
		lotacaoDAO.refresh(lotacao);
		listarEstados();
		listarCidades();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarLotacao.jsp");
	}

	public List<Lotacao> listar() throws IOException {
		lotacao = new Lotacao();
		lotacao.setEndereco(new Endereco());
		lotacao.getEndereco().setCidade(new Cidade());
		lotacao.getEndereco().getCidade().setEstado(new Estado());
		LotacaoDAO lotacaoDAO = new LotacaoDAO();
		this.setLotacaoList(lotacaoDAO.list());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarLotacoes.jsp");
		return this.getLotacaoList();
	}

	public List<SelectItem> listarEstados() {
		EstadoDAO estadoDAO = new EstadoDAO();
		estados = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = estadoDAO.list();
		for (Estado estado : estadoList) {
			estados.add(new SelectItem(estado.getCodigo(), estado
					.getDescricao()));
		}
		return estados;
	}

	public List<SelectItem> listarCidades() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = cidadeDAO.listByEstado(lotacao.getEndereco().getCidade()
				.getEstado());
		for (Cidade cidade : cidadeList) {
			cidades.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidades;
	}
}
