package de.rubeen.javaee.buch.onlineshop;

import de.rubeen.javaee.buch.onlineshop.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ruben Vitt - 10.10.17.
 */
@WebServlet(urlPatterns = {"/register"}, name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final PrintWriter out = response.getWriter();

        final Customer customer = new Customer(email, password);

        /*request.getSession().setAttribute("customer", customer);*/
        response.addCookie(new Cookie("email", email));
        response.addCookie(new Cookie("password", password));

        request.getRequestDispatcher("index.jsp").forward(request, response);
        log("Mail: " + email + " PW: " + password);

        log(getServletContext().getInitParameter("driver"));
    }
}
