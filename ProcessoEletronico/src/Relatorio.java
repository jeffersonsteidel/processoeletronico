import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import br.com.progepe.extract.DadosFuncionais;
import br.com.progepe.extract.DadosPessoais;
import br.com.progepe.extract.Extrator;
import br.com.progepe.validator.Validator;

public class Relatorio {

	public static void main(String[] args) throws Exception {
		List<DadosPessoais> dadosPessoais;
		List<DadosFuncionais> dadosFuncionais;
		Extrator extrator = new Extrator();
		extrator.carregarDados();
		String data;
//		Date dataLimite = new Date("22/09/2008");
		dadosPessoais = extrator.getDadosPessoaisList();
		dadosFuncionais = extrator.getDadosFuncionaisList();
		try {
			for (int count = 0; count < dadosPessoais.size(); count++) {

				DadosPessoais servidorPessoal = dadosPessoais.get(count);
				DadosFuncionais servidorFuncional = dadosFuncionais.get(count);
				if (servidorFuncional.getCodigoCargo().equals(1)
						&& servidorFuncional.getCodigoGrupoCargo().equals(702)
						&& servidorFuncional
								.getCodigoReferenciaNivelPadraoCargo().equals(
										"101")) {

//					Date dataI = new Date(
//							Validator.formatarData(servidorFuncional
//									.getDataIngressoServPublico()));
//					if (dataI.after(dataLimite)) {
						System.out.print(servidorPessoal.getMatriculaSiape());
						System.out.print(","
								+ servidorPessoal.getNomeServidor());
						data = Validator.formatarData(servidorFuncional
								.getDataIngressoServPublico().toString());
						System.out.print("," + data);
						System.out.print(",PROF. ENS. BAS. TEC. TECNOL.");
						System.out.print(","
								+ servidorFuncional.getClasseCargo());
						System.out.print(","
								+ servidorFuncional
										.getCodigoReferenciaNivelPadraoCargo());
						System.out.println(","
								+ servidorFuncional.getCodigoNivelFuncao());
					}
				}
			//}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}