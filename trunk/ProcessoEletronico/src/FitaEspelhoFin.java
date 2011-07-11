import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

public class FitaEspelhoFin {

	static String arquivoEntrada = "FITA_MAI";
	static String arquivoSaida = "FITA_MAI_FIN";
	
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
			html = html + "<th>CARGO</th>";
			html = html + "<th>LOTACAO</th>";
			html = html + "</tr>";
			html = html + "<tr>";
			html = html + "<th>REND/DESC</th>";
			html = html + "<th>COD</th>";
			html = html + "<th>SEQ.</th>";
			html = html + "<th>VALOR</th>";
			html = html + "<th>PRAZO</th>";
//			html = html + "<th>PARAMETRIZAÇÃO</th>";
//			html = html + "<th>PERC.</th>";
//			html = html + "<th>FRAÇÃO</th>";
//			html = html + "<th>NUMERADOR</th>";
//			html = html + "<th>DENOMINADOR</th>";
//			html = html + "<th>ASS. CAL. AUT.</th>";
//			html = html + "<th>NIVEL SAL.</th>";
//			html = html + "<th>SIST. CLSF. NSal</th>";
//			html = html + "<th>Nsal CEMP/FUNC</th>";
//			html = html + "<th>NOME</th>";
//			html = html + "<th>BANCO</th>";
//			html = html + "<th>AGENCIA</th>";
//			html = html + "<th>CONTA CORRENTE</th>";
//			html = html + "<th>ANO/MS</th>";
			html = html + "</tr>";

			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if(tipoRegistro.equals(1)){
					html = html + "<tr>";
					html = html + "<td>" + linha.substring(9, 16) + "</td>";
					html = html + "<td>" + linha.substring(20, 80) + "</td>";
				}
				if(tipoRegistro.equals(2)){
					html = html + "<td>" + linha.substring(113, 119) + "</td>";
					html = html + "<td>" + linha.substring(215, 224)+ "</td>";
					html = html + "</tr>";
				}
				if (tipoRegistro.equals(3)) {
					html = html + "<tr>";
					html = html + "<td>" + linha.substring(20, 21) + "</td>";
					html = html + "<td>" + linha.substring(21, 26) + "</td>";
					html = html + "<td>" + linha.substring(26, 27) + "</td>";
					html = html + "<td>" + linha.substring(27, 36) + ","+ linha.substring(36, 38) +"</td>";
					html = html + "<td>" + linha.substring(38, 41) + "</td>";
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
