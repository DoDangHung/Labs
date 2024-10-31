package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Comment;
import BEAN.Member;
import BEAN.Post;
import DB.DBConnection;

public class AdminDAO {
	public static int member_current_month() {
		Connection conn = DBConnection.CreateConn();
		String sql = "SELECT count(*) FROM finalweb.member where month(date)=month(current_timestamp())";
		int k =0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				k = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	public static int cmt_current_month() {
		Connection conn = DBConnection.CreateConn();
		String sql = "SELECT count(*) FROM comment where month(cmt_time)=month(current_timestamp())";
		int k =0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				k = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	public static int test_current_month() {
		Connection conn = DBConnection.CreateConn();
		String sql = "SELECT count(*) FROM result where month(result_time)=month(current_timestamp())";
		int k =0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				k = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	public static List<Member> Top_Cmt(){
		List<Member> list = new ArrayList<Member>();
		Connection conn = DBConnection.CreateConn();
		String sql = "select ho_ten, count(cmt_member_id) as 'soluong' from temp group by cmt_member_id order by soluong DESC limit 5;";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.executeUpdate("DROP TABLE IF EXISTS  temp;");
			ptmt.executeUpdate("create TEMPORARY  table temp as select member.ho_ten,comment.cmt_member_id from member,comment  where member.username=comment.cmt_member_id;");
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				Member a = new Member(rs.getString(1), "", rs.getInt(2), 0);
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	public static List<Member> Top_testing(){
		List<Member> list = new ArrayList<Member>();
		Connection conn = DBConnection.CreateConn();
		String sql = "select ho_ten, count(member_username) as 'soluong' from temp group by member_username order by soluong DESC limit 5;";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.executeUpdate("DROP TABLE IF EXISTS  temp;");
			ptmt.executeUpdate("create TEMPORARY  table temp as select member.ho_ten,result.member_username from member,result  where member.username=result.member_username;");
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				Member a = new Member(rs.getString(1), "", 0, rs.getInt(2));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	public static boolean check_200_question(String id) {
		Connection conn = DBConnection.CreateConn();
		String sql = "SELECT count(*) FROM finalweb.exam where exam_id="+id;
		int k=0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				k = rs.getInt(1);
			}
			if(k==200) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}public static boolean check_exist(String id) {
		Connection conn = DBConnection.CreateConn();
		String sql = "SELECT * FROM finalweb.exam_info where exam_id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				return false;
			}
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Member> getListUser(int start,int count){
		Connection conn = DBConnection.CreateConn();
		String sql = "select * from member where admin=0 limit " + (start - 1) + ", " + count;
		List<Member> listMem = new ArrayList<Member>();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				Member a = new Member(rs.getString("ho_ten"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("date"));
				listMem.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listMem;
	}
	public static List<Member> getListUser_ban(int start,int count){
		Connection conn = DBConnection.CreateConn();
		String sql = "select * from member where admin=5 limit " + (start - 1) + ", " + count;
		List<Member> listMem = new ArrayList<Member>();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				Member a = new Member(rs.getString("ho_ten"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("date"));
				listMem.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listMem;
	}
	public static int CountUser() {
		Connection conn = DBConnection.CreateConn();
		String sql = "select count(*) from member where admin=0";
		int k =0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				k = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	public static int CountCmt() {
		Connection conn = DBConnection.CreateConn();
		String sql = "select count(*) from comment";
		int k =0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				k = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	public static int CountUser_ban() {
		Connection conn = DBConnection.CreateConn();
		String sql = "select count(*) from member where admin=5";
		int k =0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				k = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k;
	}
	public static boolean BanUser(String username) {
		Connection conn = DBConnection.CreateConn();
		String sql = "update member set admin=5 where username='"+username+"'";
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
	public static boolean UnbanUser(String username) {
		Connection conn = DBConnection.CreateConn();
		String sql = "update member set admin=0 where username='"+username+"'";
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
	public static List<Comment> showCmtPage(Connection conn,int start,int count) {
		List<Comment> listCmt = new ArrayList<Comment>();
		String sql = "select * from comment,member where comment.cmt_member_id=member.username order by comment.cmt_checked asc,comment.cmt_time desc limit "+(start-1)+", "+count;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String cmt_id = rs.getString("cmt_id");
				String cmt_post_id = rs.getString("cmt_post_id");
				String cmt_member_id = rs.getString("cmt_member_id");
				String cmt_content = rs.getString("cmt_content");
				String cmt_member_name = rs.getString("ho_ten");
				String cmt_time = rs.getString("cmt_time");
				int check = rs.getInt("cmt_checked");
				
				Comment a = new Comment(cmt_id,cmt_post_id, cmt_content, cmt_member_id, cmt_member_name, cmt_time,check);
				listCmt.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCmt;
	}
	public static boolean DeletePost(Connection conn, String id) {
		String sql = "DELETE FROM post WHERE post_id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}

	}
	public static boolean DeleteCmtinPost(Connection conn, String id) {
		String sql = "DELETE FROM comment WHERE cmt_post_id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}

	}
	public static boolean DeleteCmt(Connection conn, String id) {
		String sql = "DELETE FROM comment WHERE cmt_post_id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);

			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}

	}
	public static Post getPost(String id) {
		Post post = new Post();
		Connection conn = DBConnection.CreateConn();
		String sql = "SELECT * FROM finalweb.post where post_id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				post = new Post(rs.getString("post_content"), "", rs.getString("post_title"), rs.getString("post_describe"), rs.getString("post_date"),rs.getInt("post_id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return post;
	}
	public static boolean updatePost(String id, String title, String content, String describe) {
		Connection conn = DBConnection.CreateConn();
		String sql = "update post set post_title='"+title+"',post_content='"+content+"',post_describe='"+describe+"' where post_id=" + id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			int k = ptmt.executeUpdate();
			if(k!=0) {
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
