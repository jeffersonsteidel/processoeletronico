package br.com.progepe.dao;

import java.security.NoSuchAlgorithmException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.encripty.Encripty;
import br.com.progepe.entity.Autenticacao;

public class DAOAutenticacao extends  DAO {

	public Autenticacao autentica(Autenticacao autenticacao)
			throws NoSuchAlgorithmException {
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				Autenticacao.class);
		c.add(Restrictions.like("siape", autenticacao.getSiape()));
		c.add(Restrictions.like("senha",
				Encripty.criptografaSenha(autenticacao.getSenha())));
		return (Autenticacao) c.uniqueResult();
	}
}