package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;

import BEAN.Member;
import DAO.LoginDAO;
import DAO.RegisterDAO;
import DB.DBConnection;

/**
 * Servlet implementation class RegisterFoward
 */
@WebServlet("/RegisterFoward")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("sessionuser")!=null || session.getAttribute("sessionadmin")!=null) {
			request.getRequestDispatcher("HomeController").forward(request, response);
		}else {
			request.getRequestDispatcher("View/Register.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConn();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String user = request.getParameter("memberuser_reg");
		String p = request.getParameter("memberpass_reg");
		String pass = BCrypt.hashpw(p, BCrypt.gensalt()); // mã hóa thành hàm băm
		String email = request.getParameter("memberemail");
		if (RegisterDAO.checkuser(conn, user, email)==true) {
			Member mb = new Member(name, user, pass, email);
			
			//gui mail
			String host="smtp.gmail.com";
			String port="587";
			String user1="edumegavn.cskh@gmail.com";
			String pass1="V1i6n0h6";
			String subject="Xác nhận tài khoản EdumegaVN";
			try {
				String randomPassword = RandomStringUtils.randomAlphanumeric(12);
				String link = "http://localhost:8080/FinalProject/Verify?code="+randomPassword+"&username="+user;
				String content="Chào bạn, \nCám ơn bạn đã tin tưởng hệ thống EdumegaVN. \n Bạn vui lòng xác nhận tài khoản bằng cách click vào link: "+link;
				LoginDAO.sendEmail(host, port, user1, pass1, email, subject, content); // hàm send mail
				RegisterDAO.InsertUser(request, response, conn, mb, randomPassword);
			} catch (Exception ex) {
				ex.printStackTrace();
				request.setAttribute("message","Lỗi hệ thống!");
				request.getRequestDispatcher("View/Register.jsp").forward(request, response);
			} 
			
			
		}else {
			request.setAttribute("message","Tài khoản hoặc email đã tồn tại.");
			request.getRequestDispatcher("View/Register.jsp").forward(request, response);
		}
		

	}

}
