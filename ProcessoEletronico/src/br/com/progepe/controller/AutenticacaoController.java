package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.progepe.dao.DAOAutenticacao;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Servidor;

public class AutenticacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Autenticacao autenticacao;

	public Autenticacao getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Autenticacao autenticacao) {
		this.autenticacao = autenticacao;
	}

	public AutenticacaoController() {

		if (this.autenticacao == null) {
			this.autenticacao = new Autenticacao();
			autenticacao.setServidor(new Servidor());
			autenticacao.getServidor().setDocumento(new Documento());
		}
	}

	public void login() throws Exception {
		boolean logado = false;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		DAOAutenticacao daoAutenticacao = new DAOAutenticacao();
		logado = daoAutenticacao.autentica(this.autenticacao.getServidor(),
				this.autenticacao.getSenha());

		if (logado) {
			session.setAttribute("user", logado);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("menus.jsp");
		} else {
			session.setAttribute("user", null);
			session.removeAttribute("user");
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("login.jsp");
		}
	}

	public void logout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		session.invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
