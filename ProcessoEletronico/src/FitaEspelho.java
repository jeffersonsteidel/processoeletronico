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
			fi.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Não achou o arquivo arquivo");
		} catch (Exception e2) {
			System.out.println("Erro no tratamento do arquivo");
		}
	}
}
