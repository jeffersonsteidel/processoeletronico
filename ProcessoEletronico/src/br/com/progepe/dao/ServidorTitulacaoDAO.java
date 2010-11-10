package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.ServidorTitulacao;

public class ServidorTitulacaoDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<ServidorTitulacao> listByServidor(
			ServidorTitulacao servidorTitulacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				ServidorTitulacao.class);
		if (servidorTitulacao.getServidor() != null) {
			c.add(Restrictions.like("servidor", servidorTitulacao.getServidor()));
		}
		return c.list();
	}

}