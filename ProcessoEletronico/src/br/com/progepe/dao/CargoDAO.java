package br.com.progepe.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import br.com.progepe.entity.Cargo;

public class CargoDAO {

	private Session session;

	public CargoDAO() {
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	public void save(Cargo cargo) {
		try {
			session.saveOrUpdate(cargo);
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
		} finally {
			session.close();
		}
	}

	public Cargo refresh(Cargo cargo) {
		try {
			session.clear();
			session.refresh(cargo);
		} catch (Exception e) {
			session.getTransaction().rollback();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} finally {
			session.close();
		}
		return cargo;
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> list() {
		Session session = HibernateUtility.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		return session.createCriteria(Cargo.class).list();
	}

}