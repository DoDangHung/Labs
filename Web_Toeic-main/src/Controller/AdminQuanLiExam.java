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
import javax.servlet.http.HttpSession;

import BEAN.Comment;
import BEAN.Exam_info;
import DAO.ExamDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class AdminQuanLiExam
 */
@WebServlet("/AdminQuanLiExam")
public class AdminQuanLiExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQuanLiExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			List<Exam_info> listExam = ExamDAO.getListExam();
			request.setAttribute("listExam", listExam);
			request.getRequestDispatcher("ViewAd/QuanLiExam.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			List<Exam_info> listExam = ExamDAO.getListExam();
			request.setAttribute("listExam", listExam);
			request.getRequestDispatcher("ViewAd/QuanLiExam.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
	}

}
