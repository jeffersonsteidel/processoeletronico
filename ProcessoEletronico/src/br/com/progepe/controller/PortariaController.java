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
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Portaria;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.TipoPortaria;

public class PortariaController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	Portaria portaria;
	private Date dataInicio;
	private Date dataFinal;
	DAO dao = new DAO();
	private ArrayList<Portaria> files = new ArrayList<Portaria>();
	private ArrayList<Portaria> portariaList = new ArrayList<Portaria>();
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

	public ArrayList<Portaria> getPortariaList() {
		return portariaList;
	}

	public void setPortariaList(ArrayList<Portaria> portariaList) {
		this.portariaList = portariaList;
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarPortarias() {
		tiposPortaria = new ArrayList<SelectItem>();
		List<TipoPortaria> tipoPortariaList = new ArrayList<TipoPortaria>();
		tipoPortariaList = dao.list(TipoPortaria.class, "descricao");
		for (TipoPortaria tipoPortaria : tipoPortariaList) {
			tiposPortaria.add(new SelectItem(tipoPortaria.getCodigo(),
					tipoPortaria.getDescricao()));
		}
		return tiposPortaria;
	}

	@SuppressWarnings("unchecked")
	public void carregarPagina() throws IOException {
		portaria = new Portaria();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarPortarias.jsp");
	}
	
	public void pesquisarServidores() throws IOException {
		//??? está certo?
	
		portaria = new Portaria();
		portaria.setNumero(portaria.getNumero());
		portaria.setNome(portaria.getNome());
		portaria.setData(portaria.getData());
		portaria.setTipo(portaria.getTipo());
		portaria.setLocal(portaria.getLocal());

//		listarLotacoes();
//		listarCargos();

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarServidoresFilter.jsp");
	}
	

}
