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

		//SEGUNDA
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
		if((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoSegunda() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoSegunda() == "") ||  (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoSegunda() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSegunda() != "")){
			totalSegunda = null;
		}
		
		//TERCA
		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaTerca() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaTerca() != ""
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaTerca() != null
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaTerca() != "") {
			if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaTerca() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioSaidaTerca() != "") {
				horaFinal = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaTerca().substring(0, 2)) * 60;
				horaFinal = horaFinal
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaTerca().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaTerca() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioEntradaTerca() != "") {
					horaIncial = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioEntradaTerca().substring(0, 2)) * 60;
					horaIncial = horaIncial
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioEntradaTerca()
											.substring(3));
				} else {
					solicitacaoHorarioEspecialEstudante
							.setHorarioSaidaTerca(null);
					solicitacaoHorarioEspecialEstudante
							.setHorarioEntradaTerca(null);
				}
			} else {
				solicitacaoHorarioEspecialEstudante
						.setHorarioSaidaTerca(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaTerca(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoTerca() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoTerca() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoTerca().substring(0,
										2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoTerca().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoTerca() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoTerca() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoTerca().substring(
											0, 2)) * 60;
					inicioIntevalo = inicioIntevalo
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioSaidaAlmocoTerca()
											.substring(3));
				}
			}

			Integer totalMinutos = (horaFinal - horaIncial)
					- (finalIntevalo - inicioIntevalo);
			Integer total = (Integer) totalMinutos / 60;
			Integer resto = (Integer) totalMinutos % 60;
			if (total < 10) {
				totalTerca = "0" + total.toString();
			} else {
				totalTerca = total.toString();
			}
			if (resto < 10) {
				totalTerca = totalTerca + ":0" + resto.toString();
			} else {
				totalTerca = totalTerca + ":" + resto.toString();
			}
		}else{
			totalTerca = null;
		}
		if((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoTerca() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoTerca() == "") ||  (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoTerca() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoTerca() != "")){
			totalTerca = null;
		}
		
		//QUARTA
		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaQuarta() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaQuarta() != ""
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaQuarta() != null
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaQuarta() != "") {
			if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaQuarta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioSaidaQuarta() != "") {
				horaFinal = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaQuarta().substring(0, 2)) * 60;
				horaFinal = horaFinal
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaQuarta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaQuarta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioEntradaQuarta() != "") {
					horaIncial = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioEntradaQuarta().substring(0, 2)) * 60;
					horaIncial = horaIncial
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioEntradaQuarta()
											.substring(3));
				} else {
					solicitacaoHorarioEspecialEstudante
							.setHorarioSaidaQuarta(null);
					solicitacaoHorarioEspecialEstudante
							.setHorarioEntradaQuarta(null);
				}
			} else {
				solicitacaoHorarioEspecialEstudante
						.setHorarioSaidaQuarta(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaQuarta(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoQuarta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoQuarta() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuarta().substring(0,
										2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuarta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuarta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoQuarta() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoQuarta().substring(
											0, 2)) * 60;
					inicioIntevalo = inicioIntevalo
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioSaidaAlmocoQuarta()
											.substring(3));
				}
			}

			Integer totalMinutos = (horaFinal - horaIncial)
					- (finalIntevalo - inicioIntevalo);
			Integer total = (Integer) totalMinutos / 60;
			Integer resto = (Integer) totalMinutos % 60;
			if (total < 10) {
				totalQuarta = "0" + total.toString();
			} else {
				totalQuarta = total.toString();
			}
			if (resto < 10) {
				totalQuarta = totalQuarta + ":0" + resto.toString();
			} else {
				totalQuarta = totalQuarta + ":" + resto.toString();
			}
		}else{
			totalQuarta = null;
		}
		if((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoQuarta() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoQuarta() == "") ||  (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoQuarta() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuarta() != "")){
			totalQuarta = null;
		}
		
		//QUINTA
		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaQuinta() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaQuinta() != ""
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaQuinta() != null
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaQuinta() != "") {
			if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaQuinta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioSaidaQuinta() != "") {
				horaFinal = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaQuinta().substring(0, 2)) * 60;
				horaFinal = horaFinal
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaQuinta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaQuinta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioEntradaQuinta() != "") {
					horaIncial = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioEntradaQuinta().substring(0, 2)) * 60;
					horaIncial = horaIncial
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioEntradaQuinta()
											.substring(3));
				} else {
					solicitacaoHorarioEspecialEstudante
							.setHorarioSaidaQuinta(null);
					solicitacaoHorarioEspecialEstudante
							.setHorarioEntradaQuinta(null);
				}
			} else {
				solicitacaoHorarioEspecialEstudante
						.setHorarioSaidaQuinta(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaQuinta(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoQuinta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoQuinta() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuinta().substring(0,
										2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuinta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuinta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoQuinta() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoQuinta().substring(
											0, 2)) * 60;
					inicioIntevalo = inicioIntevalo
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioSaidaAlmocoQuinta()
											.substring(3));
				}
			}

			Integer totalMinutos = (horaFinal - horaIncial)
					- (finalIntevalo - inicioIntevalo);
			Integer total = (Integer) totalMinutos / 60;
			Integer resto = (Integer) totalMinutos % 60;
			if (total < 10) {
				totalQuinta = "0" + total.toString();
			} else {
				totalQuinta = total.toString();
			}
			if (resto < 10) {
				totalQuinta = totalQuinta + ":0" + resto.toString();
			} else {
				totalQuinta = totalQuinta + ":" + resto.toString();
			}
		}else{
			totalQuinta = null;
		}
		if((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoQuinta() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoQuinta() == "") ||  (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoQuinta() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuinta() != "")){
			totalQuinta = null;
		}
		
		//SEXTA
		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaSexta() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaSexta() != ""
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSexta() != null
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSexta() != "") {
			if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaSexta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioSaidaSexta() != "") {
				horaFinal = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaSexta().substring(0, 2)) * 60;
				horaFinal = horaFinal
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaSexta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSexta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioEntradaSexta() != "") {
					horaIncial = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioEntradaSexta().substring(0, 2)) * 60;
					horaIncial = horaIncial
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioEntradaSexta()
											.substring(3));
				} else {
					solicitacaoHorarioEspecialEstudante
							.setHorarioSaidaSexta(null);
					solicitacaoHorarioEspecialEstudante
							.setHorarioEntradaSexta(null);
				}
			} else {
				solicitacaoHorarioEspecialEstudante
						.setHorarioSaidaSexta(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaSexta(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoSexta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoSexta() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSexta().substring(0,
										2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSexta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSexta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoSexta() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoSexta().substring(
											0, 2)) * 60;
					inicioIntevalo = inicioIntevalo
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioSaidaAlmocoSexta()
											.substring(3));
				}
			}

			Integer totalMinutos = (horaFinal - horaIncial)
					- (finalIntevalo - inicioIntevalo);
			Integer total = (Integer) totalMinutos / 60;
			Integer resto = (Integer) totalMinutos % 60;
			if (total < 10) {
				totalSexta = "0" + total.toString();
			} else {
				totalSexta = total.toString();
			}
			if (resto < 10) {
				totalSexta = totalSexta + ":0" + resto.toString();
			} else {
				totalSexta = totalSexta + ":" + resto.toString();
			}
		}else{
			totalSexta = null;
		}
		if((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoSexta() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoSexta() == "") ||  (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoSexta() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSexta() != "")){
			totalSexta = null;
		}
		
		//SABADO
		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaSabado() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaSabado() != ""
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSabado() != null
				&& solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSabado() != "") {
			if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaSabado() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioSaidaSabado() != "") {
				horaFinal = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaSabado().substring(0, 2)) * 60;
				horaFinal = horaFinal
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaSabado().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioEntradaSabado() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioEntradaSabado() != "") {
					horaIncial = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioEntradaSabado().substring(0, 2)) * 60;
					horaIncial = horaIncial
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioEntradaSabado()
											.substring(3));
				} else {
					solicitacaoHorarioEspecialEstudante
							.setHorarioSaidaSabado(null);
					solicitacaoHorarioEspecialEstudante
							.setHorarioEntradaSabado(null);
				}
			} else {
				solicitacaoHorarioEspecialEstudante
						.setHorarioSaidaSabado(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaSabado(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoSabado() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoSabado() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSabado().substring(0,
										2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSabado().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSabado() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoSabado() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoSabado().substring(
											0, 2)) * 60;
					inicioIntevalo = inicioIntevalo
							+ Integer
									.parseInt(solicitacaoHorarioEspecialEstudante
											.getHorarioSaidaAlmocoSabado()
											.substring(3));
				}
			}

			Integer totalMinutos = (horaFinal - horaIncial)
					- (finalIntevalo - inicioIntevalo);
			Integer total = (Integer) totalMinutos / 60;
			Integer resto = (Integer) totalMinutos % 60;
			if (total < 10) {
				totalSabado = "0" + total.toString();
			} else {
				totalSabado = total.toString();
			}
			if (resto < 10) {
				totalSabado = totalSabado + ":0" + resto.toString();
			} else {
				totalSabado = totalSabado + ":" + resto.toString();
			}
		}else{
			totalSabado = null;
		}
		if((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoSabado() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoSabado() == "") ||  (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoSabado() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSabado() != "")){
			totalSabado = null;
		}
		
		// TOTAL
		
		Integer totalHoras = 0;
		Integer totalMinutos = 0;
		Integer totalMinutosHoras;
		if(totalSegunda != null && totalSegunda != ""){
			totalHoras = totalHoras + (Integer.parseInt(totalSegunda.substring(0, 2)));
			totalMinutos = totalMinutos + (Integer.parseInt(totalSegunda.substring(3)));
		}
		if(totalTerca != null && totalTerca != ""){
			totalHoras = totalHoras + (Integer.parseInt(totalTerca.substring(0, 2)));
			totalMinutos = totalMinutos + (Integer.parseInt(totalTerca.substring(3)));
		}
		if(totalQuarta != null && totalQuarta != ""){
			totalHoras = totalHoras + (Integer.parseInt(totalQuarta.substring(0, 2)));
			totalMinutos = totalMinutos + (Integer.parseInt(totalQuarta.substring(3)));
		}
		if(totalQuinta != null && totalQuinta != ""){
			totalHoras = totalHoras + (Integer.parseInt(totalQuinta.substring(0, 2)));
			totalMinutos = totalMinutos + (Integer.parseInt(totalQuinta.substring(3)));
		}
		if(totalSexta != null && totalSexta != ""){
			totalHoras = totalHoras + (Integer.parseInt(totalSexta.substring(0, 2)));
			totalMinutos = totalMinutos + (Integer.parseInt(totalSexta.substring(3)));
		}
		if(totalSabado != null && totalSabado != ""){
			totalHoras = totalHoras + (Integer.parseInt(totalSabado.substring(0, 2)));
			totalMinutos = totalMinutos + (Integer.parseInt(totalSabado.substring(3)));
		}
		totalMinutosHoras = (Integer) totalMinutos / 60;
		totalMinutos = totalMinutos % 60;
		totalHoras = totalHoras + totalMinutosHoras;
		if (totalHoras < 10) {
			totalSemana = "0" + totalHoras.toString();
		} else {
			totalSemana = totalHoras.toString();
		}
		if (totalMinutos < 10) {
			totalSemana = totalSemana + ":0" + totalMinutos.toString();
		} else {
			totalSemana = totalSabado + ":" + totalMinutos.toString();
		}
	}
}
