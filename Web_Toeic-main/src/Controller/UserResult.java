package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import BEAN.Result;
import DAO.ProfileDAO;

/**
 * Servlet implementation class InforResult
 */
@WebServlet("/InforResult")
public class UserResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String member_username = session.getAttribute("sessionuserid").toString();
		List<Result> list = ProfileDAO.getResult(member_username);
		Member a = ProfileDAO.getMember(member_username);
		request.setAttribute("profile", a);
		request.setAttribute("listResult", list);
		request.getRequestDispatcher("View/InforResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
