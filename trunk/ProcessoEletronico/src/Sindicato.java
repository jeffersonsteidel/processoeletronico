import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Sindicato {

	public static void main(String[] args) throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C://SINDICATO.txt"));
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.length() > 96 && (!(linha.contains("Benef. Nome")) && !(linha.contains("Id.")))) {
					char teste = linha.charAt(8);
					if (teste == 'T') {
						System.out.print("Titular: "
								+ linha.substring(22, 60));
						System.out.println("Valor: "
								+ linha.substring(90, 97));	
					}
					if (teste == 'D') {
						System.out.print("Dependente: "
								+ linha.substring(22, 60));
						System.out.println("Valor: "
								+ linha.substring(90, 97));
					}
					if (linha.contains("Total por Familia:")) {
						System.out.println("Valor Total por Familia: "
								+ linha.substring(90, 97) +"\n");
					}
				}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
