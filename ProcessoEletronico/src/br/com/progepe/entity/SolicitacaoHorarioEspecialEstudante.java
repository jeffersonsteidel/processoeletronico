package br.com.progepe.entity;

import java.util.ArrayList;

public class SolicitacaoHorarioEspecialEstudante extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String curso;
	private String instituicao;
	private String motivo;
	private byte[] declaracaoMatricula;
	private Boolean documentoValidado = false;
	private ArrayList<SolicitacaoHorarioEspecialEstudante> files = new ArrayList<SolicitacaoHorarioEspecialEstudante>();
	private String horarioEntradaSegunda;
	private String horarioEntradaTerca;
	private String horarioEntradaQuarta;
	private String horarioEntradaQuinta;
	private String horarioEntradaSexta;
	private String horarioSaidaAlmocoSegunda;
	private String horarioSaidaAlmocoTerca;
	private String horarioSaidaAlmocoQuarta;
	private String horarioSaidaAlmocoQuinta;
	private String horarioSaidaAlmocoSexta;
	private String horarioRetornoAlmocoSegunda;
	private String horarioRetornoAlmocoTerca;
	private String horarioRetornoAlmocoQuarta;
	private String horarioRetornoAlmocoQuinta;
	private String horarioRetornoAlmocoSexta;
	private String horarioSaidaSegunda;
	private String horarioSaidaTerca;
	private String horarioSaidaQuarta;
	private String horarioSaidaQuinta;
	private String horarioSaidaSexta;

	public ArrayList<SolicitacaoHorarioEspecialEstudante> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<SolicitacaoHorarioEspecialEstudante> files) {
		this.files = files;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public byte[] getDeclaracaoMatricula() {
		return declaracaoMatricula;
	}

	public void setDeclaracaoMatricula(byte[] certidaoNascimento) {
		this.declaracaoMatricula = certidaoNascimento;
	}

	public Boolean getDocumentoValidado() {
		return documentoValidado;
	}

	public void setDocumentoValidado(Boolean documentoValidado) {
		this.documentoValidado = documentoValidado;
	}

	public String getHorarioEntradaSegunda() {
		return horarioEntradaSegunda;
	}

	public void setHorarioEntradaSegunda(String horarioEntradaSegunda) {
		this.horarioEntradaSegunda = horarioEntradaSegunda;
	}

	public String getHorarioEntradaTerca() {
		return horarioEntradaTerca;
	}

	public void setHorarioEntradaTerca(String horarioEntradaTerca) {
		this.horarioEntradaTerca = horarioEntradaTerca;
	}

	public String getHorarioEntradaQuarta() {
		return horarioEntradaQuarta;
	}

	public void setHorarioEntradaQuarta(String horarioEntradaQuarta) {
		this.horarioEntradaQuarta = horarioEntradaQuarta;
	}

	public String getHorarioEntradaQuinta() {
		return horarioEntradaQuinta;
	}

	public void setHorarioEntradaQuinta(String horarioEntradaQuinta) {
		this.horarioEntradaQuinta = horarioEntradaQuinta;
	}

	public String getHorarioEntradaSexta() {
		return horarioEntradaSexta;
	}

	public void setHorarioEntradaSexta(String horarioEntradaSexta) {
		this.horarioEntradaSexta = horarioEntradaSexta;
	}

	public String getHorarioSaidaAlmocoSegunda() {
		return horarioSaidaAlmocoSegunda;
	}

	public void setHorarioSaidaAlmocoSegunda(String horarioSaidaAlmocoSegunda) {
		this.horarioSaidaAlmocoSegunda = horarioSaidaAlmocoSegunda;
	}

	public String getHorarioSaidaAlmocoTerca() {
		return horarioSaidaAlmocoTerca;
	}

	public void setHorarioSaidaAlmocoTerca(String horarioSaidaAlmocoTerca) {
		this.horarioSaidaAlmocoTerca = horarioSaidaAlmocoTerca;
	}

	public String getHorarioSaidaAlmocoQuarta() {
		return horarioSaidaAlmocoQuarta;
	}

	public void setHorarioSaidaAlmocoQuarta(String horarioSaidaAlmocoQuarta) {
		this.horarioSaidaAlmocoQuarta = horarioSaidaAlmocoQuarta;
	}

	public String getHorarioSaidaAlmocoQuinta() {
		return horarioSaidaAlmocoQuinta;
	}

	public void setHorarioSaidaAlmocoQuinta(String horarioSaidaAlmocoQuinta) {
		this.horarioSaidaAlmocoQuinta = horarioSaidaAlmocoQuinta;
	}

	public String getHorarioSaidaAlmocoSexta() {
		return horarioSaidaAlmocoSexta;
	}

	public void setHorarioSaidaAlmocoSexta(String horarioSaidaAlmocoSexta) {
		this.horarioSaidaAlmocoSexta = horarioSaidaAlmocoSexta;
	}

	public String getHorarioRetornoAlmocoSegunda() {
		return horarioRetornoAlmocoSegunda;
	}

	public void setHorarioRetornoAlmocoSegunda(
			String horarioRetornoAlmocoSegunda) {
		this.horarioRetornoAlmocoSegunda = horarioRetornoAlmocoSegunda;
	}

	public String getHorarioRetornoAlmocoTerca() {
		return horarioRetornoAlmocoTerca;
	}

	public void setHorarioRetornoAlmocoTerca(String horarioRetornoAlmocoTerca) {
		this.horarioRetornoAlmocoTerca = horarioRetornoAlmocoTerca;
	}

	public String getHorarioRetornoAlmocoQuarta() {
		return horarioRetornoAlmocoQuarta;
	}

	public void setHorarioRetornoAlmocoQuarta(String horarioRetornoAlmocoQuarta) {
		this.horarioRetornoAlmocoQuarta = horarioRetornoAlmocoQuarta;
	}

	public String getHorarioRetornoAlmocoQuinta() {
		return horarioRetornoAlmocoQuinta;
	}

	public void setHorarioRetornoAlmocoQuinta(String horarioRetornoAlmocoQuinta) {
		this.horarioRetornoAlmocoQuinta = horarioRetornoAlmocoQuinta;
	}

	public String getHorarioRetornoAlmocoSexta() {
		return horarioRetornoAlmocoSexta;
	}

	public void setHorarioRetornoAlmocoSexta(String horarioRetornoAlmocoSexta) {
		this.horarioRetornoAlmocoSexta = horarioRetornoAlmocoSexta;
	}

	public String getHorarioSaidaSegunda() {
		return horarioSaidaSegunda;
	}

	public void setHorarioSaidaSegunda(String horarioSaidaSegunda) {
		this.horarioSaidaSegunda = horarioSaidaSegunda;
	}

	public String getHorarioSaidaTerca() {
		return horarioSaidaTerca;
	}

	public void setHorarioSaidaTerca(String horarioSaidaTerca) {
		this.horarioSaidaTerca = horarioSaidaTerca;
	}

	public String getHorarioSaidaQuarta() {
		return horarioSaidaQuarta;
	}

	public void setHorarioSaidaQuarta(String horarioSaidaQuarta) {
		this.horarioSaidaQuarta = horarioSaidaQuarta;
	}

	public String getHorarioSaidaQuinta() {
		return horarioSaidaQuinta;
	}

	public void setHorarioSaidaQuinta(String horarioSaidaQuinta) {
		this.horarioSaidaQuinta = horarioSaidaQuinta;
	}

	public String getHorarioSaidaSexta() {
		return horarioSaidaSexta;
	}

	public void setHorarioSaidaSexta(String horarioSaidaSexta) {
		this.horarioSaidaSexta = horarioSaidaSexta;
	}

}
