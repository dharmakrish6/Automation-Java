package Moolya.CashE.utilities;

import java.io.File;
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class SummaryReport {
	
	public static String[] suiteNames = {"01_Admin_Systems","02_Admin_Organization_ManageGisAndVtc",
		"03_Admin_Organization_Offices","04_Admin_Organization_Holidays","05_Admin_Organization_Funds",
		"06_Admin_Users","07_Centers","08_Admin_Accounting","09_Admin_Products_Charges","10_Admin_Products_LoanProducts",
		"11_Groups","12_LOS_Dedupe_TestSuite","13_LOS_Eligibility_TestSuite","14_LOS_JLGRegularApplicationFlow","21_LMS"};
	public static String from = "klautomation@moolya.com";
	public static String fromPass = "klmoolya#automate123";
	//yatheendra@moolya.com,harikrishna@moolya.com,sachin@moolya.com"
	public static String[] to = {};
	public static String subject = "Automation Results :: JLG V2 RC0.15.0 :: ";
	//#Novobank MEL RC 22.5     #JLG V2 RC0.15.0
	public static String bodyText = "Hi,\n\nPlease Find Below Suitewise Automation Test Results\n\n";
	public static String htmlText = "<html><body><table border=\"1\" style=\"width:100%\">"
			+ "<th><td><h3>Suit Name</h3></td><td><h3>Total</h3></td><td><h3>Pass</h3></td>"
			+ "<td><h3>Fail</h3></td><td><h3>Skip</h3></td>";
	String suitName;
	int pass = 0;
	int fail = 0;
	int skip = 0;
	int total = 0;
	int grandTotal = 0;
	int grandPass = 0;
	int grandFail = 0;
	int grandskip = 0;
	String attachFilePath = "./test-output/emailable-report.html";
	
	
	@Test
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
			
			
			WebDriver driver = new HtmlUnitDriver();
			String curdir=System.getProperty("user.dir");
			for(int i=0;i<suiteNames.length;i++){
				try{
					File folder = new File(curdir+"\\test-output\\"+suiteNames[i]);
					if(folder.exists()){
						pass = 0;
						fail = 0;
						skip = 0;
						total = 0;
						suitName = folder.getName();
						File[] listOfFiles = folder.listFiles();
						for(File file:listOfFiles){
							if(file.getName().endsWith(".html")){
								driver.get("file:///"+file.getAbsolutePath());
								String status=driver.findElement(By.xpath("(//td[2])[1]")).getText();
								String[] testStatus=status.split("/");
								pass = pass + Integer.parseInt(testStatus[0]);
								fail = fail + Integer.parseInt(testStatus[1]);
								skip = skip + Integer.parseInt(testStatus[2]);
							}
						}
						total = total + pass + fail + skip;
						grandTotal = grandTotal + total;
						grandPass = grandPass + pass;
						grandFail = grandFail + fail;
						grandskip = grandskip + skip;
						htmlText=htmlText+"<tr><td>*</td><td>"+suitName+"</td><td>"+total
								+"</td><td>"+pass+"</td><td>"+fail+"</td><td>"+skip+"</td></tr>";
//						System.out.print("Suitname : "+suitName);
//						System.out.println("\tTotal : "+total+" Pass :  "+pass+" Fail : "+fail+" Skip : "+skip);
					}
					
				}
				catch(Exception e){e.printStackTrace();}
			}
//			System.out.println("Grand Total : "+grandTotal+" Pass : "+grandPass+" Fail : "+grandFail+" Skip : "+grandskip);
			
			message.setSubject(subject + "Total: "+grandTotal+" Pass: "+grandPass+" Fail: "+grandFail+" Skip: "+grandskip); 
			Multipart multipart = new MimeMultipart();  
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			MimeBodyPart messageBodyPart3 = new MimeBodyPart();
			messageBodyPart1.setText(bodyText);
			messageBodyPart2.setContent(htmlText, "text/html");
			DataSource source = new FileDataSource(attachFilePath);
			messageBodyPart3.setDataHandler(new DataHandler(source));
			messageBodyPart3.setFileName(attachFilePath);
			multipart.addBodyPart(messageBodyPart1);  
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart3);
			message.setContent(multipart );  
			Transport.send(message);  
			System.out.println("Mail sent...");  
		}catch (MessagingException ex) {ex.printStackTrace();}  
		
		
		
	}

}
