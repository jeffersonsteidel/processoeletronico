package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Lotacao;

public class LotacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Lotacao lotacao;
	private List<Lotacao> lotacaoList;
	private List<SelectItem> estados = new ArrayList<SelectItem>();
	private List<SelectItem> cidades = new ArrayList<SelectItem>();
	private Boolean indNovo;


	public Lotacao getLotacao() {
		return lotacao;
	}

	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}

	public List<Lotacao> getLotacaoList() {
		return lotacaoList;
	}

	public void setLotacaoList(List<Lotacao> lotacaoList) {
		this.lotacaoList = lotacaoList;
	}


	public Boolean getIndNovo() {
		return indNovo;
	}

	public void setIndNovo(Boolean indNovo) {
		this.indNovo = indNovo;
	}


	@SuppressWarnings("unchecked")
	public void abrirListarLotacoes() throws ParseException {
		try {
			lotacao = new Lotacao();
			lotacao.setEndereco(new Endereco());
			lotacao.getEndereco().setCidade(new Cidade());
			lotacao.getEndereco().getCidade().setEstado(new Estado());		
			lotacaoList = new ArrayList<Lotacao>();
			lotacaoList = (List<Lotacao>) DAO.getInstance().list(Lotacao.class, "codigo");
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarLotacoes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void abrirCadastrarLotacao() throws ParseException {
		try {
			lotacao = new Lotacao();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("cadastrarLotacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void carregar() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		lotacao = (Lotacao) context.getExternalContext().getRequestMap()
				.get("list");
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarLotacao.jsp");
	}

	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarEstados() {
		estados = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = DAO.getInstance().list(Estado.class, "descricao");
		for (Estado estado : estadoList) {
			estados.add(new SelectItem(estado.getCodigo(), estado
				.getUf()));
		}
		return estados;
	}
	
	public List<SelectItem> listarCidades() {
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = CidadeDAO.getInstance().listByEstado(lotacao.getEndereco().getCidade()
				.getEstado());
		for (Cidade cidade : cidadeList) {
			cidades.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidades;
	}
	
	
	
	public void salvar() {
		if (indNovo) {
			DAO.getInstance().save(lotacao);
		} else {
			DAO.getInstance().update(lotacao);
		}
		lotacao = new Lotacao();
		//lotacao.setClasse(new Classe());
	}

	

}
