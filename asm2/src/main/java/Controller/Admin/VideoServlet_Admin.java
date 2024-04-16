package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.User;
import Entity.Video;
import Service.VideoServiceImpl;
import Utils.ExcelUtil;

/**
 * Servlet implementation class Video
 */
@WebServlet({ "/views/admin/video", "/admin/video", "/video" })
public class VideoServlet_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoServiceImpl dao = new VideoServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoServlet_Admin() {
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
		
		
		
		
		
		
		
		
	        
	       // session.removeAttribute("mes");
	       // session.removeAttribute("mes1");
	        
	    
		String videoid = request.getParameter("videoid");
		String btn = request.getParameter("btn");
		
		Entity.User currentUser = (Entity.User) session.getAttribute(Constant.SessionAtt.CURRENT_USER);
		if (currentUser == null) {
			response.sendRedirect("/asm2/views/Account?action=dang-nhap");
			return;
		}

		if (currentUser != null && !currentUser.getRole()) {

			response.sendRedirect("/asm2/views/index");
			return;
		}
//			if(tab.equals("1")) {
//				
//			}
//			if(tab.equals("2")) {
//				
//			}
		Entity.Video video = null;
		if (videoid != null) {
		    video = dao.findByID(Integer.parseInt(videoid));
			if (video != null) {
				request.setAttribute("video", video);
			}
		}

		List<Entity.Video> list_video = dao.findAll2();
		
		String action = request.getParameter("action");
		if(action != null) {
			
			
			ExcelUtil.chooseDirectoryToSave(ExcelUtil.printVideo(list_video),"_ListVideo");
			response.sendRedirect("/asm2/views/admin/video");
			return;
		}
		
		String input_search = request.getParameter("input_search");
		String by = request.getParameter("by");
		if(input_search != null && by != null) {
			if(by.trim().equals("id")) {
				list_video = dao.findVideoByIDorTitle(input_search, 0);
			}else {
				list_video = dao.findVideoByIDorTitle(input_search, 1);
			}
			
		}
		
		if (list_video != null) {
			request.setAttribute("list_video", list_video);
		}

		if (btn != null) {
			if (btn.equals("Create")) {
				
				String Poster = request.getParameter("Poster");
				String URL = request.getParameter("URL");
				String Title = request.getParameter("Title");
				String Check = request.getParameter("check");
				String Description = request.getParameter("Description");
				Entity.Video video_insert = new Video();
				//video_insert = null;
				boolean online = Check == null ? false : true;
				
				video_insert.setOnline(online);
				video_insert.setPoster(Poster);
				video_insert.setTitle(Title);
				video_insert.setUrl(URL);
				video_insert.setDescription(Description);
				//video.setUserId(currentUser.getUserId());
				if(video_insert != null) {
					try {
						dao.create(video_insert, currentUser);
						request.getSession().setAttribute("mes", "Thêm thành công Video");
					} catch (Exception e) {
						// TODO: handle exception
						request.getSession().setAttribute("mes1", "Thêm không thành công Video");
					}

					//request.setAttribute("mes", "Thêm thành công Video");
					response.sendRedirect("/asm2/views/admin/video");
					return;
				}

				
				//response.sendRedirect("/asm2/views/admin/video");
				//return;
			}
			if (btn.equals("Reset")) {
				video = null;
				response.sendRedirect("/asm2/views/admin/video");
				return;
			}
			
			if (btn.equals("Update")) {
				String Poster = request.getParameter("Poster");
				String URL = request.getParameter("URL");
				String Title = request.getParameter("Title");
				String Check = request.getParameter("check");
				String Description = request.getParameter("Description");
				String Id = request.getParameter("VideoId");
				Entity.Video video_insert = new Video();
				//video_insert = null;
				boolean online = Check.contains("1") ? true : false;
				
				video_insert.setOnline(online);
				video_insert.setPoster(Poster);
				video_insert.setTitle(Title);
				video_insert.setUrl(URL);
				video_insert.setDescription(Description);
				video_insert.setVideoId(Integer.parseInt(Id));
				if(video_insert != null) {
					try {
						dao.update(video_insert, currentUser);
						request.getSession().setAttribute("mes", "Chỉnh sửa Video thành công");
					} catch (Exception e) {
						// TODO: handle exception
						request.getSession().setAttribute("mes1", "Chỉnh sửa Video không thành công");
					}
					
					//request.setAttribute("mes", "Thêm thành công Video");
					response.sendRedirect("/asm2/views/admin/video");
					return;
				}
				
			}
		}

		String includeFile = null;
		includeFile = "/views/admin/video_admin.jsp";


			request.setAttribute("includeFile", includeFile);
			request.getRequestDispatcher("/views/admin/home_admin.jsp").forward(request, response);
		
		

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
