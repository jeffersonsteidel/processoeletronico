package br.com.progepe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Servidor;

public class ServidorDAO extends DAO {

	private static ServidorDAO instance;

	private ServidorDAO() {
	}

	public static ServidorDAO getInstance() {
		if (instance == null) {
			instance = new ServidorDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Servidor> listByFilter(Servidor servidor, Integer situacao) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Servidor.class);
		if (servidor.getSiape() != null && servidor.getSiape() != 0) {
			c.add(Restrictions.eq("siape", servidor.getSiape()));
		}

		if (servidor.getLotacao().getCodigo() != 0) {
			c.add(Restrictions.eq("lotacao", servidor.getLotacao()));
		}

		if (servidor.getNome() != null && servidor.getNome() != "") {
			c.add(Restrictions.like("nome", servidor.getNome().toUpperCase(),
					MatchMode.ANYWHERE));
		}

		if (servidor.getCargo().getCodigo() != 0) {
			c.add(Restrictions.eq("cargo", servidor.getCargo()));
		}

		if (situacao != null && Constantes.ATIVO.equals(situacao)) {
			c.add(Restrictions.isNull("dataSaida"));
		}
		if (situacao != null && Constantes.DESATIVO.equals(situacao)) {
			c.add(Restrictions.isNotNull("dataSaida"));
		}
		HibernateUtility.commitTransaction();
		return c.list();
	}

	public Servidor refreshBySiape(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession().createCriteria(
				Servidor.class);
		if (servidor.getSiape() != null && servidor.getSiape() != 0) {
			c.add(Restrictions.like("siape", servidor.getSiape()));
		}
		HibernateUtility.commitTransaction();
		Servidor servidorTemp = new Servidor();
		servidorTemp = (Servidor) c.uniqueResult();
		if (servidorTemp == null) {
			return null;
		} else {
			return servidorTemp;
		}
	}

	public Servidor refreshByFilter(Servidor servidor) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();

		Criteria c = HibernateUtility.getSession().createCriteria(
				Servidor.class);
		if (servidor.getSiape() != null && servidor.getSiape() != 0) {
			c.add(Restrictions.like("siape", servidor.getSiape()));
		}

		if (servidor.getNome() != null && servidor.getNome() != "") {
			c.add(Restrictions.like("nome", servidor.getNome().toUpperCase(),
					MatchMode.ANYWHERE));
		}
		HibernateUtility.commitTransaction();
		return (Servidor) c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Servidor> listTecnicosByCampus(Lotacao lotacao) {
		Cargo cargo = new Cargo();
		cargo.setCodigo(Constantes.CODIGO_LIMITE_TECNICO);
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from Servidor s where s.lotacao = :codigoLotacao and s.cargo < :codigoCargo and s.dataSaida is null order by s.nome");
		query.setParameter("codigoLotacao", lotacao);
		query.setParameter("codigoCargo", cargo);
		HibernateUtility.commitTransaction();
		return (List<Servidor>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Servidor> listDocentesByCampus(Lotacao lotacao) {
		Cargo cargo = new Cargo();
		cargo.setCodigo(Constantes.CODIGO_LIMITE_TECNICO);
		Cargo cargoEstagiario = new Cargo();
		cargoEstagiario.setCodigo(Constantes.CARGO_ESTAGIARIO);
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from Servidor s where s.lotacao = :codigoLotacao and s.cargo > :codigoCargo and s.cargo <> :cargoEstagiario and s.dataSaida is null order by s.nome");
		query.setParameter("codigoLotacao", lotacao);
		query.setParameter("codigoCargo", cargo);
		query.setParameter("cargoEstagiario", cargoEstagiario);
		HibernateUtility.commitTransaction();
		return (List<Servidor>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Servidor> listAniversariantes(Integer mes) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from Servidor s where month(s.dataNascimento) = :mes and s.dataSaida is null order by day(s.dataNascimento)");
		query.setParameter("mes", mes);
		HibernateUtility.commitTransaction();
		return (List<Servidor>) query.list();
	}
}