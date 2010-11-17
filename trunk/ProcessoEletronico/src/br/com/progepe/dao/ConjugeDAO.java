package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;

public class ConjugeDAO extends DAO {

	private static ConjugeDAO instance;

	private ConjugeDAO() {
	}

	public static ConjugeDAO getInstance() {
		if (instance == null) {
			instance = new ConjugeDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Conjuge> listByServidor(Conjuge conjuge) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Dependente.class);
		if (conjuge.getServidor() != null) {
			c.add(Restrictions.like("servidor", conjuge.getServidor()));
		}
		return c.list();
	}

}