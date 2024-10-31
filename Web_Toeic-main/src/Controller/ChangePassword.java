package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCrypt;

import BEAN.Member;
import DAO.ProfileDAO;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String member_username = session.getAttribute("sessionuserid").toString();
		Member a = ProfileDAO.getMember(member_username);
		request.setAttribute("profile", a);
		request.getRequestDispatcher("View/ChangePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("passnew");
		String passnew = BCrypt.hashpw(p, BCrypt.gensalt());
		String passold = request.getParameter("passold");
		HttpSession session = request.getSession(true);
		String member_username = session.getAttribute("sessionuserid").toString();
		Member a = ProfileDAO.getMember(member_username);
		
		if(BCrypt.checkpw(passold, a.getPassword())) {
			if(ProfileDAO.changePassword(a, passnew)) {
				request.setAttribute("messPass", "Đổi mật khẩu thành công");
				request.setAttribute("profile", a);
				request.getRequestDispatcher("View/ChangePassword.jsp").forward(request, response);
			}else {
				request.setAttribute("messPassFail", "Đổi mật khẩu thất bại");
				request.setAttribute("profile", a);
				request.getRequestDispatcher("View/ChangePassword.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("profile", a);
			request.setAttribute("messPassFail", "Mật khẩu không chính xác");
			request.getRequestDispatcher("View/ChangePassword.jsp").forward(request, response);
		}
		
	}

}
