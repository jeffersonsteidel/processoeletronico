package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Query;

import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Servidor;

public class RessarcimentoSaudeDAO extends DAO {

	private static RessarcimentoSaudeDAO instance;

	private RessarcimentoSaudeDAO() {
	}

	public static RessarcimentoSaudeDAO getInstance() {
		if (instance == null) {
			instance = new RessarcimentoSaudeDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Conjuge> listarConjugeComCarteirinhaPorServidor(
			Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Conjuge c WHERE c.indRessarcimentoSaude = true";
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Conjuge>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listarDependenteComCarteirinhaPorServidor(
			Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Dependente d WHERE d.indRessarcimentoSaude = true";
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Dependente>) query.list();
	}
}