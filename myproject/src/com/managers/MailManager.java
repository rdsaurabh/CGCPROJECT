package com.managers;

import javax.mail.*;
import javax.mail.internet.*;

public class MailManager {
	private final static java.util.Properties properties = new java.util.Properties();

	static {
		// Set up the SMTP server.
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

	}

	private Session getSession(String email, String password) {
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		};
		Session session = Session.getDefaultInstance(properties, auth);
		return session;
	}

	public void sendEmail(String to,String subject,String content) {

		// Construct the message
		final String from = "rdsaurabh97@gmail.com";
		

		Message msg = new MimeMessage(getSession(from, "oldtrafford23"));

		// Send the message.
		new Thread(new Runnable() {

			@Override
			public void run() {
				try { // TODO Auto-generated method stub

					msg.setFrom(new InternetAddress(from));
					msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
					msg.setSubject(subject);
					msg.setText(content);
					Transport.send(msg);
				} catch (MessagingException e) {
					// Error.
					e.printStackTrace();
				}

			}
		}).start();
	}


}
