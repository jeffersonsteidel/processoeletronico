package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.EmpregoDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Emprego;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.StatusSolicitacao;

public class EmpregoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	private List<Emprego> listaEmpregos = new ArrayList<Emprego>();
	private List<Emprego> listaEmpregosByFilter = new ArrayList<Emprego>();
	private List<SelectItem> statusSolicitacoes = new ArrayList<SelectItem>();
	private Emprego emprego;
	private Integer situacao = 0;
	private Servidor atendente;

	public List<Emprego> getListaEmpregos() {
		return listaEmpregos;
	}

	public void setListaEmpregos(List<Emprego> listaEmpregos) {
		this.listaEmpregos = listaEmpregos;
	}

	public Emprego getEmprego() {
		return emprego;
		
	}

	public void setEmprego(Emprego emprego) {
		this.emprego = emprego;
	}

	public List<Emprego> getListaEmpregosByFilter() {
		return listaEmpregosByFilter;
	}

	public void setListaEmpregosByFilter(List<Emprego> listaEmpregosByFilter) {
		this.listaEmpregosByFilter = listaEmpregosByFilter;
	}

	public List<SelectItem> getStatusSolicitacoes() {
		return statusSolicitacoes;
	}

	public void setStatusSolicitacoes(List<SelectItem> statusSolicitacoes) {
		this.statusSolicitacoes = statusSolicitacoes;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Servidor getAtendente() {
		return atendente;
	}

	public void setAtendente(Servidor atendente) {
		this.atendente = atendente;
	}
	
	public void abrirEmprego() throws Exception {
		try {
			listaEmpregos.clear();
			emprego = new Emprego();
			emprego.setStatusSolicitacao(new StatusSolicitacao());
			listarEmpregoServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("adicionarEmprego.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirListarEmprego() throws Exception {
		try {
			listarStatusSolicitacoes();
			listaEmpregosByFilter.clear();
			emprego = new Emprego();
			emprego.setStatusSolicitacao(new StatusSolicitacao());
			emprego.setServidor(new Servidor());
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarEmprego.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarStatusSolicitacoes() {
		statusSolicitacoes = new ArrayList<SelectItem>();
		List<StatusSolicitacao> statusSolicitacao = new ArrayList<StatusSolicitacao>();
		statusSolicitacao = DAO.getInstance().list(StatusSolicitacao.class, "descricao");
		for (StatusSolicitacao status : statusSolicitacao) {
			statusSolicitacoes.add(new SelectItem(status.getCodigo(), status.getDescricao()));
		}
		return statusSolicitacoes;
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		emprego.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		emprego.getServidor().setSiape(siapeAutenticado.getSiape());
		emprego.setServidor(ServidorDAO.getInstance().refreshBySiape(
				emprego.getServidor()));
	}
	
	

	public void salvarEmprego() throws Exception {
		if (emprego.getDataAdmissao().after(emprego.getDataSaida())
				|| emprego.getDataAdmissao().equals(emprego.getDataSaida())) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"A Data de Saída Final deve ser maior que Data de Admissão!",
					"A Data de Saída Final deve ser maior que Data de Admissão!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			emprego.getStatusSolicitacao().setCodigo(Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			emprego.setDataAbertura(new Date());
			DAO.getInstance().saveOrUpdate(emprego);
			listarEmpregoServidorLogado();
			emprego = new Emprego();
			buscarServidorLogado();
		}
	}

	public void deferir() {
		emprego.getStatusSolicitacao().setCodigo(Constantes.STATUS_SOLICITACAO_DEFERIDO);
		DAO.getInstance().update(emprego);
		emprego = new Emprego();
		emprego.setServidor(new Servidor());
	}
	
	public void indeferir() {
		if(emprego.getJustificativa() != null || !emprego.getJustificativa().isEmpty() ){
		emprego.getStatusSolicitacao().setCodigo(Constantes.STATUS_SOLICITACAO_INDEFERIDO);
		DAO.getInstance().update(emprego);
		emprego = new Emprego();
		emprego.setServidor(new Servidor());
		}else{
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Justificativa é obrigatório!",
					"Campo Justificativa é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	public void listarEmpregoServidorLogado() throws Exception {
		buscarServidorLogado();
		listaEmpregos = EmpregoDAO.getInstance().listByServidor(emprego);
	}

	public void remover() throws Exception {
		emprego = (Emprego) DAO.getInstance().refresh(emprego);
		DAO.getInstance().delete(emprego);
		abrirEmprego();
	}

	public void carregar() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		emprego = (Emprego) context.getExternalContext().getRequestMap()
				.get("list");
		emprego = (Emprego) DAO.getInstance().refresh(emprego);
		if(emprego.getStatusSolicitacao().getCodigo() != Constantes.STATUS_SOLICITACAO_EM_ANALISE){
		emprego.setStatusSolicitacao(new StatusSolicitacao());
		emprego.getStatusSolicitacao().setCodigo(Constantes.STATUS_SOLICITACAO_EM_ANALISE);
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
		.getCurrentInstance().getExternalContext().getSessionMap()
		.get("usuarioLogado");
		emprego.setAtendente(siapeAutenticado.getSiape());
		emprego.setDataAtendimento(new Date());
		DAO.getInstance().update(emprego);
		}
		
	}
	
	public void verificarStatus() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		emprego = (Emprego) context.getExternalContext().getRequestMap()
				.get("list");
		if(!Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(emprego.getStatusSolicitacao().getCodigo())){
			atendente = new Servidor();
			atendente.setSiape(emprego.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
		
		}
	}

	public List<Emprego> buscarEmpregos() {
		listaEmpregosByFilter = (List<Emprego>) EmpregoDAO.getInstance()
				.listByFilter(emprego, situacao);
		return listaEmpregosByFilter;
	}

}
