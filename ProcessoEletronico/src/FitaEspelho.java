import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

import br.com.progepe.validator.Validator;

public class FitaEspelho {

	static String arquivoEntrada = "FITA_MAR";
	static String arquivoSaida = "FITA_MAR";
	
	public static void main(String[] args) throws ParseException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITAS_ESPELHO_2011/" + arquivoEntrada + ".txt"));

			String html = "";
			html = html + "<html>";
			html = html + "<body>";
			html = html + "<table name='table' border='1'>";
			html = html + "<tr>";
			html = html + "<th>SIAPE</th>";
			html = html + "<th>NOME</th>";
			html = html + "<th>CPF</th>";
			html = html + "<th>RG</th>";
			html = html + "<th>ORGÃO EXPEDIÇÃO RG</th>";
			html = html + "<th>DATA EXPEDIÇÃO RG</th>";
			html = html + "<th>UF DO RG</th>";
			html = html + "<th>TITULO DE ELEITOR</th>";
			html = html + "<th>PIS/PASEP</th>";
			html = html + "<th>NOME DA MÃE</th>";
			html = html + "<th>SEXO</th>";
			html = html + "<th>DATA DE NASCIMENTO</th>";
			html = html + "<th>ESTADO CIVIL</th>";
			html = html + "<th>NIVEL ESCOLARIDADE</th>";
			html = html + "<th>TITULAÇÃO</th>";
			html = html + "<th>ENDEREÇO</th>";
			html = html + "<th>NUMERO</th>";
			html = html + "<th>COMPLEMENTO</th>";
			html = html + "<th>BAIRRO</th>";
			html = html + "<th>CIDADE</th>";
			html = html + "<th>CEP</th>";
			html = html + "<th>UF</th>";
			html = html + "<th>REGIME JURIDICO</th>";
			html = html + "<th>JORNADA DE TRABALHO</th>";
			html = html + "<th>BANCO</th>";
			html = html + "<th>AGENCIA</th>";
			html = html + "<th>CONTA CORRENTE</th>";
			html = html + "<th>GRUPO/CARGO</th>";
			html = html + "<th>CLASSE</th>";
			html = html + "<th>PADRÃO</th>";
			html = html + "<th>LOTAÇÃO</th>";
			html = html + "<th>DATA ADMISSÃO SERV. PUB.</th>";
			html = html + "<th>DATA DE ENTRADA NA OCUPAÇÃO.</th>";
			html = html + "<th>DATA ADMISSÃO ORGÃO.</th>";
			html = html + "<th>DATA SAIDA CARGO.</th>";
			html = html + "<th>SITUAÇÃO</th>";
			html = html + "<th>GRUPO INGR. ORGÃO</th>";
			html = html + "<th>OCORRENC. INGR. ORGÃO</th>";
			html = html + "<th>AFASTAMENTO GRUPO</th>";
			html = html + "<th>AFASTAMENTO OCORRENCIA</th>";

