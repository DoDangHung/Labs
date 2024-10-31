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
 * Servlet implementation class AdminChangePassword
 */
@WebServlet("/AdminChangePassword")
public class AdminChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.getRequestDispatcher("ViewAd/ChangePassword.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			String p = request.getParameter("passnew");
			String passnew = BCrypt.hashpw(p, BCrypt.gensalt());
			String passold = request.getParameter("passold");
			String member_admin = session.getAttribute("sessionadminid").toString();
			Member a = ProfileDAO.getMember(member_admin);
			
			if(BCrypt.checkpw(passold, a.getPassword())) {
				if(passnew.equals(passold)) {
					request.setAttribute("messPass", "Mật khẩu mới trùng mật khẩu cũ. Vui lòng chọn mật khẩu khác");
					request.setAttribute("profile", a);
					request.getRequestDispatcher("ViewAd/ChangePassword.jsp").forward(request, response);
				}
				else if(ProfileDAO.changePassword(a, passnew)) {
					request.setAttribute("messPass", "Đổi mật khẩu thành công");
					request.setAttribute("profile", a);
					request.getRequestDispatcher("ViewAd/ChangePassword.jsp").forward(request, response);
				}else {
					request.setAttribute("messPassFail", "Đổi mật khẩu thất bại");
					request.setAttribute("profile", a);
					request.getRequestDispatcher("ViewAd/ChangePassword.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("profile", a);
				request.setAttribute("messPassFail", "Mật khẩu không chính xác");
				request.getRequestDispatcher("ViewAd/ChangePassword.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
	}

}
