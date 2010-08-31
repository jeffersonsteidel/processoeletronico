package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.progepe.entity.EstadoCivil;

public class EstadoCivilDAO {

	private Session session;

	public EstadoCivilDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<EstadoCivil> list() {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(EstadoCivil.class).list();
	}

}