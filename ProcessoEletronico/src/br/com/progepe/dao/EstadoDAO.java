package br.com.progepe.dao;

import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Estado;

public class EstadoDAO extends DAO{

	public Estado listByUf(String ufEstado) {
		HibernateUtility.beginTransaction();
		return (Estado) HibernateUtility.getSession().createCriteria(Estado.class).add(
				Restrictions.like("uf", ufEstado)).uniqueResult();
	}
}