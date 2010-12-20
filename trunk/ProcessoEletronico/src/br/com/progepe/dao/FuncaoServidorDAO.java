package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Funcao;
import br.com.progepe.entity.FuncaoServidor;
import br.com.progepe.entity.TipoFuncao;

public class FuncaoServidorDAO extends DAO{

	private static FuncaoServidorDAO instance;
	private FuncaoServidorDAO(){}
	
	
	public static FuncaoServidorDAO getInstance(){
		if(instance == null){
			instance = new FuncaoServidorDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcao> listByTipoFuncao(TipoFuncao tipoFuncao) {
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		return HibernateUtility.getSession().createCriteria(Funcao.class).add(
				Restrictions.like("tipoFuncao", tipoFuncao)).addOrder(
				Order.asc("descricao")).list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<FuncaoServidor> listByFilter(
			FuncaoServidor funcaoServidor, Boolean indAtual) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from FuncaoServidor fs LEFT JOIN FETCH fs.servidor s where 1 = 1 ";
		if (funcaoServidor.getServidor().getSiape() != null
				&& funcaoServidor.getServidor().getSiape() != 0) {
			sql += " and s.siape = "
					+ funcaoServidor.getServidor().getSiape();
		}
		if (funcaoServidor.getFuncao().getTipoFuncao() != null
				&& funcaoServidor.getFuncao().getTipoFuncao().getCodigo() != 0) {
			sql += " and fs.fucao.tipofuncao.codigo =  "
					+ funcaoServidor.getFuncao().getTipoFuncao().getCodigo();
		}
		if (funcaoServidor.getFuncao() != null
				&& funcaoServidor.getFuncao().getCodigo() != 0) {
			sql += " and fs.fucao.codigo =  "
					+ funcaoServidor.getFuncao().getCodigo();
		}
		if (funcaoServidor.getLocalExercicio()!= null
				&& funcaoServidor.getLocalExercicio().getCodigo() != 0) {
			sql += " and fs.localExercicio.codigo =  "
					+ funcaoServidor.getLocalExercicio().getCodigo();
		}
		if (indAtual) {
			sql += " and fs.dataSaida is null";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<FuncaoServidor>) query.list();
	}
	
	
}