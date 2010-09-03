package br.com.progepe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.CargoDAO;
import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.CorPeleDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.EstadoCivilDAO;
import br.com.progepe.dao.EstadoDAO;
import br.com.progepe.dao.FuncaoDAO;
import br.com.progepe.dao.GrauParentescoDAO;
import br.com.progepe.dao.GrupoSanguineoDAO;
import br.com.progepe.dao.LotacaoDAO;
import br.com.progepe.dao.PadraoDAO;
import br.com.progepe.dao.PaisDAO;
import br.com.progepe.dao.RegimeTrabalhoDAO;
import br.com.progepe.dao.SituacaoFuncionalDAO;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Classe;
import br.com.progepe.entity.Conjugue;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.CorPele;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.EstadoCivil;
import br.com.progepe.entity.Funcao;
import br.com.progepe.entity.GrauParentesco;
import br.com.progepe.entity.Grupo;
import br.com.progepe.entity.GrupoSanguineo;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.Pais;
import br.com.progepe.entity.RegimeTrabalho;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;
import br.com.progepe.entity.SituacaoFuncional;
import br.com.progepe.entity.Telefone;
import br.com.progepe.entity.Titulacao;

public class ServidorController {

	public static final Long CAIXA_ECONOMICA_FEDERAL = 20L;

	private Servidor servidor;
	private List<Servidor> servidores;
	private Dependente dependente;
	private List<Dependente> dependentes;
	private Titulacao titulacao;
	private List<ServidorTitulacao> titulacaoList;
	private ServidorTitulacao servidorTitulacao;

	private List<SelectItem> cargos;
	private List<SelectItem> classes;
	private List<SelectItem> bancos;
	private List<SelectItem> coresPeles;
	private List<SelectItem> estadosCivis;
	private List<SelectItem> funcoes;
	private List<SelectItem> gruposSanguineos;
	private List<SelectItem> estados;
	private List<SelectItem> ufs;
	private List<SelectItem> cidades;
	private List<SelectItem> lotacoes;
	private List<SelectItem> paises;
	private List<SelectItem> situacoesFuncionais;
	private List<SelectItem> padroes;
	private List<SelectItem> regimesTrabalhos;
	private List<SelectItem> grauParentescos;
	private List<SelectItem> titulacoes;

	DAO dao = new DAO();

	private Boolean servidorEstrangeiro = false;
	private Boolean indPoupanca = false;
	private Boolean indTitulacaoEstrangeira = false;

	public Servidor getPessoa() {
		return servidor;
	}

	public void setPessoa(Servidor pessoa) {
		this.servidor = pessoa;
	}

	public List<SelectItem> getEstados() {
		return estados;
	}

	public void setEstados(List<SelectItem> estados) {
		this.estados = estados;
	}

	public List<SelectItem> getCidades() {
		return cidades;
	}

	public void setCidades(List<SelectItem> cidades) {
		this.cidades = cidades;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}

	public List<SelectItem> getLotacoes() {
		return lotacoes;
	}

