package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Member;
import BEAN.Result;
import DB.DBConnection;

public class ProfileDAO {
	public static Member getMember(String username) {
		Member a = new Member();
		String sql="SELECT * FROM finalweb.member where username = '"+username+"'";
		Connection conn = DBConnection.CreateConn();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				a.setUsername(rs.getString("username"));
				a.setHo_ten(rs.getString("ho_ten"));
				a.setEmail(rs.getString("email"));	
				a.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}
	public static boolean updateInfo(Member a) {
		String sql="UPDATE member SET ho_ten='"+a.getHo_ten()+"',email='"+a.getEmail()+"' WHERE username='" + a.getUsername()+"'";
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
		
		
		return true;
	}
	public static boolean changePassword(Member a, String passnew) {
		String sql="UPDATE member SET password='"+passnew+"' WHERE username='" + a.getUsername()+"'";
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
		
		
		return true;
	}
	
	public static boolean check_email(Member a) {
		String sql="SELECT * FROM finalweb.member where email='" + a.getEmail() +"' and username !='" +a.getUsername()+"'";
		Connection conn = DBConnection.CreateConn();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public static List<Result> getResult(String username) {
		
		String sql="SELECT * FROM finalweb.result where member_username = '"+username+"'";
		Connection conn = DBConnection.CreateConn();
		List<Result> list = new ArrayList<Result>();
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				Result a = new Result(rs.getInt("result_score"),rs.getInt("exam_id"),rs.getString("result_time"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
