package moolya.slicepay.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SummaryReport {
	
	
	public static String from = "yatheendra@moolya.com";
	public static String fromPass = "9743430233yathi";
	//yatheendra@moolya.com, manishm@slicepay.in
	public static String[] to = {""};
	String dir = System.getProperty("user.dir");
	static DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	static Date date = new Date();
	public static String subject = "Android Automation Results :: "+dateFormat.format(date);
	//#Novobank MEL RC 22.5     #JLG V2 RC0.15.0
	public static String bodyText = "Hi,\n\nPlease Find Below Suitewise Automation Test Results\n\n";
	
//	@Test
	public void EmailSummaryReport(){
		Properties properties = System.getProperties();  
		properties.setProperty("mail.transport.protocol", "smtp");  
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");  
		properties.put("mail.smtp.auth", "true");  
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getDefaultInstance(properties,  
				new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(from,fromPass);  
			}  
		});
		
		try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(from)); 
			for(String str : to)
			{
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(str));
			}
			
			
			
			message.setSubject(subject); 
			Multipart multipart = new MimeMultipart();  
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(bodyText);
			multipart.addBodyPart(messageBodyPart1);  
			
			//attachment
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	         String filename = "abc.txt";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart2.setDataHandler(new DataHandler(source));
	         messageBodyPart2.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart2);
	         
	         message.setContent(multipart );  
			Transport.send(message);  
			System.out.println("Mail sent...");  
		}catch (MessagingException ex) {ex.printStackTrace();}  
		
		
		
	}

}
