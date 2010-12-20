package br.com.progepe.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Funcao;
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
}