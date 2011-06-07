package br.com.progepe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.RemocaoDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Remocao;
import br.com.progepe.entity.Servidor;

public class RemocaoController {

	private Remocao remocao;
	private List<Remocao> remocaoList;
	private List<SelectItem> lotacoes = new ArrayList<SelectItem>();

	public Remocao getRemocao() {
		return remocao;
	}

	public void setRemocao(Remocao remocao) {
		this.remocao = remocao;
	}

	public List<SelectItem> getLotacoes() {
		return lotacoes;
	}

	public void setLotacoes(List<SelectItem> lotacoes) {
		this.lotacoes = lotacoes;
	}

	public List<Remocao> getRemocaoList() {
		return remocaoList;
	}

	public void setRemocaoList(List<Remocao> remocaoList) {
		this.remocaoList = remocaoList;
	}

	public void abrirCadastrarRemocao() throws ParseException {
		try {
			remocao = new Remocao();
			remocao.setServidor(new Servidor());
			remocao.setLotacao(new Lotacao());
			listarLotacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("cadastrarRemocao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void carregar() throws IOException, ParseException {
		remocao = (Remocao) DAO.getInstance().refresh(remocao);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarRemocao.jsp");
	}

	public void buscarServidor() throws IOException, ParseException {
		remocao.setServidor(ServidorDAO.getInstance().refreshBySiape(
				remocao.getServidor()));
		if (remocao.getServidor() == null) {
			remocao.setServidor(new Servidor());
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Siape inválido!",
					"Siape inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarLotacoes() {
		lotacoes = new ArrayList<SelectItem>();
		List<Lotacao> lotacaoList = new ArrayList<Lotacao>();
		lotacaoList = DAO.getInstance().list(Lotacao.class, "descricao");
		for (Lotacao item : lotacaoList) {
			lotacoes.add(new SelectItem(item.getCodigo(), item.getDescricao()));
		}
		return lotacoes;
	}

	public void salvar() throws IOException, ParseException {
		DAO.getInstance().saveOrUpdate(remocao);
		remocao = new Remocao();
	}

	public void abrirListarRemocoes() throws IOException {
		remocaoList = new ArrayList<Remocao>();
		remocaoList.clear();
		remocao = new Remocao();
		remocao.setServidor(new Servidor());
		remocao.setLotacao(new Lotacao());
		listarLotacoes();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("pesquisarRemocoes.jsp");
	}
	
	
	public List<Remocao> pesquisar(){
		remocaoList = RemocaoDAO.getInstance().listByFilter(remocao);
		return remocaoList;
	}
 	
	

}
