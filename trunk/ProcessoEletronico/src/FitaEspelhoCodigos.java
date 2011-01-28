import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

public class FitaEspelhoCodigos {

	public static void main(String[] args) throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITA.txt"));

			int i = 0; 
			
			String html = "";
			html = html + "<html>";
			html = html + "<body>";
			html = html + "<table name='table' border='1'>";
			html = html + "<tr>";

			// TIPO 01
			html = html + "<th>UNIDADE PAGADORA</th>";
			html = html + "<th>MATR�CULA SIAPE</th>";
			html = html + "<th>DV MATR�CULA</th>";
			html = html + "<th>SIGLA UF UPAG</th>";
			html = html + "<th>NOME SERVIDOR</th>";
			html = html + "<th>CPF</th>";
			html = html + "<th>PIS/PASEP</th>";
			html = html + "<th>NOME DA M�E</th>";
			html = html + "<th>SEXO</th>";
			html = html + "<th>DATA NASCIMENTO</th>";
			html = html + "<th>ESTADO CIVIL</th>";
			html = html + "<th>NIVEL ESCOLARIDADE</th>";
			html = html + "<th>C�DIGO TITULA��O/FORMA��O</th>";
			html = html + "<th>FILLER</th>";
			html = html + "<th>NACIONALIDADE</th>";
			html = html + "<th>NATURALIDADE</th>";
			html = html + "<th>PAIS</th>";
			html = html + "<th>ANO CHEGADA</th>";
			html = html + "<th>QUANTIDADE DE DEPENDENTES IR</th>";
			html = html + "<th>QUANTIDADE DE DEPENDENTES SF</th>";
			html = html + "<th>DATA 1� EMPREGO</th>";
			html = html + "<th>IDENTIFICA��O ORIGEM</th>";
			html = html + "<th>ENDERE�O LOGRADOURO</th>";
			html = html + "<th>ENDERE�O N�MERO</th>";
			html = html + "<th>ENDERE�O COMPLEMENTO</th>";
			html = html + "<th>ENDERE�O BAIRRO</th>";
			html = html + "<th>ENDERE�O MUNIC�PIO</th>";
			html = html + "<th>ENDERE�O CEP</th>";
			html = html + "<th>ENDERE�O UF</th>";
			html = html + "<th>N� REGISTRO GERAL</th>";
			html = html + "<th>SIGLA �RG�O EXPEDIDOR</th>";
			html = html + "<th>DATA EXPEDI��O IDENTIDADE</th>";
			html = html + "<th>SIGLA UF DA IDENTIDADE</th>";
			html = html + "<th>N� DO TITULAR DE ELEITOR</th>";
			html = html + "<th>FILLER</th>";

