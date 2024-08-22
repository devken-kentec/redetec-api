package br.com.kentec.redetec.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class SendEmailService {
	
	private String userName = "contato@kasapet.kentec.com.br";
	private String senha = "@dev_ken130483";
	
	@Async
	public void enviarEmalHtml(String assunto, String mensagem, String emailDestino) throws UnsupportedEncodingException, MessagingException {
		
		Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls", "false");
		props.put("mail.smtp.host", "mail.kentec.com.br");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(props, new Authenticator() {
		      
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(userName, senha);
			}
		});
		
		session.setDebug(true);
		
		Address[] toUser = InternetAddress.parse(emailDestino);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assunto);
		message.setText("Olá.!! Esta e-mail foi enviado usando javamail e com HTML");
                    String m = "<h1 style=\"color:red;\">"+ mensagem  +"</span></h1>"
                             + "<p style=\"color:green;\">Email enviado com sucesso!!</p>"
                             + "<p style=\"color:black;\">"+  LocalDateTime.now()  +"</p>";
                    message.setContent(m, "text/html; charset=utf-8");
                    message.setSentDate(new Date());
		Transport.send(message);
		System.out.println("Pronto!");
	}
}
