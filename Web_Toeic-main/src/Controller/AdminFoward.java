package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.AdminDAO;

/**
 * Servlet implementation class AdminFoward
 */
@WebServlet("/AdminFoward")
public class AdminFoward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFoward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int member_current_month = AdminDAO.member_current_month();
		int cmt_current_month=AdminDAO.cmt_current_month();
		int test_current_month = AdminDAO.test_current_month();
		
		List<Member> listTopCmt = new ArrayList<Member>();
		listTopCmt = AdminDAO.Top_Cmt();
		List<Member> listTopTesting = new ArrayList<Member>();
		listTopTesting = AdminDAO.Top_testing();
		
		
		
		
		
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.setAttribute("listTopCmt", listTopCmt);
			request.setAttribute("listTopTesting", listTopTesting);
			request.setAttribute("member_current_month", member_current_month);
			request.setAttribute("cmt_current_month", cmt_current_month);
			request.setAttribute("test_current_month", test_current_month);
			request.getRequestDispatcher("ViewAd/Home.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int member_current_month = AdminDAO.member_current_month();
		int cmt_current_month = AdminDAO.cmt_current_month();
		int test_current_month = AdminDAO.test_current_month();
		List<Member> listTopCmt = new ArrayList<Member>();
		listTopCmt = AdminDAO.Top_Cmt();
		List<Member> listTopTesting = new ArrayList<Member>();
		listTopTesting = AdminDAO.Top_testing();
		
		
		
		
		
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.setAttribute("listTopCmt", listTopCmt);
			request.setAttribute("listTopTesting", listTopTesting);
			request.setAttribute("member_current_month", member_current_month);
			request.setAttribute("cmt_current_month", cmt_current_month);
			request.setAttribute("test_current_month", test_current_month);
			request.getRequestDispatcher("ViewAd/Home.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
	}

}
