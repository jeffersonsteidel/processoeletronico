package br.com.progepe.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Portaria;

public class PortariaDAO extends DAO {

	private static PortariaDAO instance;
	private PortariaDAO(){}
	
	
	public static PortariaDAO getInstance(){
		if(instance == null){
			instance = new PortariaDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<Portaria> listByFilter(Portaria portaria, Date dataInicial,
			Date dataFinal) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Portaria.class);
		if (portaria.getNumero() != null && portaria.getNumero() != 0) {
			c.add(Restrictions.like("numero", portaria.getNumero()));
		}
		if (portaria.getNome() != null && portaria.getNome() != "") {
			c.add(Restrictions.like("nome", portaria.getNome(),
					MatchMode.ANYWHERE).ignoreCase());
		}
		if (dataInicial != null && dataFinal != null) {
			c.add(Restrictions.between("data", dataInicial, dataFinal));
		}
		if (portaria.getTipo().getCodigo() != null
				&& portaria.getTipo().getCodigo() != 0) {
			c.add(Restrictions.like("tipo", portaria.getTipo()));
		}
		if (portaria.getLocal() != null && portaria.getLocal() != "") {
			c.add(Restrictions.like("local", portaria.getLocal(),
					MatchMode.ANYWHERE).ignoreCase());
		}

		return c.list();
	}
}
