package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.constantes.Constantes;
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
		sql = "from DocumentoImagem di where 1= 1 ";
		if (documentoImagem.getTipoDocumento().getCodigo() !=  null && documentoImagem.getTipoDocumento().getCodigo() != 0) {
			sql += " and di.tipoDocumento.codigo =" +documentoImagem.getTipoDocumento().getCodigo();
		}
		if (titularDocumento == 1) {
			sql += " and di.servidor.siape = "+ documentoImagem.getServidor().getSiape();
		}
		if (titularDocumento == 2) {
			sql += "and di.conjuge.servidor.siape ="+ documentoImagem.getServidor().getSiape();
		}
		if (titularDocumento == 3) {
			sql += "and di.dependente.servidor.siape =" + documentoImagem.getServidor().getSiape();
		}
		if(documentoImagem.getIndValidado()){
			sql += "and di.indValidado = 1";
		}
		if(!documentoImagem.getIndValidado()){
			sql += "and di.indValidado = 0";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		if(!documentoImagem.getIndValidado()){
			return (List<DocumentoImagem>) query.setMaxResults(Constantes.RETORNO_MAXIMO_DOCUMENTOS_IMAGENS_NAO_VALIDADOS).list();
		}
		return (List<DocumentoImagem>) query.list();
	}
}