package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
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

		Criteria c = HibernateUtility.getSession().createCriteria(
				ServidorTitulacao.class);
		if (servidorTitulacao.getServidor().getSiape() != null
				&& servidorTitulacao.getServidor().getSiape() != 0) {
			c.add(Restrictions.like("servidor", servidorTitulacao.getServidor()));
		}

		if (servidorTitulacao.getAreaConhecimento().getCodigo() != null
				&& servidorTitulacao.getAreaConhecimento().getCodigo() != 0) {
			c.add(Restrictions.like("areaConhecimento",
					servidorTitulacao.getAreaConhecimento()));
		}
		if (servidorTitulacao.getTitulacao().getCodigo() != null
				&& servidorTitulacao.getTitulacao().getCodigo() != 0) {
			c.add(Restrictions.like("titulacao",
					servidorTitulacao.getTitulacao()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}
}