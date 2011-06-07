package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Query;

import br.com.progepe.entity.Remocao;

public class RemocaoDAO extends DAO {

	private static RemocaoDAO instance;

	private RemocaoDAO() {
	}

	public static RemocaoDAO getInstance() {
		if (instance == null) {
			instance = new RemocaoDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Remocao> listByFilter(Remocao remocao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Remocao fs LEFT JOIN FETCH fs.servidor s where 1 = 1 ";
		if (remocao.getServidor() != null
				&& remocao.getServidor().getSiape() != null
				&& remocao.getServidor().getSiape() != 0) {
			sql += " and s.siape = " + remocao.getServidor().getSiape();
		}
		if (remocao.getServidor() != null
				&& remocao.getServidor().getNome() != null
				&& remocao.getServidor().getNome() != "") {
			sql += " and UPPER(s.nome) like '%"
					+ remocao.getServidor().getNome().toUpperCase() + "%'";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Remocao>) query.list();
	}

}