package de.rubeen.javaee.buch.onlineshop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*@WebFilter(
        servletNames = {"SellServlet", "RegisterServlet"},
        filterName = "LoggingFilter",
        description = "Logging at specific accesses"
)*/
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = servletRequest.getServletContext();
        context.log(servletRequest.getRemoteAddr() + " did something.");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
