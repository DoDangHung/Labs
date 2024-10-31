package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Exam_info;
import BEAN.Post;
import DAO.ExamDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class ExamController
 */
@WebServlet("/ExamController")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Exam_info> listExam = new ArrayList<Exam_info>();
		Connection conn = DBConnection.CreateConn();
		int pageid = Integer.parseInt(request.getParameter("pageid"));
		
		int count = 4;
		if(pageid!=1) {
			pageid = pageid - 1;
			pageid = pageid * count +1;
		}
		
		int maxpageid;
		int CountPage = ExamDAO.CoutPage();
		if((CountPage%count)==0 && CountPage>=4) {
			maxpageid = (CountPage/ count);
		}else {
			maxpageid = CountPage/ count +1;
		}
		listExam = ExamDAO.GetListExam4(pageid,count);
		List<Post> listRePost = PostDAO.showPostPage(conn, 1, 3);
		request.setAttribute("listRePost", listRePost);
		request.setAttribute("maxpageid", maxpageid);
		request.setAttribute("numberpage", Integer.parseInt(request.getParameter("pageid")));
		request.setAttribute("listExam", listExam);
		request.getRequestDispatcher("View/ListExam.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
