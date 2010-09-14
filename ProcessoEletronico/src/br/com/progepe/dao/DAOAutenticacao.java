package br.com.progepe.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Autenticacao;
import br.com.progepe.entity.Servidor;

public class DAOAutenticacao {

	private static Session session = HibernateUtility.getSessionFactory()
			.getCurrentSession();

	public DAOAutenticacao() {
		session.beginTransaction();
		session.flush();
	}

	public boolean autentica(Servidor servidor, String senha) {
		Criteria c = session
				.createCriteria(Autenticacao.class)
				.add(Restrictions.like("login", servidor.getDocumento()
						.getCpf())).add(Restrictions.like("senha", senha));
		return c.uniqueResult() != null;
	}
}