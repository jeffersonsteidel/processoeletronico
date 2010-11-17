package br.com.progepe.dao;

import java.security.NoSuchAlgorithmException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.encripty.Encripty;
import br.com.progepe.entity.Autenticacao;

public class AutenticacaoDAO extends  DAO {
	
	private static AutenticacaoDAO instance;
	private AutenticacaoDAO(){}
	
	
	public static AutenticacaoDAO getInstance(){
		if(instance == null){
			instance = new AutenticacaoDAO();
		}
		return instance;
	}
	
	public Autenticacao autentica(Autenticacao autenticacao)
			throws NoSuchAlgorithmException {
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				Autenticacao.class);
		c.add(Restrictions.like("siape", autenticacao.getSiape()));
		c.add(Restrictions.like("senha",
				Encripty.criptografaSenha(autenticacao.getSenha())));
		HibernateUtility.commitTransaction();
		return (Autenticacao) c.uniqueResult();
	}
}