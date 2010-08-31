package br.com.progepe.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.TipoFuncaoDAO;
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

	public void cadastrarTipoFuncao() throws IOException {
		tipoFuncao = new TipoFuncao();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarTipoFuncao.jsp");
	}

	public void salvar() {
		TipoFuncaoDAO tipoFuncaoDAO = new TipoFuncaoDAO();
		tipoFuncaoDAO.save(tipoFuncao);
		tipoFuncao = new TipoFuncao();
	}

	public void carregarTipoFuncao() throws IOException {
		TipoFuncaoDAO tipoFuncaoDAO = new TipoFuncaoDAO();
		tipoFuncaoDAO.refresh(tipoFuncao);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarTipo.jsp");
	}

	public List<TipoFuncao> listarTipoFuncoes() throws IOException {
		tipoFuncao = new TipoFuncao();
		TipoFuncaoDAO tipoFuncaoDAO = new TipoFuncaoDAO();
		this.setTipoFuncaoList(tipoFuncaoDAO.list());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarTipoFuncoes.jsp");
		return this.getTipoFuncaoList();
	}

}
