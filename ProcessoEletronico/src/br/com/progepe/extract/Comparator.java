package br.com.progepe.extract;

import javax.faces.application.FacesMessage;

public class Comparator {

	public void comparador(Object object1, Object object2, String campo) {

		if (!object1.equals(object2)) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "O campo " + campo
							+ " é diferente!", "O campo " + campo
							+ " diferente!");
			System.out.println(message.getDetail());
		}
	}

	public static void main(String[] args) {
		Comparator comparator = new Comparator();
		comparator.comparador(new String("TESTE1"), new String("TESTE2"),
				"teste");
	}

}
