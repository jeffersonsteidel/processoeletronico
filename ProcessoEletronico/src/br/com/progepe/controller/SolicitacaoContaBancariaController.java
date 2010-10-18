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
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoContaBancaria;

public class SolicitacaoContaBancariaController implements Serializable {
	private static final long serialVersionUID = -333995781063775201L;
	
	private SolicitacaoContaBancaria solicitacaoContaBancaria;
	private List<SelectItem> bancos = new ArrayList<SelectItem>();
	DAO dao = new DAO();
	public static final Long CAIXA_ECONOMICA_FEDERAL = 104L;
	private Boolean indPoupanca = false;

	public SolicitacaoContaBancaria getSolicitacaoContaBancaria() {
		return solicitacaoContaBancaria;
	}

	public void setSolicitacaoContaBancaria(
			SolicitacaoContaBancaria solicitacaoContaBancaria) {
		this.solicitacaoContaBancaria = solicitacaoContaBancaria;
	}
	
	public List<SelectItem> getBancos() {
		return bancos;
	}

	public void setBancos(List<SelectItem> bancos) {
		this.bancos = bancos;
	}	
	
	public Boolean getIndPoupanca() {
		return indPoupanca;
	}

	public void setIndPoupanca(Boolean indPoupanca) {
		this.indPoupanca = indPoupanca;
	}

	public void abrirSolicitacaoContaBancaria() throws ParseException {
		try {
			buscarServidorLogado();
			solicitacaoContaBancaria.setContaBancaria(new ContaBancaria());
			solicitacaoContaBancaria.getContaBancaria().setBanco(new Banco());
			listarBancos();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("solicitacaoContaBancaria.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SelectItem> listarBancos() {
		bancos = new ArrayList<SelectItem>();
		List<Banco> bancoList = new ArrayList<Banco>();
		bancoList = dao.list(Banco.class, "descricao");
		for (Banco banco : bancoList) {
			bancos.add(new SelectItem(banco.getCodigo(), banco.getDescricao()));
		}
		return bancos;
	}
	
	public void isPoupanca() {
		if ((CAIXA_ECONOMICA_FEDERAL).equals(solicitacaoContaBancaria.getContaBancaria()
				.getBanco().getCodigo())) {
			indPoupanca = true;
		} else {
			indPoupanca = false;
		}
	}
	
	public void buscarServidorLogado() throws IOException, ParseException{
		solicitacaoContaBancaria = new SolicitacaoContaBancaria();
		solicitacaoContaBancaria.setSolicitante(new Servidor());
		solicitacaoContaBancaria.getSolicitante().setContaBancaria(new ContaBancaria());
		solicitacaoContaBancaria.getSolicitante().getContaBancaria().setBanco(new Banco());
		
		Autenticacao siapeAutenticado = (Autenticacao) FacesContext.getCurrentInstance()
		.getExternalContext().getSessionMap().get("usuarioLogado");

		solicitacaoContaBancaria.getSolicitante().setSiape(siapeAutenticado.getSiape());
		ServidorDAO servidorDAO = new ServidorDAO();
		solicitacaoContaBancaria.setSolicitante(servidorDAO.refreshBySiape(solicitacaoContaBancaria.getSolicitante()));

		if((new Long(104)).equals(solicitacaoContaBancaria.getSolicitante().getContaBancaria().getBanco().getCodigo())){
			indPoupanca = true;
		}else{
			indPoupanca = false;
		}
	}
}
