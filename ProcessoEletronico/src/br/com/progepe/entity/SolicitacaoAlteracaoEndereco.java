package br.com.progepe.entity;

public class SolicitacaoAlteracaoEndereco extends Solicitacao {

	private static final long serialVersionUID = 1L;

	private String novoCep;
	private String novoNumero;
	private String novaRua;
	private String novoComplemento;
	private String novoBairro;
	private Cidade novaCidade;

	public String getNovoCep() {
		return novoCep;
	}

	public void setNovoCep(String novoCep) {
		this.novoCep = novoCep;
	}

	public String getNovoNumero() {
		return novoNumero;
	}

	public void setNovoNumero(String novoNumero) {
		this.novoNumero = novoNumero;
	}

	public String getNovaRua() {
		return novaRua;
	}

	public void setNovaRua(String novaRua) {
		this.novaRua = novaRua;
	}

	public String getNovoComplemento() {
		return novoComplemento;
	}

	public void setNovoComplemento(String novoComplemento) {
		this.novoComplemento = novoComplemento;
	}

	public String getNovoBairro() {
		return novoBairro;
	}

	public void setNovoBairro(String novoBairro) {
		this.novoBairro = novoBairro;
	}

	public Cidade getNovaCidade() {
		return novaCidade;
	}

	public void setNovaCidade(Cidade novaCidade) {
		this.novaCidade = novaCidade;
	}
}
