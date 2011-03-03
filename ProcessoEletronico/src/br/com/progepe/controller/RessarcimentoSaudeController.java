package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.RessarcimentoSaudeDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.RessarcimentoSaude;
import br.com.progepe.entity.RessarcimentoSaudeContrato;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoPlano;

public class RessarcimentoSaudeController  {

	private RessarcimentoSaude ressarcimentoSaude;
	private List<SelectItem> tiposPlanos = new ArrayList<SelectItem>();
	private List<Conjuge> conjuges = new ArrayList<Conjuge>();
	private List<Dependente> dependentes = new ArrayList<Dependente>();

	private Boolean indParticular = false;
	private Boolean indGEAP = false;
	private Boolean indSindicato = false;
	private Boolean indRessarcimentoAtual = false;
	private Integer indAtual;

	RessarcimentoSaudeContrato ressarcimentoSaudeContrato;
	private List<RessarcimentoSaude> ressarcimentoList = new ArrayList<RessarcimentoSaude>();
	private RessarcimentoSaude ressarcimentoSaudeTemp;
	private Integer situacao;
	private List<SelectItem> status = new ArrayList<SelectItem>();
	private Boolean botaoHabilitado = false;
	private RessarcimentoSaude ressarcimentoAnterior;
	private Boolean existeAnterior;
	private Boolean ressarcimentoNovo;

	private Servidor atendente = new Servidor();
	
	private Boolean desabilitaBotao = true;

	public RessarcimentoSaude getRessarcimentoSaude() {
		return ressarcimentoSaude;
	}

	public void setRessarcimentoSaude(RessarcimentoSaude ressarcimentoSaude) {
		this.ressarcimentoSaude = ressarcimentoSaude;
	}

	public List<SelectItem> getTiposPlanos() {
		return tiposPlanos;
	}

	public void setTiposPlanos(List<SelectItem> tiposPlanos) {
		this.tiposPlanos = tiposPlanos;
	}

	public List<Conjuge> getConjuges() {
		return conjuges;
	}