	public void setLotacoes(List<SelectItem> lotacoes) {
		this.lotacoes = lotacoes;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public List<SelectItem> getPaises() {
		return paises;
	}

	public void setPaises(List<SelectItem> paises) {
		this.paises = paises;
	}

	public List<SelectItem> getEstadosCivis() {
		return estadosCivis;
	}

	public void setEstadosCivis(List<SelectItem> estadosCivis) {
		this.estadosCivis = estadosCivis;
	}

	public List<SelectItem> getSituacoesFuncionais() {
		return situacoesFuncionais;
	}

	public void setSituacoesFuncionais(List<SelectItem> situacoesFuncionais) {
		this.situacoesFuncionais = situacoesFuncionais;
	}

	public List<SelectItem> getPadroes() {
		return padroes;
	}

	public void setPadroes(List<SelectItem> padroes) {
		this.padroes = padroes;
	}

	public List<SelectItem> getRegimesTrabalhos() {
		return regimesTrabalhos;
	}

	public void setRegimesTrabalhos(List<SelectItem> regimesTrabalhos) {
		this.regimesTrabalhos = regimesTrabalhos;
	}

	public List<SelectItem> getGrauParentescos() {
		return grauParentescos;
	}

	public void setGrauParentescos(List<SelectItem> grauParentescos) {
		this.grauParentescos = grauParentescos;
	}

	public List<SelectItem> getCargos() {
		return cargos;
	}

	public void setCargos(List<SelectItem> cargos) {
		this.cargos = cargos;
	}

	public List<SelectItem> getBancos() {
		return bancos;
	}

	public void setBancos(List<SelectItem> bancos) {
		this.bancos = bancos;
	}

	public List<SelectItem> getCoresPeles() {
		return coresPeles;
	}

	public void setCoresPeles(List<SelectItem> coresPeles) {
		this.coresPeles = coresPeles;
	}

	public List<SelectItem> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<SelectItem> funcoes) {
		this.funcoes = funcoes;
	}

	public List<SelectItem> getGruposSanguineos() {
		return gruposSanguineos;
	}

	public void setGruposSanguineos(List<SelectItem> gruposSanguineos) {
		this.gruposSanguineos = gruposSanguineos;
	}

	public List<SelectItem> getUfs() {
		return ufs;
	}

	public void setUfs(List<SelectItem> ufs) {
		this.ufs = ufs;
	}

	public Boolean getServidorEstrangeiro() {
		return servidorEstrangeiro;
	}

	public void setServidorEstrangeiro(Boolean servidorEstrangeiro) {
		this.servidorEstrangeiro = servidorEstrangeiro;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Titulacao getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}

	public List<ServidorTitulacao> getTitulacaoList() {
		return titulacaoList;
	}

	public void setTitulacaoList(List<ServidorTitulacao> titulacaoList) {
		this.titulacaoList = titulacaoList;
	}

	public List<SelectItem> getTitulacoes() {
		return titulacoes;
	}

	public void setTitulacoes(List<SelectItem> titulacoes) {
		this.titulacoes = titulacoes;
	}

	public ServidorTitulacao getServidorTitulacao() {
		return servidorTitulacao;
	}

	public void setServidorTitulacao(ServidorTitulacao servidorTitulacao) {
		this.servidorTitulacao = servidorTitulacao;
	}

	public Boolean getIndPoupanca() {
		return indPoupanca;
	}

	public void setIndPoupanca(Boolean indPoupanca) {
		this.indPoupanca = indPoupanca;
	}

	public List<SelectItem> getClasses() {
		return classes;
	}

	public void setClasses(List<SelectItem> classes) {
		this.classes = classes;
	}

	public Boolean getIndTitulacaoEstrangeira() {
		return indTitulacaoEstrangeira;
	}

	public void setIndTitulacaoEstrangeira(Boolean indTitulacaoEstrangeira) {
		this.indTitulacaoEstrangeira = indTitulacaoEstrangeira;
	}

