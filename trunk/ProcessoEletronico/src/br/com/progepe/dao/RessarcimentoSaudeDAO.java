package br.com.progepe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.RessarcimentoSaude;
import br.com.progepe.entity.RessarcimentoSaudeContrato;
import br.com.progepe.entity.Servidor;

public class RessarcimentoSaudeDAO extends DAO {

	private static RessarcimentoSaudeDAO instance;

	private RessarcimentoSaudeDAO() {
	}

	public static RessarcimentoSaudeDAO getInstance() {
		if (instance == null) {
			instance = new RessarcimentoSaudeDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listarDependentePorServidor(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Dependente d LEFT JOIN FETCH d.servidor s WHERE s.siape = "
				+ servidor.getSiape();
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Dependente>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Conjuge> listarConjugePorServidor(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Conjuge c LEFT JOIN FETCH c.servidor s WHERE s.siape = "
				+ servidor.getSiape();
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Conjuge>) query.list();
	}

	public void saveRessarcimentoSaude(RessarcimentoSaude ressarcimentoSaude,
			List<Dependente> dependentes, List<Conjuge> conjuges) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().saveOrUpdate(ressarcimentoSaude);
			for (Conjuge conjuge : conjuges) {
				HibernateUtility.getSession().update(conjuge);
			}
			for (Dependente dependente : dependentes) {
				HibernateUtility.getSession().update(dependente);
			}
			for (RessarcimentoSaudeContrato contrato : ressarcimentoSaude
					.getFiles()) {
				contrato.setServidor(ressarcimentoSaude.getServidor());
				HibernateUtility.getSession().saveOrUpdate(contrato);
			}
			HibernateUtility.commitTransaction();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Item salvo com sucesso!", "Item salvo com sucesso!");
			FacesContext.getCurrentInstance().addMessage("", message);
		} catch (Exception e) {
			HibernateUtility.rollbackTransaction();
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Erro ao comunicar com o servidor!",
					"Erro ao comunicar com o servidor!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}

	@SuppressWarnings("unchecked")
	public List<RessarcimentoSaude> listByFilter(
			RessarcimentoSaude ressarcimentoSaude, Integer implantado) {
		HibernateUtility.getSession().clear();
		String sql;
		sql = "from RessarcimentoSaude rs where 1= 1 ";
		if (ressarcimentoSaude.getTipoPlano().getCodigo() != null
				&& ressarcimentoSaude.getTipoPlano().getCodigo() != 0) {
			sql += " and rs.tipoPlano.codigo ="
					+ ressarcimentoSaude.getTipoPlano().getCodigo();
		}
		if (ressarcimentoSaude.getServidor() != null
				&& ressarcimentoSaude.getServidor().getSiape() != 0) {
			sql += " and rs.servidor.siape = "
					+ ressarcimentoSaude.getServidor().getSiape();
		}
		if (implantado == 1) {
			sql += "and rs.indImplantado = 1";
		}
		if (implantado == 2) {
			sql += "and rs.indImplantado = 0";
		}
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		if (Constantes.NAO.equals(implantado)) {
			return (List<RessarcimentoSaude>) query
					.setMaxResults(
							Constantes.RETORNO_MAXIMO_RESSARCIMENTOS_SAUDE_NAO_VALIDADOS)
					.list();
		}
		return (List<RessarcimentoSaude>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<RessarcimentoSaudeContrato> getContratos(RessarcimentoSaude ressarcimentoSaude){
		HibernateUtility.getSession().clear();
		String sql;
		sql = "from RessarcimentoSaudeContrato c where c.servidor.siape = "+ ressarcimentoSaude.getServidor().getSiape();
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (ArrayList<RessarcimentoSaudeContrato>) query.list();
	}
}