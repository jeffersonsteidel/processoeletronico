package br.com.progepe.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;

import br.com.progepe.entity.AdicionalNoturno;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.SolicitacaoAdicionalNoturno;
import br.com.progepe.entity.SolicitacaoAfastamentoConjuge;
import br.com.progepe.entity.SolicitacaoAlimentacao;
import br.com.progepe.entity.SolicitacaoCasamento;
import br.com.progepe.entity.SolicitacaoContaBancaria;
import br.com.progepe.entity.SolicitacaoHorarioEspecialEstudante;
import br.com.progepe.entity.SolicitacaoLicencaPaternidade;
import br.com.progepe.entity.SolicitacaoObito;

public class AdicionalNoturnoDAO extends DAO {

	private static AdicionalNoturnoDAO instance;
	private AdicionalNoturnoDAO(){}
	
	
	public static AdicionalNoturnoDAO getInstance(){
		if(instance == null){
			instance = new AdicionalNoturnoDAO();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public List<AdicionalNoturno> listByFilter(Lotacao lotacao) {
		HibernateUtility.getSession().clear();

		Criteria c = HibernateUtility.getSession().createCriteria(
				SolicitacaoAdicionalNoturno.class);
//		if (solicitacao.getServidor().getNome() != null
//				&& solicitacao.getServidor().getNome() != "") {
//			c.add(Restrictions.like("servidor", solicitacao.getServidor()));
//		}
//		if (dataSolicitacaoInicial != null && dataSolicitacaoFinal != null) {
//			c.add(Restrictions.between("dataAbertura", dataSolicitacaoInicial,
//					dataSolicitacaoFinal));
//		}
//
//		if (solicitacao.getStatusSolicitacao().getCodigo() != null
//				&& solicitacao.getStatusSolicitacao().getCodigo() != 0) {
//			c.add(Restrictions.like("statusSolicitacao",
//					solicitacao.getStatusSolicitacao()));
//		}
//
//		if (solicitacao.getTipoSolicitacao().getCodigo() != null
//				&& solicitacao.getTipoSolicitacao().getCodigo() != 0) {
//			c.add(Restrictions.like("tipoSolicitacao",
//					solicitacao.getTipoSolicitacao()));
//		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	public SolicitacaoContaBancaria carregarSoliciacaoContaBancaria(Long codigo) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from SolicitacaoContaBancaria  s where s.codigo= :codigo");
		query.setParameter("codigo", codigo);
		HibernateUtility.commitTransaction();
		return (SolicitacaoContaBancaria) query.uniqueResult();
	}
	
	public SolicitacaoCasamento carregarSolicitacaoCasamento(Long codigo) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from SolicitacaoCasamento  s where s.codigo= :codigo");
		query.setParameter("codigo", codigo);
		HibernateUtility.commitTransaction();
		return (SolicitacaoCasamento) query.uniqueResult();
	}
	
	public SolicitacaoAlimentacao carregarSolicitacaoAlimentacao(Long codigo) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from SolicitacaoAlimentacao  s where s.codigo= :codigo");
		query.setParameter("codigo", codigo);
		HibernateUtility.commitTransaction();
		return (SolicitacaoAlimentacao) query.uniqueResult();
	}

	public SolicitacaoLicencaPaternidade carregarSolicitacaoLicencaPaternidade(
			Long codigo) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from SolicitacaoLicencaPaternidade s where s.codigo= :codigo");
		query.setParameter("codigo", codigo);
		HibernateUtility.commitTransaction();
		return (SolicitacaoLicencaPaternidade) query.uniqueResult();
	}
	
	public SolicitacaoAfastamentoConjuge carregarSolicitacaoAfastamentoConjuge(
			Long codigo) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from SolicitacaoAfastamentoConjuge s where s.codigo= :codigo");
		query.setParameter("codigo", codigo);
		HibernateUtility.commitTransaction();
		return (SolicitacaoAfastamentoConjuge) query.uniqueResult();
	}
	
	
	public SolicitacaoHorarioEspecialEstudante carregarSolicitacaoHorarioEspecialEstudante(
			Long codigo) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from SolicitacaoHorarioEspecialEstudante s where s.codigo= :codigo");
		query.setParameter("codigo", codigo);
		HibernateUtility.commitTransaction();
		return (SolicitacaoHorarioEspecialEstudante) query.uniqueResult();
	}
	
	public SolicitacaoObito carregarSolicitacaoObito(
			Long codigo) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from SolicitacaoObito s where s.codigo= :codigo");
		query.setParameter("codigo", codigo);
		HibernateUtility.commitTransaction();
		return (SolicitacaoObito) query.uniqueResult();
	}
	
	public void updateSolicitacao(Object objeto) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.getSession().saveOrUpdate(objeto);
			HibernateUtility.commitTransaction();
		} catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}
}