package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Post;
import DAO.AdminDAO;

/**
 * Servlet implementation class AdminPostEdit
 */
@WebServlet("/AdminPostEdit")
public class AdminPostEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPostEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			String postid= request.getParameter("postid");
			Post post = AdminDAO.getPost(postid);
			request.setAttribute("post", post);
			request.getRequestDispatcher("ViewAd/EditPost.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			request.setCharacterEncoding("utf-8");
			String postid = request.getParameter("postid");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String describe = request.getParameter("describe");
			if(AdminDAO.updatePost(postid, title, content, describe)) {
				request.setAttribute("messUpdate", "Cập nhật bài viết thành công");
				request.getRequestDispatcher("AdminQuanLiPostFoward?pageid=1").forward(request, response);
			}else {
				request.setAttribute("messFail", "Cập nhật bài viết thất bại");
				request.getRequestDispatcher("AdminQuanLiPostFoward?pageid=1").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
	}

}
