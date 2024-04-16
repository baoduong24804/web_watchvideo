package Main;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class main {
	public static void sendMail() {
		 // Thông tin tài khoản email
        String username = "anhbao5cm@gmail.com";
        String password = "mcvs bzys kboj abcp";
        System.out.println("Running");
        // Tạo đối tượng HtmlEmail
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setStartTLSRequired(true);
     // Cấu hình máy chủ SMTP
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
     // Tạo Authenticator để xác thực tài khoản email
//        Authenticator auth = new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        };
//
//        // Tạo phiên gửi email
//        Session session = Session.getInstance(props, auth);
//
//        try {
//            // Tạo một đối tượng MimeMessage
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient_email@example.com"));
//            message.setSubject("Email with Attachment");
//
//            // Tạo một đối tượng Multipart
//            MimeMultipart multipart = new MimeMultipart();
//
//            // Thêm nội dung email
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText("This is the message body");
//            multipart.addBodyPart(messageBodyPart);
//
//            // Thêm file đính kèm
//            MimeBodyPart attachPart = new MimeBodyPart();
//            String attachFile = "path/to/your/file.txt"; // Đường dẫn của file đính kèm
//            DataSource source = new FileDataSource(attachFile);
//            attachPart.setDataHandler(new javax.activation.DataHandler(source));
//            attachPart.setFileName("file.txt"); // Tên của file đính kèm
//            multipart.addBodyPart(attachPart);
//
//            // Đặt nội dung Multipart vào Message
//            message.setContent(multipart);
//
//            // Gửi email
//            Transport.send(message);
//
//            System.out.println("Email sent successfully!");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        try {
        	
            // Thiết lập người gửi
        	email.setCharset("utf-8"); // tv
            email.setFrom(username);

            // Thiết lập người nhận
            email.addTo("nguyenthanhnhan640822@gmail.com");

            // Thiết lập tiêu đề
            email.setSubject("Test email");

            // Thiết lập nội dung email
            email.setMsg("cón cáo còn có");

            // Gửi email
            email.send();

            System.out.println("Email sent successfully!");

        } catch (EmailException e) {
            e.printStackTrace();
        }
       // System.out.println("Done send");
    }
	

    public static void main(String[] args) {
     sendMail();  
    }
    }
