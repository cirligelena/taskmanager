package annotations;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import helper.Helper;

public class EmailSender {
	private static final Logger logger = LogManager.getLogger(EmailSender.class);
	private Helper helper = new Helper("mail.properties");

	public void sendEmail(String text) {

		Session session = Session.getInstance(helper.getProperties());
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(helper.readProperty("mail.smtp.user")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(helper.readProperty("to")));
			message.setSubject("test message from java");
			message.setText(text);
			Transport.send(message, helper.readProperty("mail.smtp.user"), helper.readProperty("mail.smtp.password"));
			logger.info("Email sent succsesfuly");
		} catch (MessagingException e) {
			logger.error(e);
		}
	}

}
