package br.com.progepe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Servidor;

public class AniversarianteController  {

	private Integer mes;
	private List<Servidor> aniversariantesList = new ArrayList<Servidor>();

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public List<Servidor> getAniversariantesList() {
		return aniversariantesList;
	}

	public void setAniversariantesList(List<Servidor> aniversariantesList) {
		this.aniversariantesList = aniversariantesList;
	}

	public void abrirAniversariantes() throws ParseException {
		try {
			mes = null;
			aniversariantesList.clear();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarAniversariantes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pesquisarAniversariantes() throws IOException {
		aniversariantesList = ServidorDAO.getInstance()
				.listAniversariantes(mes);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarAniversariantes.jsp");
	}
}
