import java.util.List;

import br.com.progepe.extract.DadosFuncionais;
import br.com.progepe.extract.DadosPessoais;
import br.com.progepe.extract.Extrator;
import br.com.progepe.validator.Validator;

public class RelatorioAltenticacao {

	public static void main(String[] args) throws Exception {
		List<DadosPessoais> dadosPessoais;
		List<DadosFuncionais> dadosFuncionais;
		Extrator extrator = new Extrator();
		extrator.carregarDados();
		String data;
		dadosPessoais = extrator.getDadosPessoaisList();
		dadosFuncionais = extrator.getDadosFuncionaisList();
		try {
			for (int count = 0; count < dadosPessoais.size(); count++) {

				DadosPessoais servidorPessoal = dadosPessoais.get(count);
				System.out.print(servidorPessoal.getMatriculaSiape());
				System.out.print("," + servidorPessoal.getNomeServidor());
				System.out.println("," + servidorPessoal
						.getDataNascimento().toString());

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
