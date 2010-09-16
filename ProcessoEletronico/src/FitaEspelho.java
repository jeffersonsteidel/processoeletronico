import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class FitaEspelho {
	public static void main(String[] args) {
		/*try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));
			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer teste = Integer.parseInt(linha.substring(17, 18));
				if (teste.equals(1)) {
					System.out.println("**********DADOS PESSOAIS**********");
					System.out.println("Unidade Pagadora:" + linha.substring(0, 9));
					System.out.println("Siape:" + linha.substring(9, 16));
					System.out.println("DV Matricula:" +linha.substring(16, 17));
					System.out.println("Tipo de Registro:" + linha.substring(17, 18));
					System.out.println("Sigla UF UPAG:" + linha.substring(18, 20));
					System.out.println("Nome:" + linha.substring(20, 80));
					System.out.println("CPF:" + linha.substring(80, 91));
					System.out.println("PIS/PASEP:" + linha.substring(91,102));
					System.out.println("Nome da Mãe:" + linha.substring(102, 152));
					System.out.println("Sexo:" + linha.substring(152, 153));
					System.out.println("Data de Nascimento:" + linha.substring(153, 161));
					System.out.println("Estado Civil:" + linha.substring(161, 162));
					System.out.println("Nivel de Escolaridade:" + linha.substring(162,164));
					System.out.println("Código da Titulação/Formação:" + linha.substring(164, 166));
					System.out.println("Filler:" + linha.substring(166, 171));
					System.out.println("Nacionalidade:" + linha.substring(171, 172));
					System.out.println("Naturalidade:" + linha.substring(172, 174));
					System.out.println("Pais:" + linha.substring(174, 177));
					System.out.println("Ano de Chegada:" + linha.substring(177, 181));
					System.out.println("Quantidade de Dependentes IR:" + linha.substring(181, 183));
					System.out.println("Quantidade de Dependentes SF:" + linha.substring(183, 185));
					System.out.println("Data do Primeiro Emprego:" + linha.substring(185, 193));
					System.out.println("Identificação Origem:" + linha.substring(193, 201));
					System.out.println("Endereço -- Logradouro:" + linha.substring(201, 241));
					System.out.println("         -- Numero:" + linha.substring(241, 247));
					System.out.println("         -- Complemento:" + linha.substring(247, 268));
					System.out.println("Bairro:" + linha.substring(268, 293));
					System.out.println("Cidade:" + linha.substring(293, 323));
					System.out.println("CEP:" + linha.substring(323, 331));
					System.out.println("UF:" + linha.substring(331, 333));
					System.out.println("RG:" + linha.substring(333,347));
					System.out.println("Sigla do Orgão Expedidor do RG:" + linha.substring(347, 352));
					System.out.println("Data de Expedição:" + linha.substring(352, 360));
					System.out.println("UF do RG:" + linha.substring(360, 362));
					System.out.println("Titulo de Eleitor:" + linha.substring(362, 375));
					System.out.println("Filler:" + linha.substring(375, 764));
				}
				
				linha = br.readLine().substring(0, 764);
				teste = Integer.parseInt(linha.substring(17, 18));
				if (teste.equals(2)) {
					System.out.println("-------------DADOS FUNCIONAIS-------------------");
					System.out.println("Unidade Pagadora:" + linha.substring(0, 9));
					System.out.println("Siape:" + linha.substring(9, 16));
					System.out.println("DV Matricula:" +linha.substring(16, 17));
					System.out.println("Tipo de Registro:" + linha.substring(17, 18));
					System.out.println("Sigla UF UPAG:" + linha.substring(18, 20));
					System.out.println("Sigla do Regime Juridico Único:" + linha.substring(20,23));
					System.out.println("Código da Situação do Servidor:" + linha.substring(23,25));
					System.out.println("Carteira de Trabalho -- Número:" + linha.substring(25,31));
					System.out.println("                     -- Série:" + linha.substring(31,36));
					System.out.println("                     -- UF:" + linha.substring(36,38));
					System.out.println("Banco:" + linha.substring(38,41));
					System.out.println("Agência:" + linha.substring(41,47));
					System.out.println("Conta Corrente:" + linha.substring(47,60));
					System.out.println("FGTS -- Data de Opção:" + linha.substring(60,68));
					System.out.println("     -- Banco:" + linha.substring(68,71));
					System.out.println("     -- Agência:" + linha.substring(71,77));
					System.out.println("     -- Conta Corrente:" + linha.substring(77,90));
					System.out.println("Jornada de Trabalho:" + linha.substring(90,92));
					System.out.println("Percentual de Tempo de Serviço:" + linha.substring(92,94));
					System.out.println("Data de Cadastramento do Servidor:" + linha.substring(94,102));
					System.out.println("Indicação de Suspenssão:" + linha.substring(102,103));
					System.out.println("Pagamento Data Supressão de Pagamento:" + linha.substring(103,109));
					System.out.println("Proporcionalidade -- Numerador:" + linha.substring(109,111));
					System.out.println("                  -- Denominador:" + linha.substring(111,113));
					System.out.println("Cargo/Emprego -- Grupo:" + linha.substring(113,116));
					System.out.println("              -- Cargo:" + linha.substring(116,119));
					System.out.println("              -- Classe:" + linha.substring(119,120));
					System.out.println("              -- Referência/Nível/Padrão:" + linha.substring(120,123));
					System.out.println("              -- Data Entrada Ocupação:" + linha.substring(123,131));
					System.out.println("              -- Data Entrada Saída:" + linha.substring(131,139));
					System.out.println("Função -- Sigla:" + linha.substring(139,142));
					System.out.println("       -- Código de Nível:" + linha.substring(142,147));
					System.out.println("       -- Escolaridade:" + linha.substring(147,149));
					System.out.println("       -- Opção:" + linha.substring(149,150));
					System.out.println("       -- Data Ingresso:" + linha.substring(150,158));
					System.out.println("       -- Data Saída:" + linha.substring(158,166));
					System.out.println("       -- Unidade Organizacional:" + linha.substring(166,175));
					System.out.println("Nova Função -- Sigla:" + linha.substring(175,178));
					System.out.println("       -- Código de Nível:" + linha.substring(178,183));
					System.out.println("       -- Escolaridade:" + linha.substring(183,185));
					System.out.println("       -- Opção:" + linha.substring(185,186));
					System.out.println("       -- Data Ingresso:" + linha.substring(186,194));
					System.out.println("       -- Data Saída:" + linha.substring(194,202));
					System.out.println("       -- Unidade Organizacional:" + linha.substring(202,211));
					System.out.println("Atividade da Função:" + linha.substring(211,215));
					System.out.println("Lotação -- Unidade Organizacional:" + linha.substring(215,224));
					System.out.println("        -- Data:" + linha.substring(224,232));
					System.out.println("Localização -- Orgão:" + linha.substring(232,237));
					System.out.println("            -- Unidade Organizacional:" + linha.substring(237,246));
					System.out.println("Ocorrência Ingresso Órgão -- Grupo:" + linha.substring(246,248));
					System.out.println("                          -- Ocorrência:" + linha.substring(248,251));
					System.out.println("                          -- Data:" + linha.substring(251,259));
					System.out.println("                          -- Diploma Legal -- Código:" + linha.substring(259,261));
					System.out.println("                                           -- Número:" + linha.substring(261,270));
					System.out.println("                                           -- Data Publicação:" + linha.substring(270,278));
					System.out.println("Ocorrência Ingresso Serv. Público -- Grupo:" + linha.substring(278,280));
					System.out.println("                          -- Ocorrência:" + linha.substring(280,283));
					System.out.println("                          -- Data:" + linha.substring(283,291));
					System.out.println("                          -- Diploma Legal -- Código:" + linha.substring(291,293));
					System.out.println("                                           -- Número:" + linha.substring(293,302));
					System.out.println("                                           -- Data Publicação:" + linha.substring(302,310));
					System.out.println("Ocorrência de Exclusão -- Grupo:" + linha.substring(310,312));
					System.out.println("                       -- Ocorrência:" + linha.substring(312,315));
					System.out.println("                       -- Data:" + linha.substring(315,323));
					System.out.println("                       -- Diploma Legal -- Código:" + linha.substring(323,325));
					System.out.println("                                        -- Número:" + linha.substring(325,334));
					System.out.println("                                        -- Data Publicação:" + linha.substring(334,342));
					System.out.println("Ocorrência Afastamento -- Grupo:" + linha.substring(342,344));
					System.out.println("                       -- Ocorrência:" + linha.substring(344,347));
					System.out.println("                       -- Data Início:" + linha.substring(347,355));
					System.out.println("                       -- Data Término:" + linha.substring(355,363));
					System.out.println("                       -- Diploma Legal -- Código:" + linha.substring(363,365));
					System.out.println("                                        -- Número:" + linha.substring(365,374));
					System.out.println("                                        -- Data Publicação:" + linha.substring(374,382));
					System.out.println("Ocorrência de Inatividade -- Grupo:" + linha.substring(382,384));
					System.out.println("                          -- Ocorrência:" + linha.substring(384,387));
					System.out.println("                          -- Data:" + linha.substring(387,395));
					System.out.println("                          -- Diploma Legal -- Código:" + linha.substring(395,397));
					System.out.println("                                           -- Número:" + linha.substring(397,406));
					System.out.println("                                           -- Data Publicação:" + linha.substring(406,414));
					System.out.println("Ocorrência de Aposentadoria -- Nº do Processo:" + linha.substring(414,429));
					System.out.println("                            -- Ano Previsto:" + linha.substring(429,433));
					System.out.println("                            -- Opção Aposent. Integral:" + linha.substring(433,434));
					System.out.println("UORG de controle:" + linha.substring(434,443));
					System.out.println("Ocorrência Modif. Funcional -- Grupo:" + linha.substring(443,445));
					System.out.println("                            -- Ocorrência:" + linha.substring(445,448));
					System.out.println("                            -- Data:" + linha.substring(448,456));
					System.out.println("                            -- Diploma Legal -- Código:" + linha.substring(456,458));
					System.out.println("                                             -- Número:" + linha.substring(458,467));
					System.out.println("                                             -- Data Publicação:" + linha.substring(467,475));
					System.out.println("Regime Jurídico - Anterior:" + linha.substring(475,478));
					System.out.println("Situação Servidor - Anterior:" + linha.substring(478,480));
					System.out.println("Mudança Órgão -- Órgão Destino:" + linha.substring(480,485));
					System.out.println("			  -- Data Liberação:" + linha.substring(485,493));
					System.out.println("			  -- Órgão Origem:" + linha.substring(493,498));
					System.out.println("Órgão Anterior:" + linha.substring(498,503));
					System.out.println("Matrícula Anterior:" + linha.substring(503,510));
					System.out.println("Código Órgão Extinto / Modificada:" + linha.substring(510,515));
					System.out.println("Matrícula Servidor Extinta / Modificada:" + linha.substring(515,522));
					System.out.println("Órgão Atual:" + linha.substring(522,527));
					System.out.println("Matrícula Atual:" + linha.substring(527,534));
					System.out.println("Mudança Unidade Pagadora -- Código UPAG:" + linha.substring(534,543));
					System.out.println("                         -- Data Liberação:" + linha.substring(543,551));
					System.out.println("                         -- Motivo:" + linha.substring(551,552));
					System.out.println("Indicador de Pagamento Servidor:" + linha.substring(552,553));
					System.out.println("Registro de Óbito -- Nome do Cartório:" + linha.substring(553,603));
					System.out.println("                  -- Nº do Livro:" + linha.substring(603,611));
					System.out.println("                  -- Nº da Folha:" + linha.substring(611,617));
					System.out.println("                  -- Nº Registro:" + linha.substring(617,625));
					System.out.println("                  -- Data:" + linha.substring(625,633));
					System.out.println("Indicador de Exclusão Instituidor:" + linha.substring(633,634));
					System.out.println("Dia de Exclusão do Instituidor:" + linha.substring(634,642));
					System.out.println("Vale Alimentação -- Tipo:" + linha.substring(642,643));
					System.out.println("                 -- Data Início:" + linha.substring(643,651));
					System.out.println("                 -- Data Fim:" + linha.substring(651, 659));
					System.out.println("Indicador de Operador de Raio-X:" + linha.substring(659,660));
					System.out.println("Órgão Requisitante:" + linha.substring(660,665));
					System.out.println("Código da Vaga:" + linha.substring(665,672));
					System.out.println("Mês de Concessão do Anuênio:" + linha.substring(672,674));
					System.out.println("Percentual de Operador Raio X:" + linha.substring(674, 679));
					System.out.println("Grupo - Ingr. Serv. Púb. -POSSE -- Código Grupo:" + linha.substring(679,681));
					System.out.println("                                -- Ocorrência:" + linha.substring(681,684));
					System.out.println("                                -- Data:" + linha.substring(684,692));
					System.out.println("                                -- Código Diploma:" + linha.substring(692,694));
					System.out.println("                                -- Data do Diploma:" + linha.substring(694,702));
					System.out.println("                                -- Número do Diploma:" + linha.substring(702,711));
					System.out.println("Grupo Reversão a Atividade -- Grupo de Ocorrência:" + linha.substring(711,713));
					System.out.println("                           -- Código de Ocorrência:" + linha.substring(713,716));
					System.out.println("                           -- Data da Ocorrência:" + linha.substring(716,724));
					System.out.println("                           -- Código do Diploma:" + linha.substring(724,726));
					System.out.println("                           --Data Publicação do Diploma:" + linha.substring(726,734));
					System.out.println("                           --Número do Diploma:" + linha.substring(734,743));
					System.out.println("Indicador de Cálculo Automático -- Cargo:" + linha.substring(743,744));
					System.out.println("                                -- Função:" + linha.substring(744,745));
					System.out.println("                                -- Salário Família:" + linha.substring(745,746));
					System.out.println("                                -- Adicional por Tempo de Serviço :" + linha.substring(746,747));
					System.out.println("                                -- FGTS:" + linha.substring(747,748));
					System.out.println("                                -- Presidência Social:" + linha.substring(748,749));
					System.out.println("                                -- Imposto de Renda:" + linha.substring(749,750));
					System.out.println("                                -- Margem Consignável:" + linha.substring(750,751));
					System.out.println("                                -- Constribuição Sindical:" + linha.substring(751,752));
					System.out.println("                                -- Adiantamento 13º Salário:" + linha.substring(752,753));
					System.out.println("                                -- Abate Teto Constitucional:" + linha.substring(753,754));
					System.out.println("                                -- 13º Salário:" + linha.substring(754,755));
					System.out.println("                                -- Plano de Seguridade Social 6%:" + linha.substring(755,756));
					System.out.println("                                -- Férias:" + linha.substring(756,757));
					System.out.println("                                -- Pensão:" + linha.substring(757,758));
					System.out.println("                                -- Benefícios:" + linha.substring(758,759));
					System.out.println("                                -- IPMF/CPMF:" + linha.substring(759,760));
					System.out.println("                                -- RAIS:" + linha.substring(760,761));
					System.out.println("                                -- Diferença de URV:" + linha.substring(761,762));
					System.out.println("                                -- Adiantamento:" + linha.substring(762,763));
					System.out.println("                                -- Rendimento PASEP:" + linha.substring(763,764));
				}
				
				
				linha = br.readLine().substring(0, 764);
				teste = Integer.parseInt(linha.substring(17, 18));
				if (teste.equals(3)) {
					System.out.println("**********DADOS FINANCEIROS**********");
					System.out.println(linha);
				}
				
				linha = br.readLine().substring(0, 764);
				teste = Integer.parseInt(linha.substring(17, 18));
				if (teste.equals(4)) {
					System.out.println("**********TOTOLIZAÇÃO**********");
					System.out.println(linha);
				}
				
				linha = br.readLine().substring(0, 764);
				teste = Integer.parseInt(linha.substring(17, 18));
				if (teste.equals(9)) {
					System.out.println("**********TRAILLER**********");
					System.out.println(linha);
				}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		*/
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
	        html = html + "<th>GRUPO</th>";
	        html = html + "<th>CARGO</th>";
	        html = html + "<th>LOTAÇÃO</th>";
	        html = html + "<th>DATA ADMISSÃO</th>";
	        html = html + "<th>SITUAÇÃO</th>";
	        html = html + "</tr>";
	        
			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer teste = Integer.parseInt(linha.substring(17, 18));
				if (teste.equals(1)) {
					html = html + "<tr>";
					html = html + "<td>" + linha.substring(9, 16) + "</td>";
					html = html + "<td>" + linha.substring(20, 80) + "</td>";
					
				} 
				if (teste.equals(2)) {
					html = html + "<td>";
					if(linha.substring(113,116).equals("701")){
						html = html + "TÉCNICO";
					}
					else if(linha.substring(113,116).equals("702")){
						html = html + "DOCENTE";
					}else{
						html = html + linha.substring(113,116);
					}
					html = html + "</td>";
					html = html + "<td>" + linha.substring(116, 119) + "</td>";
					html = html + "<td>" + linha.substring(215, 224) + "</td>";
					html = html + "<td>" + linha.substring(123, 131) + "</td>";
					String situacao = linha.substring(315,323);
					if(situacao.equals("00000000")){
					 html = html + "<td> ATIVO </td>";
					}else{
					 html = html + "<td> INATIVO </td>";
					}
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