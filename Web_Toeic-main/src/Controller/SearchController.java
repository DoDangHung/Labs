package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Post;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("search");
		Connection conn = DBConnection.CreateConn();
		List<Post> list = PostDAO.Search(conn, key);
		List<Post> listRePost = PostDAO.showPostPage(conn, 1, 3);
		request.setAttribute("listPost", list);
		request.setAttribute("tukhoa", key);
		request.setAttribute("listRePost", listRePost);
		request.getRequestDispatcher("View/Search.jsp").forward(request, response);
		
	}

}
