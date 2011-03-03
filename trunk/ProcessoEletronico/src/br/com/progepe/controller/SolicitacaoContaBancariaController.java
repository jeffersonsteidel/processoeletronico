package br.com.progepe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SolicitacaoContaBancaria;
import br.com.progepe.entity.StatusSolicitacao;
import br.com.progepe.entity.TipoSolicitacao;
import br.com.progepe.jsfUtil.EnviarEmail;

public class SolicitacaoContaBancariaController  {

	private SolicitacaoContaBancaria solicitacaoContaBancaria;
	private List<SelectItem> bancos = new ArrayList<SelectItem>();
	private Boolean indPoupanca = false;
	
	private Boolean desabilitaBotao = true;

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

	public Boolean getDesabilitaBotao() {
		return desabilitaBotao;
	}

	public void setDesabilitaBotao(Boolean desabilitaBotao) {
		this.desabilitaBotao = desabilitaBotao;
	}

	public void abrirSolicitacaoContaBancaria() throws ParseException {
		try {
			desabilitaBotao = false;
			solicitacaoContaBancaria = new SolicitacaoContaBancaria();
			solicitacaoContaBancaria.setNovoBanco(new Banco());
			buscarServidorLogado();
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
		bancoList = DAO.getInstance().list(Banco.class, "descricao");
		for (Banco banco : bancoList) {
			bancos.add(new SelectItem(banco.getCodigo(), banco.getDescricao()));
		}
		return bancos;
	}

	public void isPoupanca() {
		if ((Constantes.CAIXA_ECONOMICA_FEDERAL)
				.equals(solicitacaoContaBancaria.getNovoBanco().getCodigo())) {
			indPoupanca = true;
		} else {
			indPoupanca = false;
		}
	}

	public void buscarServidorLogado() throws IOException, ParseException {
		solicitacaoContaBancaria.setSolicitante(new Servidor());
		solicitacaoContaBancaria.getSolicitante().setContaBancaria(
				new ContaBancaria());
		solicitacaoContaBancaria.getSolicitante().getContaBancaria()
				.setBanco(new Banco());

		Autenticacao siapeAutenticado = (Autenticacao) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");

		solicitacaoContaBancaria.getSolicitante().setSiape(
				siapeAutenticado.getSiape());
		solicitacaoContaBancaria.setSolicitante(ServidorDAO.getInstance()
				.refreshBySiape(solicitacaoContaBancaria.getSolicitante()));
	}

	public void salvar() throws IOException, ParseException {
		solicitacaoContaBancaria.setDataAbertura(new Date());
		solicitacaoContaBancaria.setDataAtendimento(null);
		solicitacaoContaBancaria.setTipoSolicitacao(new TipoSolicitacao());
		solicitacaoContaBancaria.getTipoSolicitacao().setCodigo(
				Constantes.TIPO_SOLICITACAO_ALTERAR_CONTA_BANCARIA);
		solicitacaoContaBancaria.setStatusSolicitacao(new StatusSolicitacao());
		solicitacaoContaBancaria.getStatusSolicitacao().setCodigo(
				Constantes.STATUS_SOLICITACAO_ENCAMINHADO);
		DAO.getInstance().saveOrUpdate(solicitacaoContaBancaria);
		desabilitaBotao = true;
		EnviarEmail enviarEmail = new EnviarEmail();
		enviarEmail.enviarEmailSolicitacao(solicitacaoContaBancaria);
		solicitacaoContaBancaria = new SolicitacaoContaBancaria();
		solicitacaoContaBancaria.setNovoBanco(new Banco());
		buscarServidorLogado();
	}
}
