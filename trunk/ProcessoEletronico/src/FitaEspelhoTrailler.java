import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

public class FitaEspelhoTrailler {

	public static void main(String[] args) throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITAS_ESPELHO_2011/FITA_FEV.txt"));

			String html = "";
			html = html + "<html>";
			html = html + "<body>";
			html = html + "<table name='table' border='1'>";
			html = html + "<tr>";
			html = html + "<th>CONSTANTE</th>";
			html = html + "<th>TIPO REGISTRO</th>";
			html = html + "<th>QUANT. UPAG</th>";
			html = html + "<th>QUANT. SERVIDORES</th>";
			html = html + "<th>FILLER</th>";
			html = html + "</tr>";

			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(9)) {
					html = html + "<tr>";
					html = html + "<td>" + linha.substring(0, 17) + "</td>";
					html = html + "<td>" + linha.substring(17, 18) + "</td>";
					html = html + "<td>" + linha.substring(18, 21) + "</td>";
					html = html + "<td>" + linha.substring(21, 27) + "</td>";
					html = html + "<td>" + linha.substring(27, 764) + "</td>";
					html = html + "</tr>";
				}
			}
			html = html + "</table>";
			html = html + "</body>";
			html = html + "</html>";

			FileOutputStream file = new FileOutputStream("C:\\RelatorioFiller.html");
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
