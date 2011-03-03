package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.GrauParentescoDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.GrauParentesco;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoObito;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoObitoController  {

	private SolicitacaoObito solicitacaoObito;
	private List<SelectItem> grausParentescos = new ArrayList<SelectItem>();

	public SolicitacaoObito getSolicitacaoObito() {
		return solicitacaoObito;
	}

	public void setSolicitacaoObito(SolicitacaoObito solicitacaoObito) {
		this.solicitacaoObito = solicitacaoObito;
	}

	public List<SelectItem> getGrausParentescos() {
		return grausParentescos;
	}

	public void setGrausParentescos(List<SelectItem> grausParentescos) {
		this.grausParentescos = grausParentescos;
	}

	public void abrirSolicitacaoObito() throws ParseException {
		try {
			solicitacaoObito = new SolicitacaoObito();
			solicitacaoObito.setGrauParentesco(new GrauParentesco());
			listarGrauParentesco();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoObito.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoObito.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoObito.getSolicitante().setSiape(siapeAutenticado.getSiape());
		solicitacaoObito.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoObito.getSolicitante()));
	}

	public void salvar() throws IOException, ParseException {
		if (solicitacaoObito.getCertidaoObito() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar a Certidão de Obito!",
					"É necessário adicionar a Certidão de Obito!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			solicitacaoObito.setDataAbertura(new Date());
			solicitacaoObito.setDataAtendimento(null);
			solicitacaoObito.setTipoSolicitacao(new TipoSolicitacao());
			solicitacaoObito.getTipoSolicitacao().setCodigo(
					Constantes.TIPO_SOLICITACAO_OBITO);
			solicitacaoObito.setStatusSolicitacao(new StatusSolicitacao());
			solicitacaoObito.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			DAO.getInstance().saveOrUpdate(solicitacaoObito);
			EnviarEmail enviarEmail = new EnviarEmail();
			enviarEmail.enviarEmailSolicitacao(solicitacaoObito);
			solicitacaoObito = new SolicitacaoObito();
			buscarServidorLogado();
		}
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(solicitacaoObito.getCertidaoObito());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoObito.setCertidaoObito(item.getData());
	}

	public List<SelectItem> listarGrauParentesco() {
		grausParentescos = new ArrayList<SelectItem>();
		List<GrauParentesco> grauParentescosList = new ArrayList<GrauParentesco>();
		grauParentescosList = GrauParentescoDAO.getInstance().listByObito();
		for (GrauParentesco grauParentesco : grauParentescosList) {
			grausParentescos.add(new SelectItem(grauParentesco.getCodigo(),
					grauParentesco.getDescricao()));
		}
		return grausParentescos;
	}
	
	public void calcularRetorno(){
		if(solicitacaoObito.getDataObito() != null){
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(solicitacaoObito.getDataObito());  
			calendar.add(Calendar.DATE, Constantes.QUANTIDADE_DIAS_LICENCA_OBITO);  
			solicitacaoObito.setDataRetorno(calendar.getTime());
		}
	}
}
