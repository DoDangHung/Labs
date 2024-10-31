package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Post;
import DAO.PostDAO;
import DB.DBConnection;

@WebServlet("/AdminPostController")
public class AdminPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminPostController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.getRequestDispatcher("ViewAd/AddPost.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			Connection conn = DBConnection.CreateConn();
			request.setCharacterEncoding("utf-8");
			String content = request.getParameter("content");
			String title = request.getParameter("title");
			String describe = request.getParameter("describe");
			String image = "";
			Post post = new Post(content, image, title, describe);

			if (PostDAO.InsertPost(conn, post)) {
				int id = PostDAO.GetIdPost(conn);
				request.setAttribute("id", id);
				request.getRequestDispatcher("ViewAd/UploadImage.jsp").forward(request, response);
			} else {
				request.setAttribute("messPost", "Thêm bài viết thất bại");
				request.getRequestDispatcher("ViewAd/AddPost.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
		

	}

}
