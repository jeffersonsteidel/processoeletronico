package br.com.progepe.extract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InjetorDadosPessoais {

	private List<DadosPessoais> dadosPessoaisList = new ArrayList<DadosPessoais>();

	public List<DadosPessoais> getDadosPessoaisList() {
		return dadosPessoaisList;
	}

	public void setDadosPessoaisList(List<DadosPessoais> dadosPessoaisList) {
		this.dadosPessoaisList = dadosPessoaisList;
	}

	public void carregarDadosPessoais() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));
			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {
					DadosPessoais dadosPessoais = new DadosPessoais();
					dadosPessoais.setMatriculaSiape((Integer.parseInt(linha.substring(9, 16))));
					dadosPessoais.setNomeServidor(linha.substring(20, 80));
					dadosPessoaisList.add(dadosPessoais);
				}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		InjetorDadosPessoais injetorDadosPessoais = new InjetorDadosPessoais();
		injetorDadosPessoais.carregarDadosPessoais();

		for (DadosPessoais item : injetorDadosPessoais.getDadosPessoaisList()) {
			System.out.println(item.getMatriculaSiape() + " - "
					+ item.getNomeServidor());
		}

	}
}
