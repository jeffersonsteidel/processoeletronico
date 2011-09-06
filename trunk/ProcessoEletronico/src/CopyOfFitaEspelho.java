import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;

public class CopyOfFitaEspelho {

	static String arquivoEntrada = "FITA_JUL";
	static String arquivoSaida = "FITA_JUL_AAA";
	
	public static void main(String[] args) throws ParseException {
		String newLine = System.getProperty("line.separator");  
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://FITAS_ESPELHO_2011/" + arquivoEntrada + ".txt"));

			String html = "";

			while (br.ready()) {
				String linha = br.readLine().substring(0, 764);
				Integer tipoRegistro = Integer
						.parseInt(linha.substring(17, 18));
				if (tipoRegistro.equals(1)) {
					html = html + linha.substring(0, 764) +newLine;
				}
			}
		
			FileOutputStream file = new FileOutputStream("C:\\"+ arquivoSaida +".txt");
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
