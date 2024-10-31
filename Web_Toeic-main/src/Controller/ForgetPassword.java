package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;

import DAO.LoginDAO;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("View/ForgetPassword.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String host="smtp.gmail.com";
		String port="587";
		String user="edumegavn.cskh@gmail.com";
		String pass="V1i6n0h6";
		String subject="Lấy lại mật khẩu EdumegaVN";
		request.setCharacterEncoding("utf-8");
		
		if(LoginDAO.searchEmail(email)) {
			try {
				String randomPassword = RandomStringUtils.randomAlphanumeric(12);
				String content="Chào bạn, đây là mật khẩu mới của bạn: "+randomPassword+"\nCám ơn bạn đã tin tưởng hệ thống EdumegaVN.";
				LoginDAO.sendEmail(host, port, user, pass, email, subject, content); // hàm send mail
				String ePass = BCrypt.hashpw(randomPassword, BCrypt.gensalt());
				if(LoginDAO.resetPass(email, ePass)) {
					request.setAttribute("mess","Bạn vui lòng kiểm tra hộp thư!");
					request.getRequestDispatcher("View/ForgetPassword.jsp").forward(request, response);
				}else {
					request.setAttribute("messFail","Lỗi hệ thống!");
					request.getRequestDispatcher("View/ForgetPassword.jsp").forward(request, response);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				request.setAttribute("messFail","Lỗi hệ thống!");
				request.getRequestDispatcher("View/ForgetPassword.jsp").forward(request, response);
			} 
		}else {
			request.setAttribute("messFail", "Email không tồn tại!");
			request.getRequestDispatcher("View/ForgetPassword.jsp").forward(request, response);
		}
	}

}
