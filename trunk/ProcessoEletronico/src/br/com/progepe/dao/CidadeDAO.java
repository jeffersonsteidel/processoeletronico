package br.com.progepe.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Estado;

public class CidadeDAO extends DAO{


	@SuppressWarnings("unchecked")
	public List<Cidade> listByEstado(Estado estado) {
		HibernateUtility.beginTransaction();
		return HibernateUtility.getSession().createCriteria(Cidade.class).add(
				Restrictions.like("estado", estado)).addOrder(
				Order.asc("descricao")).list();
	}
	
	public Cidade listByNome(String nomeCidade) {
		HibernateUtility.beginTransaction();
		return (Cidade) HibernateUtility.getSession().createCriteria(Cidade.class).add(
				Restrictions.like("descricao", nomeCidade)).uniqueResult();
	}
	
	public Cidade listByNomeAndUF(String nomeCidade, Estado estado) {
		HibernateUtility.beginTransaction();
		return (Cidade) HibernateUtility.getSession().createCriteria(Cidade.class).add(
				Restrictions.like("descricao", nomeCidade)).add(Restrictions.like("estado", estado)).uniqueResult();
	}
}