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

import BEAN.Exam_info;
import BEAN.Post;
import DAO.ExamDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/AdminUploadImage")
public class AdminUploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUploadImage() {
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
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			Connection conn = DBConnection.CreateConn();
			String image;
			String id = request.getParameter("idPost");
			image = PostDAO.UploadImg(conn, request, response);
			if(image.equals("failed")) {
					image = "edumega.jpg";
					PostDAO.InsertImg(conn, image, id);
					request.setAttribute("messPost", "Thêm bài viết thành công");
					request.getRequestDispatcher("AdminQuanLiPostFoward?pageid=1").include(request, response);
			}else{
					PostDAO.InsertImg(conn, image, id);
					request.setAttribute("messPost", "Thêm bài viết thành công");
					request.getRequestDispatcher("AdminQuanLiPostFoward?pageid=1").include(request, response);
			}
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
		

	}

}
