package br.com.progepe.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import br.com.progepe.entity.Progressao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;
import br.com.progepe.jsfUtil.DataUtil;

public class ProgressaoDAO extends DAO {

	private static ProgressaoDAO instance;

	private ProgressaoDAO() {
	}

	public static ProgressaoDAO getInstance() {
		if (instance == null) {
			instance = new ProgressaoDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<ServidorTitulacao> listTitulacoesServidor(Servidor servidor) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from ServidorTitulacao  st where st.indValidado = 1 and st.servidor = :servidor");
		query.setParameter("servidor", servidor);
		HibernateUtility.commitTransaction();
		return (List<ServidorTitulacao>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Progressao> listProgresoes(Progressao progressao,
			String indicador) {
		HibernateUtility.getSession().clear();
		String sql;
		sql = "from Progressao p where 1 = 1 ";
		if (indicador.equals("F")) {
			sql += " and p.dataProximaProgressao > " + DataUtil.formatSql(new Date());
		} else if (indicador.equals("P")) {
			sql += " and p.dataProximaProgressao < " + DataUtil.formatSql(new Date());
		} else if (indicador.equals("H")) {
			sql += " and p.dataProximaProgressao = " + DataUtil.formatSql(new Date());
		} else if (progressao.getServidor() != null && progressao.getServidor().getSiape() != 0) {
			sql += " and p.servidor.siape = " + progressao.getServidor().getSiape();
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Progressao>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Progressao> listProgresoesByServidor(Progressao progressao) {
		HibernateUtility.getSession().clear();
		String sql;
		sql = "from Progressao p where 1 and 1 ";
		if (progressao.getServidor() != null && progressao.getServidor().getSiape() != 0) {
			sql += " and p.servidor.siape = " + progressao.getServidor().getSiape();
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Progressao>) query.list();
	}

}