package br.com.progepe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.CursoDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.AdicionalNoturno;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Curso;
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
	private List<SelectItem> cursos = new ArrayList<SelectItem>();
	private List<SelectItem> professoresCampus = new ArrayList<SelectItem>();
	private List<AdicionalNoturno> listaAdicionalNoturno = new ArrayList<AdicionalNoturno>();
	
	private Boolean indTurmaDefinida = false;

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

	public List<SelectItem> getCursos() {
		return cursos;
	}

	public void setCursos(List<SelectItem> cursos) {
		this.cursos = cursos;
	}

	public List<SelectItem> getProfessoresCampus() {
		return professoresCampus;
	}

	public void setProfessoresCampus(List<SelectItem> professoresCampus) {
		this.professoresCampus = professoresCampus;
	}
	

	public Boolean getIndTurmaDefinida() {
		return indTurmaDefinida;
	}

	public void setIndTurmaDefinida(Boolean indTurmaDefinida) {
		this.indTurmaDefinida = indTurmaDefinida;
	}

	public List<AdicionalNoturno> getListaAdicionalNoturno() {
		return listaAdicionalNoturno;
	}

	public void setListaAdicionalNoturno(
			List<AdicionalNoturno> listaAdicionalNoturno) {
		this.listaAdicionalNoturno = listaAdicionalNoturno;
	}

	public void abrirSolicitacaoAdicionalNoturnoTecnico() throws ParseException {
		try {
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			adicionalNoturno = new AdicionalNoturno();
			adicionalNoturno.setServidor(new Servidor());
			adicionalNoturno
					.setSolicitacaoAdicionalNoturno(new SolicitacaoAdicionalNoturno());
			adicionalNoturno.getSolicitacaoAdicionalNoturno().setLotacao(
					new Lotacao());
			buscarServidorLogado();
			listarLotacoes();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAdicionalNoturnoTecnico.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public void adicionarAdicional() {
		solicitacaoAdicionalNoturno.getAdicionais().add(adicionalNoturno);
		listaAdicionalNoturno.add(adicionalNoturno);
		adicionalNoturno = new AdicionalNoturno();
		}

	public void salvarAdicional() throws IOException, ParseException {
		solicitacaoAdicionalNoturno.setDataAbertura(new Date());
		solicitacaoAdicionalNoturno.setDataAtendimento(null);
		solicitacaoAdicionalNoturno.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoAdicionalNoturno.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ADICIONAL_NOTURNO);
		solicitacaoAdicionalNoturno
				.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoAdicionalNoturno.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		DAO.getInstance().saveOrUpdate(solicitacaoAdicionalNoturno);
		solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
		buscarServidorLogado();
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
				adicionalNoturno.getSolicitacaoAdicionalNoturno().getLotacao());

		for (Servidor item : servidorList) {
			servidoresCampus.add(new SelectItem(item.getCodigo(), item
					.getNome()));
		}
		return servidoresCampus;
	}

	public void abrirSolicitacaoAdicionalNoturnoDocentes()
			throws ParseException {
		try {
			solicitacaoAdicionalNoturno = new SolicitacaoAdicionalNoturno();
			solicitacaoAdicionalNoturno.setLotacao(new Lotacao());
			adicionalNoturno = new AdicionalNoturno();
			adicionalNoturno.setServidor(new Servidor());
			solicitacaoAdicionalNoturno.setCurso(new Curso());
			buscarServidorLogado();
			listarLotacoes();
			indTurmaDefinida = false;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoAdicionalNoturnoDocentes.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> listarCursos() {

		cursos = new ArrayList<SelectItem>();
		List<Curso> cursoList = new ArrayList<Curso>();
		cursoList = CursoDAO.getInstance().listByCampus(
				solicitacaoAdicionalNoturno.getLotacao());
		for (Curso curso : cursoList) {
			cursos.add(new SelectItem(curso.getCodigo(), curso.getDescricao()));
		}
		return cursos;
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

	public void carregarCursosProfessoresPorLotacao() {
		listarProfessoresCampus();
		listarCursos();
	}

	public void confirmarTurma() {
		if (solicitacaoAdicionalNoturno.getLotacao() != null &&
			solicitacaoAdicionalNoturno.getLotacao().getCodigo() != 0 
			&& solicitacaoAdicionalNoturno.getCurso() != null && solicitacaoAdicionalNoturno.getCurso().getCodigo() != 0
			&& solicitacaoAdicionalNoturno.getTurma() != null 	&& solicitacaoAdicionalNoturno.getTurma() != ""){
			indTurmaDefinida = true;
		}else{
			indTurmaDefinida = false;
		}
	}

	public void adicionarDocente() {
		List<Servidor> professorList = new ArrayList<Servidor>();
		professorList = ServidorDAO.getInstance().listDocentesByCampus(
				solicitacaoAdicionalNoturno.getLotacao());
		for(Servidor servidor: professorList){
			if(servidor.getCodigo().equals(adicionalNoturno.getServidor().getCodigo())){
				adicionalNoturno.setServidor(servidor);
				break;
			}
		}
		listaAdicionalNoturno.add(adicionalNoturno);
		adicionalNoturno = new AdicionalNoturno();
		adicionalNoturno.setServidor(new Servidor());
//		adicionalNoturno.setMateria(null);
//		adicionalNoturno.setData(null);
//		adicionalNoturno.setHoraInicial(null);
//		adicionalNoturno.setHoraFinal(null);
		}
	public void excluirDocente(){
		for(AdicionalNoturno adicional: listaAdicionalNoturno){
			if(adicional.getCodigo().equals(adicionalNoturno.getCodigo())){
				adicionalNoturno = adicional;
				break;
			}
		}
		listaAdicionalNoturno.remove(adicionalNoturno);
	}
}
