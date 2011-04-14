package br.com.progepe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.dao.ServidorTitulacaoDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;
import br.com.progepe.entity.SolicitacaoIncentivoQualificacao;

public class SolicitacaoIncentivoQualificacaoController {

	private SolicitacaoIncentivoQualificacao solicitacaoIncentivoQualificacao;
	private List<ServidorTitulacao> listaTitulacoes = new ArrayList<ServidorTitulacao>();

	public SolicitacaoIncentivoQualificacao getSolicitacaoIncentivoQualificacao() {
		return solicitacaoIncentivoQualificacao;
	}

	public void setSolicitacaoIncentivoQualificacao(
			SolicitacaoIncentivoQualificacao solicitacaoIncentivoQualificacao) {
		this.solicitacaoIncentivoQualificacao = solicitacaoIncentivoQualificacao;
	}

	public List<ServidorTitulacao> getListaTitulacoes() {
		return listaTitulacoes;
	}

	public void setListaTitulacoes(List<ServidorTitulacao> listaTitulacoes) {
		this.listaTitulacoes = listaTitulacoes;
	}

	public void abrirSolicitacaoIncentivoQualificacao() throws ParseException {
		try {
			solicitacaoIncentivoQualificacao = new SolicitacaoIncentivoQualificacao();
			solicitacaoIncentivoQualificacao
					.setServidorTitulacao(new ServidorTitulacao());
			buscarServidorLogado();
			listaTitulacoes.clear();
			solicitacaoIncentivoQualificacao.getServidorTitulacao()
					.setServidor(
							solicitacaoIncentivoQualificacao.getSolicitante());
			listaTitulacoes = ServidorTitulacaoDAO.getInstance()
					.listByIncentivo(
							solicitacaoIncentivoQualificacao
									.getServidorTitulacao());
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoIncentivoQualificacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoIncentivoQualificacao.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoIncentivoQualificacao.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoIncentivoQualificacao.setSolicitante(ServidorDAO
				.getInstance().refreshBySiape(
						solicitacaoIncentivoQualificacao.getSolicitante()));
	}

	public void salvar() {
		DAO.getInstance().save(solicitacaoIncentivoQualificacao);

		solicitacaoIncentivoQualificacao = new SolicitacaoIncentivoQualificacao();
		solicitacaoIncentivoQualificacao
				.setServidorTitulacao(new ServidorTitulacao());
	}

	public void selectionChanged(ActionEvent event) {
		UIComponent comp = event.getComponent();
		Object obj = comp.getParent();
		org.richfaces.component.html.HtmlDataTable table = (org.richfaces.component.html.HtmlDataTable) obj;
		Object rowData = table.getRowData();
		if (rowData instanceof ServidorTitulacao) {
			ServidorTitulacao selObj = (ServidorTitulacao) rowData;
			solicitacaoIncentivoQualificacao.setServidorTitulacao(selObj);
		}
	}

}
