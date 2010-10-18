package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Solicitacao;

public class SolicitacaoDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<Solicitacao> listByFilter(Solicitacao solicitacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Solicitacao.class);
		if (solicitacao.getSolicitante().getSiape() != null && solicitacao.getSolicitante().getSiape() != 0) {
			c.add(Restrictions.like("siape", solicitacao.getSolicitante().getSiape()));
		}

		if (solicitacao.getSolicitante().getNome() != null && solicitacao.getSolicitante().getNome() != "") {
			c.add(Restrictions.like("nome", solicitacao.getSolicitante().getNome().toUpperCase(),
					MatchMode.ANYWHERE));
		}
		if (solicitacao.getDataAbertura()!= null && solicitacao.getDataFechamento()!=null) {
			c.add(Restrictions.between("datas", solicitacao.getDataAbertura(),solicitacao.getDataFechamento()));
		}

		if (solicitacao.getStatusSolicitacao().getDescricao()!= null && solicitacao.getStatusSolicitacao().getDescricao() != "") {
			c.add(Restrictions.like("status", solicitacao.getStatusSolicitacao().getDescricao().toUpperCase(),
					MatchMode.ANYWHERE));
		}
		
		if (solicitacao.getTipoSolicitacao().getDescricao()!= null && solicitacao.getTipoSolicitacao().getDescricao()!= "") {
			c.add(Restrictions.like("tipoSolicitacao", solicitacao.getTipoSolicitacao().getDescricao().toUpperCase(),
					MatchMode.ANYWHERE));
		}
		
		return c.list();
	}

	public Solicitacao refreshBySiape(Solicitacao solicitacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(Solicitacao.class);
		if (solicitacao.getSolicitante().getSiape() != null && solicitacao.getSolicitante().getSiape() != 0 ){
			c.add(Restrictions.like("siape", solicitacao.getSolicitante().getSiape()));
		}
		return (Solicitacao) c.uniqueResult();
	}
	
} 