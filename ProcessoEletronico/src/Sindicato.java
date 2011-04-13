import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Sindicato {

	public static void main(String[] args) throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://SINDICATO_ABRIL_2011.dat"));
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains("Responsável:")) {
						System.out.print(linha.substring(37, 90)+"|");
				}
				if (linha.contains("Total Família:")) {
						System.out.println(linha.substring(14, 21));	
					}
				}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
