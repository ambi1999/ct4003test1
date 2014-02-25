/**
 * @author      Ambikesh Jayal <ambi1999@gmail.com>
 * @version     1.0                 (current version number of program)
 * @since     25 Feb 2014
 */

//The following has been edited by Andrew Spackman - 25/02/2014 - Completed at 11:19am


//dasdsa
import glos.IO;



import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail2 {

static BufferedReader input;
	
	int test =0;
	
    static OutputStream output;
    
    static String from = "";
    static String password = "";
    static String[] to = { "s1302027@connect.glos.ac.uk" }; // list of recipient email addresses
    static String host="";
    static String portformail="";
    
    
	 private static void sendFromGMail(String host, String port, String from, String pass, String[] to, String subject, String body) {
	    	Properties props = System.getProperties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", port);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        
	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	            System.out.println("Email sent successfully");
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        
	    }
	 
public static void main(String[] args) throws Exception{
    	
    	Scanner sc= new Scanner(System.in);
        System.out.println("Enter user name");
        from = sc.next();
        //from = IO.readString("Enter Sender Email Address");
        
        System.out.println("Enter password");
        password = sc.next();
        //password = IO.readString("Enter Password");
        
        System.out.println("Enter host, For gmail enter smtp.gmail.com, For yahoo enter smtp.mail.yahoo.com");
        host = sc.next();
        //host = IO.readString("smtp.gmail.com");
        
        System.out.println("Enter port for mail. 465 if from within university otherwise try 587");
        portformail = sc.next();
        //portformail = IO.readString("465 ");
    
     String subject = "CT4003 Email Test" ;
     String body = "I'mma go first! " + new Date().getTime();
     sendFromGMail(host, portformail, from, password, to, subject, body);
     
}
}
