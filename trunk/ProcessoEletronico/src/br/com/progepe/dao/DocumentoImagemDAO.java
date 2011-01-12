package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.DocumentoImagem;
import br.com.progepe.entity.Servidor;

public class DocumentoImagemDAO extends DAO {

	private static DocumentoImagemDAO instance;

	private DocumentoImagemDAO() {
	}

	public static DocumentoImagemDAO getInstance() {
		if (instance == null) {
			instance = new DocumentoImagemDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Conjuge> listConjugeByServidor(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession()
				.createCriteria(Conjuge.class);
		if (servidor != null) {
			c.add(Restrictions.like("servidor", servidor));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listDependenteByServidor(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				Dependente.class);
		if (servidor != null) {
			c.add(Restrictions.like("servidor", servidor));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoImagem> listByFilter(DocumentoImagem documentoImagem,
			Integer titularDocumento) {
		HibernateUtility.getSession().clear();
		String sql;
		sql = "from DocumentoImagem di where di.tipoDocumento.codigo = :codigoTipoDocumento ";
		if (titularDocumento == 1) {
			sql += " and di.servidor.siape = :siapeServidor";
		}
		if (titularDocumento == 2) {
			sql += "and di.conjuge.servidor.siape =: siapeServidor";
		}
		if (titularDocumento == 3) {
			sql += "and di.dependente.servidor.siape =: siapeServidor";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		query.setParameter("codigoTipoDocumento", documentoImagem
				.getTipoDocumento().getCodigo());
		query.setParameter("siapeServidor", documentoImagem.getServidor().getSiape());
		HibernateUtility.commitTransaction();
		return (List<DocumentoImagem>) query.list();
	}
}