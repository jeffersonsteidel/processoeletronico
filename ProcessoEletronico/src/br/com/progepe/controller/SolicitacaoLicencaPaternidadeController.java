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
import br.com.progepe.entity.SolicitacaoLicencaPaternidade;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoLicencaPaternidadeController  {

	private SolicitacaoLicencaPaternidade solicitacaoLicencaPaternidade;
	private Boolean desabilitaBotao = true;
	
	private String texto;

	public SolicitacaoLicencaPaternidade getSolicitacaoLicencaPaternidade() {
		return solicitacaoLicencaPaternidade;
	}

	public void setSolicitacaoLicencaPaternidade(
			SolicitacaoLicencaPaternidade solicitacaoLicencaPaternidade) {
		this.solicitacaoLicencaPaternidade = solicitacaoLicencaPaternidade;
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

	public void abrirSolicitacaoPaternidade() throws ParseException {
		try {
			texto = "";
			desabilitaBotao = false;
			solicitacaoLicencaPaternidade = new SolicitacaoLicencaPaternidade();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoLicencaPaternidade.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoLicencaPaternidade.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoLicencaPaternidade.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoLicencaPaternidade
				.setSolicitante(ServidorDAO.getInstance().refreshBySiape(
						solicitacaoLicencaPaternidade.getSolicitante()));
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(solicitacaoLicencaPaternidade.getCertidaoNascimento());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoLicencaPaternidade.setCertidaoNascimento(item.getData());
	}

	public void salvar() throws IOException, ParseException {
		if (solicitacaoLicencaPaternidade.getCertidaoNascimento() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"� necess�rio adicionar a Certid�o de Nascimento!",
					"� necess�rio adicionar a Certid�o de Nascimento!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			solicitacaoLicencaPaternidade.setDataAbertura(new Date());
			solicitacaoLicencaPaternidade.setDataAtendimento(null);
			solicitacaoLicencaPaternidade
					.setTipoSolicitacao(new TipoSolicitacao());
			solicitacaoLicencaPaternidade.getTipoSolicitacao().setCodigo(
					Constantes.TIPO_SOLICITACAO_LICENCA_PATERNIDADE);
			solicitacaoLicencaPaternidade
					.setStatusSolicitacao(new StatusSolicitacao());
			solicitacaoLicencaPaternidade.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			DAO.getInstance().saveOrUpdate(solicitacaoLicencaPaternidade);
			desabilitaBotao = true;
			EnviarEmail enviarEmail = new EnviarEmail();
			enviarEmail.enviarEmailSolicitacao(solicitacaoLicencaPaternidade);
			solicitacaoLicencaPaternidade = new SolicitacaoLicencaPaternidade();
			buscarServidorLogado();
			texto = "Clique aqui para ir para tela de cadastro de dependentes, l� voc� poder� adicionar seu filho(a) como seu dependedente!";
		}
	}

	public void carregar(
			SolicitacaoLicencaPaternidade codigoSolicitacaoLicencaPaternidade)
			throws IOException {
		solicitacaoLicencaPaternidade = codigoSolicitacaoLicencaPaternidade; // (SolicitacaoLicencaPaternidade)
																				// dao.refresh(codigoSolicitacaoLicencaPaternidade)
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("solicitacaoLicencaPaternidadeAprovar.jsp");
	}
	
	public void calcularRetorno(){
		if(solicitacaoLicencaPaternidade.getDataNascimento() != null){
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(solicitacaoLicencaPaternidade.getDataNascimento());  
			calendar.add(Calendar.DATE, Constantes.QUANTIDADE_DIAS_LICENCA_PATERNIDADE);  
			solicitacaoLicencaPaternidade.setDataRetorno(calendar.getTime());
		}
	}
}
