package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Servidor;

public class ServidorDAO extends DAO {
	
	private static ServidorDAO instance;
	private ServidorDAO(){}
	
	
	public static ServidorDAO getInstance(){
		if(instance == null){
			instance = new ServidorDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<Servidor> listByFilter(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Servidor.class);
		if (servidor.getSiape() != null && servidor.getSiape() != 0) {
			c.add(Restrictions.like("siape", servidor.getSiape()));
		}

		if (servidor.getLotacao().getCodigo() != 0) {
			c.add(Restrictions.like("lotacao", servidor.getLotacao()));
		}

		if (servidor.getNome() != null && servidor.getNome() != "") {
			c.add(Restrictions.like("nome", servidor.getNome().toUpperCase(),
					MatchMode.ANYWHERE));
		}

		if (servidor.getCargo().getCodigo() != 0) {
			c.add(Restrictions.like("cargo", servidor.getCargo()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	public Servidor refreshBySiape(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(Servidor.class);
		if (servidor.getSiape() != null && servidor.getSiape() != 0 ){
			c.add(Restrictions.like("siape", servidor.getSiape()));
		}
		HibernateUtility.commitTransaction();
		return (Servidor) c.uniqueResult();
	}
	

	public Servidor refreshByFilter(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Servidor.class);
		if (servidor.getSiape() != null && servidor.getSiape() != 0) {
			c.add(Restrictions.like("siape", servidor.getSiape()));
		}

		if (servidor.getNome() != null && servidor.getNome() != "") {
			c.add(Restrictions.like("nome", servidor.getNome().toUpperCase(),
					MatchMode.ANYWHERE));
		}
		HibernateUtility.commitTransaction();
		return (Servidor) c.uniqueResult();
	}
	
} 