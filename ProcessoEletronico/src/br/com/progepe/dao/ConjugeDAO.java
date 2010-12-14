package br.com.progepe.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Servidor;

public class ConjugeDAO extends DAO {

	private static ConjugeDAO instance;

	private ConjugeDAO() {
	}

	public static ConjugeDAO getInstance() {
		if (instance == null) {
			instance = new ConjugeDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Conjuge> listByServidor(Conjuge conjuge) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Conjuge.class);
		if (conjuge.getServidor() != null) {
			c.add(Restrictions.like("servidor", conjuge.getServidor()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}
	
	
	public Conjuge refreshBySolicitante(Servidor servidor){		
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();	
		Criteria c = HibernateUtility.getSession().createCriteria(
				Conjuge.class);
		if (servidor != null) {
			c.add(Restrictions.like("servidor", servidor));
		}
		c.add(Restrictions.like("atual", 1));
		HibernateUtility.commitTransaction();
		return (Conjuge)c.uniqueResult();
	}
	
	public void updateConjuge(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().update(objeto);
			HibernateUtility.commitTransaction();
		} catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

}