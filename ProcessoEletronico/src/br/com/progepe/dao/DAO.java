package br.com.progepe.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

import br.com.progepe.entity.Servidor;

public class DAO implements BaseDAO {

	private static DAO instance;

	protected DAO() {
	}

	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}

	public void save(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().save(objeto);
			HibernateUtility.commitTransaction();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Item salvo com sucesso!", "Item salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	public void saveOrUpdate(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().saveOrUpdate(objeto);
			HibernateUtility.commitTransaction();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Item salvo com sucesso!", "Item salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	public void update(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().update(objeto);
			HibernateUtility.commitTransaction();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Item atualizado com sucesso!",
					"Item atualizado com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	public void delete(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().delete(objeto);
			HibernateUtility.commitTransaction();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Item exclu�do com sucesso!", "Item exclu�do com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	@SuppressWarnings("rawtypes")
	public List list(Class clazz, String ordenarPor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.commitTransaction();
		return HibernateUtility.getSession().createCriteria(clazz)
				.addOrder(Order.asc(ordenarPor)).list();
	}

	@SuppressWarnings("rawtypes")
	public List list(Class clazz, int firstResult, int maxResults) {
		HibernateUtility.getSession().clear();
		Criteria criteria = HibernateUtility.getSession().createCriteria(clazz);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResults);
		HibernateUtility.commitTransaction();
		return criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public List listByExample(Object example) {
		HibernateUtility.getSession().clear();
		Criteria criteria = HibernateUtility.getSession().createCriteria(
				example.getClass());
		Example sample = Example.create(example);
		sample.enableLike();
		sample.excludeZeroes();
		criteria.add(sample);
		HibernateUtility.commitTransaction();
		return criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public Object getById(Serializable id, Class clazz) {
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().clear();
		HibernateUtility.commitTransaction();
		return HibernateUtility.getSession().get(clazz, id);
	}

	public void saveFitaEspelho(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().save(servidor);
		try {
			if (servidor.getSiape() == 1037636
					|| servidor.getSiape() == 1582244
					|| servidor.getSiape() == 1636146
					|| servidor.getSiape() == 1695766
					|| servidor.getSiape() == 1855801
					|| servidor.getSiape() == 1855836
					|| servidor.getSiape() == 1856181
					|| servidor.getSiape() == 1856271
					|| servidor.getSiape() == 1856360
					|| servidor.getSiape() == 1859783
					|| servidor.getSiape() == 1859875
					|| servidor.getSiape() == 1860240
					|| servidor.getSiape() == 1860290
					|| servidor.getSiape() == 1860420
					|| servidor.getSiape() == 1860429
					|| servidor.getSiape() == 1860672
					|| servidor.getSiape() == 1860691
					|| servidor.getSiape() == 1860696
					|| servidor.getSiape() == 1860755
					|| servidor.getSiape() == 1860795) {
				HibernateUtility.getSession().getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println("ERRO: "+servidor.getSiape());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public List list(Class clazz) {
		HibernateUtility.getSession().clear();
		HibernateUtility.commitTransaction();
		return HibernateUtility.getSession().createCriteria(clazz).list();
	}

	public Object refresh(Object object) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().refresh(object);
		HibernateUtility.commitTransaction();
		return object;
	}
}