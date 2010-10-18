package br.com.progepe.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.entity.Solicitacao;

public class SolicitacaoDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<Solicitacao> listByFilter(Solicitacao solicitacao, Date dataSolicitacaoInicial, Date dataSolicitacaoFinal) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Solicitacao.class);
		if (solicitacao.getSolicitante().getSiape() != null && solicitacao.getSolicitante().getSiape() != 0) {
			c.add(Restrictions.like("solitante", solicitacao.getSolicitante()));
		}
		if (dataSolicitacaoInicial!= null && dataSolicitacaoFinal!=null) {
			c.add(Restrictions.between("dataAbertura", dataSolicitacaoInicial,dataSolicitacaoFinal));
		}

		if (solicitacao.getStatusSolicitacao().getCodigo() != null) {
			c.add(Restrictions.like("statusSolicitacao", solicitacao.getStatusSolicitacao().getCodigo()));
		}
		
		if (solicitacao.getTipoSolicitacao().getCodigo()!= null) {
			c.add(Restrictions.like("tipoSolicitacao", solicitacao.getCodigo()));
		}
		
		return c.list();
	}

} 