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
import BEAN.Post;
import DAO.PostDAO;
import DB.DBConnection;

@WebServlet("/Noidungbaiviet")
public class Noidungbaiviet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Noidungbaiviet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConn();
		List<Post> listPost = PostDAO.showPostPage(conn, 1, 3);
		Post post = new Post();
		String id = request.getParameter("pageid");
		post = PostDAO.showNoiDungBaiviet(conn, id);
		List<Comment> listCmt = PostDAO.ShowComment(conn, id);
		List<Post> listRePost = PostDAO.showPostPage(conn, 1, 3);
		request.setAttribute("listRePost", listRePost);
		
		
	
		
		request.setAttribute("kitutrongdatabase1", "\n");
		request.setAttribute("kitutronghtml1", "<br/>");
		request.setAttribute("kitutrongdatabase2", "$");
		request.setAttribute("kitutronghtml2", '"');
		request.setAttribute("post",post);
		request.setAttribute("list",listPost);
		request.setAttribute("listCmt",listCmt);
		
		request.getRequestDispatcher("View/Noidungbaiviet.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
