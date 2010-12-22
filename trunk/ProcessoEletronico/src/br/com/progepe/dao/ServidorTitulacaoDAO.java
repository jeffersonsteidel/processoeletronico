package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.entity.ServidorTitulacao;

public class ServidorTitulacaoDAO extends DAO {

	private static ServidorTitulacaoDAO instance;

	private ServidorTitulacaoDAO() {
	}

	public static ServidorTitulacaoDAO getInstance() {
		if (instance == null) {
			instance = new ServidorTitulacaoDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<ServidorTitulacao> listByServidor(
			ServidorTitulacao servidorTitulacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				ServidorTitulacao.class);
		if (servidorTitulacao.getServidor() != null) {
			c.add(Restrictions.like("servidor", servidorTitulacao.getServidor()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<ServidorTitulacao> listByFilter(
			ServidorTitulacao servidorTitulacao, Integer situacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from ServidorTitulacao st LEFT JOIN FETCH st.servidor s where 1 = 1 ";
		if (servidorTitulacao.getServidor().getSiape() != null
				&& servidorTitulacao.getServidor().getSiape() != 0) {
			sql += " and s.siape = "
					+ servidorTitulacao.getServidor().getSiape();
		}
		if (servidorTitulacao.getServidor().getNome() != null
				&& servidorTitulacao.getServidor().getNome() != "") {
			sql += " and upper(s.nome) like '%"
					+ servidorTitulacao.getServidor().getNome().toUpperCase()
					+ "%'";
		}
		if (servidorTitulacao.getTitulacao().getCodigo() != null
				&& servidorTitulacao.getTitulacao().getCodigo() != 0) {
			sql += " and st.titulacao.codigo = " +servidorTitulacao.getTitulacao().getCodigo();
		}
		if (servidorTitulacao.getAreaConhecimento().getCodigo() != null
				&& servidorTitulacao.getAreaConhecimento().getCodigo() != 0) {
			sql += " and st.areaConhecimento.codigo =  "
					+ servidorTitulacao.getAreaConhecimento().getCodigo();
		}
		if (situacao != null && Constantes.ATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is null";
		}
		if (situacao != null && Constantes.DESATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is not null";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<ServidorTitulacao>) query.list();
	}
}