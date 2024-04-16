package Controller.Admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Constant.SessionAtt;
import Entity.User;

/**
 * Servlet Filter implementation class Filter_Admin
 */
@WebFilter({"/views/admin","/admin/statistical","/admin/video","/admin/user","/views/video"})
public class Filter_Admin extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public Filter_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// Kiểm tra User có null không
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
        User user = (User) session.getAttribute(SessionAtt.CURRENT_USER);
        if (user == null) {
            // User null, chuyển hướng hoặc xử lý tùy ý
        	res.sendRedirect("/asm2/views/Account?action=dang-nhap");
        } else {
        	if(!user.getRole()) {
        		res.sendRedirect("/asm2/views/index");
        	}
            // User không null, tiếp tục xử lý chuỗi Filter
            chain.doFilter(request, response);
        }
    }
		
		
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
