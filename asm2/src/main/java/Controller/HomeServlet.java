package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Video;
import Service.VideoServiceImpl;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({"/views/index"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoServiceImpl videoS = new VideoServiceImpl();
    private static final int VIDEOS_PER_PAGE = 8;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//phân trang (servlet doGet)
		  List<Video> allVideos = videoS.findAll();
		  String search = request.getParameter("input_search");
		  if(search != null) {
			  allVideos = videoS.findVideoByTitle(search);
		  }
		  
	        int totalVideos = allVideos.size();
	        int totalPages = (int) Math.ceil((double) totalVideos / VIDEOS_PER_PAGE);

	        int currentPage = 1;
	        String pageParam = request.getParameter("page");
	        if (pageParam != null && !pageParam.isEmpty()) {
	            currentPage = Integer.parseInt(pageParam);
	            if (currentPage < 1) {
	                currentPage = 1;
	            } else if (currentPage > totalPages) {
	                currentPage = totalPages;
	            }
	        }

	        int startIndex = (currentPage - 1) * VIDEOS_PER_PAGE;
	        int endIndex = Math.min(startIndex + VIDEOS_PER_PAGE, totalVideos);
	        List<Video> videosOnPage = allVideos.subList(startIndex, endIndex);

	        request.setAttribute("videosOnPage", videosOnPage);
	        request.setAttribute("currentPage", currentPage);
	        request.setAttribute("totalPages", totalPages);
	        

		
//		videoS = new VideoServiceImpl();
		//List<Video> list = videoS.findAll();
		request.setAttribute("list_video", videosOnPage);
		
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
