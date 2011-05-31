package br.com.progepe.dao;

import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.StaleStateException;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.encripty.Encripty;
import br.com.progepe.entity.Autenticacao;

public class AutenticacaoDAO extends  DAO {
	
	private static AutenticacaoDAO instance;
	private AutenticacaoDAO(){}
	
	
	public static AutenticacaoDAO getInstance(){
		if(instance == null){
			instance = new AutenticacaoDAO();
		}
		return instance;
	}
	
	public Autenticacao autentica(Autenticacao autenticacao)
			throws NoSuchAlgorithmException {
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				Autenticacao.class);
		c.add(Restrictions.eq("siape", autenticacao.getSiape()));
		c.add(Restrictions.eq("senha",
				Encripty.criptografaSenha(autenticacao.getSenha())));
		HibernateUtility.commitTransaction();
		return (Autenticacao) c.uniqueResult();
	}
	
	public void deleteAutenticacao(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().delete(objeto);
			HibernateUtility.commitTransaction();
		}
		catch (StaleStateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}
	
	public void saveAutenticacao(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().save(objeto);
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