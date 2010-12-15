package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	
	@SuppressWarnings("unchecked")
	public List<Object> listByFilter(
			Emprego emprego) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Emprego e INNER JOIN e.servidor s where 1 = 1 ";
		if(emprego.getServidor().getSiape() != null && emprego.getServidor().getSiape() != 0){
			sql += " and s.siape = "+ emprego.getServidor().getSiape() ;
		}
		if(emprego.getServidor().getNome() != null && emprego.getServidor().getNome() != ""){
			sql += " and upper(s.nome) like '%"+ emprego.getServidor().getNome().toUpperCase()+"%'";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Object>) query.list();
	}
}