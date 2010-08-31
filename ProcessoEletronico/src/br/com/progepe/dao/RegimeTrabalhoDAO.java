package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.progepe.entity.RegimeTrabalho;

public class RegimeTrabalhoDAO {

	private Session session;

	public RegimeTrabalhoDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<RegimeTrabalho> list() {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(RegimeTrabalho.class).list();
	}

}