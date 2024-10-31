package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.SlideBannerBEAN;
import DAO.SlideBannerDAO;
import DB.DBConnection;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.CreateConn();
		List<SlideBannerBEAN> list = SlideBannerDAO.ShowBanner(conn);
		request.setAttribute("banner", list);
		request.getRequestDispatcher("View/Home.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		new DBConnection();
		Connection conn = DBConnection.CreateConn();
		List<SlideBannerBEAN> list = SlideBannerDAO.ShowBanner(conn);
		request.setAttribute("banner", list);
		request.getRequestDispatcher("View/Home.jsp").forward(request, response);
	}

}