	public void cadastrar() throws IOException {
		servidor = new Servidor();
		servidor.setCargo(new Cargo());
		servidor.getCargo().setClasse(new Classe());
		servidor.setCidadeNascimento(new Cidade());
		servidor.getCidadeNascimento().setEstado(new Estado());
		servidor.setConjugue(new Conjugue());
		servidor.getConjugue().setDocumento(new Documento());
		servidor.getConjugue().getDocumento().setCarteiraUf(new Estado());
		servidor.getConjugue().getDocumento().setRgUf(new Estado());
		servidor.getConjugue().getDocumento().setTituloUf(new Estado());
		servidor.getConjugue().setCidadeNascimento(new Cidade());
		servidor.getConjugue().getCidadeNascimento().setEstado(new Estado());
		servidor.setContaBancaria(new ContaBancaria());
		servidor.getContaBancaria().setBanco(new Banco());
		servidor.setCorPele(new CorPele());
		servidor.setDocumento(new Documento());
		servidor.getDocumento().setCarteiraUf(new Estado());
		servidor.getDocumento().setRgUf(new Estado());
		servidor.getDocumento().setTituloUf(new Estado());
		servidor.setDependentes(new HashSet<Dependente>());
		servidor.setEndereco(new Endereco());
		servidor.getEndereco().setCidade(new Cidade());
		servidor.getEndereco().getCidade().setEstado(new Estado());
		servidor.setEstadoCivil(new EstadoCivil());
		servidor.setFuncao(new Funcao());
		servidor.setGrupo(new Grupo());
		servidor.setGrupoSanguineo(new GrupoSanguineo());
		servidor.setLotacao(new Lotacao());
		servidor.setPadrao(new Padrao());
		servidor.setRegimeTrabalho(new RegimeTrabalho());
		servidor.setSituacaoFuncional(new SituacaoFuncional());
		servidor.setTelefone(new Telefone());
		servidor.setCelular(new Telefone());
		dependente = new Dependente();
		dependente.setGrauParentesco(new GrauParentesco());
		dependentes = new ArrayList<Dependente>();
		servidorTitulacao = new ServidorTitulacao();
		servidorTitulacao.setTitulacao(new Titulacao());
		servidorTitulacao.setServidor(new Servidor());
		servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
		servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
				new Estado());
		servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
		servidorTitulacao.setPais(new Pais());
		titulacaoList = new ArrayList<ServidorTitulacao>();
		dependente.setDocumento(new Documento());
		dependente.getDocumento().setCarteiraUf(new Estado());
		dependente.getDocumento().setRgUf(new Estado());
		dependente.getDocumento().setTituloUf(new Estado());

		cargos = new ArrayList<SelectItem>();
		classes = new ArrayList<SelectItem>();
		ufs = new ArrayList<SelectItem>();
		cidades = new ArrayList<SelectItem>();
		estados = new ArrayList<SelectItem>();
		bancos = new ArrayList<SelectItem>();
		coresPeles = new ArrayList<SelectItem>();
		estadosCivis = new ArrayList<SelectItem>();
		funcoes = new ArrayList<SelectItem>();
		lotacoes = new ArrayList<SelectItem>();
		gruposSanguineos = new ArrayList<SelectItem>();
		padroes = new ArrayList<SelectItem>();
		regimesTrabalhos = new ArrayList<SelectItem>();
		situacoesFuncionais = new ArrayList<SelectItem>();
		paises = new ArrayList<SelectItem>();
		grauParentescos = new ArrayList<SelectItem>();
		titulacoes = new ArrayList<SelectItem>();

		listarBancos();
		listarGrauParentesco();
		listarEstados();
		listarUfs();

		listarLotacoes();
		listarPadroes();
		listarSituacoesFuncionais();
		listarFuncoes();
		listarCargos();
		listarRegimesTrabalhos();

		listarGrupoSanguineo();
		listarCorPele();
		listarEstadosCivis();

