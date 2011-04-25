package br.com.progepe.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Estado;

public class CidadeDAO extends DAO{

	private static CidadeDAO instance;
	private CidadeDAO(){}
	
	
	public static CidadeDAO getInstance(){
		if(instance == null){
			instance = new CidadeDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> listByEstado(Estado estado) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		return HibernateUtility.getSession().createCriteria(Cidade.class).add(
				Restrictions.like("estado", estado)).addOrder(
				Order.asc("descricao")).list();
	}
	
	public Cidade listByNome(String nomeCidade) {
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		return (Cidade) HibernateUtility.getSession().createCriteria(Cidade.class).add(
				Restrictions.like("descricao", nomeCidade)).uniqueResult();
	}
	
	public Cidade listByNomeAndUF(String nomeCidade, Estado estado) {
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		return (Cidade) HibernateUtility.getSession().createCriteria(Cidade.class).add(
				Restrictions.like("descricao", nomeCidade)).add(Restrictions.like("estado", estado)).uniqueResult();
	}
}