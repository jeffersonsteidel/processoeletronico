package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.DocumentoImagem;
import br.com.progepe.entity.Emprego;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;

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
	public List<ServidorTitulacao> listTitulacaoByServidor(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				ServidorTitulacao.class);
		if (servidor != null) {
			c.add(Restrictions.like("servidor", servidor));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Emprego> listEmpregoByServidor(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession()
				.createCriteria(Emprego.class);
		if (servidor != null) {
			c.add(Restrictions.like("servidor", servidor));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoImagem> listDocumentosByDependente(
			Dependente dependente) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				DocumentoImagem.class);
		if (dependente != null) {
			c.add(Restrictions.like("dependente", dependente));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoImagem> listDocumentosByEmprego(Emprego emprego) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				DocumentoImagem.class);
		if (emprego != null) {
			c.add(Restrictions.like("emprego", emprego));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoImagem> listDocumentosByConjuge(Conjuge conjuge) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				DocumentoImagem.class);
		if (conjuge != null) {
			c.add(Restrictions.like("conjuge", conjuge));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoImagem> listDocumentosByTitulacao(
			ServidorTitulacao titulacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				DocumentoImagem.class);
		if (titulacao != null) {
			c.add(Restrictions.like("servidorTitulacao", titulacao));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoImagem> listByFilter(DocumentoImagem documentoImagem) {
		HibernateUtility.getSession().clear();
		String sql = "from DocumentoImagem di where 1 = 1";
		if (documentoImagem.getTipoDocumento().getCodigo() != null
				&& documentoImagem.getTipoDocumento().getCodigo() != 0) {
			sql += "and di.tipoDocumento.codigo ="
					+ documentoImagem.getTipoDocumento().getCodigo();
		}
		if (documentoImagem.getServidor().getSiape() != null
				&& documentoImagem.getServidor().getSiape() != 0) {
			sql += " and di.servidor.siape = "
					+ documentoImagem.getServidor().getSiape();
		}
		if (documentoImagem.getServidor().getNome() != null
				&& documentoImagem.getServidor().getNome() != "") {
			sql += " and di.servidor.nome like '%"
					+ documentoImagem.getServidor().getNome() + "%'";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<DocumentoImagem>) query.setMaxResults(
				Constantes.RETORNO_MAXIMO_DOCUMENTOS_IMAGENS_NAO_VALIDADOS)
				.list();
	}
}