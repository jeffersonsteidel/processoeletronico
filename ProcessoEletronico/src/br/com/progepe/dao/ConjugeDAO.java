package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Servidor;

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
				Conjuge.class);
		if (conjuge.getServidor() != null) {
			c.add(Restrictions.like("servidor", conjuge.getServidor()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}
	
	
	public Conjuge refreshBySolicitante(Servidor servidor){		
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();	
		Criteria c = HibernateUtility.getSession().createCriteria(
				Conjuge.class);
		if (servidor != null) {
			c.add(Restrictions.like("servidor", servidor));
		}
		c.add(Restrictions.like("atual", 1));
		HibernateUtility.commitTransaction();
		return (Conjuge)c.uniqueResult();
	}

}