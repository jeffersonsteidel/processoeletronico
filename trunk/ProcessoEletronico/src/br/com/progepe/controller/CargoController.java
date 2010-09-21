package br.com.progepe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Classe;

public class CargoController {

	private Cargo cargo;
	private List<SelectItem> classes;
	private List<Cargo> cargoList;

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<SelectItem> getClasses() {
		return classes;
	}

	public void setClasses(List<SelectItem> classes) {
		this.classes = classes;
	}

	public List<Cargo> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<Cargo> cargoList) {
		this.cargoList = cargoList;
	}

	DAO dao = new DAO();

	public void cadastrar() throws IOException {
		cargo = new Cargo();
		cargo.setClasse(new Classe());
		classes = new ArrayList<SelectItem>();
		listarClasses();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarCargo.jsp");
	}

	public void salvar() {
		dao.save(cargo);
		cargo = new Cargo();
	}

	public void carregar() throws IOException {
		listarClasses();
		dao.refresh(cargo);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarCargo.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> listar() throws IOException {
		cargo = new Cargo();
		this.setCargoList(dao.list(cargo.getClass(), "descricao"));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarCargos.jsp");
		return this.getCargoList();
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarClasses() {
		classes = new ArrayList<SelectItem>();
		List<Classe> classeList = new ArrayList<Classe>();
		cargo.setClasse(new Classe());
		classeList = dao.list(cargo.getClasse().getClass(), "descricao");
		for (Classe classe : classeList) {
			classes.add(new SelectItem(classe.getCodigo(), classe.getSigla()));
		}
		return classes;
	}

}