			// TIPO 02
			html = html + "<th>SIGLA DO REGIME JUR�DICO</th>";
			html = html + "<th>C�DIGO DA SITUA��O DO SERVIDOR</th>";
			html = html + "<th>CARTEIRA DE TRABALHO N�MERO</th>";
			html = html + "<th>CARTEIRA DE TRABALHO S�RIE</th>";
			html = html + "<th>CARTEIRA DE TRABALHO UF</th>";
			html = html + "<th>BANCO PAGAMENTO BANCO</th>";
			html = html + "<th>BANCO PAGAMENTO AG�NCIA</th>";
			html = html + "<th>BANCO CONTA CORRENTE</th>";
			html = html + "<th>FGTS DATA DE OP��O</th>";
			html = html + "<th>FGTS BANCO</th>";
			html = html + "<th>FGTS AG�NCIA</th>";
			html = html + "<th>CONTA CORRENTE</th>";
			html = html + "<th>JORNADA DE TRABALHO</th>";
			html = html + "<th>PERCENTURAL DE TEMPO DE SERVI�O</th>";
			html = html + "<th>DATA DE CADASTRAMENTO SERVIDOR</th>";
			html = html + "<th>INDICADOR SUPRESS�O PAGAMENTO</th>";
			html = html + "<th>DATA SUPRESS�O DE PAGAMENTO</th>";
			html = html + "<th>PROPORCIONALIDADE NUMERADOR</th>";
			html = html + "<th>PROPORCIONALIDADE DENOMINADOR</th>";
			html = html + "<th>CARGO/EMPREGO GRUPO</th>";
			html = html + "<th>CARGO/EMPREGO CARGO</th>";
			html = html + "<th>CARGO/EMPREGO CLASSE</th>";
			html = html + "<th>CARGO/EMPREGO REFER�NCIA/NIVEL/PADR�O</th>";
			html = html + "<th>CARGO/EMPREGO DATA ENTRADA OCUPA��O</th>";
			html = html + "<th>CARGO/EMPREGO DATA SAIDA</th>";
			html = html + "<th>FUNC�O SIGLA</th>";
			html = html + "<th>FUNC�O C�DIGO NIVEL</th>";
			html = html + "<th>FUNC�O ESCOLARIDADE</th>";
			html = html + "<th>FUNC�O OP��O</th>";
			html = html + "<th>FUNC�O DATA INGRESSO</th>";
			html = html + "<th>FUNC�O DATA SAIDA</th>";
			html = html + "<th>FUNC�O UNIDADE ORGANIZACIONAL</th>";
			html = html + "<th>NOVA FUNC�O SIGLA </th>";
			html = html + "<th>NOVA FUNC�O C�DIGO NIVEL</th>";
			html = html + "<th>NOVA FUNC�O ESCOLARIDADE</th>";
			html = html + "<th>NOVA FUNC�O OP��O</th>";
			html = html + "<th>NOVA FUNC�O DATA INGRESSO</th>";
			html = html + "<th>NOVA FUNC�O DATA SAIDA</th>";
			html = html + "<th>NOVA FUNC�O UNIDADE ORGANIZACIONAL</th>";
			html = html + "<th>ATIVIDADE FUN��O</th>";
			html = html + "<th>LOTA��O UNIDADE ORGANIZACIONAL</th>";
			html = html + "<th>LOTA��O DATA</th>";
			html = html + "<th>LOCALIZA��O �RG�O</th>";
			html = html + "<th>LOCALIZA��O UNIDADE ORGANIZACIONAL</th>";
			html = html + "<th>OCORR�NCIA INGRESSO �RG�O GRUPO</th>";
			html = html + "<th>OCORR�NCIA INGRESSO �RG�O OCORR�NCIA</th>";
			html = html + "<th>OCORR�NCIA INGRESSO �RG�O DATA</th>";
			html = html + "<th>DIPLOMA LEGAL C�DIGO</th>";
			html = html + "<th>DIPLOMA LEGAL N�MERO</th>";
			html = html + "<th>DIPLOMA LEGAL DATA PUBLICA��O</th>";
			html = html + "<th>OCORR�NCIA INGRESSO SERV. PUBLICO GRUPO</th>";
			html = html	+ "<th>OCORR�NCIA INGRESSO SERV. PUBLICO OCORR�NCIA</th>";
			html = html + "<th>OORRC�NCIA INGRESSO SERV. PUBLICO DATA</th>";
			html = html + "<th>DIPLOMA LEGAL C�DIGO</th>";
			html = html + "<th>DIPLOMA LEGAL N�MERO</th>";
			html = html + "<th>DIPLOMA LEGAL DATA PUBLICA��O</th>";
			html = html + "<th>OCORR�NCIA DE EXCLUS�O GRUPO</th>";
			html = html + "<th>OCORR�NCIA DE EXCLUS�O OCORR�NCIA</th>";
			html = html + "<th>OCORR�NCIA DE EXCLUS�O DATA</th>";
			html = html + "<th>DIPLOMA LEGAL C�DIGO</th>";
			html = html + "<th>DIPLOMA LEGAL N�MERO</th>";
			html = html + "<th>DIPLOMA LEGAL DATA PUBLICA��O</th>";
			html = html + "<th>OCORR�NCIA AFASTAMENTO GRUPO</th>";
			html = html + "<th>OCORR�NCIA AFASTAMENTO OCORR�NCIA</th>";
			html = html + "<th>OCORR�NCIA AFASTAMENTO DATA INICIO</th>";
			html = html + "<th>OCORR�NCIA AFASTAMENTO DATA T�RMIO</th>";
			html = html + "<th>DIPLOMA LEGAL C�DIGO</th>";
			html = html + "<th>DIPLOMA LEGAL N�MERO</th>";
			html = html + "<th>DIPLOMA LEGAL DATA PUBLICA��O</th>";
			html = html + "<th>OCORR�NCIA DE INATIVIDADE GRUPO</th>";
			html = html + "<th>OCORR�NCIA DE INATIVIDADE OCORR�NCIA</th>";
			html = html + "<th>OCORR�NCIA DE INATIVIDADE DATA</th>";
			html = html + "<th>DIPLOMA LEGAL C�DIGO</th>";
			html = html + "<th>DIPLOMA LEGAL N�MERO</th>";
			html = html + "<th>DIPLOMA LEGAL DATA PUBLICA��O</th>";
			html = html + "<th>OCORR�NCIA DE APOSENTADORIA N� DO PROCESSO</th>";
			html = html + "<th>OCORR�NCIA DE APOSENTADORIA ANO PREVISTO</th>";
			html = html	+ "<th>OCORR�NCIA DE APOSENTADORIA OP��O APOSENT. INTEGRAL</th>";
			html = html + "<th>UORG DE CONTROLE</th>";
			html = html + "<th>OCORR�NCIA DE MODIF. FUNCIONAL GRUPO</th>";
			html = html + "<th>OCORR�NCIA DE MODIF. FUNCIONAL OCORR�NCIA</th>";
			html = html + "<th>OCORR�NCIA DE MODIF. FUNCIONAL DATA</th>";
			html = html + "<th>DIPLOMA LEGAL C�DIGO</th>";
			html = html + "<th>DIPLOMA LEGAL N�MERO</th>";
			html = html + "<th>DIPLOMA LEGAL DATA PUBLICA��O</th>";
			html = html + "<th>REGIME JUR�DICO - ANTERIOR</th>";
			html = html + "<th>SITUA��O SERVIDOR - ANTERIOR</th>";
			html = html + "<th>MUDAN�A �RG�O DESTINO</th>";
			html = html + "<th>MUDAN�A �RG�O DATA LIBERA��O</th>";
			html = html + "<th>MUDAN�A �RG�O ORIGEM</th>";
			html = html + "<th>�RG�O ANTERIOR</th>";
			html = html + "<th>MATR�CULA ANTERIOR</th>";
			html = html + "<th>C�DIGO �RG�O EXTINTO/MODIFICADO</th>";
			html = html + "<th>MATR�CULA SERVIDOR EXTINTA/MODIFICADA</th>";
			html = html + "<th>�RG�O ATUAL</th>";
			html = html + "<th>MATR�CULA ATUAL</th>";
			html = html + "<th>MUDAN�A UNIDADE PAGADORA C�DIGO UPAG</th>";
			html = html + "<th>MUDAN�A UNIDADE PAGADORA DATA LIBERA��O</th>";
			html = html + "<th>MUDAN�A UNIDADE PAGADORA MOTIVO</th>";
			html = html + "<th>INDICADOR DE PAGAMENTO SERVIDOR</th>";
			html = html + "<th>REGISTRO DE �BITO NOME CART�RIO</th>";
			html = html + "<th>REGISTRO DE �BITO N� DO LIVRO</th>";
			html = html + "<th>REGISTRO DE �BITO N� DA FOLHA</th>";
			html = html + "<th>REGISTRO DE �BITO N� DO REGISTRO</th>";
			html = html + "<th>REGISTRO DE �BITO DATA</th>";
			html = html + "<th>INDICADOR DE EXCLUS�O INSTITUIDOR</th>";
			html = html + "<th>DATA DE EXCLUS�O DO INSTITUIDOR</th>";
			html = html + "<th>VALE ALIMENTA��O TIPO</th>";
			html = html + "<th>VALE ALIMENTA��O DATA INICIO</th>";
			html = html + "<th>VALE ALIMENTA��O DATA FIM</th>";
			html = html + "<th>INDICADOR DE OPERADOR DE RAIO-X</th>";
			html = html + "<th>�RG�O REQUISITANTE</th>";
			html = html + "<th>C�DIGO DA VAGA</th>";
			html = html + "<th>M�S DE CONCESS�O DO ANU�NIO</th>";
			html = html + "<th>PERCENTUAL DE OPERADOR DE RAIO-X</th>";
			html = html	+ "<th>GRUPO - INGR. SERV. P�B. - POSSE C�DIGO DO GRUPO</th>";
			html = html	+ "<th>GRUPO - INGR. SERV. P�B. - POSSE OCORR�NCIA</th>";
			html = html + "<th>GRUPO - INGR. SERV. P�B. - POSSE DATA</th>";
			html = html	+ "<th>GRUPO - INGR. SERV. P�B. - POSSE C�DIGO DIPLOMA</th>";
			html = html	+ "<th>GRUPO - INGR. SERV. P�B. - POSSE C�DIGO DATA DIPLOMA</th>";
			html = html	+ "<th>GRUPO - INGR. SERV. P�B. - POSSE N�MERO DO DIPLOMA</th>";
			html = html	+ "<th>GRUPO REVERS�O � ATIVIDADE GRUPO DE OCORR�NCIA</th>";
			html = html	+ "<th>GRUPO REVERS�O � ATIVIDADE C�DIGO OCORR�NCIA</th>";
			html = html	+ "<th>GRUPO REVERS�O � ATIVIDADE DATA DA OCORR�NCIA</th>";
			html = html	+ "<th>GRUPO REVERS�O � ATIVIDADE C�DIGO DO DIPLOMA</th>";
			html = html	+ "<th>GRUPO REVERS�O � ATIVIDADE DATA PUBLICA��O DIPLOMA</th>";
			html = html	+ "<th>GRUPO REVERS�O � ATIVIDADE N�MERO DO DIPLOMA</th>";
			html = html + "<th>INDICADOR DE C�LCULO AUTOM�TICO CARGO</th>";
			html = html + "<th>INDICADOR DE C�LCULO AUTOM�TICO FUN��O</th>";
			html = html	+ "<th>INDICADOR DE C�LCULO AUTOM�TICO SAL�RIO FAM�LIA</th>";
			html = html	+ "<th>INDICADOR DE C�LCULO AUTOM�TICO ADICIONAL POR TEMPO DE SERVI�O</th>";
			html = html + "<th>FGTS</th>";
			html = html + "<th>PREVID�NCIA SOCIAL</th>";
			html = html + "<th>IMPOSTO DE RENDA</th>";
			html = html	+ "<th>MARGEM CONSIGN�VEL</th>";
			html = html + "<th>CONTRIBUI��O SINDICAL</th>";
			html = html	+ "<th>ADIANTAMENTO 13� SAL�RIO</th>";
			html = html + "<th>ABATE TETO CONSTITUCIONAL</th>";
			html = html	+ "<th>13� SAL�RIO</th>";
			html = html + "<th>PLANO SEGURIDADE SOCIAL 6%</th>";
			html = html + "<th>F�RIAS</th>";
			html = html + "<th>PENS�O</th>";
			html = html + "<th>BENEF�CIOS</th>";
			html = html + "<th>IPMF/CPMF</th>";
			html = html + "<th>RAIS</th>";
			html = html	+ "<th>DIFEREN�A DE URV</th>";
			html = html	+ "<th>ADIANTEMENTO</th>";
			html = html	+ "<th>RENDIMENTO PASEP</th>";

