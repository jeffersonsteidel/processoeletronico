package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoCasamento;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoCasamentoController  {

	private SolicitacaoCasamento solicitacaoCasamento;
	private String texto;
	
	private Boolean desabilitaBotao = true;

	public SolicitacaoCasamento getSolicitacaoCasamento() {
		return solicitacaoCasamento;
	}

	public void setSolicitacaoCasamento(
			SolicitacaoCasamento solicitacaoCasamento) {
		this.solicitacaoCasamento = solicitacaoCasamento;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Boolean getDesabilitaBotao() {
		return desabilitaBotao;
	}

	public void setDesabilitaBotao(Boolean desabilitaBotao) {
		this.desabilitaBotao = desabilitaBotao;
	}

	public void abrirSolicitacaoCasamento() throws ParseException {
		try {
			texto = "";
			desabilitaBotao = false;
			solicitacaoCasamento = new SolicitacaoCasamento();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoCasamento.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoCasamento.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoCasamento.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoCasamento.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoCasamento.getSolicitante()));
	}

	public void salvar() throws IOException, ParseException {
		if (solicitacaoCasamento.getCertidaoCasamento() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar a Certidão de Casamento!",
					"É necessário adicionar a Certidão de Casamento!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			solicitacaoCasamento.setDataAbertura(new Date());
			solicitacaoCasamento.setDataAtendimento(null);
			solicitacaoCasamento.setTipoSolicitacao(new TipoSolicitacao());
			solicitacaoCasamento.getTipoSolicitacao().setCodigo(
					Constantes.TIPO_SOLICITACAO_LICENCA_CASAMENTO);
			solicitacaoCasamento.setStatusSolicitacao(new StatusSolicitacao());
			solicitacaoCasamento.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			DAO.getInstance().saveOrUpdate(solicitacaoCasamento);
			desabilitaBotao = true;
			EnviarEmail enviarEmail = new EnviarEmail();
			enviarEmail.enviarEmailSolicitacao(solicitacaoCasamento);
			solicitacaoCasamento = new SolicitacaoCasamento();
			buscarServidorLogado();
			texto = "ATENÇÃO para que sua solicitação seja deferida você deverá adicionar seu cônjuge.\n Para cadastrar clique aqui.";
		}
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(solicitacaoCasamento.getCertidaoCasamento());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoCasamento.setCertidaoCasamento(item.getData());
	}
	
	public void calcularRetorno(){
		if(solicitacaoCasamento.getDataCasamento() != null){
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(solicitacaoCasamento.getDataCasamento());  
			calendar.add(Calendar.DATE, Constantes.QUANTIDADE_DIAS_LICENCA_CASAMENTO);  
			solicitacaoCasamento.setDataRetorno(calendar.getTime());
		}
	}
}
