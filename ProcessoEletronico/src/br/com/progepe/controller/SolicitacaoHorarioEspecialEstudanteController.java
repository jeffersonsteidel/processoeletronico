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

	public SolicitacaoHorarioEspecialEstudante getSolicitacaoHorarioEspecialEstudante() {
		return solicitacaoHorarioEspecialEstudante;
	}

	public void setSolicitacaoHorarioEspecialEstudante(
			SolicitacaoHorarioEspecialEstudante solicitacaoHorarioEspecialEstudante) {
		this.solicitacaoHorarioEspecialEstudante = solicitacaoHorarioEspecialEstudante;
	}

	public void abrirSolicitacaoHorarioEspecialEstudante()
			throws ParseException {
		try {
			solicitacaoHorarioEspecialEstudante = new SolicitacaoHorarioEspecialEstudante();
			solicitacaoHorarioEspecialEstudante
					.setFiles(new ArrayList<SolicitacaoHorarioEspecialEstudante>());
			buscarServidorLogado();
			solicitacaoHorarioEspecialEstudante.setTotalSemana("00:00");
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
		FacesMessage message;
		if (solicitacaoHorarioEspecialEstudante.getDeclaracaoMatricula() == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"É necessário adicionar a Declaração de Matricula!",
					"É necessário adicionar a Declaração de Matricula!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else if (!(Constantes.REGIME_DEDICACAO_EXCLUSIVA
				.equals(solicitacaoHorarioEspecialEstudante.getSolicitante()
						.getRegimeTrabalho().getCodigo()))
				&& !(solicitacaoHorarioEspecialEstudante
						.getSolicitante()
						.getRegimeTrabalho()
						.getCodigo()
						.toString() +":00").equals(solicitacaoHorarioEspecialEstudante
								.getTotalSemana())) {
			message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O Horário de Compensação deve ser igual ao do Regime de Trabalho!",
					"O Horário de Compensação deve ser igual ao do Regime de Trabalho!");
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
			solicitacaoHorarioEspecialEstudante.setTotalSemana("00:00");
		}
	}

	public void calcularTempo() {
		int finalIntevalo = 0;
		int inicioIntevalo = 0;
		int horaFinal = 0;
		int horaIncial = 0;

		// SEGUNDA
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
				solicitacaoHorarioEspecialEstudante.setTotalSegunda("0"
						+ total.toString());
			} else {
				solicitacaoHorarioEspecialEstudante.setTotalSegunda(total
						.toString());
			}
			if (resto < 10) {
				solicitacaoHorarioEspecialEstudante
						.setTotalSegunda(solicitacaoHorarioEspecialEstudante
								.getTotalSegunda() + ":0" + resto.toString());
			} else {
				solicitacaoHorarioEspecialEstudante
						.setTotalSegunda(solicitacaoHorarioEspecialEstudante
								.getTotalSegunda() + ":" + resto.toString());
			}
		} else {
			solicitacaoHorarioEspecialEstudante.setTotalSegunda(null);
		}
		if ((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoSegunda() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoSegunda() == "")
				|| (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoSegunda() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSegunda() != "")) {
			solicitacaoHorarioEspecialEstudante.setTotalSegunda(null);
		}

		// TERCA
		 finalIntevalo = 0;
		 inicioIntevalo = 0;
		 horaFinal = 0;
		 horaIncial = 0;
		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaTerca() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaTerca() != ""
				&& solicitacaoHorarioEspecialEstudante.getHorarioEntradaTerca() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioEntradaTerca() != "") {
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
				solicitacaoHorarioEspecialEstudante.setHorarioSaidaTerca(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaTerca(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoTerca() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoTerca() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoTerca().substring(0, 2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoTerca().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoTerca() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoTerca() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoTerca().substring(0,
											2)) * 60;
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
				solicitacaoHorarioEspecialEstudante.setTotalTerca("0"
						+ total.toString());
			} else {
				solicitacaoHorarioEspecialEstudante.setTotalTerca(total
						.toString());
			}
			if (resto < 10) {
				solicitacaoHorarioEspecialEstudante
						.setTotalTerca(solicitacaoHorarioEspecialEstudante
								.getTotalTerca() + ":0" + resto.toString());
			} else {
				solicitacaoHorarioEspecialEstudante
						.setTotalTerca(solicitacaoHorarioEspecialEstudante
								.getTotalTerca() + ":" + resto.toString());
			}
		} else {
			solicitacaoHorarioEspecialEstudante.setTotalTerca(null);
		}
		if ((solicitacaoHorarioEspecialEstudante.getHorarioRetornoAlmocoTerca() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoTerca() == "")
				|| (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoTerca() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoTerca() != "")) {
			solicitacaoHorarioEspecialEstudante.setTotalTerca(null);
		}

		// QUARTA
		 finalIntevalo = 0;
		 inicioIntevalo = 0;
		 horaFinal = 0;
		 horaIncial = 0;
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
				solicitacaoHorarioEspecialEstudante.setHorarioSaidaQuarta(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaQuarta(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoQuarta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoQuarta() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuarta()
								.substring(0, 2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuarta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuarta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoQuarta() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoQuarta().substring(0,
											2)) * 60;
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
				solicitacaoHorarioEspecialEstudante.setTotalQuarta("0"
						+ total.toString());
			} else {
				solicitacaoHorarioEspecialEstudante.setTotalQuarta(total
						.toString());
			}
			if (resto < 10) {
				solicitacaoHorarioEspecialEstudante
						.setTotalQuarta(solicitacaoHorarioEspecialEstudante
								.getTotalQuarta() + ":0" + resto.toString());
			} else {
				solicitacaoHorarioEspecialEstudante
						.setTotalQuarta(solicitacaoHorarioEspecialEstudante
								.getTotalQuarta() + ":" + resto.toString());
			}
		} else {
			solicitacaoHorarioEspecialEstudante.setTotalQuarta(null);
		}
		if ((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoQuarta() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoQuarta() == "")
				|| (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoQuarta() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuarta() != "")) {
			solicitacaoHorarioEspecialEstudante.setTotalQuarta(null);
		}

		// QUINTA
		 finalIntevalo = 0;
		 inicioIntevalo = 0;
		 horaFinal = 0;
		 horaIncial = 0;
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
				solicitacaoHorarioEspecialEstudante.setHorarioSaidaQuinta(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaQuinta(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoQuinta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoQuinta() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuinta()
								.substring(0, 2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoQuinta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuinta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoQuinta() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoQuinta().substring(0,
											2)) * 60;
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
				solicitacaoHorarioEspecialEstudante.setTotalQuinta("0"
						+ total.toString());
			} else {
				solicitacaoHorarioEspecialEstudante.setTotalQuinta(total
						.toString());
			}
			if (resto < 10) {
				solicitacaoHorarioEspecialEstudante
						.setTotalQuinta(solicitacaoHorarioEspecialEstudante
								.getTotalQuinta() + ":0" + resto.toString());
			} else {
				solicitacaoHorarioEspecialEstudante
						.setTotalQuinta(solicitacaoHorarioEspecialEstudante
								.getTotalQuinta() + ":" + resto.toString());
			}
		} else {
			solicitacaoHorarioEspecialEstudante.setTotalQuinta(null);
		}
		if ((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoQuinta() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoQuinta() == "")
				|| (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoQuinta() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoQuinta() != "")) {
			solicitacaoHorarioEspecialEstudante.setTotalQuinta(null);
		}

		// SEXTA
		 finalIntevalo = 0;
		 inicioIntevalo = 0;
		 horaFinal = 0;
		 horaIncial = 0;
		if (solicitacaoHorarioEspecialEstudante.getHorarioSaidaSexta() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioSaidaSexta() != ""
				&& solicitacaoHorarioEspecialEstudante.getHorarioEntradaSexta() != null
				&& solicitacaoHorarioEspecialEstudante.getHorarioEntradaSexta() != "") {
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
				solicitacaoHorarioEspecialEstudante.setHorarioSaidaSexta(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaSexta(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoSexta() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoSexta() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSexta().substring(0, 2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSexta().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSexta() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoSexta() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoSexta().substring(0,
											2)) * 60;
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
				solicitacaoHorarioEspecialEstudante.setTotalSexta("0"
						+ total.toString());
			} else {
				solicitacaoHorarioEspecialEstudante.setTotalSexta(total
						.toString());
			}
			if (resto < 10) {
				solicitacaoHorarioEspecialEstudante
						.setTotalSexta(solicitacaoHorarioEspecialEstudante
								.getTotalSexta() + ":0" + resto.toString());
			} else {
				solicitacaoHorarioEspecialEstudante
						.setTotalSexta(solicitacaoHorarioEspecialEstudante
								.getTotalSexta() + ":" + resto.toString());
			}
		} else {
			solicitacaoHorarioEspecialEstudante.setTotalSexta(null);
		}
		if ((solicitacaoHorarioEspecialEstudante.getHorarioRetornoAlmocoSexta() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoSexta() == "")
				|| (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoSexta() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSexta() != "")) {
			solicitacaoHorarioEspecialEstudante.setTotalSexta(null);
		}

		// SABADO
		 finalIntevalo = 0;
		 inicioIntevalo = 0;
		 horaFinal = 0;
		 horaIncial = 0;
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
				solicitacaoHorarioEspecialEstudante.setHorarioSaidaSabado(null);
				solicitacaoHorarioEspecialEstudante
						.setHorarioEntradaSabado(null);
			}

			if (solicitacaoHorarioEspecialEstudante
					.getHorarioRetornoAlmocoSabado() != null
					&& solicitacaoHorarioEspecialEstudante
							.getHorarioRetornoAlmocoSabado() != "") {
				finalIntevalo = Integer
						.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSabado()
								.substring(0, 2)) * 60;
				finalIntevalo = finalIntevalo
						+ Integer.parseInt(solicitacaoHorarioEspecialEstudante
								.getHorarioRetornoAlmocoSabado().substring(3));
				if (solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSabado() != null
						&& solicitacaoHorarioEspecialEstudante
								.getHorarioSaidaAlmocoSabado() != "") {
					inicioIntevalo = Integer
							.parseInt(solicitacaoHorarioEspecialEstudante
									.getHorarioSaidaAlmocoSabado().substring(0,
											2)) * 60;
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
				solicitacaoHorarioEspecialEstudante.setTotalSabado("0"
						+ total.toString());
			} else {
				solicitacaoHorarioEspecialEstudante.setTotalSabado(total
						.toString());
			}
			if (resto < 10) {
				solicitacaoHorarioEspecialEstudante
						.setTotalSabado(solicitacaoHorarioEspecialEstudante
								.getTotalSabado() + ":0" + resto.toString());
			} else {
				solicitacaoHorarioEspecialEstudante
						.setTotalSabado(solicitacaoHorarioEspecialEstudante
								.getTotalSabado() + ":" + resto.toString());
			}
		} else {
			solicitacaoHorarioEspecialEstudante.setTotalSabado(null);
		}
		if ((solicitacaoHorarioEspecialEstudante
				.getHorarioRetornoAlmocoSabado() != "" && solicitacaoHorarioEspecialEstudante
				.getHorarioSaidaAlmocoSabado() == "")
				|| (solicitacaoHorarioEspecialEstudante
						.getHorarioRetornoAlmocoSabado() == "" && solicitacaoHorarioEspecialEstudante
						.getHorarioSaidaAlmocoSabado() != "")) {
			solicitacaoHorarioEspecialEstudante.setTotalSabado(null);
		}

		// TOTAL

		Integer totalHoras = 0;
		Integer totalMinutos = 0;
		Integer totalMinutosHoras;
		if (solicitacaoHorarioEspecialEstudante.getTotalSegunda() != null
				&& solicitacaoHorarioEspecialEstudante.getTotalSegunda() != "") {
			totalHoras = totalHoras
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalSegunda().substring(0, 2)));
			totalMinutos = totalMinutos
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalSegunda().substring(3)));
		}
		if (solicitacaoHorarioEspecialEstudante.getTotalTerca() != null
				&& solicitacaoHorarioEspecialEstudante.getTotalTerca() != "") {
			totalHoras = totalHoras
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalTerca().substring(0, 2)));
			totalMinutos = totalMinutos
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalTerca().substring(3)));
		}
		if (solicitacaoHorarioEspecialEstudante.getTotalQuarta() != null
				&& solicitacaoHorarioEspecialEstudante.getTotalQuarta() != "") {
			totalHoras = totalHoras
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalQuarta().substring(0, 2)));
			totalMinutos = totalMinutos
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalQuarta().substring(3)));
		}
		if (solicitacaoHorarioEspecialEstudante.getTotalQuinta() != null
				&& solicitacaoHorarioEspecialEstudante.getTotalQuinta() != "") {
			totalHoras = totalHoras
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalQuinta().substring(0, 2)));
			totalMinutos = totalMinutos
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalQuinta().substring(3)));
		}
		if (solicitacaoHorarioEspecialEstudante.getTotalSexta() != null
				&& solicitacaoHorarioEspecialEstudante.getTotalSexta() != "") {
			totalHoras = totalHoras
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalSexta().substring(0, 2)));
			totalMinutos = totalMinutos
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalSexta().substring(3)));
		}
		if (solicitacaoHorarioEspecialEstudante.getTotalSabado() != null
				&& solicitacaoHorarioEspecialEstudante.getTotalSabado() != "") {
			totalHoras = totalHoras
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalSabado().substring(0, 2)));
			totalMinutos = totalMinutos
					+ (Integer.parseInt(solicitacaoHorarioEspecialEstudante
							.getTotalSabado().substring(3)));
		}
		totalMinutosHoras = (Integer) totalMinutos / 60;
		totalMinutos = totalMinutos % 60;
		totalHoras = totalHoras + totalMinutosHoras;
		if (totalHoras < 10) {
			solicitacaoHorarioEspecialEstudante.setTotalSemana("0"
					+ totalHoras.toString());
		} else {
			solicitacaoHorarioEspecialEstudante.setTotalSemana(totalHoras
					.toString());
		}
		if (totalMinutos < 10) {
			solicitacaoHorarioEspecialEstudante
					.setTotalSemana(solicitacaoHorarioEspecialEstudante
							.getTotalSemana() + ":0" + totalMinutos.toString());
		} else {
			solicitacaoHorarioEspecialEstudante
					.setTotalSemana(solicitacaoHorarioEspecialEstudante
							.getTotalSemana() + ":" + totalMinutos.toString());
		}
	}
}
