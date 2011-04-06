package br.com.progepe.jsfUtil;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.progepe.constantes.Constantes;
import br.com.progepe.dao.DAO;
import br.com.progepe.dao.ServidorDAO;
import br.com.progepe.entity.Conjuge;
import br.com.progepe.entity.Dependente;
import br.com.progepe.entity.Emprego;
import br.com.progepe.entity.Progressao;
import br.com.progepe.entity.Servidor;
import br.com.progepe.entity.ServidorTitulacao;
import br.com.progepe.entity.Solicitacao;

public class EnviarEmail {
	private String remetente;
	private String destinatario;
	private String smtpHost;
	private String porta;
	private String assunto;
	private Properties propriedades;
	private Session sessao;
	private static String usuario;
	private static String senha;
	private String conteudoDoEmail;

	private static class Autenticacao extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(usuario, senha);
		}
	}

	public EnviarEmail() {
	}

	public void aplicarEmail(List<Servidor> servidores) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		assunto = "";
		conteudoDoEmail = "";
		try {
			for (Servidor item : servidores) {
				@SuppressWarnings("unused")
				EnviarEmail enviar = new EnviarEmail(remetente,
						item.getEmail(), assunto, smtpHost, porta, usuario,
						senha, conteudoDoEmail);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void enviarEmailSolicitacao(Solicitacao solicitacao) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		Servidor atendente = null;
		solicitacao = (Solicitacao) DAO.getInstance().refresh(solicitacao);

		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(solicitacao
				.getStatusSolicitacao().getCodigo())) {
			assunto = "PROCESSO VERDE - Solicitação: "
					+ solicitacao.getTipoSolicitacao().getDescricao() + " - "
					+ DataUtil.formatDateHour(solicitacao.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: "
					+ solicitacao.getTipoSolicitacao().getDescricao();
			conteudoDoEmail += "\n Status: "
					+ solicitacao.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(solicitacao.getDataAbertura());
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}

		if (solicitacao.getStatusSolicitacao().getCodigo() > Constantes.STATUS_SOLICITACAO_ENCAMINHADO) {
			atendente = new Servidor();
			atendente.setSiape(solicitacao.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
			assunto = "PROCESSO VERDE - Solicitação: "
					+ solicitacao.getTipoSolicitacao().getDescricao() + " - "
					+ DataUtil.formatDateHour(solicitacao.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: "
					+ solicitacao.getTipoSolicitacao().getDescricao();
			conteudoDoEmail += "\n Status: "
					+ solicitacao.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(solicitacao.getDataAbertura());
			conteudoDoEmail += "\n Data de Atendimento: "
					+ DataUtil.formatDateHour(solicitacao.getDataAtendimento());
			conteudoDoEmail += "\n Atendente: " + atendente.getNome();
			conteudoDoEmail += "\n Data de Fechamento: "
					+ DataUtil.formatDateHour(solicitacao.getDataFechamento());
			if (solicitacao.getJustificativa() != null
					&& solicitacao.getJustificativa().length() > 0) {
				conteudoDoEmail += "\n Justificativa: "
						+ solicitacao.getJustificativa();
			}
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		try {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, solicitacao
					.getSolicitante().getEmail(), assunto, smtpHost, porta,
					usuario, senha, conteudoDoEmail);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void enviarEmailEmprego(Emprego emprego) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		Servidor atendente = null;
		emprego = (Emprego) DAO.getInstance().refresh(emprego);

		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(emprego
				.getStatusSolicitacao().getCodigo())) {
			assunto = "PROCESSO VERDE - Emprego cadastrado: "
					+ DataUtil.formatDateHour(emprego.getDataAbertura());
			assunto = "PROCESSO VERDE - CADASTRO DE EMPREGO: "
					+ DataUtil.formatDateHour(emprego.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE EMPREGO";
			conteudoDoEmail += "\n Status: "
					+ emprego.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(emprego.getDataAbertura());
			conteudoDoEmail += "\n Empresa: " + emprego.getEmpresa();
			conteudoDoEmail += "\n Cargo: " + emprego.getCargo();
			conteudoDoEmail += "\n Data de Admissão: "
					+ DataUtil.formatDate(emprego.getDataAdmissao());
			conteudoDoEmail += "\n Data de Demissão: "
					+ DataUtil.formatDate(emprego.getDataSaida());
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		if (emprego.getStatusSolicitacao().getCodigo() > Constantes.STATUS_SOLICITACAO_ENCAMINHADO) {
			atendente = new Servidor();
			atendente.setSiape(emprego.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
			assunto = "PROCESSO VERDE - CADASTRO DE EMPREGO: "
					+ DataUtil.formatDateHour(emprego.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE EMPREGO";
			conteudoDoEmail += "\n Status: "
					+ emprego.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(emprego.getDataAbertura());
			conteudoDoEmail += "\n Empresa: " + emprego.getEmpresa();
			conteudoDoEmail += "\n Cargo: " + emprego.getCargo();
			conteudoDoEmail += "\n Data de Admissão: "
					+ DataUtil.formatDate(emprego.getDataAdmissao());
			conteudoDoEmail += "\n Data de Demissão: "
					+ DataUtil.formatDate(emprego.getDataSaida());
			conteudoDoEmail += "\n Data de Atendimento: "
					+ DataUtil.formatDate(emprego.getDataAtendimento());
			conteudoDoEmail += "\n Atendente: " + atendente.getNome();
			conteudoDoEmail += "\n Data de Fechamento: "
					+ DataUtil.formatDate(emprego.getDataFechamento());
			if (emprego.getJustificativa() != null
					&& emprego.getJustificativa().length() > 0) {
				conteudoDoEmail += "\n Justificativa: "
						+ emprego.getJustificativa();
			}
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		try {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, emprego
					.getServidor().getEmail(), assunto, smtpHost, porta,
					usuario, senha, conteudoDoEmail);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void enviarEmailDependente(Dependente dependente) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		Servidor atendente = null;
		dependente = (Dependente) DAO.getInstance().refresh(dependente);

		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(dependente
				.getStatusSolicitacao().getCodigo())) {
			assunto = "PROCESSO VERDE - CADASTRO DE DEPENDENTE: "
					+ DataUtil.formatDateHour(dependente.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE DEPENDENTE";
			conteudoDoEmail += "\n Status: "
					+ dependente.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(dependente.getDataAbertura());
			conteudoDoEmail += "\n Nome do Dependendente: "
					+ dependente.getNome().toUpperCase();
			conteudoDoEmail += "\n Data de Nascimento do Dependendente: "
					+ DataUtil.formatDate(dependente.getDataNascimento());
			conteudoDoEmail += "\n CPF do Dependendente: "
					+ dependente.getCpf();
			conteudoDoEmail += "\n Grau de Parentesco: "
					+ dependente.getGrauParentesco().getDescricao();
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		if (dependente.getStatusSolicitacao().getCodigo() > Constantes.STATUS_SOLICITACAO_ENCAMINHADO) {
			atendente = new Servidor();
			atendente.setSiape(dependente.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
			assunto = "PROCESSO VERDE - CADASTRO DE DEPENDENTE: "
					+ DataUtil.formatDateHour(dependente.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE DEPENDENTE";
			conteudoDoEmail += "\n Status: "
					+ dependente.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(dependente.getDataAbertura());
			conteudoDoEmail += "\n Nome do Dependendente: "
					+ dependente.getNome().toUpperCase();
			conteudoDoEmail += "\n Data de Nascimento do Dependendente: "
					+ DataUtil.formatDate(dependente.getDataNascimento());
			conteudoDoEmail += "\n CPF do Dependendente: "
					+ dependente.getCpf();
			conteudoDoEmail += "\n Grau de Parentesco: "
					+ dependente.getGrauParentesco().getDescricao();
			conteudoDoEmail += "\n Data de Atendimento: "
					+ DataUtil.formatDate(dependente.getDataAtendimento());
			conteudoDoEmail += "\n Atendente: " + atendente.getNome();
			conteudoDoEmail += "\n Data de Fechamento: "
					+ DataUtil.formatDate(dependente.getDataFechamento());
			if (dependente.getJustificativa() != null
					&& dependente.getJustificativa().length() > 0) {
				conteudoDoEmail += "\n Justificativa: "
						+ dependente.getJustificativa();
			}
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		try {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, dependente
					.getServidor().getEmail(), assunto, smtpHost, porta,
					usuario, senha, conteudoDoEmail);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void enviarEmailTitulacao(ServidorTitulacao servidorTitulacao) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		Servidor atendente = null;
		servidorTitulacao = (ServidorTitulacao) DAO.getInstance().refresh(
				servidorTitulacao);

		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(servidorTitulacao
				.getStatusSolicitacao().getCodigo())) {
			assunto = "PROCESSO VERDE - CADASTRO DE TITULAÇÃO: "
					+ DataUtil.formatDateHour(servidorTitulacao
							.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE TITULAÇÃO";
			conteudoDoEmail += "\n Status: "
					+ servidorTitulacao.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(servidorTitulacao
							.getDataAbertura());
			conteudoDoEmail += "\n Titulação: "
					+ servidorTitulacao.getTitulacao().getDescricao();
			if (servidorTitulacao.getAreaConhecimento() != null) {
				conteudoDoEmail += "\n Área Conhecimento: "
						+ servidorTitulacao.getAreaConhecimento()
								.getDescricao();
			}
			conteudoDoEmail += "\n Estabelecimento de Ensino: "
					+ servidorTitulacao.getEstabelecimentoEnsino()
							.toUpperCase();
			if (servidorTitulacao.getCargaHoraria() != null) {
				conteudoDoEmail += "\n Carga Horária: "
						+ servidorTitulacao.getCargaHoraria();
			}
			conteudoDoEmail += "\n Ano de Conclusão: "
					+ servidorTitulacao.getAnoConclusao();
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		if (servidorTitulacao.getStatusSolicitacao().getCodigo() > Constantes.STATUS_SOLICITACAO_ENCAMINHADO) {
			atendente = new Servidor();
			atendente.setSiape(servidorTitulacao.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
			assunto = "PROCESSO VERDE - CADASTRO DE TITULAÇÃO: "
					+ DataUtil.formatDateHour(servidorTitulacao
							.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE TITULAÇÃO";
			conteudoDoEmail += "\n Status: "
					+ servidorTitulacao.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(servidorTitulacao
							.getDataAbertura());
			conteudoDoEmail += "\n Titulação: "
					+ servidorTitulacao.getTitulacao().getDescricao();
			if (servidorTitulacao.getAreaConhecimento() != null) {
				conteudoDoEmail += "\n Área Conhecimento: "
						+ servidorTitulacao.getAreaConhecimento()
								.getDescricao();
			}
			conteudoDoEmail += "\n Estabelecimento de Ensino: "
					+ servidorTitulacao.getEstabelecimentoEnsino()
							.toUpperCase();
			if (servidorTitulacao.getCargaHoraria() != null) {
				conteudoDoEmail += "\n Carga Horária: "
						+ servidorTitulacao.getCargaHoraria();
			}
			conteudoDoEmail += "\n Ano de Conclusão: "
					+ servidorTitulacao.getAnoConclusao();

			conteudoDoEmail += "\n Data de Atendimento: "
					+ DataUtil.formatDate(servidorTitulacao
							.getDataAtendimento());
			conteudoDoEmail += "\n Atendente: " + atendente.getNome();
			conteudoDoEmail += "\n Data de Fechamento: "
					+ DataUtil
							.formatDate(servidorTitulacao.getDataFechamento());
			if (servidorTitulacao.getJustificativa() != null
					&& servidorTitulacao.getJustificativa().length() > 0) {
				conteudoDoEmail += "\n Justificativa: "
						+ servidorTitulacao.getJustificativa();
			}
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		try {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, servidorTitulacao
					.getServidor().getEmail(), assunto, smtpHost, porta,
					usuario, senha, conteudoDoEmail);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void enviarEmailConjuge(Conjuge conjuge) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		Servidor atendente = null;
		conjuge = (Conjuge) DAO.getInstance().refresh(conjuge);

		if (Constantes.STATUS_SOLICITACAO_ENCAMINHADO.equals(conjuge
				.getStatusSolicitacao().getCodigo())) {
			assunto = "PROCESSO VERDE - CADASTRO DE CÔNJUGE: "
					+ DataUtil.formatDateHour(conjuge.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE CÔNJUGE";
			conteudoDoEmail += "\n Status: "
					+ conjuge.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(conjuge.getDataAbertura());
			conteudoDoEmail += "\n Data de Nascimento do Cônjuge: "
					+ DataUtil.formatDate(conjuge.getDataNascimento());
			conteudoDoEmail += "\n CPF do Cônjuge: " + conjuge.getCpf();
			conteudoDoEmail += "\n Atual: "
					+ (conjuge.getAtual() ? "SIM" : "NÃO");
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		if (conjuge.getStatusSolicitacao().getCodigo() > Constantes.STATUS_SOLICITACAO_ENCAMINHADO) {
			atendente = new Servidor();
			atendente.setSiape(conjuge.getAtendente());
			atendente = ServidorDAO.getInstance().refreshBySiape(atendente);
			assunto = "PROCESSO VERDE - CADASTRO DE CÔNJUGE: "
					+ DataUtil.formatDateHour(conjuge.getDataAbertura());
			conteudoDoEmail = "\n Solicitação: CADASTRO DE CÔNJUGE";
			conteudoDoEmail += "\n Status: "
					+ conjuge.getStatusSolicitacao().getDescricao();
			conteudoDoEmail += "\n Data de Abertura: "
					+ DataUtil.formatDateHour(conjuge.getDataAbertura());
			conteudoDoEmail += "\n Data de Nascimento do Cônjuge: "
					+ DataUtil.formatDate(conjuge.getDataNascimento());
			conteudoDoEmail += "\n CPF do Cônjuge: " + conjuge.getCpf();
			conteudoDoEmail += "\n Atual: "
					+ (conjuge.getAtual() ? "SIM" : "NÃO");
			conteudoDoEmail += "\n Data de Atendimento: "
					+ DataUtil.formatDate(conjuge.getDataAtendimento());
			conteudoDoEmail += "\n Atendente: " + atendente.getNome();
			conteudoDoEmail += "\n Data de Fechamento: "
					+ DataUtil.formatDate(conjuge.getDataFechamento());
			if (conjuge.getJustificativa() != null
					&& conjuge.getJustificativa().length() > 0) {
				conteudoDoEmail += "\n Justificativa: "
						+ conjuge.getJustificativa();
			}
			conteudoDoEmail += "\n \n E-mail automático por favor não responder!";
		}
		try {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, conjuge
					.getServidor().getEmail(), assunto, smtpHost, porta,
					usuario, senha, conteudoDoEmail);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void enviarEmailProgressaoMerito(Progressao progressao) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		assunto = "PROCESSO VERDE - PROGRESSÃO POR MÉRITO PROFISSIONAL";
		conteudoDoEmail = "\n "+ progressao.getServidor().getNome();
		conteudoDoEmail += "\n Sua progressão por mérito profissional encontra-se  ";
		if(progressao.getIndConcedido().equals(Constantes.PROGRESSAO_CONCEDIDA)){	
			conteudoDoEmail += " CONCEDIDA ";
			conteudoDoEmail += " passando do padrão "+progressao.getClasse().getSigla()+" "+progressao.getPadraoAntigo().getNivel();
			conteudoDoEmail += " para "+progressao.getClasse().getSigla()+" "+progressao.getPadraoNovo().getNivel();
			conteudoDoEmail += "\n Sua nota foi  "+progressao.getNota();
			conteudoDoEmail += "\n Sua próxima progressão está prevista para:  "+DataUtil.formatDate(progressao.getDataProximaProgressao());
		}
		if(progressao.getIndConcedido().equals(Constantes.PROGRESSAO_NAO_CONCEDIDA)){	
			conteudoDoEmail += " NÃO CONCEDIDA";
			conteudoDoEmail += " sendo assim você permanece no padrão "+progressao.getClasse().getSigla()+" "+progressao.getPadraoAntigo().getNivel();
			conteudoDoEmail += "\n Sua nota foi  "+progressao.getNota();
			conteudoDoEmail += "\n Sua próxima progressão está prevista para:  "+DataUtil.formatDate(progressao.getDataProximaProgressao());
		}
		
		conteudoDoEmail += "\n \n E-mail automático por favor não responder!";

		try {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, progressao
					.getServidor().getEmail().toLowerCase(), assunto, smtpHost, porta,
					usuario, senha, conteudoDoEmail);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@SuppressWarnings("static-access")
	public EnviarEmail(String remetente, String destinatario, String assunto,
			String smtpHost, String porta, String usuario, String senha,
			String conteudoDoEmail) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.smtpHost = smtpHost;
		this.porta = porta;
		this.usuario = usuario;
		this.senha = senha;
		this.conteudoDoEmail = conteudoDoEmail;
		this.propriedades = System.getProperties();
		this.propriedades.put("mail.smtp.host", this.smtpHost);
		this.propriedades.put("mail.smtp.auth", "true");
		this.propriedades.put("mail.debug", "false");
		this.propriedades.put("mail.smtp.debug", "false");
		this.propriedades.put("mail.smtp.port", this.porta);
		this.propriedades.put("mail.smtp.starttls.enable", "false");
		this.propriedades.put("mail.smtp.socketFactory.port", this.porta);
		this.propriedades.put("mail.smtp.socketFactory.fallback", "false");
		this.propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		this.propriedades.put("mail.smtp.user", "processo.verde@ifpr.edu.br");
		Authenticator auth = new Autenticacao();
		this.sessao = Session.getDefaultInstance(this.propriedades, auth);
		try {
			Message mensagem = new MimeMessage(this.sessao);
			mensagem.setSubject(this.assunto);
			mensagem.setFrom(new InternetAddress(this.remetente));
			mensagem.addRecipient(Message.RecipientType.TO,
					new InternetAddress(this.destinatario));
			mensagem.setText(this.conteudoDoEmail);
			Transport.send(mensagem);
		} catch (Exception err) {
			System.out.println("Erro ao enviar mensagem");
		}
	}
}