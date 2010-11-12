import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

import br.com.progepe.validator.Validator;

public class FitaEspelho {

	public static void main(String[] args) throws ParseException {
		// try {
		// BufferedReader br = new BufferedReader(new FileReader(
		// "C://FITA.txt"));
		// while (br.ready()) {
		// String linha = br.readLine().substring(0, 764);
		// Integer teste = Integer.parseInt(linha.substring(17, 18));
		// if (teste.equals(1)) {
		// System.out.println("**********DADOS PESSOAIS**********");
		// System.out.println("Unidade Pagadora:" + linha.substring(0, 9));
		// System.out.println("Siape:" + linha.substring(9, 16));
		// System.out.println("DV Matricula:" +linha.substring(16, 17));
		// System.out.println("Tipo de Registro:" + linha.substring(17, 18));
		// System.out.println("Sigla UF UPAG:" + linha.substring(18, 20));
		// System.out.println("Nome:" + linha.substring(20, 80));
		// System.out.println("CPF:" + linha.substring(80, 91));
		// System.out.println("PIS/PASEP:" + linha.substring(91,102));
		// System.out.println("Nome da M�e:" + linha.substring(102, 152));
		// System.out.println("Sexo:" + linha.substring(152, 153));
		// System.out.println("Data de Nascimento:" + linha.substring(153,
		// 161));
		// System.out.println("Estado Civil:" + linha.substring(161, 162));
		// System.out.println("Nivel de Escolaridade:" +
		// linha.substring(162,164));
		// System.out.println("C�digo da Titula��o/Forma��o:" +
		// linha.substring(164, 166));
		// System.out.println("Filler:" + linha.substring(166, 171));
		// System.out.println("Nacionalidade:" + linha.substring(171, 172));
		// System.out.println("Naturalidade:" + linha.substring(172, 174));
		// System.out.println("Pais:" + linha.substring(174, 177));
		// System.out.println("Ano de Chegada:" + linha.substring(177, 181));
		// System.out.println("Quantidade de Dependentes IR:" +
		// linha.substring(181, 183));
		// System.out.println("Quantidade de Dependentes SF:" +
		// linha.substring(183, 185));
		// System.out.println("Data do Primeiro Emprego:" + linha.substring(185,
		// 193));
		// System.out.println("Identifica��o Origem:" + linha.substring(193,
		// 201));
		// System.out.println("Endere�o -- Logradouro:" + linha.substring(201,
		// 241));
		// System.out.println("         -- Numero:" + linha.substring(241,
		// 247));
		// System.out.println("         -- Complemento:" + linha.substring(247,
		// 268));
		// System.out.println("Bairro:" + linha.substring(268, 293));
		// System.out.println("Cidade:" + linha.substring(293, 323));
		// System.out.println("CEP:" + linha.substring(323, 331));
		// System.out.println("UF:" + linha.substring(331, 333));
		// System.out.println("RG:" + linha.substring(333,347));
		// System.out.println("Sigla do Org�o Expedidor do RG:" +
		// linha.substring(347, 352));
		// System.out.println("Data de Expedi��o:" + linha.substring(352, 360));
		// System.out.println("UF do RG:" + linha.substring(360, 362));
		// System.out.println("Titulo de Eleitor:" + linha.substring(362, 375));
		// System.out.println("Filler:" + linha.substring(375, 764));
		// break;
		// }

		// linha = br.readLine().substring(0, 764);
		// teste = Integer.parseInt(linha.substring(17, 18));
		// if (teste.equals(2)) {
		// System.out.println("-------------DADOS FUNCIONAIS-------------------");
		// System.out.println("Unidade Pagadora:" + linha.substring(0, 9));
		// System.out.println("Siape:" + linha.substring(9, 16));
		// System.out.println("DV Matricula:" +linha.substring(16, 17));
		// System.out.println("Tipo de Registro:" + linha.substring(17, 18));
		// System.out.println("Sigla UF UPAG:" + linha.substring(18, 20));
		// System.out.println("Sigla do Regime Juridico �nico:" +
		// linha.substring(20,23));
		// System.out.println("C�digo da Situa��o do Servidor:" +
		// linha.substring(23,25));
		// System.out.println("Carteira de Trabalho -- N�mero:" +
		// linha.substring(25,31));
		// System.out.println("                     -- S�rie:" +
		// linha.substring(31,36));
		// System.out.println("                     -- UF:" +
		// linha.substring(36,38));
		// System.out.println("Banco:" + linha.substring(38,41));
		// System.out.println("Ag�ncia:" + linha.substring(41,47));
		// System.out.println("Conta Corrente:" + linha.substring(47,60));
		// System.out.println("FGTS -- Data de Op��o:" +
		// linha.substring(60,68));
		// System.out.println("     -- Banco:" + linha.substring(68,71));
		// System.out.println("     -- Ag�ncia:" + linha.substring(71,77));
		// System.out.println("     -- Conta Corrente:" +
		// linha.substring(77,90));
		// System.out.println("Jornada de Trabalho:" + linha.substring(90,92));
		// System.out.println("Percentual de Tempo de Servi�o:" +
		// linha.substring(92,94));
		// System.out.println("Data de Cadastramento do Servidor:" +
		// linha.substring(94,102));
		// System.out.println("Indica��o de Suspenss�o:" +
		// linha.substring(102,103));
		// System.out.println("Pagamento Data Supress�o de Pagamento:" +
		// linha.substring(103,109));
		// System.out.println("Proporcionalidade -- Numerador:" +
		// linha.substring(109,111));
		// System.out.println("                  -- Denominador:" +
		// linha.substring(111,113));
		// System.out.println("Cargo/Emprego -- Grupo:" +
		// linha.substring(113,116));
		// System.out.println("              -- Cargo:" +
		// linha.substring(116,119));
		// System.out.println("              -- Classe:" +
		// linha.substring(119,120));
		// System.out.println("              -- Refer�ncia/N�vel/Padr�o:" +
		// linha.substring(120,123));
		// System.out.println("              -- Data Entrada Ocupa��o:" +
		// linha.substring(123,131));
		// System.out.println("              -- Data Entrada Sa�da:" +
		// linha.substring(131,139));
		// System.out.println("Fun��o -- Sigla:" + linha.substring(139,142));
		// System.out.println("       -- C�digo de N�vel:" +
		// linha.substring(142,147));
		// System.out.println("       -- Escolaridade:" +
		// linha.substring(147,149));
		// System.out.println("       -- Op��o:" + linha.substring(149,150));
		// System.out.println("       -- Data Ingresso:" +
		// linha.substring(150,158));
		// System.out.println("       -- Data Sa�da:" +
		// linha.substring(158,166));
		// System.out.println("       -- Unidade Organizacional:" +
		// linha.substring(166,175));
		// System.out.println("Nova Fun��o -- Sigla:" +
		// linha.substring(175,178));
		// System.out.println("       -- C�digo de N�vel:" +
		// linha.substring(178,183));
		// System.out.println("       -- Escolaridade:" +
		// linha.substring(183,185));
		// System.out.println("       -- Op��o:" + linha.substring(185,186));
		// System.out.println("       -- Data Ingresso:" +
		// linha.substring(186,194));
		// System.out.println("       -- Data Sa�da:" +
		// linha.substring(194,202));
		// System.out.println("       -- Unidade Organizacional:" +
		// linha.substring(202,211));
		// System.out.println("Atividade da Fun��o:" +
		// linha.substring(211,215));
		// System.out.println("Lota��o -- Unidade Organizacional:" +
		// linha.substring(215,224));
		// System.out.println("        -- Data:" + linha.substring(224,232));
		// System.out.println("Localiza��o -- Org�o:" +
		// linha.substring(232,237));
		// System.out.println("            -- Unidade Organizacional:" +
		// linha.substring(237,246));
		// System.out.println("Ocorr�ncia Ingresso �rg�o -- Grupo:" +
		// linha.substring(246,248));
		// System.out.println("                          -- Ocorr�ncia:" +
		// linha.substring(248,251));
		// System.out.println("                          -- Data:" +
		// linha.substring(251,259));
		// System.out.println("                          -- Diploma Legal -- C�digo:"
		// + linha.substring(259,261));
		// System.out.println("                                           -- N�mero:"
		// + linha.substring(261,270));
		// System.out.println("                                           -- Data Publica��o:"
		// + linha.substring(270,278));
		// System.out.println("Ocorr�ncia Ingresso Serv. P�blico -- Grupo:" +
		// linha.substring(278,280));
		// System.out.println("                          -- Ocorr�ncia:" +
		// linha.substring(280,283));
		// System.out.println("                          -- Data:" +
		// linha.substring(283,291));
		// System.out.println("                          -- Diploma Legal -- C�digo:"
		// + linha.substring(291,293));
		// System.out.println("                                           -- N�mero:"
		// + linha.substring(293,302));
		// System.out.println("                                           -- Data Publica��o:"
		// + linha.substring(302,310));
		// System.out.println("Ocorr�ncia de Exclus�o -- Grupo:" +
		// linha.substring(310,312));
		// System.out.println("                       -- Ocorr�ncia:" +
		// linha.substring(312,315));
		// System.out.println("                       -- Data:" +
		// linha.substring(315,323));
		// System.out.println("                       -- Diploma Legal -- C�digo:"
		// + linha.substring(323,325));
		// System.out.println("                                        -- N�mero:"
		// + linha.substring(325,334));
		// System.out.println("                                        -- Data Publica��o:"
		// + linha.substring(334,342));
		// System.out.println("Ocorr�ncia Afastamento -- Grupo:" +
		// linha.substring(342,344));
		// System.out.println("                       -- Ocorr�ncia:" +
		// linha.substring(344,347));
		// System.out.println("                       -- Data In�cio:" +
		// linha.substring(347,355));
		// System.out.println("                       -- Data T�rmino:" +
		// linha.substring(355,363));
		// System.out.println("                       -- Diploma Legal -- C�digo:"
		// + linha.substring(363,365));
		// System.out.println("                                        -- N�mero:"
		// + linha.substring(365,374));
		// System.out.println("                                        -- Data Publica��o:"
		// + linha.substring(374,382));
		// System.out.println("Ocorr�ncia de Inatividade -- Grupo:" +
		// linha.substring(382,384));
		// System.out.println("                          -- Ocorr�ncia:" +
		// linha.substring(384,387));
		// System.out.println("                          -- Data:" +
		// linha.substring(387,395));
		// System.out.println("                          -- Diploma Legal -- C�digo:"
		// + linha.substring(395,397));
		// System.out.println("                                           -- N�mero:"
		// + linha.substring(397,406));
		// System.out.println("                                           -- Data Publica��o:"
		// + linha.substring(406,414));
		// System.out.println("Ocorr�ncia de Aposentadoria -- N� do Processo:" +
		// linha.substring(414,429));
		// System.out.println("                            -- Ano Previsto:" +
		// linha.substring(429,433));
		// System.out.println("                            -- Op��o Aposent. Integral:"
		// + linha.substring(433,434));
		// System.out.println("UORG de controle:" + linha.substring(434,443));
		// System.out.println("Ocorr�ncia Modif. Funcional -- Grupo:" +
		// linha.substring(443,445));
		// System.out.println("                            -- Ocorr�ncia:" +
		// linha.substring(445,448));
		// System.out.println("                            -- Data:" +
		// linha.substring(448,456));
		// System.out.println("                            -- Diploma Legal -- C�digo:"
		// + linha.substring(456,458));
		// System.out.println("                                             -- N�mero:"
		// + linha.substring(458,467));
		// System.out.println("                                             -- Data Publica��o:"
		// + linha.substring(467,475));
		// System.out.println("Regime Jur�dico - Anterior:" +
		// linha.substring(475,478));
		// System.out.println("Situa��o Servidor - Anterior:" +
		// linha.substring(478,480));
		// System.out.println("Mudan�a �rg�o -- �rg�o Destino:" +
		// linha.substring(480,485));
		// System.out.println("			  -- Data Libera��o:" +
		// linha.substring(485,493));
		// System.out.println("			  -- �rg�o Origem:" +
		// linha.substring(493,498));
		// System.out.println("�rg�o Anterior:" + linha.substring(498,503));
		// System.out.println("Matr�cula Anterior:" + linha.substring(503,510));
		// System.out.println("C�digo �rg�o Extinto / Modificada:" +
		// linha.substring(510,515));
		// System.out.println("Matr�cula Servidor Extinta / Modificada:" +
		// linha.substring(515,522));
		// System.out.println("�rg�o Atual:" + linha.substring(522,527));
		// System.out.println("Matr�cula Atual:" + linha.substring(527,534));
		// System.out.println("Mudan�a Unidade Pagadora -- C�digo UPAG:" +
		// linha.substring(534,543));
		// System.out.println("                         -- Data Libera��o:" +
		// linha.substring(543,551));
		// System.out.println("                         -- Motivo:" +
		// linha.substring(551,552));
		// System.out.println("Indicador de Pagamento Servidor:" +
		// linha.substring(552,553));
		// System.out.println("Registro de �bito -- Nome do Cart�rio:" +
		// linha.substring(553,603));
		// System.out.println("                  -- N� do Livro:" +
		// linha.substring(603,611));
		// System.out.println("                  -- N� da Folha:" +
		// linha.substring(611,617));
		// System.out.println("                  -- N� Registro:" +
		// linha.substring(617,625));
		// System.out.println("                  -- Data:" +
		// linha.substring(625,633));
		// System.out.println("Indicador de Exclus�o Instituidor:" +
		// linha.substring(633,634));
		// System.out.println("Dia de Exclus�o do Instituidor:" +
		// linha.substring(634,642));
		// System.out.println("Vale Alimenta��o -- Tipo:" +
		// linha.substring(642,643));
		// System.out.println("                 -- Data In�cio:" +
		// linha.substring(643,651));
		// System.out.println("                 -- Data Fim:" +
		// linha.substring(651, 659));
		// System.out.println("Indicador de Operador de Raio-X:" +
		// linha.substring(659,660));
		// System.out.println("�rg�o Requisitante:" + linha.substring(660,665));
		// System.out.println("C�digo da Vaga:" + linha.substring(665,672));
		// System.out.println("M�s de Concess�o do Anu�nio:" +
		// linha.substring(672,674));
		// System.out.println("Percentual de Operador Raio X:" +
		// linha.substring(674, 679));
		// System.out.println("Grupo - Ingr. Serv. P�b. -POSSE -- C�digo Grupo:"
		// + linha.substring(679,681));
		// System.out.println("                                -- Ocorr�ncia:" +
		// linha.substring(681,684));
		// System.out.println("                                -- Data:" +
		// linha.substring(684,692));
		// System.out.println("                                -- C�digo Diploma:"
		// + linha.substring(692,694));
		// System.out.println("                                -- Data do Diploma:"
		// + linha.substring(694,702));
		// System.out.println("                                -- N�mero do Diploma:"
		// + linha.substring(702,711));
		// System.out.println("Grupo Revers�o a Atividade -- Grupo de Ocorr�ncia:"
		// + linha.substring(711,713));
		// System.out.println("                           -- C�digo de Ocorr�ncia:"
		// + linha.substring(713,716));
		// System.out.println("                           -- Data da Ocorr�ncia:"
		// + linha.substring(716,724));
		// System.out.println("                           -- C�digo do Diploma:"
		// + linha.substring(724,726));
		// System.out.println("                           --Data Publica��o do Diploma:"
		// + linha.substring(726,734));
		// System.out.println("                           --N�mero do Diploma:"
		// + linha.substring(734,743));
		// System.out.println("Indicador de C�lculo Autom�tico -- Cargo:" +
		// linha.substring(743,744));
		// System.out.println("                                -- Fun��o:" +
		// linha.substring(744,745));
		// System.out.println("                                -- Sal�rio Fam�lia:"
		// + linha.substring(745,746));
		// System.out.println("                                -- Adicional por Tempo de Servi�o :"
		// + linha.substring(746,747));
		// System.out.println("                                -- FGTS:" +
		// linha.substring(747,748));
		// System.out.println("                                -- Presid�ncia Social:"
		// + linha.substring(748,749));
		// System.out.println("                                -- Imposto de Renda:"
		// + linha.substring(749,750));
		// System.out.println("                                -- Margem Consign�vel:"
		// + linha.substring(750,751));
		// System.out.println("                                -- Constribui��o Sindical:"
		// + linha.substring(751,752));
		// System.out.println("                                -- Adiantamento 13� Sal�rio:"
		// + linha.substring(752,753));
		// System.out.println("                                -- Abate Teto Constitucional:"
		// + linha.substring(753,754));
		// System.out.println("                                -- 13� Sal�rio:"
		// + linha.substring(754,755));
		// System.out.println("                                -- Plano de Seguridade Social 6%:"
		// + linha.substring(755,756));
		// System.out.println("                                -- F�rias:" +
		// linha.substring(756,757));
		// System.out.println("                                -- Pens�o:" +
		// linha.substring(757,758));
		// System.out.println("                                -- Benef�cios:" +
		// linha.substring(758,759));
		// System.out.println("                                -- IPMF/CPMF:" +
		// linha.substring(759,760));
		// System.out.println("                                -- RAIS:" +
		// linha.substring(760,761));
		// System.out.println("                                -- Diferen�a de URV:"
		// + linha.substring(761,762));
		// System.out.println("                                -- Adiantamento:"
		// + linha.substring(762,763));
		// System.out.println("                                -- Rendimento PASEP:"
		// + linha.substring(763,764));
		// break;
		// }
		//
		// linha = br.readLine().substring(0, 764);
		// teste = Integer.parseInt(linha.substring(17, 18));
		// if (teste.equals(3)) {
		// if(linha.substring(21,26).equals("00001")) {
		// System.out.print(linha.substring(9, 16));
		// System.out.print(", "+linha.substring(26,27));
		// System.out.println(", "+linha.substring(27,38));
		// }}
		//
		// linha = br.readLine().substring(0, 764);
		// teste = Integer.parseInt(linha.substring(17, 18));
		// if (teste.equals(4)) {
		// System.out.println("**********TOTOLIZA��O**********");
		// System.out.println(linha);
		// }
		//
		// linha = br.readLine().substring(0, 764);
		// teste = Integer.parseInt(linha.substring(17, 18));
		// if (teste.equals(9)) {
		// System.out.println("**********TRAILLER**********");
		// System.out.println(linha);
		// }
		//
		// br.close();
		// } catch (IOException ioe) {
		// ioe.printStackTrace();
		// }}

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));

			String html = "";
			html = html + "<html>";
			html = html + "<body>";
			html = html + "<table name='table' border='1'>";
			html = html + "<tr>";
			html = html + "<th>SIAPE</th>";
			html = html + "<th>NOME</th>";
			html = html + "<th>CPF</th>";
			html = html + "<th>RG</th>";
			html = html + "<th>ORG�O EXPEDI��O RG</th>";
			html = html + "<th>DATA EXPEDI��O RG</th>";
			html = html + "<th>UF DO RG</th>";
			html = html + "<th>TITULO DE ELEITOR</th>";
			html = html + "<th>PIS/PASEP</th>";
			html = html + "<th>NOME DA M�E</th>";
			html = html + "<th>SEXO</th>";
			html = html + "<th>DATA DE NASCIMENTO</th>";
			html = html + "<th>ESTADO CIVIL</th>";
			html = html + "<th>ENDERE�O</th>";
			html = html + "<th>NUMERO</th>";
			html = html + "<th>COMPLEMENTO</th>";
			html = html + "<th>BAIRRO</th>";
			html = html + "<th>CIDADE</th>";
			html = html + "<th>CEP</th>";
			html = html + "<th>UF</th>";
			html = html + "<th>REGIME JURIDICO</th>";
			html = html + "<th>JORNADA DE TRABALHO</th>";
			html = html + "<th>BANCO</th>";
			html = html + "<th>AGENCIA</th>";
			html = html + "<th>CONTA CORRENTE</th>";
			html = html + "<th>GRUPO/CARGO</th>";
			html = html + "<th>CLASSE</th>";
			html = html + "<th>PADR�O</th>";
			html = html + "<th>LOTA��O</th>";
			html = html + "<th>DATA ADMISS�O SERV. PUB.</th>";
			html = html + "<th>DATA DE ENTRADA NA OCUPA��O.</th>";
			html = html + "<th>DATA ADMISS�O ORG�O.</th>";
			html = html + "<th>SITUA��O</th>";
			html = html + "<th>GRUPO INGR. ORG�O</th>";
			html = html + "<th>OCORRENC. INGR. ORG�O</th>";
			html = html + "</tr>";

			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {
					html = html + "<tr>";
					html = html + "<td>" + linha.substring(9, 16) + "</td>";
					html = html + "<td>" + linha.substring(20, 80) + "</td>";
					html = html + "<td>"
							+ Validator.formatarCpf(linha.substring(80, 91))
							+ "</td>";
					html = html + "<td>" + linha.substring(333, 347) + "</td>";
					html = html + "<td>" + linha.substring(347, 352) + "</td>";
					html = html + "<td>"
							+ Validator.formatarData(linha.substring(352, 360))
							+ "</td>";

					html = html + "<td>" + linha.substring(360, 362) + "</td>";
					html = html + "<td>" + linha.substring(362, 375) + "</td>";
					html = html + "<td>"
							+ Validator.formatarPis(linha.substring(91, 102))
							+ "</td>";
					html = html + "<td>" + linha.substring(102, 152) + "</td>";
					html = html + "<td>" + linha.substring(152, 153) + "</td>";
					html = html + "<td>"
							+ Validator.formatarData(linha.substring(153, 161))
							+ "</td>";

					if (tipoRegistro.equals(1)) {
						html = html + "<td>";
						if (linha.substring(161, 162).equals("1")) {
							html = html + "SOLTEIRO";
						} else if (linha.substring(161, 162).equals("2")) {
							html = html + "CASADO";
						} else if (linha.substring(161, 162).equals("3")) {
							html = html + "SEPARADO";
						} else if (linha.substring(161, 162).equals("4")) {
							html = html + "DIVORCIADO";
						} else if (linha.substring(161, 162).equals("5")) {
							html = html + "VIUVO";
						}
						html = html + "</td>";
					}

					if (tipoRegistro.equals(1)) {
						html = html + "<td>" + linha.substring(201, 241)
								+ "</td>";
						html = html + "<td>" + linha.substring(241, 247)
								+ "</td>";
						html = html + "<td>" + linha.substring(247, 268)
								+ "</td>";
						html = html + "<td>" + linha.substring(268, 293)
								+ "</td>";
						html = html + "<td>" + linha.substring(293, 323)
								+ "</td>";
						html = html + "<td>" + linha.substring(323, 331)
								+ "</td>";
						html = html + "<td>" + linha.substring(331, 333)
								+ "</td>";
					}

				}
				if (tipoRegistro.equals(2)) {
					html = html + "<td>" + linha.substring(20, 23) + "</td>";
					html = html + "<td>" + linha.substring(90, 92) + "</td>";
					html = html + "<td>";
					if (("001").equals(linha.substring(38, 41))) {
						html = html + "BB";
					} else if (("104").equals(linha.substring(38, 41))) {
						html = html + "CEF";
					} else if (("341").equals(linha.substring(38, 41))) {
						html = html + "ITAU";
					} else {
						html = html + linha.substring(38, 41);
					}
					html = html + "</td>";

					html = html + "<td>" + linha.substring(41, 47) + "</td>";
					html = html + "<td>" + linha.substring(47, 60) + "</td>";
					html = html + "<td>";
					if (linha.substring(113, 116).equals("701")) {
						html = html + "T�CNICO/";
						if (linha.substring(116, 119).equals("001")) {
							html = html + "ADMINISTRADOR";
						} else if (linha.substring(116, 119).equals("009")) {
							html = html + "AUDITOR";
						} else if (linha.substring(116, 119).equals("010")) {
							html = html + "BIBLIOTECARIO";
						} else if (linha.substring(116, 119).equals("015")) {
							html = html + "CONTADOR";
						} else if (linha.substring(116, 119).equals("029")) {
							html = html + "ENFERMEIRO";
						} else if (linha.substring(116, 119).equals("031")) {
							html = html + "ENGENHEIRO";
						} else if (linha.substring(116, 119).equals("032")) {
							html = html + "ENG. DE SEG. DO TRABALHO ";
						} else if (linha.substring(116, 119).equals("045")) {
							html = html + "JORNALISTA";
						} else if (linha.substring(116, 119).equals("047")) {
							html = html + "M�DICO";
						} else if (linha.substring(116, 119).equals("058")) {
							html = html + "PEDAGOGO";
						} else if (linha.substring(116, 119).equals("062")) {
							html = html + "ANAL. DE TEC. DA INFORMA��O";
						} else if (linha.substring(116, 119).equals("066")) {
							html = html + "PROGRAMADOR VISUAL";
						} else if (linha.substring(116, 119).equals("076")) {
							html = html + "SECRETARIADO EXECUTIVO";
						} else if (linha.substring(116, 119).equals("079")) {
							html = html + "TEC. EM ASSUN. EDUCACIONAIS";
						} else if (linha.substring(116, 119).equals("200")) {
							html = html + "ASS. EM ADMINISTRA��O";
						} else if (linha.substring(116, 119).equals("224")) {
							html = html + "TEC. EM CONTABILIDADE";
						} else if (linha.substring(116, 119).equals("226")) {
							html = html + "TEC. EM TECNOL. DA INFORMA��O";
						} else if (linha.substring(116, 119).equals("233")) {
							html = html + "TEC. EM ENFERMAGEM";
						} else if (linha.substring(116, 119).equals("244")) {
							html = html + "TEC. EM LABORAT�RIO";
						} else if (linha.substring(116, 119).equals("257")) {
							html = html + "TEC. EM RADIOLOGIA";
						} else if (linha.substring(116, 119).equals("403")) {
							html = html + "ASS. DE ALUNO";
						} else if (linha.substring(116, 119).equals("409")) {
							html = html + "AUX. DE BIBLIOTECA";
						} else if (linha.substring(116, 119).equals("421")) {
							html = html + "CONTINUO";
						} else if (linha.substring(116, 119).equals("422")) {
							html = html + "CONZINHEIRO";
						} else if (linha.substring(116, 119).equals("436")) {
							html = html + "IMPRESSOR";
						} else if (linha.substring(116, 119).equals("459")) {
							html = html + "RECEPCIONISTA";
						} else if (linha.substring(116, 119).equals("464")) {
							html = html + "TELEFONISTA";
						} else if (linha.substring(116, 119).equals("611")) {
							html = html + "AUX. DE AGROPECU�RIA";
						} else if (linha.substring(116, 119).equals("623")) {
							html = html + "AUX. DE NUTRI��O";
						} else if (linha.substring(116, 119).equals("828")) {
							html = html + "OPER. DE MAQ. DE LAVANDERIA";
						}
					} else if (linha.substring(113, 116).equals("702")) {
						html = html + "DOCENTE/";
						if (linha.substring(116, 119).equals("001")) {
							html = html + "PROF. ENS. BAS. TEC. TECNOL.";
						} else if (linha.substring(116, 119).equals("003")) {
							html = html + "PROF. ENS. BAS. TEC. TECNOL. - SUB";
						}
					} else if (linha.substring(113, 116).equals("060")) {
						html = html + "DOCENTE/";
						if (linha.substring(116, 119).equals("001")) {
							html = html + "PROF. DO 3� GRAU";
						} else if (linha.substring(116, 119).equals("012")) {
							html = html + "PROF. DO 1� E 2� GRAUS - SUB";
						}
					} else {
						html = html + linha.substring(116, 119);
					}
					html = html + "</td>";

					html = html + "<td>" + linha.substring(119, 120) + "</td>";

					html = html + "<td>" + linha.substring(120, 123) + "</td>";
					html = html + "<td>";
					if (linha.substring(215, 224).equals("000000003")) {
						html = html + "REITORIA";
					} else if (linha.substring(215, 224).equals("000000012")) {
						html = html + "CAMPUS CURITIBA";
					} else if (linha.substring(215, 224).equals("000000008")) {
						html = html + "PROGEPE";
					} else if (linha.substring(215, 224).equals("000000006")) {
						html = html + "PROPLAN";
					} else if (linha.substring(215, 224).equals("000000007")) {
						html = html + "PRAI";
					} else if (linha.substring(215, 224).equals("000000004")) {
						html = html + "GABINETE";
					} else if (linha.substring(215, 224).equals("000000005")) {
						html = html + "PREPPG";
					} else if (linha.substring(215, 224).equals("000000023")) {
						html = html + "DIR. ADM E FINANCEIRO/ C. FOZ";
					} else if (linha.substring(215, 224).equals("000000036")) {
						html = html + "CAMPUS UMUARAMA";
					} else if (linha.substring(215, 224).equals("000000121")) {
						html = html + "N. A. AS. CHATEAUBRIAND";
					} else if (linha.substring(215, 224).equals("000000017")) {
						html = html + "DIR. GERAL/ C. PARANAGUA";
					} else if (linha.substring(215, 224).equals("000000009")) {
						html = html + "PRI";
					} else if (linha.substring(215, 224).equals("000000016")) {
						html = html + "CAMPUS PARANAGU�";
					} else if (linha.substring(215, 224).equals("000000024")) {
						html = html + "CAMPUS JACAREZINHO";
					} else if (linha.substring(215, 224).equals("000000028")) {
						html = html + "CAMPUS PARANAVAI";
					} else if (linha.substring(215, 224).equals("000000117")) {
						html = html + "CAMPUS LODRINA";
					} else if (linha.substring(215, 224).equals("000000020")) {
						html = html + "CAMPUS FOZ DO IGUA�U";
					} else if (linha.substring(215, 224).equals("000000112")) {
						html = html + "CAMPUS PALMAS";
					} else if (linha.substring(215, 224).equals("000000018")) {
						html = html + "DIR. ENSINO/ C. PGUA";
					} else if (linha.substring(215, 224).equals("000000032")) {
						html = html + "CAMPUS TELEMACO BORBA";
					} else if (linha.substring(215, 224).equals("000000041")) {
						html = html + "N. A. DE CAMPO LARGO";
					} else if (linha.substring(215, 224).equals("000000021")) {
						html = html + "DIR. GERAL/ C. FOZ";
					} else if (linha.substring(215, 224).equals("000000116")) {
						html = html + "N. A. DE IRATI";
					} else {
						html = html + linha.substring(215, 224);
					}
					html = html + "</td>";
					
					html = html + "<td>" + linha.substring(283, 285) + "/"
					+ linha.substring(285, 287) + "/"
					+ linha.substring(287, 291) + "</td>";
					
					html = html + "<td>" + linha.substring(123, 125) + "/"
					+ linha.substring(125, 127) + "/"
					+ linha.substring(127, 131) + "</td>";


					html = html + "<td>" + linha.substring(251, 253) + "/"
							+ linha.substring(253, 255) + "/"
							+ linha.substring(255, 259) + "</td>";

					Integer situacao = Integer
							.parseInt(linha.substring(23, 25));
					if (situacao.equals(1)) {
						html = html + "<td> ATIVO PERMANENTE </td>";
					} else if (situacao.equals(2)) {
						html = html + "<td> APOSENTADO </td>";
					} else if (situacao.equals(3)) {
						html = html + "<td> REQUISITADO </td>";
					} else if (situacao.equals(4)) {
						html = html + "<td> NOMEADO CARGO COMIS. </td>";
					} else if (situacao.equals(8)) {
						html = html + "<td> CEDIDO </td>";
					} else if (situacao.equals(9)) {
						html = html + "<td> REDISTRIBUIDO </td>";
					} else if (situacao.equals(12)) {
						html = html + "<td> CONTRATO TEMPORARIO </td>";
					} else if (situacao.equals(13)) {
						html = html + "<td> EM DISPONIBILIDADE </td>";
					} else if (situacao.equals(14)) {
						html = html + "<td> REQ. DE OUTROS ORG�OS </td>";
					} else if (situacao.equals(15)) {
						html = html + "<td> INSTITUIDOR PENS�O </td>";
					} else if (situacao.equals(41)) {
						html = html + "<td> COLABORADOR PCCTAE </td>";
					} else if (situacao.equals(66)) {
						html = html + "<td> ESTAGIARIO </td>";
					} else if (situacao.equals(84)) {
						html = html + "<td> PENSIONISTA </td>";
					} else if (situacao.equals(93)) {
						html = html + "<td> BENEFICIARIO PENS�O </td>";
					} else if (situacao.equals(18)) {
						html = html + "<td> EXERC DESCENT CARREI </td>";
					} else if (situacao.equals(19)) {
						html = html + "<td> EXERCICIO PROVISORIO </td>";
					} else {
						html = html + "<td>" + situacao + "</td>";
					}
					
					html = html + "<td>" + linha.substring(246,248)+" </td>";
					html = html + "<td>" + linha.substring(248,251)+" </td>";

					html = html + "</tr>";
				}
			}
			html = html + "</table>";
			html = html + "</body>";
			html = html + "</html>";

			FileOutputStream file = new FileOutputStream("C:\\Relatorio.html");
			PrintStream print = new PrintStream(file);
			print.println(html);
			System.out.println("Arquivo gerado com sucesso!!!");
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
