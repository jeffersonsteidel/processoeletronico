package br.com.progepe.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import br.com.progepe.entity.Progressao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;

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
	public List<Progressao> listProgresoes(Progressao progressao) {
		HibernateUtility.getSession().clear();
		String sql;
		sql = "from Progressao p where 1 and 1 ";
		if (progressao.getDataProximaProgressao().after(new Date())) {
			sql += " p.dataProximaProgressao > " + new Date();
		} else if (progressao.getDataProximaProgressao().before(new Date())) {
			sql += " p.dataProximaProgressao < " + new Date();
		} else if (progressao.getServidor() != null && progressao.getServidor().getCodigo() != 0) {
			sql += " p.servidor.codigo " + progressao.getServidor().getCodigo();
		} 
		else if (progressao.getDataProximaProgressao() == new Date()) {
				sql += " p.dataProximaProgressao = " + new Date();
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
		if (progressao.getServidor() != null && progressao.getServidor().getCodigo() != 0) {
			sql += " p.servidor.codigo " + progressao.getServidor().getCodigo();
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Progressao>) query.list();
	}
	
}