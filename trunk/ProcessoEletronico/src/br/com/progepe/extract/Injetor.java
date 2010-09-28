package br.com.progepe.extract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Injetor {

	private List<DadosPessoais> dadosPessoaisList = new ArrayList<DadosPessoais>();

	public List<DadosPessoais> getDadosPessoaisList() {
		return dadosPessoaisList;
	}

	public void setDadosPessoaisList(List<DadosPessoais> dadosPessoaisList) {
		this.dadosPessoaisList = dadosPessoaisList;
	}

	public void carregarDadosPessoais() {
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));
			while (br.ready())
			{
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {

						DadosPessoais dadosPessoais = new DadosPessoais();
						dadosPessoais.setMatriculaSiape(linha.substring(9, 16));
						dadosPessoais.setDvMatricula(linha.substring(16, 17));
						dadosPessoais.setTipoRegistro(linha.substring(17, 18));
						dadosPessoais.setNomeServidor(linha.substring(20, 80));
						dadosPessoais.setCpf(linha.substring(80, 91));
						dadosPessoais.setPisPasef(linha.substring(91,102));
						dadosPessoais.setNomeMae(linha.substring(102, 152));
						dadosPessoais.setSexo(linha.substring(152, 153));
						dadosPessoais.setDataNascimento(linha.substring(153, 161));
						dadosPessoais.setEstadoCivil(linha.substring(161, 162));
						dadosPessoais.setNivelEscolaridade(linha.substring(162, 164));
						dadosPessoais.setCodigoTitulacaoFormacao(linha.substring(164, 166));
						dadosPessoais.setNacionalidade(linha.substring(171, 172));
						dadosPessoais.setNaturalidade(linha.substring(172, 174));
						dadosPessoais.setPais(linha.substring(174, 177));
						dadosPessoais.setAnoChegada(linha.substring(177, 181));
						dadosPessoais.setDataPrimeiroEmprego(linha.substring(185, 193));
						dadosPessoais.setIdentificacaoOrigem(linha.substring(193, 201));
						dadosPessoais.setLogradouro(linha.substring(201, 241));
						dadosPessoais.setNumeroEndereco(linha.substring(241, 247));
						dadosPessoais.setComplementoEndereco(linha.substring(247, 268));
						dadosPessoais.setBairro(linha.substring(268, 293));
						dadosPessoais.setMunicipio(linha.substring(293, 323));
						dadosPessoais.setCep(linha.substring(323, 331));
						dadosPessoais.setUf(linha.substring(331, 333));
						dadosPessoais.setSiglaOrgaoExpedidor(linha.substring(347, 352));
						dadosPessoais.setDataExpedicaoIdentidade(linha.substring(352, 360));
						dadosPessoais.setSiglaUfIdentidade(linha.substring(360, 362));
						dadosPessoais.setNumeroTituloEleitor(linha.substring(362, 375));	
				
						dadosPessoaisList.add(dadosPessoais);
					}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		Injetor injetorDadosPessoais = new Injetor();
		injetorDadosPessoais.carregarDadosPessoais();

		for (DadosPessoais item : injetorDadosPessoais.getDadosPessoaisList()) 
		{
			System.out.println(item.getMatriculaSiape() + " - "
					+ item.getNomeServidor());
		}

	}
}
