package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ExamDAO;

/**
 * Servlet implementation class SaveResult
 */
@WebServlet("/SaveResult")
public class SaveResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.getRequestDispatcher("ExamController?pageid=1").forward(request, response);
		}else {
			String member_username = session.getAttribute("sessionuserid").toString();
			String examid = request.getParameter("exam_id");
			String resultscore = request.getParameter("result_score");
			int exam_id=Integer.parseInt(examid);
			int result_score=Integer.parseInt(resultscore);
			if(ExamDAO.saveResult(exam_id, result_score, member_username)) {
				request.setAttribute("messSave", "Lưu Thành Công!");
			}else {
				request.setAttribute("messSave", "Lưu Thất Bại!");
			}
			request.getRequestDispatcher("View/ResultSave.jsp").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
