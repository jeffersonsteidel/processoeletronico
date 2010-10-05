package br.com.progepe.extract;

public class DadosFitaEspelho {
	
	//antigo DadosPessoais:
	
	private Integer matriculaSiape;
	private Integer dvMatricula;
	private String tipoRegistro;
	private String nomeServidor;
	private String cpf;
	private String pisPasef;
	private String nomeMae;
	private String sexo;
	private String dataNascimento;
	private Integer estadoCivil;
	private String nivelEscolaridade;
	private Integer codigoTitulacaoFormacao;
	private String nacionalidade;
	private String naturalidade;
	private String pais;
	private Integer anoChegada;
	private String dataPrimeiroEmprego;
	private String identificacaoOrigem;
	private String logradouro;
	private String numeroEndereco;
	private String complementoEndereco;
	private String bairro;
	private String municipio;
	private String cep;
	private String uf;
	private String numeroRegistroGeral;
	private String siglaOrgaoExpedidor;
	private String dataExpedicaoIdentidade;
	private String siglaUfIdentidade;
	private String numeroTituloEleitor;

	//antigo DadosFuncionais:
	
	// pagina 5:
	
	private Integer codigoSituacaoServidor;
	private Integer numeroCarteiraDeTrabalho;
	private String serieCarteiraDeTrabalho;
	private String UfCarteiraDeTrabalho;
	private Integer codigoBanco;
	private String agenciaBanco;
	private String contaCorrenteBanco;
	private Integer jornadaDeTrabalho;
	private String dataCadastramentoServidor;
	private Integer codigoGrupoCargo;
	private Integer codigoCargo;// ALTERAR
	private String classeCargo;
	private String codigoReferenciaNivelPadraoCargo;
	private String dataEntradaOcupacaoCargo;
	private String dataSaidaCargo;
	private String siglaFuncao;
	private Integer codigoNivelFuncao;
	private String codigoEscolaridadeFuncao;
	// pagina 6:
	private String codigoOpcaoFuncao;
	private String dataIngressoFuncao;
	private String dataSaidaFuncao;
	private Integer codigoUnidadeOrganizacionalFuncao;
	private String siglaNovaFuncao;
	private Integer codigoNivelNovaFuncao;
	private String codigoEscolaridadeNovaFuncao;
	private String codigoOpcaoNovaFuncao;
	private String dataIngressoNovaFuncao;
	private String dataSaidaNovaFuncao;
	private Integer codigoUnidadeOrganizacionalNovaFuncao;
	private Integer codigoUnidadeOrganizacionalLotacao;
	private String dataLotacao;
	private Integer codigoOrgaoLocalizacao;
	private Integer codigoUnidadeOrganizacionalLocalizacao;
	private Integer codigoGrupoIngressoOrgao;
	private Integer codigoOcorrenciaIngressoOrgao;
	private String dataIngressoOrgao;
	private Integer codigoDiplomaLegalIngressoOrgao;
	private String numeroDiplomaLegalIngressoOrgao;
	private String dataPublicacaoDiplomaLegalIngressoOrgao;
	private Integer codigoGrupoIngressoServPublico;
	private Integer codigoOcorrenciaIngressoServPublico;
	private String dataIngressoServPublico;
	private Integer codigoDiplomaLegalIngressoServPublico;
	private String numeroDiplomaLegalIngressoServPublico;
	private String dataPublicacaoDiplomaLegalIngressoServPublico;
	private Integer codigoGrupoExclusao;
	private Integer codigoOcorrenciaExclusao;
	private String dataExclusao;
	private Integer codigoDiplomaLegalExclusao;
	private String numeroDiplomaLegalExclusao;
	private String dataPublicacaoDiplomaLegalExclusao;
	// pagina 7:
	private Integer codigoGrupoAfastamento;
	private Integer codigoOcerrenciaAfastamento;
	private String dataInicioAfastamento;
	private String dataTerminoAfastamento;
	private Integer codigoDiplomaLegalAfastamento;
	private String numeroDiplomaLegalAfastamento;
	private String dataPublicacaoDiplomaLegalAfastamento;
	private Integer codigoGrupoInatividade;
	private Integer codigoOcorrenciaInatividade;
	private String dataInatividade;
	private Integer codigoDiplomaLegalInatividade;
	private String numeroDiplomaLegalInatividade;
	private String dataPublicacaoDiplomaLegalInatividade;
	private String numeroProcessoAposentadoria;
	private Integer anoPrevistoAposentadoria;
	private String opcaoAposentadoriaIntegral;
	private Integer codigoGrupoModifFuncional;
	private Integer codigoOcorrenciaModifFuncional;
	private String dataModifFuncional;
	private Integer codigoDiplomaLegalModifFuncional;
	private String numeroDiplomaLegalModifFuncional;
	private String dataPublicacaoDiplomaLegalModifFuncional;
	private String codigoRegimeJuridicoAnterior;
	private Integer codigoSituaçãoServidorAnterior;
	private Integer codigoOrgaoDestinoMudancaOrgao;
	private String dataLiberacaoMudancaOrgao;
	private Integer codigoOrgaoOrigemMudancaOrgao;
	private Integer codigoOrgaoAnterior;
	private String matriculaAnterior;
	private Integer codigoOrgaoExtintoModificado;
	private String matriculaServidorExtintaModificada;
	private Integer codigoOrgaoAtual;
	private String matriculaAtual;
	// página 8:
	private Integer codigoUpagMudancaUnidadePagadora;
	private String dataLiberacaoMudancaUnidadePagadora;
	private String motivoMudancaUnidadePagadora;
	private Integer codigoIndicadorDePagamentoServidor;
	private String codigoTipoValeAlimentacao;
	private String dataInicioValeAlimentacao;
	private String dataFimValeAlimentacao;
	private Integer codigoIndicadorDeOperadorDeRaioX;
	private Integer codigoOrgaoRequisitante;
	private Integer codigoDavaga;
	private Integer codigoDoGrupoPosse;
	private Integer codigoOcorrenciaPosse;
	private String dataPosse;
	private Integer codigoDiplomaPosse;
	private String dataDiplomaPosse;
	private String numeroDiplomaPosse;
	private Integer codigoGrupoOcorrenciaGrupoReversaoAtividade;
	private Integer codigoOcorrenciaGrupoReversaoAtividade;
	private String dataOcorrenciaGrupoReversaoAtividade;
	private Integer codigoDiplomaGrupoReversaoAtividade;
	private String dataPublicacaoDiplomaGrupoReversaoAtividade;
	private String numeroDiplomaGrupoReversaoAtividade;
	
