package br.com.progepe.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.progepe.entity.Servidor;

public class DAO {

	private static Session session = HibernateUtility.getSessionFactory()
			.getCurrentSession();

	public DAO() {
		session.beginTransaction();
		session.flush();
	}

	public void save(Object object) {
		try {
			session.saveOrUpdate(object);
			session.getTransaction().commit();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Item salvo com sucesso!", "Item salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			session.getTransaction().rollback();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}
	
	public void saveFitaEspelho(Servidor servidor) throws Exception{
			if(!servidor.getSiape().equals(1216159)){
				session.save(servidor);
			}
			if(servidor.getSiape().equals(7343463)){
				session.getTransaction().commit();
			}
	}


	public void delete(Object object) {
		try {
			session.delete(object);
			session.getTransaction().commit();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Item excluído com sucesso!", "Item excluído com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			session.getTransaction().rollback();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	public Object refresh(Object object) {
		try {
			session.clear();
			session.refresh(object);
		} catch (Exception e) {
			session.getTransaction().rollback();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
		return object;
	}

	@SuppressWarnings("rawtypes")
	public List list(Class objectClass, String ordenarPor) {
		Criteria c = session.createCriteria(objectClass).addOrder(
				Order.asc(ordenarPor));
		return c.list();
	}

}