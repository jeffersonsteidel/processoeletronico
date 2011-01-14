package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.RessarcimentoSaude;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.TipoPlano;

public class RessarcimentoSaudeController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;

	private RessarcimentoSaude ressarcimentoSaude;
	private List<SelectItem> tiposPlanos = new ArrayList<SelectItem>();

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

	public void abrirRessarcimentoSaude() {
		try {
			ressarcimentoSaude = new RessarcimentoSaude();
			ressarcimentoSaude.setTipoPlano(new TipoPlano());
			buscarServidorLogado();
			listarTipoPlano();
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

}
