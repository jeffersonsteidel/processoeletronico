package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Funcao;
import br.com.progepe.entity.FuncaoServidor;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Servidor;

public class FuncaoServidorController implements Serializable {

	private static final long serialVersionUID = 8505987470598069907L;
	private FuncaoServidor funcaoServidor;

	public FuncaoServidor getFuncaoServidor() {
		return funcaoServidor;
	}

	public void setFuncaoServidor(FuncaoServidor funcaoServidor) {
		this.funcaoServidor = funcaoServidor;
	}

	public void abrirAdicionarFuncaoServidor() throws Exception {
		funcaoServidor = new FuncaoServidor();
		funcaoServidor.setFuncao(new Funcao());
		funcaoServidor.setLocalExercicio(new Lotacao());
		buscarServidorLogado();
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("adicionarFuncao.jsp");
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		funcaoServidor.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		funcaoServidor.getServidor().setSiape(siapeAutenticado.getSiape());
		funcaoServidor.setServidor(ServidorDAO.getInstance().refreshBySiape(
				funcaoServidor.getServidor()));
	}
	public void salvarFuncaoServidor() {

	}
}
