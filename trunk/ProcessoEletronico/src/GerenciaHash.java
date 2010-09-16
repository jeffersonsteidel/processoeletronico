import java.util.HashMap;

import javax.swing.JOptionPane;

public class GerenciaHash {
	private static HashMap<Integer, String> hashGrupo = new HashMap<Integer, String>();
	private static HashMap<Integer, String> hashCargoTecnico = new HashMap<Integer, String>();
	private static HashMap<Integer, String> hashCargoDocente = new HashMap<Integer, String>();
	private static String grupo;
	private static String cargo;

	public static void main(String args[]) {

		new GerenciaHash().criarIndiceGrupo();
		try {
			Integer key = Integer
					.parseInt(JOptionPane
							.showInputDialog(
									null,
									"60 - Docente\n701 - Técnico\n 702 - Docente\n 0 - Não Possue\n\nEntre com o código do grupo:"));
			grupo = hashGrupo.get(key);
			switch (key) {
			case 701:
				new GerenciaHash().criarIndiceCargoTecnico();
				try {
					Integer key2 = Integer.parseInt(JOptionPane
							.showInputDialog(null,
									"Entre com o código do cargo:"));
					cargo = hashCargoTecnico.get(key2);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Código não aceito");
				}
				break;
			case 702:
				new GerenciaHash().criarIndiceCargoDocente();
				new GerenciaHash().InicializarCargoDocente();
				break;
			case 60:
				new GerenciaHash().InicializarCargoDocente();
				break;
			default:
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Código não aceito");
		}

		JOptionPane.showMessageDialog(null, "O funcionario exerce o cargo de "
				+ cargo + " no grupo " + grupo);
	}

	public void criarIndiceGrupo() {
		hashGrupo.put(60, "Docente");
		hashGrupo.put(0, "Inexistente");
		hashGrupo.put(701, "Técnico");
		hashGrupo.put(702, "Docente");
	}

	public void criarIndiceCargoTecnico() {
		hashCargoTecnico.put(1, new String());
	}

	public void criarIndiceCargoDocente() {
		hashCargoDocente.put(1, new String());
	}
	public void InicializarCargoDocente() {
		new GerenciaHash().criarIndiceCargoDocente();
		try {
			Integer key2 = Integer.parseInt(JOptionPane
					.showInputDialog(null,
							"Entre com o código do cargo:"));
			cargo = hashCargoDocente.get(key2);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Código não aceito");
		}
	}
}
