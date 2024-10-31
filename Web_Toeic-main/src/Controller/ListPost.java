package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class ListPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConn();
		List<Post> listPost = new ArrayList<Post>();
		int pageid = Integer.parseInt(request.getParameter("pageid"));
		int count = 4;
		if(pageid!=1) {
			pageid = pageid - 1;
			pageid = pageid * count +1;
		}
		
		int maxpageid=0;
		int CountPage = PostDAO.ShowCount(conn);
		if(CountPage%count==0 && CountPage>=4) {
			maxpageid = (CountPage/ count);
		}else {
			maxpageid = CountPage/ count +1;
		}
		listPost = PostDAO.showPostPage(conn, pageid, count);
		List<Post> listRePost = PostDAO.showPostPage(conn, 1, 3);
		
		request.setAttribute("maxpageid", maxpageid);
		request.setAttribute("numberpage", Integer.parseInt(request.getParameter("pageid")));
		request.setAttribute("listPost", listPost);
		request.setAttribute("listRePost", listRePost);
		request.getRequestDispatcher("View/ListPost.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
