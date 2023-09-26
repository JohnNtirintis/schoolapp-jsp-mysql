package gr.aueb.cf.schoolapp.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Ntirintis John
 */
@WebFilter("/schoolapp/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        boolean authenticated = false;

        String requestURI = req.getRequestURI();

        if(requestURI.endsWith(".css")){
            chain.doFilter(req, res);
        } else {
            Cookie[] cookies = req.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("JSESSIONID")){
                        HttpSession session = req.getSession(false);
                        authenticated = (session != null) && (session.getAttribute("loginName") != null);
                    }
                }
            }
        }

        if(authenticated){
            chain.doFilter(req, res);
        } else{
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
