import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FitaEspelho {
	public static void main(String[] args) {
		try {
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
					break;
				}
				
				linha = br.readLine().substring(0, 764);
				teste = Integer.parseInt(linha.substring(17, 18));
				if (teste.equals(2)) {
					System.out.println("**********DADOS FUNCIONAIS**********");
					linha = br.readLine().substring(0, 764);
					System.out.println(linha);
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
	}
}