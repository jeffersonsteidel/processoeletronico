package br.com.progepe.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.GrauParentesco;

public class GrauParentescoDAO extends DAO{

	private static GrauParentescoDAO instance;
	private GrauParentescoDAO(){}
	
	
	public static GrauParentescoDAO getInstance(){
		if(instance == null){
			instance = new GrauParentescoDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<GrauParentesco> listByObito() {
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		return HibernateUtility.getSession().createCriteria(GrauParentesco.class).add(
				Restrictions.eq("indObito", true)).addOrder(
				Order.asc("descricao")).list();
	}
}