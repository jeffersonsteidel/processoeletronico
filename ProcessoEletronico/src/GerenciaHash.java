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
								"60 - Docente\n701 - Técnico\n 702 - Docente\n 0 - Não Possue\n\nEntre com o Codigo:"));
		JOptionPane.showMessageDialog(null, "O grupo é: "+hashGrupo.get(key));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Código não aceito");
		}
	}

	public void criaIndice() {
		hashGrupo.put(60, "Docente");
		hashGrupo.put(0, "Inexistente");
		hashGrupo.put(701, "Técnico");
		hashGrupo.put(702, "Docente");
	}
}
