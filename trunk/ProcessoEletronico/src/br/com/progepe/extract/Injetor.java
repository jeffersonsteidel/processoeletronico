package br.com.progepe.extract;

import java.util.List;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.EstadoDAO;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Classe;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.EstadoCivil;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.RegimeTrabalho;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SituacaoFuncional;
import br.com.progepe.validator.Validator;

public class Injetor {

	public void popularDados() throws Exception {
		Extrator injetorDados = new Extrator();
		injetorDados.carregarDados();
		DAO dao = new DAO();
		CidadeDAO cidadeDAO = new CidadeDAO();
		EstadoDAO estadoDAO = new EstadoDAO();
		@SuppressWarnings("unchecked")
		List<Padrao> padraoList = dao.list(Padrao.class, "nivel");

		for (DadosFitaEspelho dadosFitaEspelho : injetorDados
				.getDadosFitaEspelhoList()) {

			Servidor servidor = new Servidor();
			servidor.setContaBancaria(new ContaBancaria());
			servidor.getContaBancaria().setBanco(new Banco());
			servidor.setDocumento(new Documento());
			servidor.setEndereco(new Endereco());
			servidor.setCargo(new Cargo());
			servidor.getCargo().setClasse(new Classe());
			// servidor.getEndereco().setCidade(new Cidade());
			// servidor.getEndereco().getCidade().setEstado(new Estado());
			servidor.setEstadoCivil(new EstadoCivil());
			servidor.setLotacao(new Lotacao());
			servidor.getLotacao().setEndereco(new Endereco());
			// servidor.getLotacao().getEndereco().setCidade(new Cidade());
			// servidor.getLotacao().getEndereco().getCidade()
			// .setEstado(new Estado());
			servidor.setLocalExercicio(new Lotacao());
			servidor.getLocalExercicio().setEndereco(new Endereco());
			// servidor.getLocalExercicio().getEndereco().setCidade(new
			// Cidade());
			// servidor.getLocalExercicio().getEndereco().getCidade()
			// .setEstado(new Estado());
			servidor.setRegimeTrabalho(new RegimeTrabalho());
			servidor.setSituacaoFuncional(new SituacaoFuncional());

			servidor.setSiape(dadosFitaEspelho.getMatriculaSiape());
			servidor.setIdentificacaoUnica(dadosFitaEspelho.getMatriculaSiape()
					+ "-" + dadosFitaEspelho.getDvMatricula());
			servidor.setNome(dadosFitaEspelho.getNomeServidor());
			servidor.getDocumento().setCpf(
					Validator.formatarCpf(dadosFitaEspelho.getCpf()));
			servidor.getDocumento().setPis(
					Validator.formatarPis(dadosFitaEspelho.getPisPasef()));
			servidor.setNomeMae(dadosFitaEspelho.getNomeMae());
			servidor.setSexo(dadosFitaEspelho.getSexo());
			servidor.getRegimeTrabalho().setCodigo(
					new Long(dadosFitaEspelho.getJornadaDeTrabalho()));
			servidor.setDataNascimento(Validator
					.formatarDataBR(dadosFitaEspelho.getDataNascimento()));
			servidor.getEstadoCivil().setCodigo(
					new Long(dadosFitaEspelho.getEstadoCivil()));
			servidor.getDocumento().setDataPrimeiroEmprego(
					Validator.formatarDataBR(dadosFitaEspelho
							.getDataPrimeiroEmprego()));
			servidor.getEndereco().setRua(dadosFitaEspelho.getLogradouro());
			servidor.getEndereco().setNumero(
					dadosFitaEspelho.getNumeroEndereco());
			servidor.getEndereco().setComplemento(
					dadosFitaEspelho.getComplementoEndereco());
			servidor.getEndereco().setBairro(dadosFitaEspelho.getBairro());
			servidor.getEndereco().setCep(
					Validator.formatarCep(dadosFitaEspelho.getCep()));

			// Cidade cidade = cidadeDAO.listByNome(dadosFitaEspelho
			// .getMunicipio().toUpperCase().trim());
			// servidor.getEndereco().setCidade(cidade);
			// servidor.getEndereco().getCidade()
			// .setEstado(cidade.getEstado());
			servidor.getDocumento().setRg(
					dadosFitaEspelho.getNumeroRegistroGeral());
			servidor.getDocumento().setRgOrgaoEmissor(
					dadosFitaEspelho.getSiglaOrgaoExpedidor());
			servidor.getDocumento().setRgDataExpedicao(
					Validator.formatarDataBR(dadosFitaEspelho
							.getDataExpedicaoIdentidade()));

			servidor.getSituacaoFuncional().setCodigo(
					new Long(dadosFitaEspelho.getCodigoSituacaoServidor()));
			servidor.getDocumento().setCarteiraTrabalho(
					dadosFitaEspelho.getNumeroCarteiraDeTrabalho().toString());
			servidor.getDocumento().setCarteiraSerie(
					dadosFitaEspelho.getSerieCarteiraDeTrabalho());

//			Estado estado = estadoDAO.listByUf(dadosFitaEspelho
//					.getUfCarteiraDeTrabalho().toUpperCase().trim());
//			servidor.getDocumento().setCarteiraUf(estado);
//			servidor.getDocumento().setRgUf(estado);
			// servidor.getDocumento().setTituloUf(estado);

			if(servidor.getSiape().equals(1216159)){
				servidor.getContaBancaria().setBanco(null);
			}else{
			servidor.getContaBancaria().getBanco()
					.setCodigo(new Long(dadosFitaEspelho.getCodigoBanco()));
			}
			servidor.getContaBancaria().setAgencia(
					dadosFitaEspelho.getAgenciaBanco());
			servidor.getContaBancaria().setNumeroConta(
					dadosFitaEspelho.getContaCorrenteBanco());
			if(!servidor.getSiape().equals(6393047) ){
				if(!servidor.getSiape().equals(7343463)){
			
			if(dadosFitaEspelho.getCodigoGrupoCargo().equals(701)){
				Cargo cargo = new Cargo();
				cargo.setClasse(new Classe());
				cargo.setCodigo(new Long(dadosFitaEspelho.getCodigoCargo()));
				dao.refresh(cargo);
				servidor.setCargo(cargo);
			}else if(dadosFitaEspelho.getCodigoGrupoCargo().equals(702)){
				Cargo cargo = new Cargo();
				cargo.setClasse(new Classe());
				cargo.setCodigo(new Long(dadosFitaEspelho.getCodigoCargo()+702000));
				dao.refresh(cargo);
				servidor.setCargo(cargo);
			}else if(dadosFitaEspelho.getCodigoGrupoCargo().equals(60)){
				Cargo cargo = new Cargo();
				cargo.setClasse(new Classe());
				cargo.setCodigo(new Long(dadosFitaEspelho.getCodigoCargo()+60000));
				dao.refresh(cargo);
				servidor.setCargo(cargo);
			}else{
				Cargo cargo = new Cargo();
				cargo.setClasse(new Classe());
				servidor.getCargo().setCodigo(null);
				servidor.getCargo().getClasse().setCodigo(null);
			}}}

			for (Padrao item : padraoList) {
				if (item.getNivel().toString().equals(
						dadosFitaEspelho.getCodigoReferenciaNivelPadraoCargo())) {
					servidor.setPadrao(new Padrao());
					servidor.getPadrao().setCodigo(
							new Long(item.getCodigo()));
					break;
				}else{
					servidor.setPadrao(null);
				}
			}

			servidor.setDataAdmissao(Validator.formatarDataBR(dadosFitaEspelho
					.getDataEntradaOcupacaoCargo()));
			servidor.setDataSaida(Validator.formatarDataBR(dadosFitaEspelho
					.getDataSaidaCargo()));
			Long codigoLotacao = new Long(
					dadosFitaEspelho.getCodigoUnidadeOrganizacionalLotacao());
			if (codigoLotacao != null && codigoLotacao != 0) {
				servidor.getLotacao().setCodigo(codigoLotacao);
				// servidor.getLotacao().getEndereco().setCodigo(9L);
				// servidor.getLotacao().getEndereco().setCidade(cidade);
				// servidor.getLotacao().getEndereco().getCidade()
				// .setEstado(cidade.getEstado());
				servidor.getLocalExercicio().setCodigo(codigoLotacao);
				// servidor.getLocalExercicio().getEndereco().setCodigo(2L);
				// servidor.getLocalExercicio().getEndereco()
				// .setCidade(cidade);
				// servidor.getLocalExercicio().getEndereco().getCidade()
				// .setEstado(cidade.getEstado());
			} else {
				servidor.getLotacao().setCodigo(null);
				servidor.getLocalExercicio().setCodigo(null);
			}

			try {
				dao.saveFitaEspelho(servidor);
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Injetor injetorDados = new Injetor();
		injetorDados.popularDados();
	}

}
