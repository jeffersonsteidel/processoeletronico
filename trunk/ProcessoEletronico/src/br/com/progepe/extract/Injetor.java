package br.com.progepe.extract;

import java.text.ParseException;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.EstadoDAO;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.EstadoCivil;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.RegimeTrabalho;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SituacaoFuncional;
import br.com.progepe.validator.Validator;

public class Injetor {

	public void popularDados() throws ParseException {
		Extrator injetorDados = new Extrator();
		injetorDados.carregarDados();
		DAO dao = new DAO();
		CidadeDAO cidadeDAO = new CidadeDAO();
		EstadoDAO estadoDAO = new EstadoDAO();

		for (DadosFitaEspelho dadosFitaEspelho : injetorDados
				.getDadosFitaEspelhoList()) {

			Servidor servidor = new Servidor();
		//	servidor.setCargo(new Cargo());
			servidor.setContaBancaria(new ContaBancaria());
			servidor.getContaBancaria().setBanco(new Banco());
			servidor.setDocumento(new Documento());
			servidor.setEndereco(new Endereco());
			servidor.getEndereco().setCidade(new Cidade());
			servidor.getEndereco().getCidade().setEstado(new Estado());
			servidor.setEstadoCivil(new EstadoCivil());
			servidor.setLotacao(new Lotacao());
			servidor.getLotacao().setEndereco(new Endereco());
			servidor.getLotacao().getEndereco().setCidade(new Cidade());
			servidor.getLotacao().getEndereco().getCidade().setEstado(new Estado());
			servidor.setLocalExercicio(new Lotacao());
			servidor.getLocalExercicio().setEndereco(new Endereco());
			servidor.getLocalExercicio().getEndereco().setCidade(new Cidade());
			servidor.getLocalExercicio().getEndereco().getCidade().setEstado(new Estado());
		//	servidor.setPadrao(new Padrao());
			servidor.setRegimeTrabalho(new RegimeTrabalho());
			servidor.setSituacaoFuncional(new SituacaoFuncional());

			servidor.setSiape(dadosFitaEspelho.getMatriculaSiape());
			if(servidor.getSiape().equals(1760205)){
			servidor.setIdentificacaoUnica(dadosFitaEspelho.getMatriculaSiape()
					+ "-" + dadosFitaEspelho.getDvMatricula());
			servidor.setNome(dadosFitaEspelho.getNomeServidor());
			servidor.getDocumento().setCpf(
					Validator.formatarCpf(dadosFitaEspelho.getCpf()));
			servidor.getDocumento().setPis(
					Validator.formatarPis(dadosFitaEspelho.getPisPasef()));
			servidor.setNomeMae(dadosFitaEspelho.getNomeMae());
			servidor.setSexo(dadosFitaEspelho.getSexo());
			servidor.getRegimeTrabalho().setCodigo(new Long (dadosFitaEspelho.getJornadaDeTrabalho()));
			servidor.setDataNascimento(Validator
					.formatarDataBR(dadosFitaEspelho.getDataNascimento()));
			servidor.getEstadoCivil().setCodigo(
					new Long(dadosFitaEspelho.getEstadoCivil()));
			servidor.getDocumento().setDataPrimeiroEmprego(Validator.formatarDataBR(dadosFitaEspelho
							.getDataPrimeiroEmprego()));
			servidor.getEndereco().setRua(dadosFitaEspelho.getLogradouro());
			servidor.getEndereco().setNumero(
					dadosFitaEspelho.getNumeroEndereco());
			servidor.getEndereco().setComplemento(
					dadosFitaEspelho.getComplementoEndereco());
			servidor.getEndereco().setBairro(dadosFitaEspelho.getBairro());
			servidor.getEndereco().setCep(
					Validator.formatarCep(dadosFitaEspelho.getCep()));
			

			Cidade cidade = cidadeDAO.listByNome(dadosFitaEspelho
					.getMunicipio().toUpperCase().trim());
			servidor.getEndereco().setCidade(cidade);
			servidor.getEndereco().getCidade().setEstado(cidade.getEstado());
			servidor.getDocumento().setRg(dadosFitaEspelho.getNumeroRegistroGeral());
			servidor.getDocumento().setRgOrgaoEmissor(
					dadosFitaEspelho.getSiglaOrgaoExpedidor());
			servidor.getDocumento().setRgDataExpedicao(Validator.formatarDataBR(dadosFitaEspelho
							.getDataExpedicaoIdentidade()));

			servidor.getSituacaoFuncional().setCodigo(
					new Long(dadosFitaEspelho.getCodigoSituacaoServidor()));
			servidor.getDocumento().setCarteiraTrabalho(
					dadosFitaEspelho.getNumeroCarteiraDeTrabalho().toString());
			servidor.getDocumento().setCarteiraSerie(
					dadosFitaEspelho.getSerieCarteiraDeTrabalho());

			Estado estado = estadoDAO.listByUf(dadosFitaEspelho
					.getUfCarteiraDeTrabalho().toUpperCase().trim());
			servidor.getDocumento().setCarteiraUf(estado);
			servidor.getDocumento().setRgUf(estado);
			servidor.getDocumento().setTituloUf(estado);

			servidor.getContaBancaria().getBanco()
					.setCodigo(new Long(dadosFitaEspelho.getCodigoBanco()));
			servidor.getContaBancaria().setAgencia(dadosFitaEspelho.getAgenciaBanco());
			servidor.getContaBancaria().setNumeroConta(
					dadosFitaEspelho.getContaCorrenteBanco());
//			servidor.getCargo().setCodigo(new Long(dadosFitaEspelho.getCodigoCargo()));
//			servidor.getPadrao().setCodigo(
//					new Long(dadosFitaEspelho.getCodigoReferenciaNivelPadraoCargo()));
			servidor.setDataAdmissao(Validator.formatarDataBR(dadosFitaEspelho
					.getDataEntradaOcupacaoCargo()));
			servidor.setDataSaida(Validator.formatarDataBR(dadosFitaEspelho
					.getDataSaidaCargo()));
			Long codigoLotacao = new Long(
					dadosFitaEspelho.getCodigoUnidadeOrganizacionalLotacao());
			if (codigoLotacao != null && codigoLotacao != 0) {
				servidor.getLotacao().setCodigo(codigoLotacao);
				servidor.getLotacao().getEndereco().setCodigo(9L);
				servidor.getLotacao().getEndereco().setCidade(cidade);
 				servidor.getLotacao().getEndereco().getCidade()
						.setEstado(cidade.getEstado());
				servidor.getLocalExercicio().setCodigo(codigoLotacao);
				servidor.getLocalExercicio().getEndereco().setCodigo(2L);
				servidor.getLocalExercicio().getEndereco().setCidade(cidade);
				servidor.getLocalExercicio().getEndereco().getCidade()
						.setEstado(cidade.getEstado());
			} else {
				servidor.getLotacao().setCodigo(3L);
				servidor.getLotacao().getEndereco().setCodigo(9L);
				servidor.getLotacao().getEndereco().setCidade(cidade);
 				servidor.getLotacao().getEndereco().getCidade()
						.setEstado(cidade.getEstado());
				servidor.getLocalExercicio().setCodigo(3L);
				servidor.getLocalExercicio().getEndereco().setCodigo(2L);
				servidor.getLocalExercicio().getEndereco().setCidade(cidade);
				servidor.getLocalExercicio().getEndereco().getCidade()
						.setEstado(cidade.getEstado());
			}
			
							dao.save(servidor);
				}
		}

	}

	public static void main(String[] args) throws ParseException {
		Injetor injetorDados = new Injetor();
		injetorDados.popularDados();
	}

}
