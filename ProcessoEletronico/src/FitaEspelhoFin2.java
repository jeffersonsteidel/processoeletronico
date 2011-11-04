import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

public class FitaEspelhoFin2 {

	static String arquivoEntrada = "FITA_OUT";
	static String arquivoSaida = "FITA_FIN_OUT";

	public static void main(String[] args) throws ParseException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITAS_ESPELHO_2011/" + arquivoEntrada + ".txt"));
			String html = "SIAPE;REND/DESC;COD;SEQ.;VALOR;MÊS;ANO;";
			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(3)) {
					html = html + "<br>" + linha.substring(9, 16) + ";";
					html = html + linha.substring(20, 21) + ";";
					html = html + linha.substring(21, 26) + ";";
					html = html + linha.substring(26, 27) + ";";
					html = html + linha.substring(27, 36) + ","
							+ linha.substring(36, 38) + ";";
					html = html + "OUTUBRO;2011;";
				}
			}

			
			FileOutputStream file = new FileOutputStream("C:\\" + arquivoSaida
					+ ".html");
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
