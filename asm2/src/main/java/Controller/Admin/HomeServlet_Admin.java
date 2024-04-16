package Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import Entity.User;
import Service.StatsServiceImpl;
import Service.UserServiceImpl;
import Storage.UserLike;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({ "/views/admin","/admin" })
public class HomeServlet_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StatsServiceImpl statsServiceImpl = new StatsServiceImpl();
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet_Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		session.removeAttribute("mes");
        session.removeAttribute("mes1");
		Entity.User currentUser = (Entity.User) session.getAttribute(Constant.SessionAtt.CURRENT_USER);
		if (currentUser == null) {

			response.sendRedirect("/asm2/views/Account?action=dang-nhap");
			return;
		}
		
		if (currentUser != null && !currentUser.getRole()) {
			
			response.sendRedirect("/asm2/views/index");
			return;
		}
			

			String page = request.getParameter("action");
			String includeFile = "";
			if (page == null) {
				request.getRequestDispatcher("/views/admin/home_admin.jsp").forward(request, response);
				return;
			} else {
				switch (page) {
				case "video":
					includeFile = "/views/admin/video_admin.jsp";
					
					break;
				case "user":
					includeFile = "/views/admin/user_admin.jsp";
					break;
				case "statistical":
					includeFile = "/views/admin/statistical_admin.jsp";
					break;
				default: {
					includeFile = null;
					break;
				}
					
			}
				
				 request.setAttribute("includeFile", includeFile);
				 request.getRequestDispatcher("/views/admin/home_admin.jsp").forward(request, response);

		}

	
		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
