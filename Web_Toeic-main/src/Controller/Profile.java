package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.ProfileDAO;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
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
		request.getRequestDispatcher("View/Profile.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String member_username = session.getAttribute("sessionuserid").toString();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Member a = new Member(name, member_username, "", email);
		if(ProfileDAO.check_email(a)) {
			if(ProfileDAO.updateInfo(a)) {
				
				request.setAttribute("mess","Cập nhật thành công");
				Member a1 = ProfileDAO.getMember(member_username);
				request.setAttribute("profile", a1);
				session.setAttribute("sessionuser",a1.getHo_ten());
				request.getRequestDispatcher("View/Profile.jsp").forward(request, response);
			}else {
				request.setAttribute("messFail","Cập nhật thất bại");
				Member a1 = ProfileDAO.getMember(member_username);
				request.setAttribute("profile", a1);
				request.getRequestDispatcher("View/Profile.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("messFail","Email đã được đăng kí. Vui lòng sử dụng email khác");
			Member a1 = ProfileDAO.getMember(member_username);
			request.setAttribute("profile", a1);
			request.getRequestDispatcher("View/Profile.jsp").forward(request, response);
		}
		
	}

}
