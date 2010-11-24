package br.com.progepe.dao;

import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Estado;

public class EstadoDAO extends DAO{
	
	private static EstadoDAO instance;
	private EstadoDAO(){}
	
	
	public static EstadoDAO getInstance(){
		if(instance == null){
			instance = new EstadoDAO();
		}
		return instance;
	}
	
	public Estado listByUf(String ufEstado) {
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		return (Estado) HibernateUtility.getSession().createCriteria(Estado.class).add(
				Restrictions.like("uf", ufEstado)).uniqueResult();
	}
}