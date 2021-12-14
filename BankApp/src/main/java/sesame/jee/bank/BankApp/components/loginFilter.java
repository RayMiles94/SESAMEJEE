package sesame.jee.bank.BankApp.components;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class loginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String url = req.getRequestURI();

        
        if (url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith(".ico") || url.endsWith(".css") || url.endsWith(".js") ) {
            chain.doFilter(request, response); return;
        } 
        
        if (url.equals("/web/login")) {
        	chain.doFilter(request, response); return;
        }
    
        
        if (!url.equals("/login")) {
        	if(req.getSession().getAttribute("login")==null) {
            	res.sendRedirect("/login"); return;
            }
		}
        chain.doFilter(req, res);
	}

}
