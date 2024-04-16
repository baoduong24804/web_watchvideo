package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.StatsServiceImpl;
import Service.VideoServiceImpl;
import Storage.UserLike;
import Utils.ExcelUtil;

/**
 * Servlet implementation class Statistical_Admin
 */
@WebServlet({"/views/admin/statistical","/statistical"})
public class Statistical_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StatsServiceImpl dao = new StatsServiceImpl();
       private VideoServiceImpl dao2 = new VideoServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statistical_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
//		session.removeAttribute("mes");
//        session.removeAttribute("mes1");
        
		Entity.User currentUser = (Entity.User) session.getAttribute(Constant.SessionAtt.CURRENT_USER);
		if (currentUser == null) {
			response.sendRedirect("/asm2/views/Account?action=dang-nhap");
			return;
		}

		if (currentUser != null && !currentUser.getRole()) {

			response.sendRedirect("/asm2/views/index");
			return;
		}
		
		String videoid = request.getParameter("videoid");
		
		if(videoid != null) {
			Entity.Video vi = dao2.findByID(Integer.parseInt(videoid));
			List<Storage.UserLike> list_user = dao.getUserLikeById(Integer.parseInt(videoid));
			if (list_user != null) {
				
				request.setAttribute("list_user", list_user);
			}
			if (vi != null) {
				
				request.setAttribute("vi", vi);
			}
		}
		
		List<Storage.VideoLike> list_video = dao.getAllVideoLike();
		
		String action = request.getParameter("action");
		if(action != null) {
			
			
			ExcelUtil.chooseDirectoryToSave(ExcelUtil.printSatistical(list_video),"_Statistical");
			response.sendRedirect("/asm2/views/admin/statistical");
			return;
		}
		
		if (list_video != null) {
		
			request.setAttribute("list_video", list_video);
		}
		
		
		
		
		String includeFile = null;
		includeFile = "/views/admin/statistical_admin.jsp";
		
			request.setAttribute("includeFile", includeFile);
			request.getRequestDispatcher("/views/admin/home_admin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
