package Controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAtt;
import DaoImplement.UserDaoImpl;
import DaoImplement.VideoDaoImpl;
import Entity.User;
import Entity.Video;
import Service.UserServiceImpl;
import Service.VideoServiceImpl;
import Utils.Connect;
import Utils.Email;

/**
 * Servlet implementation class Account
 */
@WebServlet({ "/views/Account", "/views/Account/dang-nhap", "/views/Account/dang-ky", "/views/Account/xac-nhan",
		"/views/Account/doi-mat-khau", "/views/Account/quen-mat-khau","/views/logout" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManager en = Connect.getEntityManager();
	UserServiceImpl dao = new UserServiceImpl();
	User user = null;
	int luu_maxn = 0;
	private VideoServiceImpl videoS = null;
	int luu_ma_quen_mk = 0;
	String email = "";
	String hoten = "";
	String pass = "";
	String pass2 = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		// String url = request.get();
		// System.out.println(url);
		HttpSession session = request.getSession();
		String url_action = request.getParameter("action");
		String url2 = request.getServletPath();
		//System.out.println(url2);
		if(url2.contains("/views/logout")) {
			session.removeAttribute(SessionAtt.CURRENT_USER);
			response.sendRedirect("/asm2/views/index");
			return;
		}
		int action = 0;
		if (url_action != null) {
			switch (url_action.trim()) {
			case "dang-nhap": {
				action = 1;
				break;
			}
			case "dang-ky": {
				action = 2;
				break;
			}
			case "quen-mat-khau": {
				action = 3;
				break;
			}
			case "doi-mat-khau": {
				action = 4;
				break;
			}
			default:
				action = 0;
				break;
			}
		}

		// System.out.println("Action: "+action);

		if (action == 2) {
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
			return;
		}
		if (action == 1) {
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			return;
		}
		if (action == 3) {
			request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
			return;
		}
		if (action == 4) {
			request.getRequestDispatcher("/views/changepass.jsp").forward(request, response);
			return;
		}

		if (action == 0) {
			
		
			//System.out.println(url2);
			//////////////////////////////////////////////////////// Đăng nhâp
//			if (url2.contains("/asm2/views/Account/dang-nhap")) {
//				String email = request.getParameter("email_input");
//				String pass = request.getParameter("pass_input");
//
//				// String remember = request.getParameter("remember");
//
//				EntityManager en = Connect.getEntityManager();
//
//				User u = dao.findByID(1);
//				if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(pass)) {
//					request.setAttribute("mes2", "Đăng nhập thành công");
//					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
//
//				} else {
//					request.setAttribute("mes", "Đăng nhập thất bại");
//					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
//
//				}
//
//				return;
//			}
			// xu ly dang ky
//			String email = "";
//			String hoten = "";
//			String pass = "";
//			String pass2 = "";
//			//////////////////////////////////////////////////// đăng ký
//			if (url2.contains("/asm2/views/Account/dang-ky")) {
//				user = null;
//				// System.out.println("hello");
//
//				// System.out.println("Vao servlet dang ky");
//				// System.out.println(btn_xacnhan);
//
//				email = request.getParameter("email_input");
//				hoten = request.getParameter("ho_ten");
//				pass = request.getParameter("pass_input");
//				pass2 = request.getParameter("pass_input2");
//				String btn_dangky = request.getParameter("btn-dang-ky");
//				if (!pass.equals(pass2)) {
//					request.setAttribute("mes1", "Xác nhận mật khẩu không đúng");
//					request.getRequestDispatcher("/views/register.jsp").forward(request, response);
//					return;
//				}
//				// String remember = request.getParameter("remember");
//				for (User u : dao.findAll()) {
//					if (u.getEmail().equalsIgnoreCase(email)) {
//						request.setAttribute("mes", "Email đã được đăng ký");
//						request.getRequestDispatcher("/views/register.jsp").forward(request, response);
//						return;
//					}
//				}
//
//				if (btn_dangky != null) {
//					user = new User();
//					user.setEmail(email);
//					user.setPassword(pass);
//					user.setRole(false);
//					user.setOnline(true);
//					user.setUsername(hoten);
//					luu_maxn = Email.generateRandomNumber();
//					System.out.println("gui ma: " + luu_maxn);
//				}
//
//				request.setAttribute("email", email);
//				request.getRequestDispatcher("/views/verify.jsp").forward(request, response);
//
//				return;
//
//			}
//			/////////////////////////////// xác nhận Email
//			if (url2.contains("/asm2/views/Account/xac-nhan")) {
//
//				// System.out.println("an nut xac nhan");
//				int maxn = Integer.parseInt(request.getParameter("ma-xac-nhan"));
//
//				if (maxn == luu_maxn) {
//					// System.out.println("step 2");
//					if (dao.findByEmail(user.getEmail()) != null) {
//						request.setAttribute("mes2", "Tài khoản đã được đăng ký");
//						request.getRequestDispatcher("/views/verify.jsp").forward(request, response);
//						return;
//					}
//					dao.create(user);
//					request.setAttribute("mes2", "Đăng ký thành công");
//					request.getRequestDispatcher("/views/verify.jsp").forward(request, response);
//				} else {
//					request.setAttribute("mes", "Mã xác nhận không đúng");
//					request.getRequestDispatcher("/views/verify.jsp").forward(request, response);
//				}
//
//			}

			//////////////////////////////////////////////////////// xu ly quen mk
//			if (url2.contains("/asm2/views/Account/quen-mat-khau")) {
//
//				String email_quen_mk = request.getParameter("email_input");
//				String ma_xn = request.getParameter("ma_xn");
//				String btn_xacnhan = request.getParameter("btn_xacnhan");
//				String btn_guima = request.getParameter("btn_guima");
//				if (btn_guima != null) {
//					// gui ma
//					luu_ma_quen_mk = Email.generateRandomNumber();
//					System.out.println("Ma quen mk: " + luu_ma_quen_mk);
//					request.setAttribute("mes2", "Mã xác nhận đã được gửi");
//					request.setAttribute("email", email_quen_mk);
//					request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
//				}
//
//				if (btn_xacnhan != null) {
//					// kiem tra ma
//					if (!ma_xn.equals(String.valueOf(luu_ma_quen_mk))) {
//						request.setAttribute("mes", "Xác nhận mật khẩu không đúng");
//						request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
//						return;
//					} else {
//
//						int mk = Email.generateRandomNumber();
//						User user = dao.findByEmail(email_quen_mk);
//						user.setPassword(String.valueOf(mk));
//						request.setAttribute("mes2", "Thành công. Vui lòng kiểm tra Email");
//						request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
//						return;
//					}
//				}
//
//			}



		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url2 = request.getServletPath();
		//System.out.println(url2);
		HttpSession session = request.getSession();
////////////////////////////////////////////////////////Đăng nhâp
		int action = 0;
		switch (url2) {
		case "/views/Account/dang-nhap": {
			action = 1;
			break;
		}
		case "/views/Account/dang-ky": {
			action = 2;
			break;
		}
		case "/views/Account/quen-mat-khau": {
			action = 3;
			break;
		}
		case "/views/Account/doi-mat-khau": {
			action = 4;
			break;
		}
		default:
			action = 0;
		}
		
		
		if(action == 3) {
			// xy ly quen mk

				String email_quen_mk = request.getParameter("email_input");
				String ma_xn = request.getParameter("ma_xn");
				String btn_xacnhan = request.getParameter("btn_xacnhan");
				String btn_guima = request.getParameter("btn_guima");
				
				if (btn_guima != null) {
					// gui ma
					User u = dao.findByEmail(email_quen_mk.trim());
					if(u == null) {
						request.setAttribute("mes", "Email chưa được đăng ký");
						request.setAttribute("email", email_quen_mk);
						request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
						return;
					}
					luu_ma_quen_mk = Email.generateRandomNumber();
					System.out.println("Ma quen mk: " + luu_ma_quen_mk);
					// mở ra nếu muốn gửi qua email
					//luu_ma_quen_mk = Email.sendMail(email_quen_mk)
					request.setAttribute("mes2", "Mã xác nhận đã được gửi");
					request.setAttribute("email", email_quen_mk);
					request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
				}

				if (btn_xacnhan != null) {
					// kiem tra ma
					if (!ma_xn.equals(String.valueOf(luu_ma_quen_mk))) {
						request.setAttribute("mes", "Xác nhận mật khẩu không đúng");
						request.setAttribute("email", email_quen_mk);
						request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
						return;
					} else {

						int mk = Email.generateRandomNumber();
						User user = dao.findByEmail(email_quen_mk);
						user.setPassword(String.valueOf(mk));
						System.out.println("mk moi: "+mk);
						dao.update(user);
						request.setAttribute("mes2", "Thành công. Vui lòng kiểm tra Email");
						request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
						return;
					}
				}

			}
			
		
		if(action == 1) { /// xu ly dang nhap
			String email = request.getParameter("email_input");
			String pass = request.getParameter("pass_input");
			
			User u = dao.findByEmail(email);
			
			
			
			if(u == null) {
				// sai tk mk
				
				//request.setAttribute("mes", "Đăng nhập thất bại");
				//response.sendRedirect("?action=dang-nhap");
				//response.sendRedirect("?action=dang-nhap&mes=Dang nhap that bai");
				request.setAttribute("mes", "Đăng nhập thất bại");
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
				
				
				return;
			}else {
				if(u.getPassword().trim().equals(pass.trim())) {
					if(u.getOnline() != true) {
						request.setAttribute("mes", "Tài khoản bị khóa T-T");
						request.getRequestDispatcher("/views/login.jsp").forward(request, response);
						return;
					}
					session.setAttribute(SessionAtt.CURRENT_USER, u);
					
					
					//get_all_video(request);
					response.sendRedirect("/asm2/views/index");
					
				
					return;
				}else {
					request.setAttribute("mes", "Đăng nhập thất bại");
					request.getRequestDispatcher("/views/login.jsp").forward(request, response);
					return;
				}
				
			}
		}
			
			if(action == 4) {
				/////////////////////////////////////// xu ly doi mat khau
				
					String email_input = request.getParameter("email_input");
					String pass_input_cu = request.getParameter("pass_input_cu");
					String pass_input1 = request.getParameter("pass_input1");
					String pass_input2 = request.getParameter("pass_input2");
					String btn_dang_ky = request.getParameter("btn-dang-ky");
					// System.out.println("an nut xac nhan");
					if (btn_dang_ky != null) {
						if (!pass_input1.equals(pass_input2)) {
							request.setAttribute("mes", "Xác nhận mật khẩu không đúng");
							request.getRequestDispatcher("/views/changepass.jsp").forward(request, response);
							return;
						}

						User user = dao.findByEmail(email_input.trim());
						if (!user.getPassword().trim().equals(pass_input_cu.trim())) {
							request.setAttribute("mes1", "Đổi mật khẩu không thành công");
							request.getRequestDispatcher("/views/changepass.jsp").forward(request, response);
							return;
						}

						user.setPassword(pass_input1);
						dao.update(user);
						request.setAttribute("mes2", "Đổi mật khẩu thành công");
						request.getRequestDispatcher("/views/changepass.jsp").forward(request, response);
						return;

					}

				}
			
		
		
			if(action == 2) {
				// xu ly dang ky
				
				//////////////////////////////////////////////////// đăng ký
				
					user = null;
					// System.out.println("hello");

					// System.out.println("Vao servlet dang ky");
					// System.out.println(btn_xacnhan);

					email = request.getParameter("email_input");
					hoten = request.getParameter("ho_ten");
					pass = request.getParameter("pass_input");
					pass2 = request.getParameter("pass_input2");
					String btn_dangky = request.getParameter("btn-dang-ky");
					if (!pass.equals(pass2)) {
						request.setAttribute("mes1", "Xác nhận mật khẩu không đúng");
						request.getRequestDispatcher("/views/register.jsp").forward(request, response);
						return;
					}
					// String remember = request.getParameter("remember");
					User uu = dao.findByEmail(email);
					if(uu != null) {
						request.setAttribute("mes", "Email đã được đăng ký");
						request.getRequestDispatcher("/views/register.jsp").forward(request, response);
						return;
					}
					

					if (btn_dangky != null) {
						user = new User();
						user.setEmail(email);
						user.setPassword(pass);
						user.setRole(false);
						user.setOnline(true);
						user.setUsername(hoten);
						luu_maxn = Email.generateRandomNumber();
						System.out.println("gui ma: " + luu_maxn);
						// Mở ra nếu muốn gửi mã qua email
						// luu_maxn = Email.sendMail(email);
					}

					request.setAttribute("email", email);
					request.getRequestDispatcher("/views/verify.jsp").forward(request, response);

					return;

				}
				/////////////////////////////// xác nhận Email
				if (url2.contains("/views/Account/xac-nhan")) {

					// System.out.println("an nut xac nhan");
					int maxn = Integer.parseInt(request.getParameter("ma-xac-nhan"));

					if (maxn == luu_maxn) {
						// System.out.println("step 2");
						if (dao.findByEmail(user.getEmail()) != null) {
							request.setAttribute("mes2", "Tài khoản đã được đăng ký");
							request.getRequestDispatcher("/views/verify.jsp").forward(request, response);
							return;
						}
						dao.create(user);
						request.setAttribute("mes2", "Đăng ký thành công");
						request.getRequestDispatcher("/views/verify.jsp").forward(request, response);
					} else {
						request.setAttribute("email", email);
						request.setAttribute("mes", "Mã xác nhận không đúng");
						request.getRequestDispatcher("/views/verify.jsp").forward(request, response);
					}

				}

			}


		
		// doGet(request, response);
	void get_all_video(HttpServletRequest request) {
		videoS = new VideoServiceImpl();
		List<Video> list = videoS.findAll();
		request.setAttribute("list_video", list);
	}

}
