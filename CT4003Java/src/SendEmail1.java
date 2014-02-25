  * @since     25 Feb 2014
   */
  
 -//added by Andrew in class
 +//The following has been edited by Andrew Spackman - 25/02/2014 - Completed at 11:19am
 +
 +import glos.IO;
  
  import java.io.BufferedReader;
  import java.io.OutputStream;
 @@ -74,20 +76,24 @@ private static void sendFromGMail(String host, String port, String from, String
  public static void main(String[] args) throws Exception{
      	
      	Scanner sc= new Scanner(System.in);
 -        System.out.println("Enter user name");
 -        from = sc.next();
 +        //System.out.println("Enter user name");
 +        //from = sc.next();
 +        from = IO.readString("Enter Sender Email Address");
          
 -        System.out.println("Enter password");
 -        password = sc.next();
 +        //System.out.println("Enter password");
 +        //password = sc.next();
 +        password = IO.readString("Enter Password");
          
 -        System.out.println("Enter host, For gmail enter smtp.gmail.com, For yahoo enter smtp.mail.yahoo.com");
 -        host = sc.next();
 +        //System.out.println("Enter host, For gmail enter smtp.gmail.com, For yahoo enter smtp.mail.yahoo.com");
 +        //host = sc.next();
 +        host = IO.readString("Enter host, For gmail enter smtp.gmail.com, For yahoo enter smtp.mail.yahoo.com");
          
 -        System.out.println("Enter port for mail. 465 if from within university otherwise try 587");
 -        portformail = sc.next();
 +        //System.out.println("Enter port for mail. 465 if from within university otherwise try 587");
 +        //portformail = sc.next();
 +        portformail = IO.readString("Enter port for mail. 465 if from within university otherwise try 587");
      
 -     String subject = "ALERT VAL =" + "testing" ;
 -     String body = "Welcome to Ct4003 class" + new Date().getTime();
 +     String subject = "CT4003 Email Test" ;
 +     String body = "I'mma go first! " + new Date().getTime();
       sendFromGMail(host, portformail, from, password, to, subject, body);
       
  }