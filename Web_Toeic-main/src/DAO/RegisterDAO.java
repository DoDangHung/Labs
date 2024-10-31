package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Member;
import DB.DBConnection;

public class RegisterDAO {
	public static void InsertUser(HttpServletRequest request, HttpServletResponse response, Connection conn, Member mb,String code) throws ServletException, IOException {
		String sql = "insert into member(ho_ten,username,password,email,verify) values(?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			String hoten = mb.getHo_ten();
			String user = mb.getUsername();
			String pass = mb.getPassword();
			String email = mb.getEmail();
			
			ptmt.setString(1, hoten);
			ptmt.setString(2, user);
			ptmt.setString(3, pass);
			ptmt.setString(4, email);
			ptmt.setString(5, code);
			
			int kt = ptmt.executeUpdate();
			if(kt!=0) {
				request.setAttribute("success","Hệ thống đã gửi link xác nhận qua hộp thư, vui lòng kiểm tra hộp thư của bạn.");
				request.getRequestDispatcher("View/Register.jsp").forward(request, response);
			}else {
				request.setAttribute("message","Lỗi hệ thống, chưa tạo được tài khoản.");
				request.getRequestDispatcher("View/Register.jsp").forward(request, response);
				
			}
			ptmt.close();
			
		} catch (SQLException e) {
			request.setAttribute("message","Lỗi hệ thống, chưa tạo được tài khoản.");
			request.getRequestDispatcher("View/Register.jsp").forward(request, response);
		}
	} 
	public static boolean checkuser(Connection conn, String name, String email) {
		boolean kt =false;
		String sql = "SELECT * from finalweb.member where username = '"+name+"' or email ='"+email+"'";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs  = ptmt.executeQuery();
			if(!rs.next()) {
				kt=true;
			}else kt=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kt;
	}
	public static boolean checkVerify(Connection conn, String name, String code) {
		boolean kt =false;
		String sql = "SELECT * from finalweb.member where username = '"+name+"' and verify ='"+code+"'";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs  = ptmt.executeQuery();
			if(rs.next()) {
				kt=true;
			}else kt=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kt;
	}
	public static boolean verify(String code, String username) {
		Connection conn = DBConnection.CreateConn();
		String sql = "update finalweb.member set admin=0 where username ='"+username+"'";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int kt = ptmt.executeUpdate();
			if(kt!=0) {
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	public static boolean deleteCodeVerify(String code, String username) {
		Connection conn = DBConnection.CreateConn();
		String sql = "update finalweb.member set verify=null where username ='"+username+"'";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int kt = ptmt.executeUpdate();
			if(kt!=0) {
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
}
