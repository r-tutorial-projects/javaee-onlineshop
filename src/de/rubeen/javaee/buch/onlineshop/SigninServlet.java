package de.rubeen.javaee.buch.onlineshop;

import de.rubeen.javaee.buch.onlineshop.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ruben Vitt - 10.10.17.
 */
@WebServlet(urlPatterns = {"/signin"}, name = "SigninServlet")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String enteredMail = request.getParameter("email");
        final String enteredPassword = request.getParameter("password");
        //final Customer customer = (Customer)(request.getSession().getAttribute("customer"));
        Cookie[] cookies = request.getCookies();
        String email = "", password = "";
        for (Cookie c : cookies) {
            switch (c.getName()) {
                case "email":
                    email = c.getValue();
                    break;
                case "password":
                    password = c.getValue();
                    break;
            }
        }
        final Customer customer = new Customer(email, password);


        final PrintWriter printWriter = response.getWriter();

        String result;

        if (customer.getEmail().equals(enteredMail) && customer.getPassword().equals(enteredPassword)) {
            result = "Erfolgreich angemeldet. Deine UID ist: " + customer.getId();
        } else if (customer.getEmail() == enteredMail) {
            result = "Das Passwort ist falsch.";
        } else {
            result = "Es gibt keinen Benutzer mit dieser Emailadresse.";
        }

        response.setContentType("text/html;charset=UTF-8");
        printWriter.println("<!DOCTYPE html><html><body>" + result + "</body></html>");
    }
}
