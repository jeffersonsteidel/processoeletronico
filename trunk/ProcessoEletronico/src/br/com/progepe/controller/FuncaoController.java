package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.FuncaoServidorDAO;
import br.com.progepe.entity.Funcao;
import br.com.progepe.entity.FuncaoServidor;
import br.com.progepe.entity.TipoFuncao;

public class FuncaoController implements Serializable {

	private static final long serialVersionUID = 8505987470598069907L;

	private Funcao funcao;
	private List<SelectItem> tipoFuncoes = new ArrayList<SelectItem>();
	private List<SelectItem> funcoes = new ArrayList<SelectItem>();
	private List<Funcao> funcoesList = new ArrayList<Funcao>();
	private Boolean desabilitarCampos;

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

	public List<Funcao> getFuncoesList() {
		return funcoesList;
	}

	public void setFuncoesList(List<Funcao> funcoesList) {
		this.funcoesList = funcoesList;
	}
	
	public List<SelectItem> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<SelectItem> funcoes) {
		this.funcoes = funcoes;
	}

	public Boolean getDesabilitarCampos() {
		return desabilitarCampos;
	}

	public void setDesabilitarCampos(Boolean desabilitarCampos) {
		this.desabilitarCampos = desabilitarCampos;
	}

	public void abrirNovaFuncao() throws Exception {
		desabilitarCampos = false;
		funcao = new Funcao();
		funcao.setTipoFuncao(new TipoFuncao());
		funcao.setFuncaoAnterior(new Funcao());
		listarTipoFuncoes();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("novaFuncao.jsp");
	}
	
	@SuppressWarnings("unchecked")
	public void abrirListarFuncoes() throws Exception {
		funcao = new Funcao();
		funcao.setTipoFuncao(new TipoFuncao());
		funcao.setFuncaoAnterior(new Funcao());
		funcoesList.clear();
		funcoesList = DAO.getInstance().list(Funcao.class, "codigo");
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("pesquisarFuncoes.jsp");
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
	
	public List<SelectItem> listarFuncoes() {
		funcoes = new ArrayList<SelectItem>();
		List<Funcao> funcaoList = new ArrayList<Funcao>();
		funcaoList = FuncaoServidorDAO.getInstance().listByTipoFuncao(
				funcao.getTipoFuncao());
		for (Funcao funcao : funcaoList) {
			funcoes.add(new SelectItem(funcao.getCodigo(), funcao
					.getDescricao()));
		}
		return funcoes;
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTodasFuncoes() {
		funcoes = new ArrayList<SelectItem>();
		List<Funcao> funcaoList = new ArrayList<Funcao>();
		funcaoList = FuncaoServidorDAO.getInstance().list(Funcao.class, "descricao");
		for (Funcao funcao : funcaoList) {
			funcoes.add(new SelectItem(funcao.getCodigo(), funcao
					.getDescricao()));
		}
		return funcoes;
	}
	
	public void carregar() throws IOException{
		 FacesContext context = FacesContext.getCurrentInstance();
		 funcao = (Funcao) context
	                .getExternalContext().getRequestMap().get("list");
		 listarTipoFuncoes();
		 if(funcao.getDataExtincao() != null){
				listarTodasFuncoes();
			}else{
				listarTipoFuncoes();
			}
		 FacesContext.getCurrentInstance().getExternalContext()
			.redirect("novaFuncao.jsp");
	}

	public void salvarNovaFuncao() {
		if(funcao.getFuncaoAnterior() != null && Constantes.ZERO.equals(funcao.getFuncaoAnterior().getCodigo())){
			funcao.setFuncaoAnterior(null);
		}else{
			FuncaoServidor funcaoServidor = new FuncaoServidor();
			funcaoServidor.setFuncao(funcao.getFuncaoAnterior());
			List<FuncaoServidor> list = FuncaoServidorDAO.getInstance().listByFilter(funcaoServidor, true);
			if(list != null){
				for(FuncaoServidor item: list){
					item.setDataSaida(funcao.getFuncaoAnterior().getDataExtincao());
					FuncaoServidorDAO.getInstance().updateFuncaoServidor(item);
				}
			}
		}
		DAO.getInstance().saveOrUpdate(funcao);
		funcao = new Funcao();
		funcao.setTipoFuncao(new TipoFuncao());
		funcao.setFuncaoAnterior(new Funcao());
		desabilitarCampos = false;
	}	
	public void carregarAnterior(){
		if(funcao.getFuncaoAnterior() != null && !(Constantes.ZERO.equals(funcao.getFuncaoAnterior().getCodigo()))){
			funcao.setFuncaoAnterior((Funcao) DAO.getInstance().refresh(funcao.getFuncaoAnterior()));
			funcao.setAtoCriacao(funcao.getFuncaoAnterior().getAtoCriacao());
			desabilitarCampos = true;
		}else{
			funcao.setAtoCriacao("");
			desabilitarCampos = false;
		}
	}
}
