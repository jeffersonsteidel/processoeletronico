package br.com.progepe.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.constantes.Constantes;
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
	
	@SuppressWarnings("unchecked")
	public List<Conjuge> listByFilter(Conjuge conjuge, Integer situacao, Integer validado, Integer atuais) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Conjuge c LEFT JOIN FETCH c.servidor s where 1 = 1 ";
		if (conjuge.getServidor().getSiape() != null
				&& conjuge.getServidor().getSiape() != 0) {
			sql += " and s.siape = " + conjuge.getServidor().getSiape();
		}
		if (conjuge.getServidor().getNome() != null
				&& conjuge.getServidor().getNome() != "") {
			sql += " and upper(s.nome) like '%"
					+ conjuge.getServidor().getNome().toUpperCase() + "%'";
		}
		if (conjuge.getNome() != null && conjuge.getNome() != "") {
			sql += " and upper(c.nome) like '%"
					+ conjuge.getNome().toUpperCase() + "%'";
		}
		if (situacao != null && Constantes.ATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is null";
		}
		if (situacao != null && Constantes.DESATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is not null";
		}
		if (validado != null && Constantes.SIM.equals(validado) ) {
			sql += " and c.indValidado = 1";
		}else if (validado != null && Constantes.NAO.equals(validado) ) {
			sql += " and c.indValidado = 0";
		}
		if (atuais != null && Constantes.SIM.equals(atuais) ) {
			sql += " and c.atual = 1";
		}else if (atuais != null && Constantes.NAO.equals(atuais) ) {
			sql += " and c.atual = 0";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Conjuge>) query.list();
	}
	

}