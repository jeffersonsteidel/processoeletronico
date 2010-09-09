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
			String unidadePagadora = conteudo.substring(0, 9);
			String siape = conteudo.substring(9, 16);
			String dvMatricula = conteudo.substring(16, 17);
			String tipoDeRegistro = conteudo.substring(17, 18);
			String siglaUfUpag = conteudo.substring(18, 20);
			String nome = conteudo.substring(20, 80);
			String cpf = conteudo.substring(80, 91);
			String pis = conteudo.substring(91,102);
			String nomeMae = conteudo.substring(102, 152);
			String sexo = conteudo.substring(152, 153);
			String dataNascimento = conteudo.substring(153, 161);
			String estadoCivil = conteudo.substring(161, 162);
			String nivelEscolaridade = conteudo.substring(162,164);
			String codigoTitulacao = conteudo.substring(164, 166);
			String filler = conteudo.substring(166, 171);
			String  nacionalidade = conteudo.substring(171, 172);
			String naturalidade = conteudo.substring(172, 174);
			String pais = conteudo.substring(174, 177);
			String anoChegada = conteudo.substring(177, 181);
			String qtdDependentesIR = conteudo.substring(181, 183);
			String qtdDependentesSF = conteudo.substring(183, 185);
			String dataPrimeiroEmprego = conteudo.substring(185, 193);
			String identificacaoOrigem = conteudo.substring(193, 201);
			String enderecoLogradouro = conteudo.substring(201, 241);
			String enderecoNumero = conteudo.substring(241, 247);
			String enderecoComplemento = conteudo.substring(247, 268);
			String enderecoBairro = conteudo.substring(268, 293);
			String enderecoMunicipio = conteudo.substring(293, 323);
			String enderecoCep = conteudo.substring(323, 331);
			String enderecoUf = conteudo.substring(331, 333);
			String rg = conteudo.substring(333,347);
			String siglaOrgaoExpedidorRg = conteudo.substring(347, 352);
			String dataExpedicaoRg = conteudo.substring(352, 360);
			String siglaUfRg = conteudo.substring(360, 362);
			String tituloEleitor = conteudo.substring(362, 375);
			String filler2 = conteudo.substring(375, 764);
			System.out.println("Unidade Pagadora:" + unidadePagadora);
			System.out.println("Siape:" + siape);
			System.out.println("DV Matricula:" +dvMatricula);
			System.out.println("Tipo de Registro:" + tipoDeRegistro);
			System.out.println("Sigla UF UPAG:" + siglaUfUpag);
			System.out.println("Nome:" + nome);
			System.out.println("CPF:" + cpf);
			System.out.println("PIS/PASEP:" + pis);
			System.out.println("Nome da Mãe:" + nomeMae);
			System.out.println("Sexo:" + sexo);
			System.out.println("Data de Nascimento:" + dataNascimento);
			System.out.println("Estado Civil:" + estadoCivil);
			System.out.println("Nivel de Escolaridade:" + nivelEscolaridade);
			System.out.println("Código da Titulação/Formação:" + codigoTitulacao);
			System.out.println("Filler:" + filler);
			System.out.println("Nacionalidade:" + nacionalidade);
			System.out.println("Naturalidade:" + naturalidade);
			System.out.println("Pais:" + pais);
			System.out.println("Ano de Chegada:" + anoChegada);
			System.out.println("Quantidade de Dependentes IR:" + qtdDependentesIR);
			System.out.println("Quantidade de Dependentes SF:" + qtdDependentesSF);
			System.out.println("Data do Primeiro Emprego:" + dataPrimeiroEmprego);
			System.out.println("Identificação Origem:" + identificacaoOrigem);
			System.out.println("Endereço -- Logradouro:" + enderecoLogradouro);
			System.out.println("         -- Numero:" + enderecoNumero);
			System.out.println("         -- Complemento:" + enderecoComplemento);
			System.out.println("Bairro:" + enderecoBairro);
			System.out.println("Cidade:" + enderecoMunicipio);
			System.out.println("CEP:" + enderecoCep);
			System.out.println("UF:" + enderecoUf);
			System.out.println("RG:" + rg);
			System.out.println("Sigla do Orgão Expedidor do RG:" + siglaOrgaoExpedidorRg);
			System.out.println("Data de Expedição:" + dataExpedicaoRg);
			System.out.println("UF do RG:" + siglaUfRg);
			System.out.println("Titulo de Eleitor:" + tituloEleitor);
			System.out.println("Filler:" + filler2);
			fi.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Não achou o arquivo arquivo");
		} catch (Exception e2) {
			System.out.println("Erro no tratamento do arquivo");
		}
	}
}
