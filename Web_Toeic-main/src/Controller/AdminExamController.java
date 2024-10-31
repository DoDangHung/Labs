package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import DAO.ExamDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class AdminExamController
 */
@WebServlet("/AdminExamController")
public class AdminExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminExamController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.getRequestDispatcher("ViewAd/AddExam.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("View/Home.jsp").forward(request, response);
		};
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.setCharacterEncoding("utf8");
			Connection conn = DBConnection.CreateConn();
			String title = request.getParameter("title");
			String id = request.getParameter("id");
			if(AdminDAO.check_exist(id)) {
				if(ExamDAO.InsertExam(conn, title, id)) {
					request.setAttribute("id", id);
					request.getRequestDispatcher("ViewAd/UploadMultiFile.jsp").forward(request, response);
				}else {
					request.setAttribute("messExamFail", "Lỗi hệ thống chưa thể thêm đề thi!");
					request.getRequestDispatcher("ViewAd/AddExam.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("messExamFail", "Mã đề thi đã tồn tại!");
				request.getRequestDispatcher("ViewAd/AddExam.jsp").forward(request, response);
			}
			
		}else {
			request.getRequestDispatcher("View/Home.jsp").forward(request, response);
		};
	}

}
