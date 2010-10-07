package br.com.progepe.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Banco;

public class BancoController {
	
	private Banco banco;
	private List<Banco> bancoList;

	public Banco getBanco() {
		return banco;
	}

	
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public List<Banco> getBancoList() {
		return bancoList;
	}

	public void setBancoList(List<Banco> bancoList) {
		this.bancoList = bancoList;
	}

	DAO dao = new DAO();

	public void cadastrar() throws IOException {
		banco = new Banco();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarBanco.jsp");
	}

	public void salvar() {
		dao.save(banco);
		banco = new Banco();
	}

	public void carregar() throws IOException {
		dao.refresh(banco.getCodigo());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarBanco.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<Banco> listar() throws IOException {
		banco = new Banco();
		this.setBancoList(dao.list(banco.getClass(), "descricao"));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarBancos.jsp");
		return this.getBancoList();
	}

}
