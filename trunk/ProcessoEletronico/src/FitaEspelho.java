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
			System.out.println("Nome da M�e:" + conteudo.substring(102, 152));
			System.out.println("Sexo:" + conteudo.substring(152, 153));
			System.out.println("Data de Nascimento:" + conteudo.substring(153, 161));
			System.out.println("Estado Civil:" + conteudo.substring(161, 162));
			System.out.println("Nivel de Escolaridade:" + conteudo.substring(162,164));
			System.out.println("C�digo da Titula��o/Forma��o:" + conteudo.substring(164, 166));
			System.out.println("Filler:" + conteudo.substring(166, 171));
			System.out.println("Nacionalidade:" + conteudo.substring(171, 172));
			System.out.println("Naturalidade:" + conteudo.substring(172, 174));
			System.out.println("Pais:" + conteudo.substring(174, 177));
			System.out.println("Ano de Chegada:" + conteudo.substring(177, 181));
			System.out.println("Quantidade de Dependentes IR:" + conteudo.substring(181, 183));
			System.out.println("Quantidade de Dependentes SF:" + conteudo.substring(183, 185));
			System.out.println("Data do Primeiro Emprego:" + conteudo.substring(185, 193));
			System.out.println("Identifica��o Origem:" + conteudo.substring(193, 201));
			System.out.println("Endere�o -- Logradouro:" + conteudo.substring(201, 241));
			System.out.println("         -- Numero:" + conteudo.substring(241, 247));
			System.out.println("         -- Complemento:" + conteudo.substring(247, 268));
			System.out.println("Bairro:" + conteudo.substring(268, 293));
			System.out.println("Cidade:" + conteudo.substring(293, 323));
			System.out.println("CEP:" + conteudo.substring(323, 331));
			System.out.println("UF:" + conteudo.substring(331, 333));
			System.out.println("RG:" + conteudo.substring(333,347));
			System.out.println("Sigla do Org�o Expedidor do RG:" + conteudo.substring(347, 352));
			System.out.println("Data de Expedi��o:" + conteudo.substring(352, 360));
			System.out.println("UF do RG:" + conteudo.substring(360, 362));
			System.out.println("Titulo de Eleitor:" + conteudo.substring(362, 375));
			System.out.println("Filler:" + conteudo.substring(375, 764));
			
			System.out.println("-------------DADOS FUNCIONAIS-------------------");
			System.out.println("Unidade Pagadora:" + conteudo.substring(764,775));
			System.out.println("Matricula SIAPE:" + conteudo.substring(775,782));
			System.out.println("DV Matricula:" +conteudo.substring(782, 783));
			System.out.println("Tipo de Registro:" + conteudo.substring(783, 784));
			System.out.println("Sigla UF UPAG:" + conteudo.substring(784, 786));
			System.out.println("Sigla do Regime Juridico �nico:" + conteudo.substring(786, 789));
			System.out.println("C�digo da Situa��o do Servidor:" + conteudo.substring(789, 791));
			System.out.println("Carteira de Trabalho -- N�mero:" + conteudo.substring(791, 797));
			System.out.println("                     -- S�rie:" + conteudo.substring(797, 802));
			System.out.println("                     -- UF:" + conteudo.substring(802, 804));
			System.out.println("Banco:" + conteudo.substring(804, 807));
			System.out.println("Ag�ncia:" + conteudo.substring(807, 813));
			System.out.println("Conta Corrente:" + conteudo.substring(813, 826));
			System.out.println("FGTS -- Data de Op��o:" + conteudo.substring(826, 834));
			System.out.println("     -- Banco:" + conteudo.substring(834, 837));
			System.out.println("     -- Ag�ncia:" + conteudo.substring(837, 843));
			System.out.println("     -- Conta Corrente:" + conteudo.substring(843, 856));
			System.out.println("Jornada de Trabalho:" + conteudo.substring(856, 858));
			System.out.println("Percentual de Tempo de Servi�o:" + conteudo.substring(858, 860));
			System.out.println("Data de Cadastramento do Servidor:" + conteudo.substring(860, 868));
			System.out.println("Indica��o de Suspenss�o:" + conteudo.substring(868, 869));
			System.out.println("Pagamento Data Supress�o de Pagamento:" + conteudo.substring(869, 875));
			System.out.println("Proporcionalidade -- Numerador:" + conteudo.substring(875, 877));
			System.out.println("                  -- Denominador:" + conteudo.substring(877, 879));
			System.out.println("Cargo/Emprego -- Grupo:" + conteudo.substring(879, 882));
			System.out.println("              -- Cargo:" + conteudo.substring(882, 885));
			System.out.println("              -- Classe:" + conteudo.substring(885, 886));
			System.out.println("              -- Refer�ncia/N�vel/Padr�o:" + conteudo.substring(886, 889));
			System.out.println("              -- Data Entrada Ocupa��o:" + conteudo.substring(889, 897));
			System.out.println("              -- Data Entrada Sa�da:" + conteudo.substring(897, 905));
			System.out.println("Fun��o -- Sigla:" + conteudo.substring(905, 908));
			System.out.println("       -- C�digo de N�vel:" + conteudo.substring(908, 913));
			System.out.println("       -- Escolaridade:" + conteudo.substring(913, 915));
			System.out.println("       -- Op��o:" + conteudo.substring(915, 916));
			System.out.println("       -- Data Ingresso:" + conteudo.substring(916, 924));
			System.out.println("       -- Data Sa�da:" + conteudo.substring(924, 932));
			System.out.println("       -- Unidade Organizacional:" + conteudo.substring(932, 941));
			System.out.println("Nova Fun��o -- Sigla:" + conteudo.substring(941, 944));
			System.out.println("       -- C�digo de N�vel:" + conteudo.substring(944, 949));
			System.out.println("       -- Escolaridade:" + conteudo.substring(949, 951));
			System.out.println("       -- Op��o:" + conteudo.substring(951, 952));
			System.out.println("       -- Data Ingresso:" + conteudo.substring(952, 960));
			System.out.println("       -- Data Sa�da:" + conteudo.substring(960, 968));
			System.out.println("       -- Unidade Organizacional:" + conteudo.substring(968, 977));
			System.out.println("Atividade da Fun��o:" + conteudo.substring(977, 981));
			//String teste;
			//teste =  conteudo.substring(843, 855);
			//int tamanho = teste.length();
			//System.out.println("TAMANHO: "+tamanho);
			fi.close();
		} catch (FileNotFoundException e1) {
			System.out.println("N�o achou o arquivo arquivo");
		} catch (Exception e2) {
			System.out.println("Erro no tratamento do arquivo");
		}
	}
}
