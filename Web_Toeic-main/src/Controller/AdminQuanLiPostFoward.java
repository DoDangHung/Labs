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

import BEAN.Exam_info;
import BEAN.Post;
import DAO.ExamDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class QuanLiPostFoward
 */
@WebServlet("/AdminQuanLiPostFoward")
public class AdminQuanLiPostFoward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQuanLiPostFoward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			Connection conn = new DBConnection().CreateConn();
			List<Post> listPost = new ArrayList<Post>();
			String id = request.getParameter("pageid");
			int pageid=Integer.parseInt(id);
			if(id!=null) {
				
			}
			
			int count = 10;
			if (pageid != 1) {

				pageid = pageid -1;
				pageid = pageid * count +1;	

			}
			int CountPost = PostDAO.ShowCount(conn);
			int maxpageid=0;
			if(CountPost%count==0 && CountPost>=10) {
				maxpageid = (CountPost/ count);
			}else {
				maxpageid = (CountPost/ count)+1;
			}
			listPost = PostDAO.showPostPage(conn, pageid, count);
			
			request.setAttribute("maxpageid", maxpageid);
			request.setAttribute("numberpage", Integer.parseInt(id));
			request.setAttribute("listPost", listPost);
			request.getRequestDispatcher("ViewAd/QuanLiPost.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
