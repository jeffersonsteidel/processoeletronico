package br.com.progepe.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Grupo;

public class GrupoController {
	
	private Grupo grupo;
	private List<Grupo> grupoList;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}

	DAO dao = new DAO();

	public void cadastrar() throws IOException {
		grupo = new Grupo();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarGrupo.jsp");
	}

	public void salvar() {
		dao.save(grupo);
		grupo = new Grupo();
	}

	public void carregar() throws IOException {
		dao.refresh(grupo.getCodigo());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarGrupo.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<Grupo> listar() throws IOException {
		grupo = new Grupo();
		this.setGrupoList(dao.list(grupo.getClass(), "descricao"));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarGrupo.jsp");
		return this.getGrupoList();
	}

}
