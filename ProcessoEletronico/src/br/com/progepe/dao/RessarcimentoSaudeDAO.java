package br.com.progepe.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;

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
	public List<Dependente> listarDependentePorServidor(
			Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Dependente d LEFT JOIN FETCH d.servidor s WHERE s.siape = "
				+ servidor.getSiape();
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Dependente>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Conjuge> listarConjugePorServidor(
			Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		String sql = "from Conjuge c LEFT JOIN FETCH c.servidor s WHERE s.siape = "
				+ servidor.getSiape();
		Query query = HibernateUtility.getSession().createQuery(sql);
		HibernateUtility.commitTransaction();
		return (List<Conjuge>) query.list();
	}

	
	public void saveRessarcimentoSaude(RessarcimentoSaude ressarcimentoSaude,
			List<RessarcimentoSaudeContrato> list) {
		try {
			HibernateUtility.getSession().clear();
			HibernateUtility.beginTransaction();
			HibernateUtility.getSession().save(ressarcimentoSaude);
			ressarcimentoSaude = (RessarcimentoSaude) DAO.getInstance()
					.refresh(ressarcimentoSaude);
			for (RessarcimentoSaudeContrato ressarcimentoSaudeContrato : list) {
				ressarcimentoSaudeContrato
						.setRessarcimentoSaude(ressarcimentoSaude);
				HibernateUtility.getSession().save(ressarcimentoSaudeContrato);
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
}