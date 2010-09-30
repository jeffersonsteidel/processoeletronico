package br.com.progepe.extract;

import java.text.ParseException;
import java.util.Date;

import br.com.progepe.dao.DAO;
import br.com.progepe.entity.Cidade;
import br.com.progepe.entity.Documento;
import br.com.progepe.entity.Endereco;
import br.com.progepe.entity.Estado;
import br.com.progepe.entity.EstadoCivil;
import br.com.progepe.entity.Servidor;
import br.com.progepe.validator.Validator;

public class Injetor {
	
	@SuppressWarnings({ "deprecation" })
	public void popularDados() throws ParseException{
		Extrator injetorDados = new Extrator();
		injetorDados.carregarDados();
		DAO dao = new DAO();
		
		for (DadosPessoais item : injetorDados.getDadosPessoaisList()) {
			Servidor servidor = new Servidor();
			servidor.setDocumento(new Documento());
			servidor.getDocumento().setCarteiraUf(new Estado());
			servidor.getDocumento().setRgUf(new Estado());
			servidor.getDocumento().setTituloUf(new Estado());
			servidor.setEstadoCivil(new EstadoCivil());
			servidor.setEndereco(new Endereco());
			servidor.getEndereco().setCidade(new Cidade());
			servidor.getEndereco().getCidade().setEstado(new Estado());
			
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
