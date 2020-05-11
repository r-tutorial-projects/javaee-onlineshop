package de.rubeen.javaee.buch.onlineshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String code = servletRequest.getParameter("code");
        if ("pw".equals(code))
            filterChain.doFilter(servletRequest, servletResponse);
        else {
            final String remoteAddress = servletRequest.getRemoteAddr();
            final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            final String requestURI = httpServletRequest.getRequestURI();
            final ServletContext context = servletRequest.getServletContext();

            context.log("Warning: improper access by IP: " + remoteAddress + " on " + requestURI);
            final RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("index.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
