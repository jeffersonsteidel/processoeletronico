package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoHorarioEspecialEstudante;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoHorarioEspecialEstudanteController implements
		Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante;
	private ArrayList<SolicitacaoHorarioEspecialEstudante> files = new ArrayList<SolicitacaoHorarioEspecialEstudante>();
	DAO dao = new DAO();

	public SolicitacaoHorarioEspecialEstudante getSolicitacaoHorarioEspecialEstudante() {
		return solicitacaoHorarioEspecialEstudante;
	}

	public void setSolicitacaoHorarioEspecialEstudante(
			SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante) {
		this.solicitacaoHorarioEspecialEstudante = solicitacaoHorarioEspecialEstudante;
	}

	public ArrayList<SolicitacaoHorarioEspecialEstudante> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<SolicitacaoHorarioEspecialEstudante> files) {
		this.files = files;
	}

	public void abrirSolicitacaoHorarioEspecialEstudante()
			throws ParseException {
		try {
			solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
			buscarServidorLogado();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoHorarioEspecialEstudante.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoHorarioEspecialEstudante.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoHorarioEspecialEstudante.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoHorarioEspecialEstudante.setSolicitante(servidorDAO
				.refreshBySiape(solicitacaoHorarioEspecialEstudante
						.getSolicitante()));
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(getFiles().get((Integer) object).getDeclaracaoMatricula());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoHorarioEspecialEstudante.setDeclaracaoMatricula(item.getData());
		files.add(solicitacaoHorarioEspecialEstudante);
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoHorarioEspecialEstudante.setDataAbertura(new Date());
		solicitacaoHorarioEspecialEstudante.setDataAtendimento(null);
		solicitacaoHorarioEspecialEstudante
				.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoHorarioEspecialEstudante.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE);
		solicitacaoHorarioEspecialEstudante
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoHorarioEspecialEstudante.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		dao.saveOrUpdate(solicitacaoHorarioEspecialEstudante);
		solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
		files = new ArrayList<SolicitacaoHorarioEspecialEstudante>();
		buscarServidorLogado();
	}

}
