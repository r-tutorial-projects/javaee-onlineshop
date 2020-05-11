package de.rubeen.javaee.buch.onlineshop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ruben Vitt - 10.10.17.
 */
@WebServlet(urlPatterns = {"/revision"}, name = "RevisionServlet")
public class RevisionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        String remoteAddress = request.getRemoteAddr();
        int remotePort = request.getRemotePort();
        log(remoteAddress + ":" + remotePort);

        out.println("<!DOCTYPE html><html><body>Ihre IP-Adresse: " + remoteAddress + ":" + remotePort + "</body></html>");
    }
}
