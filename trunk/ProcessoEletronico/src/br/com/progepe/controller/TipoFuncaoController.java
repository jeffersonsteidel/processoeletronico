package br.com.progepe.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.TipoFuncao;

public class TipoFuncaoController {

	private TipoFuncao tipoFuncao;
	private List<TipoFuncao> tipoFuncaoList;

	public TipoFuncao getTipoFuncao() {
		return tipoFuncao;
	}

	public void setTipoFuncao(TipoFuncao tipoFuncao) {
		this.tipoFuncao = tipoFuncao;
	}

	public List<TipoFuncao> getTipoFuncaoList() {
		return tipoFuncaoList;
	}

	public void setTipoFuncaoList(List<TipoFuncao> tipoFuncaoList) {
		this.tipoFuncaoList = tipoFuncaoList;
	}

	DAO dao = new DAO();

	public void cadastrar() throws IOException {
		tipoFuncao = new TipoFuncao();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarTipoFuncao.jsp");
	}

	public void salvar() {
		dao.save(tipoFuncao);
		tipoFuncao = new TipoFuncao();
	}

	public void carregar() throws IOException {
		dao.refresh(tipoFuncao);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarTipoFuncao.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<TipoFuncao> listar() throws IOException {
		tipoFuncao = new TipoFuncao();
		this.setTipoFuncaoList(dao.list(tipoFuncao.getClass(), "descricao"));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarTipoFuncao.jsp");
		return this.getTipoFuncaoList();
	}

}
