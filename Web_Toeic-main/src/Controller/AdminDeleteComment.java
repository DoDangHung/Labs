package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class AdminDeleteComment
 */
@WebServlet("/AdminDeleteComment")
public class AdminDeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteComment() {
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
			String check = request.getParameter("check");
			String id = request.getParameter("id");
			if(check.equals("delete")) {
				if(PostDAO.DeleteCmt(conn, id)) {
					request.setAttribute("delete","Xóa bình luận thành công");
				}else {
					request.setAttribute("deleteFail","Xóa bình luận thất bại");
				}
				
				
			}else if(check.equals("accept")){
				PostDAO.AcceptCmt(conn, id);
			}
			request.getRequestDispatcher("AdminQuanLiComment?pageid=1").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
