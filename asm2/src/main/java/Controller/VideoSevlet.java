package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAtt;
import DaoImplement.HistoryDaoImpl;
import Entity.History;
import Entity.User;
import Entity.Video;
import Service.HistoryServiceImpl;
import Service.VideoServiceImpl;

/**
 * Servlet implementation class VideoSevlet
 */
@WebServlet({"/views/video"})
public class VideoSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VideoServiceImpl videoService = new VideoServiceImpl();
       HistoryServiceImpl historyService = new HistoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hêhehesassssssssssssssssssssss");
		String action = request.getParameter("action");
		String share = request.getParameter("share");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		if(action == null) {
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
			return;
		}
		
		if(share != null) {
			action = "share";
		}
		
		switch (action) {
		case "watch":
			doGetWatch(session, id, request, response);
			break;
		case "like":
			doGetLike(session, id, request, response);
			break;
		case "share":
			doShare(session, id, request, response);
			break;
		}
		
	
	}
	
	private void doGetWatch(HttpSession session, String id, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Video video = videoService.findByID(Integer.parseInt(id));
		req.setAttribute("video", video);
		User currrentUser = (User) session.getAttribute(SessionAtt.CURRENT_USER);
		
		//Neu da dang nhap thi click vao xem thi them vao History - xem xem no da like hay chua
		if (currrentUser != null) {
			History history = historyService.create(currrentUser, video);
			req.setAttribute("flagLikedBtn", history.getIsLike());
		}
		/////////// random videoooooooooooooooo
		List<Video> list_video = videoService.getRandomVideo(8);
		req.setAttribute("list_video", list_video);
		req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}

	private void doGetLike(HttpSession session,String id, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/json");
		User currrentUser = (User) session.getAttribute(SessionAtt.CURRENT_USER);
		if(currrentUser == null) {
			resp.sendRedirect("/asm2/views/Account?action=dang-nhap");
			return;
		}
		boolean result = false;
		Video v = videoService.findByID(Integer.parseInt(id));
		if(v != null) {
			
			result = historyService.updateLikeOrUnlike(currrentUser, v);
			//System.out.println("like: "+result);
		}
	 
		if (result == true) {
			resp.setStatus(204);// Success nhma k tra ve data
		} else {
			resp.setStatus(400);// Loi
		}

	}
	
	private void doShare(HttpSession session,String id, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		User currrentUser = (User) session.getAttribute(SessionAtt.CURRENT_USER);
		if(currrentUser == null) {
			resp.sendRedirect("/asm2/views/Account?action=dang-nhap");
			return;
		}
		boolean result = false;
		Video v = videoService.findByID(Integer.parseInt(id));
		if(v != null) {
			try {
				result = true;
				int share = v.getShare()+1;
				v.setShare(share);
				//System.out.println(share);
				//req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
				videoService.update(v, currrentUser);
				//System.out.println("share: "+share);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	 
		if (result == true) {
			resp.setStatus(204);// Success nhma k tra ve data
		} else {
			resp.setStatus(400);// Loi
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
