package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAtt;
import Entity.History;
import Entity.User;
import Entity.Video;
import Service.HistoryServiceImpl;
import Service.StatsServiceImpl;
import Service.VideoServiceImpl;
import Storage.UserHistory;
import Storage.UserVideo;

/**
 * Servlet implementation class UserVideoServlet
 */
@WebServlet({"/views/user/video","/user/video"})
public class UserVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StatsServiceImpl dao = new StatsServiceImpl();
       private VideoServiceImpl daov = new VideoServiceImpl();
       private HistoryServiceImpl daoh = new HistoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SessionAtt.CURRENT_USER);
		if(user == null) {
			response.sendRedirect("/asm2/views/Account?action=dang-nhap");
			return;
		}
		List<UserVideo> list = dao.getAllUserVideo(user.getUserId());
		List<UserHistory> list_history = dao.getAllUserHistory(user.getUserId());
		
		String videoid = request.getParameter("videoid");
		if(videoid != null) {

			Video v = daov.findByID(Integer.parseInt(videoid));
			if(v != null) {
				daoh.updateLikeOrUnlike(user,v);
				response.sendRedirect("/asm2/views/user/video");
				return;
			}
		
				
		}
		
		if(list != null) {
			
			request.setAttribute("list", list);
		}
		if(list_history != null) {
			
			
			request.setAttribute("list_history", list_history);
			
			
		}
		String includeFile = null;
		includeFile = "/views/user_video.jsp";

			request.setAttribute("includeFile", includeFile);
			request.getRequestDispatcher("/views/user_home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
