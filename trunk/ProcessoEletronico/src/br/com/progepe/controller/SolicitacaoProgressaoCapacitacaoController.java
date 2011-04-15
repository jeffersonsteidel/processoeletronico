package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.ProgressaoCapacitacaoCertificacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoProgressaoCapacitacao;

public class SolicitacaoProgressaoCapacitacaoController {

	private ProgressaoCapacitacaoCertificacao certificadoImagem;
	private SolicitacaoProgressaoCapacitacao solicitacaoProgressaoCapacitacao;
	private List<ProgressaoCapacitacaoCertificacao> certificadoProgressaoCapacitacaoList = new ArrayList<ProgressaoCapacitacaoCertificacao>();

	public ProgressaoCapacitacaoCertificacao getCertificadoImagem() {
		return certificadoImagem;
	}

	public void setCertificadoImagem(
			ProgressaoCapacitacaoCertificacao certificadoImagem) {
		this.certificadoImagem = certificadoImagem;
	}

	public SolicitacaoProgressaoCapacitacao getSolicitacaoProgressaoCapacitacao() {
		return solicitacaoProgressaoCapacitacao;
	}

	public void setSolicitacaoProgressaoCapacitacao(
			SolicitacaoProgressaoCapacitacao solicitacaoProgressaoCapacitacao) {
		this.solicitacaoProgressaoCapacitacao = solicitacaoProgressaoCapacitacao;
	}

	public List<ProgressaoCapacitacaoCertificacao> getCertificadoProgressaoCapacitacaoList() {
		return certificadoProgressaoCapacitacaoList;
	}

	public void setCertificadoProgressaoCapacitacaoList(
			List<ProgressaoCapacitacaoCertificacao> certificadoProgressaoCapacitacaoList) {
		this.certificadoProgressaoCapacitacaoList = certificadoProgressaoCapacitacaoList;
	}

	public void abrirProgressaoCapacitacao() throws ParseException {
		try {
			certificadoProgressaoCapacitacaoList.clear();
			solicitacaoProgressaoCapacitacao = new SolicitacaoProgressaoCapacitacao();
			certificadoImagem = new ProgressaoCapacitacaoCertificacao();
			solicitacaoProgressaoCapacitacao.setNovoPadrao(new Padrao());
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoProgressaoCapacitacao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoProgressaoCapacitacao.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoProgressaoCapacitacao.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoProgressaoCapacitacao.setSolicitante(ServidorDAO
				.getInstance().refreshBySiape(
						solicitacaoProgressaoCapacitacao.getSolicitante()));
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		certificadoImagem = new ProgressaoCapacitacaoCertificacao();
		certificadoImagem.setCertificado(item.getData());
		certificadoImagem
				.setSolicitacaoProgressaoCapacitacao(solicitacaoProgressaoCapacitacao);
		certificadoProgressaoCapacitacaoList.add(certificadoImagem);
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(certificadoImagem.getCertificado());
	}

	public void salvar() throws Exception {

		if (certificadoImagem.getCertificado() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar um Documento!",
					"É necessário adicionar um Documento!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			DAO.getInstance().save(solicitacaoProgressaoCapacitacao);
			DAO.getInstance().save(certificadoImagem);	
			solicitacaoProgressaoCapacitacao = new SolicitacaoProgressaoCapacitacao();
			solicitacaoProgressaoCapacitacao.setNovoPadrao(new Padrao());
			
			certificadoImagem = new ProgressaoCapacitacaoCertificacao();
			certificadoImagem.setSolicitacaoProgressaoCapacitacao(new SolicitacaoProgressaoCapacitacao());
		}
	}
}
