package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.entity.Emprego;

public class EmpregoDAO extends DAO {
	
	private static EmpregoDAO instance;
	private EmpregoDAO(){}
	
	
	public static EmpregoDAO getInstance(){
		if(instance == null){
			instance = new EmpregoDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<Emprego> listByServidor(
			Emprego emprego) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Emprego.class);
		if (emprego.getServidor() != null) {
			c.add(Restrictions.like("servidor", emprego.getServidor()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Emprego> listByFilter(
			Emprego emprego, Integer situacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Emprego e LEFT JOIN FETCH e.servidor s where 1 = 1 ";
		if(emprego.getServidor().getSiape() != null && emprego.getServidor().getSiape() != 0){
			sql += " and s.siape = "+ emprego.getServidor().getSiape() ;
		}
		if(emprego.getServidor().getNome() != null && emprego.getServidor().getNome() != ""){
			sql += " and upper(s.nome) like '%"+ emprego.getServidor().getNome().toUpperCase()+"%'";
		}
		if (situacao != null && Constantes.ATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is null";
		}
		if (situacao != null && Constantes.DESATIVO.equals(situacao) ) {
			sql += " and s.dataSaida is not null";
		}
		if(emprego.getStatusSolicitacao()!= null && emprego.getStatusSolicitacao().getCodigo() != 0){
			sql += " and e.statusSolicitacao.codigo = " + emprego.getStatusSolicitacao().getCodigo();
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Emprego>) query.list();
	}
}