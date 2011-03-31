package br.com.progepe.extract;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.CorPele;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.EstadoCivil;
import br.com.progepe.entity.GrupoSanguineo;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.Pais;
import br.com.progepe.entity.RegimeTrabalho;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SituacaoFuncional;
import br.com.progepe.validator.Validator;

public class Injetor {

	public void popularDados() throws Exception {
		Extrator injetorDados = new Extrator();
		injetorDados.carregarDados();

		for (DadosFitaEspelho dadosFitaEspelho : injetorDados
				.getDadosFitaEspelhoList()) {

			Servidor servidor = new Servidor();
			servidor.setCargo(new Cargo());
			servidor.setEstadoNascimento(new Estado());
			servidor.setContaBancaria(new ContaBancaria());
			servidor.getContaBancaria().setBanco(new Banco());
			servidor.setCorPele(new CorPele());
			servidor.setDocumento(new Documento());
//			servidor.getDocumento().setCarteiraUf(new Estado());
//			servidor.getDocumento().setRgUf(new Estado());
//			servidor.getDocumento().setTituloUf(new Estado());
			servidor.setEndereco(new Endereco());
			servidor.getEndereco().setCidade(new Cidade());
			servidor.getEndereco().getCidade().setEstado(new Estado());
			servidor.setEstadoCivil(new EstadoCivil());
//			servidor.setFuncao(new Funcao());
//			servidor.getFuncao().setTipoFuncao(new TipoFuncao());
			servidor.setGrupoSanguineo(new GrupoSanguineo());
			servidor.setLotacao(new Lotacao());
//			servidor.setLocalExercicio(new Lotacao());
			servidor.setEndereco(new Endereco());
			servidor.getEndereco().setCidade(new Cidade());
			servidor.getEndereco().getCidade().setEstado(new Estado());
			servidor.setPadrao(new Padrao());
			servidor.setRegimeTrabalho(new RegimeTrabalho());
			servidor.setSituacaoFuncional(new SituacaoFuncional());
			servidor.setPais(new Pais());
		
			servidor.setSiape(dadosFitaEspelho.getMatriculaSiape());
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
			
			servidor.setCidadeNascimento(5915L);
				
			servidor.getEndereco().getCidade().setCodigo(5915L);
			servidor.getEndereco().getCidade().getEstado().setCodigo(18L);
			
//			servidor.getDocumento().getCarteiraUf().setCodigo(18L);
//			servidor.getDocumento().getRgUf().setCodigo(18L);
//			servidor.getDocumento().getTituloUf().setCodigo(18L);
			
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
			if (servidor.getSiape().equals(1216159)) {
				servidor.getContaBancaria().getBanco().setCodigo(1L);
			} else {
				servidor.getContaBancaria().getBanco()
						.setCodigo(new Long(dadosFitaEspelho.getCodigoBanco()));
			}
			servidor.getContaBancaria().setAgencia(
					dadosFitaEspelho.getAgenciaBanco());
			servidor.getContaBancaria().setNumeroConta(
					dadosFitaEspelho.getContaCorrenteBanco());
			servidor.setDataAdmissao(Validator.formatarDataBR(dadosFitaEspelho
					.getDataEntradaOcupacaoCargo()));
			servidor.setDataAdmServicoPublico(Validator.formatarDataBR(dadosFitaEspelho
					.getDataIngressoServPublico()));
//			if(dadosFitaEspelho
//					.getDataSaidaCargo().equals("00000000")){
//				servidor.setDataSaida(Validator.formatarDataBR(dadosFitaEspelho
//					.getDataSaidaCargo()));
//			}
			Long codigoLotacao = new Long(
					dadosFitaEspelho.getCodigoUnidadeOrganizacionalLotacao());
			if (codigoLotacao != null && codigoLotacao != 0) {
				servidor.getLotacao().setCodigo(codigoLotacao);
//				servidor.getLocalExercicio().setCodigo(codigoLotacao);
			} else {
				servidor.getLotacao().setCodigo(12L);
//				servidor.getLocalExercicio().setCodigo(12L);
			}
			servidor.getPadrao().setCodigo(69L);
			servidor.getGrupoSanguineo().setCodigo(7L);
			servidor.getEstadoCivil().setCodigo(new Long(dadosFitaEspelho.getEstadoCivil()));
			servidor.getCorPele().setCodigo(1L);
			servidor.getCargo().setCodigo(1L);
			servidor.getPais().setCodigo(24L);
			try{
			if(servidor.getSiape() == 1363512 ||
			   servidor.getSiape() == 1454260 ||
			   servidor.getSiape() == 1614670 ||
			   servidor.getSiape() == 1761375 ||
			   servidor.getSiape() == 1847355 ||
			   servidor.getSiape() == 1847537 ||
			   servidor.getSiape() == 1848347 ||
			   servidor.getSiape() == 1848826 ||
			   servidor.getSiape() == 1849535 ||
			   servidor.getSiape() == 1849913 ||
			   servidor.getSiape() == 1849966 ||
			   servidor.getSiape() == 1850177 ||
			   servidor.getSiape() == 1850198 ||
			   servidor.getSiape() == 1850462 ||
			   servidor.getSiape() == 1850555 ||
			   servidor.getSiape() == 1850661 ||
			   servidor.getSiape() == 1850711 ||
			   servidor.getSiape() == 1850773 ||
			   servidor.getSiape() == 1850832 ||
			   servidor.getSiape() == 1850866 ||
			   servidor.getSiape() == 1850889 ||
			   servidor.getSiape() == 1850972 ||
			   servidor.getSiape() == 1851002 ||
			   servidor.getSiape() == 1851024 ||
			   servidor.getSiape() == 1851056 ||
			   servidor.getSiape() == 1851088 ||
			   servidor.getSiape() == 1851144 ||
			   servidor.getSiape() == 1851483 ||
			   servidor.getSiape() == 1852292 ||
			   servidor.getSiape() == 1852328 ||
			   servidor.getSiape() == 1853828 ||
			   servidor.getSiape() == 2814807){
				DAO.getInstance().saveFitaEspelho(servidor);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Injetor injetorDados = new Injetor();
		injetorDados.popularDados();
	}

}
