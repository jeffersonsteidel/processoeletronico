package br.com.progepe.controller;

import java.io.IOException;
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
import br.com.progepe.entity.Portaria;

public class PortariaController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	Portaria portaria;
	private ArrayList<Portaria> files = new ArrayList<Portaria>();
	DAO dao = new DAO();
	private List<SelectItem> tiposPortaria = new ArrayList<SelectItem>();

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(
			Portaria portaria) {
		this.portaria = portaria;
	}

	public ArrayList<Portaria> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Portaria> files) {
		this.files = files;
	}

	public void abrirPortaria() throws ParseException {
		try {
			portaria = new Portaria();
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

	public void salvar() throws IOException, ParseException {
		portaria.setData(new Date());
		dao.saveOrUpdate(portaria);
		portaria = new Portaria();
		files = new ArrayList<Portaria>();
	}
}
