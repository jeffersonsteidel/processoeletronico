package br.com.progepe.extract;

import java.text.ParseException;
import java.util.Date;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.EstadoDAO;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.EstadoCivil;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SituacaoFuncional;
import br.com.progepe.validator.Validator;

public class Injetor {
	
	@SuppressWarnings({ "deprecation" })
	public void popularDados() throws ParseException{
		Extrator injetorDados = new Extrator();
		injetorDados.carregarDados();
		DAO dao = new DAO();
		CidadeDAO cidadeDAO = new CidadeDAO();
		EstadoDAO estadoDAO = new EstadoDAO();
		
		for (DadosPessoais pessoal : injetorDados.getDadosPessoaisList()) {
			Servidor servidor = new Servidor();
			servidor.setCargo(new Cargo());
			servidor.setContaBancaria(new ContaBancaria());
			servidor.getContaBancaria().setBanco(new Banco());
//			servidor.setDocumento(new Documento());
//			servidor.setEndereco(new Endereco());
//			servidor.getEndereco().setCidade(new Cidade());
//			servidor.getEndereco().getCidade().setEstado(new Estado());
			servidor.setEstadoCivil(new EstadoCivil());
		//	servidor.setLotacao(new Lotacao());
			servidor.setPadrao(new Padrao());
		//	servidor.setRegimeTrabalho(new RegimeTrabalho());
			servidor.setSituacaoFuncional(new SituacaoFuncional());
			
			servidor.setSiape(pessoal.getMatriculaSiape());
			servidor.setIdentificacaoUnica(pessoal.getMatriculaSiape() + "-" + pessoal.getDvMatricula());
			servidor.setNome(pessoal.getNomeServidor());
//			servidor.getDocumento().setCpf(Validator.formatarCpf(pessoal.getCpf()));
//			servidor.getDocumento().setPis(Validator.formatarPis(pessoal.getPisPasef()));
			servidor.setNomeMae(pessoal.getNomeMae());
			servidor.setSexo(pessoal.getSexo());	
			servidor.setDataNascimento(new Date(Validator.formatarData(pessoal.getDataNascimento())));
			servidor.getEstadoCivil().setCodigo(new Long (pessoal.getEstadoCivil()));
//			servidor.getDocumento().setDataPrimeiroEmprego(new Date(Validator.formatarData(pessoal.getDataPrimeiroEmprego())));
//			servidor.getEndereco().setRua(pessoal.getLogradouro());
//			servidor.getEndereco().setNumero(pessoal.getNumeroEndereco());
//			servidor.getEndereco().setComplemento(pessoal.getComplementoEndereco());
//			servidor.getEndereco().setBairro(pessoal.getBairro());
//			servidor.getEndereco().setCep(Validator.formatarCep(pessoal.getCep()));
			
//			Cidade cidade = cidadeDAO.listByNome(pessoal.getMunicipio().toUpperCase().trim());
//			servidor.getEndereco().setCidade(cidade);
//			servidor.getEndereco().getCidade().setEstado(cidade.getEstado());
//			servidor.getDocumento().setRg(pessoal.getNumeroRegistroGeral());
//			servidor.getDocumento().setRgOrgaoEmissor(pessoal.getSiglaOrgaoExpedidor());
//			servidor.getDocumento().setRgDataExpedicao(new Date(Validator.formatarData(pessoal.getDataExpedicaoIdentidade())));
			
			for (DadosFuncionais funcional : injetorDados.getDadosFuncionaisList()) {
				if(pessoal.getMatriculaSiape().equals(funcional.getMatriculaSiape())){
					servidor.getSituacaoFuncional().setCodigo(new Long(funcional.getCodigoSituacaoServidor()));
//					servidor.getDocumento().setCarteiraTrabalho(funcional.getNumeroCarteiraDeTrabalho().toString());
//					servidor.getDocumento().setCarteiraSerie(funcional.getSerieCarteiraDeTrabalho());
					
//					Estado estado = estadoDAO.listByUf(funcional.getUfCarteiraDeTrabalho().toUpperCase().trim());
//					servidor.getDocumento().setCarteiraUf(estado);
//					servidor.getDocumento().setRgUf(estado);
//					servidor.getDocumento().setTituloUf(estado);
					
					servidor.getContaBancaria().getBanco().setCodigo(new Long (funcional.getCodigoBanco()));
					servidor.getContaBancaria().setAgencia(funcional.getAgenciaBanco());
					servidor.getContaBancaria().setNumeroConta(funcional.getContaCorrenteBanco());
					servidor.getCargo().setCodigo(new Long (funcional.getCodigoCargo()));
					servidor.getPadrao().setCodigo(new Long (funcional.getCodigoReferenciaNivelPadraoCargo()));
					servidor.setDataAdmissao(new Date (Validator.formatarData(funcional.getDataEntradaOcupacaoCargo())));
					servidor.setDataSaida(new Date (Validator.formatarData(funcional.getDataSaidaCargo())));
					Long codigoLotacao = new Long(funcional.getCodigoUnidadeOrganizacionalLotacao());
					if(codigoLotacao != null && codigoLotacao != 0){
					//	servidor.getLotacao().setCodigo(codigoLotacao);
					}else{
//						servidor.getLotacao().setCodigo(3L);
//						servidor.getLotacao().getEndereco().setCodigo(2L);
//						servidor.getLotacao().getEndereco().setCidade(cidade);
//						servidor.getLotacao().getEndereco().getCidade().setEstado(cidade.getEstado());
//						servidor.getLocalExercicio().setCodigo(3L);
//						servidor.getLocalExercicio().getEndereco().setCodigo(2L);
//						servidor.getLocalExercicio().getEndereco().setCidade(cidade);
//						servidor.getLocalExercicio().getEndereco().getCidade().setEstado(cidade.getEstado());
					}
					dao.save(servidor);
					break;
				}
			}
		}
	
	}	
	public static void main(String[] args) throws ParseException {
		Injetor injetorDados = new Injetor();	
		injetorDados.popularDados();
	}

}
