package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ExamDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class UploadMultiFile
 */
@WebServlet("/AdminUploadMultiFile")
public class AdminUploadMultiFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUploadMultiFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("sessionadmin") != null) {
			request.getRequestDispatcher("ViewAd/UploadMultiFile.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String k = request.getParameter("id");
		int id = Integer.parseInt(k);
		HttpSession session = request.getSession(true);
		if (session.getAttribute("sessionadmin") != null) {
			if (ExamDAO.UploadMultiFile(request, response)) {
				if (ExamDAO.ImportExcel(request, response, id)) {
					request.setAttribute("messExam", "Thêm bài thi và file bài thi thành công");
					request.getRequestDispatcher("AdminQuanLiExam").forward(request, response);
				} else {
					request.setAttribute("messExamFail", "Thêm bài thi và file bài thi thất bại");
					request.getRequestDispatcher("AdminQuanLiExam").forward(request, response);
				}
			} else {
				request.setAttribute("messExamFail", "Thêm file bài thi thất bại");
				request.getRequestDispatcher("AdminQuanLiExam").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		}
	}

}
