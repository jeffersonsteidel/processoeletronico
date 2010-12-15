package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.ServidorTitulacao;

public class ServidorTitulacaoDAO extends DAO {
	
	private static ServidorTitulacaoDAO instance;
	private ServidorTitulacaoDAO(){}
	
	
	public static ServidorTitulacaoDAO getInstance(){
		if(instance == null){
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
			ServidorTitulacao servidorTitulacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from ServidorTitulacao st LEFT JOIN FETCH st.servidor s LEFT JOIN FETCH st.titulacao t LEFT JOIN FETCH st.areaConhecimento ac where 1 = 1 ";
		if(servidorTitulacao.getServidor().getSiape() != null && servidorTitulacao.getServidor().getSiape() != 0){
			sql += " and s.siape = "+ servidorTitulacao.getServidor().getSiape() ;
		}
		if(servidorTitulacao.getServidor().getNome() != null && servidorTitulacao.getServidor().getNome() != ""){
			sql += " and upper(s.nome) like '%"+ servidorTitulacao.getServidor().getNome().toUpperCase()+"%'";
		}if(servidorTitulacao.getTitulacao().getDescricao() != null && servidorTitulacao.getTitulacao().getDescricao() != ""){
			sql += " and upper(t.descricao) like '%"+ servidorTitulacao.getTitulacao().getDescricao().toUpperCase()+"%'";
		}if(servidorTitulacao.getAreaConhecimento().getDescricao() != null && servidorTitulacao.getAreaConhecimento().getDescricao() != ""){
			sql += " and upper(ac.descricao) like '%"+ servidorTitulacao.getAreaConhecimento().getDescricao().toUpperCase()+"%'";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<ServidorTitulacao>) query.list();
	}
}