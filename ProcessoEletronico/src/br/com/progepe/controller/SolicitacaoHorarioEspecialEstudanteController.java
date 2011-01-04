package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
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
import br.com.progepe.entity.SolicitacaoHorarioEspecialEstudante;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoHorarioEspecialEstudanteController implements
		Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante;
	private String totalSegunda;
	private String totalTerca;
	private String totalQuarta;
	private String totalQuinta;
	private String totalSexta;
	private String totalSabado;
	private String totalSemana;

	public SolicitacaoHorarioEspecialEstudante getSolicitacaoHorarioEspecialEstudante() {
		return solicitacaoHorarioEspecialEstudante;
	}

	public void setSolicitacaoHorarioEspecialEstudante(
			SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante) {
		this.solicitacaoHorarioEspecialEstudante = solicitacaoHorarioEspecialEstudante;
	}

	public String getTotalSegunda() {
		return totalSegunda;
	}

	public void setTotalSegunda(String totalSegunda) {
		this.totalSegunda = totalSegunda;
	}

	public String getTotalTerca() {
		return totalTerca;
	}

	public void setTotalTerca(String totalTerca) {
		this.totalTerca = totalTerca;
	}

	public String getTotalQuarta() {
		return totalQuarta;
	}

	public void setTotalQuarta(String totalQuarta) {
		this.totalQuarta = totalQuarta;
	}

	public String getTotalQuinta() {
		return totalQuinta;
	}

	public void setTotalQuinta(String totalQuinta) {
		this.totalQuinta = totalQuinta;
	}

	public String getTotalSexta() {
		return totalSexta;
	}

	public void setTotalSexta(String totalSexta) {
		this.totalSexta = totalSexta;
	}

	public String getTotalSabado() {
		return totalSabado;
	}

	public void setTotalSabado(String totalSabado) {
		this.totalSabado = totalSabado;
	}

	public String getTotalSemana() {
		return totalSemana;
	}

	public void setTotalSemana(String totalSemana) {
		this.totalSemana = totalSemana;
	}

	public void abrirSolicitacaoHorarioEspecialEstudante()
			throws ParseException {
		try {
			totalSegunda = null;
			totalTerca = null;
			totalQuarta = null;
			totalQuinta = null;
			totalSexta = null;
			totalSabado = null;
			totalSemana = null;
			solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
			solicitacaoHorarioEspecialEstudante
					.setFiles(new ArrayList<SolicitacaoHorarioEspecialEstudante>());
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
		solicitacaoHorarioEspecialEstudante.setSolicitante(ServidorDAO
				.getInstance().refreshBySiape(
						solicitacaoHorarioEspecialEstudante.getSolicitante()));
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(solicitacaoHorarioEspecialEstudante.getFiles()
				.get((Integer) object).getDeclaracaoMatricula());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		solicitacaoHorarioEspecialEstudante.setDeclaracaoMatricula(item
				.getData());
		solicitacaoHorarioEspecialEstudante.getFiles().add(
				solicitacaoHorarioEspecialEstudante);
	}

	public void salvar() throws IOException, ParseException {
		if (solicitacaoHorarioEspecialEstudante.getDeclaracaoMatricula() == null) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar a Declaração de Matricula!",
					"É necessário adicionar a Declaração de Matricula!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			solicitacaoHorarioEspecialEstudante.setDataAbertura(new Date());
			solicitacaoHorarioEspecialEstudante.setDataAtendimento(null);
			solicitacaoHorarioEspecialEstudante
					.setTipoSolicitacao(new TipoSolicitacao());
			solicitacaoHorarioEspecialEstudante.getTipoSolicitacao().setCodigo(
					Constantes.TIPO_SOLICITACAO_HORARIO_ESPECIAL_ESTUDANTE);
			solicitacaoHorarioEspecialEstudante
					.setStatusSolicitacao(new StatusSolicitacao());
			solicitacaoHorarioEspecialEstudante.getStatusSolicitacao()
					.setCodigo(Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			DAO.getInstance().saveOrUpdate(solicitacaoHorarioEspecialEstudante);
			solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
			solicitacaoHorarioEspecialEstudante
					.setFiles(new ArrayList<SolicitacaoHorarioEspecialEstudante>());
			buscarServidorLogado();
			totalSegunda = null;
			totalTerca = null;
			totalQuarta = null;
			totalQuinta = null;
			totalSexta = null;
			totalSabado = null;
			totalSemana = null;
		}
	}

	public void calcularTempo() {
		int finalIntevalo = 0;
		int inicioIntevalo = 0;
		int horaFinal = 0;
		int horaIncial = 0;

		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaSegunda() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaSegunda() != ""
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSegunda() != null
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSegunda() != "") {
			if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaSegunda() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioSaidaSegunda() != "") {
				horaFinal = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaSegunda().substring(0, 2)) * 60;
				horaFinal = horaFinal
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaSegunda().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSegunda() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioEntradaSegunda() != "") {
					horaIncial = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioEntradaSegunda().substring(0, 2)) * 60;
					horaIncial = horaIncial
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioEntradaSegunda()
											.substring(3));
				} else {
					solicitacaoHorarioEspecialEstudante
							.setHorarioSaidaSegunda(null);
					solicitacaoHorarioEspecialEstudante
							.setHorarioEntradaSegunda(null);
				}
			} else {
				solicitacaoHorarioEspecialEstudante
						.setHorarioSaidaSegunda(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaSegunda(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoSegunda() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoSegunda() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSegunda().substring(0,
										2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSegunda().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSegunda() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoSegunda() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoSegunda().substring(
											0, 2)) * 60;
					inicioIntevalo = inicioIntevalo
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioSaidaAlmocoSegunda()
											.substring(3));
				} 
			}

			Integer totalMinutos = (horaFinal - horaIncial)
					- (finalIntevalo - inicioIntevalo);
			Integer total = (Integer) totalMinutos / 60;
			Integer resto = (Integer) totalMinutos % 60;
			if (total < 10) {
				totalSegunda = "0" + total.toString();
			} else {
				totalSegunda = total.toString();
			}
			if (resto < 10) {
				totalSegunda = totalSegunda + ":0" + resto.toString();
			} else {
				totalSegunda = totalSegunda + ":" + resto.toString();
			}
		}else{
			totalSegunda = null;
		}
	}
}
