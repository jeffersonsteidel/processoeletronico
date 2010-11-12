package br.com.progepe.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.PortariaDAO;
import br.com.progepe.entity.Portaria;
import br.com.progepe.entity.TipoPortaria;

public class PortariaController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	Portaria portaria;
	private Date dataInicio;
	private Date dataFinal;
	private ArrayList<Portaria> files = new ArrayList<Portaria>();
	private List<Portaria> portariaList = new ArrayList<Portaria>();
	private List<SelectItem> tiposPortaria = new ArrayList<SelectItem>();

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public ArrayList<Portaria> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Portaria> files) {
		this.files = files;
	}

	public List<SelectItem> getTiposPortaria() {
		return tiposPortaria;
	}

	public void setTiposPortaria(List<SelectItem> tiposPortaria) {
		this.tiposPortaria = tiposPortaria;
	}

	public List<Portaria> getPortariaList() {
		return portariaList;
	}

	public void setPortariaList(List<Portaria> portariaList) {
		this.portariaList = portariaList;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposPortaria() {
		tiposPortaria = new ArrayList<SelectItem>();
		List<TipoPortaria> tiposPortariaList = new ArrayList<TipoPortaria>();
		tiposPortariaList = DAO.getInstance().list(TipoPortaria.class, "descricao");
		for (TipoPortaria tipoPortaria : tiposPortariaList) {
			tiposPortaria.add(new SelectItem(tipoPortaria.getCodigo(),
					tipoPortaria.getDescricao()));
		}
		return tiposPortaria;
	}

	public void abrirPortaria() throws ParseException {
		try {
			portaria = new Portaria();
			portaria.setTipo(new TipoPortaria());
			tiposPortaria = new ArrayList<SelectItem>();
			listarTiposPortaria();
			files.clear();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("portaria.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		portaria.setPdf(item.getData());
		files.add(portaria);
	}

	public void paint(OutputStream out, Object data) throws IOException {
		if (data instanceof String) {
			InputStream file = FacesContext.getCurrentInstance()
					.getExternalContext().getResourceAsStream((String) data);
			int size = file.available();
			byte[] pdf = new byte[size];
			file.read(pdf);
			file.close();
			out.write(pdf);
		}
	}

	public void salvar() throws IOException, ParseException {
		 DAO.getInstance().saveOrUpdate(portaria);
		portaria = new Portaria();
		files = new ArrayList<Portaria>();
	}

	public void listarPortarias() throws IOException {
		portariaList = new ArrayList<Portaria>();
		portariaList.clear();
		portaria = new Portaria();
		portaria.setTipo(new TipoPortaria());
		listarTiposPortaria();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarPortarias.jsp");
	}

	public void pesquisarPortarias() throws IOException {
		this.setPortariaList(PortariaDAO.getInstance().listByFilter(portaria, dataInicio,
				dataFinal));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarPortarias.jsp");
	}

	public void carregar() throws IOException, ParseException {
		portaria = (Portaria)  DAO.getInstance().refresh(portaria);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("portaria.jsp");
	}


	public void visualizar() throws IOException, ParseException {
		portaria = (Portaria)  DAO.getInstance().refresh(portaria);
		OutputStream out = new FileOutputStream("c:\\portaria.pdf");
		out.write(portaria.getPdf()); 
	    Runtime.getRuntime().exec("cmd.exe /C c:\\portaria.pdf");
		out.flush();
		out.close();
		Runtime.getRuntime().runFinalization();
		
	}
	
	public void excluir() throws IOException{
		 DAO.getInstance().delete(portaria);
		listarPortarias();
	}
}
