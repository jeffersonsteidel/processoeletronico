package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Servidor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;
	private Integer siape;
	private Cargo cargo;
	private Date dataAdmissao;
	private Lotacao lotacao;
	private Lotacao localExercicio;
	private Integer ramal;
	private Documento documento;
	private Padrao padrao;
	private ContaBancaria contaBancaria;
	private Conjugue conjugue;
	private String sexo;
	private String Email;
	private Date dataNascimento;
	private GrupoSanguineo grupoSanguineo;
	private String nomePai;
	private String nomeMae;
	private Cidade cidadeNascimento;
	private EstadoCivil estadoCivil;
	private CorPele corPele;
	private Boolean indEstrangeiro = false;
	private Funcao funcao;
	private RegimeTrabalho regimeTrabalho;
	private SituacaoFuncional situacaoFuncional;
	private Grupo grupo;
	private Endereco endereco;
	private Telefone telefone;
	private Telefone celular;
	private Set<Dependente> dependentes = new HashSet<Dependente>();
	private Set<Titulacao> titulacoes = new HashSet<Titulacao>();
	private String identificacaoUnica;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSiape() {
		return siape;
	}

	public void setSiape(Integer siape) {
		this.siape = siape;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Lotacao getLotacao() {
		return lotacao;
	}

	public void setLotacao(Lotacao lotacao) {
		this.lotacao = lotacao;
	}

	public Integer getRamal() {
		return ramal;
	}

	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Padrao getPadrao() {
		return padrao;
	}

	public void setPadrao(Padrao padrao) {
		this.padrao = padrao;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public Conjugue getConjugue() {
		return conjugue;
	}

	public void setConjugue(Conjugue conjugue) {
		this.conjugue = conjugue;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public GrupoSanguineo getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(GrupoSanguineo grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Cidade getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(Cidade cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public CorPele getCorPele() {
		return corPele;
	}

	public void setCorPele(CorPele corPele) {
		this.corPele = corPele;
	}

	public Boolean getIndEstrangeiro() {
		return indEstrangeiro;
	}

	public void setIndEstrangeiro(Boolean indEstrangeiro) {
		this.indEstrangeiro = indEstrangeiro;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public RegimeTrabalho getRegimeTrabalho() {
		return regimeTrabalho;
	}

	public void setRegimeTrabalho(RegimeTrabalho regimeTrabalho) {
		this.regimeTrabalho = regimeTrabalho;
	}

	public SituacaoFuncional getSituacaoFuncional() {
		return situacaoFuncional;
	}

	public void setSituacaoFuncional(SituacaoFuncional situacaoFuncional) {
		this.situacaoFuncional = situacaoFuncional;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Telefone getCelular() {
		return celular;
	}

	public void setCelular(Telefone celular) {
		this.celular = celular;
	}

	public Set<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Set<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Set<Titulacao> getTitulacoes() {
		return titulacoes;
	}

	public void setTitulacoes(Set<Titulacao> titulacoes) {
		this.titulacoes = titulacoes;
	}

	public String getIdentificacaoUnica() {
		return identificacaoUnica;
	}

	public void setIdentificacaoUnica(String identificacaoUnica) {
		this.identificacaoUnica = identificacaoUnica;
	}

	public Lotacao getLocalExercicio() {
		return localExercicio;
	}

	public void setLocalExercicio(Lotacao localExercicio) {
		this.localExercicio = localExercicio;
	}
	
}
