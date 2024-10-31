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
import DB.DBConnection;

/**
 * Servlet implementation class AdminDeleteExam
 */
@WebServlet("/AdminDeleteExam")
public class AdminDeleteExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteExam() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			String id=request.getParameter("id");
			if(ExamDAO.deleteExam(id)) {
				if(ExamDAO.deleteQuestion(id)) {
					request.setAttribute("mess", "Xóa thành công");
					request.getRequestDispatcher("AdminQuanLiExam").forward(request, response);
				}else {
					request.setAttribute("mess", "Xóa thất bại");
					request.getRequestDispatcher("AdminQuanLiExam").forward(request, response);
				}
			}else {
				request.setAttribute("mess", "Xóa thất bại");
				request.getRequestDispatcher("AdminQuanLiExam").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
