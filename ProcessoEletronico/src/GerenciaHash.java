import java.util.HashMap;

import javax.swing.JOptionPane;

public class GerenciaHash {
	private static HashMap<Integer, String> hashGrupo = new HashMap<Integer, String>();

	public static void main(String args[]) {
		
		new GerenciaHash().criaIndice();
		try{
		Integer key = Integer
				.parseInt(JOptionPane
						.showInputDialog(
								null,
								"60 - Docente\n701 - T�cnico\n 702 - Docente\n 0 - N�o Possue\n\nEntre com o Codigo:"));
		JOptionPane.showMessageDialog(null, "O grupo �: "+hashGrupo.get(key));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "C�digo n�o aceito");
		}
	}

	public void criaIndice() {
		hashGrupo.put(60, "Docente");
		hashGrupo.put(0, "Inexistente");
		hashGrupo.put(701, "T�cnico");
		hashGrupo.put(702, "Docente");
	}
}
