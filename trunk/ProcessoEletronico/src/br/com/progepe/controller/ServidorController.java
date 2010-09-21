package br.com.progepe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.entity.AreaConhecimento;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Classe;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.CorPele;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Emprego;
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
import br.com.progepe.entity.TipoFuncao;
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
	private Emprego emprego;
	private List<Emprego> empregoList;

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
	private List<SelectItem> areasConhecimentos;
	private List<SelectItem> tipoFuncoes;

	DAO dao = new DAO();

	private Boolean servidorEstrangeiro = false;
	private Boolean indPoupanca = false;
	private Boolean indTitulacaoEstrangeira = false;
	private Boolean indConjugeServidor = false;
	private Boolean indUniversitario = false;

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

	public List<SelectItem> getAreasConhecimentos() {
		return areasConhecimentos;
	}

	public void setAreasConhecimentos(List<SelectItem> areasConhecimentos) {
		this.areasConhecimentos = areasConhecimentos;
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

	public Emprego getEmprego() {
		return emprego;
	}

	public void setEmprego(Emprego emprego) {
		this.emprego = emprego;
	}

	public List<Emprego> getEmpregoList() {
		return empregoList;
	}

	public void setEmpregoList(List<Emprego> empregoList) {
		this.empregoList = empregoList;
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

	public Boolean getIndConjugeServidor() {
		return indConjugeServidor;
	}

	public void setIndConjugeServidor(Boolean indConjugeServidor) {
		this.indConjugeServidor = indConjugeServidor;
	}

	public Boolean getIndUniversitario() {
		return indUniversitario;
	}

	public void setIndUniversitario(Boolean indUniversitario) {
		this.indUniversitario = indUniversitario;
	}
	
	public List<SelectItem> getTipoFuncoes() {
		return tipoFuncoes;
	}

	public void setTipoFuncoes(List<SelectItem> tipoFuncoes) {
		this.tipoFuncoes = tipoFuncoes;
	}

	public void cadastrar() throws IOException {
		servidor = new Servidor();
		servidor.setCargo(new Cargo());
		servidor.getCargo().setClasse(new Classe());
		servidor.setCidadeNascimento(new Cidade());
		servidor.getCidadeNascimento().setEstado(new Estado());
		servidor.setConjuge(new Conjuge());
		servidor.getConjuge().setDocumento(new Documento());
		servidor.getConjuge().getDocumento().setCarteiraUf(new Estado());
		servidor.getConjuge().getDocumento().setRgUf(new Estado());
		servidor.getConjuge().getDocumento().setTituloUf(new Estado());
		servidor.getConjuge().setCidadeNascimento(new Cidade());
		servidor.getConjuge().getCidadeNascimento().setEstado(new Estado());
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
		servidor.getFuncao().setTipoFuncao(new TipoFuncao());
		servidor.setGrupo(new Grupo());
		servidor.setGrupoSanguineo(new GrupoSanguineo());
		servidor.setLotacao(new Lotacao());
		servidor.setLocalExercicio(new Lotacao());
		servidor.setPadrao(new Padrao());
		servidor.setRegimeTrabalho(new RegimeTrabalho());
		servidor.setSituacaoFuncional(new SituacaoFuncional());
		servidor.setTelefone(new Telefone());
		servidor.setCelular(new Telefone());
		dependentes = new ArrayList<Dependente>();
		servidorTitulacao = new ServidorTitulacao();
		servidorTitulacao.setTitulacao(new Titulacao());
		servidorTitulacao.setAreaConhecimento(new AreaConhecimento());
		servidorTitulacao.setCidadeEstabelecimentoEnsino(new Cidade());
		servidorTitulacao.getCidadeEstabelecimentoEnsino().setEstado(
				new Estado());
		servidorTitulacao.setEstadoOrgaoEmissor(new Estado());
		servidorTitulacao.setPais(new Pais());
		titulacaoList = new ArrayList<ServidorTitulacao>();
		dependente = new Dependente();
		dependente.setGrauParentesco(new GrauParentesco());
		dependente.setDocumento(new Documento());
		dependente.setGrauParentesco(new GrauParentesco());
		dependente.getDocumento().setCarteiraUf(new Estado());
		dependente.getDocumento().setRgUf(new Estado());
		dependente.getDocumento().setTituloUf(new Estado());
		emprego = new Emprego();
		empregoList = new ArrayList<Emprego>();

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
		areasConhecimentos = new ArrayList<SelectItem>();
		tipoFuncoes = new ArrayList<SelectItem>();


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
		listarAreaConhecimento();

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrarServidor.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarUfs() {
		ufs = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = dao.list(Estado.class);
		for (Estado estado : estadoList) {
			ufs.add(new SelectItem(estado.getCodigo(), estado.getUf()));
		}
		return ufs;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarEstados() {
		estados = new ArrayList<SelectItem>();
		List<Estado> estadoList = new ArrayList<Estado>();
		estadoList = dao.list(Estado.class);
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

	public List<SelectItem> listarCidadesConjuge() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidades = new ArrayList<SelectItem>();
		List<Cidade> cidadeList = new ArrayList<Cidade>();
		cidadeList = cidadeDAO.listByEstado(servidor.getConjuge()
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarLotacoes() {
		lotacoes = new ArrayList<SelectItem>();
		List<Lotacao> lotacaoList = new ArrayList<Lotacao>();
		lotacaoList = dao.list(servidor.getLotacao().getClass());
		for (Lotacao lotacao : lotacaoList) {
			lotacoes.add(new SelectItem(lotacao.getCodigo(), lotacao
					.getDescricao()));
		}
		return lotacoes;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarEstadosCivis() {
		estadosCivis = new ArrayList<SelectItem>();
		List<EstadoCivil> estadoCivilList = new ArrayList<EstadoCivil>();
		estadoCivilList = dao.list(EstadoCivil.class);
		for (EstadoCivil estadoCivil : estadoCivilList) {
			estadosCivis.add(new SelectItem(estadoCivil.getCodigo(),
					estadoCivil.getDescricao()));
		}
		return estadosCivis;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarCorPele() {
		coresPeles = new ArrayList<SelectItem>();
		List<CorPele> corPeleList = new ArrayList<CorPele>();
		corPeleList = dao.list(CorPele.class);
		for (CorPele corPele : corPeleList) {
			coresPeles.add(new SelectItem(corPele.getCodigo(), corPele
					.getDescricao()));
		}
		return coresPeles;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarGrauParentesco() {
		grauParentescos = new ArrayList<SelectItem>();
		List<GrauParentesco> grauParentescoList = new ArrayList<GrauParentesco>();
		grauParentescoList = dao.list(GrauParentesco.class);
		for (GrauParentesco grauParentesco : grauParentescoList) {
			grauParentescos.add(new SelectItem(grauParentesco.getCodigo(),
					grauParentesco.getDescricao()));
		}
		return grauParentescos;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarGrupoSanguineo() {
		gruposSanguineos = new ArrayList<SelectItem>();
		List<GrupoSanguineo> grupoSanguineoList = new ArrayList<GrupoSanguineo>();
		grupoSanguineoList = dao.list(GrupoSanguineo.class);
		for (GrupoSanguineo grupoSanguineo : grupoSanguineoList) {
			gruposSanguineos.add(new SelectItem(grupoSanguineo.getCodigo(),
					grupoSanguineo.getDescricao()));
		}
		return gruposSanguineos;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarPadroes() {
		padroes = new ArrayList<SelectItem>();
		List<Padrao> padraoList = new ArrayList<Padrao>();
		padraoList = dao.list(Padrao.class);
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarAreaConhecimento() {
		areasConhecimentos = new ArrayList<SelectItem>();
		List<AreaConhecimento> areaConheciemntoList = new ArrayList<AreaConhecimento>();
		areaConheciemntoList = dao.list(servidorTitulacao.getAreaConhecimento()
				.getClass());
		for (AreaConhecimento areaConhecimento : areaConheciemntoList) {
			areasConhecimentos.add(new SelectItem(areaConhecimento.getCodigo(),
					areaConhecimento.getDescricao()));
		}
		return areasConhecimentos;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarFuncoes() {
		funcoes = new ArrayList<SelectItem>();
		List<Funcao> funcoesList = new ArrayList<Funcao>();
		funcoesList = dao.list(Funcao.class);
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
		Cargo cargo = servidor.getCargo();
		dao.refresh(cargo);
		servidor.setCargo(cargo);
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarSituacoesFuncionais() {
		situacoesFuncionais = new ArrayList<SelectItem>();
		List<SituacaoFuncional> situacaoFuncionalList = new ArrayList<SituacaoFuncional>();
		situacaoFuncionalList = dao.list(SituacaoFuncional.class);
		for (SituacaoFuncional situacaoFuncional : situacaoFuncionalList) {
			situacoesFuncionais.add(new SelectItem(situacaoFuncional
					.getCodigo(), situacaoFuncional.getDescricao()));
		}
		return situacoesFuncionais;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarRegimesTrabalhos() {
		regimesTrabalhos = new ArrayList<SelectItem>();
		List<RegimeTrabalho> regimeTrabalhoList = new ArrayList<RegimeTrabalho>();
		regimeTrabalhoList = dao.list(RegimeTrabalho.class);
		for (RegimeTrabalho regimeTrabalho : regimeTrabalhoList) {
			regimesTrabalhos.add(new SelectItem(regimeTrabalho.getCodigo(),
					regimeTrabalho.getDescricao()));
		}
		return regimesTrabalhos;
	}

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarCargos() {
		cargos = new ArrayList<SelectItem>();
		List<Cargo> cargoList = new ArrayList<Cargo>();
		cargoList = dao.list(Cargo.class);
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

	@SuppressWarnings("unchecked")
	public List<SelectItem> listarPais() {
		paises = new ArrayList<SelectItem>();
		List<Pais> paisList = new ArrayList<Pais>();
		paisList = dao.list(Pais.class);
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

	public Boolean isConjugeServidor() {
		if (servidor.getConjuge().getIndServidor()) {
			indConjugeServidor = true;
		} else {
			indConjugeServidor = false;
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
		dao.save(dependente);
		dao.save(titulacao);
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

	public Boolean isUniversitario() {
		if (dependente.getIndEstudante()) {
			indUniversitario = true;
		} else {
			indUniversitario = false;
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
			servidorTitulacao.setAreaConhecimento(new AreaConhecimento());
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
		if (servidorTitulacao.getCurso() == null
				|| servidorTitulacao.getCurso() == "") {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Curso é obrigatório!", "Campo Curso é obrigatório!");
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

	public List<Dependente> adicionarDependentes() {
		if (validatorDependentes()) {
			System.out.println("ERROS");
		} else {
			dependente.setGrauParentesco((GrauParentesco) dao
					.refresh(dependente.getGrauParentesco()));
			dependente.setIndentificador(dependentes.size() + 1);
			dependentes.add(dependente);
			FacesMessage messageSucesso = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Item inserido com sucesso!",
					"Item inserido com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", messageSucesso);
			dependente = new Dependente();
			dependente.setGrauParentesco(new GrauParentesco());
			dependente.setDocumento(new Documento());
			dependente.setGrauParentesco(new GrauParentesco());
			dependente.getDocumento().setCarteiraUf(new Estado());
			dependente.getDocumento().setRgUf(new Estado());
			dependente.getDocumento().setTituloUf(new Estado());
		}
		return dependentes;
	}

	public boolean validatorDependentes() {
		FacesMessage message = null;
		int contadorErros = 0;
		if (dependente.getNome() == null || dependente.getNome() == "") {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Nome do Dependente é obrigatório!",
					"Campo Nome do Dependente é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (dependente.getSexo() == null || dependente.getSexo() == "") {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Sexo é obrigatório!", "Campo Sexo é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (dependente.getDataNascimento() == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Data de Nascimento do Dependente é obrigatório!",
					"Campo Data de Nascimento do Dependente é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (dependente.getGrauParentesco().getCodigo() == 0) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Grau Parentesco é obrigatório!",
					"Campo Grau Parentesco é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (dependente.getIndEstudante()) {
			if (dependente.getFaculdade() == null
					|| dependente.getFaculdade() == "") {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Campo Estabelecimento de Ensino é obrigatório!",
						"Campo Estabelecimento de Ensino é obrigatório!");
				FacesContext.getCurrentInstance().addMessage("", message);
				contadorErros = +1;
			}
			if (dependente.getCurso() == null || dependente.getCurso() == "") {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Campo Curso é obrigatório!",
						"Campo Curso é obrigatório!");
				FacesContext.getCurrentInstance().addMessage("", message);
				contadorErros = +1;
			}
			if (dependente.getDataFormacao() == null) {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Campo Previsão de Formação é obrigatório!",
						"Campo Previsão de Formação é obrigatório!");
				FacesContext.getCurrentInstance().addMessage("", message);
				contadorErros = +1;
			}
		}

		if (contadorErros > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Dependente> removerDependente() {
		if (dependente.getCodigo() != 0) {
			dependentes.remove(dependente);
		} else {
			for (int i = 0; i < dependentes.size(); i++) {
				if (dependentes.get(i).getIndentificador()
						.equals(dependente.getIndentificador())) {
					dependentes.remove(dependentes.get(i));
				}
			}
		}
		return dependentes;
	}

	public List<Emprego> adicionarEmprego() {
		if (validatorEmprego()) {
			System.out.println("ERROS");
		} else {
			emprego.setIndentificador(empregoList.size() + 1);
			empregoList.add(emprego);
			FacesMessage messageSucesso = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Item inserido com sucesso!",
					"Item inserido com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", messageSucesso);
			emprego = new Emprego();
		}
		return empregoList;
	}

	public boolean validatorEmprego() {
		FacesMessage message = null;
		int contadorErros = 0;
		if (emprego.getEmpresa() == null || emprego.getEmpresa() == "") {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Empresa é obrigatório!",
					"Campo Empresa é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (emprego.getCargo() == null || emprego.getCargo() == "") {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Cargo é obrigatório!", "Campo Cargo é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (emprego.getDataAdmissao() == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Data de Admissão é obrigatório!",
					"Campo Data de Admissão é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (emprego.getDataSaida() == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Data de Saída é obrigatório!",
					"Campo Data de Saída é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (emprego.getAtividades() == null || emprego.getAtividades() == "") {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campo Atividades é obrigatório!",
					"Campo Atividades é obrigatório!");
			FacesContext.getCurrentInstance().addMessage("", message);
			contadorErros = +1;
		}
		if (contadorErros > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Emprego> removerEmprego() {
		if (emprego.getCodigo() != 0) {
			empregoList.remove(emprego);
		} else {
			for (int i = 0; i < empregoList.size(); i++) {
				if (empregoList.get(i).getIndentificador()
						.equals(emprego.getIndentificador())) {
					empregoList.remove(empregoList.get(i));
				}
			}
		}
		return empregoList;
	}
}
