import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FitaEspelho {

	public static void main(String[] args) {

		try {
			String arquivo = "C://FITA.txt";
			StringBuffer conteudo = new StringBuffer("");
			FileInputStream fi = new FileInputStream(arquivo);
			int c;
			while ((c = fi.read()) != -1) {
				conteudo.append((char) c);
			}
			System.out.println("-------------DADOS PESSOAIS-------------------");
			System.out.println("Unidade Pagadora:" + conteudo.substring(0, 9));
			System.out.println("Siape:" + conteudo.substring(9, 16));
			System.out.println("DV Matricula:" +conteudo.substring(16, 17));
			System.out.println("Tipo de Registro:" + conteudo.substring(17, 18));
			System.out.println("Sigla UF UPAG:" + conteudo.substring(18, 20));
			System.out.println("Nome:" + conteudo.substring(20, 80));
			System.out.println("CPF:" + conteudo.substring(80, 91));
			System.out.println("PIS/PASEP:" + conteudo.substring(91,102));
			System.out.println("Nome da Mãe:" + conteudo.substring(102, 152));
			System.out.println("Sexo:" + conteudo.substring(152, 153));
			System.out.println("Data de Nascimento:" + conteudo.substring(153, 161));
			System.out.println("Estado Civil:" + conteudo.substring(161, 162));
			System.out.println("Nivel de Escolaridade:" + conteudo.substring(162,164));
			System.out.println("Código da Titulação/Formação:" + conteudo.substring(164, 166));
			System.out.println("Filler:" + conteudo.substring(166, 171));
			System.out.println("Nacionalidade:" + conteudo.substring(171, 172));
			System.out.println("Naturalidade:" + conteudo.substring(172, 174));
			System.out.println("Pais:" + conteudo.substring(174, 177));
			System.out.println("Ano de Chegada:" + conteudo.substring(177, 181));
			System.out.println("Quantidade de Dependentes IR:" + conteudo.substring(181, 183));
			System.out.println("Quantidade de Dependentes SF:" + conteudo.substring(183, 185));
			System.out.println("Data do Primeiro Emprego:" + conteudo.substring(185, 193));
			System.out.println("Identificação Origem:" + conteudo.substring(193, 201));
			System.out.println("Endereço -- Logradouro:" + conteudo.substring(201, 241));
			System.out.println("         -- Numero:" + conteudo.substring(241, 247));
			System.out.println("         -- Complemento:" + conteudo.substring(247, 268));
			System.out.println("Bairro:" + conteudo.substring(268, 293));
			System.out.println("Cidade:" + conteudo.substring(293, 323));
			System.out.println("CEP:" + conteudo.substring(323, 331));
			System.out.println("UF:" + conteudo.substring(331, 333));
			System.out.println("RG:" + conteudo.substring(333,347));
			System.out.println("Sigla do Orgão Expedidor do RG:" + conteudo.substring(347, 352));
			System.out.println("Data de Expedição:" + conteudo.substring(352, 360));
			System.out.println("UF do RG:" + conteudo.substring(360, 362));
			System.out.println("Titulo de Eleitor:" + conteudo.substring(362, 375));
			System.out.println("Filler:" + conteudo.substring(375, 764));
			
			System.out.println("-------------DADOS FUNCIONAIS-------------------");
			System.out.println("Unidade Pagadora:" + conteudo.substring(764,775));
			System.out.println("Matricula SIAPE:" + conteudo.substring(775,782));
			System.out.println("DV Matricula:" +conteudo.substring(782, 783));
			System.out.println("Tipo de Registro:" + conteudo.substring(783, 784));
			System.out.println("Sigla UF UPAG:" + conteudo.substring(784, 786));
			System.out.println("Sigla do Regime Juridico Único:" + conteudo.substring(786, 789));
			System.out.println("Código da Situação do Servidor:" + conteudo.substring(789, 791));
			System.out.println("Carteira de Trabalho -- Número:" + conteudo.substring(791, 797));
			System.out.println("                     -- Série:" + conteudo.substring(797, 802));
			System.out.println("                     -- UF:" + conteudo.substring(802, 804));
			System.out.println("Banco:" + conteudo.substring(804, 807));
			System.out.println("Agência:" + conteudo.substring(807, 813));
			System.out.println("Conta Corrente:" + conteudo.substring(813, 826));
			System.out.println("FGTS -- Data de Opção:" + conteudo.substring(826, 834));
			System.out.println("     -- Banco:" + conteudo.substring(834, 837));
			System.out.println("     -- Agência:" + conteudo.substring(837, 843));
			System.out.println("     -- Conta Corrente:" + conteudo.substring(843, 856));
			System.out.println("Jornada de Trabalho:" + conteudo.substring(856, 858));
			System.out.println("Percentual de Tempo de Serviço:" + conteudo.substring(858, 860));
			System.out.println("Data de Cadastramento do Servidor:" + conteudo.substring(860, 868));
			System.out.println("Indicação de Suspenssão:" + conteudo.substring(868, 869));
			System.out.println("Pagamento Data Supressão de Pagamento:" + conteudo.substring(869, 875));
			System.out.println("Proporcionalidade -- Numerador:" + conteudo.substring(875, 877));
			System.out.println("                  -- Denominador:" + conteudo.substring(877, 879));
			System.out.println("Cargo/Emprego -- Grupo:" + conteudo.substring(879, 882));
			System.out.println("              -- Cargo:" + conteudo.substring(882, 885));
			System.out.println("              -- Classe:" + conteudo.substring(885, 886));
			System.out.println("              -- Referência/Nível/Padrão:" + conteudo.substring(886, 889));
			System.out.println("              -- Data Entrada Ocupação:" + conteudo.substring(889, 897));
			System.out.println("              -- Data Entrada Saída:" + conteudo.substring(897, 905));
			System.out.println("Função -- Sigla:" + conteudo.substring(905, 908));
			System.out.println("       -- Código de Nível:" + conteudo.substring(908, 913));
			System.out.println("       -- Escolaridade:" + conteudo.substring(913, 915));
			System.out.println("       -- Opção:" + conteudo.substring(915, 916));
			System.out.println("       -- Data Ingresso:" + conteudo.substring(916, 924));
			System.out.println("       -- Data Saída:" + conteudo.substring(924, 932));
			System.out.println("       -- Unidade Organizacional:" + conteudo.substring(932, 941));
			System.out.println("Nova Função -- Sigla:" + conteudo.substring(941, 944));
			System.out.println("       -- Código de Nível:" + conteudo.substring(944, 949));
			System.out.println("       -- Escolaridade:" + conteudo.substring(949, 951));
			System.out.println("       -- Opção:" + conteudo.substring(951, 952));
			System.out.println("       -- Data Ingresso:" + conteudo.substring(952, 960));
			System.out.println("       -- Data Saída:" + conteudo.substring(960, 968));
			System.out.println("       -- Unidade Organizacional:" + conteudo.substring(968, 977));
			System.out.println("Atividade da Função:" + conteudo.substring(977, 981));
			System.out.println("Lotação -- Unidade Organizacional:" + conteudo.substring(981, 990));
			System.out.println("        -- Data:" + conteudo.substring(990, 998));
			System.out.println("Localização -- Orgão:" + conteudo.substring(998, 1003));
			System.out.println("            -- Unidade Organizacional:" + conteudo.substring(1003, 1012));
			System.out.println("Ocorrência Ingresso Órgão -- Grupo:" + conteudo.substring(1012, 1014));
			System.out.println("                          -- Ocorrência:" + conteudo.substring(1014, 1017));
			System.out.println("                          -- Data:" + conteudo.substring(1017, 1025));
			System.out.println("                          -- Diploma Legal -- Código:" + conteudo.substring(1025, 1027));
			System.out.println("                                           -- Número:" + conteudo.substring(1027, 1036));
			System.out.println("                                           -- Data Publicação:" + conteudo.substring(1036, 1044));
			System.out.println("Ocorrência Ingresso Serv. Público -- Grupo:" + conteudo.substring(1044, 1046));
			System.out.println("                          -- Ocorrência:" + conteudo.substring(1046, 1049));
			System.out.println("                          -- Data:" + conteudo.substring(1049, 1057));
			System.out.println("                          -- Diploma Legal -- Código:" + conteudo.substring(1057, 1059));
			System.out.println("                                           -- Número:" + conteudo.substring(1059, 1068));
			System.out.println("                                           -- Data Publicação:" + conteudo.substring(1068, 1076));
			System.out.println("Ocorrência de Exclusão -- Grupo:" + conteudo.substring(1076, 1078));
			System.out.println("                       -- Ocorrência:" + conteudo.substring(1078, 1081));
			System.out.println("                       -- Data:" + conteudo.substring(1081, 1089));
			System.out.println("                       -- Diploma Legal -- Código:" + conteudo.substring(1089, 1091));
			System.out.println("                                        -- Número:" + conteudo.substring(1091, 1100));
			System.out.println("                                        -- Data Publicação:" + conteudo.substring(1100, 1108));
			System.out.println("Ocorrência Afastamento -- Grupo:" + conteudo.substring(1108, 1110));
			System.out.println("                       -- Ocorrência:" + conteudo.substring(1110, 1113));
			System.out.println("                       -- Data Início:" + conteudo.substring(1113, 1121));
			System.out.println("                       -- Data Término:" + conteudo.substring(1121, 1129));
			System.out.println("                       -- Diploma Legal -- Código:" + conteudo.substring(1121, 1123));
			System.out.println("                                        -- Número:" + conteudo.substring(1123, 1132));
			System.out.println("                                        -- Data Publicação:" + conteudo.substring(1132, 1140));
			System.out.println("Ocorrência de Inatividade -- Grupo:" + conteudo.substring(1140, 1142));
			System.out.println("                          -- Ocorrência:" + conteudo.substring(1142, 1145));
			System.out.println("                          -- Data:" + conteudo.substring(1145, 1153));
			System.out.println("                          -- Diploma Legal -- Código:" + conteudo.substring(1153, 1155));
			System.out.println("                                           -- Número:" + conteudo.substring(1155, 1164));
			System.out.println("                                           -- Data Publicação:" + conteudo.substring(1164 , 1172));
			System.out.println("Ocorrência de Aposentadoria -- Nº do Processo:" + conteudo.substring(1172, 1187));
			System.out.println("                            -- Ano Previsto:" + conteudo.substring(1187, 1191));
			System.out.println("                            -- Opção Aposent. Legal:" + conteudo.substring(1191, 1192));
			
			//String teste;
			//teste =  conteudo.substring(843, 855);
			//int tamanho = teste.length();
			//System.out.println("TAMANHO: "+tamanho);
			fi.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Não achou o arquivo arquivo");
		} catch (Exception e2) {
			System.out.println("Erro no tratamento do arquivo");
		}
	}
}
