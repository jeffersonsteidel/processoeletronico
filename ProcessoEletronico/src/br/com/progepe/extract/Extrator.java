package br.com.progepe.extract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Extrator {

	private List<DadosFitaEspelho> dadosFitaEspelhoList = new ArrayList<DadosFitaEspelho>(); //cria lista de DaDosFitaEspelho


	public List<DadosFitaEspelho> getDadosFitaEspelhoList() {
		return dadosFitaEspelhoList;
	}

	public void setDadosFitaEspelhoList(
			List<DadosFitaEspelho> dadosFitaEspelhoList) {
		this.dadosFitaEspelhoList = dadosFitaEspelhoList;
	}

	public void carregarDados() throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITAS_ESPELHO_2011/FITA_JUL.txt"));
			DadosFitaEspelho dadosFitaEspelho = null;
			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				
				if (tipoRegistro.equals(1)) {
					   dadosFitaEspelho= new DadosFitaEspelho();
						
						
						dadosFitaEspelho.setMatriculaSiape(Integer.parseInt(linha.substring(9, 16).trim()));
						dadosFitaEspelho.setDvMatricula(Integer.parseInt(linha.substring(16, 17)));
						dadosFitaEspelho.setTipoRegistro(linha.substring(17, 18).trim());
						dadosFitaEspelho.setNomeServidor(linha.substring(20, 80).trim());
						dadosFitaEspelho.setCpf(linha.substring(80, 91).trim());
						dadosFitaEspelho.setPisPasef(linha.substring(91,102).trim());
						dadosFitaEspelho.setNomeMae(linha.substring(102, 152).trim());
						dadosFitaEspelho.setSexo(linha.substring(152, 153).trim());
						dadosFitaEspelho.setDataNascimento(linha.substring(153, 161).trim());
						dadosFitaEspelho.setEstadoCivil(Integer.parseInt(linha.substring(161, 162)));
						dadosFitaEspelho.setNivelEscolaridade(linha.substring(162, 164).trim());
						dadosFitaEspelho.setCodigoTitulacaoFormacao(Integer.parseInt(linha.substring(164, 166)));
						dadosFitaEspelho.setNacionalidade(linha.substring(171, 172).trim());
						dadosFitaEspelho.setNaturalidade(linha.substring(172, 174).trim());
						dadosFitaEspelho.setPais(linha.substring(174, 177).trim());
						dadosFitaEspelho.setAnoChegada(Integer.parseInt(linha.substring(177, 181)));
						dadosFitaEspelho.setDataPrimeiroEmprego(linha.substring(185, 193));
						dadosFitaEspelho.setIdentificacaoOrigem(linha.substring(193, 201).trim());
						dadosFitaEspelho.setLogradouro(linha.substring(201, 241).trim());
						dadosFitaEspelho.setNumeroEndereco(linha.substring(241, 247).trim());
						dadosFitaEspelho.setComplementoEndereco(linha.substring(247, 268).trim());
						dadosFitaEspelho.setBairro(linha.substring(268, 293).trim());
						dadosFitaEspelho.setMunicipio(linha.substring(293, 323).trim());
						dadosFitaEspelho.setCep(linha.substring(323, 331).trim());
						dadosFitaEspelho.setUf(linha.substring(331, 333).trim());
						dadosFitaEspelho.setSiglaOrgaoExpedidor(linha.substring(347, 352).trim());
						dadosFitaEspelho.setDataExpedicaoIdentidade(linha.substring(352, 360));
						dadosFitaEspelho.setSiglaUfIdentidade(linha.substring(360, 362).trim());
						dadosFitaEspelho.setNumeroTituloEleitor(linha.substring(362, 375).trim());	

						
				}

				if (tipoRegistro.equals(2)) {

					
					    DadosFitaEspelho dadosFitaEspelho2 = dadosFitaEspelho;
						dadosFitaEspelho2.setMatriculaSiape(Integer.parseInt(linha.substring(9, 16)));
						dadosFitaEspelho2.setTipoRegistro(linha.substring(17,18));
						dadosFitaEspelho2.setCodigoSituacaoServidor(Integer.parseInt(linha.substring(23, 25)));
						dadosFitaEspelho2.setNumeroCarteiraDeTrabalho(Integer.parseInt(linha.substring(25, 31)));
						dadosFitaEspelho2.setSerieCarteiraDeTrabalho(linha.substring(31, 36));
						dadosFitaEspelho2.setUfCarteiraDeTrabalho(linha.substring(36, 38));
						dadosFitaEspelho2.setCodigoBanco(Integer.parseInt(linha.substring(38, 41)));
						dadosFitaEspelho2.setAgenciaBanco(linha.substring(41, 47));
						dadosFitaEspelho2.setContaCorrenteBanco(linha.substring(47, 60));
						dadosFitaEspelho2.setJornadaDeTrabalho(Integer.parseInt(linha.substring(90, 92)));
						dadosFitaEspelho2.setDataCadastramentoServidor(linha.substring(94, 102));
						dadosFitaEspelho2.setCodigoGrupoCargo(Integer.parseInt(linha.substring(113, 116)));
						dadosFitaEspelho2.setCodigoCargo(Integer.parseInt(linha.substring(116, 119)));
						dadosFitaEspelho2.setClasseCargo(linha.substring(119, 120));
						dadosFitaEspelho2.setCodigoReferenciaNivelPadraoCargo(linha.substring(120, 123));
						dadosFitaEspelho2.setDataEntradaOcupacaoCargo(linha.substring(123, 131));
						dadosFitaEspelho2.setDataSaidaCargo(linha.substring(131, 139));
						dadosFitaEspelho2.setSiglaFuncao(linha.substring(139, 142));
						dadosFitaEspelho2.setCodigoNivelFuncao(Integer.parseInt(linha.substring(142, 147)));
						dadosFitaEspelho2.setCodigoEscolaridadeFuncao(linha.substring(147, 149));
						//pagina 6:
						dadosFitaEspelho2.setCodigoOpcaoFuncao(linha.substring(149, 150));
						dadosFitaEspelho2.setDataIngressoFuncao(linha.substring(150, 158));
						dadosFitaEspelho2.setDataSaidaFuncao(linha.substring(158, 166));
						dadosFitaEspelho2.setCodigoUnidadeOrganizacionalFuncao(Integer.parseInt(linha.substring(166, 175)));
						dadosFitaEspelho2.setSiglaNovaFuncao(linha.substring(175, 178));
						dadosFitaEspelho2.setCodigoNivelNovaFuncao(Integer.parseInt(linha.substring(178, 183)));
						dadosFitaEspelho2.setCodigoEscolaridadeNovaFuncao(linha.substring(183, 185));
						dadosFitaEspelho2.setCodigoOpcaoNovaFuncao(linha.substring(185, 186));
						dadosFitaEspelho2.setDataIngressoNovaFuncao(linha.substring(186, 194));
						dadosFitaEspelho2.setDataSaidaNovaFuncao(linha.substring(194, 202));
						dadosFitaEspelho2.setCodigoUnidadeOrganizacionalNovaFuncao(Integer.parseInt(linha.substring(202, 211)));
						dadosFitaEspelho2.setCodigoUnidadeOrganizacionalLotacao(Integer.parseInt(linha.substring(215, 224)));
						dadosFitaEspelho2.setDataLotacao(linha.substring(224, 232));
						dadosFitaEspelho2.setCodigoOrgaoLocalizacao(Integer.parseInt(linha.substring(232, 237)));
						dadosFitaEspelho2.setCodigoUnidadeOrganizacionalLocalizacao(Integer.parseInt(linha.substring(237, 246)));
						dadosFitaEspelho2.setCodigoGrupoIngressoOrgao(Integer.parseInt(linha.substring(246, 248)));
						dadosFitaEspelho2.setCodigoOcorrenciaIngressoOrgao(Integer.parseInt(linha.substring(248, 251)));
						dadosFitaEspelho2.setDataIngressoOrgao(linha.substring(251, 259));
						dadosFitaEspelho2.setCodigoDiplomaLegalIngressoOrgao(Integer.parseInt(linha.substring(259, 261)));
						dadosFitaEspelho2.setNumeroDiplomaLegalIngressoOrgao(linha.substring(261, 270));
						dadosFitaEspelho2.setDataPublicacaoDiplomaLegalIngressoOrgao(linha.substring(270, 278));
						dadosFitaEspelho2.setCodigoGrupoIngressoServPublico(Integer.parseInt(linha.substring(278, 280)));
						dadosFitaEspelho2.setCodigoOcorrenciaIngressoServPublico(Integer.parseInt(linha.substring(280, 283)));
						dadosFitaEspelho2.setDataIngressoServPublico(linha.substring(283, 291));
						dadosFitaEspelho2.setCodigoDiplomaLegalIngressoServPublico(Integer.parseInt(linha.substring(291, 293)));
						dadosFitaEspelho2.setNumeroDiplomaLegalIngressoServPublico(linha.substring(293, 302));
						dadosFitaEspelho2.setDataPublicacaoDiplomaLegalIngressoServPublico(linha.substring(302, 310));
						dadosFitaEspelho2.setCodigoGrupoExclusao(Integer.parseInt(linha.substring(310, 312)));
						dadosFitaEspelho2.setCodigoOcorrenciaExclusao(Integer.parseInt(linha.substring(312, 315)));
						dadosFitaEspelho2.setDataExclusao(linha.substring(315, 323));
						dadosFitaEspelho2.setCodigoDiplomaLegalExclusao(Integer.parseInt(linha.substring(323, 325)));
						dadosFitaEspelho2.setNumeroDiplomaLegalExclusao(linha.substring(325, 334));
						dadosFitaEspelho2.setDataPublicacaoDiplomaLegalExclusao(linha.substring(334, 342));
						//página 7
						dadosFitaEspelho2.setCodigoGrupoAfastamento(Integer.parseInt(linha.substring(342, 344)));
						dadosFitaEspelho2.setCodigoOcerrenciaAfastamento(Integer.parseInt(linha.substring(344, 347)));
						dadosFitaEspelho2.setDataInicioAfastamento(linha.substring(347, 355));
						dadosFitaEspelho2.setDataTerminoAfastamento(linha.substring(355, 363));
						dadosFitaEspelho2.setCodigoDiplomaLegalAfastamento(Integer.parseInt(linha.substring(363, 365)));
						dadosFitaEspelho2.setNumeroDiplomaLegalAfastamento(linha.substring(365, 374));
						dadosFitaEspelho2.setDataPublicacaoDiplomaLegalAfastamento(linha.substring(374, 382));
						dadosFitaEspelho2.setCodigoGrupoInatividade(Integer.parseInt(linha.substring(382, 384)));
						dadosFitaEspelho2.setCodigoOcorrenciaInatividade(Integer.parseInt(linha.substring(384, 387)));
						dadosFitaEspelho2.setDataInatividade(linha.substring(388, 395));
						dadosFitaEspelho2.setCodigoDiplomaLegalInatividade(Integer.parseInt(linha.substring(395, 397)));
						dadosFitaEspelho2.setNumeroDiplomaLegalInatividade(linha.substring(397, 406));
						dadosFitaEspelho2.setDataPublicacaoDiplomaLegalInatividade(linha.substring(406, 414));
						dadosFitaEspelho2.setNumeroProcessoAposentadoria(linha.substring(414, 429));
						dadosFitaEspelho2.setAnoPrevistoAposentadoria(Integer.parseInt(linha.substring(429, 433)));
						dadosFitaEspelho2.setOpcaoAposentadoriaIntegral(linha.substring(433, 434));
						dadosFitaEspelho2.setCodigoGrupoModifFuncional(Integer.parseInt(linha.substring(443, 445)));
						dadosFitaEspelho2.setCodigoOcorrenciaModifFuncional(Integer.parseInt(linha.substring(445, 448)));
						dadosFitaEspelho2.setDataModifFuncional(linha.substring(448, 456));
						dadosFitaEspelho2.setCodigoDiplomaLegalModifFuncional(Integer.parseInt(linha.substring(456, 458)));
						dadosFitaEspelho2.setNumeroDiplomaLegalModifFuncional(linha.substring(458, 467));
						dadosFitaEspelho2.setDataPublicacaoDiplomaLegalModifFuncional(linha.substring(467, 475));
						dadosFitaEspelho2.setCodigoRegimeJuridicoAnterior(linha.substring(475, 478));
						dadosFitaEspelho2.setCodigoSituaçãoServidorAnterior(Integer.parseInt(linha.substring(478, 480)));
						dadosFitaEspelho2.setCodigoOrgaoDestinoMudancaOrgao(Integer.parseInt(linha.substring(480, 485)));
						dadosFitaEspelho2.setDataLiberacaoMudancaOrgao(linha.substring(485, 493));
						dadosFitaEspelho2.setCodigoOrgaoOrigemMudancaOrgao(Integer.parseInt(linha.substring(493, 498)));
						dadosFitaEspelho2.setCodigoOrgaoAnterior(Integer.parseInt(linha.substring(498, 503)));
						dadosFitaEspelho2.setMatriculaAnterior(linha.substring(503, 510));
						dadosFitaEspelho2.setCodigoOrgaoExtintoModificado(Integer.parseInt(linha.substring(510, 515)));
						dadosFitaEspelho2.setMatriculaServidorExtintaModificada(linha.substring(515, 522));
						dadosFitaEspelho2.setCodigoOrgaoAtual(Integer.parseInt(linha.substring(522, 527)));
				    	dadosFitaEspelho2.setMatriculaAtual(linha.substring(527, 534));
				    	//página 8
						dadosFitaEspelho2.setCodigoUpagMudancaUnidadePagadora(Integer.parseInt(linha.substring(534, 543)));
						dadosFitaEspelho2.setDataLiberacaoMudancaUnidadePagadora(linha.substring(543, 551));
						dadosFitaEspelho2.setMotivoMudancaUnidadePagadora(linha.substring(551, 552));
						dadosFitaEspelho2.setCodigoIndicadorDePagamentoServidor(Integer.parseInt(linha.substring(552, 553)));
						dadosFitaEspelho2.setCodigoTipoValeAlimentacao(linha.substring(642, 643));
						dadosFitaEspelho2.setDataInicioValeAlimentacao(linha.substring(643, 651));
						dadosFitaEspelho2.setDataFimValeAlimentacao(linha.substring(651, 659));
						dadosFitaEspelho2.setCodigoIndicadorDeOperadorDeRaioX(Integer.parseInt(linha.substring(659, 660)));
						dadosFitaEspelho2.setCodigoOrgaoRequisitante(Integer.parseInt(linha.substring(660, 665)));
						dadosFitaEspelho2.setCodigoDavaga(Integer.parseInt(linha.substring(665, 672)));
						dadosFitaEspelho2.setCodigoDoGrupoPosse(Integer.parseInt(linha.substring(679, 681)));
						dadosFitaEspelho2.setCodigoOcorrenciaPosse(Integer.parseInt(linha.substring(681, 684)));
						dadosFitaEspelho2.setDataPosse(linha.substring(684, 692));
						dadosFitaEspelho2.setCodigoDiplomaPosse(Integer.parseInt(linha.substring(692, 694)));
						dadosFitaEspelho2.setDataDiplomaPosse(linha.substring(694, 702));
						dadosFitaEspelho2.setNumeroDiplomaPosse(linha.substring(702, 711));
						dadosFitaEspelho2.setCodigoGrupoOcorrenciaGrupoReversaoAtividade(Integer.parseInt(linha.substring(711, 713)));
						dadosFitaEspelho2.setDataOcorrenciaGrupoReversaoAtividade(linha.substring(716, 724));
						dadosFitaEspelho2.setCodigoDiplomaGrupoReversaoAtividade(Integer.parseInt(linha.substring(724, 726)));
						dadosFitaEspelho2.setDataPublicacaoDiplomaGrupoReversaoAtividade(linha.substring(726, 734));
						dadosFitaEspelho2.setNumeroDiplomaGrupoReversaoAtividade(linha.substring(734, 743));

						dadosFitaEspelhoList.add(dadosFitaEspelho2);
						
				}
				
				
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	
}
