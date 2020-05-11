package de.rubeen.javaee.buch.onlineshop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter (
        filterName = "IsSecureLoggerFilter",
        urlPatterns ={ "/*" },
        dispatcherTypes = {
                DispatcherType.REQUEST,
                DispatcherType.ASYNC,
                DispatcherType.INCLUDE,
                DispatcherType.ERROR,
                DispatcherType.FORWARD
        },
        asyncSupported = true
)
public class IsSecureLoggerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.log("LoggingFilter...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
