package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Exam;
import DAO.ExamDAO;

/**
 * Servlet implementation class FinishExam
 */
@WebServlet("/FinishExam")
public class FinishExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinishExam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Exam> listAnw = new ArrayList<Exam>();
		int id = Integer.parseInt(request.getParameter("examid"));
		List<Exam> listExam = ExamDAO.getExam(id);
		for (int i = 1; i <= 200; i++) {
			String anw = request.getParameter("" + i + "");
			Exam a = new Exam();
			a.setQuestionnumber(i);
			a.setCorrect_anwser(anw);
			listAnw.add(a);
		}
		int scores_reading = 0, scores_listenning = 0;
		
		for (Exam a : listExam) {
			for (Exam b : listAnw) {
				if (a.getQuestionnumber()==b.getQuestionnumber() && a.getQuestionnumber()<=100) {
					if(a.getCorrect_anwser().equals(b.getCorrect_anwser())) {
						scores_listenning=scores_listenning+1;
					}
				}
				if (a.getQuestionnumber()==b.getQuestionnumber() && a.getQuestionnumber()>100) {
					if(a.getCorrect_anwser().equals(b.getCorrect_anwser())) {
						scores_reading=scores_reading+1;
					}
				}
				
			}
		}
		request.setAttribute("listAnw", listAnw);
		request.setAttribute("exam_id",id);
		request.setAttribute("scores_reading", scores_reading);
		request.setAttribute("scores_listenning", scores_listenning);
		request.setAttribute("listExam", listExam);
		request.getRequestDispatcher("View/Result.jsp").forward(request, response);
	}

}
