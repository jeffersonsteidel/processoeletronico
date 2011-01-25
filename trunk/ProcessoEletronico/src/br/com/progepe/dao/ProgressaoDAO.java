package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Query;

import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;

public class ProgressaoDAO extends DAO {

	private static ProgressaoDAO instance;

	private ProgressaoDAO() {
	}

	public static ProgressaoDAO getInstance() {
		if (instance == null) {
			instance = new ProgressaoDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<ServidorTitulacao> listTitulacoesServidor(
			Servidor servidor) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from ServidorTitulacao  st where st.indValidado = 1 and st.servidor = :servidor");
		query.setParameter("servidor", servidor);
		HibernateUtility.commitTransaction();
		return (List<ServidorTitulacao>) query.list();
	}

	
}