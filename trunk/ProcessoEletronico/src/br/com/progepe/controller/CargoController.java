package br.com.progepe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Classe;

public class CargoController  {
	private static final long serialVersionUID = -333995781063775201L;

	private Cargo cargo;
	private List<Cargo> cargoList;
	private List<SelectItem> classes = new ArrayList<SelectItem>();
	private Boolean indNovo;

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<Cargo> cargoList) {
		this.cargoList = cargoList;
	}

	public List<SelectItem> getClasses() {
		return classes;
	}

	public void setClasses(List<SelectItem> classes) {
		this.classes = classes;
	}

	public Boolean getIndNovo() {
		return indNovo;
	}

	public void setIndNovo(Boolean indNovo) {
		this.indNovo = indNovo;
	}

	@SuppressWarnings("unchecked")
	public void abrirListarCargos() throws ParseException {
		try {
			cargo = new Cargo();
			cargoList = new ArrayList<Cargo>();
			cargoList = (List<Cargo>) DAO.getInstance().list(Cargo.class,
					"codigo");
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarCargos.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirCadastrarCargo() throws ParseException {
		try {
			cargo = new Cargo();
			cargo.setClasse(new Classe());
			indNovo = true;
			listarClasses();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("cadastrarCargo.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void carregar() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		listarClasses();
		indNovo = false;
		cargo = (Cargo) context.getExternalContext().getRequestMap()
				.get("list");
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarCargo.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarClasses() {
		classes = new ArrayList<SelectItem>();
		List<Classe> classeList = new ArrayList<Classe>();
		classeList = DAO.getInstance().list(Classe.class, "sigla");
		for (Classe classe : classeList) {
			classes.add(new SelectItem(classe.getCodigo(), classe.getSigla()));
		}
		return classes;
	}

	public void salvar() {
		if (indNovo) {
			DAO.getInstance().save(cargo);
		} else {
			DAO.getInstance().update(cargo);
		}
		cargo = new Cargo();
		cargo.setClasse(new Classe());
	}
}
