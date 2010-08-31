package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.progepe.entity.Padrao;

public class PadraoDAO {

	private Session session;

	public PadraoDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Padrao> list() {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(Padrao.class).list();
	}

}