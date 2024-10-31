package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.Comment;
import BEAN.Post;

public class PostDAO {
	public static List<Post> showPost(Connection conn) {
		List<Post> listPost = new ArrayList<Post>();
		String sql = "SELECT * FROM finalweb.post order by post_id desc";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("post_id");
				String title = rs.getString("post_title");
				String content = rs.getString("post_content");
				String img = rs.getString("post_image");
				String des = rs.getString("post_describe");

				Post a = new Post(content, img, title, des, id);
				listPost.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPost;
	}
	public static int ShowCount(Connection conn) {
		int count=0;
		
		String sql = "SELECT count(*) from post";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs  = ptmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	public static List<Post> showPostPage(Connection conn, int start, int count) {
		List<Post> listPost = new ArrayList<Post>();
		String sql = "select * from post order by post_id desc limit "+(start-1)+", "+count;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("post_id");
				String title = rs.getString("post_title");
				String content = rs.getString("post_content");
				String img = rs.getString("post_image");
				String des = rs.getString("post_describe");
				String time = rs.getString("post_date");

				Post a = new Post(content, img, title, des,time, id);
				listPost.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPost;
	}
	public static Post showNoiDungBaiviet(Connection conn, String id) {
		Post post = new Post();
		String sql = "select * from post where post_id="+id;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("post_id");
				String title = rs.getString("post_title");
				String content = rs.getString("post_content");
				String img = rs.getString("post_image");
				String des = rs.getString("post_describe");
				String time = rs.getString("post_date");

				post = new Post(content, img, title, des,time, i);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return post;
	}

	public static String UploadImg(Connection conn, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String test = "";
		ServletContext context = request.getServletContext();
		response.setContentType("text/html; charset=UTF-8");

		final String Address = "C:\\Users\\lamqu\\eclipse-workspace\\FinalProject\\WebContent\\ImgUpload";
		// final String Address = "F://";
		final int MaxMemorySize = 1024 * 1024 * 3; // 3MB
		final int MaxRequestSize = 1024 * 1024 * 50; // 50 MB

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
			test = "failed";
			return test;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(MaxMemorySize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);

		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);

			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (!item.isFormField()) {
					String fileName = item.getName();
					test = fileName;
					// pathFile: vị trí mà chúng ta muốn upload file vào
					// gửi cho server

					String pathFile = Address + File.separator + fileName;

					File uploadedFile = new File(pathFile);

					boolean kt = uploadedFile.exists();

					try {

						if (kt == true) {

							test = "failed";
						} else {
							item.write(uploadedFile);
							test = fileName;
						}

					} catch (Exception e) {

						test = e.getMessage();
					}
				} else {
					test = "failed";
				}
			}

		} catch (FileUploadException e) {
			test = "failed";
			return test;
		}

		return test;
	}

	public static boolean InsertPost(Connection conn, Post post) {
		String sql = "insert into post(post_title,post_image,post_describe,post_content) values(?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			String title = post.getTitle();
			String des = post.getDescribe();
			String img = post.getImage();
			String content = post.getContent();
			
			ptmt.setString(1, title);
			ptmt.setString(2, img);
			ptmt.setString(3, des);
			ptmt.setString(4, content);

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
	public static int GetIdPost(Connection conn) {
		String sql = "SELECT @@IDENTITY asLastID";
		int id=0;
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("asLastID");
			}
			ptmt.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return id;

	}
	public static boolean InsertImg(Connection conn, String image, String id) {
		String sql = "UPDATE post SET post_image='"+image+"' WHERE post_id=" + id;
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
	
	public static List<Post> Search(Connection conn, String key) {
		String sql = "SELECT * from post where post_title like '%"+key+"%' or post_content like '%"+key+"%'";
		List<Post> listPost = new ArrayList<Post>();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("post_id");
				String title = rs.getString("post_title");
				String content = rs.getString("post_content");
				String img = rs.getString("post_image");
				String des = rs.getString("post_describe");

				String time = rs.getString("post_date");
				Post post = new Post(content, img, title, des,time, i);
				listPost.add(post);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listPost;
	}
	public static List<Comment> ShowComment(Connection conn, String id) {
		String sql = "select * from comment,member where comment.cmt_post_id="+id+" and comment.cmt_checked=1 and comment.cmt_member_id=member.username and member.admin=0 order by comment.cmt_time Desc";
		List<Comment> listCmt = new ArrayList<Comment>();
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String id_post = rs.getString("cmt_post_id");
				String member_id = rs.getString("cmt_member_id");
				String member_name = rs.getString("ho_ten");
				String cmt_content = rs.getString("cmt_content");
				String cmt_time = rs.getString("cmt_time");

				Comment a = new Comment(id_post, cmt_content, member_id, member_name, cmt_time);
				listCmt.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listCmt;
	}
	public static boolean InsertComment(Connection conn, Comment cmt) {
		String sql = "insert into comment(cmt_post_id,cmt_member_id,cmt_content) values(?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,cmt.getId_post());
			ptmt.setString(2,cmt.getMember_id());
			ptmt.setString(3,cmt.getCmt_content());
			
			

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
		String sql = "DELETE FROM comment WHERE cmt_id="+id;
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
	public static boolean AcceptCmt(Connection conn, String id) {
		String sql = "UPDATE comment set cmt_checked=1 where cmt_id="+id;
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
}
