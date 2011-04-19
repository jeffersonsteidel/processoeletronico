package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.ProgressaoCapacitacaoCertificado;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoProgressaoCapacitacao;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoProgressaoCapacitacaoController {

	private ProgressaoCapacitacaoCertificado progressaoCapacitacaoCertificacaoImagem;
	private SolicitacaoProgressaoCapacitacao solicitacaoProgressaoCapacitacao;
	private List<ProgressaoCapacitacaoCertificado> certificadoProgressaoCapacitacaoList = new ArrayList<ProgressaoCapacitacaoCertificado>();

	public ProgressaoCapacitacaoCertificado getProgressaoCapacitacaoCertificacaoImagem() {
		return progressaoCapacitacaoCertificacaoImagem;
	}

	public void setProgressaoCapacitacaoCertificacaoImagem(
			ProgressaoCapacitacaoCertificado progressaoCapacitacaoCertificacaoImagem) {
		this.progressaoCapacitacaoCertificacaoImagem = progressaoCapacitacaoCertificacaoImagem;
	}

	public SolicitacaoProgressaoCapacitacao getSolicitacaoProgressaoCapacitacao() {
		return solicitacaoProgressaoCapacitacao;
	}

	public void setSolicitacaoProgressaoCapacitacao(
			SolicitacaoProgressaoCapacitacao solicitacaoProgressaoCapacitacao) {
		this.solicitacaoProgressaoCapacitacao = solicitacaoProgressaoCapacitacao;
	}

	public List<ProgressaoCapacitacaoCertificado> getCertificadoProgressaoCapacitacaoList() {
		return certificadoProgressaoCapacitacaoList;
	}

	public void setCertificadoProgressaoCapacitacaoList(
			List<ProgressaoCapacitacaoCertificado> certificadoProgressaoCapacitacaoList) {
		this.certificadoProgressaoCapacitacaoList = certificadoProgressaoCapacitacaoList;
	}

	public void abrirProgressaoCapacitacao() throws ParseException {
		try {
			certificadoProgressaoCapacitacaoList.clear();
			solicitacaoProgressaoCapacitacao = new SolicitacaoProgressaoCapacitacao();
			progressaoCapacitacaoCertificacaoImagem = new ProgressaoCapacitacaoCertificado();
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
		progressaoCapacitacaoCertificacaoImagem = new ProgressaoCapacitacaoCertificado();
		UploadItem item = event.getUploadItem();
		progressaoCapacitacaoCertificacaoImagem.setCertificado(item.getData());
		this.getCertificadoProgressaoCapacitacaoList().add(
				progressaoCapacitacaoCertificacaoImagem);
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		if (this.getCertificadoProgressaoCapacitacaoList().size() > 0) {
			stream.write(this.getCertificadoProgressaoCapacitacaoList()
					.get((Integer) object).getCertificado());
		}
	}

	public void salvar() throws Exception {
		if (progressaoCapacitacaoCertificacaoImagem.getCertificado() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar o Certificado de conclusão de Curso!",
					"É necessário adicionar o Certificado de conclusão de Curso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			solicitacaoProgressaoCapacitacao.setDataAbertura(new Date());
			solicitacaoProgressaoCapacitacao.setDataAtendimento(null);
			solicitacaoProgressaoCapacitacao
					.setTipoSolicitacao(new TipoSolicitacao());
			solicitacaoProgressaoCapacitacao.getTipoSolicitacao().setCodigo(
					Constantes.TIPO_SOLICITACAO_PROGRESSAO_CAPACITACAO);
			solicitacaoProgressaoCapacitacao
					.setStatusSolicitacao(new StatusSolicitacao());
			solicitacaoProgressaoCapacitacao.getStatusSolicitacao().setCodigo(
					Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			solicitacaoProgressaoCapacitacao.getProgressaoCapacitacaoCertificadoList().clear();
			solicitacaoProgressaoCapacitacao.getProgressaoCapacitacaoCertificadoList().addAll(getCertificadoProgressaoCapacitacaoList());
			DAO.getInstance().save(solicitacaoProgressaoCapacitacao);
			
			solicitacaoProgressaoCapacitacao = new SolicitacaoProgressaoCapacitacao();
			solicitacaoProgressaoCapacitacao.setNovoPadrao(new Padrao());
			progressaoCapacitacaoCertificacaoImagem = new ProgressaoCapacitacaoCertificado();
			progressaoCapacitacaoCertificacaoImagem
					.setSolicitacaoProgressaoCapacitacao(new SolicitacaoProgressaoCapacitacao());
		}
	}
}
