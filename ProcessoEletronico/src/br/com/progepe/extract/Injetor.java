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
		
		for (DadosPessoais item : injetorDados.getDadosPessoaisList()) {
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
			
			servidor.setSiape(item.getMatriculaSiape());
			servidor.setIdentificacaoUnica(item.getMatriculaSiape() + "-" + item.getDvMatricula());
			servidor.setNome(item.getNomeServidor());
			servidor.getDocumento().setCpf(Validator.formatarCpf(item.getCpf()));
			servidor.getDocumento().setPis(Validator.formatarPis(item.getPisPasef()));
			servidor.setNomeMae(item.getNomeMae());
			servidor.setSexo(item.getSexo());	
			servidor.setDataNascimento(new Date(Validator.formatarData(item.getDataNascimento())));
			servidor.getEstadoCivil().setCodigo(new Long (item.getEstadoCivil()));
			servidor.getDocumento().setDataPrimeiroEmprego(new Date(Validator.formatarData(item.getDataPrimeiroEmprego())));
			servidor.getEndereco().setRua(item.getLogradouro());
			servidor.getEndereco().setNumero(item.getNumeroEndereco());
			servidor.getEndereco().setComplemento(item.getComplementoEndereco());
			servidor.getEndereco().setBairro(item.getBairro());
			servidor.getEndereco().setCep(Validator.formatarCep(item.getCep()));
			
			Cidade cidade = cidadeDAO.listByNome(item.getMunicipio().toUpperCase().trim());
			servidor.getEndereco().setCidade(cidade);
			servidor.getEndereco().getCidade().setEstado(cidade.getEstado());
			servidor.getDocumento().setRg(item.getNumeroRegistroGeral());
			servidor.getDocumento().setRgOrgaoEmissor(item.getSiglaOrgaoExpedidor());
			servidor.getDocumento().setRgDataExpedicao(new Date(Validator.formatarData(item.getDataExpedicaoIdentidade())));
			
			dao.save(servidor);
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
