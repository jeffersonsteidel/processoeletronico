package br.com.progepe.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

import br.com.progepe.entity.Servidor;

public class DAO implements BaseDAO {

	public Serializable save(Object objeto) {
		HibernateUtility.beginTransaction();
		return HibernateUtility.getSession().save(objeto);
	}

	public void update(Object objeto) {
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().update(objeto);
	}

	public void delete(Object objeto) {
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().delete(objeto);
	}

	@SuppressWarnings("rawtypes")
	public List list(Class clazz, String ordenarPor) {
		return HibernateUtility.getSession().createCriteria(clazz)
				.addOrder(Order.asc(ordenarPor)).list();
	}

	@SuppressWarnings("rawtypes")
	public List list(Class clazz, int firstResult, int maxResults) {
		Criteria criteria = HibernateUtility.getSession().createCriteria(clazz);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		return criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public List listByExample(Object example) {
		Criteria criteria = HibernateUtility.getSession().createCriteria(
				example.getClass());
		Example sample = Example.create(example);
		sample.enableLike();
		sample.excludeZeroes();
		criteria.add(sample);
		return criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public Object getById(Serializable id, Class clazz) {
		HibernateUtility.beginTransaction();
		return HibernateUtility.getSession().get(clazz, id);
	}

	public void saveFitaEspelho(Servidor servidor) throws Exception {
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().save(servidor);
		if (servidor.getSiape().equals(7343463)) {
			HibernateUtility.getSession().getTransaction().commit();
		}
	}

	@SuppressWarnings("rawtypes")
	public List list(Class clazz) {
		return HibernateUtility.getSession().createCriteria(clazz).list();
	}

	public Object refresh(Object object) {
		HibernateUtility.getSession().flush();
		HibernateUtility.getSession().refresh(object);
		return object;
	}
}