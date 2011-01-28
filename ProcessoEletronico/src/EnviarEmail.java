import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.progepe.entity.Servidor;

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

	public void aplicarEmail(List<Servidor> servidores) {
		String remetente = "processo.verde@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String usuario = "processo.verde@ifpr.edu.br";
		String senha = "ifpr10";

		assunto = "";
		conteudoDoEmail = "";
		try{	
		for (Servidor item : servidores) {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, item.getEmail(),
					assunto, smtpHost, porta, usuario, senha, conteudoDoEmail);
		}
		}catch (Exception e) {
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
			System.out.println("Enviando mensagem");
			Transport.send(mensagem);
			System.out.println("Mensagem enviada");
		} catch (Exception err) {
			System.out.println("Erro ao enviar mensagem");
		}
	}
}