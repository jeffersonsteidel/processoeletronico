package br.com.progepe.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.FuncaoDAO;
import br.com.progepe.entity.Funcao;

public class FuncaoController {

	private Funcao funcao;
	private List<Funcao> funcaoList;

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Funcao> getFuncaoList() {
		return funcaoList;
	}

	public void setFuncaoList(List<Funcao> funcaoList) {
		this.funcaoList = funcaoList;
	}

	public void cadastrarFuncao() throws IOException {
		funcao = new Funcao();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarFuncao.jsp");
	}

	public void salvar() {
		FuncaoDAO funcaoDAO = new FuncaoDAO();
		funcaoDAO.save(funcao);
		funcao = new Funcao();
	}

	public void carregarFuncao() throws IOException {
		FuncaoDAO funcaoDAO = new FuncaoDAO();
		funcaoDAO.refresh(funcao);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarFuncao.jsp");
	}

	public List<Funcao> listarFuncoes() throws IOException {
		funcao = new Funcao();
		FuncaoDAO funcaoDAO = new FuncaoDAO();
		this.setFuncaoList(funcaoDAO.list());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarFuncoes.jsp");
		return this.getFuncaoList();
	}
}
