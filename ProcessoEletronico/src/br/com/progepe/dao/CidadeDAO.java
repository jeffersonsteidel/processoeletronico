package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Estado;

public class CidadeDAO {

	private Session session;

	public CidadeDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> listByEstado(Estado estado) {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(Cidade.class).add(
				Restrictions.like("estado", estado)).addOrder(
				Order.asc("descricao")).list();
	}
}