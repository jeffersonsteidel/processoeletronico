import java.util.Date;
import java.util.List;

import br.com.progepe.extract.DadosFuncionais;
import br.com.progepe.extract.DadosPessoais;
import br.com.progepe.validator.Validator;

public class Relatorio {

	public static void main(String[] args) throws Exception {
		List<DadosPessoais> dadosPessoais;
		List<DadosFuncionais> dadosFuncionais;
		Extrator extrator = new Extrator();
		extrator.carregarDados();
		List<DadosFinanceiros> dadosFinanceiros;
		Date data;
		// Date dataLimite = new Date("22/09/2008");
		dadosPessoais = extrator.getDadosPessoaisList();
		dadosFuncionais = extrator.getDadosFuncionaisList();
		dadosFinanceiros = extrator.getDadosFinanceiros();

		try {

			for (int count = 0; count < dadosPessoais.size(); count++) {
				int count2 = 0;
				dadosFinanceiros = extrator.getDadosFinanceiros();
				DadosPessoais servidorPessoal = dadosPessoais.get(count);
				DadosFuncionais servidorFuncional = dadosFuncionais.get(count);
				DadosFinanceiros servidorFinanceiro = null;
				try {
					while (!dadosFinanceiros.isEmpty()) {
						if ((dadosFinanceiros.get(count2).getSiape()
								.equals(servidorPessoal.getMatriculaSiape()
										.toString()))
								/*&& (dadosFinanceiros.get(count2).getCodigo()
										.equals("00001"))*/) {
							servidorFinanceiro = dadosFinanceiros.get(count2);
						} else if (servidorFinanceiro.getValor().equals(null)) {
							servidorFinanceiro.setCodigo("00001");
							servidorFinanceiro.setValor("00000");
						}
						dadosFinanceiros.remove(count2);
						count2++;
					}
				} catch (Exception exception) {
				}
				// if (servidorFuncional.getCodigoCargo().equals(1)
				// && servidorFuncional.getCodigoGrupoCargo().equals(702)
				// && servidorFuncional
				// .getCodigoReferenciaNivelPadraoCargo().equals(
				// "101")) {
				System.out.print(servidorPessoal.getMatriculaSiape());
				System.out.print("," + servidorPessoal.getNomeServidor());
				System.out.print("," + Validator.formatarData(servidorFuncional
						.getDataIngressoServPublico()));
				System.out.print(",PROF. ENS. BAS. TEC. TECNOL.");
				System.out.print("," + servidorFuncional.getClasseCargo());
				System.out.print(","
						+ servidorFuncional
								.getCodigoReferenciaNivelPadraoCargo());
				System.out
						.print("," + servidorFuncional.getCodigoNivelFuncao());
				try {
					System.out.print(",valor," + servidorFinanceiro.getValor());

				} catch (Exception exception) {
				}
				System.out.println();
				// }

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}