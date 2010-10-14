package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.progepe.dao.DAOAutenticacao;
import br.com.progepe.encripty.Encripty;
import br.com.progepe.entity.Autenticacao;

public class AutenticacaoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private Autenticacao autenticacao;
	private String novaSenha;
	private String confirmarSenha;

	public Autenticacao getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Autenticacao autenticacao) {
		this.autenticacao = autenticacao;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public AutenticacaoController() {

		if (this.autenticacao == null) {
			this.autenticacao = new Autenticacao();
		}
	}

	public void login() throws Exception {
		Autenticacao siapeAutenticado;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		DAOAutenticacao daoAutenticacao = new DAOAutenticacao();
		siapeAutenticado = daoAutenticacao.autentica(autenticacao);

		if (siapeAutenticado.getSiape() != null && siapeAutenticado.getSiape() != 0) {
			session.setAttribute("user", siapeAutenticado);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("menus.jsp");
		} else {
			session.setAttribute("user", null);
			session.removeAttribute("user");
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Siape ou Senha inválida!",
					"Siape ou Senha inválida!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	
	public void alterarSenha() throws IOException {
		autenticacao = new Autenticacao();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("alterarSenha.jsp");
	}

	public void verificarSenha() throws NoSuchAlgorithmException {

		if (novaSenha.equals(confirmarSenha)) {
			Encripty.criptografaSenha(novaSenha);
		}

		else {			
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Os campos 'Nova Senha' e 'Confirmação nova senha' devem ser iguais!",
					"Os campos 'Nova Senha' e 'Confirmação nova senha' devem ser iguais!");
			FacesContext.getCurrentInstance().addMessage("", message);
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
