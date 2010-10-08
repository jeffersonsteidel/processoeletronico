package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Servidor;

public class ServidorDAO extends DAO{


	@SuppressWarnings("unchecked")
	public List<Servidor> listByFilter(Servidor servidor) {
		HibernateUtility.beginTransaction();
		
		Criteria c = HibernateUtility.getSession().createCriteria(Servidor.class);
		if (servidor.getSiape() != null && servidor.getSiape() != 0 ){
		c.add(Restrictions.like("siape", servidor.getSiape()));
		}
		
		if(servidor.getLotacao().getCodigo() != 0){
			c.add(Restrictions.like("lotacao", servidor.getLotacao()));
		}
		
		if (servidor.getNome() != null && servidor.getNome() != "" ){
			c.add(Restrictions.like("nome", servidor.getNome().toUpperCase(), MatchMode.START));			
		}
		
		if (servidor.getCargo().getCodigo() != 0){
			c.add(Restrictions.like("cargo", servidor.getCargo()));
		}
		
		return c.list();
	}
	
}