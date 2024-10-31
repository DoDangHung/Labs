package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.LoginDAO;
import DB.DBConnection;

/**
 * Servlet implementation class LoginFowar
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sessionuser")!=null || session.getAttribute("sessionadmin")!=null) {
			request.getRequestDispatcher("HomeController").forward(request, response);
		}else {
			request.getRequestDispatcher("View/Login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = new DBConnection().CreateConn();
		
		String user,pass;
		user = request.getParameter("memberuser");
		pass = request.getParameter("memberpass");
		
		Member a = new Member(user,pass);
		String check = LoginDAO.CheckLogin(a, conn, request, response); // check pass coi đúng không, check sẽ nhận 3 giá trị,'failed' là k tồn tại, errorPass là sai pass, success là oke
		String name=LoginDAO.getName(a, conn, request, response);
		if(check.equals("failed")) {
			request.setAttribute("message","Tài khoản không tồn tại");
			request.getRequestDispatcher("View/Login.jsp").forward(request, response);
		}else if(check.equals("errorPass")) {
			request.setAttribute("message","Mật khẩu không chính xác");
			request.getRequestDispatcher("View/Login.jsp").forward(request, response);
		}else if(check.equals("success")) {
			if(LoginDAO.checkAdmin(a, conn, request, response).equals("0")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("sessionuser",name);
				session.setAttribute("sessionuserid",user);
				request.getRequestDispatcher("HomeController").forward(request, response);
			}else if(LoginDAO.checkAdmin(a, conn, request, response).equals("1")){
				HttpSession session = request.getSession(true);
				session.setAttribute("sessionadmin",name);
				session.setAttribute("sessionadminid",user);
				request.getRequestDispatcher("HomeController").forward(request, response);
			}else if(LoginDAO.checkAdmin(a, conn, request, response).equals("5")){
				request.setAttribute("message","Tài khoản của bạn bị khóa. Vui lòng liên hệ admin.");
				request.getRequestDispatcher("View/Login.jsp").forward(request, response);
			}else if(LoginDAO.checkAdmin(a, conn, request, response).equals("2")){
				request.setAttribute("message","Tài khoản chưa được kích hoạt. Vui lòng kiểm tra hộp thư");
				request.getRequestDispatcher("View/Login.jsp").forward(request, response);
			}
		}
	}

}
