package de.rubeen.javaee.buch.onlineshop;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by Ruben Vitt - 10.10.17.
 */
@WebServlet(urlPatterns = {"/sell"}, name = "SellServlet", asyncSupported = true)
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 30)
public class SellServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String title = request.getParameter("title"),
                description = request.getParameter("description"),
                price = request.getParameter("price");
        final Part part = request.getPart("foto");
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            String path = "/tmp/" + part.getSubmittedFileName();
            File file = new File(path);
            outputStream = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int i = 0;
            inputStream = part.getInputStream();
            while ((i = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, 1);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        } finally {
            outputStream.close();
            inputStream.close();
        }
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        printWriter.println(String.format("<!DOCTYPE html><html><body><br>Hochgeladener Artikel: %s<br>Beschreibung: %s<br>" +
                "Preis: %s<br>Bild: %s</body></html>", title, description, price, part.getSubmittedFileName()));
        final AsyncContext asyncContext = request.startAsync();
        asyncContext.start(new FotoService(inputStream, outputStream));
        asyncContext.complete();
    }
}
