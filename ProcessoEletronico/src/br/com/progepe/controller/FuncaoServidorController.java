package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.FuncaoServidorDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Funcao;
import br.com.progepe.entity.FuncaoServidor;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.TipoFuncao;

public class FuncaoServidorController implements Serializable {

	private static final long serialVersionUID = 8505987470598069907L;

	private FuncaoServidor funcaoServidor;
	private List<SelectItem> locaisExercicio = new ArrayList<SelectItem>();
	private List<SelectItem> tipoFuncoes = new ArrayList<SelectItem>();
	private List<SelectItem> funcoes = new ArrayList<SelectItem>();
	private List<FuncaoServidor> listaFuncoesByFilter = new ArrayList<FuncaoServidor>();
	private Boolean indAtual = false;

	public FuncaoServidor getFuncaoServidor() {
		return funcaoServidor;
	}

	public void setFuncaoServidor(FuncaoServidor funcaoServidor) {
		this.funcaoServidor = funcaoServidor;
	}

	public List<SelectItem> getLocaisExercicio() {
		return locaisExercicio;
	}

	public void setLocaisExercicio(List<SelectItem> locaisExercicio) {
		this.locaisExercicio = locaisExercicio;
	}

	public List<SelectItem> getTipoFuncoes() {
		return tipoFuncoes;
	}

	public void setTipoFuncoes(List<SelectItem> tipoFuncoes) {
		this.tipoFuncoes = tipoFuncoes;
	}

	public List<SelectItem> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<SelectItem> funcoes) {
		this.funcoes = funcoes;
	}

	public List<FuncaoServidor> getListaFuncoesByFilter() {
		return listaFuncoesByFilter;
	}

	public void setListaFuncoesByFilter(List<FuncaoServidor> listaFuncoesByFilter) {
		this.listaFuncoesByFilter = listaFuncoesByFilter;
	}

	public Boolean getIndAtual() {
		return indAtual;
	}

	public void setIndAtual(Boolean indAtual) {
		this.indAtual = indAtual;
	}

	public void abrirAdicionarFuncaoServidor() throws Exception {
		funcaoServidor = new FuncaoServidor();
		funcaoServidor.setFuncao(new Funcao());
		funcaoServidor.getFuncao().setTipoFuncao(new TipoFuncao());
		funcaoServidor.setLocalExercicio(new Lotacao());
		funcaoServidor.setServidor(new Servidor());
		listarLotacoes();
		listarTipoFuncoes();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("adicionarFuncao.jsp");
	}
	
	public void abrirListarFuncoes() throws Exception {
		funcaoServidor = new FuncaoServidor();
		funcaoServidor.setFuncao(new Funcao());
		funcaoServidor.getFuncao().setTipoFuncao(new TipoFuncao());
		funcaoServidor.setLocalExercicio(new Lotacao());
		funcaoServidor.setServidor(new Servidor());
		listarLotacoes();
		listarTipoFuncoes();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarFuncoes.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarLotacoes() {
		locaisExercicio = new ArrayList<SelectItem>();
		List<Lotacao> lotacaoList = new ArrayList<Lotacao>();
		lotacaoList = DAO.getInstance().list(Lotacao.class, "descricao");
		for (Lotacao lotacao : lotacaoList) {
			locaisExercicio.add(new SelectItem(lotacao.getCodigo(), lotacao
					.getDescricao()));
		}
		return locaisExercicio;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTipoFuncoes() {
		tipoFuncoes = new ArrayList<SelectItem>();
		List<TipoFuncao> tipoFuncaoList = new ArrayList<TipoFuncao>();
		tipoFuncaoList = DAO.getInstance().list(TipoFuncao.class, "codigo");
		for (TipoFuncao item : tipoFuncaoList) {
			tipoFuncoes.add(new SelectItem(item.getCodigo(), item
					.getSigla()));
		}
		return tipoFuncoes;
	}

	public List<SelectItem> listarFuncoes() {
		funcoes = new ArrayList<SelectItem>();
		List<Funcao> funcaoList = new ArrayList<Funcao>();
		funcaoList = FuncaoServidorDAO.getInstance().listByTipoFuncao(
				funcaoServidor.getFuncao().getTipoFuncao());
		for (Funcao funcao : funcaoList) {
			funcoes.add(new SelectItem(funcao.getCodigo(), funcao
					.getDescricao()));
		}
		return funcoes;
	}

	
	public void buscarServidor() throws IOException, ParseException {
		funcaoServidor.setServidor(ServidorDAO.getInstance().refreshBySiape(
				funcaoServidor.getServidor()));
		if(funcaoServidor.getServidor() == null){
			funcaoServidor.setServidor(new Servidor());
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Siape inválido!",
					"Siape inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	public void salvarFuncaoServidor() {
		DAO.getInstance().save(funcaoServidor);
		funcaoServidor = new FuncaoServidor();
		funcaoServidor.setFuncao(new Funcao());
		funcaoServidor.getFuncao().setTipoFuncao(new TipoFuncao());
		funcaoServidor.setLocalExercicio(new Lotacao());
		funcoes = new ArrayList<SelectItem>();
	}
}
