package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.progepe.entity.CorPele;

public class CorPeleDAO {

	private Session session;

	public CorPeleDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<CorPele> list() {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(CorPele.class).list();
	}

}