package br.com.progepe.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Funcao;

public class FuncaoController {

	private Funcao funcao;
	private List<Funcao> funcaoList;
	DAO dao = new DAO();

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
		dao.save(funcao);
		funcao = new Funcao();
	}

	public void carregarFuncao() throws IOException {
		dao.refresh(funcao.getCodigo());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarFuncao.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<Funcao> listarFuncoes() throws IOException {
		funcao = new Funcao();
		this.setFuncaoList(dao.list(Funcao.class, "descricao"));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarFuncoes.jsp");
		return this.getFuncaoList();
	}
}
