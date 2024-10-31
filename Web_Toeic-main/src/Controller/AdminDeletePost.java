package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import DAO.ExamDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class DeletePost
 */
@WebServlet("/AdminDeletePost")
public class AdminDeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeletePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			Connection conn = DBConnection.CreateConn();
			String id = request.getParameter("idPost");
			if(AdminDAO.DeletePost(conn, id)) {
				AdminDAO.DeleteCmtinPost(conn, id);
				request.setAttribute("messPost", "Xóa bài viết thành công!");
				request.getRequestDispatcher("AdminQuanLiPostFoward?pageid=1").forward(request, response);
			}else {
				request.setAttribute("messFail", "Xóa bài viết thất bại!");
				request.getRequestDispatcher("AdminQuanLiPostFoward?pageid=1").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("request.getRequestDispatcher(\"View/404.jsp\").forward(request, response);").forward(request, response);
		};
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
