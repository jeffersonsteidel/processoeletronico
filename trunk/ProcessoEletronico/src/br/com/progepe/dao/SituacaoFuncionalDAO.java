package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.progepe.entity.SituacaoFuncional;

public class SituacaoFuncionalDAO {

	private Session session;

	public SituacaoFuncionalDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<SituacaoFuncional> list() {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(SituacaoFuncional.class).list();
	}

}