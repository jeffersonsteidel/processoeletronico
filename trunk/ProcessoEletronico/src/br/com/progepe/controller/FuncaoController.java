package br.com.progepe.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Funcao;
import br.com.progepe.entity.TipoFuncao;

public class FuncaoController implements Serializable {

	private static final long serialVersionUID = 8505987470598069907L;

	private Funcao funcao;
	private List<SelectItem> tipoFuncoes = new ArrayList<SelectItem>();

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<SelectItem> getTipoFuncoes() {
		return tipoFuncoes;
	}

	public void setTipoFuncoes(List<SelectItem> tipoFuncoes) {
		this.tipoFuncoes = tipoFuncoes;
	}

	public void abrirNovaFuncao() throws Exception {
		funcao = new Funcao();
		funcao.setTipoFuncao(new TipoFuncao());
		listarTipoFuncoes();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("novaFuncao.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTipoFuncoes() {
		tipoFuncoes = new ArrayList<SelectItem>();
		List<TipoFuncao> tipoFuncaoList = new ArrayList<TipoFuncao>();
		tipoFuncaoList = DAO.getInstance().list(TipoFuncao.class, "codigo");
		for (TipoFuncao item : tipoFuncaoList) {
			tipoFuncoes.add(new SelectItem(item.getCodigo(), item.getSigla()));
		}
		return tipoFuncoes;
	}

	public void salvarNovaFuncao() {
		DAO.getInstance().saveOrUpdate(funcao);
		funcao = new Funcao();
		funcao.setTipoFuncao(new TipoFuncao());
	}

}
