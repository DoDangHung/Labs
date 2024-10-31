package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCrypt;

import BEAN.Member;
import DB.DBConnection;

public class LoginDAO {
	public static String CheckLogin(Member a, Connection conn,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "SELECT * FROM finalweb.member where username = '"+a.getUsername()+"'";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(!rs.next()) {
				return "failed";
			}else {
				try {
					if(BCrypt.checkpw(a.getPassword(), rs.getString("password"))) {
						return "success";
					}
					else {
						return "errorPass";
					}
				}
				catch(IllegalArgumentException e){
					return "errorPass";
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}
	public static String checkAdmin(Member a, Connection conn,HttpServletRequest request, HttpServletResponse response) {
		String sql = "SELECT * FROM finalweb.member where username = '"+a.getUsername()+"'";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				return rs.getString("admin");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static String getName(Member a, Connection conn,HttpServletRequest request, HttpServletResponse response) {
		String sql = "SELECT * FROM finalweb.member where username = '"+a.getUsername()+"'";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("ho_ten");
				return name;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static boolean searchEmail(String email) {
		String sql = "select * from member where email='"+email+"'";
		Connection conn = DBConnection.CreateConn();
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        MimeMessage msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject,"UTF-8");
        msg.setSentDate(new Date());
        msg.setText(message, "UTF-8");
 
        // sends the e-mail
        Transport.send(msg);
 
    }
	public static boolean resetPass(String email, String pass) {
		String sql ="Update member set password='"+pass+"' where email='"+email+"'";
		Connection conn = DBConnection.CreateConn();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int kt = ptmt.executeUpdate();
			if(kt!=0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
