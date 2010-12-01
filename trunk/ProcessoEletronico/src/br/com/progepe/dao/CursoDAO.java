package br.com.progepe.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Curso;
import br.com.progepe.entity.Lotacao;

public class CursoDAO extends DAO {
	
	private static CursoDAO instance;
	private CursoDAO(){}
	
	
	public static CursoDAO getInstance(){
		if(instance == null){
			instance = new CursoDAO();
		}
		return instance;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Curso> listByCampus(Lotacao lotacao) {
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		if(lotacao != null){
		return HibernateUtility.getSession().createCriteria(Curso.class).add(
				Restrictions.like("lotacao", lotacao)).addOrder(
				Order.asc("descricao")).list();
		}
		return null;
	}
	
} 