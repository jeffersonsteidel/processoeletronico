package br.com.progepe.extract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Injetor {

	private List<DadosPessoais> dadosPessoaisList = new ArrayList<DadosPessoais>();//cria lista de Dados Pessoais
	private List<DadosFuncionais> dadosFuncionaisList = new ArrayList<DadosFuncionais>();//cria lista de Dados Funcionais

	public List<DadosPessoais> getDadosPessoaisList() {
		return dadosPessoaisList;
	}
	public List<DadosFuncionais> getDadosFuncionaisList() {
		return dadosFuncionaisList;
	}
	
	public void setDadosPessoaisList(List<DadosPessoais> dadosPessoaisList) {
		this.dadosPessoaisList = dadosPessoaisList;
	}
	public void setDadosFuncionaisList(List<DadosFuncionais> dadosFuncionaisList) {
		this.dadosFuncionaisList = dadosFuncionaisList;
	}

	public void carregarDadosPessoais() {
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));
			while (br.ready())
			{
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {

						DadosPessoais dadosPessoais = new DadosPessoais();
						
						dadosPessoais.setMatriculaSiape(linha.substring(9, 16));
						dadosPessoais.setDvMatricula(linha.substring(16, 17));
						dadosPessoais.setTipoRegistro(linha.substring(17, 18));
						dadosPessoais.setNomeServidor(linha.substring(20, 80));
						dadosPessoais.setCpf(linha.substring(80, 91));
						dadosPessoais.setPisPasef(linha.substring(91,102));
						dadosPessoais.setNomeMae(linha.substring(102, 152));
						dadosPessoais.setSexo(linha.substring(152, 153));
						dadosPessoais.setDataNascimento(linha.substring(153, 161));
						dadosPessoais.setEstadoCivil(linha.substring(161, 162));
						dadosPessoais.setNivelEscolaridade(linha.substring(162, 164));
						dadosPessoais.setCodigoTitulacaoFormacao(linha.substring(164, 166));
						dadosPessoais.setNacionalidade(linha.substring(171, 172));
						dadosPessoais.setNaturalidade(linha.substring(172, 174));
						dadosPessoais.setPais(linha.substring(174, 177));
						dadosPessoais.setAnoChegada(linha.substring(177, 181));
						dadosPessoais.setDataPrimeiroEmprego(linha.substring(185, 193));
						dadosPessoais.setIdentificacaoOrigem(linha.substring(193, 201));
						dadosPessoais.setLogradouro(linha.substring(201, 241));
						dadosPessoais.setNumeroEndereco(linha.substring(241, 247));
						dadosPessoais.setComplementoEndereco(linha.substring(247, 268));
						dadosPessoais.setBairro(linha.substring(268, 293));
						dadosPessoais.setMunicipio(linha.substring(293, 323));
						dadosPessoais.setCep(linha.substring(323, 331));
						dadosPessoais.setUf(linha.substring(331, 333));
						dadosPessoais.setSiglaOrgaoExpedidor(linha.substring(347, 352));
						dadosPessoais.setDataExpedicaoIdentidade(linha.substring(352, 360));
						dadosPessoais.setSiglaUfIdentidade(linha.substring(360, 362));
						dadosPessoais.setNumeroTituloEleitor(linha.substring(362, 375));	
				
						dadosPessoaisList.add(dadosPessoais);
					}
				
					else if (tipoRegistro.equals(2)) {
						
						DadosFuncionais dadosFuncionais = new DadosFuncionais();
						
						//pagina 5:
						dadosFuncionais.setMatriculaSiape(linha.substring(9, 16));
						dadosFuncionais.setTipoRegistro(linha.substring(17,18));
						dadosFuncionais.setCodigoSituacaoServidor(linha.substring(23, 25));
						dadosFuncionais.setNumeroCarteiraDeTrabalho(linha.substring(25, 31));
						dadosFuncionais.setSerieCarteiraDeTrabalho(linha.substring(31, 36));
						dadosFuncionais.setUfCarteiraDeTrabalho(linha.substring(36, 38));
						dadosFuncionais.setCodigoBanco(linha.substring(38, 41));
						dadosFuncionais.setAgenciaBanco(linha.substring(41, 47));
						dadosFuncionais.setContaCorrenteBanco(linha.substring(47, 60));
						dadosFuncionais.setJornadaDeTrabalho(linha.substring(90, 92));
						dadosFuncionais.setDataCadastramentoServidor(linha.substring(94, 102));
						dadosFuncionais.setCodigoGrupoCargo(linha.substring(113, 116));
						dadosFuncionais.setCodigoCargo(linha.substring(116, 119));
						dadosFuncionais.setClasseCargo(linha.substring(119, 120));
						dadosFuncionais.setCodigoReferenciaNivelPadraoCargo(linha.substring(120, 123));
						dadosFuncionais.setDataEntradaOcupacaoCargo(linha.substring(123, 131));
						dadosFuncionais.setDataSaidaCargo(linha.substring(131, 139));
						dadosFuncionais.setSiglaFuncao(linha.substring(139, 142));
						dadosFuncionais.setCodigoNivelFuncao(linha.substring(142, 147));
						dadosFuncionais.setCodigoEscolaridadeFuncao(linha.substring(147, 149));
						//pagina 6:
						dadosFuncionais.setCodigoOpcaoFuncao(linha.substring(149, 150));
						dadosFuncionais.setDataIngressoFuncao(linha.substring(150, 158));
						dadosFuncionais.setDataSaidaFuncao(linha.substring(158, 166));
						dadosFuncionais.setCodigoUnidadeOrganizacionalFuncao(linha.substring(166, 175));
						dadosFuncionais.setSiglaNovaFuncao(linha.substring(175, 178));
						dadosFuncionais.setCodigoNivelNovaFuncao(linha.substring(178, 183));
						dadosFuncionais.setCodigoEscolaridadeNovaFuncao(linha.substring(183, 185));
						dadosFuncionais.setCodigoOpcaoNovaFuncao(linha.substring(185, 186));
						dadosFuncionais.setDataIngressoNovaFuncao(linha.substring(186, 194));
						dadosFuncionais.setDataSaidaNovaFuncao(linha.substring(194, 202));
						dadosFuncionais.setCodigoUnidadeOrganizacionalNovaFuncao(linha.substring(202, 211));
						dadosFuncionais.setCodigoUnidadeOrganizacionalLotacao(linha.substring(215, 224));
						dadosFuncionais.setDataLotacao(linha.substring(224, 232));
						dadosFuncionais.setCodigoOrgaoLocalizacao(linha.substring(232, 237));
						dadosFuncionais.setCodigoUnidadeOrganizacionalLocalizacao(linha.substring(237, 246));
						dadosFuncionais.setCodigoGrupoIngressoOrgao(linha.substring(246, 248));
						dadosFuncionais.setCodigoOcorrenciaIngressoOrgao(linha.substring(248, 251));
						dadosFuncionais.setDataIngressoOrgao(linha.substring(251, 259));
						dadosFuncionais.setCodigoDiplomaLegalIngressoOrgao(linha.substring(259, 261));
						dadosFuncionais.setNumeroDiplomaLegalIngressoOrgao(linha.substring(261, 270));
						dadosFuncionais.setDataPublicacaoDiplomaLegalIngressoOrgao(linha.substring(270, 278));
						dadosFuncionais.setCodigoGrupoIngressoServPublico(linha.substring(278, 280));
						dadosFuncionais.setCodigoOcorrenciaIngressoServPublico(linha.substring(280, 283));
						dadosFuncionais.setDataIngressoServPublico(linha.substring(283, 291));
						dadosFuncionais.setCodigoDiplomaLegalIngressoServPublico(linha.substring(291, 293));
						dadosFuncionais.setNumeroDiplomaLegalIngressoServPublico(linha.substring(293, 302));
						dadosFuncionais.setDataPublicacaoDiplomaLegalIngressoServPublico(linha.substring(302, 310));
						dadosFuncionais.setCodigoGrupoExclusao(linha.substring(310, 312));
						dadosFuncionais.setCodigoOcorrenciaExclusao(linha.substring(312, 315));
						dadosFuncionais.setDataExclusao(linha.substring(315, 323));
						dadosFuncionais.setCodigoDiplomaLegalExclusao(linha.substring(323, 325));
						dadosFuncionais.setNumeroDiplomaLegalExclusao(linha.substring(325, 334));
						dadosFuncionais.setDataPublicacaoDiplomaLegalExclusao(linha.substring(334, 342));
						//página 7
						dadosFuncionais.setCodigoGrupoAfastamento(linha.substring(342, 344));
						dadosFuncionais.setCodigoOcerrenciaAfastamento(linha.substring(344, 347));
						dadosFuncionais.setDataInicioAfastamento(linha.substring(347, 355));
						dadosFuncionais.setDataTerminoAfastamento(linha.substring(355, 363));
						dadosFuncionais.setCodigoDiplomaLegalAfastamento(linha.substring(363, 365));
						dadosFuncionais.setNumeroDiplomaLegalAfastamento(linha.substring(365, 374));
						dadosFuncionais.setDataPublicacaoDiplomaLegalAfastamento(linha.substring(374, 382));
						dadosFuncionais.setCodigoGrupoInatividade(linha.substring(382, 384));
						dadosFuncionais.setCodigoOcorrenciaInatividade(linha.substring(384, 387));
						dadosFuncionais.setDataInatividade(linha.substring(388, 395));
						dadosFuncionais.setCodigoDiplomaLegalInatividade(linha.substring(395, 397));
						dadosFuncionais.setNumeroDiplomaLegalInatividade(linha.substring(397, 406));
						dadosFuncionais.setDataPublicacaoDiplomaLegalInatividade(linha.substring(406, 414));
						dadosFuncionais.setNumeroProcessoAposentadoria(linha.substring(414, 429));
						dadosFuncionais.setAnoPrevistoAposentadoria(linha.substring(429, 433));
						dadosFuncionais.setOpcaoAposentadoriaIntegral(linha.substring(433, 434));
						dadosFuncionais.setCodigoGrupoModifFuncional(linha.substring(443, 445));
						dadosFuncionais.setCodigoOcorrenciaModifFuncional(linha.substring(445, 448));
						dadosFuncionais.setDataModifFuncional(linha.substring(448, 456));
						dadosFuncionais.setCodigoDiplomaLegalModifFuncional(linha.substring(456, 458));
						dadosFuncionais.setNumeroDiplomaLegalModifFuncional(linha.substring(458, 467));
						dadosFuncionais.setDataPublicacaoDiplomaLegalModifFuncional(linha.substring(467, 475));
						dadosFuncionais.setCodigoRegimeJuridicoAnterior(linha.substring(475, 478));
						dadosFuncionais.setCodigoSituaçãoServidorAnterior(linha.substring(478, 480));
						dadosFuncionais.setCodigoOrgaoDestinoMudancaOrgao(linha.substring(480, 485));
						dadosFuncionais.setDataLiberacaoMudancaOrgao(linha.substring(485, 493));
						dadosFuncionais.setCodigoOrgaoOrigemMudancaOrgao(linha.substring(493, 498));
						dadosFuncionais.setCodigoOrgaoAnterior(linha.substring(498, 503));
						dadosFuncionais.setMatriculaAnterior(linha.substring(503, 510));
						dadosFuncionais.setCodigoOrgaoExtintoModificado(linha.substring(510, 515));
						dadosFuncionais.setMatriculaServidorExtintaModificada(linha.substring(515, 522));
						dadosFuncionais.setCodigoOrgaoAtual(linha.substring(522, 527));
				    	dadosFuncionais.setMatriculaAtual(linha.substring(527, 534));
				    	//página 8
						dadosFuncionais.setCodigoUpagMudancaUnidadePagadora(linha.substring(534, 543));
						dadosFuncionais.setDataLiberacaoMudancaUnidadePagadora(linha.substring(543, 551));
						dadosFuncionais.setMotivoMudancaUnidadePagadora(linha.substring(551, 552));
						dadosFuncionais.setCodigoIndicadorDePagamentoServidor(linha.substring(552, 553));
						dadosFuncionais.setCodigoTipoValeAlimentacao(linha.substring(642, 643));
						dadosFuncionais.setDataInicioValeAlimentacao(linha.substring(643, 651));
						dadosFuncionais.setDataFimValeAlimentacao(linha.substring(651, 659));
						dadosFuncionais.setCodigoIndicadorDeOperadorDeRaioX(linha.substring(659, 660));
						dadosFuncionais.setCodigoOrgaoRequisitante(linha.substring(660, 665));
						dadosFuncionais.setCodigoDavaga(linha.substring(665, 672));
						dadosFuncionais.setCodigoDoGrupoPosse(linha.substring(679, 681));
						dadosFuncionais.setCodigoOcorrenciaPosse(linha.substring(681, 684));
						dadosFuncionais.setDataPosse(linha.substring(684, 692));
						dadosFuncionais.setCodigoDiplomaPosse(linha.substring(692, 694));
						dadosFuncionais.setDataDiplomaPosse(linha.substring(694, 702));
						dadosFuncionais.setNumeroDiplomaPosse(linha.substring(702, 711));
						dadosFuncionais.setCodigoGrupoOcorrenciaGrupoReversaoAtividade(linha.substring(711, 713));
						dadosFuncionais.setDataOcorrenciaGrupoReversaoAtividade(linha.substring(716, 724));
						dadosFuncionais.setCodigoDiplomaGrupoReversaoAtividade(linha.substring(724, 726));
						dadosFuncionais.setDataPublicacaoDiplomaGrupoReversaoAtividade(linha.substring(726, 734));
						dadosFuncionais.setNumeroDiplomaGrupoReversaoAtividade(linha.substring(734, 743));
						
						dadosFuncionaisList.add(dadosFuncionais);
					}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void carregarDadosFuncionais() {
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));
			while (br.ready())
			{
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(2)) {
				
						DadosFuncionais dadosFuncionais = new DadosFuncionais();
						
						//pagina 5:
						dadosFuncionais.setMatriculaSiape(linha.substring(9, 16));
						dadosFuncionais.setTipoRegistro(linha.substring(17,18));
						dadosFuncionais.setCodigoSituacaoServidor(linha.substring(23, 25));
						dadosFuncionais.setNumeroCarteiraDeTrabalho(linha.substring(25, 31));
						dadosFuncionais.setSerieCarteiraDeTrabalho(linha.substring(31, 36));
						dadosFuncionais.setUfCarteiraDeTrabalho(linha.substring(36, 38));
						dadosFuncionais.setCodigoBanco(linha.substring(38, 41));
						dadosFuncionais.setAgenciaBanco(linha.substring(41, 47));
						dadosFuncionais.setContaCorrenteBanco(linha.substring(47, 60));
						dadosFuncionais.setJornadaDeTrabalho(linha.substring(90, 92));
						dadosFuncionais.setDataCadastramentoServidor(linha.substring(94, 102));
						dadosFuncionais.setCodigoGrupoCargo(linha.substring(113, 116));
						dadosFuncionais.setCodigoCargo(linha.substring(116, 119));
						dadosFuncionais.setClasseCargo(linha.substring(119, 120));
						dadosFuncionais.setCodigoReferenciaNivelPadraoCargo(linha.substring(120, 123));
						dadosFuncionais.setDataEntradaOcupacaoCargo(linha.substring(123, 131));
						dadosFuncionais.setDataSaidaCargo(linha.substring(131, 139));
						dadosFuncionais.setSiglaFuncao(linha.substring(139, 142));
						dadosFuncionais.setCodigoNivelFuncao(linha.substring(142, 147));
						dadosFuncionais.setCodigoEscolaridadeFuncao(linha.substring(147, 149));
						//pagina 6:
						dadosFuncionais.setCodigoOpcaoFuncao(linha.substring(149, 150));
						dadosFuncionais.setDataIngressoFuncao(linha.substring(150, 158));
						dadosFuncionais.setDataSaidaFuncao(linha.substring(158, 166));
						dadosFuncionais.setCodigoUnidadeOrganizacionalFuncao(linha.substring(166, 175));
						dadosFuncionais.setSiglaNovaFuncao(linha.substring(175, 178));
						dadosFuncionais.setCodigoNivelNovaFuncao(linha.substring(178, 183));
						dadosFuncionais.setCodigoEscolaridadeNovaFuncao(linha.substring(183, 185));
						dadosFuncionais.setCodigoOpcaoNovaFuncao(linha.substring(185, 186));
						dadosFuncionais.setDataIngressoNovaFuncao(linha.substring(186, 194));
						dadosFuncionais.setDataSaidaNovaFuncao(linha.substring(194, 202));
						dadosFuncionais.setCodigoUnidadeOrganizacionalNovaFuncao(linha.substring(202, 211));
						dadosFuncionais.setCodigoUnidadeOrganizacionalLotacao(linha.substring(215, 224));
						dadosFuncionais.setDataLotacao(linha.substring(224, 232));
						dadosFuncionais.setCodigoOrgaoLocalizacao(linha.substring(232, 237));
						dadosFuncionais.setCodigoUnidadeOrganizacionalLocalizacao(linha.substring(237, 246));
						dadosFuncionais.setCodigoGrupoIngressoOrgao(linha.substring(246, 248));
						dadosFuncionais.setCodigoOcorrenciaIngressoOrgao(linha.substring(248, 251));
						dadosFuncionais.setDataIngressoOrgao(linha.substring(251, 259));
						dadosFuncionais.setCodigoDiplomaLegalIngressoOrgao(linha.substring(259, 261));
						dadosFuncionais.setNumeroDiplomaLegalIngressoOrgao(linha.substring(261, 270));
						dadosFuncionais.setDataPublicacaoDiplomaLegalIngressoOrgao(linha.substring(270, 278));
						dadosFuncionais.setCodigoGrupoIngressoServPublico(linha.substring(278, 280));
						dadosFuncionais.setCodigoOcorrenciaIngressoServPublico(linha.substring(280, 283));
						dadosFuncionais.setDataIngressoServPublico(linha.substring(283, 291));
						dadosFuncionais.setCodigoDiplomaLegalIngressoServPublico(linha.substring(291, 293));
						dadosFuncionais.setNumeroDiplomaLegalIngressoServPublico(linha.substring(293, 302));
						dadosFuncionais.setDataPublicacaoDiplomaLegalIngressoServPublico(linha.substring(302, 310));
						dadosFuncionais.setCodigoGrupoExclusao(linha.substring(310, 312));
						dadosFuncionais.setCodigoOcorrenciaExclusao(linha.substring(312, 315));
						dadosFuncionais.setDataExclusao(linha.substring(315, 323));
						dadosFuncionais.setCodigoDiplomaLegalExclusao(linha.substring(323, 325));
						dadosFuncionais.setNumeroDiplomaLegalExclusao(linha.substring(325, 334));
						dadosFuncionais.setDataPublicacaoDiplomaLegalExclusao(linha.substring(334, 342));
						//página 7
						dadosFuncionais.setCodigoGrupoAfastamento(linha.substring(342, 344));
						dadosFuncionais.setCodigoOcerrenciaAfastamento(linha.substring(344, 347));
						dadosFuncionais.setDataInicioAfastamento(linha.substring(347, 355));
						dadosFuncionais.setDataTerminoAfastamento(linha.substring(355, 363));
						dadosFuncionais.setCodigoDiplomaLegalAfastamento(linha.substring(363, 365));
						dadosFuncionais.setNumeroDiplomaLegalAfastamento(linha.substring(365, 374));
						dadosFuncionais.setDataPublicacaoDiplomaLegalAfastamento(linha.substring(374, 382));
						dadosFuncionais.setCodigoGrupoInatividade(linha.substring(382, 384));
						dadosFuncionais.setCodigoOcorrenciaInatividade(linha.substring(384, 387));
						dadosFuncionais.setDataInatividade(linha.substring(388, 395));
						dadosFuncionais.setCodigoDiplomaLegalInatividade(linha.substring(395, 397));
						dadosFuncionais.setNumeroDiplomaLegalInatividade(linha.substring(397, 406));
						dadosFuncionais.setDataPublicacaoDiplomaLegalInatividade(linha.substring(406, 414));
						dadosFuncionais.setNumeroProcessoAposentadoria(linha.substring(414, 429));
						dadosFuncionais.setAnoPrevistoAposentadoria(linha.substring(429, 433));
						dadosFuncionais.setOpcaoAposentadoriaIntegral(linha.substring(433, 434));
						dadosFuncionais.setCodigoGrupoModifFuncional(linha.substring(443, 445));
						dadosFuncionais.setCodigoOcorrenciaModifFuncional(linha.substring(445, 448));
						dadosFuncionais.setDataModifFuncional(linha.substring(448, 456));
						dadosFuncionais.setCodigoDiplomaLegalModifFuncional(linha.substring(456, 458));
						dadosFuncionais.setNumeroDiplomaLegalModifFuncional(linha.substring(458, 467));
						dadosFuncionais.setDataPublicacaoDiplomaLegalModifFuncional(linha.substring(467, 475));
						dadosFuncionais.setCodigoRegimeJuridicoAnterior(linha.substring(475, 478));
						dadosFuncionais.setCodigoSituaçãoServidorAnterior(linha.substring(478, 480));
						dadosFuncionais.setCodigoOrgaoDestinoMudancaOrgao(linha.substring(480, 485));
						dadosFuncionais.setDataLiberacaoMudancaOrgao(linha.substring(485, 493));
						dadosFuncionais.setCodigoOrgaoOrigemMudancaOrgao(linha.substring(493, 498));
						dadosFuncionais.setCodigoOrgaoAnterior(linha.substring(498, 503));
						dadosFuncionais.setMatriculaAnterior(linha.substring(503, 510));
						dadosFuncionais.setCodigoOrgaoExtintoModificado(linha.substring(510, 515));
						dadosFuncionais.setMatriculaServidorExtintaModificada(linha.substring(515, 522));
						dadosFuncionais.setCodigoOrgaoAtual(linha.substring(522, 527));
				    	dadosFuncionais.setMatriculaAtual(linha.substring(527, 534));
				    	//página 8
						dadosFuncionais.setCodigoUpagMudancaUnidadePagadora(linha.substring(534, 543));
						dadosFuncionais.setDataLiberacaoMudancaUnidadePagadora(linha.substring(543, 551));
						dadosFuncionais.setMotivoMudancaUnidadePagadora(linha.substring(551, 552));
						dadosFuncionais.setCodigoIndicadorDePagamentoServidor(linha.substring(552, 553));
						dadosFuncionais.setCodigoTipoValeAlimentacao(linha.substring(642, 643));
						dadosFuncionais.setDataInicioValeAlimentacao(linha.substring(643, 651));
						dadosFuncionais.setDataFimValeAlimentacao(linha.substring(651, 659));
						dadosFuncionais.setCodigoIndicadorDeOperadorDeRaioX(linha.substring(659, 660));
						dadosFuncionais.setCodigoOrgaoRequisitante(linha.substring(660, 665));
						dadosFuncionais.setCodigoDavaga(linha.substring(665, 672));
						dadosFuncionais.setCodigoDoGrupoPosse(linha.substring(679, 681));
						dadosFuncionais.setCodigoOcorrenciaPosse(linha.substring(681, 684));
						dadosFuncionais.setDataPosse(linha.substring(684, 692));
						dadosFuncionais.setCodigoDiplomaPosse(linha.substring(692, 694));
						dadosFuncionais.setDataDiplomaPosse(linha.substring(694, 702));
						dadosFuncionais.setNumeroDiplomaPosse(linha.substring(702, 711));
						dadosFuncionais.setCodigoGrupoOcorrenciaGrupoReversaoAtividade(linha.substring(711, 713));
						dadosFuncionais.setDataOcorrenciaGrupoReversaoAtividade(linha.substring(716, 724));
						dadosFuncionais.setCodigoDiplomaGrupoReversaoAtividade(linha.substring(724, 726));
						dadosFuncionais.setDataPublicacaoDiplomaGrupoReversaoAtividade(linha.substring(726, 734));
						dadosFuncionais.setNumeroDiplomaGrupoReversaoAtividade(linha.substring(734, 743));
						
						dadosFuncionaisList.add(dadosFuncionais);
					}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) 
	{
		Injetor injetorDadosPessoais = new Injetor();
		injetorDadosPessoais.carregarDadosPessoais();

		for (DadosPessoais item : injetorDadosPessoais.getDadosPessoaisList()) 
		{
			System.out.println(item.getMatriculaSiape() + " - "
					+ item.getNomeServidor());
		}
		
		
		Injetor injetorDadosFuncionais = new Injetor();
		injetorDadosFuncionais.carregarDadosFuncionais();
		
		for (DadosFuncionais item : injetorDadosFuncionais.getDadosFuncionaisList()) 
		{
			System.out.println(item.getMatriculaSiape()+ " - " + item.getDataCadastramentoServidor());
		}
	}
}
