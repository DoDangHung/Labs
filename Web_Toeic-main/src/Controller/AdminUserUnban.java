package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;

/**
 * Servlet implementation class AdminUserUnban
 */
@WebServlet("/AdminUserUnban")
public class AdminUserUnban extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserUnban() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			String username = request.getParameter("username");
			if(AdminDAO.UnbanUser(username)) {
				request.setAttribute("messBan", "Cho phép người dùng thành công");
				request.getRequestDispatcher("AdminUserManager_ban?pageid=1").forward(request, response);
			}else {
				request.setAttribute("messFailBan", "Cho phép người dùng thất bại");
				request.getRequestDispatcher("AdminUserManager_ban?pageid=1").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
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
