package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				ServidorTitulacao.class);
		c.add(Restrictions.like("indValidado", 1));
		if (servidor != null) {
			c.add(Restrictions.like("servidor", servidor));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	
}