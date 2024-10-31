package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Comment;
import DAO.PostDAO;
import DB.DBConnection;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommentController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConn();
		String id_post = request.getParameter("id_post");
		String member_id = request.getParameter("member_id");
		String member_name = request.getParameter("member_name");
		String cmt_content = request.getParameter("cmt_content");
		
		Comment cmt = new Comment(id_post, cmt_content, member_id, member_name);
		
		PostDAO.InsertComment(conn, cmt);
		
		List<Comment> listCmt = PostDAO.ShowComment(conn, id_post);
		
		request.setAttribute("listCmt",listCmt);
		request.getRequestDispatcher("View/Comment.jsp").forward(request, response);
		
		
		
	}

}
