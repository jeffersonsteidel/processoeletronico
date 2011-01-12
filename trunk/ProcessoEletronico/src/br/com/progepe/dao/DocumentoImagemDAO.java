package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.DocumentoImagem;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.Solicitacao;

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
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().clear();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Solicitacao.class);
		if (documentoImagem.getServidor() != null
				&& documentoImagem.getServidor().getSiape() != 0) {
			c.add(Restrictions.like("servidor", documentoImagem.getServidor()));
		}
		if (titularDocumento.equals(2)) {
			c.add(Restrictions.isNotNull("conjuge"));
		}
		if (titularDocumento.equals(3)) {
			c.add(Restrictions.isNotNull("dependente"));
		}
		if (documentoImagem.getTipoDocumento() != null
				&& documentoImagem.getTipoDocumento().getCodigo() != 0) {
			c.add(Restrictions.like("tipoDocumento",
					documentoImagem.getTipoDocumento()));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

}