			html = html + "<th>CODIGO NIVEL FUNÇÃO</th>";
			html = html + "<th>FUNÇÃO DATA SAIDA</th>";
			html = html + "</tr>";

			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {
					html = html + "<tr>";
					html = html + "<td>" + linha.substring(9, 16) + "</td>";
					html = html + "<td>" + linha.substring(20, 80) + "</td>";
					html = html + "<td>"
							+ Validator.formatarCpf(linha.substring(80, 91))
							+ "</td>";
					html = html + "<td>" + linha.substring(333, 347) + "</td>";
					html = html + "<td>" + linha.substring(347, 352) + "</td>";
					html = html + "<td>"
							+ Validator.formatarData(linha.substring(352, 360))
							+ "</td>";

					html = html + "<td>" + linha.substring(360, 362) + "</td>";
					html = html + "<td>" + linha.substring(362, 375) + "</td>";
					html = html + "<td>"
							+ Validator.formatarPis(linha.substring(91, 102))
							+ "</td>";
					html = html + "<td>" + linha.substring(102, 152) + "</td>";
					html = html + "<td>" + linha.substring(152, 153) + "</td>";
					html = html + "<td>"
							+ Validator.formatarData(linha.substring(153, 161))
							+ "</td>";

					if (tipoRegistro.equals(1)) {
						html = html + "<td>";
						if (linha.substring(161, 162).equals("1")) {
							html = html + "SOLTEIRO";
						} else if (linha.substring(161, 162).equals("2")) {
							html = html + "CASADO";
						} else if (linha.substring(161, 162).equals("3")) {
							html = html + "SEPARADO";
						} else if (linha.substring(161, 162).equals("4")) {
							html = html + "DIVORCIADO";
						} else if (linha.substring(161, 162).equals("5")) {
							html = html + "VIUVO";
						}
						html = html + "</td>";
					}

					if (tipoRegistro.equals(1)) {
						html = html + "<td>" + linha.substring(162, 164)
								+ "</td>";

						html = html + "<td>" + linha.substring(164, 166)
								+ "</td>";

						html = html + "<td>" + linha.substring(201, 241)
								+ "</td>";
						html = html + "<td>" + linha.substring(241, 247)
								+ "</td>";
						html = html + "<td>" + linha.substring(247, 268)
								+ "</td>";
						html = html + "<td>" + linha.substring(268, 293)
								+ "</td>";
						html = html + "<td>" + linha.substring(293, 323)
								+ "</td>";
						html = html + "<td>" + linha.substring(323, 331)
								+ "</td>";
						html = html + "<td>" + linha.substring(331, 333)
								+ "</td>";
					}

				}
				if (tipoRegistro.equals(2)) {
					html = html + "<td>" + linha.substring(20, 23) + "</td>";
					html = html + "<td>" + linha.substring(90, 92) + "</td>";
					html = html + "<td>";
					if (("001").equals(linha.substring(38, 41))) {
						html = html + "BB";
					} else if (("104").equals(linha.substring(38, 41))) {
						html = html + "CEF";
					} else if (("341").equals(linha.substring(38, 41))) {
						html = html + "ITAU";
					} else {
						html = html + linha.substring(38, 41);
					}
					html = html + "</td>";

					html = html + "<td>" + linha.substring(41, 47) + "</td>";
					html = html + "<td>" + linha.substring(47, 60) + "</td>";
					html = html + "<td>";
					if (linha.substring(113, 116).equals("701")) {
						html = html + "TÉCNICO/";
						if (linha.substring(116, 119).equals("001")) {
							html = html + "ADMINISTRADOR";
						} else if (linha.substring(116, 119).equals("004")) {
							html = html + "ARQUITETO E URBANISTA";
						} else if (linha.substring(116, 119).equals("006")) {
							html = html + "ASS. SOCIAL";
						} else if (linha.substring(116, 119).equals("009")) {
							html = html + "AUDITOR";
						} else if (linha.substring(116, 119).equals("010")) {
							html = html + "BIBLIOTECARIO";
						} else if (linha.substring(116, 119).equals("015")) {
							html = html + "CONTADOR";
						} else if (linha.substring(116, 119).equals("029")) {
							html = html + "ENFERMEIRO";
						} else if (linha.substring(116, 119).equals("031")) {
							html = html + "ENGENHEIRO";
						} else if (linha.substring(116, 119).equals("032")) {
							html = html + "ENG. DE SEG. DO TRABALHO ";
						} else if (linha.substring(116, 119).equals("045")) {
							html = html + "JORNALISTA";
						} else if (linha.substring(116, 119).equals("047")) {
							html = html + "MÉDICO";
						} else if (linha.substring(116, 119).equals("058")) {
							html = html + "PEDAGOGO";
						} else if (linha.substring(116, 119).equals("062")) {
							html = html + "ANAL. DE TEC. DA INFORMAÇÃO";
						} else if (linha.substring(116, 119).equals("066")) {
							html = html + "PROGRAMADOR VISUAL";
						} else if (linha.substring(116, 119).equals("076")) {
							html = html + "SECRETARIADO EXECUTIVO";
						} else if (linha.substring(116, 119).equals("079")) {
							html = html + "TEC. EM ASSUN. EDUCACIONAIS";
						} else if (linha.substring(116, 119).equals("200")) {
							html = html + "ASS. EM ADMINISTRAÇÃO";
						} else if (linha.substring(116, 119).equals("224")) {
							html = html + "TEC. EM CONTABILIDADE";
						} else if (linha.substring(116, 119).equals("226")) {
							html = html + "TEC. EM TECNOL. DA INFORMAÇÃO";
						} else if (linha.substring(116, 119).equals("233")) {
							html = html + "TEC. EM ENFERMAGEM";
						} else if (linha.substring(116, 119).equals("244")) {
							html = html + "TEC. EM LABORATÓRIO";
						} else if (linha.substring(116, 119).equals("257")) {
							html = html + "TEC. EM RADIOLOGIA";
						} else if (linha.substring(116, 119).equals("403")) {
							html = html + "ASS. DE ALUNO";
						} else if (linha.substring(116, 119).equals("409")) {
							html = html + "AUX. DE BIBLIOTECA";
						} else if (linha.substring(116, 119).equals("421")) {
							html = html + "CONTINUO";
						} else if (linha.substring(116, 119).equals("422")) {
							html = html + "CONZINHEIRO";
						} else if (linha.substring(116, 119).equals("436")) {
							html = html + "IMPRESSOR";
						} else if (linha.substring(116, 119).equals("459")) {
							html = html + "RECEPCIONISTA";
						} else if (linha.substring(116, 119).equals("464")) {
							html = html + "TELEFONISTA";
						} else if (linha.substring(116, 119).equals("611")) {
							html = html + "AUX. DE AGROPECUÁRIA";
						} else if (linha.substring(116, 119).equals("623")) {
							html = html + "AUX. DE NUTRIÇÃO";
						} else if (linha.substring(116, 119).equals("828")) {
							html = html + "OPER. DE MAQ. DE LAVANDERIA";
						}
					} else if (linha.substring(113, 116).equals("702")) {
						html = html + "DOCENTE/";
						if (linha.substring(116, 119).equals("001")) {
							html = html + "PROF. ENS. BAS. TEC. TECNOL.";
						} else if (linha.substring(116, 119).equals("003")) {
							html = html + "PROF. ENS. BAS. TEC. TECNOL. - SUB";
						}
					} else if (linha.substring(113, 116).equals("060")) {
						html = html + "DOCENTE/";
						if (linha.substring(116, 119).equals("001")) {
							html = html + "PROF. DO 3º GRAU";
						} else if (linha.substring(116, 119).equals("012")) {
							html = html + "PROF. DO 1º E 2º GRAUS - SUB";
						}
					} else {
						html = html + linha.substring(116, 119);
					}
					html = html + "</td>";

					html = html + "<td>" + linha.substring(119, 120) + "</td>";

					html = html + "<td>" + linha.substring(120, 123) + "</td>";
					html = html + "<td>";
					if (linha.substring(215, 224).equals("000000003")) {
						html = html + "REITORIA";
					} else if (linha.substring(215, 224).equals("000000012")) {
						html = html + "CAMPUS CURITIBA";
					} else if (linha.substring(215, 224).equals("000000008")) {
						html = html + "PROGEPE";
					} else if (linha.substring(215, 224).equals("000000006")) {
						html = html + "PROPLAN";
					} else if (linha.substring(215, 224).equals("000000007")) {
						html = html + "PRAI";
					} else if (linha.substring(215, 224).equals("000000004")) {
						html = html + "GABINETE";
					} else if (linha.substring(215, 224).equals("000000005")) {
						html = html + "PREPPG";
					} else if (linha.substring(215, 224).equals("000000023")) {
						html = html + "DIR. ADM E FINANCEIRO/ C. FOZ";
					} else if (linha.substring(215, 224).equals("000000036")) {
						html = html + "CAMPUS UMUARAMA";
					} else if (linha.substring(215, 224).equals("000000121")) {
						html = html + "N. A. AS. CHATEAUBRIAND";
					} else if (linha.substring(215, 224).equals("000000017")) {
						html = html + "DIR. GERAL/ C. PARANAGUA";
					} else if (linha.substring(215, 224).equals("000000009")) {
						html = html + "PRI";
					} else if (linha.substring(215, 224).equals("000000016")) {
						html = html + "CAMPUS PARANAGUÁ";
					} else if (linha.substring(215, 224).equals("000000024")) {
						html = html + "CAMPUS JACAREZINHO";
					} else if (linha.substring(215, 224).equals("000000028")) {
						html = html + "CAMPUS PARANAVAI";
					} else if (linha.substring(215, 224).equals("000000117")) {
						html = html + "CAMPUS LODRINA";
					} else if (linha.substring(215, 224).equals("000000020")) {
						html = html + "CAMPUS FOZ DO IGUAÇU";
					} else if (linha.substring(215, 224).equals("000000112")) {
						html = html + "CAMPUS PALMAS";
					} else if (linha.substring(215, 224).equals("000000018")) {
						html = html + "DIR. ENSINO/ C. PGUA";
					} else if (linha.substring(215, 224).equals("000000032")) {
						html = html + "CAMPUS TELEMACO BORBA";
					} else if (linha.substring(215, 224).equals("000000041")) {
						html = html + "N. A. DE CAMPO LARGO";
					} else if (linha.substring(215, 224).equals("000000021")) {
						html = html + "DIR. GERAL/ C. FOZ";
					} else if (linha.substring(215, 224).equals("000000116")) {
						html = html + "N. A. DE IRATI";
					} else if (linha.substring(215, 224).equals("000000010")) {
						html = html + "AUDITORIA INTERNA";
					} else if (linha.substring(215, 224).equals("000000019")) {
						html = html + "DIRETORIA ADM E FINANC/CPGUA";
					} else if (linha.substring(215, 224).equals("000000034")) {
						html = html + "DIRETORIA ENSINO/CTBOR";
					} else if (linha.substring(215, 224).equals("000000115")) {
						html = html + "DIR. ADM. E FIN./C.PALMAS";
					} else {
						html = html + linha.substring(215, 224);
					}
					html = html + "</td>";

					html = html + "<td>" + linha.substring(283, 285) + "/"
							+ linha.substring(285, 287) + "/"
							+ linha.substring(287, 291) + "</td>";

					html = html + "<td>" + linha.substring(123, 125) + "/"
							+ linha.substring(125, 127) + "/"
							+ linha.substring(127, 131) + "</td>";

					html = html + "<td>" + linha.substring(251, 253) + "/"
							+ linha.substring(253, 255) + "/"
							+ linha.substring(255, 259) + "</td>";

					html = html + "<td>" + linha.substring(131, 133) + "/"
							+ linha.substring(133, 135) + "/"
							+ linha.substring(135, 139) + "</td>";

					Integer situacao = Integer
							.parseInt(linha.substring(23, 25));
					if (situacao.equals(1)) {
						html = html + "<td> ATIVO PERMANENTE </td>";
					} else if (situacao.equals(2)) {
						html = html + "<td> APOSENTADO </td>";
					} else if (situacao.equals(3)) {
						html = html + "<td> REQUISITADO </td>";
					} else if (situacao.equals(4)) {
						html = html + "<td> NOMEADO CARGO COMIS. </td>";
					} else if (situacao.equals(8)) {
						html = html + "<td> CEDIDO </td>";
					} else if (situacao.equals(9)) {
						html = html + "<td> REDISTRIBUIDO </td>";
					} else if (situacao.equals(12)) {
						html = html + "<td> CONTRATO TEMPORARIO </td>";
					} else if (situacao.equals(13)) {
						html = html + "<td> EM DISPONIBILIDADE </td>";
					} else if (situacao.equals(14)) {
						html = html + "<td> REQ. DE OUTROS ORGÃOS </td>";
					} else if (situacao.equals(15)) {
						html = html + "<td> INSTITUIDOR PENSÃO </td>";
					} else if (situacao.equals(41)) {
						html = html + "<td> COLABORADOR PCCTAE </td>";
					} else if (situacao.equals(66)) {
						html = html + "<td> ESTAGIARIO </td>";
					} else if (situacao.equals(84)) {
						html = html + "<td> PENSIONISTA </td>";
					} else if (situacao.equals(93)) {
						html = html + "<td> BENEFICIARIO PENSÃO </td>";
					} else if (situacao.equals(18)) {
						html = html + "<td> EXERC DESCENT CARREI </td>";
					} else if (situacao.equals(19)) {
						html = html + "<td> EXERCICIO PROVISORIO </td>";
					} else {
						html = html + "<td>" + situacao + "</td>";
					}

					html = html + "<td>" + linha.substring(246, 248) + " </td>";
					html = html + "<td>" + linha.substring(248, 251) + " </td>";

					html = html + "<td>" + linha.substring(342, 344) + " </td>";
					html = html + "<td>" + linha.substring(344, 347) + " </td>";

					html = html + "<td>" + linha.substring(142, 147) + " </td>";

					html = html + "<td>" + linha.substring(158, 160) + "/"
							+ linha.substring(160, 162) + "/"
							+ linha.substring(162, 166) + "</td>";

					html = html + "</tr>";
				}
			}
			html = html + "</table>";
			html = html + "</body>";
			html = html + "</html>";

			FileOutputStream file = new FileOutputStream("C:\\"+ arquivoSaida +".html");
			PrintStream print = new PrintStream(file);
			print.println(html);
			System.out.println("Arquivo gerado com sucesso!!!");
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
