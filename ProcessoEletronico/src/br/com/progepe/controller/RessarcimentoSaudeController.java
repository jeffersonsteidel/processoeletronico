package br.com.progepe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
import br.com.progepe.entity.TipoPlano;

public class RessarcimentoSaudeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private RessarcimentoSaude ressarcimentoSaude;
	private List<SelectItem> tiposPlanos = new ArrayList<SelectItem>();
	private List<Conjuge> conjuges = new ArrayList<Conjuge>();
	private List<Dependente> dependentes = new ArrayList<Dependente>();
	private Boolean indParticular = false;
	RessarcimentoSaudeContrato ressarcimentoSaudeContrato;

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

	public void abrirRessarcimentoSaude() {
		try {
			this.setDependentes(new ArrayList<Dependente>());
			this.setConjuges(new ArrayList<Conjuge>());
			ressarcimentoSaude = new RessarcimentoSaude();
			ressarcimentoSaude.setTipoPlano(new TipoPlano());
			buscarServidorLogado();
			listarTipoPlano();
			validarNomePlano();
			conjuges = RessarcimentoSaudeDAO.getInstance().listarConjugePorServidor(ressarcimentoSaude.getServidor());
			dependentes =  RessarcimentoSaudeDAO.getInstance().listarDependentePorServidor(ressarcimentoSaude.getServidor());
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
		if (!Constantes.TIPO_PLANO_PARTICULAR.equals(ressarcimentoSaude.getTipoPlano().getCodigo())) {
			this.setIndParticular(false);
		} else {
			this.setIndParticular(true);
		}
	}
	
	public void salvar (){
		RessarcimentoSaudeDAO.getInstance().saveRessarcimentoSaude(ressarcimentoSaude, dependentes, conjuges);
		this.setIndParticular(false);
		this.ressarcimentoSaude.setFiles(new ArrayList<RessarcimentoSaudeContrato>());
	}
}
