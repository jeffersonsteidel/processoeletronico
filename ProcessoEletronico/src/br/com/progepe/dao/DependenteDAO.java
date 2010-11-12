package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Dependente;

public class DependenteDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<Dependente> listByServidor(Dependente dependente) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Dependente.class);
		if (dependente.getServidor() != null) {
			c.add(Restrictions.like("servidor", dependente.getServidor()));
		}
		return c.list();
	}

	// @SuppressWarnings("unchecked")
	// public List<Dependente> listByFilter(Dependente dependente) {
	// HibernateUtility.getSession().clear();
	// HibernateUtility.beginTransaction();
	//
	// Criteria c = HibernateUtility.getSession().createCriteria(
	// ServidorTitulacao.class);
	// if (dependente.getServidor().getSiape() != null &&
	// dependente.getServidor().getSiape() != 0) {
	// c.add(Restrictions.like("servidor", dependente.getServidor()));
	// }
	//
	// if(dependente.getAreaConhecimento().getCodigo() != null &&
	// servidorTitulacao.getAreaConhecimento().getCodigo()!=0){
	// c.add(Restrictions.like("areaConhecimento",
	// servidorTitulacao.getAreaConhecimento()));
	// }
	// if(servidorTitulacao.getTitulacao().getCodigo()!= null &&
	// servidorTitulacao.getTitulacao().getCodigo()!=0){
	// c.add(Restrictions.like("titulacao", servidorTitulacao.getTitulacao()));
	// }
	// return c.list();
	// }
}