package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Emprego;

public class EmpregoDAO extends DAO {
	
	private static EmpregoDAO instance;
	private EmpregoDAO(){}
	
	
	public static EmpregoDAO getInstance(){
		if(instance == null){
			instance = new EmpregoDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<Emprego> listByServidor(
			Emprego emprego) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Emprego.class);
		if (emprego.getServidor() != null) {
			c.add(Restrictions.like("servidor", emprego.getServidor()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}
}