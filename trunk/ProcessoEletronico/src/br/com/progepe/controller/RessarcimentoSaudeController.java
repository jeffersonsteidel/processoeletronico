package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
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

public class RessarcimentoSaudeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private RessarcimentoSaude ressarcimentoSaude;
	private List<SelectItem> tiposPlanos = new ArrayList<SelectItem>();
	private List<Conjuge> conjuges = new ArrayList<Conjuge>();
	private List<Dependente> dependentes = new ArrayList<Dependente>();
	private Boolean indParticular = false;
	RessarcimentoSaudeContrato ressarcimentoSaudeContrato;
	private List<RessarcimentoSaude> ressarcimentoList = new ArrayList<RessarcimentoSaude>();
	private RessarcimentoSaude ressarcimentoSaudeTemp;
	private Integer situacao;
	private List<SelectItem> status = new ArrayList<SelectItem>();
	private Boolean botaoHabilitado = false;
	private RessarcimentoSaude ressarcimentoAnterior;
	private Boolean existeAnterior;

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

	public void abrirRessarcimentoSaude() {
		try {
			existeAnterior = false;
			this.setDependentes(new ArrayList<Dependente>());
			this.setConjuges(new ArrayList<Conjuge>());
			ressarcimentoSaude = new RessarcimentoSaude();
			ressarcimentoSaude.setTipoPlano(new TipoPlano());
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			buscarServidorLogado();
			listarTipoPlano();
			validarNomePlano();
			List<RessarcimentoSaude> ressarcimentoList = RessarcimentoSaudeDAO
					.getInstance().recuperarRessarcimentosAnteriores(
							ressarcimentoSaude.getServidor());
			if (ressarcimentoList != null && !ressarcimentoList.isEmpty()) {
				existeAnterior = true;
				ressarcimentoAnterior = ressarcimentoList.get(0);
				for (RessarcimentoSaude ressarcimento : ressarcimentoList) {
					if (ressarcimento.getCodigo() > ressarcimentoAnterior
							.getCodigo()) {
						ressarcimentoAnterior = ressarcimento;
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

	public void validarNomePlano() {
		if (!Constantes.TIPO_PLANO_PARTICULAR.equals(ressarcimentoSaude
				.getTipoPlano().getCodigo())) {
			this.setIndParticular(false);
		} else {
			this.setIndParticular(true);
		}
	}

	public void salvar() throws IOException, ParseException {
		ressarcimentoSaude.setStatus(new StatusSolicitacao());
		ressarcimentoSaude.getStatus().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		RessarcimentoSaudeDAO.getInstance().saveRessarcimentoSaude(
				ressarcimentoSaude, dependentes, conjuges);
		this.setIndParticular(false);
		ressarcimentoSaude = new RessarcimentoSaude();
		ressarcimentoSaude.setTipoPlano(new TipoPlano());
		ressarcimentoSaude.setStatus(new StatusSolicitacao());
		this.ressarcimentoSaude
				.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
		buscarServidorLogado();
	}

	public void pesquisar() {
		Boolean validacao = true;
		if (!Constantes.STATUS_SOLICITACAO_ENCAMINHADO
				.equals(ressarcimentoSaudeTemp.getStatus().getCodigo())) {
			if (ressarcimentoSaudeTemp.getServidor().getSiape() == null
					|| ressarcimentoSaudeTemp.getServidor().getSiape() == 0) {
				validacao = false;
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Siape do Servidor é obrigatório!",
						"O campo Siape do Servidor é obrigatório!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}
			if (ressarcimentoSaudeTemp.getTipoPlano().getCodigo() == null
					|| ressarcimentoSaudeTemp.getTipoPlano().getCodigo() == 0) {
				validacao = false;
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"O campo Tipo do Plano é obrigatório!",
						"O campo Tipo do Plano é obrigatório!");
				FacesContext.getCurrentInstance().addMessage("", message);
			}

		}
		if (validacao) {
			ressarcimentoList = RessarcimentoSaudeDAO.getInstance()
					.listByFilter(ressarcimentoSaudeTemp, situacao);
		}
	}

	public void carregar() {
		FacesContext context = FacesContext.getCurrentInstance();
		ressarcimentoSaude = (RessarcimentoSaude) context.getExternalContext()
				.getRequestMap().get("list");
		botaoHabilitado = false;
		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(ressarcimentoSaude
				.getStatus().getCodigo())) {
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude.getStatus().setCodigo(
					Constantes.STATUS_SOLICITACAO_EM_ANALISE);
			botaoHabilitado = true;
		}
		validarNomePlano();
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
		ressarcimentoSaude.setStatus(new StatusSolicitacao());
		ressarcimentoSaude.getStatus().setCodigo(
				Constantes.STATUS_SOLICITACAO_DEFERIDO);
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

	public void indeferir() {
		if (ressarcimentoSaude.getJustificativa() == null || ressarcimentoSaude.getJustificativa().equals("")) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"O campo Justificativa é obrigatório!",
					"O campo Justificativa é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} else {
			ressarcimentoSaude.setStatus(new StatusSolicitacao());
			ressarcimentoSaude.getStatus().setCodigo(
					Constantes.STATUS_SOLICITACAO_INDEFERIDO);
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

}
