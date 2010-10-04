package br.com.progepe.extract;

import java.text.ParseException;
import java.util.Date;

import br.com.progepe.dao.CidadeDAO;
import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Banco;
import br.com.progepe.entity.Cargo;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Classe;
import br.com.progepe.entity.ContaBancaria;
import br.com.progepe.entity.CorPele;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.EstadoCivil;
import br.com.progepe.entity.Funcao;
import br.com.progepe.entity.Grupo;
import br.com.progepe.entity.GrupoSanguineo;
import br.com.progepe.entity.Lotacao;
import br.com.progepe.entity.Padrao;
import br.com.progepe.entity.RegimeTrabalho;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.SituacaoFuncional;
import br.com.progepe.entity.TipoFuncao;
import br.com.progepe.validator.Validator;

public class Injetor {
	
	@SuppressWarnings({ "deprecation" })
	public void popularDados() throws ParseException{
		Extrator injetorDados = new Extrator();
		injetorDados.carregarDados();
		DAO dao = new DAO();
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		for (DadosPessoais pessoal : injetorDados.getDadosPessoaisList()) {
			Servidor servidor = new Servidor();
			servidor.setCargo(new Cargo());
			servidor.getCargo().setClasse(new Classe());
			servidor.setCidadeNascimento(new Cidade());
			servidor.getCidadeNascimento().setEstado(new Estado());
			servidor.setContaBancaria(new ContaBancaria());
			servidor.getContaBancaria().setBanco(new Banco());
			servidor.setCorPele(new CorPele());
			servidor.setDocumento(new Documento());
			servidor.getDocumento().setCarteiraUf(new Estado());
			servidor.getDocumento().setRgUf(new Estado());
			servidor.getDocumento().setTituloUf(new Estado());
			servidor.setEndereco(new Endereco());
			servidor.getEndereco().setCidade(new Cidade());
			servidor.getEndereco().getCidade().setEstado(new Estado());
			servidor.setEstadoCivil(new EstadoCivil());
			servidor.setFuncao(new Funcao());
			servidor.getFuncao().setTipoFuncao(new TipoFuncao());
			servidor.setGrupo(new Grupo());
			servidor.setGrupoSanguineo(new GrupoSanguineo());
			servidor.setLotacao(new Lotacao());
			servidor.setLocalExercicio(new Lotacao());
			servidor.setEndereco(new Endereco());
			servidor.getEndereco().setCidade(new Cidade());
			servidor.getEndereco().getCidade().setEstado(new Estado());
			servidor.setPadrao(new Padrao());
			servidor.setRegimeTrabalho(new RegimeTrabalho());
			servidor.setSituacaoFuncional(new SituacaoFuncional());
			
			servidor.setSiape(pessoal.getMatriculaSiape());
			servidor.setIdentificacaoUnica(pessoal.getMatriculaSiape() + "-" + pessoal.getDvMatricula());
			servidor.setNome(pessoal.getNomeServidor());
			servidor.getDocumento().setCpf(Validator.formatarCpf(pessoal.getCpf()));
			servidor.getDocumento().setPis(Validator.formatarPis(pessoal.getPisPasef()));
			servidor.setNomeMae(pessoal.getNomeMae());
			servidor.setSexo(pessoal.getSexo());	
			servidor.setDataNascimento(new Date(Validator.formatarData(pessoal.getDataNascimento())));
			servidor.getEstadoCivil().setCodigo(new Long (pessoal.getEstadoCivil()));
			servidor.getDocumento().setDataPrimeiroEmprego(new Date(Validator.formatarData(pessoal.getDataPrimeiroEmprego())));
			servidor.getEndereco().setRua(pessoal.getLogradouro());
			servidor.getEndereco().setNumero(pessoal.getNumeroEndereco());
			servidor.getEndereco().setComplemento(pessoal.getComplementoEndereco());
			servidor.getEndereco().setBairro(pessoal.getBairro());
			servidor.getEndereco().setCep(Validator.formatarCep(pessoal.getCep()));
			
			Cidade cidade = cidadeDAO.listByNome(pessoal.getMunicipio().toUpperCase().trim());
			servidor.getEndereco().setCidade(cidade);
			servidor.getEndereco().getCidade().setEstado(cidade.getEstado());
			servidor.getDocumento().setRg(pessoal.getNumeroRegistroGeral());
			servidor.getDocumento().setRgOrgaoEmissor(pessoal.getSiglaOrgaoExpedidor());
			servidor.getDocumento().setRgDataExpedicao(new Date(Validator.formatarData(pessoal.getDataExpedicaoIdentidade())));
			
			for (DadosFuncionais funcional : injetorDados.getDadosFuncionaisList()) {
				if(pessoal.getMatriculaSiape().equals(funcional.getMatriculaSiape())){
					servidor.getSituacaoFuncional().setCodigo(new Long(funcional.getCodigoSituacaoServidor()));
					servidor.getDocumento().setCarteiraTrabalho(funcional.getNumeroCarteiraDeTrabalho().toString());
					servidor.getDocumento().setCarteiraSerie(funcional.getSerieCarteiraDeTrabalho());
					servidor.getContaBancaria().getBanco().setCodigo(new Long (funcional.getCodigoBanco()));
					servidor.getContaBancaria().setAgencia(funcional.getAgenciaBanco());
					servidor.getContaBancaria().setNumeroConta(funcional.getContaCorrenteBanco());
					servidor.getCargo().setCodigo(new Long (funcional.getCodigoCargo()));
					servidor.getPadrao().setCodigo(new Long (funcional.getCodigoReferenciaNivelPadraoCargo()));
					servidor.setDataAdmissao(new Date (Validator.formatarData(funcional.getDataEntradaOcupacaoCargo())));
					servidor.setDataSaida(new Date (Validator.formatarData(funcional.getDataSaidaCargo())));
					servidor.getLotacao().setCodigo(new Long (funcional.getCodigoUnidadeOrganizacionalLotacao()));
					dao.save(servidor);
					break;
				}
			}
		}
	
	}	
	public static void main(String[] args) throws ParseException {
		Injetor injetorDados = new Injetor();	
		injetorDados.popularDados();
		
//
//		for (DadosPessoais item : injetorDados.getDadosPessoaisList()) {
//			System.out.println(item.getMatriculaSiape() + " - "
//					+ item.getNomeServidor());
//		}
//		for (DadosFuncionais item : injetorDados.getDadosFuncionaisList()) {
//			System.out.println(item.getMatriculaSiape() + " - "
//					+ item.getDataCadastramentoServidor());
//		}
		
	}

}
