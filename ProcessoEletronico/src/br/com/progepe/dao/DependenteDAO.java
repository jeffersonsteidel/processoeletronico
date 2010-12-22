package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.entity.Dependente;

public class DependenteDAO extends DAO {

	private static DependenteDAO instance;

	private DependenteDAO() {
	}

	public static DependenteDAO getInstance() {
		if (instance == null) {
			instance = new DependenteDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listByServidor(Dependente dependente) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				Dependente.class);
		if (dependente.getServidor() != null) {
			c.add(Restrictions.like("servidor", dependente.getServidor()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listByFilter(Dependente dependente, Integer situacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Dependente d LEFT JOIN FETCH d.servidor s where 1 = 1 ";
		if (dependente.getServidor().getSiape() != null
				&& dependente.getServidor().getSiape() != 0) {
			sql += " and s.siape = " + dependente.getServidor().getSiape();
		}
		if (dependente.getServidor().getNome() != null
				&& dependente.getServidor().getNome() != "") {
			sql += " and upper(s.nome) like '%"
					+ dependente.getServidor().getNome().toUpperCase() + "%'";
		}
		if (dependente.getNome() != null && dependente.getNome() != "") {
			sql += " and upper(d.nome) like '%"
					+ dependente.getNome().toUpperCase() + "%'";
		}
		if (dependente.getGrauParentesco().getCodigo() != null
				&& dependente.getGrauParentesco().getCodigo() != 0) {
			sql += " and d.grauParentesco = "
					+ dependente.getGrauParentesco().getCodigo();
		}
		if (situacao != null && Constantes.ATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is null";
		}
		if (situacao != null && Constantes.DESATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is not null";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Dependente>) query.list();
	}
}