
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InjetorTeste {

	private List<DadosPessoaisTeste> dadosPessoaisList = new ArrayList<DadosPessoaisTeste>();// cria
																								// lista
																								// de
																								// Dados
																								// Pessoais
	private List<DadosFuncionaisTeste> dadosFuncionaisList = new ArrayList<DadosFuncionaisTeste>();// cria
																									// lista
																									// de
																									// Dados
																									// Funcionais

	public List<DadosPessoaisTeste> getDadosPessoaisList() {
		return dadosPessoaisList;
	}

	public List<DadosFuncionaisTeste> getDadosFuncionaisList() {
		return dadosFuncionaisList;
	}

	public void setDadosPessoaisList(List<DadosPessoaisTeste> dadosPessoaisList) {
		this.dadosPessoaisList = dadosPessoaisList;
	}

	public void setDadosFuncionaisList(
			List<DadosFuncionaisTeste> dadosFuncionaisList) {
		this.dadosFuncionaisList = dadosFuncionaisList;
	}

	public void carregarDados() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));
			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {

						DadosPessoaisTeste dadosPessoaisTeste = new DadosPessoaisTeste();
						dadosPessoaisTeste.setMatriculaSiape(Integer.parseInt(linha.substring(9, 16)));
						dadosPessoaisTeste.setDvMatricula(Integer.parseInt(linha.substring(16, 17)));
						dadosPessoaisTeste.setTipoRegistro(linha.substring(17, 18));
						dadosPessoaisTeste.setNomeServidor(linha.substring(20, 80));
						dadosPessoaisTeste.setCpf(linha.substring(80, 91));
						dadosPessoaisTeste.setPisPasef(Long.parseLong(linha.substring(91,102)));
						dadosPessoaisTeste.setNomeMae(linha.substring(102, 152));
						dadosPessoaisTeste.setSexo(linha.substring(152, 153));
						dadosPessoaisTeste.setDataNascimento(linha.substring(153, 161));
						dadosPessoaisTeste.setEstadoCivil(linha.substring(161, 162));
						dadosPessoaisTeste.setNivelEscolaridade(linha.substring(162, 164));
						dadosPessoaisTeste.setCodigoTitulacaoFormacao(Integer.parseInt(linha.substring(164, 166)));
						dadosPessoaisTeste.setNacionalidade(linha.substring(171, 172));
						dadosPessoaisTeste.setNaturalidade(linha.substring(172, 174));
						dadosPessoaisTeste.setPais(linha.substring(174, 177));
						dadosPessoaisTeste.setAnoChegada(Integer.parseInt(linha.substring(177, 181)));
						dadosPessoaisTeste.setDataPrimeiroEmprego(linha.substring(185, 193));
						dadosPessoaisTeste.setIdentificacaoOrigem(linha.substring(193, 201));
						dadosPessoaisTeste.setLogradouro(linha.substring(201, 241));
						dadosPessoaisTeste.setNumeroEndereco(linha.substring(241, 247));
						dadosPessoaisTeste.setComplementoEndereco(linha.substring(247, 268));
						dadosPessoaisTeste.setBairro(linha.substring(268, 293));
						dadosPessoaisTeste.setMunicipio(linha.substring(293, 323));
						dadosPessoaisTeste.setCep(linha.substring(323, 331));
						dadosPessoaisTeste.setUf(linha.substring(331, 333));
						dadosPessoaisTeste.setSiglaOrgaoExpedidor(linha.substring(347, 352));
						dadosPessoaisTeste.setDataExpedicaoIdentidade(linha.substring(352, 360));
						dadosPessoaisTeste.setSiglaUfIdentidade(linha.substring(360, 362));
						dadosPessoaisTeste.setNumeroTituloEleitor(linha.substring(362, 375));	

					dadosPessoaisList.add(dadosPessoaisTeste);
				}

				else if (tipoRegistro.equals(2)) {

					DadosFuncionaisTeste dadosFuncionaisTeste = new DadosFuncionaisTeste();

					// pagina 5:
						dadosFuncionaisTeste.setMatriculaSiape(Integer.parseInt(linha.substring(9, 16)));
						dadosFuncionaisTeste.setTipoRegistro(linha.substring(17,18));
						dadosFuncionaisTeste.setCodigoSituacaoServidor(Integer.parseInt(linha.substring(23, 25)));
						dadosFuncionaisTeste.setNumeroCarteiraDeTrabalho(Integer.parseInt(linha.substring(25, 31)));
						dadosFuncionaisTeste.setSerieCarteiraDeTrabalho(linha.substring(31, 36));
						dadosFuncionaisTeste.setUfCarteiraDeTrabalho(linha.substring(36, 38));
						dadosFuncionaisTeste.setCodigoBanco(Integer.parseInt(linha.substring(38, 41)));
						dadosFuncionaisTeste.setAgenciaBanco(linha.substring(41, 47));
						dadosFuncionaisTeste.setContaCorrenteBanco(linha.substring(47, 60));
						dadosFuncionaisTeste.setJornadaDeTrabalho(Integer.parseInt(linha.substring(90, 92)));
						dadosFuncionaisTeste.setDataCadastramentoServidor(linha.substring(94, 102));
						dadosFuncionaisTeste.setCodigoGrupoCargo(Integer.parseInt(linha.substring(113, 116)));
						dadosFuncionaisTeste.setCodigoCargo(Integer.parseInt(linha.substring(116, 119)));
						dadosFuncionaisTeste.setClasseCargo(linha.substring(119, 120));
						dadosFuncionaisTeste.setCodigoReferenciaNivelPadraoCargo(linha.substring(120, 123));
						dadosFuncionaisTeste.setDataEntradaOcupacaoCargo(linha.substring(123, 131));
						dadosFuncionaisTeste.setDataSaidaCargo(linha.substring(131, 139));
						dadosFuncionaisTeste.setSiglaFuncao(linha.substring(139, 142));
						dadosFuncionaisTeste.setCodigoNivelFuncao(Integer.parseInt(linha.substring(142, 147)));
						dadosFuncionaisTeste.setCodigoEscolaridadeFuncao(linha.substring(147, 149));
						//pagina 6:
						dadosFuncionaisTeste.setCodigoOpcaoFuncao(linha.substring(149, 150));
						dadosFuncionaisTeste.setDataIngressoFuncao(linha.substring(150, 158));
						dadosFuncionaisTeste.setDataSaidaFuncao(linha.substring(158, 166));
						dadosFuncionaisTeste.setCodigoUnidadeOrganizacionalFuncao(Integer.parseInt(linha.substring(166, 175)));
						dadosFuncionaisTeste.setSiglaNovaFuncao(linha.substring(175, 178));
						dadosFuncionaisTeste.setCodigoNivelNovaFuncao(Integer.parseInt(linha.substring(178, 183)));
						dadosFuncionaisTeste.setCodigoEscolaridadeNovaFuncao(linha.substring(183, 185));
						dadosFuncionaisTeste.setCodigoOpcaoNovaFuncao(linha.substring(185, 186));
						dadosFuncionaisTeste.setDataIngressoNovaFuncao(linha.substring(186, 194));
						dadosFuncionaisTeste.setDataSaidaNovaFuncao(linha.substring(194, 202));
						dadosFuncionaisTeste.setCodigoUnidadeOrganizacionalNovaFuncao(Integer.parseInt(linha.substring(202, 211)));
						dadosFuncionaisTeste.setCodigoUnidadeOrganizacionalLotacao(Integer.parseInt(linha.substring(215, 224)));
						dadosFuncionaisTeste.setDataLotacao(linha.substring(224, 232));
						dadosFuncionaisTeste.setCodigoOrgaoLocalizacao(Integer.parseInt(linha.substring(232, 237)));
						dadosFuncionaisTeste.setCodigoUnidadeOrganizacionalLocalizacao(Integer.parseInt(linha.substring(237, 246)));
						dadosFuncionaisTeste.setCodigoGrupoIngressoOrgao(Integer.parseInt(linha.substring(246, 248)));
						dadosFuncionaisTeste.setCodigoOcorrenciaIngressoOrgao(Integer.parseInt(linha.substring(248, 251)));
						dadosFuncionaisTeste.setDataIngressoOrgao(linha.substring(251, 259));
						dadosFuncionaisTeste.setCodigoDiplomaLegalIngressoOrgao(Integer.parseInt(linha.substring(259, 261)));
						dadosFuncionaisTeste.setNumeroDiplomaLegalIngressoOrgao(linha.substring(261, 270));
						dadosFuncionaisTeste.setDataPublicacaoDiplomaLegalIngressoOrgao(linha.substring(270, 278));
						dadosFuncionaisTeste.setCodigoGrupoIngressoServPublico(Integer.parseInt(linha.substring(278, 280)));
						dadosFuncionaisTeste.setCodigoOcorrenciaIngressoServPublico(Integer.parseInt(linha.substring(280, 283)));
						dadosFuncionaisTeste.setDataIngressoServPublico(linha.substring(283, 291));
						dadosFuncionaisTeste.setCodigoDiplomaLegalIngressoServPublico(Integer.parseInt(linha.substring(291, 293)));
						dadosFuncionaisTeste.setNumeroDiplomaLegalIngressoServPublico(linha.substring(293, 302));
						dadosFuncionaisTeste.setDataPublicacaoDiplomaLegalIngressoServPublico(linha.substring(302, 310));
						dadosFuncionaisTeste.setCodigoGrupoExclusao(Integer.parseInt(linha.substring(310, 312)));
						dadosFuncionaisTeste.setCodigoOcorrenciaExclusao(Integer.parseInt(linha.substring(312, 315)));
						dadosFuncionaisTeste.setDataExclusao(linha.substring(315, 323));
						dadosFuncionaisTeste.setCodigoDiplomaLegalExclusao(Integer.parseInt(linha.substring(323, 325)));
						dadosFuncionaisTeste.setNumeroDiplomaLegalExclusao(linha.substring(325, 334));
						dadosFuncionaisTeste.setDataPublicacaoDiplomaLegalExclusao(linha.substring(334, 342));
						//página 7
						dadosFuncionaisTeste.setCodigoGrupoAfastamento(Integer.parseInt(linha.substring(342, 344)));
						dadosFuncionaisTeste.setCodigoOcerrenciaAfastamento(Integer.parseInt(linha.substring(344, 347)));
						dadosFuncionaisTeste.setDataInicioAfastamento(linha.substring(347, 355));
						dadosFuncionaisTeste.setDataTerminoAfastamento(linha.substring(355, 363));
						dadosFuncionaisTeste.setCodigoDiplomaLegalAfastamento(Integer.parseInt(linha.substring(363, 365)));
						dadosFuncionaisTeste.setNumeroDiplomaLegalAfastamento(linha.substring(365, 374));
						dadosFuncionaisTeste.setDataPublicacaoDiplomaLegalAfastamento(linha.substring(374, 382));
						dadosFuncionaisTeste.setCodigoGrupoInatividade(Integer.parseInt(linha.substring(382, 384)));
						dadosFuncionaisTeste.setCodigoOcorrenciaInatividade(Integer.parseInt(linha.substring(384, 387)));
						dadosFuncionaisTeste.setDataInatividade(linha.substring(388, 395));
						dadosFuncionaisTeste.setCodigoDiplomaLegalInatividade(Integer.parseInt(linha.substring(395, 397)));
						dadosFuncionaisTeste.setNumeroDiplomaLegalInatividade(linha.substring(397, 406));
						dadosFuncionaisTeste.setDataPublicacaoDiplomaLegalInatividade(linha.substring(406, 414));
						dadosFuncionaisTeste.setNumeroProcessoAposentadoria(linha.substring(414, 429));
						dadosFuncionaisTeste.setAnoPrevistoAposentadoria(Integer.parseInt(linha.substring(429, 433)));
						dadosFuncionaisTeste.setOpcaoAposentadoriaIntegral(linha.substring(433, 434));
						dadosFuncionaisTeste.setCodigoGrupoModifFuncional(Integer.parseInt(linha.substring(443, 445)));
						dadosFuncionaisTeste.setCodigoOcorrenciaModifFuncional(Integer.parseInt(linha.substring(445, 448)));
						dadosFuncionaisTeste.setDataModifFuncional(linha.substring(448, 456));
						dadosFuncionaisTeste.setCodigoDiplomaLegalModifFuncional(Integer.parseInt(linha.substring(456, 458)));
						dadosFuncionaisTeste.setNumeroDiplomaLegalModifFuncional(linha.substring(458, 467));
						dadosFuncionaisTeste.setDataPublicacaoDiplomaLegalModifFuncional(linha.substring(467, 475));
						dadosFuncionaisTeste.setCodigoRegimeJuridicoAnterior(linha.substring(475, 478));
						dadosFuncionaisTeste.setCodigoSituaçãoServidorAnterior(Integer.parseInt(linha.substring(478, 480)));
						dadosFuncionaisTeste.setCodigoOrgaoDestinoMudancaOrgao(Integer.parseInt(linha.substring(480, 485)));
						dadosFuncionaisTeste.setDataLiberacaoMudancaOrgao(linha.substring(485, 493));
						dadosFuncionaisTeste.setCodigoOrgaoOrigemMudancaOrgao(Integer.parseInt(linha.substring(493, 498)));
						dadosFuncionaisTeste.setCodigoOrgaoAnterior(Integer.parseInt(linha.substring(498, 503)));
						dadosFuncionaisTeste.setMatriculaAnterior(linha.substring(503, 510));
						dadosFuncionaisTeste.setCodigoOrgaoExtintoModificado(Integer.parseInt(linha.substring(510, 515)));
						dadosFuncionaisTeste.setMatriculaServidorExtintaModificada(linha.substring(515, 522));
						dadosFuncionaisTeste.setCodigoOrgaoAtual(Integer.parseInt(linha.substring(522, 527)));
				    	dadosFuncionaisTeste.setMatriculaAtual(linha.substring(527, 534));
				    	//página 8
						dadosFuncionaisTeste.setCodigoUpagMudancaUnidadePagadora(Integer.parseInt(linha.substring(534, 543)));
						dadosFuncionaisTeste.setDataLiberacaoMudancaUnidadePagadora(linha.substring(543, 551));
						dadosFuncionaisTeste.setMotivoMudancaUnidadePagadora(linha.substring(551, 552));
						dadosFuncionaisTeste.setCodigoIndicadorDePagamentoServidor(Integer.parseInt(linha.substring(552, 553)));
						dadosFuncionaisTeste.setCodigoTipoValeAlimentacao(linha.substring(642, 643));
						dadosFuncionaisTeste.setDataInicioValeAlimentacao(linha.substring(643, 651));
						dadosFuncionaisTeste.setDataFimValeAlimentacao(linha.substring(651, 659));
						dadosFuncionaisTeste.setCodigoIndicadorDeOperadorDeRaioX(Integer.parseInt(linha.substring(659, 660)));
						dadosFuncionaisTeste.setCodigoOrgaoRequisitante(Integer.parseInt(linha.substring(660, 665)));
						dadosFuncionaisTeste.setCodigoDavaga(Integer.parseInt(linha.substring(665, 672)));
						dadosFuncionaisTeste.setCodigoDoGrupoPosse(Integer.parseInt(linha.substring(679, 681)));
						dadosFuncionaisTeste.setCodigoOcorrenciaPosse(Integer.parseInt(linha.substring(681, 684)));
						dadosFuncionaisTeste.setDataPosse(linha.substring(684, 692));
						dadosFuncionaisTeste.setCodigoDiplomaPosse(Integer.parseInt(linha.substring(692, 694)));
						dadosFuncionaisTeste.setDataDiplomaPosse(linha.substring(694, 702));
						dadosFuncionaisTeste.setNumeroDiplomaPosse(linha.substring(702, 711));
						dadosFuncionaisTeste.setCodigoGrupoOcorrenciaGrupoReversaoAtividade(Integer.parseInt(linha.substring(711, 713)));
						dadosFuncionaisTeste.setDataOcorrenciaGrupoReversaoAtividade(linha.substring(716, 724));
						dadosFuncionaisTeste.setCodigoDiplomaGrupoReversaoAtividade(Integer.parseInt(linha.substring(724, 726)));
						dadosFuncionaisTeste.setDataPublicacaoDiplomaGrupoReversaoAtividade(linha.substring(726, 734));
						dadosFuncionaisTeste.setNumeroDiplomaGrupoReversaoAtividade(linha.substring(734, 743));

					dadosFuncionaisList.add(dadosFuncionaisTeste);
				}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public static void main(String[] args) {
		InjetorTeste injetorDados = new InjetorTeste();
		injetorDados.carregarDados();

		for (DadosPessoaisTeste item : injetorDados.getDadosPessoaisList()) {
			System.out.println(item.getMatriculaSiape() + " - "
					+ item.getNomeServidor());
		}
		for (DadosFuncionaisTeste item : injetorDados.getDadosFuncionaisList()) {
			System.out.println(item.getMatriculaSiape() + " - "
					+ item.getDataCadastramentoServidor());
		}
	}
}
