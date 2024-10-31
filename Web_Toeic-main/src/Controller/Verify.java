package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;
import DB.DBConnection;

/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConn();
		String code = request.getParameter("code");
		String username = request.getParameter("username");
		if(RegisterDAO.checkVerify(conn, username, code)) {
			RegisterDAO.verify(code, username);
			RegisterDAO.deleteCodeVerify(code, username);
			request.setAttribute("messageSuccess","Kích hoạt tài khoản thành công.");
			request.getRequestDispatcher("View/Login.jsp").forward(request, response);
		}else {
			RegisterDAO.verify(code, username);
			request.setAttribute("message","Kích hoạt tài khoản thất bại.");
			request.getRequestDispatcher("View/Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
