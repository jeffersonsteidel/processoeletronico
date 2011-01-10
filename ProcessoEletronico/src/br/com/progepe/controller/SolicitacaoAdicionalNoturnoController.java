package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.AdicionalNoturnoDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.AdicionalNoturno;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoAdicionalNoturno;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;

public class SolicitacaoAdicionalNoturnoController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno;
	private List<SelectItem> lotacoes = new ArrayList<SelectItem>();
	private List<SelectItem> servidoresCampus = new ArrayList<SelectItem>();
	private AdicionalNoturno adicionalNoturno;
	private List<SelectItem> professoresCampus = new ArrayList<SelectItem>();
	private List<AdicionalNoturno> listaAdicionalNoturno = new ArrayList<AdicionalNoturno>();
	private List<AdicionalNoturno> listaAdicionalTecnicos;
	private List<AdicionalNoturno> listaAdicionaisDocentes = new ArrayList<AdicionalNoturno>();
	private List<AdicionalNoturno> listaAdicionaisTecnicos = new ArrayList<AdicionalNoturno>();

	private Boolean indEncaminharDocente = false;
	private Boolean indEncaminharTecnico = false;

	public List<SelectItem> getLotacoes() {
		return lotacoes;
	}

	public void setLotacoes(List<SelectItem> lotacoes) {
		this.lotacoes = lotacoes;
	}

	public List<SelectItem> getServidoresCampus() {
		return servidoresCampus;
	}

	public void setServidoresCampus(List<SelectItem> servidoresCampus) {
		this.servidoresCampus = servidoresCampus;
	}

	public SolicitacaoAdicionalNoturno getSolicitacaoAdicionalNoturno() {
		return solicitacaoAdicionalNoturno;
	}

	public void setSolicitacaoAdicionalNoturno(
			SolicitacaoAdicionalNoturno solicitacaoAdicionalNoturno) {
		this.solicitacaoAdicionalNoturno = solicitacaoAdicionalNoturno;
	}

	public AdicionalNoturno getAdicionalNoturno() {
		return adicionalNoturno;
	}

	public void setAdicionalNoturno(AdicionalNoturno adicionalNoturno) {
		this.adicionalNoturno = adicionalNoturno;
	}

	public List<SelectItem> getProfessoresCampus() {
		return professoresCampus;
	}

	public void setProfessoresCampus(List<SelectItem> professoresCampus) {
		this.professoresCampus = professoresCampus;
	}

	public List<AdicionalNoturno> getListaAdicionalNoturno() {
		return listaAdicionalNoturno;
	}

	public void setListaAdicionalNoturno(
			List<AdicionalNoturno> listaAdicionalNoturno) {
		this.listaAdicionalNoturno = listaAdicionalNoturno;
	}

	public void setListaAdicionalTecnicos(
			List<AdicionalNoturno> listaAdicionalTecnicos) {
		this.listaAdicionalTecnicos = listaAdicionalTecnicos;
	}

	public List<AdicionalNoturno> getListaAdicionalTecnicos() {
		return listaAdicionalTecnicos;
	}

	public List<AdicionalNoturno> getListaAdicionaisDocentes() {
		return listaAdicionaisDocentes;
	}

	public void setListaAdicionaisDocentes(
			List<AdicionalNoturno> listaAdicionaisDocentes) {
		this.listaAdicionaisDocentes = listaAdicionaisDocentes;
	}

	public List<AdicionalNoturno> getListaAdicionaisTecnicos() {
		return listaAdicionaisTecnicos;
	}

	public void setListaAdicionaisTecnicos(
			List<AdicionalNoturno> listaAdicionaisTecnicos) {
		this.listaAdicionaisTecnicos = listaAdicionaisTecnicos;
	}

	public Boolean getIndEncaminharDocente() {
		return indEncaminharDocente;
	}

	public void setIndEncaminharDocente(Boolean indEncaminharDocente) {
		this.indEncaminharDocente = indEncaminharDocente;
	}

	public Boolean getIndEncaminharTecnico() {
		return indEncaminharTecnico;
	}

	public void setIndEncaminharTecnico(Boolean indEncaminharTecnico) {
		this.indEncaminharTecnico = indEncaminharTecnico;
	}

	public void abrirSolicitacaoAdicionalNoturnoTecnico() throws ParseException {
		try {
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			listaAdicionalTecnicos = new ArrayList<AdicionalNoturno>();
			listaAdicionalTecnicos.clear();
			adicionalNoturno = new AdicionalNoturno();
			adicionalNoturno.setServidor(new Servidor());
			solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
			buscarServidorLogado();
			listarLotacoes();
			solicitacaoAdicionalNoturno.setLotacao(solicitacaoAdicionalNoturno
					.getSolicitante().getLotacao());
			listarServidoresTecnicosCampus();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAdicionalNoturnoTecnico.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirSolicitacaoAdicionalNoturnoDocentes()
			throws ParseException {
		try {
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
			adicionalNoturno = new AdicionalNoturno();
			adicionalNoturno.setServidor(new Servidor());
			listaAdicionalNoturno = new ArrayList<AdicionalNoturno>();
			professoresCampus = new ArrayList<SelectItem>();
			buscarServidorLogado();
			listarLotacoes();
			solicitacaoAdicionalNoturno.setLotacao(solicitacaoAdicionalNoturno
					.getSolicitante().getLotacao());
			listarProfessoresCampus();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAdicionalNoturnoDocentes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirListarSolicitacaoAdicionalNoturnoTecnicos()
			throws ParseException {
		try {
			listaAdicionaisTecnicos = new ArrayList<AdicionalNoturno>();
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			solicitacaoAdicionalNoturno.setServidor(new Servidor());
			solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
			indEncaminharTecnico = false;
			buscarDiretor();
			listarLotacoes();
			solicitacaoAdicionalNoturno.setLotacao(solicitacaoAdicionalNoturno
					.getServidor().getLotacao());
			listarAdicionaisTecnicosAprovacao();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarSolicitacaoAdicionalNoturnoTecnicos.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abrirListarSolicitacaoAdicionalNoturnoDocentes()
			throws ParseException {
		try {
			listaAdicionaisDocentes = new ArrayList<AdicionalNoturno>();
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			solicitacaoAdicionalNoturno.setServidor(new Servidor());
			solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
			indEncaminharDocente = false;
			listarLotacoes();
			buscarDiretor();
			solicitacaoAdicionalNoturno.setLotacao(solicitacaoAdicionalNoturno
					.getServidor().getLotacao());
			listarAdicionaisDocentesAprovacao();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarSolicitacaoAdicionalNoturnoDocentes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public List<AdicionalNoturno> listarAdicionaisDocentesAprovacao()
			throws ParseException, IOException {
		listaAdicionaisDocentes.clear();
		List<SolicitacaoAdicionalNoturno> solicitacoes = new ArrayList<SolicitacaoAdicionalNoturno>();
		solicitacoes = AdicionalNoturnoDAO.getInstance()
				.carregarSolicitacaoAdicionalNoturnoDocentes(
						solicitacaoAdicionalNoturno.getLotacao(), true);
		solicitacaoAdicionalNoturno = solicitacoes.get(0);
		if (solicitacaoAdicionalNoturno == null) {
			listaAdicionaisDocentes = new ArrayList<AdicionalNoturno>();
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			solicitacaoAdicionalNoturno.setServidor(new Servidor());
			solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
			indEncaminharDocente = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Nenhum adicional encontrado para esse campus!",
					"Nenhum adicional encontrado para esse campus!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			List<AdicionalNoturno> listAdicionalNoturno = new ArrayList<AdicionalNoturno>();
			listAdicionalNoturno.addAll(solicitacaoAdicionalNoturno
					.getAdicionais());
			for (AdicionalNoturno adicional : listAdicionalNoturno) {
				adicional.setDiaSemana(pesquisarDiaSemana(adicional.getData()
						.getDay()));
				listaAdicionaisDocentes.add(adicional);
			}
			indEncaminharDocente = true;
		}
		buscarDiretor();
		return this.listaAdicionaisDocentes;
	}

	@SuppressWarnings("deprecation")
	public List<AdicionalNoturno> listarAdicionaisTecnicosAprovacao()
			throws ParseException, IOException {
		listaAdicionaisTecnicos.clear();
		solicitacaoAdicionalNoturno = AdicionalNoturnoDAO.getInstance()
				.carregarSolicitacaoAdicionalNoturno(
						solicitacaoAdicionalNoturno.getLotacao(), false);
		if (solicitacaoAdicionalNoturno == null) {
			listaAdicionaisTecnicos = new ArrayList<AdicionalNoturno>();
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			solicitacaoAdicionalNoturno.setServidor(new Servidor());
			solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
			indEncaminharTecnico = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Nenhum adicional encontrado para esse campus!",
					"Nenhum adicional encontrado para esse campus!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {

			List<AdicionalNoturno> listaAdicionaisTecnicosAprovacao = new ArrayList<AdicionalNoturno>();
			listaAdicionaisTecnicosAprovacao.addAll(solicitacaoAdicionalNoturno
					.getAdicionais());
			for (AdicionalNoturno adicional : listaAdicionaisTecnicosAprovacao) {
				adicional.setDiaSemana(pesquisarDiaSemana(adicional.getData()
						.getDay()));
				listaAdicionaisTecnicos.add(adicional);
			}
			indEncaminharTecnico = true;
		}
		buscarDiretor();
		return this.listaAdicionaisTecnicos;
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoAdicionalNoturno.setSolicitante(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoAdicionalNoturno.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoAdicionalNoturno.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoAdicionalNoturno.getSolicitante()));
	}

	public void buscarDiretor() throws IOException, ParseException {
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		solicitacaoAdicionalNoturno.setServidor(new Servidor());
		solicitacaoAdicionalNoturno.getServidor().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoAdicionalNoturno.setServidor(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoAdicionalNoturno.getServidor()));
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarLotacoes() {
		lotacoes = new ArrayList<SelectItem>();
		List<Lotacao> lotacaoList = new ArrayList<Lotacao>();
		lotacaoList = DAO.getInstance().list(Lotacao.class, "descricao");
		for (Lotacao lotacao : lotacaoList) {
			lotacoes.add(new SelectItem(lotacao.getCodigo(), lotacao
					.getDescricao()));
		}
		return lotacoes;
	}

	public List<SelectItem> listarServidoresTecnicosCampus() {
		servidoresCampus = new ArrayList<SelectItem>();
		List<Servidor> servidorList = new ArrayList<Servidor>();
		servidorList = ServidorDAO.getInstance().listTecnicosByCampus(
				solicitacaoAdicionalNoturno.getLotacao());

		for (Servidor item : servidorList) {
			servidoresCampus.add(new SelectItem(item.getCodigo(), item
					.getNome()));
		}
		return servidoresCampus;
	}

	public List<SelectItem> listarProfessoresCampus() {
		professoresCampus = new ArrayList<SelectItem>();
		List<Servidor> professorList = new ArrayList<Servidor>();
		professorList = ServidorDAO.getInstance().listDocentesByCampus(
				solicitacaoAdicionalNoturno.getLotacao());
		for (Servidor item : professorList) {
			professoresCampus.add(new SelectItem(item.getCodigo(), item
					.getNome()));
		}
		return professoresCampus;
	}

	@SuppressWarnings("deprecation")
	public void adicionarAdicionalTecnico() throws ParseException {
		Boolean ok = true;
		if (solicitacaoAdicionalNoturno.getLotacao() == null
				|| solicitacaoAdicionalNoturno.getLotacao().getCodigo() == null
				|| solicitacaoAdicionalNoturno.getLotacao().getCodigo() == 0) {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo Campus é obrigatório!",
					"Campo Campus é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getServidor() == null
				|| adicionalNoturno.getServidor().getCodigo() == null
				|| adicionalNoturno.getServidor().getCodigo() == 0) {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Servidor é obrigatório!",
					"Campo Servidor é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getData() == null) {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo Data é obrigatório!",
					"Campo Data é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getHoraInicial() == null
				|| adicionalNoturno.getHoraInicial() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Hora Inicial é obrigatório!",
					"Campo Hora Inicial é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getHoraFinal() == null
				|| adicionalNoturno.getHoraFinal() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Hora Final é obrigatório!",
					"Campo Hora Final é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getMotivo() == null
				|| adicionalNoturno.getMotivo() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo Motivo é obrigatório!",
					"Campo Motivo é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}

		// Validação e calculo de hora
		if (adicionalNoturno.getHoraInicial() != null
				&& adicionalNoturno.getHoraInicial() != ""
				&& adicionalNoturno.getHoraFinal() != null
				&& adicionalNoturno.getHoraFinal() != "") {
			Integer horaInicial = Integer.parseInt(adicionalNoturno
					.getHoraInicial().substring(0, 2));
			Integer horaFinal = Integer.parseInt(adicionalNoturno
					.getHoraFinal().substring(0, 2));

			if (horaInicial > 5 && horaInicial < 22) {
				ok = false;
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!",
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}

			if (horaFinal > 5 && horaFinal < 22) {
				ok = false;
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!",
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		}

		if (ok) {
			List<Servidor> tecnicoList = new ArrayList<Servidor>();
			tecnicoList = ServidorDAO.getInstance().listTecnicosByCampus(
					solicitacaoAdicionalNoturno.getLotacao());
			for (Servidor servidor : tecnicoList) {
				if (servidor.getCodigo().equals(
						adicionalNoturno.getServidor().getCodigo())) {
					adicionalNoturno.setServidor(servidor);
					break;
				}
			}
			adicionalNoturno.setDiaSemana(pesquisarDiaSemana(adicionalNoturno
					.getData().getDay()));
			adicionalNoturno.setIndAprovadoDiretor(false);
			listaAdicionalTecnicos.add(adicionalNoturno);
			adicionalNoturno = new AdicionalNoturno();
			adicionalNoturno.setServidor(new Servidor());
			adicionalNoturno.setMotivo("");
		}
	}

	@SuppressWarnings("deprecation")
	public void adicionarDocente() {
		Boolean ok = true;
		if (solicitacaoAdicionalNoturno.getLotacao() == null
				|| solicitacaoAdicionalNoturno.getLotacao().getCodigo() == null
				|| solicitacaoAdicionalNoturno.getLotacao().getCodigo() == 0) {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo Campus é obrigatório!",
					"Campo Campus é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getCurso() == null
				|| adicionalNoturno.getCurso() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo Curso é obrigatório!",
					"Campo Curso é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}

		if (adicionalNoturno.getTurma() == null
				|| adicionalNoturno.getTurma() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo Turma é obrigatório!",
					"Campo Turma é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getMateria() == null
				|| adicionalNoturno.getMateria() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Materia é obrigatório!",
					"Campo Matéria é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getServidor() == null
				|| adicionalNoturno.getServidor().getCodigo() == null
				|| adicionalNoturno.getServidor().getCodigo() == 0) {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Servidor é obrigatório!",
					"Campo Servidor é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getData() == null) {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Campo Data é obrigatório!",
					"Campo Data é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getHoraInicial() == null
				|| adicionalNoturno.getHoraInicial() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Hora Inicial é obrigatório!",
					"Campo Hora Inicial é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		if (adicionalNoturno.getHoraFinal() == null
				|| adicionalNoturno.getHoraFinal() == "") {
			ok = false;
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Campo Hora Final é obrigatório!",
					"Campo Hora Final é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}

		// Validação e calculo de hora
		if (adicionalNoturno.getHoraInicial() != null
				&& adicionalNoturno.getHoraInicial() != ""
				&& adicionalNoturno.getHoraFinal() != null
				&& adicionalNoturno.getHoraFinal() != "") {
			Integer horaInicial = Integer.parseInt(adicionalNoturno
					.getHoraInicial().substring(0, 2));
			Integer horaFinal = Integer.parseInt(adicionalNoturno
					.getHoraFinal().substring(0, 2));

			if (horaInicial > 5 && horaInicial < 22) {
				ok = false;
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!",
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}

			if (horaFinal > 5 && horaFinal < 22) {
				ok = false;
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!",
						"O Período de Adicional Noturno deve ser compreendido entre 22:00h e 05:00h!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		}
		if (ok) {
			List<Servidor> professorList = new ArrayList<Servidor>();
			professorList = ServidorDAO.getInstance().listDocentesByCampus(
					solicitacaoAdicionalNoturno.getLotacao());
			for (Servidor servidor : professorList) {
				if (servidor.getCodigo().equals(
						adicionalNoturno.getServidor().getCodigo())) {
					adicionalNoturno.setServidor(servidor);
					break;
				}
			}
			adicionalNoturno.setDiaSemana(pesquisarDiaSemana(adicionalNoturno
					.getData().getDay()));
			adicionalNoturno.setIndAprovadoDiretor(false);
			listaAdicionalNoturno.add(adicionalNoturno);
			adicionalNoturno = new AdicionalNoturno();
			adicionalNoturno.setServidor(new Servidor());
		}
	}

	public void salvarDocentes() throws Exception {
		solicitacaoAdicionalNoturno.getAdicionais().addAll(
				listaAdicionalNoturno);
		solicitacaoAdicionalNoturno.setIndDocente(true);
		solicitacaoAdicionalNoturno.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAdicionalNoturno.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_DOCENTES);
		solicitacaoAdicionalNoturno.setDataAbertura(new Date());
		DAO.getInstance().saveOrUpdate(solicitacaoAdicionalNoturno);
		listaAdicionalNoturno = new ArrayList<AdicionalNoturno>();
		adicionalNoturno = new AdicionalNoturno();
		adicionalNoturno.setServidor(new Servidor());
		solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
	}

	public void salvarAdicionalTecnico() throws Exception {
		solicitacaoAdicionalNoturno.getAdicionais().addAll(
				listaAdicionalTecnicos);
		solicitacaoAdicionalNoturno.setIndDocente(false);
		solicitacaoAdicionalNoturno.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAdicionalNoturno.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO_TECNICOS);
		solicitacaoAdicionalNoturno.setDataAbertura(new Date());
		DAO.getInstance().saveOrUpdate(solicitacaoAdicionalNoturno);
		solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
		listaAdicionalTecnicos = new ArrayList<AdicionalNoturno>();
		adicionalNoturno = new AdicionalNoturno();
		adicionalNoturno.setServidor(new Servidor());
		solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
	}

	public void encaminharDocentes() throws IOException, ParseException {
		solicitacaoAdicionalNoturno.getAdicionais().clear();
		solicitacaoAdicionalNoturno.getAdicionais().addAll(
				listaAdicionaisDocentes);
		solicitacaoAdicionalNoturno
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAdicionalNoturno.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		buscarDiretor();
		AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
				solicitacaoAdicionalNoturno);
		indEncaminharDocente = false;
	}

	public void encaminharTecnicos() throws IOException, ParseException {
		solicitacaoAdicionalNoturno.getAdicionais().clear();
		solicitacaoAdicionalNoturno.getAdicionais().addAll(
				listaAdicionaisTecnicos);
		solicitacaoAdicionalNoturno
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAdicionalNoturno.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		buscarDiretor();
		AdicionalNoturnoDAO.getInstance().saveOrUpdateAdicional(
				solicitacaoAdicionalNoturno);
		indEncaminharTecnico = false;
	}

	public void excluirDocente() {
		listaAdicionalNoturno.remove(adicionalNoturno);
		adicionalNoturno = new AdicionalNoturno();
		adicionalNoturno.setServidor(new Servidor());
	}

	public void excluir() {
		listaAdicionalTecnicos.remove(adicionalNoturno);
		adicionalNoturno = new AdicionalNoturno();
		adicionalNoturno.setServidor(new Servidor());
	}

	public static String pesquisarDiaSemana(int diaSemana) {
		String diaSemanaString = null;
		switch (diaSemana) {

		case 0: {
			diaSemanaString = "Domingo";
			break;
		}
		case 1: {
			diaSemanaString = "Segunda-Feira";
			break;
		}
		case 2: {
			diaSemanaString = "Terça-Feira";
			break;
		}
		case 3: {
			diaSemanaString = "Quarta-Feira";
			break;
		}
		case 4: {
			diaSemanaString = "Quinta-Feira";
			break;
		}
		case 5: {
			diaSemanaString = "Sexta-Feira";
			break;
		}
		case 6: {
			diaSemanaString = "Sábado";
			break;
		}

		}
		return diaSemanaString;
	}
}
