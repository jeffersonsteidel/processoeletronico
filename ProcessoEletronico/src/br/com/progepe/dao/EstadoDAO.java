package br.com.progepe.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Estado;

public class EstadoDAO {

	private Session session;

	public EstadoDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	public Estado listByUf(String ufEstado) {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return (Estado) session.createCriteria(Estado.class).add(
				Restrictions.like("uf", ufEstado)).uniqueResult();
	}
}