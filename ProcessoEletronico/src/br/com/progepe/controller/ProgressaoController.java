package br.com.progepe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ProgressaoDAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Classe;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.Progressao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;
import br.com.progepe.entity.TipoProgressao;

public class ProgressaoController  {
	private static final long serialVersionUID = -333995781063775201L;

	private Progressao progressao;
	private List<Progressao> progressaoList;
	private List<SelectItem> classes = new ArrayList<SelectItem>();
	private List<SelectItem> padroes = new ArrayList<SelectItem>();
	private List<SelectItem> tiposProgressoes = new ArrayList<SelectItem>();
	private Boolean indCapacitacao;
	private List<ServidorTitulacao> titulacoes = new ArrayList<ServidorTitulacao>();

	public Progressao getProgressao() {
		return progressao;
	}

	public void setProgressao(Progressao progressao) {
		this.progressao = progressao;
	}

	public List<Progressao> getProgressaoList() {
		return progressaoList;
	}

	public void setProgressaoList(List<Progressao> progressaoList) {
		this.progressaoList = progressaoList;
	}

	public List<SelectItem> getClasses() {
		return classes;
	}

	public void setClasses(List<SelectItem> classes) {
		this.classes = classes;
	}

	public List<SelectItem> getPadroes() {
		return padroes;
	}

	public void setPadroes(List<SelectItem> padroes) {
		this.padroes = padroes;
	}

	public Boolean getIndCapacitacao() {
		return indCapacitacao;
	}

	public void setIndCapacitacao(Boolean indCapacitacao) {
		this.indCapacitacao = indCapacitacao;
	}

	public List<SelectItem> getTiposProgressoes() {
		return tiposProgressoes;
	}

	public void setTiposProgressoes(List<SelectItem> tiposProgressoes) {
		this.tiposProgressoes = tiposProgressoes;
	}

	public List<ServidorTitulacao> getTitulacoes() {
		return titulacoes;
	}

	public void setTitulacoes(List<ServidorTitulacao> titulacoes) {
		this.titulacoes = titulacoes;
	}

	@SuppressWarnings("unchecked")
	public void abrirListarProgressao() throws ParseException {
		try {
			progressao = new Progressao();
			progressaoList = new ArrayList<Progressao>();
			progressao.getServidor().setCargo(new Cargo());
			progressaoList = (List<Progressao>) DAO.getInstance().list(Progressao.class,
					"codigo");
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listarProgressoes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void abrirCadastrarProgressao() throws ParseException {
		try {
			indCapacitacao = false;
			titulacoes.clear();
			listarPadroes();
			listarTiposProgressoes();
			progressao = new Progressao();
			progressao.setServidor(new Servidor());
			progressao.setClasseAntiga(new Classe());
			progressao.setClasseNova(new Classe());
			progressao.setPadraoAntigo(new Padrao());
			progressao.setPadraoNovo(new Padrao());
			progressao.setTipoProgressao(new TipoProgressao());
			progressao.setServidorTitulacao(new ServidorTitulacao());
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("cadastrarProgressao.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTiposProgressoes() {
		tiposProgressoes = new ArrayList<SelectItem>();
		List<TipoProgressao> tipoProgressaoList = new ArrayList<TipoProgressao>();
		tipoProgressaoList = DAO.getInstance().list(TipoProgressao.class,
				"descricao");
		for (TipoProgressao tipoProgressao : tipoProgressaoList) {
			tiposProgressoes.add(new SelectItem(tipoProgressao.getCodigo(),
					tipoProgressao.getDescricao()));
		}
		return tiposProgressoes;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarPadroes() {
		padroes = new ArrayList<SelectItem>();
		List<Padrao> padraoList = new ArrayList<Padrao>();
		padraoList = DAO.getInstance().list(Padrao.class, "nivel");
		for (Padrao padrao : padraoList) {
			padroes.add(new SelectItem(padrao.getCodigo(), padrao.getNivel()
					.toString()));
		}
		return padroes;
	}
	
	public void calcularProximaProgressao(){
		if(progressao.getDataProgressao() != null){
			Calendar calendar = Calendar.getInstance();  
			   calendar.setTime(progressao.getDataProgressao());  
			   calendar.add(Calendar.MONTH, Constantes.QUANTIDADE_MESES_PROGRESSAO);  
			progressao.setDataProximaProgressao(calendar.getTime());
		}
	}

	public void salvar() {
		DAO.getInstance().save(progressao);
		progressao = new Progressao();
		progressao.setClasseAntiga(progressao.getServidor().getCargo()
				.getClasse());
		progressao.setClasseNova(new Classe());
		progressao.setPadraoAntigo(progressao.getServidor().getPadrao());
		progressao.setPadraoNovo(new Padrao());
		progressao.setServidorTitulacao(new ServidorTitulacao());
	}

	public void buscarServidor() throws IOException, ParseException {
		progressao.setServidor(ServidorDAO.getInstance().refreshBySiape(
				progressao.getServidor()));
		if (progressao.getServidor() == null) {
			progressao.setServidor(new Servidor());
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Siape inválido!",
					"Siape inválido!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}
	
	public void carregar() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		progressao = (Progressao) context.getExternalContext().getRequestMap()
				.get("list");
		listarTiposProgressoes();
		listarPadroes();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarProgressao.jsp");
	}


	public void validarTipoProgressao() {
		if (progressao.getTipoProgressao() != null
				&& progressao.getTipoProgressao().getCodigo()
						.equals(Constantes.TIPO_PROGRESSAO_CAPACITACAO)) {
			indCapacitacao = true;
			if (progressao.getServidor().getCodigo() == null || Constantes.ZERO.equals(progressao.getServidor().getCodigo())) {
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Informe o Siape do Servidor!",
						"Informe o Siape do Servidor!");
				FacesContext.getCurrentInstance().addMessage("", message);
				progressao.setTipoProgressao(new TipoProgressao());
			} else {
				titulacoes = ProgressaoDAO.getInstance()
						.listTitulacoesServidor(progressao.getServidor());
				if(titulacoes.isEmpty()){
					FacesMessage message = new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Não existem Titulações para este Servidor!",
							"Não existem Titulações para este Servidor!");
					FacesContext.getCurrentInstance().addMessage("", message);
				}
			}
		} else {
			indCapacitacao = false;
			titulacoes.clear();
		}
	}
}