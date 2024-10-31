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
import BEAN.Post;
import DAO.AdminDAO;
import DAO.PostDAO;
import DB.DBConnection;

/**
 * Servlet implementation class AdminQuanLiComment
 */
@WebServlet("/AdminQuanLiComment")
public class AdminQuanLiComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQuanLiComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionadmin")!=null) {
			int pageid = Integer.parseInt(request.getParameter("pageid"));
			int count = 10;
			if(pageid!=1) {
				pageid = pageid - 1;
				pageid = pageid * count +1;
			}
			
			int maxpageid;
			int CountPage = AdminDAO.CountCmt();
			if((CountPage%count)==0 && CountPage>=10) {
				maxpageid = (CountPage/ count);
			}else {
				maxpageid = CountPage/ count +1;
			}
			request.setAttribute("maxpageid", maxpageid);
			request.setAttribute("numberpage", Integer.parseInt(request.getParameter("pageid")));
			
			
			Connection conn = new DBConnection().CreateConn();
			List<Comment> listCmt = new ArrayList<Comment>();
			listCmt = AdminDAO.showCmtPage(conn,pageid,count);
			
			request.setAttribute("listCmt", listCmt);
			request.getRequestDispatcher("ViewAd/QuanLiCmt.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
