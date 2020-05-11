package de.rubeen.javaee.buch.onlineshop;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by Ruben Vitt - 10.10.17.
 */
public class JdbcServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String properties = getInitParameter("jdbc_properties");
        final ServletContext context = request.getServletContext();
        final InputStream in = context.getResourceAsStream(properties);
        final Properties p = new Properties();
        p.load(in);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<!DOCTYPE html><html><body>");
        printWriter.println(String.format("driver: %s\nuri: %s\nusername: %s\npassword: %s",
                p.getProperty("driver"), p.getProperty("url"), p.getProperty("username"), p.getProperty("password")));
    }
}