		listarTitulacoes();

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarServidor.jsp");
	}

	public List<SelectItem> listarUfs() {
		EstadoDAO estadoDAO = new EstadoDAO();
		ufs = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = estadoDAO.list();
		for (Estado estado : estadoList) {
			ufs.add(new SelectItem(estado.getCodigo(), estado.getUf()));
		}
		return ufs;
	}

	public List<SelectItem> listarEstados() {
		EstadoDAO estadoDAO = new EstadoDAO();
		estados = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = estadoDAO.list();
		for (Estado estado : estadoList) {
			estados.add(new SelectItem(estado.getCodigo(), estado
					.getDescricao()));
		}
		return estados;
	}

	public List<SelectItem> listarCidadesNascimentoServidor() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = cidadeDAO.listByEstado(servidor.getCidadeNascimento()
				.getEstado());
		for (Cidade cidade : cidadeList) {
			cidades.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidades;
	}

	public List<SelectItem> listarCidadesConjugue() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = cidadeDAO.listByEstado(servidor.getConjugue()
				.getCidadeNascimento().getEstado());
		for (Cidade cidade : cidadeList) {
			cidades.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidades;
	}

	public List<SelectItem> listarCidadesContato() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = cidadeDAO.listByEstado(servidor.getEndereco().getCidade()
				.getEstado());
		for (Cidade cidade : cidadeList) {
			cidades.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidades;
	}

	public List<SelectItem> listarCidadesEstabelecimentoEnsino() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = cidadeDAO.listByEstado(servidorTitulacao
				.getCidadeEstabelecimentoEnsino().getEstado());
		for (Cidade cidade : cidadeList) {
			cidades.add(new SelectItem(cidade.getCodigo(), cidade
					.getDescricao()));
		}
		return cidades;
	}

	public List<SelectItem> listarLotacoes() {
		LotacaoDAO lotacaoDAO = new LotacaoDAO();
		lotacoes = new ArrayList<SelectItem>();
		List<Lotacao> lotacaoList = new ArrayList<Lotacao>();
		lotacaoList = lotacaoDAO.list();
		for (Lotacao lotacao : lotacaoList) {
			lotacoes.add(new SelectItem(lotacao.getCodigo(), lotacao
					.getDescricao()));
		}
		return lotacoes;
	}

	public List<SelectItem> listarEstadosCivis() {
		EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
		estadosCivis = new ArrayList<SelectItem>();
		List<EstadoCivil> estadoCivilList = new ArrayList<EstadoCivil>();
		estadoCivilList = estadoCivilDAO.list();
		for (EstadoCivil estadoCivil : estadoCivilList) {
			estadosCivis.add(new SelectItem(estadoCivil.getCodigo(),
					estadoCivil.getDescricao()));
		}
		return estadosCivis;
	}

	public List<SelectItem> listarCorPele() {
		CorPeleDAO corPeleDAO = new CorPeleDAO();
		coresPeles = new ArrayList<SelectItem>();
		List<CorPele> corPeleList = new ArrayList<CorPele>();
		corPeleList = corPeleDAO.list();
		for (CorPele corPele : corPeleList) {
			coresPeles.add(new SelectItem(corPele.getCodigo(), corPele
					.getDescricao()));
		}
		return coresPeles;
	}

	public List<SelectItem> listarGrauParentesco() {
		GrauParentescoDAO grauParentescoDAO = new GrauParentescoDAO();
		grauParentescos = new ArrayList<SelectItem>();
		List<GrauParentesco> grauParentescoList = new ArrayList<GrauParentesco>();
		grauParentescoList = grauParentescoDAO.list();
		for (GrauParentesco grauParentesco : grauParentescoList) {
			grauParentescos.add(new SelectItem(grauParentesco.getCodigo(),
					grauParentesco.getDescricao()));
		}
		return grauParentescos;
	}

	public List<SelectItem> listarGrupoSanguineo() {
		GrupoSanguineoDAO grupoSanguineoDAO = new GrupoSanguineoDAO();
		gruposSanguineos = new ArrayList<SelectItem>();
		List<GrupoSanguineo> grupoSanguineoList = new ArrayList<GrupoSanguineo>();
		grupoSanguineoList = grupoSanguineoDAO.list();
		for (GrupoSanguineo grupoSanguineo : grupoSanguineoList) {
			gruposSanguineos.add(new SelectItem(grupoSanguineo.getCodigo(),
					grupoSanguineo.getDescricao()));
		}
		return gruposSanguineos;
	}

	public List<SelectItem> listarPadroes() {
		PadraoDAO padraoDAO = new PadraoDAO();
		padroes = new ArrayList<SelectItem>();
		List<Padrao> padraoList = new ArrayList<Padrao>();
		padraoList = padraoDAO.list();
		for (Padrao padrao : padraoList) {
			padroes.add(new SelectItem(padrao.getCodigo(), padrao.getNivel()
					.toString()));
		}
		return padroes;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarBancos() {
		bancos = new ArrayList<SelectItem>();
		List<Banco> bancoList = new ArrayList<Banco>();
		bancoList = dao.list(servidor.getContaBancaria().getBanco().getClass());
		for (Banco banco : bancoList) {
			bancos.add(new SelectItem(banco.getCodigo(), banco.getDescricao()));
		}
		return bancos;
	}

	public List<SelectItem> listarFuncoes() {
		FuncaoDAO funcaoDAO = new FuncaoDAO();
		funcoes = new ArrayList<SelectItem>();
		List<Funcao> funcoesList = new ArrayList<Funcao>();
		funcoesList = funcaoDAO.list();
		for (Funcao funcao : funcoesList) {
			funcoes.add(new SelectItem(funcao.getCodigo(), funcao
					.getDescricao()));
		}
		return funcoes;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarClasses() {
		classes = new ArrayList<SelectItem>();
		List<Classe> classeList = new ArrayList<Classe>();
		classeList = dao.list(servidor.getCargo().getClasse().getClass());
		for (Classe classe : classeList) {
			classes.add(new SelectItem(classe.getCodigo(), classe.getSigla()));
		}
		return classes;
	}

	public void carregarClasse() {
		servidor.getCargo().setClasse(new Classe());
		servidor.setCargo((Cargo) dao.refresh(servidor.getCargo()));
	}

	public List<SelectItem> listarSituacoesFuncionais() {
		SituacaoFuncionalDAO situacaoFuncionalDAO = new SituacaoFuncionalDAO();
		situacoesFuncionais = new ArrayList<SelectItem>();
		List<SituacaoFuncional> situacaoFuncionalList = new ArrayList<SituacaoFuncional>();
		situacaoFuncionalList = situacaoFuncionalDAO.list();
		for (SituacaoFuncional situacaoFuncional : situacaoFuncionalList) {
			situacoesFuncionais.add(new SelectItem(situacaoFuncional
					.getCodigo(), situacaoFuncional.getDescricao()));
		}
		return situacoesFuncionais;
	}

	public List<SelectItem> listarRegimesTrabalhos() {
		RegimeTrabalhoDAO regimeTrabalhoDAO = new RegimeTrabalhoDAO();
		regimesTrabalhos = new ArrayList<SelectItem>();
		List<RegimeTrabalho> regimeTrabalhoList = new ArrayList<RegimeTrabalho>();
		regimeTrabalhoList = regimeTrabalhoDAO.list();
		for (RegimeTrabalho regimeTrabalho : regimeTrabalhoList) {
			regimesTrabalhos.add(new SelectItem(regimeTrabalho.getCodigo(),
					regimeTrabalho.getDescricao()));
		}
		return regimesTrabalhos;
	}

	public List<SelectItem> listarCargos() {
		CargoDAO cargoDAO = new CargoDAO();
		cargos = new ArrayList<SelectItem>();
		List<Cargo> cargoList = new ArrayList<Cargo>();
		cargoList = cargoDAO.list();
		for (Cargo cargo : cargoList) {
			cargos.add(new SelectItem(cargo.getCodigo(), cargo.getDescricao()));
		}
		return cargos;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarTitulacoes() {
		titulacoes = new ArrayList<SelectItem>();
		List<Titulacao> titulacaoList = new ArrayList<Titulacao>();
		titulacaoList = dao.list(servidorTitulacao.getTitulacao().getClass());
		for (Titulacao titulacao : titulacaoList) {
			titulacoes.add(new SelectItem(titulacao.getCodigo(), titulacao
					.getDescricao()));
		}
		return titulacoes;
	}

	public List<SelectItem> listarPais() {
		PaisDAO paisDAO = new PaisDAO();
		paises = new ArrayList<SelectItem>();
		List<Pais> paisList = new ArrayList<Pais>();
		paisList = paisDAO.list();
		for (Pais pais : paisList) {
			paises.add(new SelectItem(pais.getCodigo(), pais.getDescricao()));
		}
		return paises;
	}

	public Boolean isEstrangeiro() {
		if (servidor.getIndEstrangeiro()) {
			servidorEstrangeiro = true;
			listarPais();
		} else {
			servidorEstrangeiro = false;
		}
		return false;
	}

	public Boolean isPoupanca() {
		if ((CAIXA_ECONOMICA_FEDERAL).equals(servidor.getContaBancaria()
				.getBanco().getCodigo())) {
			indPoupanca = true;
		} else {
			indPoupanca = false;
		}
		return false;
	}

	public void salvar() {
		dao.save(servidor);
		servidor = new Servidor();
	}

	public Boolean isTitulacaoEstrangeira() {
		if (this.getIndTitulacaoEstrangeira()) {
			indTitulacaoEstrangeira = true;
			servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
			servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
					new Estado());
		} else {
			indTitulacaoEstrangeira = false;
		}
		return false;
	}

	public List<ServidorTitulacao> adicionarTitulacao() {
		if (validatorTitulacao()) {
			System.out.println("ERROS");
		} else {
			Titulacao titulacao = (Titulacao) dao.refresh(servidorTitulacao
					.getTitulacao());
			servidorTitulacao.setTitulacao(titulacao);
			servidorTitulacao.setIndentificador(titulacaoList.size() + 1);
			titulacaoList.add(servidorTitulacao);
			FacesMessage messageSucesso = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Item inserido com sucesso!",
					"Item inserido com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", messageSucesso);
			servidorTitulacao = new ServidorTitulacao();
			servidorTitulacao.setTitulacao(new Titulacao());
			servidorTitulacao.setServidor(new Servidor());
			servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
			servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
					new Estado());
			servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
		}
		return titulacaoList;
	}

	public boolean validatorTitulacao() {
		FacesMessage message = null;
		int contadorErros = 0;
		if (servidorTitulacao.getTitulacao().getCodigo() == 0) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Titulação é obrigatório!",
					"Campo Titulação é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (servidorTitulacao.getEstabelecimentoEnsino() == null
				|| servidorTitulacao.getEstabelecimentoEnsino() == "") {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Estabelecimento de Ensino é obrigatório!",
					"Campo Estabelecimento de Ensino é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (servidorTitulacao.getCidadeEstabelecimentoEnsino().getEstado()
				.getCodigo() == 0
				&& !(this.getIndTitulacaoEstrangeira())) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Estado do Estabelecimento é obrigatório!",
					"Campo Estado do Estabelecimento é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (servidorTitulacao.getCidadeEstabelecimentoEnsino().getCodigo() == 0
				&& !(this.getIndTitulacaoEstrangeira())) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Cidade do Estabelecimento é obrigatório!",
					"Campo Cidade do Estabelecimento é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (servidorTitulacao.getAnoConclusao() == null
				|| servidorTitulacao.getAnoConclusao() == 0) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Ano de Conclusão é obrigatório!",
					"Campo Ano de Conclusão é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (this.getIndTitulacaoEstrangeira()
				&& servidorTitulacao.getPais().getCodigo() == 0) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo País é obrigatório!", "Campo País é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (contadorErros > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<ServidorTitulacao> removerTitulacao() {
		if (servidorTitulacao.getCodigo() != 0) {
			titulacaoList.remove(servidorTitulacao);
		} else {
			for (int i = 0; i < titulacaoList.size(); i++) {
				if (titulacaoList.get(i).getIndentificador()
						.equals(servidorTitulacao.getIndentificador())) {
					titulacaoList.remove(titulacaoList.get(i));
				}
			}
		}
		return titulacaoList;
	}

	public List<Dependente> adicionarDependente() {
		dependentes.add(dependente);
		return dependentes;
	}
}
