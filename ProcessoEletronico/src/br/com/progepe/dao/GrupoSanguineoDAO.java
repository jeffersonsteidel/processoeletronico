package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.progepe.entity.GrupoSanguineo;

public class GrupoSanguineoDAO {

	private Session session;

	public GrupoSanguineoDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<GrupoSanguineo> list() {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(GrupoSanguineo.class).list();
	}

}