package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.faces.context.FacesContext;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoHorarioEspecialEstudante;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoHorarioEspecialEstudanteController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante;
	DAO dao = new DAO();

	public SolicitacaoHorarioEspecialEstudante getSolicitacaoHorarioEspecialEstudante() {
		return solicitacaoHorarioEspecialEstudante;
	}

	public void setSolicitacaoHorarioEspecialEstudante(SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante) {
		this.solicitacaoHorarioEspecialEstudante = solicitacaoHorarioEspecialEstudante;
	}

	public void abrirSolicitacaoHorarioEspecialEstudante() throws ParseException {
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
				.refreshBySiape(solicitacaoHorarioEspecialEstudante.getSolicitante()));
	}
	
	public void salvar() throws IOException, ParseException {
		solicitacaoHorarioEspecialEstudante.setDataAbertura(new Date());
		solicitacaoHorarioEspecialEstudante.setDataAtendimento(null);
		solicitacaoHorarioEspecialEstudante.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoHorarioEspecialEstudante.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE);
		solicitacaoHorarioEspecialEstudante.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoHorarioEspecialEstudante.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_AGUARDANDO);
		dao.saveOrUpdate(solicitacaoHorarioEspecialEstudante);
		solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
		buscarServidorLogado();
	}
	
}
