package Controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.User;
import Entity.Video;
import Service.UserServiceImpl;
import Utils.ExcelUtil;

/**
 * Servlet implementation class UserServlet_Admin
 */
@WebServlet({"/views/admin/user","/user"})
public class UserServlet_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl dao = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				
			        HttpSession session = request.getSession();
//			        session.removeAttribute("mes");
//			        session.removeAttribute("mes1");
			        
			       
			    String userid = request.getParameter("userid");
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
//					if(tab.equals("1")) {
//						
//					}
//					if(tab.equals("2")) {
//						
//					}
				Entity.User user = null;
				if (userid != null) {
					user = dao.findByID(Integer.parseInt(userid));
					
					if (user != null) {
						request.setAttribute("user", user);
					}
				}

				List<Entity.User> list_user = dao.findAll2();
//				for (User user2 : list_user) {
//					System.out.println(user2.getEmail());
//				}
				String action = request.getParameter("action");
				if(action != null) {
					
					
					ExcelUtil.chooseDirectoryToSave(ExcelUtil.printUser(list_user),"_ListUser");
					response.sendRedirect("/asm2/views/admin/user");
					return;
				}
				
				String input_search = request.getParameter("input_search");
				String by = request.getParameter("by");
				if(input_search != null && by != null) {
					if(by.trim().equals("id")) {
						list_user = dao.findUserByIDorEmail(input_search, 0);
					}else {
						list_user = dao.findUserByIDorEmail(input_search, 1);
					}
					
				}
				
				if (list_user != null) {
					request.setAttribute("list_user", list_user);
				}
				
				

				if(btn != null) {
					if (btn.equals("Reset")) {
						//video = null;
						response.sendRedirect("/asm2/views/admin/user");
						return;
					}
					
					if (btn.equals("Update")) {
						String Username = request.getParameter("Username");
						String Password = request.getParameter("Password");
						String Email = request.getParameter("Email");
						String Check = request.getParameter("check");
						String UserId = request.getParameter("UserId");
						
						Entity.User user_insert = new User();
						//video_insert = null;
						boolean online = Check == null ? false : true;
						
						
						user_insert.setOnline(online);
						user_insert.setEmail(Email);
						user_insert.setUsername(Username);
						user_insert.setPassword(Password);
						user_insert.setRole(false);
						
						user_insert.setUserId(Integer.parseInt(UserId));
						
						if(user_insert != null) {
							try {
								dao.update(user_insert);
								request.getSession().setAttribute("mes", "Chỉnh sửa User thành công");
							} catch (Exception e) {
								// TODO: handle exception
								request.getSession().setAttribute("mes1", "Chỉnh sửa User không thành công");
							}
							
							//request.setAttribute("mes", "Thêm thành công Video");
							response.sendRedirect("/asm2/views/admin/user");
							return;
						}
						
					}
				}
				
					
					String includeFile = null;
					includeFile = "/views/admin/user_admin.jsp";
					
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