	//antigo DadosPessoais:
	
	public Integer getMatriculaSiape() {
		return matriculaSiape;
	}

	public void setMatriculaSiape(Integer matriculaSiape) {
		this.matriculaSiape = matriculaSiape;
	}

	public Integer getDvMatricula() {
		return dvMatricula;
	}

	public void setDvMatricula(Integer dvMatricula) {
		this.dvMatricula = dvMatricula;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getNomeServidor() {
		return nomeServidor;
	}

	public void setNomeServidor(String nomeServidor) {
		this.nomeServidor = nomeServidor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPisPasef() {
		return pisPasef;
	}

	public void setPisPasef(String pisPasef) {
		this.pisPasef = pisPasef;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNivelEscolaridade() {
		return nivelEscolaridade;
	}

	public void setNivelEscolaridade(String nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}

	public Integer getCodigoTitulacaoFormacao() {
		return codigoTitulacaoFormacao;
	}

	public void setCodigoTitulacaoFormacao(Integer codigoTitulacaoFormacao) {
		this.codigoTitulacaoFormacao = codigoTitulacaoFormacao;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getAnoChegada() {
		return anoChegada;
	}

	public void setAnoChegada(Integer anoChegada) {
		this.anoChegada = anoChegada;
	}

	public String getDataPrimeiroEmprego() {
		return dataPrimeiroEmprego;
	}

	public void setDataPrimeiroEmprego(String dataPrimeiroEmprego) {
		this.dataPrimeiroEmprego = dataPrimeiroEmprego;
	}

	public String getIdentificacaoOrigem() {
		return identificacaoOrigem;
	}

	public void setIdentificacaoOrigem(String identificacaoOrigem) {
		this.identificacaoOrigem = identificacaoOrigem;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumeroRegistroGeral() {
		return numeroRegistroGeral;
	}

	public void setNumeroRegistroGeral(String numeroRegistroGeral) {
		this.numeroRegistroGeral = numeroRegistroGeral;
	}

	public String getSiglaOrgaoExpedidor() {
		return siglaOrgaoExpedidor;
	}

	public void setSiglaOrgaoExpedidor(String siglaOrgaoExpedidor) {
		this.siglaOrgaoExpedidor = siglaOrgaoExpedidor;
	}

	public String getDataExpedicaoIdentidade() {
		return dataExpedicaoIdentidade;
	}

	public void setDataExpedicaoIdentidade(String dataExpedicaoIdentidade) {
		this.dataExpedicaoIdentidade = dataExpedicaoIdentidade;
	}

	public String getSiglaUfIdentidade() {
		return siglaUfIdentidade;
	}

	public void setSiglaUfIdentidade(String siglaUfIdentidade) {
		this.siglaUfIdentidade = siglaUfIdentidade;
	}

	public String getNumeroTituloEleitor() {
		return numeroTituloEleitor;
	}

	public void setNumeroTituloEleitor(String numeroTituloEleitor) {
		this.numeroTituloEleitor = numeroTituloEleitor;
	}
	
	//antigo DadosFuncionais:
	

	public Integer getCodigoSituacaoServidor() {
		return codigoSituacaoServidor;
	}

	public void setCodigoSituacaoServidor(Integer codigoSituacaoServidor) {
		this.codigoSituacaoServidor = codigoSituacaoServidor;
	}

	public Integer getNumeroCarteiraDeTrabalho() {
		return numeroCarteiraDeTrabalho;
	}

	public void setNumeroCarteiraDeTrabalho(Integer numeroCarteiraDeTrabalho) {
		this.numeroCarteiraDeTrabalho = numeroCarteiraDeTrabalho;
	}

	public String getSerieCarteiraDeTrabalho() {
		return serieCarteiraDeTrabalho;
	}

	public void setSerieCarteiraDeTrabalho(String serieCarteiraDeTrabalho) {
		this.serieCarteiraDeTrabalho = serieCarteiraDeTrabalho;
	}

	public String getUfCarteiraDeTrabalho() {
		return UfCarteiraDeTrabalho;
	}

	public void setUfCarteiraDeTrabalho(String ufCarteiraDeTrabalho) {
		UfCarteiraDeTrabalho = ufCarteiraDeTrabalho;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getAgenciaBanco() {
		return agenciaBanco;
	}

	public void setAgenciaBanco(String agenciaBanco) {
		this.agenciaBanco = agenciaBanco;
	}

	public String getContaCorrenteBanco() {
		return contaCorrenteBanco;
	}

	public void setContaCorrenteBanco(String contaCorrenteBanco) {
		this.contaCorrenteBanco = contaCorrenteBanco;
	}

	public Integer getJornadaDeTrabalho() {
		return jornadaDeTrabalho;
	}

	public void setJornadaDeTrabalho(Integer jornadaDeTrabalho) {
		this.jornadaDeTrabalho = jornadaDeTrabalho;
	}

	public String getDataCadastramentoServidor() {
		return dataCadastramentoServidor;
	}

	public void setDataCadastramentoServidor(String dataCadastramentoServidor) {
		this.dataCadastramentoServidor = dataCadastramentoServidor;
	}

	public Integer getCodigoGrupoCargo() {
		return codigoGrupoCargo;
	}

	public void setCodigoGrupoCargo(Integer codigoGrupoCargo) {
		this.codigoGrupoCargo = codigoGrupoCargo;
	}

	public Integer getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(Integer codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getClasseCargo() {
		return classeCargo;
	}

	public void setClasseCargo(String classeCargo) {
		this.classeCargo = classeCargo;
	}

	public String getCodigoReferenciaNivelPadraoCargo() {
		return codigoReferenciaNivelPadraoCargo;
	}

	public void setCodigoReferenciaNivelPadraoCargo(
			String codigoReferenciaNivelPadraoCargo) {
		this.codigoReferenciaNivelPadraoCargo = codigoReferenciaNivelPadraoCargo;
	}

	public String getDataEntradaOcupacaoCargo() {
		return dataEntradaOcupacaoCargo;
	}

	public void setDataEntradaOcupacaoCargo(String dataEntradaOcupacaoCargo) {
		this.dataEntradaOcupacaoCargo = dataEntradaOcupacaoCargo;
	}

	public String getDataSaidaCargo() {
		return dataSaidaCargo;
	}

	public void setDataSaidaCargo(String dataSaidaCargo) {
		this.dataSaidaCargo = dataSaidaCargo;
	}

	public String getSiglaFuncao() {
		return siglaFuncao;
	}

	public void setSiglaFuncao(String siglaFuncao) {
		this.siglaFuncao = siglaFuncao;
	}

	public Integer getCodigoNivelFuncao() {
		return codigoNivelFuncao;
	}

	public void setCodigoNivelFuncao(Integer codigoNivelFuncao) {
		this.codigoNivelFuncao = codigoNivelFuncao;
	}

	public String getCodigoEscolaridadeFuncao() {
		return codigoEscolaridadeFuncao;
	}

	public void setCodigoEscolaridadeFuncao(String codigoEscolaridadeFuncao) {
		this.codigoEscolaridadeFuncao = codigoEscolaridadeFuncao;
	}

	public String getCodigoOpcaoFuncao() {
		return codigoOpcaoFuncao;
	}

	public void setCodigoOpcaoFuncao(String codigoOpcaoFuncao) {
		this.codigoOpcaoFuncao = codigoOpcaoFuncao;
	}

	public String getDataIngressoFuncao() {
		return dataIngressoFuncao;
	}

	public void setDataIngressoFuncao(String dataIngressoFuncao) {
		this.dataIngressoFuncao = dataIngressoFuncao;
	}

	public String getDataSaidaFuncao() {
		return dataSaidaFuncao;
	}

	public void setDataSaidaFuncao(String dataSaidaFuncao) {
		this.dataSaidaFuncao = dataSaidaFuncao;
	}

	public Integer getCodigoUnidadeOrganizacionalFuncao() {
		return codigoUnidadeOrganizacionalFuncao;
	}

	public void setCodigoUnidadeOrganizacionalFuncao(
			Integer codigoUnidadeOrganizacionalFuncao) {
		this.codigoUnidadeOrganizacionalFuncao = codigoUnidadeOrganizacionalFuncao;
	}

	public String getSiglaNovaFuncao() {
		return siglaNovaFuncao;
	}

	public void setSiglaNovaFuncao(String siglaNovaFuncao) {
		this.siglaNovaFuncao = siglaNovaFuncao;
	}

	public Integer getCodigoNivelNovaFuncao() {
		return codigoNivelNovaFuncao;
	}

	public void setCodigoNivelNovaFuncao(Integer codigoNivelNovaFuncao) {
		this.codigoNivelNovaFuncao = codigoNivelNovaFuncao;
	}

	public String getCodigoEscolaridadeNovaFuncao() {
		return codigoEscolaridadeNovaFuncao;
	}

	public void setCodigoEscolaridadeNovaFuncao(
			String codigoEscolaridadeNovaFuncao) {
		this.codigoEscolaridadeNovaFuncao = codigoEscolaridadeNovaFuncao;
	}

	public String getCodigoOpcaoNovaFuncao() {
		return codigoOpcaoNovaFuncao;
	}

	public void setCodigoOpcaoNovaFuncao(String codigoOpcaoNovaFuncao) {
		this.codigoOpcaoNovaFuncao = codigoOpcaoNovaFuncao;
	}

	public String getDataIngressoNovaFuncao() {
		return dataIngressoNovaFuncao;
	}

	public void setDataIngressoNovaFuncao(String dataIngressoNovaFuncao) {
		this.dataIngressoNovaFuncao = dataIngressoNovaFuncao;
	}

	public String getDataSaidaNovaFuncao() {
		return dataSaidaNovaFuncao;
	}

	public void setDataSaidaNovaFuncao(String dataSaidaNovaFuncao) {
		this.dataSaidaNovaFuncao = dataSaidaNovaFuncao;
	}

	public Integer getCodigoUnidadeOrganizacionalNovaFuncao() {
		return codigoUnidadeOrganizacionalNovaFuncao;
	}

	public void setCodigoUnidadeOrganizacionalNovaFuncao(
			Integer codigoUnidadeOrganizacionalNovaFuncao) {
		this.codigoUnidadeOrganizacionalNovaFuncao = codigoUnidadeOrganizacionalNovaFuncao;
	}

	public Integer getCodigoUnidadeOrganizacionalLotacao() {
		return codigoUnidadeOrganizacionalLotacao;
	}

	public void setCodigoUnidadeOrganizacionalLotacao(
			Integer codigoUnidadeOrganizacionalLotacao) {
		this.codigoUnidadeOrganizacionalLotacao = codigoUnidadeOrganizacionalLotacao;
	}

	public String getDataLotacao() {
		return dataLotacao;
	}

	public void setDataLotacao(String dataLotacao) {
		this.dataLotacao = dataLotacao;
	}

	public Integer getCodigoOrgaoLocalizacao() {
		return codigoOrgaoLocalizacao;
	}

	public void setCodigoOrgaoLocalizacao(Integer codigoOrgaoLocalizacao) {
		this.codigoOrgaoLocalizacao = codigoOrgaoLocalizacao;
	}

	public Integer getCodigoUnidadeOrganizacionalLocalizacao() {
		return codigoUnidadeOrganizacionalLocalizacao;
	}

	public void setCodigoUnidadeOrganizacionalLocalizacao(
			Integer codigoUnidadeOrganizacionalLocalizacao) {
		this.codigoUnidadeOrganizacionalLocalizacao = codigoUnidadeOrganizacionalLocalizacao;
	}

	public Integer getCodigoGrupoIngressoOrgao() {
		return codigoGrupoIngressoOrgao;
	}

	public void setCodigoGrupoIngressoOrgao(Integer codigoGrupoIngressoOrgao) {
		this.codigoGrupoIngressoOrgao = codigoGrupoIngressoOrgao;
	}

	public Integer getCodigoOcorrenciaIngressoOrgao() {
		return codigoOcorrenciaIngressoOrgao;
	}

	public void setCodigoOcorrenciaIngressoOrgao(
			Integer codigoOcorrenciaIngressoOrgao) {
		this.codigoOcorrenciaIngressoOrgao = codigoOcorrenciaIngressoOrgao;
	}

	public String getDataIngressoOrgao() {
		return dataIngressoOrgao;
	}

	public void setDataIngressoOrgao(String dataIngressoOrgao) {
		this.dataIngressoOrgao = dataIngressoOrgao;
	}

	public Integer getCodigoDiplomaLegalIngressoOrgao() {
		return codigoDiplomaLegalIngressoOrgao;
	}

	public void setCodigoDiplomaLegalIngressoOrgao(
			Integer codigoDiplomaLegalIngressoOrgao) {
		this.codigoDiplomaLegalIngressoOrgao = codigoDiplomaLegalIngressoOrgao;
	}

	public String getNumeroDiplomaLegalIngressoOrgao() {
		return numeroDiplomaLegalIngressoOrgao;
	}

	public void setNumeroDiplomaLegalIngressoOrgao(
			String numeroDiplomaLegalIngressoOrgao) {
		this.numeroDiplomaLegalIngressoOrgao = numeroDiplomaLegalIngressoOrgao;
	}

	public String getDataPublicacaoDiplomaLegalIngressoOrgao() {
		return dataPublicacaoDiplomaLegalIngressoOrgao;
	}

	public void setDataPublicacaoDiplomaLegalIngressoOrgao(
			String dataPublicacaoDiplomaLegalIngressoOrgao) {
		this.dataPublicacaoDiplomaLegalIngressoOrgao = dataPublicacaoDiplomaLegalIngressoOrgao;
	}

	public Integer getCodigoGrupoIngressoServPublico() {
		return codigoGrupoIngressoServPublico;
	}

	public void setCodigoGrupoIngressoServPublico(
			Integer codigoGrupoIngressoServPublico) {
		this.codigoGrupoIngressoServPublico = codigoGrupoIngressoServPublico;
	}

	public Integer getCodigoOcorrenciaIngressoServPublico() {
		return codigoOcorrenciaIngressoServPublico;
	}

	public void setCodigoOcorrenciaIngressoServPublico(
			Integer codigoOcorrenciaIngressoServPublico) {
		this.codigoOcorrenciaIngressoServPublico = codigoOcorrenciaIngressoServPublico;
	}

	public String getDataIngressoServPublico() {
		return dataIngressoServPublico;
	}

	public void setDataIngressoServPublico(String dataIngressoServPublico) {
		this.dataIngressoServPublico = dataIngressoServPublico;
	}

	public Integer getCodigoDiplomaLegalIngressoServPublico() {
		return codigoDiplomaLegalIngressoServPublico;
	}

	public void setCodigoDiplomaLegalIngressoServPublico(
			Integer codigoDiplomaLegalIngressoServPublico) {
		this.codigoDiplomaLegalIngressoServPublico = codigoDiplomaLegalIngressoServPublico;
	}

	public String getNumeroDiplomaLegalIngressoServPublico() {
		return numeroDiplomaLegalIngressoServPublico;
	}

	public void setNumeroDiplomaLegalIngressoServPublico(
			String numeroDiplomaLegalIngressoServPublico) {
		this.numeroDiplomaLegalIngressoServPublico = numeroDiplomaLegalIngressoServPublico;
	}

	public String getDataPublicacaoDiplomaLegalIngressoServPublico() {
		return dataPublicacaoDiplomaLegalIngressoServPublico;
	}

	public void setDataPublicacaoDiplomaLegalIngressoServPublico(
			String dataPublicacaoDiplomaLegalIngressoServPublico) {
		this.dataPublicacaoDiplomaLegalIngressoServPublico = dataPublicacaoDiplomaLegalIngressoServPublico;
	}

	public Integer getCodigoGrupoExclusao() {
		return codigoGrupoExclusao;
	}

	public void setCodigoGrupoExclusao(Integer codigoGrupoExclusao) {
		this.codigoGrupoExclusao = codigoGrupoExclusao;
	}

	public Integer getCodigoOcorrenciaExclusao() {
		return codigoOcorrenciaExclusao;
	}

	public void setCodigoOcorrenciaExclusao(Integer codigoOcorrenciaExclusao) {
		this.codigoOcorrenciaExclusao = codigoOcorrenciaExclusao;
	}

	public String getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(String dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Integer getCodigoDiplomaLegalExclusao() {
		return codigoDiplomaLegalExclusao;
	}

	public void setCodigoDiplomaLegalExclusao(Integer codigoDiplomaLegalExclusao) {
		this.codigoDiplomaLegalExclusao = codigoDiplomaLegalExclusao;
	}

	public String getNumeroDiplomaLegalExclusao() {
		return numeroDiplomaLegalExclusao;
	}

	public void setNumeroDiplomaLegalExclusao(String numeroDiplomaLegalExclusao) {
		this.numeroDiplomaLegalExclusao = numeroDiplomaLegalExclusao;
	}

	public String getDataPublicacaoDiplomaLegalExclusao() {
		return dataPublicacaoDiplomaLegalExclusao;
	}

	public void setDataPublicacaoDiplomaLegalExclusao(
			String dataPublicacaoDiplomaLegalExclusao) {
		this.dataPublicacaoDiplomaLegalExclusao = dataPublicacaoDiplomaLegalExclusao;
	}

	public Integer getCodigoGrupoAfastamento() {
		return codigoGrupoAfastamento;
	}

	public void setCodigoGrupoAfastamento(Integer codigoGrupoAfastamento) {
		this.codigoGrupoAfastamento = codigoGrupoAfastamento;
	}

	public Integer getCodigoOcerrenciaAfastamento() {
		return codigoOcerrenciaAfastamento;
	}

	public void setCodigoOcerrenciaAfastamento(
			Integer codigoOcerrenciaAfastamento) {
		this.codigoOcerrenciaAfastamento = codigoOcerrenciaAfastamento;
	}

	public String getDataInicioAfastamento() {
		return dataInicioAfastamento;
	}

	public void setDataInicioAfastamento(String dataInicioAfastamento) {
		this.dataInicioAfastamento = dataInicioAfastamento;
	}

	public String getDataTerminoAfastamento() {
		return dataTerminoAfastamento;
	}

	public void setDataTerminoAfastamento(String dataTerminoAfastamento) {
		this.dataTerminoAfastamento = dataTerminoAfastamento;
	}

	public Integer getCodigoDiplomaLegalAfastamento() {
		return codigoDiplomaLegalAfastamento;
	}

	public void setCodigoDiplomaLegalAfastamento(
			Integer codigoDiplomaLegalAfastamento) {
		this.codigoDiplomaLegalAfastamento = codigoDiplomaLegalAfastamento;
	}

	public String getNumeroDiplomaLegalAfastamento() {
		return numeroDiplomaLegalAfastamento;
	}

	public void setNumeroDiplomaLegalAfastamento(
			String numeroDiplomaLegalAfastamento) {
		this.numeroDiplomaLegalAfastamento = numeroDiplomaLegalAfastamento;
	}

	public String getDataPublicacaoDiplomaLegalAfastamento() {
		return dataPublicacaoDiplomaLegalAfastamento;
	}

	public void setDataPublicacaoDiplomaLegalAfastamento(
			String dataPublicacaoDiplomaLegalAfastamento) {
		this.dataPublicacaoDiplomaLegalAfastamento = dataPublicacaoDiplomaLegalAfastamento;
	}

	public Integer getCodigoGrupoInatividade() {
		return codigoGrupoInatividade;
	}

	public void setCodigoGrupoInatividade(Integer codigoGrupoInatividade) {
		this.codigoGrupoInatividade = codigoGrupoInatividade;
	}

	public Integer getCodigoOcorrenciaInatividade() {
		return codigoOcorrenciaInatividade;
	}

	public void setCodigoOcorrenciaInatividade(
			Integer codigoOcorrenciaInatividade) {
		this.codigoOcorrenciaInatividade = codigoOcorrenciaInatividade;
	}

	public String getDataInatividade() {
		return dataInatividade;
	}

	public void setDataInatividade(String dataInatividade) {
		this.dataInatividade = dataInatividade;
	}

	public Integer getCodigoDiplomaLegalInatividade() {
		return codigoDiplomaLegalInatividade;
	}

	public void setCodigoDiplomaLegalInatividade(
			Integer codigoDiplomaLegalInatividade) {
		this.codigoDiplomaLegalInatividade = codigoDiplomaLegalInatividade;
	}

	public String getNumeroDiplomaLegalInatividade() {
		return numeroDiplomaLegalInatividade;
	}

	public void setNumeroDiplomaLegalInatividade(
			String numeroDiplomaLegalInatividade) {
		this.numeroDiplomaLegalInatividade = numeroDiplomaLegalInatividade;
	}

	public String getDataPublicacaoDiplomaLegalInatividade() {
		return dataPublicacaoDiplomaLegalInatividade;
	}

	public void setDataPublicacaoDiplomaLegalInatividade(
			String dataPublicacaoDiplomaLegalInatividade) {
		this.dataPublicacaoDiplomaLegalInatividade = dataPublicacaoDiplomaLegalInatividade;
	}

	public String getNumeroProcessoAposentadoria() {
		return numeroProcessoAposentadoria;
	}

	public void setNumeroProcessoAposentadoria(
			String numeroProcessoAposentadoria) {
		this.numeroProcessoAposentadoria = numeroProcessoAposentadoria;
	}

	public Integer getAnoPrevistoAposentadoria() {
		return anoPrevistoAposentadoria;
	}

	public void setAnoPrevistoAposentadoria(Integer anoPrevistoAposentadoria) {
		this.anoPrevistoAposentadoria = anoPrevistoAposentadoria;
	}

	public String getOpcaoAposentadoriaIntegral() {
		return opcaoAposentadoriaIntegral;
	}

	public void setOpcaoAposentadoriaIntegral(String opcaoAposentadoriaIntegral) {
		this.opcaoAposentadoriaIntegral = opcaoAposentadoriaIntegral;
	}

	public Integer getCodigoGrupoModifFuncional() {
		return codigoGrupoModifFuncional;
	}

	public void setCodigoGrupoModifFuncional(Integer codigoGrupoModifFuncional) {
		this.codigoGrupoModifFuncional = codigoGrupoModifFuncional;
	}

	public Integer getCodigoOcorrenciaModifFuncional() {
		return codigoOcorrenciaModifFuncional;
	}

	public void setCodigoOcorrenciaModifFuncional(
			Integer codigoOcorrenciaModifFuncional) {
		this.codigoOcorrenciaModifFuncional = codigoOcorrenciaModifFuncional;
	}

	public String getDataModifFuncional() {
		return dataModifFuncional;
	}

	public void setDataModifFuncional(String dataModifFuncional) {
		this.dataModifFuncional = dataModifFuncional;
	}

	public Integer getCodigoDiplomaLegalModifFuncional() {
		return codigoDiplomaLegalModifFuncional;
	}

	public void setCodigoDiplomaLegalModifFuncional(
			Integer codigoDiplomaLegalModifFuncional) {
		this.codigoDiplomaLegalModifFuncional = codigoDiplomaLegalModifFuncional;
	}

	public String getNumeroDiplomaLegalModifFuncional() {
		return numeroDiplomaLegalModifFuncional;
	}

	public void setNumeroDiplomaLegalModifFuncional(
			String numeroDiplomaLegalModifFuncional) {
		this.numeroDiplomaLegalModifFuncional = numeroDiplomaLegalModifFuncional;
	}

	public String getDataPublicacaoDiplomaLegalModifFuncional() {
		return dataPublicacaoDiplomaLegalModifFuncional;
	}

	public void setDataPublicacaoDiplomaLegalModifFuncional(
			String dataPublicacaoDiplomaLegalModifFuncional) {
		this.dataPublicacaoDiplomaLegalModifFuncional = dataPublicacaoDiplomaLegalModifFuncional;
	}

	public String getCodigoRegimeJuridicoAnterior() {
		return codigoRegimeJuridicoAnterior;
	}

	public void setCodigoRegimeJuridicoAnterior(
			String codigoRegimeJuridicoAnterior) {
		this.codigoRegimeJuridicoAnterior = codigoRegimeJuridicoAnterior;
	}

	public Integer getCodigoSituaçãoServidorAnterior() {
		return codigoSituaçãoServidorAnterior;
	}

	public void setCodigoSituaçãoServidorAnterior(
			Integer codigoSituaçãoServidorAnterior) {
		this.codigoSituaçãoServidorAnterior = codigoSituaçãoServidorAnterior;
	}

	public Integer getCodigoOrgaoDestinoMudancaOrgao() {
		return codigoOrgaoDestinoMudancaOrgao;
	}

	public void setCodigoOrgaoDestinoMudancaOrgao(
			Integer codigoOrgaoDestinoMudancaOrgao) {
		this.codigoOrgaoDestinoMudancaOrgao = codigoOrgaoDestinoMudancaOrgao;
	}

	public String getDataLiberacaoMudancaOrgao() {
		return dataLiberacaoMudancaOrgao;
	}

	public void setDataLiberacaoMudancaOrgao(String dataLiberacaoMudancaOrgao) {
		this.dataLiberacaoMudancaOrgao = dataLiberacaoMudancaOrgao;
	}

	public Integer getCodigoOrgaoOrigemMudancaOrgao() {
		return codigoOrgaoOrigemMudancaOrgao;
	}

	public void setCodigoOrgaoOrigemMudancaOrgao(
			Integer codigoOrgaoOrigemMudancaOrgao) {
		this.codigoOrgaoOrigemMudancaOrgao = codigoOrgaoOrigemMudancaOrgao;
	}

	public Integer getCodigoOrgaoAnterior() {
		return codigoOrgaoAnterior;
	}

	public void setCodigoOrgaoAnterior(Integer codigoOrgaoAnterior) {
		this.codigoOrgaoAnterior = codigoOrgaoAnterior;
	}

	public String getMatriculaAnterior() {
		return matriculaAnterior;
	}

	public void setMatriculaAnterior(String matriculaAnterior) {
		this.matriculaAnterior = matriculaAnterior;
	}

	public Integer getCodigoOrgaoExtintoModificado() {
		return codigoOrgaoExtintoModificado;
	}

	public void setCodigoOrgaoExtintoModificado(
			Integer codigoOrgaoExtintoModificado) {
		this.codigoOrgaoExtintoModificado = codigoOrgaoExtintoModificado;
	}

	public String getMatriculaServidorExtintaModificada() {
		return matriculaServidorExtintaModificada;
	}

	public void setMatriculaServidorExtintaModificada(
			String matriculaServidorExtintaModificada) {
		this.matriculaServidorExtintaModificada = matriculaServidorExtintaModificada;
	}

	public Integer getCodigoOrgaoAtual() {
		return codigoOrgaoAtual;
	}

	public void setCodigoOrgaoAtual(Integer codigoOrgaoAtual) {
		this.codigoOrgaoAtual = codigoOrgaoAtual;
	}

	public String getMatriculaAtual() {
		return matriculaAtual;
	}

	public void setMatriculaAtual(String matriculaAtual) {
		this.matriculaAtual = matriculaAtual;
	}

	public Integer getCodigoUpagMudancaUnidadePagadora() {
		return codigoUpagMudancaUnidadePagadora;
	}

	public void setCodigoUpagMudancaUnidadePagadora(
			Integer codigoUpagMudancaUnidadePagadora) {
		this.codigoUpagMudancaUnidadePagadora = codigoUpagMudancaUnidadePagadora;
	}

	public String getDataLiberacaoMudancaUnidadePagadora() {
		return dataLiberacaoMudancaUnidadePagadora;
	}

	public void setDataLiberacaoMudancaUnidadePagadora(
			String dataLiberacaoMudancaUnidadePagadora) {
		this.dataLiberacaoMudancaUnidadePagadora = dataLiberacaoMudancaUnidadePagadora;
	}

	public String getMotivoMudancaUnidadePagadora() {
		return motivoMudancaUnidadePagadora;
	}

	public void setMotivoMudancaUnidadePagadora(
			String motivoMudancaUnidadePagadora) {
		this.motivoMudancaUnidadePagadora = motivoMudancaUnidadePagadora;
	}

	public Integer getCodigoIndicadorDePagamentoServidor() {
		return codigoIndicadorDePagamentoServidor;
	}

	public void setCodigoIndicadorDePagamentoServidor(
			Integer codigoIndicadorDePagamentoServidor) {
		this.codigoIndicadorDePagamentoServidor = codigoIndicadorDePagamentoServidor;
	}

	public String getCodigoTipoValeAlimentacao() {
		return codigoTipoValeAlimentacao;
	}

	public void setCodigoTipoValeAlimentacao(String codigoTipoValeAlimentacao) {
		this.codigoTipoValeAlimentacao = codigoTipoValeAlimentacao;
	}

	public String getDataInicioValeAlimentacao() {
		return dataInicioValeAlimentacao;
	}

	public void setDataInicioValeAlimentacao(String dataInicioValeAlimentacao) {
		this.dataInicioValeAlimentacao = dataInicioValeAlimentacao;
	}

	public String getDataFimValeAlimentacao() {
		return dataFimValeAlimentacao;
	}

	public void setDataFimValeAlimentacao(String dataFimValeAlimentacao) {
		this.dataFimValeAlimentacao = dataFimValeAlimentacao;
	}

	public Integer getCodigoIndicadorDeOperadorDeRaioX() {
		return codigoIndicadorDeOperadorDeRaioX;
	}

	public void setCodigoIndicadorDeOperadorDeRaioX(
			Integer codigoIndicadorDeOperadorDeRaioX) {
		this.codigoIndicadorDeOperadorDeRaioX = codigoIndicadorDeOperadorDeRaioX;
	}

	public Integer getCodigoOrgaoRequisitante() {
		return codigoOrgaoRequisitante;
	}

	public void setCodigoOrgaoRequisitante(Integer codigoOrgaoRequisitante) {
		this.codigoOrgaoRequisitante = codigoOrgaoRequisitante;
	}

	public Integer getCodigoDavaga() {
		return codigoDavaga;
	}

	public void setCodigoDavaga(Integer codigoDavaga) {
		this.codigoDavaga = codigoDavaga;
	}

	public Integer getCodigoDoGrupoPosse() {
		return codigoDoGrupoPosse;
	}

	public void setCodigoDoGrupoPosse(Integer codigoDoGrupoPosse) {
		this.codigoDoGrupoPosse = codigoDoGrupoPosse;
	}

	public Integer getCodigoOcorrenciaPosse() {
		return codigoOcorrenciaPosse;
	}

	public void setCodigoOcorrenciaPosse(Integer codigoOcorrenciaPosse) {
		this.codigoOcorrenciaPosse = codigoOcorrenciaPosse;
	}

	public String getDataPosse() {
		return dataPosse;
	}

	public void setDataPosse(String dataPosse) {
		this.dataPosse = dataPosse;
	}

	public Integer getCodigoDiplomaPosse() {
		return codigoDiplomaPosse;
	}

	public void setCodigoDiplomaPosse(Integer codigoDiplomaPosse) {
		this.codigoDiplomaPosse = codigoDiplomaPosse;
	}

	public String getDataDiplomaPosse() {
		return dataDiplomaPosse;
	}

	public void setDataDiplomaPosse(String dataDiplomaPosse) {
		this.dataDiplomaPosse = dataDiplomaPosse;
	}

	public String getNumeroDiplomaPosse() {
		return numeroDiplomaPosse;
	}

	public void setNumeroDiplomaPosse(String numeroDiplomaPosse) {
		this.numeroDiplomaPosse = numeroDiplomaPosse;
	}

	public Integer getCodigoGrupoOcorrenciaGrupoReversaoAtividade() {
		return codigoGrupoOcorrenciaGrupoReversaoAtividade;
	}

	public void setCodigoGrupoOcorrenciaGrupoReversaoAtividade(
			Integer codigoGrupoOcorrenciaGrupoReversaoAtividade) {
		this.codigoGrupoOcorrenciaGrupoReversaoAtividade = codigoGrupoOcorrenciaGrupoReversaoAtividade;
	}

	public Integer getCodigoOcorrenciaGrupoReversaoAtividade() {
		return codigoOcorrenciaGrupoReversaoAtividade;
	}

	public void setCodigoOcorrenciaGrupoReversaoAtividade(
			Integer codigoOcorrenciaGrupoReversaoAtividade) {
		this.codigoOcorrenciaGrupoReversaoAtividade = codigoOcorrenciaGrupoReversaoAtividade;
	}

	public String getDataOcorrenciaGrupoReversaoAtividade() {
		return dataOcorrenciaGrupoReversaoAtividade;
	}

	public void setDataOcorrenciaGrupoReversaoAtividade(
			String dataOcorrenciaGrupoReversaoAtividade) {
		this.dataOcorrenciaGrupoReversaoAtividade = dataOcorrenciaGrupoReversaoAtividade;
	}

	public Integer getCodigoDiplomaGrupoReversaoAtividade() {
		return codigoDiplomaGrupoReversaoAtividade;
	}

	public void setCodigoDiplomaGrupoReversaoAtividade(
			Integer codigoDiplomaGrupoReversaoAtividade) {
		this.codigoDiplomaGrupoReversaoAtividade = codigoDiplomaGrupoReversaoAtividade;
	}

	public String getDataPublicacaoDiplomaGrupoReversaoAtividade() {
		return dataPublicacaoDiplomaGrupoReversaoAtividade;
	}

	public void setDataPublicacaoDiplomaGrupoReversaoAtividade(
			String dataPublicacaoDiplomaGrupoReversaoAtividade) {
		this.dataPublicacaoDiplomaGrupoReversaoAtividade = dataPublicacaoDiplomaGrupoReversaoAtividade;
	}

	public String getNumeroDiplomaGrupoReversaoAtividade() {
		return numeroDiplomaGrupoReversaoAtividade;
	}

	public void setNumeroDiplomaGrupoReversaoAtividade(
			String numeroDiplomaGrupoReversaoAtividade) {
		this.numeroDiplomaGrupoReversaoAtividade = numeroDiplomaGrupoReversaoAtividade;
	}

}