	public void setConjuges(List<Conjuge> conjuges) {
		this.conjuges = conjuges;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public void setIndParticular(Boolean indParticular) {
		this.indParticular = indParticular;
	}

	public Boolean getIndParticular() {
		return indParticular;
	}

	public RessarcimentoSaudeContrato getRessarcimentoSaudeContrato() {
		return ressarcimentoSaudeContrato;
	}

	public void setRessarcimentoSaudeContrato(
			RessarcimentoSaudeContrato ressarcimentoSaudeContrato) {
		this.ressarcimentoSaudeContrato = ressarcimentoSaudeContrato;
	}

	public List<RessarcimentoSaude> getRessarcimentoList() {
		return ressarcimentoList;
	}

	public void setRessarcimentoList(List<RessarcimentoSaude> ressarcimentoList) {
		this.ressarcimentoList = ressarcimentoList;
	}

	public RessarcimentoSaude getRessarcimentoSaudeTemp() {
		return ressarcimentoSaudeTemp;
	}

	public void setRessarcimentoSaudeTemp(
			RessarcimentoSaude ressarcimentoSaudeTemp) {
		this.ressarcimentoSaudeTemp = ressarcimentoSaudeTemp;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public List<SelectItem> getStatus() {
		return status;
	}

	public void setStatus(List<SelectItem> status) {
		this.status = status;
	}

	public Boolean getBotaoHabilitado() {
		return botaoHabilitado;
	}

	public void setBotaoHabilitado(Boolean botaoHabilitado) {
		this.botaoHabilitado = botaoHabilitado;
	}

	public RessarcimentoSaude getRessarcimentoAnterior() {
		return ressarcimentoAnterior;
	}

	public void setRessarcimentoAnterior(
			RessarcimentoSaude ressarcimentoAnterior) {
		this.ressarcimentoAnterior = ressarcimentoAnterior;
	}

	public Boolean getExisteAnterior() {
		return existeAnterior;
	}

	public void setExisteAnterior(Boolean existeAnterior) {
		this.existeAnterior = existeAnterior;
	}

	public Boolean getIndGEAP() {
		return indGEAP;
	}

	public void setIndGEAP(Boolean indGEAP) {
		this.indGEAP = indGEAP;
	}

	public Boolean getIndSindicato() {
		return indSindicato;
	}

	public void setIndSindicato(Boolean indSindicato) {
		this.indSindicato = indSindicato;
	}

	public Boolean getRessarcimentoNovo() {
		return ressarcimentoNovo;
	}

	public void setRessarcimentoNovo(Boolean ressarcimentoNovo) {
		this.ressarcimentoNovo = ressarcimentoNovo;
	}

	public Boolean getIndRessarcimentoAtual() {
		return indRessarcimentoAtual;
	}

	public void setIndRessarcimentoAtual(Boolean indRessarcimentoAtual) {
		this.indRessarcimentoAtual = indRessarcimentoAtual;
	}

	public Integer getIndAtual() {
		return indAtual;
	}

	public void setIndAtual(Integer indAtual) {
		this.indAtual = indAtual;
	}

	public Servidor getAtendente() {
		return atendente;
	}

	public void setAtendente(Servidor atendente) {
		this.atendente = atendente;
	}

	
	public Boolean getDesabilitaBotao() {
		return desabilitaBotao;
	}

	public void setDesabilitaBotao(Boolean desabilitaBotao) {
		this.desabilitaBotao = desabilitaBotao;
	}

	public void abrirRessarcimentoSaude() {
		try {
			desabilitaBotao = false;
			indGEAP = false;
			indParticular = false;
			indSindicato = false;
			indRessarcimentoAtual = false;
			atendente = new Servidor();
			existeAnterior = false;
			ressarcimentoNovo = true;
			this.setDependentes(new ArrayList<Dependente>());
			this.setConjuges(new ArrayList<Conjuge>());
			ressarcimentoSaude = new RessarcimentoSaude();
			ressarcimentoSaude.setTipoPlano(new TipoPlano());
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude.getTipoPlano().setCodigo(
					Constantes.TIPO_PLANO_SINDICATO);
			ressarcimentoSaude
					.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
			buscarServidorLogado();
			listarTipoPlano();
			validarTipoPlano();
			List<RessarcimentoSaude> ressarcimentoList = RessarcimentoSaudeDAO
					.getInstance().recuperarRessarcimentosAnteriores(
							ressarcimentoSaude.getServidor());
			if (ressarcimentoList != null && !ressarcimentoList.isEmpty()) {
				existeAnterior = true;
				ressarcimentoNovo = false;
				ressarcimentoAnterior = ressarcimentoList.get(0);
				for (RessarcimentoSaude ressarcimento : ressarcimentoList) {
					if (ressarcimento.getCodigo() > ressarcimentoAnterior
							.getCodigo()) {
						ressarcimentoAnterior = ressarcimento;
						if (Constantes.TIPO_PLANO_PARTICULAR
								.equals(ressarcimentoAnterior.getTipoPlano()
										.getCodigo())) {
							this.setIndParticular(true);
						}
					}
				}
				if (ressarcimentoSaude.getAtendente() != null
						&& !ressarcimentoSaude.getAtendente().equals(0)) {
					atendente.setSiape(ressarcimentoAnterior.getAtendente());
					atendente = ServidorDAO.getInstance().refreshBySiape(
							atendente);
				}
			}
			conjuges = RessarcimentoSaudeDAO.getInstance()
					.listarConjugePorServidor(ressarcimentoSaude.getServidor(),
							false);
			dependentes = RessarcimentoSaudeDAO.getInstance()
					.listarDependentePorServidor(
							ressarcimentoSaude.getServidor(), false);
			if (null == dependentes) {
				dependentes = new ArrayList<Dependente>();
			}
			if (null == conjuges) {
				conjuges = new ArrayList<Conjuge>();
			}
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("ressarcimentoSaude.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTipoPlano() {
		tiposPlanos = new ArrayList<SelectItem>();
		List<TipoPlano> tipoPlanoList = new ArrayList<TipoPlano>();
		tipoPlanoList = DAO.getInstance().list(TipoPlano.class, "descricao");
		for (TipoPlano tipoPlano : tipoPlanoList) {
			tiposPlanos.add(new SelectItem(tipoPlano.getCodigo(), tipoPlano
					.getDescricao()));
		}
		return tiposPlanos;
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		ressarcimentoSaude.setServidor(new Servidor());
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		ressarcimentoSaude.getServidor().setSiape(siapeAutenticado.getSiape());
		ressarcimentoSaude.setServidor(ServidorDAO.getInstance()
				.refreshBySiape(ressarcimentoSaude.getServidor()));
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		ressarcimentoSaudeContrato = new RessarcimentoSaudeContrato();
		ressarcimentoSaudeContrato.setPagina(item.getData());
		ressarcimentoSaude.getFiles().add(ressarcimentoSaudeContrato);
	}

	public void paint(OutputStream stream, Object object) throws Exception {
		if (ressarcimentoSaude.getFiles().size() > 0) {
			stream.write(ressarcimentoSaude.getFiles().get((Integer) object)
					.getPagina());
		}
	}

	public void validarTipoPlano() {
		if (Constantes.TIPO_PLANO_PARTICULAR.equals(ressarcimentoSaude
				.getTipoPlano().getCodigo())) {
			this.setIndParticular(true);
			this.setIndGEAP(false);
			this.setIndSindicato(false);
			ressarcimentoSaude.setDataAdesao(null);
			ressarcimentoSaude.setNumeroContrato(null);
			ressarcimentoSaude.setNomePlano(null);
			ressarcimentoSaude
					.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
		} else if (Constantes.TIPO_PLANO_GEAPE.equals(ressarcimentoSaude
				.getTipoPlano().getCodigo())) {
			this.setIndParticular(false);
			this.setIndGEAP(true);
			this.setIndSindicato(false);
			ressarcimentoSaude.setDataAdesao(null);
			ressarcimentoSaude.setNumeroContrato(null);
			ressarcimentoSaude.setNomePlano(null);
			ressarcimentoSaude
					.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
		} else if (Constantes.TIPO_PLANO_SINDICATO.equals(ressarcimentoSaude
				.getTipoPlano().getCodigo())) {
			this.setIndParticular(false);
			this.setIndGEAP(false);
			this.setIndSindicato(true);
			ressarcimentoSaude.setDataAdesao(null);
			ressarcimentoSaude.setNumeroContrato(null);
			ressarcimentoSaude.setNomePlano(null);
			ressarcimentoSaude
					.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
		}
	}

	public void salvar() throws IOException, ParseException {
		if (ressarcimentoSaude.getFiles().isEmpty() && !indSindicato) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"É obrigatório adicionar o Contrato!",
					"É obrigatório adicionar o Contrato!");
			FacesContext.getCurrentInstance().addMessage("", message);

		} else {
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude.getStatus().setCodigo(
					Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
			ressarcimentoSaude.setIndAtual(true);
			ressarcimentoSaude.setDataAbertura(new Date());
			ressarcimentoSaude.setJustificativa(null);
			ressarcimentoSaude.setAtendente(null);
			if (indSindicato) {
				ressarcimentoSaude.setNomePlano(null);
				ressarcimentoSaude.setNumeroContrato(null);
			}
			for (int i = 0; i < dependentes.size(); i++) {
				if (dependentes.get(i).getIndRessarcimentoSaude().equals(false)) {
					dependentes.get(i).setIndRessarcimentoSaude(null);
				}
			}
			for (int i = 0; i < conjuges.size(); i++) {
				if (conjuges.get(i).getIndRessarcimentoSaude().equals(false)) {
					conjuges.get(i).setIndRessarcimentoSaude(null);
				}
			}
			RessarcimentoSaudeDAO.getInstance().saveRessarcimentoSaude(
					ressarcimentoSaude, dependentes, conjuges);
			desabilitaBotao = true;
			indGEAP = false;
			indParticular = false;
			indSindicato = false;
			indRessarcimentoAtual = true;
			ressarcimentoSaude = new RessarcimentoSaude();
			ressarcimentoSaude.setTipoPlano(new TipoPlano());
			ressarcimentoSaude.getTipoPlano().setCodigo(
					Constantes.TIPO_PLANO_PARTICULAR);
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			this.ressarcimentoSaude
					.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
			buscarServidorLogado();
			existeAnterior = false;
			ressarcimentoNovo = true;
			this.setDependentes(new ArrayList<Dependente>());
			this.setConjuges(new ArrayList<Conjuge>());
			buscarServidorLogado();
			listarTipoPlano();
			validarTipoPlano();
			List<RessarcimentoSaude> ressarcimentoList = RessarcimentoSaudeDAO
					.getInstance().recuperarRessarcimentosAnteriores(
							ressarcimentoSaude.getServidor());
			if (ressarcimentoList != null && !ressarcimentoList.isEmpty()) {
				existeAnterior = true;
				ressarcimentoNovo = false;
				ressarcimentoAnterior = ressarcimentoList.get(0);
				for (RessarcimentoSaude ressarcimento : ressarcimentoList) {
					if (ressarcimento.getCodigo() > ressarcimentoAnterior
							.getCodigo()) {
						ressarcimentoAnterior = ressarcimento;
						if (Constantes.TIPO_PLANO_PARTICULAR
								.equals(ressarcimentoAnterior.getTipoPlano()
										.getCodigo())) {
							this.setIndParticular(true);
						}
					}
				}
			}
			conjuges = RessarcimentoSaudeDAO.getInstance()
					.listarConjugePorServidor(ressarcimentoSaude.getServidor(),
							false);
			dependentes = RessarcimentoSaudeDAO.getInstance()
					.listarDependentePorServidor(
							ressarcimentoSaude.getServidor(), false);
			if (null == dependentes) {
				dependentes = new ArrayList<Dependente>();
			}
			if (null == conjuges) {
				conjuges = new ArrayList<Conjuge>();
			}
		}
	}

	public void pesquisar() {
		ressarcimentoList = RessarcimentoSaudeDAO.getInstance().listByFilter(
				ressarcimentoSaudeTemp, situacao, indAtual);
	}

	public void carregar() {
		ressarcimentoSaude = new RessarcimentoSaude();
		FacesContext context = FacesContext.getCurrentInstance();
		ressarcimentoSaude = (RessarcimentoSaude) context.getExternalContext()
				.getRequestMap().get("list");
		ressarcimentoSaude = (RessarcimentoSaude) DAO.getInstance().refresh(
				ressarcimentoSaude);
		botaoHabilitado = false;
		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(ressarcimentoSaude
				.getStatus().getCodigo()) && ressarcimentoSaude.getIndAtual()) {
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude.getStatus().setCodigo(
					Constantes.STATUS_SOLICITACAO_EM_ANALISE);
			Autenticacao siapeAutenticado = (Autenticacao) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuarioLogado");
			ressarcimentoSaude.setAtendente(siapeAutenticado.getSiape());
			ressarcimentoSaude.setDataAtendimento(new Date());
			RessarcimentoSaudeDAO.getInstance().updateRessarcimento(
					ressarcimentoSaude);
			botaoHabilitado = true;
		} else if (!Constantes.STATUS_SOLICITACAO_ENCAMINHADO
				.equals(ressarcimentoSaude.getStatus().getCodigo())) {
			atendente = new Servidor();
			atendente.setSiape(ressarcimentoSaude.getAtendente());
			atendente = ServidorDAO.getInstance().refreshByFilter(atendente);
		}
		conjuges.clear();
		dependentes.clear();
		conjuges = RessarcimentoSaudeDAO.getInstance()
				.listarConjugePorServidor(ressarcimentoSaude.getServidor(),
						true);
		dependentes = RessarcimentoSaudeDAO.getInstance()
				.listarDependentePorServidor(ressarcimentoSaude.getServidor(),
						true);
		if (null == dependentes) {
			dependentes = new ArrayList<Dependente>();
		}
		if (null == conjuges) {
			conjuges = new ArrayList<Conjuge>();
		}
		ressarcimentoSaude.setFiles(RessarcimentoSaudeDAO.getInstance()
				.getContratos(ressarcimentoSaude));

	}

	public void abrirListar() {
		try {
			situacao = Constantes.TODOS;
			ressarcimentoSaudeTemp = new RessarcimentoSaude();
			ressarcimentoSaudeTemp.setServidor(new Servidor());
			ressarcimentoSaudeTemp.setTipoPlano(new TipoPlano());
			ressarcimentoSaudeTemp.setStatus(new StatusSolicitacao());
			ressarcimentoList = new ArrayList<RessarcimentoSaude>();
			ressarcimentoSaude = new RessarcimentoSaude();
			ressarcimentoSaude.setServidor(new Servidor());
			ressarcimentoSaude.setTipoPlano(new TipoPlano());
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			this.setDependentes(new ArrayList<Dependente>());
			this.setConjuges(new ArrayList<Conjuge>());
			ressarcimentoSaude
					.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
			listarTipoPlano();
			listarStatus();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarRessarcimentoSaude.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deferir() {
		if (ressarcimentoSaude.getJustificativa().length() > 250) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa deve ter no maxímo 250 caracteres!",
					"O campo Justificativa deve ter no maxímo 250 caracteres!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude.getStatus().setCodigo(
					Constantes.STATUS_SOLICITACAO_DEFERIDO);
			Autenticacao siapeAutenticado = (Autenticacao) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuarioLogado");
			ressarcimentoSaude.setAtendente(siapeAutenticado.getSiape());
			ressarcimentoSaude.setDataFechamento(new Date());
			DAO.getInstance().update(ressarcimentoSaude);
			ressarcimentoList = new ArrayList<RessarcimentoSaude>();
			ressarcimentoSaude = new RessarcimentoSaude();
			ressarcimentoSaude.setServidor(new Servidor());
			ressarcimentoSaude.setTipoPlano(new TipoPlano());
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude
					.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
			pesquisar();
			botaoHabilitado = false;
		}
	}

	public void indeferir() {
		if (ressarcimentoSaude.getJustificativa() == null
				|| ressarcimentoSaude.getJustificativa().equals("")) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa é obrigatório!",
					"O campo Justificativa é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else if (ressarcimentoSaude.getJustificativa().length() > 250) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa deve ter no maxímo 250 caracteres!",
					"O campo Justificativa deve ter no maxímo 250 caracteres!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude.getStatus().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
			ressarcimentoSaude.setDataFechamento(new Date());
			DAO.getInstance().update(ressarcimentoSaude);
			ressarcimentoList = new ArrayList<RessarcimentoSaude>();
			pesquisar();
			botaoHabilitado = false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarStatus() {
		status = new ArrayList<SelectItem>();
		List<StatusSolicitacao> statusSolicitacoesList = new ArrayList<StatusSolicitacao>();
		statusSolicitacoesList = DAO.getInstance().list(
				StatusSolicitacao.class, "descricao");
		for (StatusSolicitacao statusSolicitacao : statusSolicitacoesList) {
			status.add(new SelectItem(statusSolicitacao.getCodigo(),
					statusSolicitacao.getDescricao()));
		}
		return status;
	}

	public void desativarRessarcimento() throws Exception {
		ressarcimentoAnterior.setIndAtual(false);
		RessarcimentoSaudeDAO.getInstance().updateRessarcimento(
				ressarcimentoAnterior);
		ressarcimentoNovo = true;
		this.setDependentes(new ArrayList<Dependente>());
		this.setConjuges(new ArrayList<Conjuge>());
		ressarcimentoSaude = new RessarcimentoSaude();
		ressarcimentoSaude.setTipoPlano(new TipoPlano());
		ressarcimentoSaude.setStatus(new StatusSolicitacao());
		ressarcimentoSaude.getTipoPlano().setCodigo(
				Constantes.TIPO_PLANO_PARTICULAR);
		buscarServidorLogado();
		listarTipoPlano();
		validarTipoPlano();
		conjuges = RessarcimentoSaudeDAO.getInstance()
				.listarConjugePorServidor(ressarcimentoSaude.getServidor(),
						false);
		dependentes = RessarcimentoSaudeDAO.getInstance()
				.listarDependentePorServidor(ressarcimentoSaude.getServidor(),
						false);
		if (null == dependentes) {
			dependentes = new ArrayList<Dependente>();
		}
		if (null == conjuges) {
			conjuges = new ArrayList<Conjuge>();
		}
	}

	public void atualizarDependentes() {
		for (int i = 0; i < dependentes.size(); i++) {
			if (dependentes.get(i).getIndRessarcimentoSaude().equals(false)) {
				dependentes.get(i).setIndRessarcimentoSaude(null);
			}
		}
		for (int i = 0; i < conjuges.size(); i++) {
			if (conjuges.get(i).getIndRessarcimentoSaude().equals(false)) {
				conjuges.get(i).setIndRessarcimentoSaude(null);
			}
		}
		RessarcimentoSaudeDAO.getInstance().updateLists(dependentes, conjuges);
		conjuges = RessarcimentoSaudeDAO.getInstance()
				.listarConjugePorServidor(ressarcimentoSaude.getServidor(),
						false);
		dependentes = RessarcimentoSaudeDAO.getInstance()
				.listarDependentePorServidor(ressarcimentoSaude.getServidor(),
						false);
	}
}
