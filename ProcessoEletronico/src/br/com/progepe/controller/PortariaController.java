package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.PortariaDAO;
import br.com.progepe.entity.Portaria;
import br.com.progepe.entity.TipoPortaria;

public class PortariaController  {
	private static final long serialVersionUID = -333995781063775201L;

	Portaria portaria;
	Portaria portariaFilter;
	private Date dataInicio;
	private Date dataFinal;
	private List<Portaria> portariaList = new ArrayList<Portaria>();
	private List<SelectItem> tiposPortaria = new ArrayList<SelectItem>();
	private List<Portaria> portarias = new ArrayList<Portaria>();
	private Integer quantidadeArquivos = 0;

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

	public List<Portaria> getPortarias() {
		return portarias;
	}

	public void setPortarias(List<Portaria> portarias) {
		this.portarias = portarias;
	}
	
	public Portaria getPortariaFilter() {
		return portariaFilter;
	}

	public void setPortariaFilter(Portaria portariaFilter) {
		this.portariaFilter = portariaFilter;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposPortaria() {
		tiposPortaria = new ArrayList<SelectItem>();
		List<TipoPortaria> tiposPortariaList = new ArrayList<TipoPortaria>();
		tiposPortariaList = DAO.getInstance().list(TipoPortaria.class,
				"descricao");
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
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("portaria.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void carregarPortaria() throws Exception {
		portaria = (Portaria) DAO.getInstance().refresh(portaria);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();
		response.sendRedirect("portariaVisualizar.jsp");
	}

	public void salvar() throws IOException, ParseException {
		if (portaria.getArquivo1() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar a Portaria!",
					"É necessário adicionar a Portaria!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			DAO.getInstance().saveOrUpdate(portaria);
			portaria = new Portaria();
		}
	}

	public void listarPortarias() throws IOException {
		portariaList = new ArrayList<Portaria>();
		portariaList.clear();
		portariaFilter = new Portaria();
		portariaFilter.setTipo(new TipoPortaria());
		listarTiposPortaria();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarPortarias.jsp");
	}

	public void pesquisarPortarias() throws IOException {
		this.setPortariaList(PortariaDAO.getInstance().listByFilter(portariaFilter,
				dataInicio, dataFinal));
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("listarPortarias.jsp");
	}

	public void carregar() throws IOException, ParseException {
		portaria = (Portaria) DAO.getInstance().refresh(portaria);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("portaria.jsp");
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		quantidadeArquivos++;
		if (quantidadeArquivos.equals(1)) {
			portaria.setArquivo1(item.getData());
		} else if (quantidadeArquivos == 2) {
			portaria.setArquivo2(item.getData());
		} else if (quantidadeArquivos == 3) {
			portaria.setArquivo3(item.getData());
		} else if (quantidadeArquivos == 4) {
			portaria.setArquivo4(item.getData());
		} else if (quantidadeArquivos == 5) {
			portaria.setArquivo5(item.getData());
		}
	}

	public void paint1(OutputStream stream, Object object) throws IOException {
		stream.write(portaria.getArquivo1());
	}

	public void paint2(OutputStream stream, Object object) throws IOException {
		stream.write(portaria.getArquivo2());
	}

	public void paint3(OutputStream stream, Object object) throws IOException {
		stream.write(portaria.getArquivo3());
	}

	public void paint4(OutputStream stream, Object object) throws IOException {
		stream.write(portaria.getArquivo4());
	}

	public void paint5(OutputStream stream, Object object) throws IOException {
		stream.write(portaria.getArquivo5());
	}

	public void excluir() throws IOException {
		DAO.getInstance().delete(portaria);
		listarPortarias();
	}
	
	public void retornaUltimaPesquisa() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("listarPortarias.jsp");
	}
}