			html = html + "</tr>";

			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {
					html = html + "<tr>";
					html = html + "<td>" + linha.substring(0, 9) + "</td>";
					html = html + "<td>" + linha.substring(9, 16) + "</td>";
					html = html + "<td>" + linha.substring(16, 17) + "</td>";
					html = html + "<td>" + linha.substring(18, 20) + "</td>";
					html = html + "<td>" + linha.substring(20, 80) + "</td>";
					html = html + "<td>" + linha.substring(80, 91) + "</td>";
					html = html + "<td>" + linha.substring(91, 102) + "</td>";
					html = html + "<td>" + linha.substring(102, 152) + "</td>";
					html = html + "<td>" + linha.substring(152, 153) + "</td>";
					html = html + "<td>" + linha.substring(153, 161) + "</td>";
					html = html + "<td>" + linha.substring(161, 162) + "</td>";
					html = html + "<td>" + linha.substring(162, 164) + "</td>";
					html = html + "<td>" + linha.substring(164, 166) + "</td>";
					html = html + "<td>" + linha.substring(166, 171) + "</td>";
					html = html + "<td>" + linha.substring(171, 172) + "</td>";
					html = html + "<td>" + linha.substring(172, 174) + "</td>";
					html = html + "<td>" + linha.substring(174, 177) + "</td>";
					html = html + "<td>" + linha.substring(177, 181) + "</td>";
					html = html + "<td>" + linha.substring(181, 183) + "</td>";
					html = html + "<td>" + linha.substring(183, 185) + "</td>";
					html = html + "<td>" + linha.substring(185, 193) + "</td>";
					html = html + "<td>" + linha.substring(193, 201) + "</td>";
					html = html + "<td>" + linha.substring(201, 241) + "</td>";
					html = html + "<td>" + linha.substring(241, 247) + "</td>";
					html = html + "<td>" + linha.substring(247, 268) + "</td>";
					html = html + "<td>" + linha.substring(268, 293) + "</td>";
					html = html + "<td>" + linha.substring(293, 323) + "</td>";
					html = html + "<td>" + linha.substring(323, 331) + "</td>";
					html = html + "<td>" + linha.substring(331, 333) + "</td>";
					html = html + "<td>" + linha.substring(333, 347) + "</td>";
					html = html + "<td>" + linha.substring(347, 352) + "</td>";
					html = html + "<td>" + linha.substring(352, 360) + "</td>";
					html = html + "<td>" + linha.substring(360, 362) + "</td>";
					html = html + "<td>" + linha.substring(362, 375) + "</td>";
					html = html + "<td>" + linha.substring(375, 764) + "</td>";

				}
				if (tipoRegistro.equals(2)) {
					html = html + "<td>" + linha.substring(20, 23) + "</td>"; 
					html = html + "<td>" + linha.substring(23, 25) + "</td>";
					html = html + "<td>" + linha.substring(25, 31) + "</td>";
					html = html + "<td>" + linha.substring(31, 36) + "</td>";
					html = html + "<td>" + linha.substring(36, 38) + "</td>";
					html = html + "<td>" + linha.substring(38, 41) + "</td>";
					html = html + "<td>" + linha.substring(41, 47) + "</td>";
					html = html + "<td>" + linha.substring(47, 60) + "</td>";
					html = html + "<td>" + linha.substring(60, 68) + "</td>";
					html = html + "<td>" + linha.substring(68, 71) + "</td>";
					html = html + "<td>" + linha.substring(71, 77) + "</td>";
					html = html + "<td>" + linha.substring(77, 90) + "</td>";
					html = html + "<td>" + linha.substring(90, 92) + "</td>";
					html = html + "<td>" + linha.substring(92, 94) + "</td>";
					html = html + "<td>" + linha.substring(94, 102) + "</td>";
					html = html + "<td>" + linha.substring(102, 103) + "</td>";
					html = html + "<td>" + linha.substring(103, 109) + "</td>";
					html = html + "<td>" + linha.substring(109, 111) + "</td>";
					html = html + "<td>" + linha.substring(111, 113) + "</td>";
					html = html + "<td>" + linha.substring(113, 116) + "</td>";
					html = html + "<td>" + linha.substring(116, 119) + "</td>";
					html = html + "<td>" + linha.substring(119, 120) + "</td>";
					html = html + "<td>" + linha.substring(120, 123) + "</td>";
					html = html + "<td>" + linha.substring(123, 131) + "</td>";
					html = html + "<td>" + linha.substring(131, 139) + "</td>";
					html = html + "<td>" + linha.substring(139, 142) + "</td>";
					html = html + "<td>" + linha.substring(142, 147) + "</td>";
					html = html + "<td>" + linha.substring(147, 149) + "</td>";
					html = html + "<td>" + linha.substring(149, 150) + "</td>";
					html = html + "<td>" + linha.substring(150, 158) + "</td>";
					html = html + "<td>" + linha.substring(158, 166) + "</td>";
					html = html + "<td>" + linha.substring(166, 175) + "</td>";
					html = html + "<td>" + linha.substring(175, 178) + "</td>";
					html = html + "<td>" + linha.substring(178, 183) + "</td>";
					html = html + "<td>" + linha.substring(183, 185) + "</td>";
					html = html + "<td>" + linha.substring(185, 186) + "</td>";
					html = html + "<td>" + linha.substring(186, 194) + "</td>";
					html = html + "<td>" + linha.substring(194, 202) + "</td>";
					html = html + "<td>" + linha.substring(202, 211) + "</td>";
					html = html + "<td>" + linha.substring(211, 215) + "</td>";
					html = html + "<td>" + linha.substring(215, 224) + "</td>";
					html = html + "<td>" + linha.substring(224, 232) + "</td>";
					html = html + "<td>" + linha.substring(232, 237) + "</td>";
					html = html + "<td>" + linha.substring(237, 246) + "</td>";
					html = html + "<td>" + linha.substring(246, 248) + "</td>";
					html = html + "<td>" + linha.substring(248, 251) + "</td>";
					html = html + "<td>" + linha.substring(251, 259) + "</td>";
					html = html + "<td>" + linha.substring(259, 261) + "</td>";
					html = html + "<td>" + linha.substring(261, 270) + "</td>";
					html = html + "<td>" + linha.substring(270, 278) + "</td>";
					html = html + "<td>" + linha.substring(278, 280) + "</td>";
					html = html + "<td>" + linha.substring(280, 283) + "</td>";
					html = html + "<td>" + linha.substring(283, 291) + "</td>";
					html = html + "<td>" + linha.substring(291, 293) + "</td>";
					html = html + "<td>" + linha.substring(293, 302) + "</td>";
					html = html + "<td>" + linha.substring(302, 310) + "</td>";
					html = html + "<td>" + linha.substring(310, 312) + "</td>";
					html = html + "<td>" + linha.substring(312, 315) + "</td>";
					html = html + "<td>" + linha.substring(315, 323) + "</td>";
					html = html + "<td>" + linha.substring(323, 325) + "</td>";
					html = html + "<td>" + linha.substring(325, 334) + "</td>";
					html = html + "<td>" + linha.substring(334, 342) + "</td>";
					html = html + "<td>" + linha.substring(342, 344) + "</td>";
					html = html + "<td>" + linha.substring(344, 347) + "</td>";
					html = html + "<td>" + linha.substring(347, 355) + "</td>";
					html = html + "<td>" + linha.substring(355, 363) + "</td>";
					html = html + "<td>" + linha.substring(363, 365) + "</td>";
					html = html + "<td>" + linha.substring(365, 374) + "</td>";
					html = html + "<td>" + linha.substring(374, 382) + "</td>";
					html = html + "<td>" + linha.substring(382, 384) + "</td>";
					html = html + "<td>" + linha.substring(384, 387) + "</td>";
					html = html + "<td>" + linha.substring(387, 395) + "</td>";
					html = html + "<td>" + linha.substring(395, 397) + "</td>";
					html = html + "<td>" + linha.substring(397, 406) + "</td>";
					html = html + "<td>" + linha.substring(406, 414) + "</td>";
					html = html + "<td>" + linha.substring(414, 429) + "</td>";
					html = html + "<td>" + linha.substring(429, 433) + "</td>";
					html = html + "<td>" + linha.substring(433, 434) + "</td>";
					html = html + "<td>" + linha.substring(434, 443) + "</td>";
					html = html + "<td>" + linha.substring(443, 445) + "</td>";
					html = html + "<td>" + linha.substring(445, 448) + "</td>";
					html = html + "<td>" + linha.substring(448, 456) + "</td>";
					html = html + "<td>" + linha.substring(456, 458) + "</td>";
					html = html + "<td>" + linha.substring(458, 467) + "</td>";
					html = html + "<td>" + linha.substring(467, 475) + "</td>";
					html = html + "<td>" + linha.substring(475, 478) + "</td>";
					html = html + "<td>" + linha.substring(478, 480) + "</td>";
					html = html + "<td>" + linha.substring(480, 485) + "</td>";
					html = html + "<td>" + linha.substring(485, 493) + "</td>";
					html = html + "<td>" + linha.substring(493, 498) + "</td>";
					html = html + "<td>" + linha.substring(498, 503) + "</td>";
					html = html + "<td>" + linha.substring(503, 510) + "</td>";
					html = html + "<td>" + linha.substring(510, 515) + "</td>";
					html = html + "<td>" + linha.substring(515, 522) + "</td>";
					html = html + "<td>" + linha.substring(522, 527) + "</td>";
					html = html + "<td>" + linha.substring(527, 534) + "</td>";
					html = html + "<td>" + linha.substring(534, 543) + "</td>";
					html = html + "<td>" + linha.substring(543, 551) + "</td>";
					html = html + "<td>" + linha.substring(551, 552) + "</td>";
					html = html + "<td>" + linha.substring(552, 553) + "</td>";
					html = html + "<td>" + linha.substring(553, 603) + "</td>";
					html = html + "<td>" + linha.substring(603, 611) + "</td>";
					html = html + "<td>" + linha.substring(611, 617) + "</td>";
					html = html + "<td>" + linha.substring(617, 625) + "</td>";
					html = html + "<td>" + linha.substring(625, 633) + "</td>";
					html = html + "<td>" + linha.substring(633, 634) + "</td>";
					html = html + "<td>" + linha.substring(634, 642) + "</td>";
					html = html + "<td>" + linha.substring(642, 643) + "</td>";
					html = html + "<td>" + linha.substring(643, 651) + "</td>";
					html = html + "<td>" + linha.substring(651, 659) + "</td>";
					html = html + "<td>" + linha.substring(659, 660) + "</td>";
					html = html + "<td>" + linha.substring(660, 665) + "</td>";
					html = html + "<td>" + linha.substring(665, 672) + "</td>";
					html = html + "<td>" + linha.substring(672, 674) + "</td>";
					html = html + "<td>" + linha.substring(674, 679) + "</td>";
					html = html + "<td>" + linha.substring(679, 681) + "</td>";
					html = html + "<td>" + linha.substring(681, 684) + "</td>";
					html = html + "<td>" + linha.substring(684, 692) + "</td>";
					html = html + "<td>" + linha.substring(692, 694) + "</td>";
					html = html + "<td>" + linha.substring(694, 702) + "</td>";
					html = html + "<td>" + linha.substring(702, 711) + "</td>";
					html = html + "<td>" + linha.substring(711, 713) + "</td>";
					html = html + "<td>" + linha.substring(713, 716) + "</td>";
					html = html + "<td>" + linha.substring(716, 724) + "</td>";
					html = html + "<td>" + linha.substring(724, 726) + "</td>";
					html = html + "<td>" + linha.substring(726, 734) + "</td>";
					html = html + "<td>" + linha.substring(734, 743) + "</td>";
					html = html + "<td>" + linha.substring(743, 744) + "</td>";
					html = html + "<td>" + linha.substring(744, 745) + "</td>";
					html = html + "<td>" + linha.substring(745, 746) + "</td>";
					html = html + "<td>" + linha.substring(746, 747) + "</td>";
					html = html + "<td>" + linha.substring(747, 748) + "</td>";
					html = html + "<td>" + linha.substring(748, 749) + "</td>";
					html = html + "<td>" + linha.substring(749, 750) + "</td>";
					html = html + "<td>" + linha.substring(750, 751) + "</td>";
					html = html + "<td>" + linha.substring(751, 752) + "</td>";
					html = html + "<td>" + linha.substring(752, 753) + "</td>";
					html = html + "<td>" + linha.substring(753, 754) + "</td>";
					html = html + "<td>" + linha.substring(754, 755) + "</td>";
					html = html + "<td>" + linha.substring(755, 756) + "</td>";
					html = html + "<td>" + linha.substring(756, 757) + "</td>";
					html = html + "<td>" + linha.substring(757, 758) + "</td>";
					html = html + "<td>" + linha.substring(758, 759) + "</td>";
					html = html + "<td>" + linha.substring(759, 760) + "</td>";
					html = html + "<td>" + linha.substring(760, 761) + "</td>";
					html = html + "<td>" + linha.substring(761, 762) + "</td>";
					html = html + "<td>" + linha.substring(762, 763) + "</td>";
					html = html + "<td>" + linha.substring(763, 764) + "</td>";

					System.out.println(i++);
					html = html + "</tr>";

					
				}
			}
			html = html + "</table>";
			html = html + "</body>";
			html = html + "</html>";

			FileOutputStream file = new FileOutputStream("C:\\Relatorio.html");
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
