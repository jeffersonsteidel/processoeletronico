package br.com.progepe.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;

public class PermissaoController {

	private Servidor servidor;
	private Autenticacao autenticacao;
	private Boolean isAutenticacaoNull;

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Autenticacao getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Autenticacao autenticacao) {
		this.autenticacao = autenticacao;
	}
	
	public Boolean getIsAutenticacaoNull() {
		return isAutenticacaoNull;
	}

	public void setIsAutenticacaoNull(Boolean isAutenticacaoNull) {
		this.isAutenticacaoNull = isAutenticacaoNull;
	}

	public void abrirGerenciarPermissao() {
		try {
			isAutenticacaoNull = true;
			servidor = new Servidor();
			autenticacao = new Autenticacao();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("gerenciarPermissao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void pesquisarPermissaoServidor(){
		servidor = ServidorDAO.getInstance().refreshBySiape(servidor);
		if(servidor != null){
			autenticacao.setSiape(servidor.getSiape());
			autenticacao  = (Autenticacao) ServidorDAO.getInstance().refresh(autenticacao);
		}else{
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Siape inexistente!",
					"Siape inexistente!");
			FacesContext.getCurrentInstance().addMessage("", message);
			servidor = new Servidor();
			autenticacao = new Autenticacao();
			isAutenticacaoNull = true;
		}
		if(servidor != null &&  autenticacao == null){
			isAutenticacaoNull = true;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Este servidor está desativado!",
					"Este servidor está desativado!");
			FacesContext.getCurrentInstance().addMessage("", message);
			servidor = new Servidor();
			autenticacao = new Autenticacao();
			isAutenticacaoNull = true;
		} else{
			isAutenticacaoNull = false;
		}
	}
	
	public void salvar(){
		DAO.getInstance().update(autenticacao);
		servidor = new Servidor();
		autenticacao = new Autenticacao();
		isAutenticacaoNull = true;
	}
}
