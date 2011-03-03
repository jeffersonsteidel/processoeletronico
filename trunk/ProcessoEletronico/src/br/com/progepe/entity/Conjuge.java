package br.com.progepe.entity;

import java.io.Serializable;
import java.util.Date;

public class Conjuge implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;
	private Cidade cidadeNascimento;
	private Boolean indEstrangeiro;
	private Boolean indServidor;
	private String local;
	private String sexo;
	private Servidor servidor;
	private Pais pais;
	private Boolean atual;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String rgOrgao;
	private Date rgDataExpedicao;
	private Estado rgUf;
	private Boolean indRessarcimentoSaude;
	private Integer atendente;
	private Date dataAtendimento;
	private Date dataAbertura;
	private Date dataFechamento;
	private String justificativa;
	private StatusSolicitacao statusSolicitacao;
	private Boolean indNovo;
	
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

	public Cidade getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(Cidade cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public Boolean getIndEstrangeiro() {
		return indEstrangeiro;
	}

	public void setIndEstrangeiro(Boolean indEstrangeiro) {
		this.indEstrangeiro = indEstrangeiro;
	}

	public Boolean getIndServidor() {
		return indServidor;
	}

	public void setIndServidor(Boolean indServidor) {
		this.indServidor = indServidor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Boolean getAtual() {
		return atual;
	}

	public void setAtual(Boolean atual) {
		this.atual = atual;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgOrgao() {
		return rgOrgao;
	}

	public void setRgOrgao(String rgOrgao) {
		this.rgOrgao = rgOrgao;
	}

	public Date getRgDataExpedicao() {
		return rgDataExpedicao;
	}

	public void setRgDataExpedicao(Date rgDataExpedicao) {
		this.rgDataExpedicao = rgDataExpedicao;
	}

	public Estado getRgUf() {
		return rgUf;
	}

	public void setRgUf(Estado rgUf) {
		this.rgUf = rgUf;
	}

	public Boolean getIndRessarcimentoSaude() {
		return indRessarcimentoSaude;
	}

	public void setIndRessarcimentoSaude(Boolean indRessarcimentoSaude) {
		this.indRessarcimentoSaude = indRessarcimentoSaude;
	}

	public Integer getAtendente() {
		return atendente;
	}

	public void setAtendente(Integer atendente) {
		this.atendente = atendente;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public StatusSolicitacao getStatusSolicitacao() {
		return statusSolicitacao;
	}

	public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}

	public Boolean getIndNovo() {
		return indNovo;
	}

	public void setIndNovo(Boolean indNovo) {
		this.indNovo = indNovo;
	}
}
